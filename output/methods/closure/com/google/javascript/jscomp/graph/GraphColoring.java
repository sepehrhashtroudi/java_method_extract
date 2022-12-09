public GraphColoring(AdjacencyGraph<N, E> graph) { [EOL]     this.graph = graph; [EOL] } <line_num>: 54,56
Color(int value) { [EOL]     this.value = value; [EOL] } <line_num>: 91,93
public GreedyGraphColoring(AdjacencyGraph<N, E> graph) { [EOL]     this(graph, null); [EOL] } <line_num>: 116,118
public GreedyGraphColoring(AdjacencyGraph<N, E> graph, Comparator<N> tieBreaker) { [EOL]     super(graph); [EOL]     this.tieBreaker = tieBreaker; [EOL] } <line_num>: 124,128
public abstract int color(); <line_num>: 64,64
public N getPartitionSuperNode(N node) { [EOL]     Preconditions.checkNotNull(colorToNodeMap, "No coloring founded. color() should be called first."); [EOL]     Color color = graph.getNode(node).getAnnotation(); [EOL]     N headNode = colorToNodeMap[color.value]; [EOL]     if (headNode == null) { [EOL]         colorToNodeMap[color.value] = node; [EOL]         return node; [EOL]     } else { [EOL]         return headNode; [EOL]     } [EOL] } <line_num>: 71,82
public AdjacencyGraph<N, E> getGraph() { [EOL]     return graph; [EOL] } <line_num>: 84,86
@Override [EOL] public boolean equals(Object other) { [EOL]     if (!(other instanceof Color)) { [EOL]         return false; [EOL]     } else { [EOL]         return value == ((Color) other).value; [EOL]     } [EOL] } <line_num>: 95,102
@Override [EOL] public int hashCode() { [EOL]     return value; [EOL] } <line_num>: 104,107
@Override [EOL] public int compare(GraphNode<N, E> o1, GraphNode<N, E> o2) { [EOL]     int result = graph.getWeight(o2.getValue()) - graph.getWeight(o1.getValue()); [EOL]     return result == 0 && tieBreaker != null ? tieBreaker.compare(o1.getValue(), o2.getValue()) : result; [EOL] } <line_num>: 137,143
@Override [EOL] public int color() { [EOL]     graph.clearNodeAnnotations(); [EOL]     List<GraphNode<N, E>> worklist = Lists.newArrayList(graph.getNodes()); [EOL]     Collections.sort(worklist, new Comparator<GraphNode<N, E>>() { [EOL]  [EOL]         @Override [EOL]         public int compare(GraphNode<N, E> o1, GraphNode<N, E> o2) { [EOL]             int result = graph.getWeight(o2.getValue()) - graph.getWeight(o1.getValue()); [EOL]             return result == 0 && tieBreaker != null ? tieBreaker.compare(o1.getValue(), o2.getValue()) : result; [EOL]         } [EOL]     }); [EOL]     int count = 0; [EOL]     do { [EOL]         Color color = new Color(count); [EOL]         SubGraph<N, E> subgraph = graph.newSubGraph(); [EOL]         for (Iterator<GraphNode<N, E>> i = worklist.iterator(); i.hasNext(); ) { [EOL]             GraphNode<N, E> node = i.next(); [EOL]             if (subgraph.isIndependentOf(node.getValue())) { [EOL]                 subgraph.addNode(node.getValue()); [EOL]                 node.setAnnotation(color); [EOL]                 i.remove(); [EOL]             } [EOL]         } [EOL]         count++; [EOL]     } while (!worklist.isEmpty()); [EOL]     @SuppressWarnings("unchecked") [EOL]     N[] map = (N[]) new Object[count]; [EOL]     colorToNodeMap = map; [EOL]     return count; [EOL] } <line_num>: 130,166