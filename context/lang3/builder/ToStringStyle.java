DefaultToStringStyle
NoFieldNameToStringStyle
ShortPrefixToStringStyle
SimpleToStringStyle
MultiLineToStringStyle
ToStringStyle
 static Map<Object, Object> getRegistry()
 static boolean isRegistered(final Object value)
 static void register(final Object value)
 static void unregister(final Object value)
public void appendSuper(final StringBuffer buffer, final String superToString)
public void appendToString(final StringBuffer buffer, final String toString)
public void appendStart(final StringBuffer buffer, final Object object)
public void appendEnd(final StringBuffer buffer, final Object object)
protected void removeLastFieldSeparator(final StringBuffer buffer)
public void append(final StringBuffer buffer, final String fieldName, final Object value, final Boolean fullDetail)
protected void appendInternal(final StringBuffer buffer, final String fieldName, final Object value, final boolean detail)
protected void appendCyclicObject(final StringBuffer buffer, final String fieldName, final Object value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Collection<?> coll)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Map<?, ?> map)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object value)
public void append(final StringBuffer buffer, final String fieldName, final long value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long value)
public void append(final StringBuffer buffer, final String fieldName, final int value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int value)
public void append(final StringBuffer buffer, final String fieldName, final short value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short value)
public void append(final StringBuffer buffer, final String fieldName, final byte value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte value)
public void append(final StringBuffer buffer, final String fieldName, final char value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char value)
public void append(final StringBuffer buffer, final String fieldName, final double value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double value)
public void append(final StringBuffer buffer, final String fieldName, final float value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float value)
public void append(final StringBuffer buffer, final String fieldName, final boolean value)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean value)
public void append(final StringBuffer buffer, final String fieldName, final Object[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object[] array)
protected void reflectionAppendArrayDetail(final StringBuffer buffer, final String fieldName, final Object array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object[] array)
public void append(final StringBuffer buffer, final String fieldName, final long[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final long[] array)
public void append(final StringBuffer buffer, final String fieldName, final int[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final int[] array)
public void append(final StringBuffer buffer, final String fieldName, final short[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final short[] array)
public void append(final StringBuffer buffer, final String fieldName, final byte[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final byte[] array)
public void append(final StringBuffer buffer, final String fieldName, final char[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final char[] array)
public void append(final StringBuffer buffer, final String fieldName, final double[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final double[] array)
public void append(final StringBuffer buffer, final String fieldName, final float[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final float[] array)
public void append(final StringBuffer buffer, final String fieldName, final boolean[] array, final Boolean fullDetail)
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean[] array)
protected void appendSummary(final StringBuffer buffer, final String fieldName, final boolean[] array)
protected void appendClassName(final StringBuffer buffer, final Object object)
protected void appendIdentityHashCode(final StringBuffer buffer, final Object object)
protected void appendContentStart(final StringBuffer buffer)
protected void appendContentEnd(final StringBuffer buffer)
protected void appendNullText(final StringBuffer buffer, final String fieldName)
protected void appendFieldSeparator(final StringBuffer buffer)
protected void appendFieldStart(final StringBuffer buffer, final String fieldName)
protected void appendFieldEnd(final StringBuffer buffer, final String fieldName)
protected void appendSummarySize(final StringBuffer buffer, final String fieldName, final int size)
protected boolean isFullDetail(final Boolean fullDetailRequest)
protected String getShortClassName(final Class<?> cls)
protected boolean isUseClassName()
protected void setUseClassName(final boolean useClassName)
protected boolean isUseShortClassName()
protected void setUseShortClassName(final boolean useShortClassName)
protected boolean isUseIdentityHashCode()
protected void setUseIdentityHashCode(final boolean useIdentityHashCode)
protected boolean isUseFieldNames()
protected void setUseFieldNames(final boolean useFieldNames)
protected boolean isDefaultFullDetail()
protected void setDefaultFullDetail(final boolean defaultFullDetail)
protected boolean isArrayContentDetail()
protected void setArrayContentDetail(final boolean arrayContentDetail)
protected String getArrayStart()
protected void setArrayStart(String arrayStart)
protected String getArrayEnd()
protected void setArrayEnd(String arrayEnd)
protected String getArraySeparator()
protected void setArraySeparator(String arraySeparator)
protected String getContentStart()
protected void setContentStart(String contentStart)
protected String getContentEnd()
protected void setContentEnd(String contentEnd)
protected String getFieldNameValueSeparator()
protected void setFieldNameValueSeparator(String fieldNameValueSeparator)
protected String getFieldSeparator()
protected void setFieldSeparator(String fieldSeparator)
protected boolean isFieldSeparatorAtStart()
protected void setFieldSeparatorAtStart(final boolean fieldSeparatorAtStart)
protected boolean isFieldSeparatorAtEnd()
protected void setFieldSeparatorAtEnd(final boolean fieldSeparatorAtEnd)
protected String getNullText()
protected void setNullText(String nullText)
protected String getSizeStartText()
protected void setSizeStartText(String sizeStartText)
protected String getSizeEndText()
protected void setSizeEndText(String sizeEndText)
protected String getSummaryObjectStartText()
protected void setSummaryObjectStartText(String summaryObjectStartText)
protected String getSummaryObjectEndText()
protected void setSummaryObjectEndText(String summaryObjectEndText)
private Object readResolve()
private Object readResolve()
private Object readResolve()
private Object readResolve()
private Object readResolve()
long serialVersionUID=Optional[-2587890625525655916L]
ToStringStyle DEFAULT_STYLE=Optional[new DefaultToStringStyle()]
ToStringStyle MULTI_LINE_STYLE=Optional[new MultiLineToStringStyle()]
ToStringStyle NO_FIELD_NAMES_STYLE=Optional[new NoFieldNameToStringStyle()]
ToStringStyle SHORT_PREFIX_STYLE=Optional[new ShortPrefixToStringStyle()]
ToStringStyle SIMPLE_STYLE=Optional[new SimpleToStringStyle()]
ThreadLocal<WeakHashMap<Object, Object>> REGISTRY=Optional[new ThreadLocal<WeakHashMap<Object, Object>>()]
boolean useFieldNames=Optional[true]
boolean useClassName=Optional[true]
boolean useShortClassName=Optional[false]
boolean useIdentityHashCode=Optional[true]
String contentStart=Optional["["]
String contentEnd=Optional["]"]
String fieldNameValueSeparator=Optional["="]
boolean fieldSeparatorAtStart=Optional[false]
boolean fieldSeparatorAtEnd=Optional[false]
String fieldSeparator=Optional[","]
String arrayStart=Optional["{"]
String arraySeparator=Optional[","]
boolean arrayContentDetail=Optional[true]
String arrayEnd=Optional["}"]
boolean defaultFullDetail=Optional[true]
String nullText=Optional["<null>"]
String sizeStartText=Optional["<size="]
String sizeEndText=Optional[">"]
String summaryObjectStartText=Optional["<"]
String summaryObjectEndText=Optional[">"]
