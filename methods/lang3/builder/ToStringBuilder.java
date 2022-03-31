public static ToStringStyle getDefaultStyle() { [EOL]     return defaultStyle; [EOL] }
public static void setDefaultStyle(final ToStringStyle style) { [EOL]     if (style == null) { [EOL]         throw new IllegalArgumentException("The style must not be null"); [EOL]     } [EOL]     defaultStyle = style; [EOL] }
public static String reflectionToString(final Object object) { [EOL]     return ReflectionToStringBuilder.toString(object); [EOL] }
public static String reflectionToString(final Object object, final ToStringStyle style) { [EOL]     return ReflectionToStringBuilder.toString(object, style); [EOL] }
public static String reflectionToString(final Object object, final ToStringStyle style, final boolean outputTransients) { [EOL]     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, null); [EOL] }
public static <T> String reflectionToString(final T object, final ToStringStyle style, final boolean outputTransients, final Class<? super T> reflectUpToClass) { [EOL]     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, reflectUpToClass); [EOL] }
public ToStringBuilder append(final boolean value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final boolean[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final byte value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final byte[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final char value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final char[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final double value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final double[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final float value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final float[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final int value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final int[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final long value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final long[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final Object obj) { [EOL]     style.append(buffer, null, obj, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final Object[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final short value) { [EOL]     style.append(buffer, null, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final short[] array) { [EOL]     style.append(buffer, null, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final boolean value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final boolean[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final boolean[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final byte value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final byte[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final byte[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final char value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final char[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final char[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final double value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final double[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final double[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final float value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final float[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final float[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final int value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final int[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final int[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final long value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final long[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final long[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final Object obj) { [EOL]     style.append(buffer, fieldName, obj, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final Object obj, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, obj, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final Object[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final Object[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final short value) { [EOL]     style.append(buffer, fieldName, value); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final short[] array) { [EOL]     style.append(buffer, fieldName, array, null); [EOL]     return this; [EOL] }
public ToStringBuilder append(final String fieldName, final short[] array, final boolean fullDetail) { [EOL]     style.append(buffer, fieldName, array, Boolean.valueOf(fullDetail)); [EOL]     return this; [EOL] }
public ToStringBuilder appendAsObjectToString(final Object object) { [EOL]     ObjectUtils.identityToString(this.getStringBuffer(), object); [EOL]     return this; [EOL] }
public ToStringBuilder appendSuper(final String superToString) { [EOL]     if (superToString != null) { [EOL]         style.appendSuper(buffer, superToString); [EOL]     } [EOL]     return this; [EOL] }
public ToStringBuilder appendToString(final String toString) { [EOL]     if (toString != null) { [EOL]         style.appendToString(buffer, toString); [EOL]     } [EOL]     return this; [EOL] }
public Object getObject() { [EOL]     return object; [EOL] }
public StringBuffer getStringBuffer() { [EOL]     return buffer; [EOL] }
public ToStringStyle getStyle() { [EOL]     return style; [EOL] }
@Override [EOL] public String toString() { [EOL]     if (this.getObject() == null) { [EOL]         this.getStringBuffer().append(this.getStyle().getNullText()); [EOL]     } else { [EOL]         style.appendEnd(this.getStringBuffer(), this.getObject()); [EOL]     } [EOL]     return this.getStringBuffer().toString(); [EOL] }
@Override [EOL] public String build() { [EOL]     return toString(); [EOL] }
