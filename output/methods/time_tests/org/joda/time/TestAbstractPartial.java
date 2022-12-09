public TestAbstractPartial(String name) { [EOL]     super(name); [EOL] } <line_num>: 58,60
MockPartial() { [EOL]     super(); [EOL] } <line_num>: 153,155
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 50,52
public static TestSuite suite() { [EOL]     return new TestSuite(TestAbstractPartial.class); [EOL] } <line_num>: 54,56
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     zone = DateTimeZone.getDefault(); [EOL]     DateTimeZone.setDefault(DateTimeZone.UTC); [EOL] } <line_num>: 62,66
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(zone); [EOL]     zone = null; [EOL] } <line_num>: 68,72
public void testGetValue() throws Throwable { [EOL]     MockPartial mock = new MockPartial(); [EOL]     assertEquals(1970, mock.getValue(0)); [EOL]     assertEquals(1, mock.getValue(1)); [EOL]     try { [EOL]         mock.getValue(-1); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL]     try { [EOL]         mock.getValue(2); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL] } <line_num>: 75,88
public void testGetValues() throws Throwable { [EOL]     MockPartial mock = new MockPartial(); [EOL]     int[] vals = mock.getValues(); [EOL]     assertEquals(2, vals.length); [EOL]     assertEquals(1970, vals[0]); [EOL]     assertEquals(1, vals[1]); [EOL] } <line_num>: 90,96
public void testGetField() throws Throwable { [EOL]     MockPartial mock = new MockPartial(); [EOL]     assertEquals(BuddhistChronology.getInstanceUTC().year(), mock.getField(0)); [EOL]     assertEquals(BuddhistChronology.getInstanceUTC().monthOfYear(), mock.getField(1)); [EOL]     try { [EOL]         mock.getField(-1); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL]     try { [EOL]         mock.getField(2); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL] } <line_num>: 98,111
public void testGetFieldType() throws Throwable { [EOL]     MockPartial mock = new MockPartial(); [EOL]     assertEquals(DateTimeFieldType.year(), mock.getFieldType(0)); [EOL]     assertEquals(DateTimeFieldType.monthOfYear(), mock.getFieldType(1)); [EOL]     try { [EOL]         mock.getFieldType(-1); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL]     try { [EOL]         mock.getFieldType(2); [EOL]         fail(); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]     } [EOL] } <line_num>: 113,126
public void testGetFieldTypes() throws Throwable { [EOL]     MockPartial mock = new MockPartial(); [EOL]     DateTimeFieldType[] vals = mock.getFieldTypes(); [EOL]     assertEquals(2, vals.length); [EOL]     assertEquals(DateTimeFieldType.year(), vals[0]); [EOL]     assertEquals(DateTimeFieldType.monthOfYear(), vals[1]); [EOL] } <line_num>: 128,134
public void testGetPropertyEquals() throws Throwable { [EOL]     MockProperty0 prop0 = new MockProperty0(); [EOL]     assertEquals(true, prop0.equals(prop0)); [EOL]     assertEquals(true, prop0.equals(new MockProperty0())); [EOL]     assertEquals(false, prop0.equals(new MockProperty1())); [EOL]     assertEquals(false, prop0.equals(new MockProperty0Val())); [EOL]     assertEquals(false, prop0.equals(new MockProperty0Field())); [EOL]     assertEquals(false, prop0.equals(new MockProperty0Chrono())); [EOL]     assertEquals(false, prop0.equals("")); [EOL]     assertEquals(false, prop0.equals(null)); [EOL] } <line_num>: 136,146
protected DateTimeField getField(int index, Chronology chrono) { [EOL]     switch(index) { [EOL]         case 0: [EOL]             return chrono.year(); [EOL]         case 1: [EOL]             return chrono.monthOfYear(); [EOL]         default: [EOL]             throw new IndexOutOfBoundsException(); [EOL]     } [EOL] } <line_num>: 157,166
public int size() { [EOL]     return 2; [EOL] } <line_num>: 168,170
public int getValue(int index) { [EOL]     return val[index]; [EOL] } <line_num>: 172,174
public void setValue(int index, int value) { [EOL]     val[index] = value; [EOL] } <line_num>: 176,178
public Chronology getChronology() { [EOL]     return BuddhistChronology.getInstanceUTC(); [EOL] } <line_num>: 180,182
public DateTimeField getField() { [EOL]     return partial.getField(0); [EOL] } <line_num>: 187,189
public ReadablePartial getReadablePartial() { [EOL]     return partial; [EOL] } <line_num>: 190,192
public int get() { [EOL]     return partial.getValue(0); [EOL] } <line_num>: 193,195
public DateTimeField getField() { [EOL]     return partial.getField(1); [EOL] } <line_num>: 199,201
public ReadablePartial getReadablePartial() { [EOL]     return partial; [EOL] } <line_num>: 202,204
public int get() { [EOL]     return partial.getValue(1); [EOL] } <line_num>: 205,207
public DateTimeField getField() { [EOL]     return BuddhistChronology.getInstanceUTC().hourOfDay(); [EOL] } <line_num>: 210,212
public int get() { [EOL]     return 99; [EOL] } <line_num>: 215,217
public Chronology getChronology() { [EOL]     return ISOChronology.getInstanceUTC(); [EOL] } <line_num>: 222,224
public ReadablePartial getReadablePartial() { [EOL]     return new MockPartial() { [EOL]  [EOL]         public Chronology getChronology() { [EOL]             return ISOChronology.getInstanceUTC(); [EOL]         } [EOL]     }; [EOL] } <line_num>: 220,226
