 Property(String name)
 RenamePrototypes(AbstractCompiler compiler, boolean aggressiveRenaming, @Nullable char[] reservedCharacters, @Nullable VariableMap prevUsedRenameMap)
 int count()
 boolean canRename()
private boolean canRenamePrototypeProperty()
private boolean canRenameObjLitProperty()
public int compare(Property a1, Property a2)
public void process(Node externs, Node root)
private void reusePrototypeNames(Set<Property> properties)
public void visit(NodeTraversal t, Node n, Node parent)
public void visit(NodeTraversal t, Node n, Node parent)
private void processPrototypeParent(Node n, CompilerInput input)
private void markPrototypePropertyCandidate(Node n, CompilerInput input)
private void markObjLitPropertyCandidate(Node n, CompilerInput input)
private void markPropertyAccessCandidate(Node n, CompilerInput input)
private Property getProperty(String name)
 VariableMap getPropertyMap()
