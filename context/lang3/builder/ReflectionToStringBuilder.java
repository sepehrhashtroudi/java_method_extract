ReflectionToStringBuilder
public static String toString(final Object object)
public static String toString(final Object object, final ToStringStyle style)
public static String toString(final Object object, final ToStringStyle style, final boolean outputTransients)
public static String toString(final Object object, final ToStringStyle style, final boolean outputTransients, final boolean outputStatics)
public static String toString(final T object, final ToStringStyle style, final boolean outputTransients, final boolean outputStatics, final Class<? super T> reflectUpToClass)
public static String toStringExclude(final Object object, final Collection<String> excludeFieldNames)
 static String[] toNoNullStringArray(final Collection<String> collection)
 static String[] toNoNullStringArray(final Object[] array)
public static String toStringExclude(final Object object, final String... excludeFieldNames)
protected boolean accept(final Field field)
protected void appendFieldsIn(final Class<?> clazz)
public String[] getExcludeFieldNames()
public Class<?> getUpToClass()
protected Object getValue(final Field field) throws IllegalArgumentException, IllegalAccessException
public boolean isAppendStatics()
public boolean isAppendTransients()
public ReflectionToStringBuilder reflectionAppendArray(final Object array)
public void setAppendStatics(final boolean appendStatics)
public void setAppendTransients(final boolean appendTransients)
public ReflectionToStringBuilder setExcludeFieldNames(final String... excludeFieldNamesParam)
public void setUpToClass(final Class<?> clazz)
public String toString()
boolean appendStatics=Optional[false]
boolean appendTransients=Optional[false]
String[] excludeFieldNames
Class<?> upToClass=Optional[null]
