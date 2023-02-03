public DynamicPropertyPointer(NodePointer parent, DynamicPropertyHandler handler) { [EOL]     super(parent); [EOL]     this.handler = handler; [EOL] } <line_num>: 47,53
public boolean isContainer() { [EOL]     return true; [EOL] } <line_num>: 57,59
public int getPropertyCount() { [EOL]     return getPropertyNames().length; [EOL] } <line_num>: 64,66
public String[] getPropertyNames() { [EOL]     if (names == null) { [EOL]         String[] allNames = handler.getPropertyNames(getBean()); [EOL]         names = new String[allNames.length]; [EOL]         for (int i = 0; i < names.length; i++) { [EOL]             names[i] = allNames[i]; [EOL]         } [EOL]         Arrays.sort(names); [EOL]         if (requiredPropertyName != null) { [EOL]             int inx = Arrays.binarySearch(names, requiredPropertyName); [EOL]             if (inx < 0) { [EOL]                 allNames = names; [EOL]                 names = new String[allNames.length + 1]; [EOL]                 names[0] = requiredPropertyName; [EOL]                 System.arraycopy(allNames, 0, names, 1, allNames.length); [EOL]                 Arrays.sort(names); [EOL]             } [EOL]         } [EOL]     } [EOL]     return names; [EOL] } <line_num>: 71,91
public String getPropertyName() { [EOL]     if (name == null) { [EOL]         String[] names = getPropertyNames(); [EOL]         if (propertyIndex >= 0 && propertyIndex < names.length) { [EOL]             name = names[propertyIndex]; [EOL]         } else { [EOL]             name = "*"; [EOL]         } [EOL]     } [EOL]     return name; [EOL] } <line_num>: 97,108
public void setPropertyName(String propertyName) { [EOL]     setPropertyIndex(UNSPECIFIED_PROPERTY); [EOL]     this.name = propertyName; [EOL]     requiredPropertyName = propertyName; [EOL]     if (names != null && Arrays.binarySearch(names, propertyName) < 0) { [EOL]         names = null; [EOL]     } [EOL] } <line_num>: 117,124
public int getPropertyIndex() { [EOL]     if (propertyIndex == UNSPECIFIED_PROPERTY) { [EOL]         String[] names = getPropertyNames(); [EOL]         for (int i = 0; i < names.length; i++) { [EOL]             if (names[i].equals(name)) { [EOL]                 setPropertyIndex(i); [EOL]                 break; [EOL]             } [EOL]         } [EOL]     } [EOL]     return super.getPropertyIndex(); [EOL] } <line_num>: 130,141
public void setPropertyIndex(int index) { [EOL]     if (propertyIndex != index) { [EOL]         super.setPropertyIndex(index); [EOL]         name = null; [EOL]     } [EOL] } <line_num>: 147,152
public Object getBaseValue() { [EOL]     return handler.getProperty(getBean(), getPropertyName()); [EOL] } <line_num>: 158,160
public Object getImmediateNode() { [EOL]     Object value; [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         value = ValueUtils.getValue(handler.getProperty(getBean(), getPropertyName())); [EOL]     } else { [EOL]         value = ValueUtils.getValue(handler.getProperty(getBean(), getPropertyName()), index); [EOL]     } [EOL]     return value; [EOL] } <line_num>: 168,181
protected boolean isActualProperty() { [EOL]     return true; [EOL] } <line_num>: 187,189
public void setValue(Object value) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         handler.setProperty(getBean(), getPropertyName(), value); [EOL]     } else { [EOL]         ValueUtils.setValue(handler.getProperty(getBean(), getPropertyName()), index, value); [EOL]     } [EOL] } <line_num>: 196,206
public NodePointer createPath(JXPathContext context) { [EOL]     Object collection = getBaseValue(); [EOL]     if (collection == null) { [EOL]         AbstractFactory factory = getAbstractFactory(context); [EOL]         boolean success = factory.createObject(context, this, getBean(), getPropertyName(), 0); [EOL]         if (!success) { [EOL]             throw new JXPathAbstractFactoryException("Factory could not create an object for path: " + asPath()); [EOL]         } [EOL]         collection = getBaseValue(); [EOL]     } [EOL]     if (index != WHOLE_COLLECTION) { [EOL]         if (index < 0) { [EOL]             throw new JXPathInvalidAccessException("Index is less than 1: " + asPath()); [EOL]         } [EOL]         if (index >= getLength()) { [EOL]             collection = ValueUtils.expandCollection(collection, index + 1); [EOL]             handler.setProperty(getBean(), getPropertyName(), collection); [EOL]         } [EOL]     } [EOL]     return this; [EOL] } <line_num>: 208,240
public NodePointer createPath(JXPathContext context, Object value) { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         handler.setProperty(getBean(), getPropertyName(), value); [EOL]     } else { [EOL]         createPath(context); [EOL]         ValueUtils.setValue(getBaseValue(), index, value); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 242,251
public void remove() { [EOL]     if (index == WHOLE_COLLECTION) { [EOL]         removeKey(); [EOL]     } else if (isCollection()) { [EOL]         Object collection = ValueUtils.remove(getBaseValue(), index); [EOL]         handler.setProperty(getBean(), getPropertyName(), collection); [EOL]     } else if (index == 0) { [EOL]         removeKey(); [EOL]     } [EOL] } <line_num>: 253,264
private void removeKey() { [EOL]     Object bean = getBean(); [EOL]     if (bean instanceof Map) { [EOL]         ((Map) bean).remove(getPropertyName()); [EOL]     } else { [EOL]         handler.setProperty(bean, getPropertyName(), null); [EOL]     } [EOL] } <line_num>: 266,274
public String asPath() { [EOL]     StringBuffer buffer = new StringBuffer(); [EOL]     buffer.append(getImmediateParentPointer().asPath()); [EOL]     if (buffer.length() == 0) { [EOL]         buffer.append("/."); [EOL]     } else if (buffer.charAt(buffer.length() - 1) == '/') { [EOL]         buffer.append('.'); [EOL]     } [EOL]     buffer.append("[@name='"); [EOL]     buffer.append(escape(getPropertyName())); [EOL]     buffer.append("']"); [EOL]     if (index != WHOLE_COLLECTION && isCollection()) { [EOL]         buffer.append('[').append(index + 1).append(']'); [EOL]     } [EOL]     return buffer.toString(); [EOL] } <line_num>: 276,292
private String escape(String string) { [EOL]     int index = string.indexOf('\''); [EOL]     while (index != -1) { [EOL]         string = string.substring(0, index) + "&apos;" + string.substring(index + 1); [EOL]         index = string.indexOf('\''); [EOL]     } [EOL]     index = string.indexOf('\"'); [EOL]     while (index != -1) { [EOL]         string = string.substring(0, index) + "&quot;" + string.substring(index + 1); [EOL]         index = string.indexOf('\"'); [EOL]     } [EOL]     return string; [EOL] } <line_num>: 294,312
private AbstractFactory getAbstractFactory(JXPathContext context) { [EOL]     AbstractFactory factory = context.getFactory(); [EOL]     if (factory == null) { [EOL]         throw new JXPathException("Factory is not set on the JXPathContext - cannot create path: " + asPath()); [EOL]     } [EOL]     return factory; [EOL] } <line_num>: 314,322