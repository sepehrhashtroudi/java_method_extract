public DataTimePackageTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 92,94
public static Test suite() { [EOL]     TestSuite suite = new TestSuite("org.jfree.data.time"); [EOL]     suite.addTestSuite(DateRangeTests.class); [EOL]     suite.addTestSuite(DayTests.class); [EOL]     suite.addTestSuite(FixedMillisecondTests.class); [EOL]     suite.addTestSuite(HourTests.class); [EOL]     suite.addTestSuite(MinuteTests.class); [EOL]     suite.addTestSuite(MillisecondTests.class); [EOL]     suite.addTestSuite(MonthTests.class); [EOL]     suite.addTestSuite(MovingAverageTests.class); [EOL]     suite.addTestSuite(QuarterTests.class); [EOL]     suite.addTestSuite(SecondTests.class); [EOL]     suite.addTestSuite(SimpleTimePeriodTests.class); [EOL]     suite.addTestSuite(TimePeriodAnchorTests.class); [EOL]     suite.addTestSuite(TimePeriodValueTests.class); [EOL]     suite.addTestSuite(TimePeriodValuesTests.class); [EOL]     suite.addTestSuite(TimePeriodValuesCollectionTests.class); [EOL]     suite.addTestSuite(TimeSeriesCollectionTests.class); [EOL]     suite.addTestSuite(TimeSeriesTests.class); [EOL]     suite.addTestSuite(TimeSeriesDataItemTests.class); [EOL]     suite.addTestSuite(TimeTableXYDatasetTests.class); [EOL]     suite.addTestSuite(WeekTests.class); [EOL]     suite.addTestSuite(YearTests.class); [EOL]     return suite; [EOL] } <line_num>: 61,85
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 101,103