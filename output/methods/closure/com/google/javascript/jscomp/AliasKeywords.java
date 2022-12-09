public AliasSpecification(String aliasName, int tokenId) { [EOL]     this.aliasName = aliasName; [EOL]     this.tokenId = tokenId; [EOL] } <line_num>: 97,100
ThrowAliasSpecification(String aliasName) { [EOL]     super(aliasName, Token.THROW); [EOL] } <line_num>: 166,168
KeywordAliasSpecification(String aliasName, int tokenId) { [EOL]     super(aliasName, tokenId); [EOL] } <line_num>: 227,229
VoidKeywordAliasSpecification(String aliasName, int tokenId) { [EOL]     super(aliasName, tokenId); [EOL] } <line_num>: 261,263
AliasKeywords(AbstractCompiler compiler) { [EOL]     this.compiler = compiler; [EOL]     aliasSpecifications = createAliasSpecifications(); [EOL]     aliasTypes = Maps.newLinkedHashMap(); [EOL]     aliasNames = Sets.newLinkedHashSet(); [EOL]     for (AliasSpecification specification : aliasSpecifications) { [EOL]         aliasTypes.put(specification.getTokenId(), specification); [EOL]         aliasNames.add(specification.getAliasName()); [EOL]     } [EOL] } <line_num>: 353,362
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     final int type = n.getType(); [EOL]     if (isAliasableType(type)) { [EOL]         visitAliasableNode(n, parent); [EOL]     } else if (type == Token.NAME) { [EOL]         visitNameNode(n); [EOL]     } [EOL] } <line_num>: 42,50
private void visitAliasableNode(Node n, Node parent) { [EOL]     AliasSpecification aliasableNodes = aliasTypes.get(n.getType()); [EOL]     aliasableNodes.visit(n, parent); [EOL] } <line_num>: 56,59
private void visitNameNode(Node n) { [EOL]     if (isAliasDefinition(n)) { [EOL]         throw new IllegalStateException("Existing alias definition for " + Token.name(n.getType())); [EOL]     } [EOL] } <line_num>: 65,70
public void visit(Node n, Node parent) { [EOL]     nodes.put(n, parent); [EOL] } <line_num>: 102,104
boolean maybeInsertAliasDeclarationIntoParseTree(Node codeRoot) { [EOL]     if (nodes.size() >= minOccurrencesRequiredToAlias()) { [EOL]         insertAliasDeclaration(codeRoot); [EOL]         isAliased = true; [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 113,120
public void doAlias(AbstractCompiler compiler) { [EOL]     if (isAliased) { [EOL]         for (Map.Entry<Node, Node> entry : nodes.entrySet()) { [EOL]             Node n = entry.getKey(); [EOL]             Node parent = entry.getValue(); [EOL]             aliasNode(n, parent); [EOL]             compiler.reportCodeChange(); [EOL]         } [EOL]     } [EOL] } <line_num>: 126,135
public int getTokenId() { [EOL]     return tokenId; [EOL] } <line_num>: 137,139
public String getAliasName() { [EOL]     return aliasName; [EOL] } <line_num>: 141,143
protected abstract int minOccurrencesRequiredToAlias(); <line_num>: 149,149
protected abstract void insertAliasDeclaration(Node codeRoot); <line_num>: 157,157
protected abstract void aliasNode(Node n, Node parent); <line_num>: 160,160
@Override [EOL] protected void aliasNode(Node throwNode, Node parent) { [EOL]     Node name = NodeUtil.newName(compiler.getCodingConvention(), getAliasName(), throwNode, getAliasName()); [EOL]     Node aliasCall = IR.call(name, throwNode.removeFirstChild()); [EOL]     aliasCall.putBooleanProp(Node.FREE_CALL, true); [EOL]     Node exprResult = IR.exprResult(aliasCall); [EOL]     parent.replaceChild(throwNode, exprResult); [EOL] } <line_num>: 170,179
@Override [EOL] protected void insertAliasDeclaration(Node codeRoot) { [EOL]     codeRoot.addChildToFront(createAliasFunctionNode(getAliasName())); [EOL] } <line_num>: 181,187
@Override [EOL] protected int minOccurrencesRequiredToAlias() { [EOL]     return MIN_OCCURRENCES_REQUIRED_TO_ALIAS_THROW; [EOL] } <line_num>: 189,192
static int estimateMinOccurrencesRequriedToAlias() { [EOL]     Node alias = createAliasFunctionNode("TT"); [EOL]     return InlineCostEstimator.getCost(alias) / 2 + 1; [EOL] } <line_num>: 199,210
private static Node createAliasFunctionNode(String aliasName) { [EOL]     final String PARAM_NAME = "jscomp_throw_param"; [EOL]     return IR.function(IR.name(aliasName), IR.paramList(IR.name(PARAM_NAME)), IR.block(IR.throwNode(IR.name(PARAM_NAME)))); [EOL] } <line_num>: 216,223
@Override [EOL] protected int minOccurrencesRequiredToAlias() { [EOL]     return MIN_OCCURRENCES_REQUIRED_TO_ALIAS_LITERAL; [EOL] } <line_num>: 231,234
@Override [EOL] protected void aliasNode(Node n, Node parent) { [EOL]     Node aliasNode = NodeUtil.newName(compiler.getCodingConvention(), getAliasName(), n, getAliasName()); [EOL]     parent.replaceChild(n, aliasNode); [EOL] } <line_num>: 236,241
@Override [EOL] protected void insertAliasDeclaration(Node codeRoot) { [EOL]     Node varNode = new Node(Token.VAR); [EOL]     Node value = new Node(getTokenId()); [EOL]     Node name = NodeUtil.newName(compiler.getCodingConvention(), getAliasName(), varNode, getAliasName()); [EOL]     name.addChildToBack(value); [EOL]     varNode.addChildToBack(name); [EOL]     codeRoot.addChildrenToFront(varNode); [EOL] } <line_num>: 243,256
@Override [EOL] public void visit(Node n, Node parent) { [EOL]     Node value = n.getFirstChild(); [EOL]     if (value.isNumber() && value.getDouble() == 0) { [EOL]         super.visit(n, parent); [EOL]     } [EOL] } <line_num>: 265,271
@Override [EOL] protected int minOccurrencesRequiredToAlias() { [EOL]     return MIN_OCCURRENCES_REQUIRED_TO_ALIAS_LITERAL; [EOL] } <line_num>: 273,276
@Override [EOL] protected void aliasNode(Node n, Node parent) { [EOL]     Node aliasNode = NodeUtil.newName(compiler.getCodingConvention(), getAliasName(), n, getAliasName()); [EOL]     parent.replaceChild(n, aliasNode); [EOL] } <line_num>: 278,283
@Override [EOL] protected void insertAliasDeclaration(Node codeRoot) { [EOL]     Node varNode = new Node(Token.VAR); [EOL]     Node value = IR.voidNode(IR.number(0)); [EOL]     Node name = NodeUtil.newName(compiler.getCodingConvention(), getAliasName(), varNode, getAliasName()); [EOL]     name.addChildToBack(value); [EOL]     varNode.addChildToBack(name); [EOL]     codeRoot.addChildrenToFront(varNode); [EOL] } <line_num>: 285,298
@Override [EOL] public void process(Node externs, Node root) { [EOL]     NodeTraversal.traverse(compiler, root, new FindAliasableNodes()); [EOL]     if (needsAliases()) { [EOL]         addAliasNodes(compiler.getNodeForCodeInsertion(null)); [EOL]         for (AliasSpecification spec : aliasSpecifications) { [EOL]             spec.doAlias(compiler); [EOL]         } [EOL]     } [EOL] } <line_num>: 367,381
private boolean needsAliases() { [EOL]     for (AliasSpecification spec : aliasSpecifications) { [EOL]         if (!spec.nodes.isEmpty()) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 383,391
private void addAliasNodes(Node codeRoot) { [EOL]     boolean codeChanged = false; [EOL]     for (AliasSpecification spec : aliasSpecifications) { [EOL]         if (spec.maybeInsertAliasDeclarationIntoParseTree(codeRoot)) { [EOL]             codeChanged = true; [EOL]         } [EOL]     } [EOL]     if (codeChanged) { [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL] } <line_num>: 397,409
private boolean isAliasDefinition(Node n) { [EOL]     if (!n.isName()) { [EOL]         return false; [EOL]     } [EOL]     if (!isAliasName(n.getString())) { [EOL]         return false; [EOL]     } [EOL]     return n.getFirstChild() != null; [EOL] } <line_num>: 414,429
private boolean isAliasableType(int type) { [EOL]     return aliasTypes.containsKey(type); [EOL] } <line_num>: 434,436
private boolean isAliasName(String name) { [EOL]     return aliasNames.contains(name); [EOL] } <line_num>: 441,443
private List<AliasSpecification> createAliasSpecifications() { [EOL]     List<AliasSpecification> l = Lists.newArrayList(); [EOL]     l.add(new KeywordAliasSpecification(ALIAS_FALSE, Token.FALSE)); [EOL]     l.add(new KeywordAliasSpecification(ALIAS_NULL, Token.NULL)); [EOL]     l.add(new KeywordAliasSpecification(ALIAS_TRUE, Token.TRUE)); [EOL]     l.add(new VoidKeywordAliasSpecification(ALIAS_VOID, Token.VOID)); [EOL]     l.add(new ThrowAliasSpecification(ALIAS_THROW)); [EOL]     return l; [EOL] } <line_num>: 450,464