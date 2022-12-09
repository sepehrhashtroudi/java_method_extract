 RenameLabels(AbstractCompiler compiler)
 RenameLabels(AbstractCompiler compiler, Supplier<String> supplier, boolean removeUnused)
 ProcessLabels()
 LabelInfo(int id)
public String get()
public void enterScope(NodeTraversal nodeTraversal)
public void exitScope(NodeTraversal nodeTraversal)
public boolean shouldTraverse(NodeTraversal nodeTraversal, Node node, Node parent)
public void visit(NodeTraversal nodeTraversal, Node node, Node parent)
private void visitBreakOrContinue(Node node)
private void visitLabel(Node node, Node parent)
 String getNameForId(int id)
 LabelInfo getLabelInfo(String name)
public void process(Node externs, Node root)
AbstractCompiler compiler
Supplier<String> nameSupplier
boolean removeUnused
