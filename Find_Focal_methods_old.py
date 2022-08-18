import re
import os
import sys
from sklearn.model_selection import train_test_split
import copy

test_path= "Evo_tests/"
method_names_path = "method_names/"
source_file_path = "methods/"
context_path = "context/"

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
                    and os.path.exists(method_names_path + "/".join(root.split('/')[1:])+"/"+file)\
                    and os.path.exists(context_path + "/".join(root.split('/')[1:])+"/"+file):


                    f = open(root+"/"+file)
                    methods_body = f.read()
                    f.close()
                    # print(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
                    f = open(test_path + "/".join(root.split('/')[1:])+'/'+file.split('.')[0]+"_ESTest.java")
                    tests = f.read()
                    f.close()
                    # print(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
                    f = open(context_path + "/".join(root.split('/')[1:])+"/"+file)
                    m_names = f.read()
                    f.close()

                    f = open(method_names_path + "/".join(root.split('/')[1:])+"/"+file)
                    context = f.read()
                    f.close()
                    context = context.split('\n')

                    methods_body = methods_body.split('\n')
                    tests = tests.split('@Test')[1:]
                    method_name_list = []
                    method_name_list = [i.replace('(','') for i in re.findall('\w+\(',m_names)]
                    # print(method_name_list)


                    methods_dict = dict(zip(method_name_list, methods_body))

                    # print(len(methods))
                    
                    method_test = {}
                    for test in tests:
                        # print(test)
                        for key,value in methods_dict.items():
                            if test.find(key)!=-1:
                                context_copy = copy.deepcopy(context)
                                for i,m in enumerate(context_copy):  #find the method name in the context and replace it with method body at the begining of the list
                                    if key+'(' in m:
                                        context_copy.pop(i)
                                        context_copy.insert(1,value)

                                test_s = test.split(';')
                                new_test = []
                                if(test.count('assert')==1):
                                    for i in test_s:
                                        new_test.append(i)
                                elif(test.count('assert')>1):
                                    # print("########################")
                                    for i in test_s:
                                        if i.find('assert') != -1 and i.find(key) == -1:
                                            pass
                                        else:
                                            new_test.append(i)
                                new_test = ';'.join(new_test)
                                # print(new_test)
                                
                                if(len(new_test)>0):
                                    test_name = re.findall('test\d+',new_test)[0]
                                    if(new_test.find('assert')!=-1):
                                        method_test['@Test' + new_test.replace(test_name,"test"+key)] = "\n".join(context_copy)
                                    

                        
                    # for key , value in method_test.items():
                    #     print(key,value)
                    #     print('\n\n\n')
                        

                    with open("Evosuit.tests", "a") as f1, open("Evosuit.Methods", "a") as f2:
                        f1.write(root+"/"+file+'\n')
                        f2.write(root+"/"+file+'\n')
                        for key , value in method_test.items():
                            X.append(value.replace('\n',' [EOL] ') +'\n')
                            Y.append(key.replace('\n',' [EOL] ') + '\n')
                            f1.write(key.replace('\n',' [EOL] ') + '\n')
                            f2.write(value.replace('\n',' [EOL] ') +'\n')
                
            except:
                print("new_test")
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
            

            




            



        


