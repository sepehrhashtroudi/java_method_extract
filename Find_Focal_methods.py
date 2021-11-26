
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
m_names = m_names.split('\n')
tests = tests.split('@Test')
# print(sources)

# print('@Test'.join(tests))
method_name_list = []
for m_name in m_names:
    m_name = m_name.split(" ")
    for i in m_name:
        if "(" in i:
            method_name_list.append(i.split("(")[0])


methods = dict(zip(method_name_list, methods))

print(len(methods))
method_test = {}
for test in tests:
    for key,value in methods.items():
        if test.find(key)!=-1:
            method_test["@Test" + test.replace('\n','\t')] = value.strip('\n')
    
for key , value in method_test.items():
    print(key,value)
    print('\n\n\n')
    


    


