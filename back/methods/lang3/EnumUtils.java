public static <E extends Enum<E>> Map<String, E> getEnumMap(final Class<E> enumClass) { [EOL]     final Map<String, E> map = new LinkedHashMap<String, E>(); [EOL]     for (final E e : enumClass.getEnumConstants()) { [EOL]         map.put(e.name(), e); [EOL]     } [EOL]     return map; [EOL] }
public static <E extends Enum<E>> List<E> getEnumList(final Class<E> enumClass) { [EOL]     return new ArrayList<E>(Arrays.asList(enumClass.getEnumConstants())); [EOL] }
public static <E extends Enum<E>> boolean isValidEnum(final Class<E> enumClass, final String enumName) { [EOL]     if (enumName == null) { [EOL]         return false; [EOL]     } [EOL]     try { [EOL]         Enum.valueOf(enumClass, enumName); [EOL]         return true; [EOL]     } catch (final IllegalArgumentException ex) { [EOL]         return false; [EOL]     } [EOL] }
public static <E extends Enum<E>> E getEnum(final Class<E> enumClass, final String enumName) { [EOL]     if (enumName == null) { [EOL]         return null; [EOL]     } [EOL]     try { [EOL]         return Enum.valueOf(enumClass, enumName); [EOL]     } catch (final IllegalArgumentException ex) { [EOL]         return null; [EOL]     } [EOL] }
public static <E extends Enum<E>> long generateBitVector(final Class<E> enumClass, final Iterable<E> values) { [EOL]     checkBitVectorable(enumClass); [EOL]     Validate.notNull(values); [EOL]     long total = 0; [EOL]     for (final E constant : values) { [EOL]         Validate.isTrue(constant != null, NULL_ELEMENTS_NOT_PERMITTED); [EOL]         total |= 1 << constant.ordinal(); [EOL]     } [EOL]     return total; [EOL] }
public static <E extends Enum<E>> long[] generateBitVectors(final Class<E> enumClass, final Iterable<E> values) { [EOL]     asEnum(enumClass); [EOL]     Validate.notNull(values); [EOL]     final EnumSet<E> condensed = EnumSet.noneOf(enumClass); [EOL]     for (final E constant : values) { [EOL]         Validate.isTrue(constant != null, NULL_ELEMENTS_NOT_PERMITTED); [EOL]         condensed.add(constant); [EOL]     } [EOL]     final long[] result = new long[(enumClass.getEnumConstants().length - 1) / Long.SIZE + 1]; [EOL]     for (final E value : condensed) { [EOL]         result[value.ordinal() / Long.SIZE] |= 1 << (value.ordinal() % Long.SIZE); [EOL]     } [EOL]     ArrayUtils.reverse(result); [EOL]     return result; [EOL] }
public static <E extends Enum<E>> long generateBitVector(final Class<E> enumClass, final E... values) { [EOL]     Validate.noNullElements(values); [EOL]     return generateBitVector(enumClass, Arrays.<E>asList(values)); [EOL] }
public static <E extends Enum<E>> long[] generateBitVectors(final Class<E> enumClass, final E... values) { [EOL]     asEnum(enumClass); [EOL]     Validate.noNullElements(values); [EOL]     final EnumSet<E> condensed = EnumSet.noneOf(enumClass); [EOL]     Collections.addAll(condensed, values); [EOL]     final long[] result = new long[(enumClass.getEnumConstants().length - 1) / Long.SIZE + 1]; [EOL]     for (final E value : condensed) { [EOL]         result[value.ordinal() / Long.SIZE] |= 1 << (value.ordinal() % Long.SIZE); [EOL]     } [EOL]     ArrayUtils.reverse(result); [EOL]     return result; [EOL] }
public static <E extends Enum<E>> EnumSet<E> processBitVector(final Class<E> enumClass, final long value) { [EOL]     checkBitVectorable(enumClass).getEnumConstants(); [EOL]     return processBitVectors(enumClass, value); [EOL] }
public static <E extends Enum<E>> EnumSet<E> processBitVectors(final Class<E> enumClass, long... values) { [EOL]     final EnumSet<E> results = EnumSet.noneOf(asEnum(enumClass)); [EOL]     values = ArrayUtils.clone(Validate.notNull(values)); [EOL]     ArrayUtils.reverse(values); [EOL]     for (final E constant : enumClass.getEnumConstants()) { [EOL]         final int block = constant.ordinal() / Long.SIZE; [EOL]         if (block < values.length && (values[block] & 1 << (constant.ordinal() % Long.SIZE)) != 0) { [EOL]             results.add(constant); [EOL]         } [EOL]     } [EOL]     return results; [EOL] }
private static <E extends Enum<E>> Class<E> checkBitVectorable(final Class<E> enumClass) { [EOL]     final E[] constants = asEnum(enumClass).getEnumConstants(); [EOL]     Validate.isTrue(constants.length <= Long.SIZE, CANNOT_STORE_S_S_VALUES_IN_S_BITS, constants.length, enumClass.getSimpleName(), Long.SIZE); [EOL]     return enumClass; [EOL] }
private static <E extends Enum<E>> Class<E> asEnum(final Class<E> enumClass) { [EOL]     Validate.notNull(enumClass, ENUM_CLASS_MUST_BE_DEFINED); [EOL]     Validate.isTrue(enumClass.isEnum(), S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE, enumClass); [EOL]     return enumClass; [EOL] }