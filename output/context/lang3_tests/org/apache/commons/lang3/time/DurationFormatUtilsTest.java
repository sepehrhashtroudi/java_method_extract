public void testConstructor()
public void testFormatDurationWords()
public void testFormatDurationPluralWords()
public void testFormatDurationHMS()
public void testFormatDurationISO()
public void testFormatDuration()
public void testFormatPeriodISO()
public void testFormatPeriod()
public void testLexx()
public void testBugzilla38401()
public void testJiraLang281()
public void testLANG815()
public void testLowDurations()
public void testEdgeDurations()
public void testDurationsByBruteForce()
private void bruteForce(final int year, final int month, final int day, final String format, final int calendarType)
private void assertEqualDuration(final String expected, final int[] start, final int[] end, final String format)
private void assertEqualDuration(final String message, final String expected, final int[] start, final int[] end, final String format)
private void assertArrayEquals(final DurationFormatUtils.Token[] obj1, final DurationFormatUtils.Token[] obj2)
int FOUR_YEARS=Optional[365 * 3 + 366]
