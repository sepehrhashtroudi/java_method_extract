 InlineFunctions(AbstractCompiler compiler, Supplier<String> safeNameIdSupplier, boolean inlineGlobalFunctions, boolean inlineLocalFunctions, boolean blockFunctionInliningEnabled, boolean assumeStrictThis, boolean assumeMinimumCapture)
 CallVisitor(Map<String, FunctionState> fns, Map<Node, String> anonFns, CallVisitorCallback callback)
 FindCandidatesReferences(Map<String, FunctionState> fns, Map<Node, String> anonFns)
 Inline(FunctionInjector injector, SpecializeModule.SpecializationState specializationState)
public NamedFunction(Node fn)
public FunctionVar(Node var)
public FunctionExpression(Node fn, int index)
 Reference(Node callNode, JSModule module, InliningMode mode, boolean decompose)
 FunctionState getOrCreateFunctionState(String fnName)
public void enableSpecialization(SpecializeModule.SpecializationState specializationState)
public void process(Node externs, Node root)
public boolean shouldTraverse(NodeTraversal nodeTraversal, Node n, Node parent)
public void visit(NodeTraversal t, Node n, Node parent)
public void findNamedFunctions(NodeTraversal t, Node n, Node parent)
public void findFunctionExpressions(NodeTraversal t, Node n)
private void maybeAddFunction(Function fn, JSModule module)
private boolean hasLocalNames(Node fnNode)
private static Node getContainingFunction(NodeTraversal t)
private boolean isCandidateFunction(Function fn)
public void visitCallSite(NodeTraversal t, Node callNode, Node parent, FunctionState fs)
public void visit(NodeTraversal t, Node n, Node parent)
 static boolean isCandidateUsage(Node name)
public void visit(NodeTraversal t, Node n, Node parent)
public void visitCallSite(NodeTraversal t, Node callNode, Node parent, FunctionState fs)
 void maybeAddReference(NodeTraversal t, FunctionState fs, Node callNode, JSModule module)
private boolean maybeAddReferenceUsingMode(NodeTraversal t, FunctionState fs, Node callNode, JSModule module, InliningMode mode)
private void checkNameUsage(NodeTraversal t, Node n, Node parent)
public void visitCallSite(NodeTraversal t, Node callNode, Node parent, FunctionState fs)
private void inlineFunction(NodeTraversal t, Node callNode, FunctionState fs, InliningMode mode)
private void trimCanidatesNotMeetingMinimumRequirements()
 void trimCanidatesUsingOnCost()
private boolean mimimizeCost(FunctionState fs)
private boolean inliningLowersCost(FunctionState fs)
private void resolveInlineConflicts()
private void resolveInlineConflictsForFunction(FunctionState fs)
private Set<String> findCalledFunctions(Node node)
private void findCalledFunctions(Node node, Set<String> changed)
private void decomposeExpressions(Set<String> fnNames)
 void removeInlinedFunctions()
 void verifyAllReferencesInlined(FunctionState fs)
 boolean hasExistingFunctionDefinition()
public void setReferencesThis(boolean referencesThis)
public boolean getReferencesThis()
public void setHasInnerFunctions(boolean hasInnerFunctions)
public boolean hasInnerFunctions()
 void removeBlockInliningReferences()
public boolean hasBlockInliningReferences()
public Function getFn()
public void setFn(Function fn)
public Node getSafeFnNode()
public void setSafeFnNode(Node safeFnNode)
public boolean canInline()
public void setInline(boolean inline)
public boolean canRemove()
public void setRemove(boolean remove)
public boolean canInlineDirectly()
public void inlineDirectly(boolean directReplacement)
public boolean hasReferences()
private Map<Node, Reference> getReferencesInternal()
public void addReference(Reference ref)
public Collection<Reference> getReferences()
public Reference getReference(Node n)
public Set<String> getNamesToAlias()
public void setNamesToAlias(Set<String> names)
public void setModule(JSModule module)
public JSModule getModule()
public String getName()
public Node getFunctionNode()
public void remove()
public Node getDeclaringBlock()
public String getName()
public Node getFunctionNode()
public void remove()
public Node getDeclaringBlock()
public String getName()
public Node getFunctionNode()
public void remove()
public Node getDeclaringBlock()
public String getName()
public Node getFunctionNode()
public void remove()
public Node getDeclaringBlock()
