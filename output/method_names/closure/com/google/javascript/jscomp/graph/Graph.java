public AnnotationState(Annotatable annotatable, Annotation annotation)
public GraphAnnotationState(int size)
 SimpleSubGraph(Graph<N, E> graph)
public abstract void connect(N n1, E edge, N n2)
public abstract void disconnect(N n1, N n2)
public final void connectIfNotFound(N n1, E edge, N n2)
public abstract GraphNode<N, E> createNode(N value)
public abstract Collection<GraphNode<N, E>> getNodes()
public abstract List<GraphEdge<N, E>> getEdges()
public abstract int getNodeDegree(N value)
public int getWeight(N value)
public abstract List<GraphNode<N, E>> getNeighborNodes(N value)
public abstract Iterator<GraphNode<N, E>> getNeighborNodesIterator(N value)
public abstract List<GraphEdge<N, E>> getEdges(N n1, N n2)
public abstract GraphEdge<N, E> getFirstEdge(N n1, N n2)
public final boolean hasNode(N n)
public abstract boolean isConnected(N n1, N n2)
public abstract boolean isConnected(N n1, E e, N n2)
 T getNodeOrFail(N val)
public final void clearNodeAnnotations()
public final void clearEdgeAnnotations()
public final void pushNodeAnnotations()
public final void popNodeAnnotations()
public final void pushEdgeAnnotations()
public final void popEdgeAnnotations()
 E getValue()
 GraphNode<N, E> getNodeA()
 GraphNode<N, E> getNodeB()
public boolean isIndependentOf(N value)
public void addNode(N value)
private static void pushAnnotations(Deque<GraphAnnotationState> stack, Collection<? extends Annotatable> haveAnnotations)
private static void popAnnotations(Deque<GraphAnnotationState> stack)
