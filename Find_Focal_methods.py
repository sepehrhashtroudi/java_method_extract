
import re


test_file = "csv_tests/CSVFormat_ESTest.java"
method_names = "method_names/CSVFormat.java"
source_file = "methods/CSVFormat.java"
f = open(test_file)
tests = f.read()
f.close()

f = open(method_names)
m_names = f.read()
f.close()

f = open(source_file)
methods = f.read()
f.close()




methods = methods.split('\n')
tests = tests.split('@Test')
method_name_list = []
method_name_list = [i.replace('(','') for i in re.findall('\w+\(',m_names)]
# print(method_name_list)


methods = dict(zip(method_name_list, methods))

print(len(methods))
method_test = {}
for test in tests:
    for key,value in methods.items():
        if test.find(key)!=-1:
            test_s = test.split(';')
            new_test = []
            for i in test_s:
                if i.find('assert') == -1 or i.find(key) != -1:
                    new_test.append(i)
            new_test = ';'.join(new_test)
            test_name = re.findall('test\d+',new_test)[0]
            method_test['@Test' + new_test.replace(test_name,"test"+key)] = value
            

    
# for key , value in method_test.items():
#     print(key,value)
#     print('\n\n\n')
    

with open("extracted_tests.txt", "w") as f1, open("extracted_methods.txt", "w") as f2:
    for key , value in method_test.items():
        f1.write(key.replace('\n','\t') + '\n')
        f2.write(value+'\n')


    


