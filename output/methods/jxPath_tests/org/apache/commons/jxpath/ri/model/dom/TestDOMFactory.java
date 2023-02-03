public boolean createObject(JXPathContext context, Pointer pointer, Object parent, String name, int index) { [EOL]     if (name.equals("location") || name.equals("address") || name.equals("street")) { [EOL]         addDOMElement((Node) parent, index, name, null); [EOL]         return true; [EOL]     } [EOL]     if (name.startsWith("price:")) { [EOL]         String namespaceURI = context.getNamespaceURI("price"); [EOL]         addDOMElement((Node) parent, index, name, namespaceURI); [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 36,55
private void addDOMElement(Node parent, int index, String tag, String namespaceURI) { [EOL]     Node child = parent.getFirstChild(); [EOL]     int count = 0; [EOL]     while (child != null) { [EOL]         if (child.getNodeName().equals(tag)) { [EOL]             count++; [EOL]         } [EOL]         child = child.getNextSibling(); [EOL]     } [EOL]     while (count <= index) { [EOL]         Document doc = parent.getOwnerDocument(); [EOL]         Node newElement; [EOL]         if (namespaceURI == null) { [EOL]             newElement = doc.createElement(tag); [EOL]         } else { [EOL]             newElement = doc.createElementNS(namespaceURI, tag); [EOL]         } [EOL]         parent.appendChild(newElement); [EOL]         count++; [EOL]     } [EOL] } <line_num>: 57,81
public boolean declareVariable(JXPathContext context, String name) { [EOL]     return false; [EOL] } <line_num>: 83,85