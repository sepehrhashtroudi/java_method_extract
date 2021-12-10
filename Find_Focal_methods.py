import re
import os
import sys
from sklearn.model_selection import train_test_split

test_path= "Evo_tests/"
method_names_path = "method_names/"
source_file_path = "methods/"

if os.path.exists("Evosuit.Methods"):
  os.remove("Evosuit.Methods")
if os.path.exists("Evosuit.tests"):
  os.remove("Evosuit.tests")
X = []
Y = []
if __name__ == "__main__":
    for (root,dirs,files) in os.walk(source_file_path, topdown=True):
        # print (root)
        # print (files)
        # print ('--------------------------------')
        for file in files:
            try:
                # print(root+'/'+file)
                if os.path.exists(root+"/"+file) \
                    and os.path.exists(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java") \
                    and os.path.exists(method_names_path + "/".join(root.split('/')[1:])+"/"+file):

                    f = open(root+"/"+file)
                    methods = f.read()
                    f.close()
                    # print(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
                    f = open(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
                    tests = f.read()
                    f.close()
                    # print(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
                    f = open(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
                    m_names = f.read()
                    f.close()

                    methods = methods.split('\n')
                    tests = tests.split('@Test')[1:]
                    method_name_list = []
                    method_name_list = [i.replace('(','') for i in re.findall('\w+\(',m_names)]
                    # print(method_name_list)


                    methods = dict(zip(method_name_list, methods))

                    # print(len(methods))
                    method_test = {}
                    for test in tests:
                        # print(test)
                        for key,value in methods.items():
                            if test.find(key)!=-1:
                                test_s = test.split(';')
                                new_test = []
                                for i in test_s:
                                    if i.find('assert') == -1 or i.find(key) != -1:
                                        new_test.append(i)
                                new_test = ';'.join(new_test)
                                # print(new_test)
                                
                                test_name = re.findall('test\d+',new_test)[0]
                                method_test['@Test' + new_test.replace(test_name,"test"+key)] = value
                                

                        
                    # for key , value in method_test.items():
                    #     print(key,value)
                    #     print('\n\n\n')
                        

                    with open("Evosuit.tests", "a") as f1, open("Evosuit.Methods", "a") as f2:
                        # f1.write(root+"/"+file+'\n')
                        # f2.write(root+"/"+file+'\n')
                        for key , value in method_test.items():
                            X.append(value +'\n')
                            Y.append(key.replace('\n','\t') + '\n')
                            f1.write(key.replace('\n','\t') + '\n')
                            f2.write(value +'\n')
                
            except:
                print(new_test)
                print(sys.exc_info())

            print(root+"/"+file)
    with open("Evosuit_train.tests", "w") as Evosuit_train_tests, open("Evosuit_train.methods", "w") as Evosuit_train_methods , open("Evosuit_test.tests", "w") as Evosuit_test_tests, open("Evosuit_test.methods", "w") as Evosuit_test_methods:
        X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.20, random_state=42)    
        for i in X_train:
            Evosuit_train_methods.write(i)
        for i in X_test:
            Evosuit_test_methods.write(i)
        for i in y_train:
            Evosuit_train_tests.write(i)
        for i in y_test:
            Evosuit_test_tests.write(i)
            

            




            



        


