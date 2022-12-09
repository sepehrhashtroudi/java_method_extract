public TestScaledDurationField(String name) { [EOL]     super(name); [EOL] } <line_num>: 51,53
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 43,45
public static TestSuite suite() { [EOL]     return new TestSuite(TestScaledDurationField.class); [EOL] } <line_num>: 47,49
protected void setUp() throws Exception { [EOL]     DurationField base = MillisDurationField.INSTANCE; [EOL]     iField = new ScaledDurationField(base, DurationFieldType.minutes(), 90); [EOL] } <line_num>: 55,58
protected void tearDown() throws Exception { [EOL]     iField = null; [EOL] } <line_num>: 60,62
public void test_constructor() { [EOL]     try { [EOL]         new ScaledDurationField(null, DurationFieldType.minutes(), 10); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new ScaledDurationField(MillisDurationField.INSTANCE, null, 10); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 0); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 1); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 65,82
public void test_getScalar() { [EOL]     assertEquals(90, iField.getScalar()); [EOL] } <line_num>: 84,86
public void test_getType() { [EOL]     assertEquals(DurationFieldType.minutes(), iField.getType()); [EOL] } <line_num>: 89,91
public void test_getName() { [EOL]     assertEquals("minutes", iField.getName()); [EOL] } <line_num>: 93,95
public void test_isSupported() { [EOL]     assertEquals(true, iField.isSupported()); [EOL] } <line_num>: 97,99
public void test_isPrecise() { [EOL]     assertEquals(true, iField.isPrecise()); [EOL] } <line_num>: 101,103
public void test_getUnitMillis() { [EOL]     assertEquals(90, iField.getUnitMillis()); [EOL] } <line_num>: 105,107
public void test_toString() { [EOL]     assertEquals("DurationField[minutes]", iField.toString()); [EOL] } <line_num>: 109,111
public void test_getValue_long() { [EOL]     assertEquals(0, iField.getValue(0L)); [EOL]     assertEquals(12345678 / 90, iField.getValue(12345678L)); [EOL]     assertEquals(-1234 / 90, iField.getValue(-1234L)); [EOL]     assertEquals(INTEGER_MAX / 90, iField.getValue(LONG_INTEGER_MAX)); [EOL]     try { [EOL]         iField.getValue(LONG_INTEGER_MAX + 1L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 114,123
public void test_getValueAsLong_long() { [EOL]     assertEquals(0L, iField.getValueAsLong(0L)); [EOL]     assertEquals(12345678L / 90, iField.getValueAsLong(12345678L)); [EOL]     assertEquals(-1234 / 90L, iField.getValueAsLong(-1234L)); [EOL]     assertEquals(LONG_INTEGER_MAX + 1L, iField.getValueAsLong(LONG_INTEGER_MAX * 90L + 90L)); [EOL] } <line_num>: 125,130
public void test_getValue_long_long() { [EOL]     assertEquals(0, iField.getValue(0L, 567L)); [EOL]     assertEquals(12345678 / 90, iField.getValue(12345678L, 567L)); [EOL]     assertEquals(-1234 / 90, iField.getValue(-1234L, 567L)); [EOL]     assertEquals(INTEGER_MAX / 90, iField.getValue(LONG_INTEGER_MAX, 567L)); [EOL]     try { [EOL]         iField.getValue(LONG_INTEGER_MAX + 1L, 567L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 132,141
public void test_getValueAsLong_long_long() { [EOL]     assertEquals(0L, iField.getValueAsLong(0L, 567L)); [EOL]     assertEquals(12345678 / 90L, iField.getValueAsLong(12345678L, 567L)); [EOL]     assertEquals(-1234 / 90L, iField.getValueAsLong(-1234L, 567L)); [EOL]     assertEquals(LONG_INTEGER_MAX + 1L, iField.getValueAsLong(LONG_INTEGER_MAX * 90L + 90L, 567L)); [EOL] } <line_num>: 143,148
public void test_getMillis_int() { [EOL]     assertEquals(0, iField.getMillis(0)); [EOL]     assertEquals(1234L * 90L, iField.getMillis(1234)); [EOL]     assertEquals(-1234L * 90L, iField.getMillis(-1234)); [EOL]     assertEquals(LONG_INTEGER_MAX * 90L, iField.getMillis(INTEGER_MAX)); [EOL] } <line_num>: 151,156
public void test_getMillis_long() { [EOL]     assertEquals(0L, iField.getMillis(0L)); [EOL]     assertEquals(1234L * 90L, iField.getMillis(1234L)); [EOL]     assertEquals(-1234L * 90L, iField.getMillis(-1234L)); [EOL]     try { [EOL]         iField.getMillis(LONG_MAX); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 158,166
public void test_getMillis_int_long() { [EOL]     assertEquals(0L, iField.getMillis(0, 567L)); [EOL]     assertEquals(1234L * 90L, iField.getMillis(1234, 567L)); [EOL]     assertEquals(-1234L * 90L, iField.getMillis(-1234, 567L)); [EOL]     assertEquals(LONG_INTEGER_MAX * 90L, iField.getMillis(INTEGER_MAX, 567L)); [EOL] } <line_num>: 168,173
public void test_getMillis_long_long() { [EOL]     assertEquals(0L, iField.getMillis(0L, 567L)); [EOL]     assertEquals(1234L * 90L, iField.getMillis(1234L, 567L)); [EOL]     assertEquals(-1234L * 90L, iField.getMillis(-1234L, 567L)); [EOL]     try { [EOL]         iField.getMillis(LONG_MAX, 567L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 175,183
public void test_add_long_int() { [EOL]     assertEquals(567L, iField.add(567L, 0)); [EOL]     assertEquals(567L + 1234L * 90L, iField.add(567L, 1234)); [EOL]     assertEquals(567L - 1234L * 90L, iField.add(567L, -1234)); [EOL]     try { [EOL]         iField.add(LONG_MAX, 1); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 186,194
public void test_add_long_long() { [EOL]     assertEquals(567L, iField.add(567L, 0L)); [EOL]     assertEquals(567L + 1234L * 90L, iField.add(567L, 1234L)); [EOL]     assertEquals(567L - 1234L * 90L, iField.add(567L, -1234L)); [EOL]     try { [EOL]         iField.add(LONG_MAX, 1L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL]     try { [EOL]         iField.add(1L, LONG_MAX); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 196,208
public void test_getDifference_long_int() { [EOL]     assertEquals(0, iField.getDifference(1L, 0L)); [EOL]     assertEquals(567, iField.getDifference(567L * 90L, 0L)); [EOL]     assertEquals(567 - 1234, iField.getDifference(567L * 90L, 1234L * 90L)); [EOL]     assertEquals(567 + 1234, iField.getDifference(567L * 90L, -1234L * 90L)); [EOL]     try { [EOL]         iField.getDifference(LONG_MAX, -1L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 211,220
public void test_getDifferenceAsLong_long_long() { [EOL]     assertEquals(0L, iField.getDifferenceAsLong(1L, 0L)); [EOL]     assertEquals(567L, iField.getDifferenceAsLong(567L * 90L, 0L)); [EOL]     assertEquals(567L - 1234L, iField.getDifferenceAsLong(567L * 90L, 1234L * 90L)); [EOL]     assertEquals(567L + 1234L, iField.getDifferenceAsLong(567L * 90L, -1234L * 90L)); [EOL]     try { [EOL]         iField.getDifferenceAsLong(LONG_MAX, -1L); [EOL]         fail(); [EOL]     } catch (ArithmeticException ex) { [EOL]     } [EOL] } <line_num>: 222,231
public void test_equals() { [EOL]     assertEquals(true, iField.equals(iField)); [EOL]     assertEquals(false, iField.equals(ISOChronology.getInstance().minutes())); [EOL]     DurationField dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 2); [EOL]     assertEquals(false, iField.equals(dummy)); [EOL]     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 90); [EOL]     assertEquals(true, iField.equals(dummy)); [EOL]     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.millis(), 90); [EOL]     assertEquals(false, iField.equals(dummy)); [EOL]     assertEquals(false, iField.equals("")); [EOL]     assertEquals(false, iField.equals(null)); [EOL] } <line_num>: 234,245
public void test_hashCode() { [EOL]     assertEquals(iField.hashCode(), iField.hashCode()); [EOL]     assertEquals(false, iField.hashCode() == ISOChronology.getInstance().minutes().hashCode()); [EOL]     DurationField dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 2); [EOL]     assertEquals(false, iField.hashCode() == dummy.hashCode()); [EOL]     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 90); [EOL]     assertEquals(true, iField.hashCode() == dummy.hashCode()); [EOL]     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.millis(), 90); [EOL]     assertEquals(false, iField.hashCode() == dummy.hashCode()); [EOL] } <line_num>: 247,256
public void test_compareTo() { [EOL]     assertEquals(0, iField.compareTo(iField)); [EOL]     assertEquals(-1, iField.compareTo(ISOChronology.getInstance().minutes())); [EOL]     DurationField dummy = new PreciseDurationField(DurationFieldType.minutes(), 0); [EOL]     assertEquals(1, iField.compareTo(dummy)); [EOL]     try { [EOL]         iField.compareTo(null); [EOL]         fail(); [EOL]     } catch (NullPointerException ex) { [EOL]     } [EOL] } <line_num>: 259,272
public void testSerialization() throws Exception { [EOL]     DurationField test = iField; [EOL]     ByteArrayOutputStream baos = new ByteArrayOutputStream(); [EOL]     ObjectOutputStream oos = new ObjectOutputStream(baos); [EOL]     oos.writeObject(test); [EOL]     byte[] bytes = baos.toByteArray(); [EOL]     oos.close(); [EOL]     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); [EOL]     ObjectInputStream ois = new ObjectInputStream(bais); [EOL]     DurationField result = (DurationField) ois.readObject(); [EOL]     ois.close(); [EOL]     assertEquals(test, result); [EOL] } <line_num>: 275,290