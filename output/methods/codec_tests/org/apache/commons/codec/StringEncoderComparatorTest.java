public StringEncoderComparatorTest(String name) { [EOL]     super(name); [EOL] } <line_num>: 37,39
public void testComparatorNoArgCon() throws Exception { [EOL]     new StringEncoderComparator(); [EOL] } <line_num>: 41,43
public void testComparatorWithSoundex() throws Exception { [EOL]     StringEncoderComparator sCompare = new StringEncoderComparator(new Soundex()); [EOL]     assertTrue("O'Brien and O'Brian didn't come out with " + "the same Soundex, something must be wrong here", 0 == sCompare.compare("O'Brien", "O'Brian")); [EOL] } <line_num>: 45,52
public void testComparatorWithDoubleMetaphone() throws Exception { [EOL]     StringEncoderComparator sCompare = new StringEncoderComparator(new DoubleMetaphone()); [EOL]     String[] testArray = { "Jordan", "Sosa", "Prior", "Pryor" }; [EOL]     List testList = Arrays.asList(testArray); [EOL]     String[] controlArray = { "Jordan", "Prior", "Pryor", "Sosa" }; [EOL]     Collections.sort(testList, sCompare); [EOL]     String[] resultArray = (String[]) testList.toArray(new String[0]); [EOL]     for (int i = 0; i < resultArray.length; i++) { [EOL]         assertEquals("Result Array not Equal to Control Array at index: " + i, controlArray[i], resultArray[i]); [EOL]     } [EOL] } <line_num>: 54,70
public void testComparatorWithDoubleMetaphoneAndInvalidInput() throws Exception { [EOL]     StringEncoderComparator sCompare = new StringEncoderComparator(new DoubleMetaphone()); [EOL]     int compare = sCompare.compare(new Double(3.0), new Long(3)); [EOL]     assertEquals("Trying to compare objects that make no sense to the underlying encoder should return a zero compare code", 0, compare); [EOL] } <line_num>: 72,80