public TestISOPeriodFormat(String name) { [EOL]     super(name); [EOL] } <line_num>: 68,70
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 60,62
public static TestSuite suite() { [EOL]     return new TestSuite(TestISOPeriodFormat.class); [EOL] } <line_num>: 64,66
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     originalDateTimeZone = DateTimeZone.getDefault(); [EOL]     originalTimeZone = TimeZone.getDefault(); [EOL]     originalLocale = Locale.getDefault(); [EOL]     DateTimeZone.setDefault(LONDON); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Locale.setDefault(Locale.UK); [EOL] } <line_num>: 72,80
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(originalDateTimeZone); [EOL]     TimeZone.setDefault(originalTimeZone); [EOL]     Locale.setDefault(originalLocale); [EOL]     originalDateTimeZone = null; [EOL]     originalTimeZone = null; [EOL]     originalLocale = null; [EOL] } <line_num>: 82,90
public void testSubclassableConstructor() { [EOL]     ISOPeriodFormat f = new ISOPeriodFormat() { [EOL]     }; [EOL]     assertNotNull(f); [EOL] } <line_num>: 93,98
public void testFormatStandard() { [EOL]     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); [EOL]     assertEquals("P1Y2M3W4DT5H6M7.008S", ISOPeriodFormat.standard().print(p)); [EOL]     p = new Period(1, 2, 3, 4, 5, 6, 7, 0); [EOL]     assertEquals("P1Y2M3W4DT5H6M7S", ISOPeriodFormat.standard().print(p)); [EOL]     p = new Period(0); [EOL]     assertEquals("PT0S", ISOPeriodFormat.standard().print(p)); [EOL]     p = new Period(0, PeriodType.standard().withMillisRemoved().withSecondsRemoved()); [EOL]     assertEquals("PT0M", ISOPeriodFormat.standard().print(p)); [EOL]     assertEquals("P1Y4DT5H6M7.008S", ISOPeriodFormat.standard().print(YEAR_DAY_PERIOD)); [EOL]     assertEquals("PT0S", ISOPeriodFormat.standard().print(EMPTY_YEAR_DAY_PERIOD)); [EOL]     assertEquals("P1Y2M3W4D", ISOPeriodFormat.standard().print(DATE_PERIOD)); [EOL]     assertEquals("PT5H6M7.008S", ISOPeriodFormat.standard().print(TIME_PERIOD)); [EOL] } <line_num>: 101,116
public void testFormatStandard_negative() { [EOL]     Period p = new Period(-1, -2, -3, -4, -5, -6, -7, -8); [EOL]     assertEquals("P-1Y-2M-3W-4DT-5H-6M-7.008S", ISOPeriodFormat.standard().print(p)); [EOL]     p = Period.years(-54); [EOL]     assertEquals("P-54Y", ISOPeriodFormat.standard().print(p)); [EOL]     p = Period.seconds(4).withMillis(-8); [EOL]     assertEquals("PT3.992S", ISOPeriodFormat.standard().print(p)); [EOL]     p = Period.seconds(-4).withMillis(8); [EOL]     assertEquals("PT-3.992S", ISOPeriodFormat.standard().print(p)); [EOL]     p = Period.seconds(-23); [EOL]     assertEquals("PT-23S", ISOPeriodFormat.standard().print(p)); [EOL]     p = Period.millis(-8); [EOL]     assertEquals("PT-0.008S", ISOPeriodFormat.standard().print(p)); [EOL] } <line_num>: 118,136
public void testFormatAlternate() { [EOL]     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); [EOL]     assertEquals("P00010204T050607.008", ISOPeriodFormat.alternate().print(p)); [EOL]     p = new Period(1, 2, 3, 4, 5, 6, 7, 0); [EOL]     assertEquals("P00010204T050607", ISOPeriodFormat.alternate().print(p)); [EOL]     p = new Period(0); [EOL]     assertEquals("P00000000T000000", ISOPeriodFormat.alternate().print(p)); [EOL]     p = new Period(0, PeriodType.standard().withMillisRemoved().withSecondsRemoved()); [EOL]     assertEquals("P00000000T000000", ISOPeriodFormat.alternate().print(p)); [EOL]     assertEquals("P00010004T050607.008", ISOPeriodFormat.alternate().print(YEAR_DAY_PERIOD)); [EOL]     assertEquals("P00000000T000000", ISOPeriodFormat.alternate().print(EMPTY_YEAR_DAY_PERIOD)); [EOL]     assertEquals("P00010204T000000", ISOPeriodFormat.alternate().print(DATE_PERIOD)); [EOL]     assertEquals("P00000000T050607.008", ISOPeriodFormat.alternate().print(TIME_PERIOD)); [EOL] } <line_num>: 139,154
public void testFormatAlternateExtended() { [EOL]     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); [EOL]     assertEquals("P0001-02-04T05:06:07.008", ISOPeriodFormat.alternateExtended().print(p)); [EOL]     p = new Period(1, 2, 3, 4, 5, 6, 7, 0); [EOL]     assertEquals("P0001-02-04T05:06:07", ISOPeriodFormat.alternateExtended().print(p)); [EOL]     p = new Period(0); [EOL]     assertEquals("P0000-00-00T00:00:00", ISOPeriodFormat.alternateExtended().print(p)); [EOL]     p = new Period(0, PeriodType.standard().withMillisRemoved().withSecondsRemoved()); [EOL]     assertEquals("P0000-00-00T00:00:00", ISOPeriodFormat.alternateExtended().print(p)); [EOL]     assertEquals("P0001-00-04T05:06:07.008", ISOPeriodFormat.alternateExtended().print(YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0000-00-00T00:00:00", ISOPeriodFormat.alternateExtended().print(EMPTY_YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0001-02-04T00:00:00", ISOPeriodFormat.alternateExtended().print(DATE_PERIOD)); [EOL]     assertEquals("P0000-00-00T05:06:07.008", ISOPeriodFormat.alternateExtended().print(TIME_PERIOD)); [EOL] } <line_num>: 157,172
public void testFormatAlternateWithWeeks() { [EOL]     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); [EOL]     assertEquals("P0001W0304T050607.008", ISOPeriodFormat.alternateWithWeeks().print(p)); [EOL]     p = new Period(1, 2, 3, 4, 5, 6, 7, 0); [EOL]     assertEquals("P0001W0304T050607", ISOPeriodFormat.alternateWithWeeks().print(p)); [EOL]     p = new Period(0); [EOL]     assertEquals("P0000W0000T000000", ISOPeriodFormat.alternateWithWeeks().print(p)); [EOL]     p = new Period(0, PeriodType.standard().withMillisRemoved().withSecondsRemoved()); [EOL]     assertEquals("P0000W0000T000000", ISOPeriodFormat.alternateWithWeeks().print(p)); [EOL]     assertEquals("P0001W0004T050607.008", ISOPeriodFormat.alternateWithWeeks().print(YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0000W0000T000000", ISOPeriodFormat.alternateWithWeeks().print(EMPTY_YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0001W0304T000000", ISOPeriodFormat.alternateWithWeeks().print(DATE_PERIOD)); [EOL]     assertEquals("P0000W0000T050607.008", ISOPeriodFormat.alternateWithWeeks().print(TIME_PERIOD)); [EOL] } <line_num>: 175,190
public void testFormatAlternateExtendedWithWeeks() { [EOL]     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); [EOL]     assertEquals("P0001-W03-04T05:06:07.008", ISOPeriodFormat.alternateExtendedWithWeeks().print(p)); [EOL]     p = new Period(1, 2, 3, 4, 5, 6, 7, 0); [EOL]     assertEquals("P0001-W03-04T05:06:07", ISOPeriodFormat.alternateExtendedWithWeeks().print(p)); [EOL]     p = new Period(0); [EOL]     assertEquals("P0000-W00-00T00:00:00", ISOPeriodFormat.alternateExtendedWithWeeks().print(p)); [EOL]     p = new Period(0, PeriodType.standard().withMillisRemoved().withSecondsRemoved()); [EOL]     assertEquals("P0000-W00-00T00:00:00", ISOPeriodFormat.alternateExtendedWithWeeks().print(p)); [EOL]     assertEquals("P0001-W00-04T05:06:07.008", ISOPeriodFormat.alternateExtendedWithWeeks().print(YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0000-W00-00T00:00:00", ISOPeriodFormat.alternateExtendedWithWeeks().print(EMPTY_YEAR_DAY_PERIOD)); [EOL]     assertEquals("P0001-W03-04T00:00:00", ISOPeriodFormat.alternateExtendedWithWeeks().print(DATE_PERIOD)); [EOL]     assertEquals("P0000-W00-00T05:06:07.008", ISOPeriodFormat.alternateExtendedWithWeeks().print(TIME_PERIOD)); [EOL] } <line_num>: 193,208
