public SideEffectsAnalysis(AbstractCompiler compiler, LocationAbstractionMode locationAbstractionMode)
public SideEffectsAnalysis(AbstractCompiler compiler)
public IntraproceduralMotionEnvironment(ControlFlowGraph<Node> controlFlowGraph, Node cfgSource, Node cfgDestination)
public CrossModuleMotionEnvironment(Node sourceNode, JSModule sourceModule, Node destinationNode, JSModule destinationModule, JSModuleGraph moduleGraph)
public RawMotionEnvironment(Set<Node> environment)
public LocationSummary(EffectLocation modSet, EffectLocation refSet)
private VisibilityLocationAbstraction(AbstractCompiler compiler, VariableVisibilityAnalysis variableVisibilityAnalysis, VariableUseDeclarationMap variableUseMap)
public VisibilityBasedEffectLocation(int visibilityMask)
public VariableUseDeclarationMap(AbstractCompiler compiler)
public boolean apply(Node input)
public void process(Node externs, Node root)
private LocationAbstraction createVisibilityAbstraction(Node externs, Node root)
public boolean safeToMoveBefore(Node source, AbstractMotionEnvironment environment, Node destination)
private boolean isPure(Node node)
public boolean apply(Node input)
private static boolean nodesHaveSameControlFlow(Node node1, Node node2)
private static boolean isControlDependentChild(Node child)
private static Node closestControlDependentAncestor(Node node)
private static boolean nodeHasAncestor(Node node, Node possibleAncestor)
public boolean apply(Node input)
private boolean nodeHasCall(Node node)
public abstract Set<Node> calculateEnvironment()
public Set<Node> calculateEnvironment()
public Set<Node> calculateEnvironment()
public Set<Node> calculateEnvironment()
public EffectLocation getModSet()
public EffectLocation getRefSet()
public boolean intersectsLocation(EffectLocation otherLocation)
public EffectLocation join(EffectLocation otherLocation)
public boolean isEmpty()
 abstract LocationSummary calculateLocationSummary(Node node)
 abstract EffectLocation getBottomLocation()
public LocationSummary calculateLocationSummary(Set<Node> nodes)
 EffectLocation getBottomLocation()
public LocationSummary calculateLocationSummary(Node node)
 EffectLocation calculateRefSet(Node node)
 EffectLocation calculateModSet(Node node)
public EffectLocation join(EffectLocation otherLocation)
public boolean intersectsLocation(EffectLocation otherLocation)
public boolean isEmpty()
 LocationSummary calculateLocationSummary(Node node)
public void visit(NodeTraversal t, Node n, Node parent)
private Set<Node> findStorageLocationReferences(Node root)
private int effectMaskForVariableReference(Node variableReference)
 EffectLocation getBottomLocation()
private static boolean isStorageNode(Node node)
private static boolean storageNodeIsRValue(Node node)
private static boolean storageNodeIsLValue(Node node)
public boolean intersectsLocation(EffectLocation otherLocation)
public boolean isEmpty()
public EffectLocation join(EffectLocation otherLocation)
public void mapUses(Node root)
public Node findDeclaringNameNodeForUse(Node usingNameNode)
