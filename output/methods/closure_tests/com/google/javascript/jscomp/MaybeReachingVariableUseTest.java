public void testStraightLine() { [EOL]     assertMatch("D:var x=1; U: x"); [EOL]     assertMatch("var x; D:x=1; U: x"); [EOL]     assertNotMatch("D:var x=1; x = 2; U: x"); [EOL]     assertMatch("var x=1; D:x=2; U: x"); [EOL]     assertNotMatch("U:x; D:var x = 1"); [EOL]     assertMatch("D: var x = 1; var y = 2; y; U:x"); [EOL] } <line_num>: 44,51
public void testIf() { [EOL]     assertMatch("var x; if(a){ D:x=1 }else { x=2 }; U:x"); [EOL]     assertMatch("var x; if(a){ x=1 }else { D:x=2 }; U:x"); [EOL]     assertMatch("D:var x=1; if(a){ U1: x }else { U2: x };"); [EOL] } <line_num>: 53,57
public void testLoops() { [EOL]     assertMatch("var x=0; while(a){ D:x=1 }; U:x"); [EOL]     assertMatch("var x=0; for(;;) { D:x=1 }; U:x"); [EOL]     assertMatch("D:var x=1; while(a) { U:x }"); [EOL]     assertMatch("D:var x=1; for(;;)  { U:x }"); [EOL] } <line_num>: 59,65
public void testConditional() { [EOL]     assertMatch("var x=0; var y; D:(x=1)&&y; U:x"); [EOL]     assertMatch("var x=0; var y; D:y&&(x=1); U:x"); [EOL]     assertMatch("var x=0; var y=0; D:(x=1)&&(y=0); U:x"); [EOL]     assertMatch("var x=0; var y=0; D:(y=0)&&(x=1); U:x"); [EOL]     assertNotMatch("D: var x=0; var y=0; (x=1)&&(y=0); U:x"); [EOL]     assertMatch("D: var x=0; var y=0; (y=1)&&((y=2)||(x=1)); U:x"); [EOL]     assertMatch("D: var x=0; var y=0; (y=0)&&(x=1); U:x"); [EOL] } <line_num>: 67,75
public void testUseAndDefInSameInstruction() { [EOL]     assertNotMatch("D:var x=0; U:x=1,x"); [EOL]     assertMatch("D:var x=0; U:x,x=1"); [EOL] } <line_num>: 77,80
public void testAssignmentInExpressions() { [EOL]     assertMatch("var x=0; D:foo(bar(x=1)); U:x"); [EOL]     assertMatch("var x=0; D:foo(bar + (x = 1)); U:x"); [EOL] } <line_num>: 82,85
public void testHook() { [EOL]     assertMatch("var x=0; D:foo() ? x=1 : bar(); U:x"); [EOL]     assertMatch("var x=0; D:foo() ? x=1 : x=2; U:x"); [EOL] } <line_num>: 87,90
public void testAssignmentOps() { [EOL]     assertNotMatch("D: var x = 0; U: x = 100"); [EOL]     assertMatch("D: var x = 0; U: x += 100"); [EOL]     assertMatch("D: var x = 0; U: x -= 100"); [EOL] } <line_num>: 92,96
public void testInc() { [EOL]     assertMatch("D: var x = 0; U:x++"); [EOL]     assertMatch("var x = 0; D:x++; U:x"); [EOL] } <line_num>: 98,101
public void testForIn() { [EOL]     assertNotMatch("D: var x = [], foo; U: for (x in foo) { }"); [EOL]     assertNotMatch("D: var x = [], foo; for (x in foo) { U:x }"); [EOL]     assertMatch("var x = [], foo; D: for (x in foo) { U:x }"); [EOL] } <line_num>: 103,109
public void testTryCatch() { [EOL]     assertMatch("D: var x = 1; " + "try { U: var y = foo() + x; } catch (e) {} " + "U: var z = x;"); [EOL] } <line_num>: 111,116
private void assertMatch(String src) { [EOL]     computeUseDef(src); [EOL]     Collection<Node> result = useDef.getUses("x", def); [EOL]     assertTrue(result.size() == uses.size()); [EOL]     assertTrue(result.containsAll(uses)); [EOL] } <line_num>: 121,126
private void assertNotMatch(String src) { [EOL]     computeUseDef(src); [EOL]     assertFalse(useDef.getUses("x", def).contains(uses)); [EOL] } <line_num>: 131,134
private void computeUseDef(String src) { [EOL]     Compiler compiler = new Compiler(); [EOL]     src = "function _FUNCTION(param1, param2){" + src + "}"; [EOL]     Node n = compiler.parseTestCode(src).getFirstChild(); [EOL]     assertEquals(0, compiler.getErrorCount()); [EOL]     Scope scope = new SyntacticScopeCreator(compiler).createScope(n, null); [EOL]     ControlFlowAnalysis cfa = new ControlFlowAnalysis(compiler, false, true); [EOL]     cfa.process(null, n); [EOL]     ControlFlowGraph<Node> cfg = cfa.getCfg(); [EOL]     useDef = new MaybeReachingVariableUse(cfg, scope, compiler); [EOL]     useDef.analyze(); [EOL]     def = null; [EOL]     uses = Lists.newArrayList(); [EOL]     new NodeTraversal(compiler, new LabelFinder()).traverse(n); [EOL]     assertNotNull("Code should have an instruction labeled D", def); [EOL]     assertFalse("Code should have an instruction labeled starting withing U", uses.isEmpty()); [EOL] } <line_num>: 139,156
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isLabel()) { [EOL]         if (n.getFirstChild().getString().equals("D")) { [EOL]             def = n.getLastChild(); [EOL]         } else if (n.getFirstChild().getString().startsWith("U")) { [EOL]             uses.add(n.getLastChild()); [EOL]         } [EOL]     } [EOL] } <line_num>: 162,171