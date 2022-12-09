public TestAll(String testName) { [EOL]     super(testName); [EOL] } <line_num>: 31,33
public static Test suite() { [EOL]     TestSuite suite = new TestSuite(); [EOL]     suite.addTest(TestUTCProvider.suite()); [EOL]     suite.addTest(TestBuilder.suite()); [EOL]     suite.addTest(TestCompiler.suite()); [EOL]     suite.addTest(TestCachedDateTimeZone.suite()); [EOL]     suite.addTest(TestFixedDateTimeZone.suite()); [EOL]     return suite; [EOL] } <line_num>: 35,43
public static void main(String[] args) { [EOL]     String[] testCaseName = { TestAll.class.getName() }; [EOL]     junit.textui.TestRunner.main(testCaseName); [EOL] } <line_num>: 45,50