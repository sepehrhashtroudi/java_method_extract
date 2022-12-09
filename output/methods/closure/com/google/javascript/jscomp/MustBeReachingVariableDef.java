MustBeReachingVariableDef(ControlFlowGraph<Node> cfg, Scope jsScope, AbstractCompiler compiler) { [EOL]     super(cfg, new MustDefJoin()); [EOL]     this.jsScope = jsScope; [EOL]     this.compiler = compiler; [EOL]     this.escaped = Sets.newHashSet(); [EOL]     computeEscaped(jsScope, escaped, compiler); [EOL] } <line_num>: 53,60
Definition(Node node) { [EOL]     this.node = node; [EOL] } <line_num>: 73,75
public MustDef() { [EOL]     reachingDef = Maps.newHashMap(); [EOL] } <line_num>: 116,118
public MustDef(Iterator<Var> vars) { [EOL]     this(); [EOL]     while (vars.hasNext()) { [EOL]         Var var = vars.next(); [EOL]         reachingDef.put(var, new Definition(var.scope.getRootNode())); [EOL]     } [EOL] } <line_num>: 120,129
public MustDef(MustDef other) { [EOL]     reachingDef = Maps.newHashMap(other.reachingDef); [EOL] } <line_num>: 136,138
@Override [EOL] public boolean equals(Object other) { [EOL]     if (!(other instanceof Definition)) { [EOL]         return false; [EOL]     } [EOL]     Definition otherDef = (Definition) other; [EOL]     return otherDef.node == node; [EOL] } <line_num>: 77,86
@Override [EOL] public boolean equals(Object other) { [EOL]     return (other instanceof MustDef) && ((MustDef) other).reachingDef.equals(this.reachingDef); [EOL] } <line_num>: 140,144
@Override [EOL] public MustDef apply(MustDef a, MustDef b) { [EOL]     MustDef result = new MustDef(); [EOL]     Map<Var, Definition> resultMap = result.reachingDef; [EOL]     for (Map.Entry<Var, Definition> varEntry : a.reachingDef.entrySet()) { [EOL]         Var var = varEntry.getKey(); [EOL]         Definition aDef = varEntry.getValue(); [EOL]         if (aDef == null) { [EOL]             resultMap.put(var, null); [EOL]             continue; [EOL]         } [EOL]         Node aNode = aDef.node; [EOL]         if (b.reachingDef.containsKey(var)) { [EOL]             Definition bDef = b.reachingDef.get(var); [EOL]             if (aDef.equals(bDef)) { [EOL]                 resultMap.put(var, aDef); [EOL]             } else { [EOL]                 resultMap.put(var, null); [EOL]             } [EOL]         } else { [EOL]             resultMap.put(var, aDef); [EOL]         } [EOL]     } [EOL]     for (Map.Entry<Var, Definition> entry : b.reachingDef.entrySet()) { [EOL]         Var var = entry.getKey(); [EOL]         if (!a.reachingDef.containsKey(var)) { [EOL]             resultMap.put(var, entry.getValue()); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 148,190
@Override [EOL] boolean isForward() { [EOL]     return true; [EOL] } <line_num>: 193,196
@Override [EOL] MustDef createEntryLattice() { [EOL]     return new MustDef(jsScope.getVars()); [EOL] } <line_num>: 198,201
@Override [EOL] MustDef createInitialEstimateLattice() { [EOL]     return new MustDef(); [EOL] } <line_num>: 203,206
@Override [EOL] MustDef flowThrough(Node n, MustDef input) { [EOL]     MustDef output = new MustDef(input); [EOL]     computeMustDef(n, n, output, false); [EOL]     return output; [EOL] } <line_num>: 208,218
private void computeMustDef(Node n, Node cfgNode, MustDef output, boolean conditional) { [EOL]     switch(n.getType()) { [EOL]         case Token.BLOCK: [EOL]         case Token.FUNCTION: [EOL]             return; [EOL]         case Token.WHILE: [EOL]         case Token.DO: [EOL]         case Token.IF: [EOL]             computeMustDef(NodeUtil.getConditionExpression(n), cfgNode, output, conditional); [EOL]             return; [EOL]         case Token.FOR: [EOL]             if (!NodeUtil.isForIn(n)) { [EOL]                 computeMustDef(NodeUtil.getConditionExpression(n), cfgNode, output, conditional); [EOL]             } else { [EOL]                 Node lhs = n.getFirstChild(); [EOL]                 Node rhs = lhs.getNext(); [EOL]                 if (lhs.isVar()) { [EOL]                     lhs = lhs.getLastChild(); [EOL]                 } [EOL]                 if (lhs.isName()) { [EOL]                     addToDefIfLocal(lhs.getString(), cfgNode, rhs, output); [EOL]                 } [EOL]             } [EOL]             return; [EOL]         case Token.AND: [EOL]         case Token.OR: [EOL]             computeMustDef(n.getFirstChild(), cfgNode, output, conditional); [EOL]             computeMustDef(n.getLastChild(), cfgNode, output, true); [EOL]             return; [EOL]         case Token.HOOK: [EOL]             computeMustDef(n.getFirstChild(), cfgNode, output, conditional); [EOL]             computeMustDef(n.getFirstChild().getNext(), cfgNode, output, true); [EOL]             computeMustDef(n.getLastChild(), cfgNode, output, true); [EOL]             return; [EOL]         case Token.VAR: [EOL]             for (Node c = n.getFirstChild(); c != null; c = c.getNext()) { [EOL]                 if (c.hasChildren()) { [EOL]                     computeMustDef(c.getFirstChild(), cfgNode, output, conditional); [EOL]                     addToDefIfLocal(c.getString(), conditional ? null : cfgNode, c.getFirstChild(), output); [EOL]                 } [EOL]             } [EOL]             return; [EOL]         default: [EOL]             if (NodeUtil.isAssignmentOp(n)) { [EOL]                 if (n.getFirstChild().isName()) { [EOL]                     Node name = n.getFirstChild(); [EOL]                     computeMustDef(name.getNext(), cfgNode, output, conditional); [EOL]                     addToDefIfLocal(name.getString(), conditional ? null : cfgNode, n.getLastChild(), output); [EOL]                     return; [EOL]                 } else if (NodeUtil.isGet(n.getFirstChild())) { [EOL]                     Node obj = n.getFirstChild().getFirstChild(); [EOL]                     if (obj.isName() && "arguments".equals(obj.getString())) { [EOL]                         escapeParameters(output); [EOL]                     } [EOL]                 } [EOL]             } [EOL]             if (n.isName() && "arguments".equals(n.getString())) { [EOL]                 escapeParameters(output); [EOL]             } [EOL]             if (n.isDec() || n.isInc()) { [EOL]                 Node target = n.getFirstChild(); [EOL]                 if (target.isName()) { [EOL]                     addToDefIfLocal(target.getString(), conditional ? null : cfgNode, null, output); [EOL]                     return; [EOL]                 } [EOL]             } [EOL]             for (Node c = n.getFirstChild(); c != null; c = c.getNext()) { [EOL]                 computeMustDef(c, cfgNode, output, conditional); [EOL]             } [EOL]     } [EOL] } <line_num>: 225,318
private void addToDefIfLocal(String name, @Nullable Node node, @Nullable Node rValue, MustDef def) { [EOL]     Var var = jsScope.getVar(name); [EOL]     if (var == null || var.scope != jsScope) { [EOL]         return; [EOL]     } [EOL]     for (Var other : def.reachingDef.keySet()) { [EOL]         Definition otherDef = def.reachingDef.get(other); [EOL]         if (otherDef == null) { [EOL]             continue; [EOL]         } [EOL]         if (otherDef.depends.contains(var)) { [EOL]             def.reachingDef.put(other, null); [EOL]         } [EOL]     } [EOL]     if (!escaped.contains(var)) { [EOL]         if (node == null) { [EOL]             def.reachingDef.put(var, null); [EOL]         } else { [EOL]             Definition definition = new Definition(node); [EOL]             if (rValue != null) { [EOL]                 computeDependence(definition, rValue); [EOL]             } [EOL]             def.reachingDef.put(var, definition); [EOL]         } [EOL]     } [EOL] } <line_num>: 327,358
private void escapeParameters(MustDef output) { [EOL]     for (Iterator<Var> i = jsScope.getVars(); i.hasNext(); ) { [EOL]         Var v = i.next(); [EOL]         if (isParameter(v)) { [EOL]             output.reachingDef.put(v, null); [EOL]         } [EOL]     } [EOL]     for (Entry<Var, Definition> pair : output.reachingDef.entrySet()) { [EOL]         Definition value = pair.getValue(); [EOL]         if (value == null) { [EOL]             continue; [EOL]         } [EOL]         for (Var dep : value.depends) { [EOL]             if (isParameter(dep)) { [EOL]                 output.reachingDef.put(pair.getKey(), null); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 360,382
private boolean isParameter(Var v) { [EOL]     return v.getParentNode().isParamList(); [EOL] } <line_num>: 384,386
@Override [EOL] public void visit(NodeTraversal t, Node n, Node parent) { [EOL]     if (n.isName()) { [EOL]         Var dep = jsScope.getVar(n.getString()); [EOL]         if (dep == null) { [EOL]             def.unknownDependencies = true; [EOL]         } else { [EOL]             def.depends.add(dep); [EOL]         } [EOL]     } [EOL] } <line_num>: 395,405
private void computeDependence(final Definition def, Node rValue) { [EOL]     NodeTraversal.traverse(compiler, rValue, new AbstractCfgNodeTraversalCallback() { [EOL]  [EOL]         @Override [EOL]         public void visit(NodeTraversal t, Node n, Node parent) { [EOL]             if (n.isName()) { [EOL]                 Var dep = jsScope.getVar(n.getString()); [EOL]                 if (dep == null) { [EOL]                     def.unknownDependencies = true; [EOL]                 } else { [EOL]                     def.depends.add(dep); [EOL]                 } [EOL]             } [EOL]         } [EOL]     }); [EOL] } <line_num>: 392,407
Definition getDef(String name, Node useNode) { [EOL]     Preconditions.checkArgument(getCfg().hasNode(useNode)); [EOL]     GraphNode<Node, Branch> n = getCfg().getNode(useNode); [EOL]     FlowState<MustDef> state = n.getAnnotation(); [EOL]     return state.getIn().reachingDef.get(jsScope.getVar(name)); [EOL] } <line_num>: 417,422
Node getDefNode(String name, Node useNode) { [EOL]     Definition def = getDef(name, useNode); [EOL]     return def == null ? null : def.node; [EOL] } <line_num>: 424,427
boolean dependsOnOuterScopeVars(Definition def) { [EOL]     if (def.unknownDependencies) { [EOL]         return true; [EOL]     } [EOL]     for (Var s : def.depends) { [EOL]         if (s.scope != jsScope) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 429,440
