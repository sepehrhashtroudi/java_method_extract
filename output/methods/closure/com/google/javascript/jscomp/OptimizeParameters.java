OptimizeParameters(AbstractCompiler compiler) { [EOL]     this.compiler = compiler; [EOL] } <line_num>: 50,52
public Parameter(Node arg, boolean shouldRemove) { [EOL]     this.shouldRemove = shouldRemove; [EOL]     this.arg = arg; [EOL] } <line_num>: 413,416
@Override [EOL] @VisibleForTesting [EOL] public void process(Node externs, Node root) { [EOL]     Preconditions.checkState(compiler.getLifeCycleStage() == LifeCycleStage.NORMALIZED); [EOL]     SimpleDefinitionFinder defFinder = new SimpleDefinitionFinder(compiler); [EOL]     defFinder.process(externs, root); [EOL]     process(externs, root, defFinder); [EOL] } <line_num>: 54,62
@Override [EOL] public void process(Node externs, Node root, SimpleDefinitionFinder definitions) { [EOL]     for (DefinitionSite defSite : definitions.getDefinitionSites()) { [EOL]         if (canChangeSignature(defSite, definitions)) { [EOL]             tryEliminateConstantArgs(defSite, definitions); [EOL]             tryEliminateOptionalArgs(defSite, definitions); [EOL]         } [EOL]     } [EOL]     for (Node n : removedNodes) { [EOL]         definitions.removeReferences(n); [EOL]     } [EOL] } <line_num>: 64,79
private boolean canChangeSignature(DefinitionSite definitionSite, SimpleDefinitionFinder defFinder) { [EOL]     Definition definition = definitionSite.definition; [EOL]     if (definitionSite.inExterns) { [EOL]         return false; [EOL]     } [EOL]     Node rValue = definition.getRValue(); [EOL]     if (rValue == null || !rValue.isFunction() || NodeUtil.isVarArgsFunction(rValue)) { [EOL]         return false; [EOL]     } [EOL]     if (!SimpleDefinitionFinder.isSimpleFunctionDeclaration(rValue)) { [EOL]         return false; [EOL]     } [EOL]     if (!defFinder.canModifyDefinition(definition)) { [EOL]         return false; [EOL]     } [EOL]     Collection<UseSite> useSites = defFinder.getUseSites(definition); [EOL]     if (useSites.isEmpty()) { [EOL]         return false; [EOL]     } [EOL]     for (UseSite site : useSites) { [EOL]         if (!SimpleDefinitionFinder.isCallOrNewSite(site)) { [EOL]             return false; [EOL]         } [EOL]         Node nameNode = site.node; [EOL]         Collection<Definition> singleSiteDefinitions = defFinder.getDefinitionsReferencedAt(nameNode); [EOL]         if (singleSiteDefinitions.size() > 1) { [EOL]             return false; [EOL]         } [EOL]         Preconditions.checkState(!singleSiteDefinitions.isEmpty()); [EOL]         Preconditions.checkState(singleSiteDefinitions.contains(definition)); [EOL]     } [EOL]     return true; [EOL] } <line_num>: 85,147
private void tryEliminateOptionalArgs(DefinitionSite defSite, SimpleDefinitionFinder defFinder) { [EOL]     int maxArgs = -1; [EOL]     Definition definition = defSite.definition; [EOL]     Collection<UseSite> useSites = defFinder.getUseSites(definition); [EOL]     for (UseSite site : useSites) { [EOL]         Preconditions.checkState(SimpleDefinitionFinder.isCallOrNewSite(site)); [EOL]         Node call = site.node.getParent(); [EOL]         int numArgs = call.getChildCount() - 1; [EOL]         if (numArgs > maxArgs) { [EOL]             maxArgs = numArgs; [EOL]         } [EOL]     } [EOL]     eliminateParamsAfter(definition.getRValue(), maxArgs); [EOL] } <line_num>: 152,171
private void tryEliminateConstantArgs(DefinitionSite defSite, SimpleDefinitionFinder defFinder) { [EOL]     List<Parameter> parameters = Lists.newArrayList(); [EOL]     boolean firstCall = true; [EOL]     Definition definition = defSite.definition; [EOL]     Collection<UseSite> useSites = defFinder.getUseSites(definition); [EOL]     boolean continueLooking = false; [EOL]     for (UseSite site : useSites) { [EOL]         Preconditions.checkState(SimpleDefinitionFinder.isCallOrNewSite(site)); [EOL]         Node call = site.node.getParent(); [EOL]         Node cur = call.getFirstChild(); [EOL]         if (firstCall) { [EOL]             continueLooking = buildParameterList(parameters, cur, site.scope); [EOL]             firstCall = false; [EOL]         } else { [EOL]             continueLooking = findFixedParameters(parameters, cur); [EOL]         } [EOL]         if (!continueLooking) { [EOL]             return; [EOL]         } [EOL]     } [EOL]     continueLooking = adjustForSideEffects(parameters); [EOL]     if (!continueLooking) { [EOL]         return; [EOL]     } [EOL]     for (UseSite site : useSites) { [EOL]         Preconditions.checkState(SimpleDefinitionFinder.isCallOrNewSite(site)); [EOL]         Node call = site.node.getParent(); [EOL]         optimizeCallSite(defFinder, parameters, call); [EOL]     } [EOL]     Node function = definition.getRValue(); [EOL]     if (function.isFunction()) { [EOL]         optimizeFunctionDefinition(parameters, function); [EOL]     } [EOL] } <line_num>: 184,231
private boolean adjustForSideEffects(List<Parameter> parameters) { [EOL]     boolean anyMovable = false; [EOL]     boolean seenUnmovableSideEffects = false; [EOL]     boolean seenUnmoveableSideEfffected = false; [EOL]     for (int i = parameters.size() - 1; i >= 0; i--) { [EOL]         Parameter current = parameters.get(i); [EOL]         if (current.shouldRemove && ((seenUnmovableSideEffects && current.canBeSideEffected()) || (seenUnmoveableSideEfffected && current.hasSideEffects()))) { [EOL]             current.shouldRemove = false; [EOL]         } [EOL]         if (current.shouldRemove) { [EOL]             anyMovable = true; [EOL]         } else { [EOL]             if (current.canBeSideEffected) { [EOL]                 seenUnmoveableSideEfffected = true; [EOL]             } [EOL]             if (current.hasSideEffects) { [EOL]                 seenUnmovableSideEffects = true; [EOL]             } [EOL]         } [EOL]     } [EOL]     return anyMovable; [EOL] } <line_num>: 237,275
private boolean findFixedParameters(List<Parameter> parameters, Node cur) { [EOL]     boolean anyMovable = false; [EOL]     int index = 0; [EOL]     while ((cur = cur.getNext()) != null) { [EOL]         Parameter p; [EOL]         if (index >= parameters.size()) { [EOL]             p = new Parameter(cur, false); [EOL]             parameters.add(p); [EOL]         } else { [EOL]             p = parameters.get(index); [EOL]             if (p.shouldRemove()) { [EOL]                 Node value = p.getArg(); [EOL]                 if (!cur.isEquivalentTo(value)) { [EOL]                     p.setShouldRemove(false); [EOL]                 } else { [EOL]                     anyMovable = true; [EOL]                 } [EOL]             } [EOL]         } [EOL]         setParameterSideEffectInfo(p, cur); [EOL]         index++; [EOL]     } [EOL]     for (; index < parameters.size(); index++) { [EOL]         parameters.get(index).setShouldRemove(false); [EOL]     } [EOL]     return anyMovable; [EOL] } <line_num>: 281,310
private boolean buildParameterList(List<Parameter> parameters, Node cur, Scope s) { [EOL]     boolean anyMovable = false; [EOL]     while ((cur = cur.getNext()) != null) { [EOL]         boolean movable = isMovableValue(cur, s); [EOL]         Parameter p = new Parameter(cur, movable); [EOL]         setParameterSideEffectInfo(p, cur); [EOL]         parameters.add(p); [EOL]         if (movable) { [EOL]             anyMovable = true; [EOL]         } [EOL]     } [EOL]     return anyMovable; [EOL] } <line_num>: 315,328
private void setParameterSideEffectInfo(Parameter p, Node value) { [EOL]     if (!p.hasSideEffects()) { [EOL]         p.setHasSideEffects(NodeUtil.mayHaveSideEffects(value, compiler)); [EOL]     } [EOL]     if (!p.canBeSideEffected()) { [EOL]         p.setCanBeSideEffected(NodeUtil.canBeSideEffected(value)); [EOL]     } [EOL] } <line_num>: 330,338
private boolean isMovableValue(Node n, Scope s) { [EOL]     switch(n.getType()) { [EOL]         case Token.THIS: [EOL]             return false; [EOL]         case Token.FUNCTION: [EOL]             return false; [EOL]         case Token.NAME: [EOL]             if (n.getString().equals("arguments")) { [EOL]                 return false; [EOL]             } else { [EOL]                 Var v = s.getVar(n.getString()); [EOL]                 if (v != null && (v.isLocal() || v.nameNode.getParent().isCatch())) { [EOL]                     return false; [EOL]                 } [EOL]             } [EOL]             break; [EOL]     } [EOL]     for (Node c = n.getFirstChild(); c != null; c = c.getNext()) { [EOL]         if (!isMovableValue(c, s)) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 345,380
private void optimizeFunctionDefinition(List<Parameter> parameters, Node function) { [EOL]     for (int index = parameters.size() - 1; index >= 0; index--) { [EOL]         if (parameters.get(index).shouldRemove()) { [EOL]             Node paramName = eliminateFunctionParamAt(function, index); [EOL]             addVariableToFunction(function, paramName, parameters.get(index).getArg()); [EOL]         } [EOL]     } [EOL] } <line_num>: 382,391
private void optimizeCallSite(SimpleDefinitionFinder defFinder, List<Parameter> parameters, Node call) { [EOL]     for (int index = parameters.size() - 1; index >= 0; index--) { [EOL]         Parameter p = parameters.get(index); [EOL]         if (p.shouldRemove()) { [EOL]             eliminateCallParamAt(defFinder, p, call, index); [EOL]         } [EOL]     } [EOL] } <line_num>: 393,401
public Node getArg() { [EOL]     return arg; [EOL] } <line_num>: 418,420
public boolean shouldRemove() { [EOL]     return shouldRemove; [EOL] } <line_num>: 422,424
public void setShouldRemove(boolean value) { [EOL]     shouldRemove = value; [EOL] } <line_num>: 426,428
public void setHasSideEffects(boolean hasSideEffects) { [EOL]     this.hasSideEffects = hasSideEffects; [EOL] } <line_num>: 430,432
public boolean hasSideEffects() { [EOL]     return hasSideEffects; [EOL] } <line_num>: 434,436
public void setCanBeSideEffected(boolean canBeSideEffected) { [EOL]     this.canBeSideEffected = canBeSideEffected; [EOL] } <line_num>: 438,440
public boolean canBeSideEffected() { [EOL]     return canBeSideEffected; [EOL] } <line_num>: 442,444
private void addVariableToFunction(Node function, Node varName, Node value) { [EOL]     Preconditions.checkArgument(function.isFunction(), "Node must be a function."); [EOL]     Node block = function.getLastChild(); [EOL]     Preconditions.checkArgument(block.isBlock(), "Node must be a block."); [EOL]     Preconditions.checkState(value.getParent() == null); [EOL]     Node stmt; [EOL]     if (varName != null) { [EOL]         stmt = NodeUtil.newVarNode(varName.getString(), value); [EOL]     } else { [EOL]         stmt = IR.exprResult(value); [EOL]     } [EOL]     block.addChildToFront(stmt); [EOL]     compiler.reportCodeChange(); [EOL] } <line_num>: 453,470
private boolean eliminateParamsAfter(Node function, int argIndex) { [EOL]     boolean paramRemoved = false; [EOL]     Node formalArgPtr = function.getFirstChild().getNext().getFirstChild(); [EOL]     while (argIndex != 0 && formalArgPtr != null) { [EOL]         formalArgPtr = formalArgPtr.getNext(); [EOL]         argIndex--; [EOL]     } [EOL]     return eliminateParamsAfter(function, formalArgPtr); [EOL] } <line_num>: 476,486
private boolean eliminateParamsAfter(Node fnNode, Node argNode) { [EOL]     if (argNode != null) { [EOL]         eliminateParamsAfter(fnNode, argNode.getNext()); [EOL]         argNode.detachFromParent(); [EOL]         Node var = IR.var(argNode).copyInformationFrom(argNode); [EOL]         fnNode.getLastChild().addChildrenToFront(var); [EOL]         compiler.reportCodeChange(); [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 488,499
private Node eliminateFunctionParamAt(Node function, int argIndex) { [EOL]     Preconditions.checkArgument(function.isFunction(), "Node must be a function."); [EOL]     Node formalArgPtr = NodeUtil.getArgumentForFunction(function, argIndex); [EOL]     if (formalArgPtr != null) { [EOL]         function.getFirstChild().getNext().removeChild(formalArgPtr); [EOL]     } [EOL]     return formalArgPtr; [EOL] } <line_num>: 507,518
private Node eliminateCallParamAt(SimpleDefinitionFinder defFinder, Parameter p, Node call, int argIndex) { [EOL]     Preconditions.checkArgument(NodeUtil.isCallOrNew(call), "Node must be a call or new."); [EOL]     Node formalArgPtr = NodeUtil.getArgumentForCallOrNew(call, argIndex); [EOL]     if (formalArgPtr != null) { [EOL]         call.removeChild(formalArgPtr); [EOL]         if (p.getArg() != formalArgPtr) { [EOL]             removedNodes.add(formalArgPtr); [EOL]         } [EOL]         compiler.reportCodeChange(); [EOL]     } [EOL]     return formalArgPtr; [EOL] } <line_num>: 528,547
