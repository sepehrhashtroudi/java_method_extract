public TestAll(String testName) { [EOL]     super(testName); [EOL] } <line_num>: 31,33
public static void main(String[] args) { [EOL]     String[] testCaseName = { TestAll.class.getName() }; [EOL]     junit.textui.TestRunner.main(testCaseName); [EOL] } <line_num>: 35,40
public static Test suite() { [EOL]     TestSuite suite = new TestSuite(); [EOL]     suite.addTest(TestFieldUtils.suite()); [EOL]     suite.addTest(TestBaseDateTimeField.suite()); [EOL]     suite.addTest(TestOffsetDateTimeField.suite()); [EOL]     suite.addTest(TestPreciseDurationDateTimeField.suite()); [EOL]     suite.addTest(TestPreciseDateTimeField.suite()); [EOL]     suite.addTest(TestMillisDurationField.suite()); [EOL]     suite.addTest(TestPreciseDurationField.suite()); [EOL]     suite.addTest(TestScaledDurationField.suite()); [EOL]     suite.addTest(TestUnsupportedDateTimeField.suite()); [EOL]     return suite; [EOL] } <line_num>: 42,57
