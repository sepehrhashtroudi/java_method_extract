AnalyzePrototypeProperties(AbstractCompiler compiler, JSModuleGraph moduleGraph, boolean canModifyExterns, boolean anchorUnusedVars) { [EOL]     this.compiler = compiler; [EOL]     this.moduleGraph = moduleGraph; [EOL]     this.canModifyExterns = canModifyExterns; [EOL]     this.anchorUnusedVars = anchorUnusedVars; [EOL]     if (moduleGraph != null) { [EOL]         firstModule = moduleGraph.getRootModule(); [EOL]     } else { [EOL]         firstModule = null; [EOL]     } [EOL]     globalNode.markReference(null); [EOL]     externNode.markReference(null); [EOL]     symbolGraph.createNode(globalNode); [EOL]     symbolGraph.createNode(externNode); [EOL]     for (String property : IMPLICITLY_USED_PROPERTIES) { [EOL]         NameInfo nameInfo = getNameInfoForName(property, PROPERTY); [EOL]         if (moduleGraph == null) { [EOL]             symbolGraph.connect(externNode, null, nameInfo); [EOL]         } else { [EOL]             for (JSModule module : moduleGraph.getAllModules()) { [EOL]                 symbolGraph.connect(externNode, module, nameInfo); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 114,143
GlobalFunction(Node nameNode, Var var, JSModule module) { [EOL]     Node parent = nameNode.getParent(); [EOL]     Preconditions.checkState(parent.isVar() || NodeUtil.isFunctionDeclaration(parent)); [EOL]     this.nameNode = nameNode; [EOL]     this.var = var; [EOL]     this.module = module; [EOL] } <line_num>: 574,582
AssignmentProperty(Node node, Var rootVar, JSModule module) { [EOL]     this.exprNode = node; [EOL]     this.rootVar = rootVar; [EOL]     this.module = module; [EOL] } <line_num>: 644,648
LiteralProperty(Node key, Node value, Node map, Node assign, Var rootVar, JSModule module) { [EOL]     this.key = key; [EOL]     this.value = value; [EOL]     this.map = map; [EOL]     this.assign = assign; [EOL]     this.rootVar = rootVar; [EOL]     this.module = module; [EOL] } <line_num>: 694,702
NameContext(NameInfo name, Scope scope) { [EOL]     this.name = name; [EOL]     this.scope = scope; [EOL] } <line_num>: 741,744
NameInfo(String name) { [EOL]     this.name = name; [EOL] } <line_num>: 767,769
@Override [EOL] public void process(Node externRoot, Node root) { [EOL]     if (!canModifyExterns) { [EOL]         NodeTraversal.traverse(compiler, externRoot, new ProcessExternProperties()); [EOL]     } [EOL]     NodeTraversal.traverse(compiler, root, new ProcessProperties()); [EOL]     FixedPointGraphTraversal<NameInfo, JSModule> t = FixedPointGraphTraversal.newTraversal(new PropagateReferences()); [EOL]     t.computeFixedPoint(symbolGraph, Sets.newHashSet(externNode, globalNode)); [EOL] } <line_num>: 145,158
public Collection<NameInfo> getAllNameInfo() { [EOL]     List<NameInfo> result = Lists.newArrayList(propertyNameInfo.values()); [EOL]     result.addAll(varNameInfo.values()); [EOL]     return result; [EOL] } <line_num>: 163,167
private NameInfo getNameInfoForName(String name, SymbolType type) { [EOL]     Map<String, NameInfo> map = type == PROPERTY ? propertyNameInfo : varNameInfo; [EOL]     if (map.containsKey(name)) { [EOL]         return map.get(name); [EOL]     } else { [EOL]         NameInfo nameInfo = new NameInfo(name); [EOL]         map.put(name, nameInfo); [EOL]         symbolGraph.createNode(nameInfo); [EOL]         return nameInfo; [EOL]     } [EOL] } <line_num>: 176,187
@Override [EOL] public void enterScope(NodeTraversal t) { [EOL]     Node n = t.getCurrentNode(); [EOL]     if (n.isFunction()) { [EOL]         String propName = getPrototypePropertyNameFromRValue(n); [EOL]         if (propName != null) { [EOL]             symbolStack.push(new NameContext(getNameInfoForName(propName, PROPERTY), t.getScope())); [EOL]         } else if (isGlobalFunctionDeclaration(t, n)) { [EOL]             Node parent = n.getParent(); [EOL]             String name = parent.isName() ? parent.getString() : n.getFirstChild().getString(); [EOL]             symbolStack.push(new NameContext(getNameInfoForName(name, VAR), t.getScope())); [EOL]         } else { [EOL]             symbolStack.push(new NameContext(anonymousNode, t.getScope())); [EOL]         } [EOL]     } else { [EOL]         Preconditions.checkState(t.inGlobalScope()); [EOL]         symbolStack.push(new NameContext(globalNode, t.getScope())); [EOL]     } [EOL] } <line_num>: 201,230
@Override [EOL] public void exitScope(NodeTraversal t) { [EOL]     symbolStack.pop(); [EOL] } <line_num>: 232,235
@Override [EOL] public boolean shouldTraverse(NodeTraversal t, Node n, Node parent) { [EOL]     String propName = processNonFunctionPrototypeAssign(n, parent); [EOL]     if (propName != null) { [EOL]         symbolStack.push(new NameContext(getNameInfoForName(propName, PROPERTY), null)); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 237,247
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isGetProp()) { [EOL]         String propName = n.getFirstChild().getNext().getString(); [EOL]         if (n.isQualifiedName()) { [EOL]             if (propName.equals("prototype")) { [EOL]                 if (processPrototypeRef(t, n)) { [EOL]                     return; [EOL]                 } [EOL]             } else if (compiler.getCodingConvention().isExported(propName)) { [EOL]                 addGlobalUseOfSymbol(propName, t.getModule(), PROPERTY); [EOL]                 return; [EOL]             } else { [EOL]                 if (n.getParent().isAssign() && n.getNext() != null) { [EOL]                     String rValueName = getPrototypePropertyNameFromRValue(n); [EOL]                     if (rValueName != null) { [EOL]                         return; [EOL]                     } [EOL]                 } [EOL]             } [EOL]         } [EOL]         addSymbolUse(propName, t.getModule(), PROPERTY); [EOL]     } else if (n.isObjectLit()) { [EOL]         String lValueName = NodeUtil.getBestLValueName(NodeUtil.getBestLValue(n)); [EOL]         if (lValueName != null && lValueName.endsWith(".prototype")) { [EOL]             return; [EOL]         } [EOL]         for (Node propNameNode = n.getFirstChild(); propNameNode != null; propNameNode = propNameNode.getNext()) { [EOL]             if (!propNameNode.isQuotedString()) { [EOL]                 addSymbolUse(propNameNode.getString(), t.getModule(), PROPERTY); [EOL]             } [EOL]         } [EOL]     } else if (n.isName()) { [EOL]         String name = n.getString(); [EOL]         Var var = t.getScope().getVar(name); [EOL]         if (var != null) { [EOL]             if (var.isGlobal()) { [EOL]                 if (var.getInitialValue() != null && var.getInitialValue().isFunction()) { [EOL]                     if (t.inGlobalScope()) { [EOL]                         if (!processGlobalFunctionDeclaration(t, n, var)) { [EOL]                             addGlobalUseOfSymbol(name, t.getModule(), VAR); [EOL]                         } [EOL]                     } else { [EOL]                         addSymbolUse(name, t.getModule(), VAR); [EOL]                     } [EOL]                 } [EOL]             } else if (var.getScope() != t.getScope()) { [EOL]                 for (int i = symbolStack.size() - 1; i >= 0; i--) { [EOL]                     NameContext context = symbolStack.get(i); [EOL]                     if (context.scope == var.getScope()) { [EOL]                         break; [EOL]                     } [EOL]                     context.name.readClosureVariables = true; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     if (processNonFunctionPrototypeAssign(n, parent) != null) { [EOL]         symbolStack.pop(); [EOL]     } [EOL] } <line_num>: 249,331
private void addSymbolUse(String name, JSModule module, SymbolType type) { [EOL]     NameInfo info = getNameInfoForName(name, type); [EOL]     NameInfo def = null; [EOL]     for (int i = symbolStack.size() - 1; i >= 0; i--) { [EOL]         def = symbolStack.get(i).name; [EOL]         if (def != anonymousNode) { [EOL]             break; [EOL]         } [EOL]     } [EOL]     if (!def.equals(info)) { [EOL]         symbolGraph.connect(def, module, info); [EOL]     } [EOL] } <line_num>: 333,346
private String processNonFunctionPrototypeAssign(Node n, Node parent) { [EOL]     if (isAssignRValue(n, parent) && !n.isFunction()) { [EOL]         return getPrototypePropertyNameFromRValue(n); [EOL]     } [EOL]     return null; [EOL] } <line_num>: 352,357
private boolean isGlobalFunctionDeclaration(NodeTraversal t, Node n) { [EOL]     Scope s = t.getScope(); [EOL]     if (!(s.isGlobal() || s.getDepth() == 1 && s.getRootNode() == n)) { [EOL]         return false; [EOL]     } [EOL]     return NodeUtil.isFunctionDeclaration(n) || n.isFunction() && n.getParent().isName(); [EOL] } <line_num>: 363,374
private boolean isAssignRValue(Node n, Node parent) { [EOL]     return parent != null && parent.isAssign() && parent.getFirstChild() != n; [EOL] } <line_num>: 379,381
private String getPrototypePropertyNameFromRValue(Node rValue) { [EOL]     Node lValue = NodeUtil.getBestLValue(rValue); [EOL]     if (lValue == null || lValue.getParent() == null || lValue.getParent().getParent() == null || !(NodeUtil.isObjectLitKey(lValue, lValue.getParent()) || NodeUtil.isExprAssign(lValue.getParent().getParent()))) { [EOL]         return null; [EOL]     } [EOL]     String lValueName = NodeUtil.getBestLValueName(NodeUtil.getBestLValue(rValue)); [EOL]     if (lValueName == null) { [EOL]         return null; [EOL]     } [EOL]     int lastDot = lValueName.lastIndexOf('.'); [EOL]     if (lastDot == -1) { [EOL]         return null; [EOL]     } [EOL]     String firstPart = lValueName.substring(0, lastDot); [EOL]     if (!firstPart.endsWith(".prototype")) { [EOL]         return null; [EOL]     } [EOL]     return lValueName.substring(lastDot + 1); [EOL] } <line_num>: 390,416
private boolean processGlobalFunctionDeclaration(NodeTraversal t, Node nameNode, Var v) { [EOL]     Node firstChild = nameNode.getFirstChild(); [EOL]     Node parent = nameNode.getParent(); [EOL]     if (isGlobalFunctionDeclaration(t, parent) || firstChild != null && isGlobalFunctionDeclaration(t, firstChild)) { [EOL]         String name = nameNode.getString(); [EOL]         getNameInfoForName(name, VAR).getDeclarations().add(new GlobalFunction(nameNode, v, t.getModule())); [EOL]         if (compiler.getCodingConvention().isExported(name) || anchorUnusedVars) { [EOL]             addGlobalUseOfSymbol(name, t.getModule(), VAR); [EOL]         } [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 422,446
private boolean processPrototypeRef(NodeTraversal t, Node ref) { [EOL]     Node root = NodeUtil.getRootOfQualifiedName(ref); [EOL]     Node n = ref.getParent(); [EOL]     switch(n.getType()) { [EOL]         case Token.GETPROP: [EOL]             Node dest = n.getFirstChild().getNext(); [EOL]             Node parent = n.getParent(); [EOL]             Node grandParent = parent.getParent(); [EOL]             if (dest.isString() && NodeUtil.isExprAssign(grandParent) && NodeUtil.isVarOrSimpleAssignLhs(n, parent)) { [EOL]                 String name = dest.getString(); [EOL]                 Property prop = new AssignmentProperty(grandParent, maybeGetVar(t, root), t.getModule()); [EOL]                 getNameInfoForName(name, PROPERTY).getDeclarations().add(prop); [EOL]                 return true; [EOL]             } [EOL]             break; [EOL]         case Token.ASSIGN: [EOL]             Node map = n.getFirstChild().getNext(); [EOL]             if (map.isObjectLit()) { [EOL]                 for (Node key = map.getFirstChild(); key != null; key = key.getNext()) { [EOL]                     String name = key.getString(); [EOL]                     Property prop = new LiteralProperty(key, key.getFirstChild(), map, n, maybeGetVar(t, root), t.getModule()); [EOL]                     getNameInfoForName(name, PROPERTY).getDeclarations().add(prop); [EOL]                 } [EOL]                 return true; [EOL]             } [EOL]             break; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 454,497
private Var maybeGetVar(NodeTraversal t, Node maybeName) { [EOL]     return maybeName.isName() ? t.getScope().getVar(maybeName.getString()) : null; [EOL] } <line_num>: 499,502
private void addGlobalUseOfSymbol(String name, JSModule module, SymbolType type) { [EOL]     symbolGraph.connect(globalNode, module, getNameInfoForName(name, type)); [EOL] } <line_num>: 504,507
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isGetProp()) { [EOL]         symbolGraph.connect(externNode, firstModule, getNameInfoForName(n.getLastChild().getString(), PROPERTY)); [EOL]     } [EOL] } <line_num>: 511,517
@Override [EOL] public boolean traverseEdge(NameInfo start, JSModule edge, NameInfo dest) { [EOL]     if (start.isReferenced()) { [EOL]         JSModule startModule = start.getDeepestCommonModuleRef(); [EOL]         if (startModule != null && moduleGraph.dependsOn(startModule, edge)) { [EOL]             return dest.markReference(startModule); [EOL]         } else { [EOL]             return dest.markReference(edge); [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 522,534
void remove(); <line_num>: 548,548
Var getRootVar(); <line_num>: 553,553
JSModule getModule(); <line_num>: 558,558
@Override [EOL] public Var getRootVar() { [EOL]     return var; [EOL] } <line_num>: 584,587
@Override [EOL] public void remove() { [EOL]     Node parent = nameNode.getParent(); [EOL]     if (parent.isFunction() || parent.hasOneChild()) { [EOL]         NodeUtil.removeChild(parent.getParent(), parent); [EOL]     } else { [EOL]         Preconditions.checkState(parent.isVar()); [EOL]         parent.removeChild(nameNode); [EOL]     } [EOL] } <line_num>: 589,598
@Override [EOL] public JSModule getModule() { [EOL]     return module; [EOL] } <line_num>: 600,603
public Node getFunctionNode() { [EOL]     Node parent = nameNode.getParent(); [EOL]     if (parent.isFunction()) { [EOL]         return parent; [EOL]     } else { [EOL]         return nameNode.getChildAtIndex(1); [EOL]     } [EOL] } <line_num>: 605,614
Node getPrototype(); <line_num>: 624,624
Node getValue(); <line_num>: 627,627
@Override [EOL] public Var getRootVar() { [EOL]     return rootVar; [EOL] } <line_num>: 650,653
@Override [EOL] public void remove() { [EOL]     NodeUtil.removeChild(exprNode.getParent(), exprNode); [EOL] } <line_num>: 655,658
@Override [EOL] public Node getPrototype() { [EOL]     return getAssignNode().getFirstChild().getFirstChild(); [EOL] } <line_num>: 660,663
@Override [EOL] public Node getValue() { [EOL]     return getAssignNode().getLastChild(); [EOL] } <line_num>: 665,668
private Node getAssignNode() { [EOL]     return exprNode.getFirstChild(); [EOL] } <line_num>: 670,672
@Override [EOL] public JSModule getModule() { [EOL]     return module; [EOL] } <line_num>: 674,677
@Override [EOL] public Var getRootVar() { [EOL]     return rootVar; [EOL] } <line_num>: 704,707
@Override [EOL] public void remove() { [EOL]     map.removeChild(key); [EOL] } <line_num>: 709,712
@Override [EOL] public Node getPrototype() { [EOL]     return assign.getFirstChild(); [EOL] } <line_num>: 714,717
@Override [EOL] public Node getValue() { [EOL]     return value; [EOL] } <line_num>: 719,722
@Override [EOL] public JSModule getModule() { [EOL]     return module; [EOL] } <line_num>: 724,727
@Override [EOL] public String toString() { [EOL]     return name; [EOL] } <line_num>: 771,771
boolean isReferenced() { [EOL]     return referenced; [EOL] } <line_num>: 774,776
boolean readsClosureVariables() { [EOL]     return readClosureVariables; [EOL] } <line_num>: 779,781
boolean markReference(JSModule module) { [EOL]     boolean hasChanged = false; [EOL]     if (!referenced) { [EOL]         referenced = true; [EOL]         hasChanged = true; [EOL]     } [EOL]     if (moduleGraph != null) { [EOL]         JSModule originalDeepestCommon = deepestCommonModuleRef; [EOL]         if (deepestCommonModuleRef == null) { [EOL]             deepestCommonModuleRef = module; [EOL]         } else { [EOL]             deepestCommonModuleRef = moduleGraph.getDeepestCommonDependencyInclusive(deepestCommonModuleRef, module); [EOL]         } [EOL]         if (originalDeepestCommon != deepestCommonModuleRef) { [EOL]             hasChanged = true; [EOL]         } [EOL]     } [EOL]     return hasChanged; [EOL] } <line_num>: 789,813
JSModule getDeepestCommonModuleRef() { [EOL]     return deepestCommonModuleRef; [EOL] } <line_num>: 819,821
Deque<Symbol> getDeclarations() { [EOL]     return declarations; [EOL] } <line_num>: 827,829