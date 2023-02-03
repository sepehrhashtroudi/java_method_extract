public DescendantContext(EvalContext parentContext, boolean includeSelf, NodeTest nodeTest) { [EOL]     super(parentContext); [EOL]     this.includeSelf = includeSelf; [EOL]     this.nodeTest = nodeTest; [EOL] } <line_num>: 45,53
public boolean isChildOrderingRequired() { [EOL]     return true; [EOL] } <line_num>: 55,57
public NodePointer getCurrentNodePointer() { [EOL]     if (position == 0) { [EOL]         if (!setPosition(1)) { [EOL]             return null; [EOL]         } [EOL]     } [EOL]     return currentNodePointer; [EOL] } <line_num>: 59,66
public void reset() { [EOL]     super.reset(); [EOL]     setStarted = false; [EOL] } <line_num>: 68,71
public boolean setPosition(int position) { [EOL]     if (position < this.position) { [EOL]         reset(); [EOL]     } [EOL]     while (this.position < position) { [EOL]         if (!nextNode()) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 73,84
public boolean nextNode() { [EOL]     if (!setStarted) { [EOL]         setStarted = true; [EOL]         stack = new Stack(); [EOL]         currentNodePointer = parentContext.getCurrentNodePointer(); [EOL]         if (currentNodePointer != null) { [EOL]             if (!currentNodePointer.isLeaf()) { [EOL]                 stack.push(currentNodePointer.childIterator(ELEMENT_NODE_TEST, false, null)); [EOL]             } [EOL]             if (includeSelf) { [EOL]                 if (currentNodePointer.testNode(nodeTest)) { [EOL]                     position++; [EOL]                     return true; [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     while (!stack.isEmpty()) { [EOL]         NodeIterator it = (NodeIterator) stack.peek(); [EOL]         if (it.setPosition(it.getPosition() + 1)) { [EOL]             currentNodePointer = it.getNodePointer(); [EOL]             if (!isRecursive()) { [EOL]                 if (!currentNodePointer.isLeaf()) { [EOL]                     stack.push(currentNodePointer.childIterator(ELEMENT_NODE_TEST, false, null)); [EOL]                 } [EOL]                 if (currentNodePointer.testNode(nodeTest)) { [EOL]                     position++; [EOL]                     return true; [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             stack.pop(); [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 86,133
private boolean isRecursive() { [EOL]     Object node = currentNodePointer.getNode(); [EOL]     for (int i = stack.size() - 1; --i >= 0; ) { [EOL]         NodeIterator it = (NodeIterator) stack.get(i); [EOL]         Pointer pointer = it.getNodePointer(); [EOL]         if (pointer != null && pointer.getNode() == node) { [EOL]             return true; [EOL]         } [EOL]     } [EOL]     return false; [EOL] } <line_num>: 139,149
