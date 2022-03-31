import javalang
tree = javalang.parse.parse("package lang3; class AnnotationUtils {}")
for path, node in tree:
    print (path, node)
    print('\n')
tokens = list(javalang.tokenizer.tokenize('System.out.println("Hello " + "world");'))
print(tokens)
