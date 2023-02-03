public NullPropertyPointer(NodePointer parent) { [EOL]     super(parent); [EOL] } <line_num>: 35,37
public QName getName() { [EOL]     return new QName(propertyName); [EOL] } <line_num>: 39,41
public void setPropertyIndex(int index) { [EOL] } <line_num>: 43,44
public int getLength() { [EOL]     return 0; [EOL] } <line_num>: 46,48
public Object getBaseValue() { [EOL]     return null; [EOL] } <line_num>: 50,52
public Object getImmediateNode() { [EOL]     return null; [EOL] } <line_num>: 54,56
public boolean isLeaf() { [EOL]     return true; [EOL] } <line_num>: 58,60
public NodePointer getValuePointer() { [EOL]     return new NullPointer(this, new QName(getPropertyName())); [EOL] } <line_num>: 62,64
protected boolean isActualProperty() { [EOL]     return false; [EOL] } <line_num>: 66,68
public boolean isActual() { [EOL]     return false; [EOL] } <line_num>: 70,72
public boolean isContainer() { [EOL]     return true; [EOL] } <line_num>: 74,76
public void setValue(Object value) { [EOL]     if (parent == null || parent.isContainer()) { [EOL]         throw new JXPathInvalidAccessException("Cannot set property " + asPath() + ", the target object is null"); [EOL]     } else if (parent instanceof PropertyOwnerPointer && ((PropertyOwnerPointer) parent).isDynamicPropertyDeclarationSupported()) { [EOL]         PropertyPointer propertyPointer = ((PropertyOwnerPointer) parent).getPropertyPointer(); [EOL]         propertyPointer.setPropertyName(propertyName); [EOL]         propertyPointer.setValue(value); [EOL]     } else { [EOL]         throw new JXPathInvalidAccessException("Cannot set property " + asPath() + ", path does not match a changeable location"); [EOL]     } [EOL] } <line_num>: 78,101
public NodePointer createPath(JXPathContext context) { [EOL]     NodePointer newParent = parent.createPath(context); [EOL]     if (isAttribute()) { [EOL]         return newParent.createAttribute(context, getName()); [EOL]     } else { [EOL]         if (newParent instanceof PropertyOwnerPointer) { [EOL]             PropertyOwnerPointer pop = (PropertyOwnerPointer) newParent; [EOL]             newParent = pop.getPropertyPointer(); [EOL]         } [EOL]         return newParent.createChild(context, getName(), getIndex()); [EOL]     } [EOL] } <line_num>: 103,128
public NodePointer createPath(JXPathContext context, Object value) { [EOL]     NodePointer newParent = parent.createPath(context); [EOL]     if (isAttribute()) { [EOL]         NodePointer pointer = newParent.createAttribute(context, getName()); [EOL]         pointer.setValue(value); [EOL]         return pointer; [EOL]     } else { [EOL]         if (newParent instanceof PropertyOwnerPointer) { [EOL]             PropertyOwnerPointer pop = (PropertyOwnerPointer) newParent; [EOL]             newParent = pop.getPropertyPointer(); [EOL]         } [EOL]         return newParent.createChild(context, getName(), index, value); [EOL]     } [EOL] } <line_num>: 130,144
public NodePointer createChild(JXPathContext context, QName name, int index) { [EOL]     return createPath(context).createChild(context, name, index); [EOL] } <line_num>: 146,152
public NodePointer createChild(JXPathContext context, QName name, int index, Object value) { [EOL]     return createPath(context).createChild(context, name, index, value); [EOL] } <line_num>: 154,161
public String getPropertyName() { [EOL]     return propertyName; [EOL] } <line_num>: 163,165
public void setPropertyName(String propertyName) { [EOL]     this.propertyName = propertyName; [EOL] } <line_num>: 167,169
public void setNameAttributeValue(String attributeValue) { [EOL]     this.propertyName = attributeValue; [EOL]     byNameAttribute = true; [EOL] } <line_num>: 171,174
public boolean isCollection() { [EOL]     return getIndex() != WHOLE_COLLECTION; [EOL] } <line_num>: 176,178
public int getPropertyCount() { [EOL]     return 0; [EOL] } <line_num>: 180,182
public String[] getPropertyNames() { [EOL]     return new String[0]; [EOL] } <line_num>: 184,186
public String asPath() { [EOL]     if (!byNameAttribute) { [EOL]         return super.asPath(); [EOL]     } else { [EOL]         StringBuffer buffer = new StringBuffer(); [EOL]         buffer.append(getImmediateParentPointer().asPath()); [EOL]         buffer.append("[@name='"); [EOL]         buffer.append(escape(getPropertyName())); [EOL]         buffer.append("']"); [EOL]         if (index != WHOLE_COLLECTION) { [EOL]             buffer.append('[').append(index + 1).append(']'); [EOL]         } [EOL]         return buffer.toString(); [EOL]     } [EOL] } <line_num>: 188,203
private String escape(String string) { [EOL]     int index = string.indexOf('\''); [EOL]     while (index != -1) { [EOL]         string = string.substring(0, index) + "&apos;" + string.substring(index + 1); [EOL]         index = string.indexOf('\''); [EOL]     } [EOL]     index = string.indexOf('\"'); [EOL]     while (index != -1) { [EOL]         string = string.substring(0, index) + "&quot;" + string.substring(index + 1); [EOL]         index = string.indexOf('\"'); [EOL]     } [EOL]     return string; [EOL] } <line_num>: 205,223
