 CheckMissingReturn(AbstractCompiler compiler, CheckLevel level)
public boolean apply(Node input)
public boolean apply(DiGraphEdge<Node, ControlFlowGraph.Branch> input)
public void enterScope(NodeTraversal t)
private static boolean fastAllPathsReturnCheck(ControlFlowGraph<Node> cfg)
public void exitScope(NodeTraversal t)
public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public void visit(NodeTraversal t, Node n, Node parent)
private JSType explicitReturnExpected(Node scope)
private static boolean isEmptyFunction(Node function)
private boolean isVoidOrUnknown(JSType returnType)
