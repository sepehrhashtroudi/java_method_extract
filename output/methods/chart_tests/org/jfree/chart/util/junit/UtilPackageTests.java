public UtilPackageTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 87,89
public static Test suite() { [EOL]     TestSuite suite = new TestSuite("org.jfree.chart.util"); [EOL]     suite.addTestSuite(BooleanListTests.class); [EOL]     suite.addTestSuite(HashUtilitiesTests.class); [EOL]     suite.addTestSuite(LineUtilitiesTests.class); [EOL]     suite.addTestSuite(LogFormatTests.class); [EOL]     suite.addTestSuite(PaintListTests.class); [EOL]     suite.addTestSuite(PaintMapTests.class); [EOL]     suite.addTestSuite(RelativeDateFormatTests.class); [EOL]     suite.addTestSuite(SerialUtilitiesTests.class); [EOL]     suite.addTestSuite(ShapeListTests.class); [EOL]     suite.addTestSuite(ShapeUtilitiesTests.class); [EOL]     suite.addTestSuite(StrokeListTests.class); [EOL]     suite.addTestSuite(StrokeMapTests.class); [EOL]     return suite; [EOL] } <line_num>: 65,80
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 96,98