public NormalizeAndDenormalizePass(AbstractCompiler compiler) { [EOL]     this.compiler = compiler; [EOL]     denormalizePass = new Denormalize(compiler); [EOL]     normalizePass = new NormalizeStatements(compiler, false); [EOL] } <line_num>: 115,119
@Override [EOL] public CompilerPass getProcessor(final Compiler compiler) { [EOL]     return new NormalizeAndDenormalizePass(compiler); [EOL] } <line_num>: 27,30
@Override [EOL] protected int getNumRepetitions() { [EOL]     return 1; [EOL] } <line_num>: 32,36
public void testFor() { [EOL]     test("a = 0; for(; a < 2 ; a++) foo()", "for(a = 0; a < 2 ; a++) foo();"); [EOL]     test("var a = 0; for(; c < b ; c++) foo()", "for(var a = 0; c < b ; c++) foo()"); [EOL]     testSame("var a = 0; a:for(; c < b ; c++) foo()"); [EOL]     testSame("var a = 0; a:b:for(; c < b ; c++) foo()"); [EOL]     test("if(x){var a = 0; for(; c < b; c++) foo()}", "if(x){for(var a = 0; c < b; c++) foo()}"); [EOL]     test("init(); for(; a < 2 ; a++) foo()", "for(init(); a < 2 ; a++) foo();"); [EOL]     test("function f(){ var a; for(; a < 2 ; a++) foo() }", "function f(){ for(var a; a < 2 ; a++) foo() }"); [EOL]     testSame("function f(){ return; for(; a < 2 ; a++) foo() }"); [EOL] } <line_num>: 38,62
public void testForIn() { [EOL]     test("var a; for(a in b) foo()", "for (var a in b) foo()"); [EOL]     testSame("a = 0; for(a in b) foo()"); [EOL]     testSame("var a = 0; for(a in b) foo()"); [EOL]     testSame("var a; a:for(a in b) foo()"); [EOL]     testSame("var a; a:b:for(a in b) foo()"); [EOL]     test("if(x){var a; for(a in b) foo()}", "if(x){for(var a in b) foo()}"); [EOL]     testSame("init(); for(a in b) foo()"); [EOL]     testSame("function f(){ return; for(a in b) foo() }"); [EOL] } <line_num>: 64,82
public void testInOperatorNotInsideFor() { [EOL]     testSame("function f(){ var a; var i=\"length\" in a;" + "for(; a < 2 ; a++) foo() }"); [EOL]     testSame("function f(){ var a; var i=(\"length\" in a);" + "for(; a < 2 ; a++) foo() }"); [EOL]     test("function f(){" + "var b,a=0; for (var i=(\"length\" in b);a<2; a++) foo()}", "function f(){var b; var a=0;var i=(\"length\" in b);" + "for (;a<2;a++) foo()}"); [EOL] } <line_num>: 84,102
@Override [EOL] public void process(Node externs, Node root) { [EOL]     NodeTraversal.traverse(compiler, root, normalizePass); [EOL]     NodeTraversal.traverse(compiler, root, denormalizePass); [EOL] } <line_num>: 121,125