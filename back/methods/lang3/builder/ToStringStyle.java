static Map<Object, Object> getRegistry() { [EOL]     return REGISTRY.get(); [EOL] }
static boolean isRegistered(final Object value) { [EOL]     final Map<Object, Object> m = getRegistry(); [EOL]     return m != null && m.containsKey(value); [EOL] }
static void register(final Object value) { [EOL]     if (value != null) { [EOL]         final Map<Object, Object> m = getRegistry(); [EOL]         if (m == null) { [EOL]             REGISTRY.set(new WeakHashMap<Object, Object>()); [EOL]         } [EOL]         getRegistry().put(value, null); [EOL]     } [EOL] }
static void unregister(final Object value) { [EOL]     if (value != null) { [EOL]         final Map<Object, Object> m = getRegistry(); [EOL]         if (m != null) { [EOL]             m.remove(value); [EOL]             if (m.isEmpty()) { [EOL]                 REGISTRY.remove(); [EOL]             } [EOL]         } [EOL]     } [EOL] }
public void appendSuper(final StringBuffer buffer, final String superToString) { [EOL]     appendToString(buffer, superToString); [EOL] }
public void appendToString(final StringBuffer buffer, final String toString) { [EOL]     if (toString != null) { [EOL]         final int pos1 = toString.indexOf(contentStart) + contentStart.length(); [EOL]         final int pos2 = toString.lastIndexOf(contentEnd); [EOL]         if (pos1 != pos2 && pos1 >= 0 && pos2 >= 0) { [EOL]             final String data = toString.substring(pos1, pos2); [EOL]             if (fieldSeparatorAtStart) { [EOL]                 removeLastFieldSeparator(buffer); [EOL]             } [EOL]             buffer.append(data); [EOL]             appendFieldSeparator(buffer); [EOL]         } [EOL]     } [EOL] }
public void appendStart(final StringBuffer buffer, final Object object) { [EOL]     if (object != null) { [EOL]         appendClassName(buffer, object); [EOL]         appendIdentityHashCode(buffer, object); [EOL]         appendContentStart(buffer); [EOL]         if (fieldSeparatorAtStart) { [EOL]             appendFieldSeparator(buffer); [EOL]         } [EOL]     } [EOL] }
public void appendEnd(final StringBuffer buffer, final Object object) { [EOL]     if (this.fieldSeparatorAtEnd == false) { [EOL]         removeLastFieldSeparator(buffer); [EOL]     } [EOL]     appendContentEnd(buffer); [EOL]     unregister(object); [EOL] }
protected void removeLastFieldSeparator(final StringBuffer buffer) { [EOL]     final int len = buffer.length(); [EOL]     final int sepLen = fieldSeparator.length(); [EOL]     if (len > 0 && sepLen > 0 && len >= sepLen) { [EOL]         boolean match = true; [EOL]         for (int i = 0; i < sepLen; i++) { [EOL]             if (buffer.charAt(len - 1 - i) != fieldSeparator.charAt(sepLen - 1 - i)) { [EOL]                 match = false; [EOL]                 break; [EOL]             } [EOL]         } [EOL]         if (match) { [EOL]             buffer.setLength(len - sepLen); [EOL]         } [EOL]     } [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final Object value, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (value == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else { [EOL]         appendInternal(buffer, fieldName, value, isFullDetail(fullDetail)); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendInternal(final StringBuffer buffer, final String fieldName, final Object value, final boolean detail) { [EOL]     if (isRegistered(value) && !(value instanceof Number || value instanceof Boolean || value instanceof Character)) { [EOL]         appendCyclicObject(buffer, fieldName, value); [EOL]         return; [EOL]     } [EOL]     register(value); [EOL]     try { [EOL]         if (value instanceof Collection<?>) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Collection<?>) value); [EOL]             } else { [EOL]                 appendSummarySize(buffer, fieldName, ((Collection<?>) value).size()); [EOL]             } [EOL]         } else if (value instanceof Map<?, ?>) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Map<?, ?>) value); [EOL]             } else { [EOL]                 appendSummarySize(buffer, fieldName, ((Map<?, ?>) value).size()); [EOL]             } [EOL]         } else if (value instanceof long[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (long[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (long[]) value); [EOL]             } [EOL]         } else if (value instanceof int[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (int[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (int[]) value); [EOL]             } [EOL]         } else if (value instanceof short[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (short[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (short[]) value); [EOL]             } [EOL]         } else if (value instanceof byte[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (byte[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (byte[]) value); [EOL]             } [EOL]         } else if (value instanceof char[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (char[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (char[]) value); [EOL]             } [EOL]         } else if (value instanceof double[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (double[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (double[]) value); [EOL]             } [EOL]         } else if (value instanceof float[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (float[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (float[]) value); [EOL]             } [EOL]         } else if (value instanceof boolean[]) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (boolean[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (boolean[]) value); [EOL]             } [EOL]         } else if (value.getClass().isArray()) { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, (Object[]) value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, (Object[]) value); [EOL]             } [EOL]         } else { [EOL]             if (detail) { [EOL]                 appendDetail(buffer, fieldName, value); [EOL]             } else { [EOL]                 appendSummary(buffer, fieldName, value); [EOL]             } [EOL]         } [EOL]     } finally { [EOL]         unregister(value); [EOL]     } [EOL] }
protected void appendCyclicObject(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     ObjectUtils.identityToString(buffer, value); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     buffer.append(value); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Collection<?> coll) { [EOL]     buffer.append(coll); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Map<?, ?> map) { [EOL]     buffer.append(map); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object value) { [EOL]     buffer.append(summaryObjectStartText); [EOL]     buffer.append(getShortClassName(value.getClass())); [EOL]     buffer.append(summaryObjectEndText); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final long value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final int value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final short value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final byte value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final char value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final double value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final float value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final boolean value) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     appendDetail(buffer, fieldName, value); [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean value) { [EOL]     buffer.append(value); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final Object[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final Object[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         final Object item = array[i]; [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         if (item == null) { [EOL]             appendNullText(buffer, fieldName); [EOL]         } else { [EOL]             appendInternal(buffer, fieldName, item, arrayContentDetail); [EOL]         } [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void reflectionAppendArrayDetail(final StringBuffer buffer, final String fieldName, final Object array) { [EOL]     buffer.append(arrayStart); [EOL]     final int length = Array.getLength(array); [EOL]     for (int i = 0; i < length; i++) { [EOL]         final Object item = Array.get(array, i); [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         if (item == null) { [EOL]             appendNullText(buffer, fieldName); [EOL]         } else { [EOL]             appendInternal(buffer, fieldName, item, arrayContentDetail); [EOL]         } [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final Object[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final long[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final long[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final long[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final int[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final int[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final int[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final short[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final short[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final short[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final byte[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final byte[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final byte[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final char[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final char[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final char[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final double[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final double[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final double[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final float[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final float[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final float[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
public void append(final StringBuffer buffer, final String fieldName, final boolean[] array, final Boolean fullDetail) { [EOL]     appendFieldStart(buffer, fieldName); [EOL]     if (array == null) { [EOL]         appendNullText(buffer, fieldName); [EOL]     } else if (isFullDetail(fullDetail)) { [EOL]         appendDetail(buffer, fieldName, array); [EOL]     } else { [EOL]         appendSummary(buffer, fieldName, array); [EOL]     } [EOL]     appendFieldEnd(buffer, fieldName); [EOL] }
protected void appendDetail(final StringBuffer buffer, final String fieldName, final boolean[] array) { [EOL]     buffer.append(arrayStart); [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         if (i > 0) { [EOL]             buffer.append(arraySeparator); [EOL]         } [EOL]         appendDetail(buffer, fieldName, array[i]); [EOL]     } [EOL]     buffer.append(arrayEnd); [EOL] }
protected void appendSummary(final StringBuffer buffer, final String fieldName, final boolean[] array) { [EOL]     appendSummarySize(buffer, fieldName, array.length); [EOL] }
protected void appendClassName(final StringBuffer buffer, final Object object) { [EOL]     if (useClassName && object != null) { [EOL]         register(object); [EOL]         if (useShortClassName) { [EOL]             buffer.append(getShortClassName(object.getClass())); [EOL]         } else { [EOL]             buffer.append(object.getClass().getName()); [EOL]         } [EOL]     } [EOL] }
protected void appendIdentityHashCode(final StringBuffer buffer, final Object object) { [EOL]     if (this.isUseIdentityHashCode() && object != null) { [EOL]         register(object); [EOL]         buffer.append('@'); [EOL]         buffer.append(Integer.toHexString(System.identityHashCode(object))); [EOL]     } [EOL] }
protected void appendContentStart(final StringBuffer buffer) { [EOL]     buffer.append(contentStart); [EOL] }
protected void appendContentEnd(final StringBuffer buffer) { [EOL]     buffer.append(contentEnd); [EOL] }
protected void appendNullText(final StringBuffer buffer, final String fieldName) { [EOL]     buffer.append(nullText); [EOL] }
protected void appendFieldSeparator(final StringBuffer buffer) { [EOL]     buffer.append(fieldSeparator); [EOL] }
protected void appendFieldStart(final StringBuffer buffer, final String fieldName) { [EOL]     if (useFieldNames && fieldName != null) { [EOL]         buffer.append(fieldName); [EOL]         buffer.append(fieldNameValueSeparator); [EOL]     } [EOL] }
protected void appendFieldEnd(final StringBuffer buffer, final String fieldName) { [EOL]     appendFieldSeparator(buffer); [EOL] }
protected void appendSummarySize(final StringBuffer buffer, final String fieldName, final int size) { [EOL]     buffer.append(sizeStartText); [EOL]     buffer.append(size); [EOL]     buffer.append(sizeEndText); [EOL] }
protected boolean isFullDetail(final Boolean fullDetailRequest) { [EOL]     if (fullDetailRequest == null) { [EOL]         return defaultFullDetail; [EOL]     } [EOL]     return fullDetailRequest.booleanValue(); [EOL] }
protected String getShortClassName(final Class<?> cls) { [EOL]     return ClassUtils.getShortClassName(cls); [EOL] }
protected boolean isUseClassName() { [EOL]     return useClassName; [EOL] }
protected void setUseClassName(final boolean useClassName) { [EOL]     this.useClassName = useClassName; [EOL] }
protected boolean isUseShortClassName() { [EOL]     return useShortClassName; [EOL] }
protected void setUseShortClassName(final boolean useShortClassName) { [EOL]     this.useShortClassName = useShortClassName; [EOL] }
protected boolean isUseIdentityHashCode() { [EOL]     return useIdentityHashCode; [EOL] }
protected void setUseIdentityHashCode(final boolean useIdentityHashCode) { [EOL]     this.useIdentityHashCode = useIdentityHashCode; [EOL] }
protected boolean isUseFieldNames() { [EOL]     return useFieldNames; [EOL] }
protected void setUseFieldNames(final boolean useFieldNames) { [EOL]     this.useFieldNames = useFieldNames; [EOL] }
protected boolean isDefaultFullDetail() { [EOL]     return defaultFullDetail; [EOL] }
protected void setDefaultFullDetail(final boolean defaultFullDetail) { [EOL]     this.defaultFullDetail = defaultFullDetail; [EOL] }
protected boolean isArrayContentDetail() { [EOL]     return arrayContentDetail; [EOL] }
protected void setArrayContentDetail(final boolean arrayContentDetail) { [EOL]     this.arrayContentDetail = arrayContentDetail; [EOL] }
protected String getArrayStart() { [EOL]     return arrayStart; [EOL] }
protected void setArrayStart(String arrayStart) { [EOL]     if (arrayStart == null) { [EOL]         arrayStart = ""; [EOL]     } [EOL]     this.arrayStart = arrayStart; [EOL] }
protected String getArrayEnd() { [EOL]     return arrayEnd; [EOL] }
protected void setArrayEnd(String arrayEnd) { [EOL]     if (arrayEnd == null) { [EOL]         arrayEnd = ""; [EOL]     } [EOL]     this.arrayEnd = arrayEnd; [EOL] }
protected String getArraySeparator() { [EOL]     return arraySeparator; [EOL] }
protected void setArraySeparator(String arraySeparator) { [EOL]     if (arraySeparator == null) { [EOL]         arraySeparator = ""; [EOL]     } [EOL]     this.arraySeparator = arraySeparator; [EOL] }
protected String getContentStart() { [EOL]     return contentStart; [EOL] }
protected void setContentStart(String contentStart) { [EOL]     if (contentStart == null) { [EOL]         contentStart = ""; [EOL]     } [EOL]     this.contentStart = contentStart; [EOL] }
protected String getContentEnd() { [EOL]     return contentEnd; [EOL] }
protected void setContentEnd(String contentEnd) { [EOL]     if (contentEnd == null) { [EOL]         contentEnd = ""; [EOL]     } [EOL]     this.contentEnd = contentEnd; [EOL] }
protected String getFieldNameValueSeparator() { [EOL]     return fieldNameValueSeparator; [EOL] }
protected void setFieldNameValueSeparator(String fieldNameValueSeparator) { [EOL]     if (fieldNameValueSeparator == null) { [EOL]         fieldNameValueSeparator = ""; [EOL]     } [EOL]     this.fieldNameValueSeparator = fieldNameValueSeparator; [EOL] }
protected String getFieldSeparator() { [EOL]     return fieldSeparator; [EOL] }
protected void setFieldSeparator(String fieldSeparator) { [EOL]     if (fieldSeparator == null) { [EOL]         fieldSeparator = ""; [EOL]     } [EOL]     this.fieldSeparator = fieldSeparator; [EOL] }
protected boolean isFieldSeparatorAtStart() { [EOL]     return fieldSeparatorAtStart; [EOL] }
protected void setFieldSeparatorAtStart(final boolean fieldSeparatorAtStart) { [EOL]     this.fieldSeparatorAtStart = fieldSeparatorAtStart; [EOL] }
protected boolean isFieldSeparatorAtEnd() { [EOL]     return fieldSeparatorAtEnd; [EOL] }
protected void setFieldSeparatorAtEnd(final boolean fieldSeparatorAtEnd) { [EOL]     this.fieldSeparatorAtEnd = fieldSeparatorAtEnd; [EOL] }
protected String getNullText() { [EOL]     return nullText; [EOL] }
protected void setNullText(String nullText) { [EOL]     if (nullText == null) { [EOL]         nullText = ""; [EOL]     } [EOL]     this.nullText = nullText; [EOL] }
protected String getSizeStartText() { [EOL]     return sizeStartText; [EOL] }
protected void setSizeStartText(String sizeStartText) { [EOL]     if (sizeStartText == null) { [EOL]         sizeStartText = ""; [EOL]     } [EOL]     this.sizeStartText = sizeStartText; [EOL] }
protected String getSizeEndText() { [EOL]     return sizeEndText; [EOL] }
protected void setSizeEndText(String sizeEndText) { [EOL]     if (sizeEndText == null) { [EOL]         sizeEndText = ""; [EOL]     } [EOL]     this.sizeEndText = sizeEndText; [EOL] }
protected String getSummaryObjectStartText() { [EOL]     return summaryObjectStartText; [EOL] }
protected void setSummaryObjectStartText(String summaryObjectStartText) { [EOL]     if (summaryObjectStartText == null) { [EOL]         summaryObjectStartText = ""; [EOL]     } [EOL]     this.summaryObjectStartText = summaryObjectStartText; [EOL] }
protected String getSummaryObjectEndText() { [EOL]     return summaryObjectEndText; [EOL] }
protected void setSummaryObjectEndText(String summaryObjectEndText) { [EOL]     if (summaryObjectEndText == null) { [EOL]         summaryObjectEndText = ""; [EOL]     } [EOL]     this.summaryObjectEndText = summaryObjectEndText; [EOL] }
private Object readResolve() { [EOL]     return ToStringStyle.DEFAULT_STYLE; [EOL] }
private Object readResolve() { [EOL]     return ToStringStyle.NO_FIELD_NAMES_STYLE; [EOL] }
private Object readResolve() { [EOL]     return ToStringStyle.SHORT_PREFIX_STYLE; [EOL] }
private Object readResolve() { [EOL]     return ToStringStyle.SIMPLE_STYLE; [EOL] }
private Object readResolve() { [EOL]     return ToStringStyle.MULTI_LINE_STYLE; [EOL] }
