public static String toString(final Object object) { [EOL]     return toString(object, null, false, false, null); [EOL] }
public static String toString(final Object object, final ToStringStyle style) { [EOL]     return toString(object, style, false, false, null); [EOL] }
public static String toString(final Object object, final ToStringStyle style, final boolean outputTransients) { [EOL]     return toString(object, style, outputTransients, false, null); [EOL] }
public static String toString(final Object object, final ToStringStyle style, final boolean outputTransients, final boolean outputStatics) { [EOL]     return toString(object, style, outputTransients, outputStatics, null); [EOL] }
public static <T> String toString(final T object, final ToStringStyle style, final boolean outputTransients, final boolean outputStatics, final Class<? super T> reflectUpToClass) { [EOL]     return new ReflectionToStringBuilder(object, style, null, reflectUpToClass, outputTransients, outputStatics).toString(); [EOL] }
public static String toStringExclude(final Object object, final Collection<String> excludeFieldNames) { [EOL]     return toStringExclude(object, toNoNullStringArray(excludeFieldNames)); [EOL] }
static String[] toNoNullStringArray(final Collection<String> collection) { [EOL]     if (collection == null) { [EOL]         return ArrayUtils.EMPTY_STRING_ARRAY; [EOL]     } [EOL]     return toNoNullStringArray(collection.toArray()); [EOL] }
static String[] toNoNullStringArray(final Object[] array) { [EOL]     final List<String> list = new ArrayList<String>(array.length); [EOL]     for (final Object e : array) { [EOL]         if (e != null) { [EOL]             list.add(e.toString()); [EOL]         } [EOL]     } [EOL]     return list.toArray(ArrayUtils.EMPTY_STRING_ARRAY); [EOL] }
public static String toStringExclude(final Object object, final String... excludeFieldNames) { [EOL]     return new ReflectionToStringBuilder(object).setExcludeFieldNames(excludeFieldNames).toString(); [EOL] }
protected boolean accept(final Field field) { [EOL]     if (field.getName().indexOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR) != -1) { [EOL]         return false; [EOL]     } [EOL]     if (Modifier.isTransient(field.getModifiers()) && !this.isAppendTransients()) { [EOL]         return false; [EOL]     } [EOL]     if (Modifier.isStatic(field.getModifiers()) && !this.isAppendStatics()) { [EOL]         return false; [EOL]     } [EOL]     if (this.excludeFieldNames != null && Arrays.binarySearch(this.excludeFieldNames, field.getName()) >= 0) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] }
protected void appendFieldsIn(final Class<?> clazz) { [EOL]     if (clazz.isArray()) { [EOL]         this.reflectionAppendArray(this.getObject()); [EOL]         return; [EOL]     } [EOL]     final Field[] fields = clazz.getDeclaredFields(); [EOL]     AccessibleObject.setAccessible(fields, true); [EOL]     for (final Field field : fields) { [EOL]         final String fieldName = field.getName(); [EOL]         if (this.accept(field)) { [EOL]             try { [EOL]                 final Object fieldValue = this.getValue(field); [EOL]                 this.append(fieldName, fieldValue); [EOL]             } catch (final IllegalAccessException ex) { [EOL]                 throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage()); [EOL]             } [EOL]         } [EOL]     } [EOL] }
public String[] getExcludeFieldNames() { [EOL]     return this.excludeFieldNames.clone(); [EOL] }
public Class<?> getUpToClass() { [EOL]     return this.upToClass; [EOL] }
protected Object getValue(final Field field) throws IllegalArgumentException, IllegalAccessException { [EOL]     return field.get(this.getObject()); [EOL] }
public boolean isAppendStatics() { [EOL]     return this.appendStatics; [EOL] }
public boolean isAppendTransients() { [EOL]     return this.appendTransients; [EOL] }
public ReflectionToStringBuilder reflectionAppendArray(final Object array) { [EOL]     this.getStyle().reflectionAppendArrayDetail(this.getStringBuffer(), null, array); [EOL]     return this; [EOL] }
public void setAppendStatics(final boolean appendStatics) { [EOL]     this.appendStatics = appendStatics; [EOL] }
public void setAppendTransients(final boolean appendTransients) { [EOL]     this.appendTransients = appendTransients; [EOL] }
public ReflectionToStringBuilder setExcludeFieldNames(final String... excludeFieldNamesParam) { [EOL]     if (excludeFieldNamesParam == null) { [EOL]         this.excludeFieldNames = null; [EOL]     } else { [EOL]         this.excludeFieldNames = toNoNullStringArray(excludeFieldNamesParam); [EOL]         Arrays.sort(this.excludeFieldNames); [EOL]     } [EOL]     return this; [EOL] }
public void setUpToClass(final Class<?> clazz) { [EOL]     if (clazz != null) { [EOL]         final Object object = getObject(); [EOL]         if (object != null && clazz.isInstance(object) == false) { [EOL]             throw new IllegalArgumentException("Specified class is not a superclass of the object"); [EOL]         } [EOL]     } [EOL]     this.upToClass = clazz; [EOL] }
@Override [EOL] public String toString() { [EOL]     if (this.getObject() == null) { [EOL]         return this.getStyle().getNullText(); [EOL]     } [EOL]     Class<?> clazz = this.getObject().getClass(); [EOL]     this.appendFieldsIn(clazz); [EOL]     while (clazz.getSuperclass() != null && clazz != this.getUpToClass()) { [EOL]         clazz = clazz.getSuperclass(); [EOL]         this.appendFieldsIn(clazz); [EOL]     } [EOL]     return super.toString(); [EOL] }