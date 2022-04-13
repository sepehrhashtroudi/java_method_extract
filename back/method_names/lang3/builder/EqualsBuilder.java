EqualsBuilder
 static Set<Pair<IDKey, IDKey>> getRegistry()
 static Pair<IDKey, IDKey> getRegisterPair(final Object lhs, final Object rhs)
 static boolean isRegistered(final Object lhs, final Object rhs)
 static void register(final Object lhs, final Object rhs)
 static void unregister(final Object lhs, final Object rhs)
public static boolean reflectionEquals(final Object lhs, final Object rhs, final Collection<String> excludeFields)
public static boolean reflectionEquals(final Object lhs, final Object rhs, final String... excludeFields)
public static boolean reflectionEquals(final Object lhs, final Object rhs, final boolean testTransients)
public static boolean reflectionEquals(final Object lhs, final Object rhs, final boolean testTransients, final Class<?> reflectUpToClass, final String... excludeFields)
private static void reflectionAppend(final Object lhs, final Object rhs, final Class<?> clazz, final EqualsBuilder builder, final boolean useTransients, final String[] excludeFields)
public EqualsBuilder appendSuper(final boolean superEquals)
public EqualsBuilder append(final Object lhs, final Object rhs)
public EqualsBuilder append(final long lhs, final long rhs)
public EqualsBuilder append(final int lhs, final int rhs)
public EqualsBuilder append(final short lhs, final short rhs)
public EqualsBuilder append(final char lhs, final char rhs)
public EqualsBuilder append(final byte lhs, final byte rhs)
public EqualsBuilder append(final double lhs, final double rhs)
public EqualsBuilder append(final float lhs, final float rhs)
public EqualsBuilder append(final boolean lhs, final boolean rhs)
public EqualsBuilder append(final Object[] lhs, final Object[] rhs)
public EqualsBuilder append(final long[] lhs, final long[] rhs)
public EqualsBuilder append(final int[] lhs, final int[] rhs)
public EqualsBuilder append(final short[] lhs, final short[] rhs)
public EqualsBuilder append(final char[] lhs, final char[] rhs)
public EqualsBuilder append(final byte[] lhs, final byte[] rhs)
public EqualsBuilder append(final double[] lhs, final double[] rhs)
public EqualsBuilder append(final float[] lhs, final float[] rhs)
public EqualsBuilder append(final boolean[] lhs, final boolean[] rhs)
public boolean isEquals()
public Boolean build()
protected void setEquals(final boolean isEquals)
public void reset()
