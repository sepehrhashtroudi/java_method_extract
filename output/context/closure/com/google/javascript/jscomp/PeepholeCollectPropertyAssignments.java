 Node optimizeSubtree(Node subtree)
private Node getName(Node n)
private Node getValue(Node n)
 boolean isInterestingValue(Node n)
private boolean isPropertyAssignmentToName(Node propertyCandidate)
private boolean collectProperty(Node propertyCandidate, String name, Node value)
private boolean collectArrayProperty(Node arrayLiteral, Node propertyCandidate)
private boolean collectObjectProperty(Node objectLiteral, Node propertyCandidate)
private static boolean mightContainForwardReference(Node node, String varName)
