from operator import ne
import re
import os
import sys
from sklearn.model_selection import train_test_split
import copy
root = './'
file = "test_0_tufano.output"

if __name__ == "__main__":
    f = open(root+"/"+file)
    tests_body = f.read()
    f.close()

    global i
    i = 0

    def replace(m):
        global i
        i += 1
        test_name=m.group(0).split('(') 
        new_test_name =(str(i)+'(').join(test_name)
        return new_test_name
        
    
    new_test_body = re.sub('test\w+\(\)', replace, tests_body)
    new_test_body = re.sub('        ', '\n', new_test_body)
    # print(new_test_body)
    with open("Final_tests_tufano.java", "w") as Final_tests:
        Final_tests.write(new_test_body)
        


    