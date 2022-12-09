public RelativeDateFormatTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 74,76
public static Test suite() { [EOL]     return new TestSuite(RelativeDateFormatTests.class); [EOL] } <line_num>: 65,67
public void testFormat() { [EOL]     RelativeDateFormat rdf = new RelativeDateFormat(); [EOL]     String s = rdf.format(new Date(2 * 60L * 60L * 1000L + 122500L)); [EOL]     assertEquals("2h2m2.500s", s); [EOL] } <line_num>: 81,85
public void test2033092() { [EOL]     RelativeDateFormat rdf = new RelativeDateFormat(); [EOL]     rdf.setShowZeroDays(false); [EOL]     rdf.setShowZeroHours(false); [EOL]     rdf.setMinuteSuffix(":"); [EOL]     rdf.setHourSuffix(":"); [EOL]     rdf.setSecondSuffix(""); [EOL]     DecimalFormat hoursFormatter = new DecimalFormat(); [EOL]     hoursFormatter.setMaximumFractionDigits(0); [EOL]     hoursFormatter.setMaximumIntegerDigits(2); [EOL]     hoursFormatter.setMinimumIntegerDigits(2); [EOL]     rdf.setHourFormatter(hoursFormatter); [EOL]     DecimalFormat minsFormatter = new DecimalFormat(); [EOL]     minsFormatter.setMaximumFractionDigits(0); [EOL]     minsFormatter.setMaximumIntegerDigits(2); [EOL]     minsFormatter.setMinimumIntegerDigits(2); [EOL]     rdf.setMinuteFormatter(minsFormatter); [EOL]     DecimalFormat secondsFormatter = new DecimalFormat(); [EOL]     secondsFormatter.setMaximumFractionDigits(0); [EOL]     secondsFormatter.setMaximumIntegerDigits(2); [EOL]     secondsFormatter.setMinimumIntegerDigits(2); [EOL]     rdf.setSecondFormatter(secondsFormatter); [EOL]     String s = rdf.format(new Date(2 * 60L * 60L * 1000L + 122500L)); [EOL]     assertEquals("02:02:02", s); [EOL] } <line_num>: 91,115
public void testEquals() { [EOL]     RelativeDateFormat df1 = new RelativeDateFormat(); [EOL]     RelativeDateFormat df2 = new RelativeDateFormat(); [EOL]     assertEquals(df1, df2); [EOL]     df1.setBaseMillis(123L); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setBaseMillis(123L); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setDayFormatter(new DecimalFormat("0%")); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setDayFormatter(new DecimalFormat("0%")); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setDaySuffix("D"); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setDaySuffix("D"); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setHourFormatter(new DecimalFormat("0%")); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setHourFormatter(new DecimalFormat("0%")); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setHourSuffix("H"); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setHourSuffix("H"); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setMinuteFormatter(new DecimalFormat("0%")); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setMinuteFormatter(new DecimalFormat("0%")); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setMinuteSuffix("M"); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setMinuteSuffix("M"); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setSecondSuffix("S"); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setSecondSuffix("S"); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setShowZeroDays(!df1.getShowZeroDays()); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setShowZeroDays(!df2.getShowZeroDays()); [EOL]     assertTrue(df1.equals(df2)); [EOL]     df1.setSecondFormatter(new DecimalFormat("0.0")); [EOL]     assertFalse(df1.equals(df2)); [EOL]     df2.setSecondFormatter(new DecimalFormat("0.0")); [EOL]     assertTrue(df1.equals(df2)); [EOL] } <line_num>: 120,174
public void testHashCode() { [EOL]     RelativeDateFormat df1 = new RelativeDateFormat(123L); [EOL]     RelativeDateFormat df2 = new RelativeDateFormat(123L); [EOL]     assertTrue(df1.equals(df2)); [EOL]     int h1 = df1.hashCode(); [EOL]     int h2 = df2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 179,186
public void testCloning() { [EOL]     NumberFormat nf = new DecimalFormat("0"); [EOL]     RelativeDateFormat df1 = new RelativeDateFormat(); [EOL]     df1.setSecondFormatter(nf); [EOL]     RelativeDateFormat df2 = null; [EOL]     df2 = (RelativeDateFormat) df1.clone(); [EOL]     assertTrue(df1 != df2); [EOL]     assertTrue(df1.getClass() == df2.getClass()); [EOL]     assertTrue(df1.equals(df2)); [EOL]     nf.setMinimumFractionDigits(2); [EOL]     assertFalse(df1.equals(df2)); [EOL] } <line_num>: 191,204
public void testNegative() { [EOL]     NumberFormat nf = new DecimalFormat("0"); [EOL]     RelativeDateFormat df1 = new RelativeDateFormat(); [EOL]     df1.setSecondFormatter(nf); [EOL]     assertEquals("-0h0m1s", df1.format(new Date(-1000L))); [EOL] } <line_num>: 209,214
