public static <T> T defaultIfNull(final T object, final T defaultValue) { [EOL]     return object != null ? object : defaultValue; [EOL] }
public static <T> T firstNonNull(final T... values) { [EOL]     if (values != null) { [EOL]         for (final T val : values) { [EOL]             if (val != null) { [EOL]                 return val; [EOL]             } [EOL]         } [EOL]     } [EOL]     return null; [EOL] }
public static boolean equals(final Object object1, final Object object2) { [EOL]     if (object1 == object2) { [EOL]         return true; [EOL]     } [EOL]     if (object1 == null || object2 == null) { [EOL]         return false; [EOL]     } [EOL]     return object1.equals(object2); [EOL] }
public static boolean notEqual(final Object object1, final Object object2) { [EOL]     return ObjectUtils.equals(object1, object2) == false; [EOL] }
public static int hashCode(final Object obj) { [EOL]     return obj == null ? 0 : obj.hashCode(); [EOL] }
public static int hashCodeMulti(final Object... objects) { [EOL]     int hash = 1; [EOL]     if (objects != null) { [EOL]         for (final Object object : objects) { [EOL]             hash = hash * 31 + ObjectUtils.hashCode(object); [EOL]         } [EOL]     } [EOL]     return hash; [EOL] }
public static String identityToString(final Object object) { [EOL]     if (object == null) { [EOL]         return null; [EOL]     } [EOL]     final StringBuilder builder = new StringBuilder(); [EOL]     identityToString(builder, object); [EOL]     return builder.toString(); [EOL] }
public static void identityToString(final Appendable appendable, final Object object) throws IOException { [EOL]     if (object == null) { [EOL]         throw new NullPointerException("Cannot get the toString of a null identity"); [EOL]     } [EOL]     appendable.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object))); [EOL] }
public static void identityToString(final StrBuilder builder, final Object object) { [EOL]     if (object == null) { [EOL]         throw new NullPointerException("Cannot get the toString of a null identity"); [EOL]     } [EOL]     builder.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object))); [EOL] }
public static void identityToString(final StringBuffer buffer, final Object object) { [EOL]     if (object == null) { [EOL]         throw new NullPointerException("Cannot get the toString of a null identity"); [EOL]     } [EOL]     buffer.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object))); [EOL] }
public static void identityToString(final StringBuilder builder, final Object object) { [EOL]     if (object == null) { [EOL]         throw new NullPointerException("Cannot get the toString of a null identity"); [EOL]     } [EOL]     builder.append(object.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(object))); [EOL] }
public static String toString(final Object obj) { [EOL]     return obj == null ? "" : obj.toString(); [EOL] }
public static String toString(final Object obj, final String nullStr) { [EOL]     return obj == null ? nullStr : obj.toString(); [EOL] }
public static <T extends Comparable<? super T>> T min(final T... values) { [EOL]     T result = null; [EOL]     if (values != null) { [EOL]         for (final T value : values) { [EOL]             if (compare(value, result, true) < 0) { [EOL]                 result = value; [EOL]             } [EOL]         } [EOL]     } [EOL]     return result; [EOL] }
public static <T extends Comparable<? super T>> T max(final T... values) { [EOL]     T result = null; [EOL]     if (values != null) { [EOL]         for (final T value : values) { [EOL]             if (compare(value, result, false) > 0) { [EOL]                 result = value; [EOL]             } [EOL]         } [EOL]     } [EOL]     return result; [EOL] }
public static <T extends Comparable<? super T>> int compare(final T c1, final T c2) { [EOL]     return compare(c1, c2, false); [EOL] }
public static <T extends Comparable<? super T>> int compare(final T c1, final T c2, final boolean nullGreater) { [EOL]     if (c1 == c2) { [EOL]         return 0; [EOL]     } else if (c1 == null) { [EOL]         return nullGreater ? 1 : -1; [EOL]     } else if (c2 == null) { [EOL]         return nullGreater ? -1 : 1; [EOL]     } [EOL]     return c1.compareTo(c2); [EOL] }
public static <T extends Comparable<? super T>> T median(final T... items) { [EOL]     Validate.notEmpty(items); [EOL]     Validate.noNullElements(items); [EOL]     final TreeSet<T> sort = new TreeSet<T>(); [EOL]     Collections.addAll(sort, items); [EOL]     @SuppressWarnings("unchecked") [EOL]     final T result = (T) sort.toArray()[(sort.size() - 1) / 2]; [EOL]     return result; [EOL] }
public static <T> T median(final Comparator<T> comparator, final T... items) { [EOL]     Validate.notEmpty(items, "null/empty items"); [EOL]     Validate.noNullElements(items); [EOL]     Validate.notNull(comparator, "null comparator"); [EOL]     final TreeSet<T> sort = new TreeSet<T>(comparator); [EOL]     Collections.addAll(sort, items); [EOL]     @SuppressWarnings("unchecked") [EOL]     final T result = (T) sort.toArray()[(sort.size() - 1) / 2]; [EOL]     return result; [EOL] }
public static <T> T mode(final T... items) { [EOL]     if (ArrayUtils.isNotEmpty(items)) { [EOL]         final HashMap<T, MutableInt> occurrences = new HashMap<T, MutableInt>(items.length); [EOL]         for (final T t : items) { [EOL]             final MutableInt count = occurrences.get(t); [EOL]             if (count == null) { [EOL]                 occurrences.put(t, new MutableInt(1)); [EOL]             } else { [EOL]                 count.increment(); [EOL]             } [EOL]         } [EOL]         T result = null; [EOL]         int max = 0; [EOL]         for (final Map.Entry<T, MutableInt> e : occurrences.entrySet()) { [EOL]             final int cmp = e.getValue().intValue(); [EOL]             if (cmp == max) { [EOL]                 result = null; [EOL]             } else if (cmp > max) { [EOL]                 max = cmp; [EOL]                 result = e.getKey(); [EOL]             } [EOL]         } [EOL]         return result; [EOL]     } [EOL]     return null; [EOL] }
public static <T> T clone(final T obj) { [EOL]     if (obj instanceof Cloneable) { [EOL]         final Object result; [EOL]         if (obj.getClass().isArray()) { [EOL]             final Class<?> componentType = obj.getClass().getComponentType(); [EOL]             if (!componentType.isPrimitive()) { [EOL]                 result = ((Object[]) obj).clone(); [EOL]             } else { [EOL]                 int length = Array.getLength(obj); [EOL]                 result = Array.newInstance(componentType, length); [EOL]                 while (length-- > 0) { [EOL]                     Array.set(result, length, Array.get(obj, length)); [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             try { [EOL]                 final Method clone = obj.getClass().getMethod("clone"); [EOL]                 result = clone.invoke(obj); [EOL]             } catch (final NoSuchMethodException e) { [EOL]                 throw new CloneFailedException("Cloneable type " + obj.getClass().getName() + " has no clone method", e); [EOL]             } catch (final IllegalAccessException e) { [EOL]                 throw new CloneFailedException("Cannot clone Cloneable type " + obj.getClass().getName(), e); [EOL]             } catch (final InvocationTargetException e) { [EOL]                 throw new CloneFailedException("Exception cloning Cloneable type " + obj.getClass().getName(), e.getCause()); [EOL]             } [EOL]         } [EOL]         @SuppressWarnings("unchecked") [EOL]         final T checked = (T) result; [EOL]         return checked; [EOL]     } [EOL]     return null; [EOL] }
public static <T> T cloneIfPossible(final T obj) { [EOL]     final T clone = clone(obj); [EOL]     return clone == null ? obj : clone; [EOL] }
private Object readResolve() { [EOL]     return ObjectUtils.NULL; [EOL] }
public static boolean CONST(final boolean v) { [EOL]     return v; [EOL] }
public static byte CONST(final byte v) { [EOL]     return v; [EOL] }
public static byte CONST_BYTE(final int v) throws IllegalArgumentException { [EOL]     if (v < Byte.MIN_VALUE || v > Byte.MAX_VALUE) { [EOL]         throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + v + "]"); [EOL]     } [EOL]     return (byte) v; [EOL] }
public static char CONST(final char v) { [EOL]     return v; [EOL] }
public static short CONST(final short v) { [EOL]     return v; [EOL] }
public static short CONST_SHORT(final int v) throws IllegalArgumentException { [EOL]     if (v < Short.MIN_VALUE || v > Short.MAX_VALUE) { [EOL]         throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + v + "]"); [EOL]     } [EOL]     return (short) v; [EOL] }
public static int CONST(final int v) { [EOL]     return v; [EOL] }
public static long CONST(final long v) { [EOL]     return v; [EOL] }
public static float CONST(final float v) { [EOL]     return v; [EOL] }
public static double CONST(final double v) { [EOL]     return v; [EOL] }
public static <T> T CONST(final T v) { [EOL]     return v; [EOL] }