 GlobalVarReferenceMap(List<CompilerInput> inputs, List<CompilerInput> externs)
 SourceRefRange(List<Reference> refList, int lastBefore, int firstAfter)
public GlobalVarRefCleanupPass(AbstractCompiler compiler)
public ReferenceCollection getReferences(Var var)
private void resetGlobalVarReferences(Map<Var, ReferenceCollection> globalRefMap)
 void updateGlobalVarReferences(Map<Var, ReferenceCollection> refMapPatch, Node root)
private void removeScriptReferences(InputId inputId)
private void replaceReferences(String varName, InputId inputId, ReferenceCollection newSourceCollection)
private SourceRefRange findSourceRefRange(List<Reference> refList, InputId inputId)
 List<Reference> refsBefore()
 List<Reference> refsAfter()
public void updateReferencesWithGlobalScope(Scope globalScope)
public void hotSwapScript(Node scriptRoot, Node originalRoot)
public void process(Node externs, Node root)
