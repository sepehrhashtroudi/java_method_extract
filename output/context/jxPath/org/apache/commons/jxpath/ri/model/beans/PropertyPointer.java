public PropertyPointer(NodePointer parent)
public int getPropertyIndex()
public void setPropertyIndex(int index)
public Object getBean()
public QName getName()
public abstract String getPropertyName()
public abstract void setPropertyName(String propertyName)
public abstract int getPropertyCount()
public abstract String[] getPropertyNames()
protected abstract boolean isActualProperty()
public boolean isActual()
public Object getImmediateNode()
public boolean isCollection()
public boolean isLeaf()
public int getLength()
public NodePointer getImmediateValuePointer()
public NodePointer createPath(JXPathContext context)
public NodePointer createPath(JXPathContext context, Object value)
public NodePointer createChild(JXPathContext context, QName name, int index, Object value)
public NodePointer createChild(JXPathContext context, QName name, int index)
public int hashCode()
public boolean equals(Object object)
public int compareChildNodePointers(NodePointer pointer1, NodePointer pointer2)
private AbstractFactory getAbstractFactory(JXPathContext context)
int UNSPECIFIED_PROPERTY=Optional[Integer.MIN_VALUE]
int propertyIndex=Optional[UNSPECIFIED_PROPERTY]
Object bean
Object UNINITIALIZED=Optional[new Object()]
Object value=Optional[UNINITIALIZED]
