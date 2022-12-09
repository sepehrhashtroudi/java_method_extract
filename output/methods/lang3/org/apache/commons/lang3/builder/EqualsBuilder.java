public EqualsBuilder() { [EOL] } <line_num>: 222,224
static Set<Pair<IDKey, IDKey>> getRegistry() { [EOL]     return REGISTRY.get(); [EOL] } <line_num>: 120,122
static Pair<IDKey, IDKey> getRegisterPair(final Object lhs, final Object rhs) { [EOL]     final IDKey left = new IDKey(lhs); [EOL]     final IDKey right = new IDKey(rhs); [EOL]     return Pair.of(left, right); [EOL] } <line_num>: 134,138
static boolean isRegistered(final Object lhs, final Object rhs) { [EOL]     final Set<Pair<IDKey, IDKey>> registry = getRegistry(); [EOL]     final Pair<IDKey, IDKey> pair = getRegisterPair(lhs, rhs); [EOL]     final Pair<IDKey, IDKey> swappedPair = Pair.of(pair.getLeft(), pair.getRight()); [EOL]     return registry != null && (registry.contains(pair) || registry.contains(swappedPair)); [EOL] } <line_num>: 153,160
static void register(final Object lhs, final Object rhs) { [EOL]     synchronized (EqualsBuilder.class) { [EOL]         if (getRegistry() == null) { [EOL]             REGISTRY.set(new HashSet<Pair<IDKey, IDKey>>()); [EOL]         } [EOL]     } [EOL]     final Set<Pair<IDKey, IDKey>> registry = getRegistry(); [EOL]     final Pair<IDKey, IDKey> pair = getRegisterPair(lhs, rhs); [EOL]     registry.add(pair); [EOL] } <line_num>: 171,181
static void unregister(final Object lhs, final Object rhs) { [EOL]     Set<Pair<IDKey, IDKey>> registry = getRegistry(); [EOL]     if (registry != null) { [EOL]         final Pair<IDKey, IDKey> pair = getRegisterPair(lhs, rhs); [EOL]         registry.remove(pair); [EOL]         synchronized (EqualsBuilder.class) { [EOL]             registry = getRegistry(); [EOL]             if (registry != null && registry.isEmpty()) { [EOL]                 REGISTRY.remove(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 195,208
public static boolean reflectionEquals(final Object lhs, final Object rhs, final Collection<String> excludeFields) { [EOL]     return reflectionEquals(lhs, rhs, ReflectionToStringBuilder.toNoNullStringArray(excludeFields)); [EOL] } <line_num>: 247,249
public static boolean reflectionEquals(final Object lhs, final Object rhs, final String... excludeFields) { [EOL]     return reflectionEquals(lhs, rhs, false, null, excludeFields); [EOL] } <line_num>: 270,272
public static boolean reflectionEquals(final Object lhs, final Object rhs, final boolean testTransients) { [EOL]     return reflectionEquals(lhs, rhs, testTransients, null); [EOL] } <line_num>: 294,296
public static boolean reflectionEquals(final Object lhs, final Object rhs, final boolean testTransients, final Class<?> reflectUpToClass, final String... excludeFields) { [EOL]     if (lhs == rhs) { [EOL]         return true; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         return false; [EOL]     } [EOL]     final Class<?> lhsClass = lhs.getClass(); [EOL]     final Class<?> rhsClass = rhs.getClass(); [EOL]     Class<?> testClass; [EOL]     if (lhsClass.isInstance(rhs)) { [EOL]         testClass = lhsClass; [EOL]         if (!rhsClass.isInstance(lhs)) { [EOL]             testClass = rhsClass; [EOL]         } [EOL]     } else if (rhsClass.isInstance(lhs)) { [EOL]         testClass = rhsClass; [EOL]         if (!lhsClass.isInstance(rhs)) { [EOL]             testClass = lhsClass; [EOL]         } [EOL]     } else { [EOL]         return false; [EOL]     } [EOL]     final EqualsBuilder equalsBuilder = new EqualsBuilder(); [EOL]     try { [EOL]         reflectionAppend(lhs, rhs, testClass, equalsBuilder, testTransients, excludeFields); [EOL]         while (testClass.getSuperclass() != null && testClass != reflectUpToClass) { [EOL]             testClass = testClass.getSuperclass(); [EOL]             reflectionAppend(lhs, rhs, testClass, equalsBuilder, testTransients, excludeFields); [EOL]         } [EOL]     } catch (final IllegalArgumentException e) { [EOL]         return false; [EOL]     } [EOL]     return equalsBuilder.isEquals(); [EOL] } <line_num>: 324,371
private static void reflectionAppend(final Object lhs, final Object rhs, final Class<?> clazz, final EqualsBuilder builder, final boolean useTransients, final String[] excludeFields) { [EOL]     if (isRegistered(lhs, rhs)) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         register(lhs, rhs); [EOL]         final Field[] fields = clazz.getDeclaredFields(); [EOL]         AccessibleObject.setAccessible(fields, true); [EOL]         for (int i = 0; i < fields.length && builder.isEquals; i++) { [EOL]             final Field f = fields[i]; [EOL]             if (!ArrayUtils.contains(excludeFields, f.getName()) && (f.getName().indexOf('$') == -1) && (useTransients || !Modifier.isTransient(f.getModifiers())) && (!Modifier.isStatic(f.getModifiers()))) { [EOL]                 try { [EOL]                     builder.append(f.get(lhs), f.get(rhs)); [EOL]                 } catch (final IllegalAccessException e) { [EOL]                     throw new InternalError("Unexpected IllegalAccessException"); [EOL]                 } [EOL]             } [EOL]         } [EOL]     } finally { [EOL]         unregister(lhs, rhs); [EOL]     } [EOL] } <line_num>: 384,418
public EqualsBuilder appendSuper(final boolean superEquals) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = superEquals; [EOL]     return this; [EOL] } <line_num>: 429,435
public EqualsBuilder append(final Object lhs, final Object rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     final Class<?> lhsClass = lhs.getClass(); [EOL]     if (!lhsClass.isArray()) { [EOL]         isEquals = lhs.equals(rhs); [EOL]     } else if (lhs.getClass() != rhs.getClass()) { [EOL]         this.setEquals(false); [EOL]     } else if (lhs instanceof long[]) { [EOL]         append((long[]) lhs, (long[]) rhs); [EOL]     } else if (lhs instanceof int[]) { [EOL]         append((int[]) lhs, (int[]) rhs); [EOL]     } else if (lhs instanceof short[]) { [EOL]         append((short[]) lhs, (short[]) rhs); [EOL]     } else if (lhs instanceof char[]) { [EOL]         append((char[]) lhs, (char[]) rhs); [EOL]     } else if (lhs instanceof byte[]) { [EOL]         append((byte[]) lhs, (byte[]) rhs); [EOL]     } else if (lhs instanceof double[]) { [EOL]         append((double[]) lhs, (double[]) rhs); [EOL]     } else if (lhs instanceof float[]) { [EOL]         append((float[]) lhs, (float[]) rhs); [EOL]     } else if (lhs instanceof boolean[]) { [EOL]         append((boolean[]) lhs, (boolean[]) rhs); [EOL]     } else { [EOL]         append((Object[]) lhs, (Object[]) rhs); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 447,489
public EqualsBuilder append(final long lhs, final long rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 502,508
public EqualsBuilder append(final int lhs, final int rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 517,523
public EqualsBuilder append(final short lhs, final short rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 532,538
public EqualsBuilder append(final char lhs, final char rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 547,553
public EqualsBuilder append(final byte lhs, final byte rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 562,568
public EqualsBuilder append(final double lhs, final double rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     return append(Double.doubleToLongBits(lhs), Double.doubleToLongBits(rhs)); [EOL] } <line_num>: 583,588
public EqualsBuilder append(final float lhs, final float rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     return append(Float.floatToIntBits(lhs), Float.floatToIntBits(rhs)); [EOL] } <line_num>: 603,608
public EqualsBuilder append(final boolean lhs, final boolean rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     isEquals = (lhs == rhs); [EOL]     return this; [EOL] } <line_num>: 617,623
public EqualsBuilder append(final Object[] lhs, final Object[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 635,654
public EqualsBuilder append(final long[] lhs, final long[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 666,685
public EqualsBuilder append(final int[] lhs, final int[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 697,716
public EqualsBuilder append(final short[] lhs, final short[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 728,747
public EqualsBuilder append(final char[] lhs, final char[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 759,778
public EqualsBuilder append(final byte[] lhs, final byte[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 790,809
public EqualsBuilder append(final double[] lhs, final double[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 821,840
public EqualsBuilder append(final float[] lhs, final float[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 852,871
public EqualsBuilder append(final boolean[] lhs, final boolean[] rhs) { [EOL]     if (isEquals == false) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == rhs) { [EOL]         return this; [EOL]     } [EOL]     if (lhs == null || rhs == null) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     if (lhs.length != rhs.length) { [EOL]         this.setEquals(false); [EOL]         return this; [EOL]     } [EOL]     for (int i = 0; i < lhs.length && isEquals; ++i) { [EOL]         append(lhs[i], rhs[i]); [EOL]     } [EOL]     return this; [EOL] } <line_num>: 883,902
public boolean isEquals() { [EOL]     return this.isEquals; [EOL] } <line_num>: 910,912
@Override [EOL] public Boolean build() { [EOL]     return Boolean.valueOf(isEquals()); [EOL] } <line_num>: 923,926
protected void setEquals(final boolean isEquals) { [EOL]     this.isEquals = isEquals; [EOL] } <line_num>: 934,936
public void reset() { [EOL]     this.isEquals = true; [EOL] } <line_num>: 942,944