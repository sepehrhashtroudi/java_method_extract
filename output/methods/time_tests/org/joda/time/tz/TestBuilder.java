public TestBuilder(String name) { [EOL]     super(name); [EOL] } <line_num>: 196,198
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 36,38
public static TestSuite suite() { [EOL]     return new TestSuite(TestBuilder.class); [EOL] } <line_num>: 40,42
static DateTimeZoneBuilder buildAmericaLosAngelesBuilder() { [EOL]     return new DateTimeZoneBuilder().addCutover(-2147483648, 'w', 1, 1, 0, false, 0).setStandardOffset(-28378000).setFixedSavings("LMT", 0).addCutover(1883, 'w', 11, 18, 0, false, 43200000).setStandardOffset(-28800000).addRecurringSavings("PDT", 3600000, 1918, 1919, 'w', 3, -1, 7, false, 7200000).addRecurringSavings("PST", 0, 1918, 1919, 'w', 10, -1, 7, false, 7200000).addRecurringSavings("PWT", 3600000, 1942, 1942, 'w', 2, 9, 0, false, 7200000).addRecurringSavings("PPT", 3600000, 1945, 1945, 'u', 8, 14, 0, false, 82800000).addRecurringSavings("PST", 0, 1945, 1945, 'w', 9, 30, 0, false, 7200000).addRecurringSavings("PDT", 3600000, 1948, 1948, 'w', 3, 14, 0, false, 7200000).addRecurringSavings("PST", 0, 1949, 1949, 'w', 1, 1, 0, false, 7200000).addRecurringSavings("PDT", 3600000, 1950, 1966, 'w', 4, -1, 7, false, 7200000).addRecurringSavings("PST", 0, 1950, 1961, 'w', 9, -1, 7, false, 7200000).addRecurringSavings("PST", 0, 1962, 1966, 'w', 10, -1, 7, false, 7200000).addRecurringSavings("PST", 0, 1967, 2147483647, 'w', 10, -1, 7, false, 7200000).addRecurringSavings("PDT", 3600000, 1967, 1973, 'w', 4, -1, 7, false, 7200000).addRecurringSavings("PDT", 3600000, 1974, 1974, 'w', 1, 6, 0, false, 7200000).addRecurringSavings("PDT", 3600000, 1975, 1975, 'w', 2, 23, 0, false, 7200000).addRecurringSavings("PDT", 3600000, 1976, 1986, 'w', 4, -1, 7, false, 7200000).addRecurringSavings("PDT", 3600000, 1987, 2147483647, 'w', 4, 1, 7, true, 7200000); [EOL] } <line_num>: 165,188
static DateTimeZone buildAmericaLosAngeles() { [EOL]     return buildAmericaLosAngelesBuilder().toDateTimeZone("America/Los_Angeles", true); [EOL] } <line_num>: 190,192
protected void setUp() throws Exception { [EOL]     originalDateTimeZone = DateTimeZone.getDefault(); [EOL]     DateTimeZone.setDefault(DateTimeZone.UTC); [EOL] } <line_num>: 200,203
protected void tearDown() throws Exception { [EOL]     DateTimeZone.setDefault(originalDateTimeZone); [EOL] } <line_num>: 205,207
public void testID() { [EOL]     DateTimeZone tz = buildAmericaLosAngeles(); [EOL]     assertEquals("America/Los_Angeles", tz.getID()); [EOL]     assertEquals(false, tz.isFixed()); [EOL] } <line_num>: 209,213
public void testForwardTransitions() { [EOL]     DateTimeZone tz = buildAmericaLosAngeles(); [EOL]     testForwardTransitions(tz, AMERICA_LOS_ANGELES_DATA); [EOL] } <line_num>: 215,218
static void testForwardTransitions(DateTimeZone tz, String[][] data) { [EOL]     long instant = Long.MIN_VALUE; [EOL]     for (int i = 0; i < data.length; i++) { [EOL]         String[] row = data[i]; [EOL]         long expectedInstant = instant; [EOL]         if (row[0] != null) { [EOL]             instant = tz.nextTransition(instant); [EOL]             expectedInstant = new DateTime(row[0]).getMillis(); [EOL]         } [EOL]         String expectedKey = row[1]; [EOL]         int expectedStandardOffset = -(int) OFFSET_FORMATTER.parseMillis(row[2]); [EOL]         int expectedOffset = -(int) OFFSET_FORMATTER.parseMillis(row[3]); [EOL]         assertEquals(expectedInstant, instant); [EOL]         assertEquals(expectedKey, tz.getNameKey(instant)); [EOL]         assertEquals(expectedStandardOffset, tz.getStandardOffset(instant)); [EOL]         assertEquals(expectedOffset, tz.getOffset(instant)); [EOL]         if (i < data.length - 1) { [EOL]             long nextInstant = new DateTime(data[i + 1][0]).getMillis(); [EOL]             long span = (nextInstant - instant) / 10; [EOL]             for (int j = 1; j < 10; j++) { [EOL]                 long between = instant + j * span; [EOL]                 assertEquals(expectedKey, tz.getNameKey(between)); [EOL]                 assertEquals(expectedStandardOffset, tz.getStandardOffset(between)); [EOL]                 assertEquals(expectedOffset, tz.getOffset(between)); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 220,251
public void testReverseTransitions() { [EOL]     DateTimeZone tz = buildAmericaLosAngeles(); [EOL]     testReverseTransitions(tz, AMERICA_LOS_ANGELES_DATA); [EOL] } <line_num>: 253,256
static void testReverseTransitions(DateTimeZone tz, String[][] data) { [EOL]     long instant = new DateTime(data[data.length - 1][0]).getMillis(); [EOL]     for (int i = data.length; --i >= 1; ) { [EOL]         String[] row = data[i]; [EOL]         String[] prevRow = data[i - 1]; [EOL]         instant = tz.previousTransition(instant); [EOL]         long expectedInstant = new DateTime(row[0]).getMillis() - 1; [EOL]         String expectedKey = prevRow[1]; [EOL]         int expectedStandardOffset = -(int) OFFSET_FORMATTER.parseMillis(prevRow[2]); [EOL]         int expectedOffset = -(int) OFFSET_FORMATTER.parseMillis(prevRow[3]); [EOL]         assertEquals(expectedInstant, instant); [EOL]         assertEquals(expectedKey, tz.getNameKey(instant)); [EOL]         assertEquals(expectedStandardOffset, tz.getStandardOffset(instant)); [EOL]         assertEquals(expectedOffset, tz.getOffset(instant)); [EOL]     } [EOL] } <line_num>: 258,275
public void testSerialization() throws IOException { [EOL]     DateTimeZone tz = testSerialization(buildAmericaLosAngelesBuilder(), "America/Los_Angeles"); [EOL]     assertEquals(false, tz.isFixed()); [EOL]     testForwardTransitions(tz, AMERICA_LOS_ANGELES_DATA); [EOL]     testReverseTransitions(tz, AMERICA_LOS_ANGELES_DATA); [EOL] } <line_num>: 277,284
static DateTimeZone testSerialization(DateTimeZoneBuilder builder, String id) throws IOException { [EOL]     ByteArrayOutputStream out = new ByteArrayOutputStream(); [EOL]     builder.writeTo("America/Los_Angeles", out); [EOL]     ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray()); [EOL]     DateTimeZone tz = DateTimeZoneBuilder.readFrom(in, id); [EOL]     assertEquals(id, tz.getID()); [EOL]     return tz; [EOL] } <line_num>: 286,295
public void testFixed() throws IOException { [EOL]     DateTimeZoneBuilder builder = new DateTimeZoneBuilder().setStandardOffset(3600000).setFixedSavings("LMT", 0); [EOL]     DateTimeZone tz = builder.toDateTimeZone("Test", true); [EOL]     for (int i = 0; i < 2; i++) { [EOL]         assertEquals("Test", tz.getID()); [EOL]         assertEquals(true, tz.isFixed()); [EOL]         assertEquals(3600000, tz.getOffset(0)); [EOL]         assertEquals(3600000, tz.getStandardOffset(0)); [EOL]         assertEquals(0, tz.nextTransition(0)); [EOL]         assertEquals(0, tz.previousTransition(0)); [EOL]         tz = testSerialization(builder, "Test"); [EOL]     } [EOL] } <line_num>: 297,313
