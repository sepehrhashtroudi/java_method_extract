 OptimizeReturns(AbstractCompiler compiler)
public void process(Node externs, Node root)
public void process(Node externs, Node root, SimpleDefinitionFinder definitions)
private boolean callResultsMaybeUsed(SimpleDefinitionFinder defFinder, DefinitionSite definitionSite)
public void visit(Node node)
private void rewriteReturns(final SimpleDefinitionFinder defFinder, Node fnNode)
private static boolean isCall(UseSite site)
AbstractCompiler compiler