public CollectionPointer(Object collection, Locale locale) { [EOL]     super(null, locale); [EOL]     this.collection = collection; [EOL] } <line_num>: 42,45
public CollectionPointer(NodePointer parent, Object collection) { [EOL]     super(parent); [EOL]     this.collection = collection; [EOL] } <line_num>: 47,50
public QName getName() { [EOL]     return null; [EOL] } <line_num>: 52,54
public Object getBaseValue() { [EOL]     return collection; [EOL] } <line_num>: 56,58
public boolean isCollection() { [EOL]     return true; [EOL] } <line_num>: 60,62
public int getLength() { [EOL]     return ValueUtils.getLength(getBaseValue()); [EOL] } <line_num>: 64,66
public boolean isLeaf() { [EOL]     Object value = getNode(); [EOL]     return value == null || JXPathIntrospector.getBeanInfo(value.getClass()).isAtomic(); [EOL] } <line_num>: 68,72
public boolean isContainer() { [EOL]     return index != WHOLE_COLLECTION; [EOL] } <line_num>: 74,76
public Object getImmediateNode() { [EOL]     if (index != WHOLE_COLLECTION) { [EOL]         return ValueUtils.getValue(collection, index); [EOL]     } else { [EOL]         return ValueUtils.getValue(collection); [EOL]     } [EOL] } <line_num>: 78,85
public void setValue(Object value) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         parent.setValue(value); [EOL]     } else { [EOL]         ValueUtils.setValue(collection, index, value); [EOL]     } [EOL] } <line_num>: 87,94
public void setIndex(int index) { [EOL]     super.setIndex(index); [EOL]     valuePointer = null; [EOL] } <line_num>: 96,99
public NodePointer getValuePointer() { [EOL]     if (valuePointer == null) { [EOL]         if (index == WHOLE_COLLECTION) { [EOL]             valuePointer = this; [EOL]         } else { [EOL]             Object value = getImmediateNode(); [EOL]             valuePointer = NodePointer.newChildNodePointer(this, getName(), value); [EOL]         } [EOL]     } [EOL]     return valuePointer; [EOL] } <line_num>: 101,113
public NodePointer createPath(JXPathContext context) { [EOL]     Object collection = getBaseValue(); [EOL]     if (ValueUtils.getLength(collection) <= index) { [EOL]         collection = ValueUtils.expandCollection(getNode(), index + 1); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 115,121
public NodePointer createPath(JXPathContext context, Object value) { [EOL]     NodePointer ptr = createPath(context); [EOL]     ptr.setValue(value); [EOL]     return ptr; [EOL] } <line_num>: 123,127
public NodePointer createChild(JXPathContext context, QName name, int index, Object value) { [EOL]     NodePointer ptr = (NodePointer) clone(); [EOL]     ptr.setIndex(index); [EOL]     return ptr.createPath(context, value); [EOL] } <line_num>: 129,138
public NodePointer createChild(JXPathContext context, QName name, int index) { [EOL]     NodePointer ptr = (NodePointer) clone(); [EOL]     ptr.setIndex(index); [EOL]     return ptr.createPath(context); [EOL] } <line_num>: 140,148
public int hashCode() { [EOL]     return System.identityHashCode(collection) + index; [EOL] } <line_num>: 150,152
public boolean equals(Object object) { [EOL]     if (object == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(object instanceof CollectionPointer)) { [EOL]         return false; [EOL]     } [EOL]     CollectionPointer other = (CollectionPointer) object; [EOL]     return collection == other.collection && index == other.index; [EOL] } <line_num>: 154,165
public NodeIterator childIterator(NodeTest test, boolean reverse, NodePointer startWith) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         return new CollectionChildNodeIterator(this, test, reverse, startWith); [EOL]     } else { [EOL]         return getValuePointer().childIterator(test, reverse, startWith); [EOL]     } [EOL] } <line_num>: 167,180
public NodeIterator attributeIterator(QName name) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         return new CollectionAttributeNodeIterator(this, name); [EOL]     } [EOL]     return getValuePointer().attributeIterator(name); [EOL] } <line_num>: 182,187
public NodeIterator namespaceIterator() { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         return null; [EOL]     } [EOL]     return getValuePointer().namespaceIterator(); [EOL] } <line_num>: 189,194
public NodePointer namespacePointer(String namespace) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         return null; [EOL]     } [EOL]     return getValuePointer().namespacePointer(namespace); [EOL] } <line_num>: 196,201
public boolean testNode(NodeTest test) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         if (test == null) { [EOL]             return true; [EOL]         } else if (test instanceof NodeNameTest) { [EOL]             return false; [EOL]         } else if (test instanceof NodeTypeTest) { [EOL]             if (((NodeTypeTest) test).getNodeType() == Compiler.NODE_TYPE_NODE) { [EOL]                 return true; [EOL]             } [EOL]         } [EOL]         return false; [EOL]     } [EOL]     return getValuePointer().testNode(test); [EOL] } <line_num>: 203,219
public int compareChildNodePointers(NodePointer pointer1, NodePointer pointer2) { [EOL]     return pointer1.getIndex() - pointer2.getIndex(); [EOL] } <line_num>: 221,225
public String asPath() { [EOL]     StringBuffer buffer = new StringBuffer(); [EOL]     NodePointer parent = getImmediateParentPointer(); [EOL]     if (parent != null) { [EOL]         buffer.append(parent.asPath()); [EOL]         if (index != WHOLE_COLLECTION) { [EOL]             if (parent.getIndex() != WHOLE_COLLECTION) { [EOL]                 buffer.append("/."); [EOL]             } [EOL]             buffer.append("[").append(index + 1).append(']'); [EOL]         } [EOL]     } else { [EOL]         if (index != WHOLE_COLLECTION) { [EOL]             buffer.append("/.[").append(index + 1).append(']'); [EOL]         } else { [EOL]             buffer.append("/"); [EOL]         } [EOL]     } [EOL]     return buffer.toString(); [EOL] } <line_num>: 230,253
