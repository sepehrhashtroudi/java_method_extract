public JSModuleGraph(JSModule[] modulesInDepOrder)
public JSModuleGraph(List<JSModule> modulesInDepOrder)
protected ModuleDependenceException(String message, JSModule module, JSModule dependentModule)
 Iterable<JSModule> getAllModules()
 int getModuleCount()
 JSModule getRootModule()
 JSONArray toJson()
public boolean dependsOn(JSModule src, JSModule m)
 JSModule getDeepestCommonDependency(JSModule m1, JSModule m2)
public JSModule getDeepestCommonDependencyInclusive(JSModule m1, JSModule m2)
public JSModule getDeepestCommonDependencyInclusive(Collection<JSModule> modules)
 Set<JSModule> getTransitiveDepsDeepestFirst(JSModule m)
private void addDeps(Set<JSModule> deps, JSModule m)
public void coalesceDuplicateFiles()
public List<CompilerInput> manageDependencies(List<String> entryPoints, List<CompilerInput> inputs) throws CircularDependencyException, MissingProvideException
public List<CompilerInput> manageDependencies(DependencyOptions depOptions, List<CompilerInput> inputs) throws CircularDependencyException, MissingProvideException
 LinkedDirectedGraph<JSModule, String> toGraphvizGraph()
public int compare(JSModule m1, JSModule m2)
private int depthCompare(JSModule m1, JSModule m2)
public JSModule getModule()
public JSModule getDependentModule()
List<JSModule> modules
List<List<JSModule>> modulesByDepth
Map<JSModule, Set<JSModule>> dependencyMap=Optional[Maps.newHashMap()]
