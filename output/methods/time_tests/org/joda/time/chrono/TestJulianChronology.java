public TestJulianChronology(String name) { [EOL]     super(name); [EOL] } <line_num>: 59,61
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 51,53
public static TestSuite suite() { [EOL]     return new TestSuite(TestJulianChronology.class); [EOL] } <line_num>: 55,57
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     originalDateTimeZone = DateTimeZone.getDefault(); [EOL]     originalTimeZone = TimeZone.getDefault(); [EOL]     originalLocale = Locale.getDefault(); [EOL]     DateTimeZone.setDefault(LONDON); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Locale.setDefault(Locale.UK); [EOL] } <line_num>: 63,71
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(originalDateTimeZone); [EOL]     TimeZone.setDefault(originalTimeZone); [EOL]     Locale.setDefault(originalLocale); [EOL]     originalDateTimeZone = null; [EOL]     originalTimeZone = null; [EOL]     originalLocale = null; [EOL] } <line_num>: 73,81
public void testFactoryUTC() { [EOL]     assertEquals(DateTimeZone.UTC, JulianChronology.getInstanceUTC().getZone()); [EOL]     assertSame(JulianChronology.class, JulianChronology.getInstanceUTC().getClass()); [EOL] } <line_num>: 84,87
public void testFactory() { [EOL]     assertEquals(LONDON, JulianChronology.getInstance().getZone()); [EOL]     assertSame(JulianChronology.class, JulianChronology.getInstance().getClass()); [EOL] } <line_num>: 89,92
public void testFactory_Zone() { [EOL]     assertEquals(TOKYO, JulianChronology.getInstance(TOKYO).getZone()); [EOL]     assertEquals(PARIS, JulianChronology.getInstance(PARIS).getZone()); [EOL]     assertEquals(LONDON, JulianChronology.getInstance(null).getZone()); [EOL]     assertSame(JulianChronology.class, JulianChronology.getInstance(TOKYO).getClass()); [EOL] } <line_num>: 94,99
public void testFactory_Zone_int() { [EOL]     JulianChronology chrono = JulianChronology.getInstance(TOKYO, 2); [EOL]     assertEquals(TOKYO, chrono.getZone()); [EOL]     assertEquals(2, chrono.getMinimumDaysInFirstWeek()); [EOL]     try { [EOL]         JulianChronology.getInstance(TOKYO, 0); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         JulianChronology.getInstance(TOKYO, 8); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 101,114
public void testEquality() { [EOL]     assertSame(JulianChronology.getInstance(TOKYO), JulianChronology.getInstance(TOKYO)); [EOL]     assertSame(JulianChronology.getInstance(LONDON), JulianChronology.getInstance(LONDON)); [EOL]     assertSame(JulianChronology.getInstance(PARIS), JulianChronology.getInstance(PARIS)); [EOL]     assertSame(JulianChronology.getInstanceUTC(), JulianChronology.getInstanceUTC()); [EOL]     assertSame(JulianChronology.getInstance(), JulianChronology.getInstance(LONDON)); [EOL] } <line_num>: 117,123
public void testWithUTC() { [EOL]     assertSame(JulianChronology.getInstanceUTC(), JulianChronology.getInstance(LONDON).withUTC()); [EOL]     assertSame(JulianChronology.getInstanceUTC(), JulianChronology.getInstance(TOKYO).withUTC()); [EOL]     assertSame(JulianChronology.getInstanceUTC(), JulianChronology.getInstanceUTC().withUTC()); [EOL]     assertSame(JulianChronology.getInstanceUTC(), JulianChronology.getInstance().withUTC()); [EOL] } <line_num>: 125,130
public void testWithZone() { [EOL]     assertSame(JulianChronology.getInstance(TOKYO), JulianChronology.getInstance(TOKYO).withZone(TOKYO)); [EOL]     assertSame(JulianChronology.getInstance(LONDON), JulianChronology.getInstance(TOKYO).withZone(LONDON)); [EOL]     assertSame(JulianChronology.getInstance(PARIS), JulianChronology.getInstance(TOKYO).withZone(PARIS)); [EOL]     assertSame(JulianChronology.getInstance(LONDON), JulianChronology.getInstance(TOKYO).withZone(null)); [EOL]     assertSame(JulianChronology.getInstance(PARIS), JulianChronology.getInstance().withZone(PARIS)); [EOL]     assertSame(JulianChronology.getInstance(PARIS), JulianChronology.getInstanceUTC().withZone(PARIS)); [EOL] } <line_num>: 132,139
public void testToString() { [EOL]     assertEquals("JulianChronology[Europe/London]", JulianChronology.getInstance(LONDON).toString()); [EOL]     assertEquals("JulianChronology[Asia/Tokyo]", JulianChronology.getInstance(TOKYO).toString()); [EOL]     assertEquals("JulianChronology[Europe/London]", JulianChronology.getInstance().toString()); [EOL]     assertEquals("JulianChronology[UTC]", JulianChronology.getInstanceUTC().toString()); [EOL]     assertEquals("JulianChronology[UTC,mdfw=2]", JulianChronology.getInstance(DateTimeZone.UTC, 2).toString()); [EOL] } <line_num>: 141,147
public void testDurationFields() { [EOL]     final JulianChronology julian = JulianChronology.getInstance(); [EOL]     assertEquals("eras", julian.eras().getName()); [EOL]     assertEquals("centuries", julian.centuries().getName()); [EOL]     assertEquals("years", julian.years().getName()); [EOL]     assertEquals("weekyears", julian.weekyears().getName()); [EOL]     assertEquals("months", julian.months().getName()); [EOL]     assertEquals("weeks", julian.weeks().getName()); [EOL]     assertEquals("days", julian.days().getName()); [EOL]     assertEquals("halfdays", julian.halfdays().getName()); [EOL]     assertEquals("hours", julian.hours().getName()); [EOL]     assertEquals("minutes", julian.minutes().getName()); [EOL]     assertEquals("seconds", julian.seconds().getName()); [EOL]     assertEquals("millis", julian.millis().getName()); [EOL]     assertEquals(false, julian.eras().isSupported()); [EOL]     assertEquals(true, julian.centuries().isSupported()); [EOL]     assertEquals(true, julian.years().isSupported()); [EOL]     assertEquals(true, julian.weekyears().isSupported()); [EOL]     assertEquals(true, julian.months().isSupported()); [EOL]     assertEquals(true, julian.weeks().isSupported()); [EOL]     assertEquals(true, julian.days().isSupported()); [EOL]     assertEquals(true, julian.halfdays().isSupported()); [EOL]     assertEquals(true, julian.hours().isSupported()); [EOL]     assertEquals(true, julian.minutes().isSupported()); [EOL]     assertEquals(true, julian.seconds().isSupported()); [EOL]     assertEquals(true, julian.millis().isSupported()); [EOL]     assertEquals(false, julian.centuries().isPrecise()); [EOL]     assertEquals(false, julian.years().isPrecise()); [EOL]     assertEquals(false, julian.weekyears().isPrecise()); [EOL]     assertEquals(false, julian.months().isPrecise()); [EOL]     assertEquals(false, julian.weeks().isPrecise()); [EOL]     assertEquals(false, julian.days().isPrecise()); [EOL]     assertEquals(false, julian.halfdays().isPrecise()); [EOL]     assertEquals(true, julian.hours().isPrecise()); [EOL]     assertEquals(true, julian.minutes().isPrecise()); [EOL]     assertEquals(true, julian.seconds().isPrecise()); [EOL]     assertEquals(true, julian.millis().isPrecise()); [EOL]     final JulianChronology julianUTC = JulianChronology.getInstanceUTC(); [EOL]     assertEquals(false, julianUTC.centuries().isPrecise()); [EOL]     assertEquals(false, julianUTC.years().isPrecise()); [EOL]     assertEquals(false, julianUTC.weekyears().isPrecise()); [EOL]     assertEquals(false, julianUTC.months().isPrecise()); [EOL]     assertEquals(true, julianUTC.weeks().isPrecise()); [EOL]     assertEquals(true, julianUTC.days().isPrecise()); [EOL]     assertEquals(true, julianUTC.halfdays().isPrecise()); [EOL]     assertEquals(true, julianUTC.hours().isPrecise()); [EOL]     assertEquals(true, julianUTC.minutes().isPrecise()); [EOL]     assertEquals(true, julianUTC.seconds().isPrecise()); [EOL]     assertEquals(true, julianUTC.millis().isPrecise()); [EOL]     final DateTimeZone gmt = DateTimeZone.forID("Etc/GMT"); [EOL]     final JulianChronology julianGMT = JulianChronology.getInstance(gmt); [EOL]     assertEquals(false, julianGMT.centuries().isPrecise()); [EOL]     assertEquals(false, julianGMT.years().isPrecise()); [EOL]     assertEquals(false, julianGMT.weekyears().isPrecise()); [EOL]     assertEquals(false, julianGMT.months().isPrecise()); [EOL]     assertEquals(true, julianGMT.weeks().isPrecise()); [EOL]     assertEquals(true, julianGMT.days().isPrecise()); [EOL]     assertEquals(true, julianGMT.halfdays().isPrecise()); [EOL]     assertEquals(true, julianGMT.hours().isPrecise()); [EOL]     assertEquals(true, julianGMT.minutes().isPrecise()); [EOL]     assertEquals(true, julianGMT.seconds().isPrecise()); [EOL]     assertEquals(true, julianGMT.millis().isPrecise()); [EOL] } <line_num>: 150,216
public void testDateFields() { [EOL]     final JulianChronology julian = JulianChronology.getInstance(); [EOL]     assertEquals("era", julian.era().getName()); [EOL]     assertEquals("centuryOfEra", julian.centuryOfEra().getName()); [EOL]     assertEquals("yearOfCentury", julian.yearOfCentury().getName()); [EOL]     assertEquals("yearOfEra", julian.yearOfEra().getName()); [EOL]     assertEquals("year", julian.year().getName()); [EOL]     assertEquals("monthOfYear", julian.monthOfYear().getName()); [EOL]     assertEquals("weekyearOfCentury", julian.weekyearOfCentury().getName()); [EOL]     assertEquals("weekyear", julian.weekyear().getName()); [EOL]     assertEquals("weekOfWeekyear", julian.weekOfWeekyear().getName()); [EOL]     assertEquals("dayOfYear", julian.dayOfYear().getName()); [EOL]     assertEquals("dayOfMonth", julian.dayOfMonth().getName()); [EOL]     assertEquals("dayOfWeek", julian.dayOfWeek().getName()); [EOL]     assertEquals(true, julian.era().isSupported()); [EOL]     assertEquals(true, julian.centuryOfEra().isSupported()); [EOL]     assertEquals(true, julian.yearOfCentury().isSupported()); [EOL]     assertEquals(true, julian.yearOfEra().isSupported()); [EOL]     assertEquals(true, julian.year().isSupported()); [EOL]     assertEquals(true, julian.monthOfYear().isSupported()); [EOL]     assertEquals(true, julian.weekyearOfCentury().isSupported()); [EOL]     assertEquals(true, julian.weekyear().isSupported()); [EOL]     assertEquals(true, julian.weekOfWeekyear().isSupported()); [EOL]     assertEquals(true, julian.dayOfYear().isSupported()); [EOL]     assertEquals(true, julian.dayOfMonth().isSupported()); [EOL]     assertEquals(true, julian.dayOfWeek().isSupported()); [EOL]     assertEquals(julian.eras(), julian.era().getDurationField()); [EOL]     assertEquals(julian.centuries(), julian.centuryOfEra().getDurationField()); [EOL]     assertEquals(julian.years(), julian.yearOfCentury().getDurationField()); [EOL]     assertEquals(julian.years(), julian.yearOfEra().getDurationField()); [EOL]     assertEquals(julian.years(), julian.year().getDurationField()); [EOL]     assertEquals(julian.months(), julian.monthOfYear().getDurationField()); [EOL]     assertEquals(julian.weekyears(), julian.weekyearOfCentury().getDurationField()); [EOL]     assertEquals(julian.weekyears(), julian.weekyear().getDurationField()); [EOL]     assertEquals(julian.weeks(), julian.weekOfWeekyear().getDurationField()); [EOL]     assertEquals(julian.days(), julian.dayOfYear().getDurationField()); [EOL]     assertEquals(julian.days(), julian.dayOfMonth().getDurationField()); [EOL]     assertEquals(julian.days(), julian.dayOfWeek().getDurationField()); [EOL]     assertEquals(null, julian.era().getRangeDurationField()); [EOL]     assertEquals(julian.eras(), julian.centuryOfEra().getRangeDurationField()); [EOL]     assertEquals(julian.centuries(), julian.yearOfCentury().getRangeDurationField()); [EOL]     assertEquals(julian.eras(), julian.yearOfEra().getRangeDurationField()); [EOL]     assertEquals(null, julian.year().getRangeDurationField()); [EOL]     assertEquals(julian.years(), julian.monthOfYear().getRangeDurationField()); [EOL]     assertEquals(julian.centuries(), julian.weekyearOfCentury().getRangeDurationField()); [EOL]     assertEquals(null, julian.weekyear().getRangeDurationField()); [EOL]     assertEquals(julian.weekyears(), julian.weekOfWeekyear().getRangeDurationField()); [EOL]     assertEquals(julian.years(), julian.dayOfYear().getRangeDurationField()); [EOL]     assertEquals(julian.months(), julian.dayOfMonth().getRangeDurationField()); [EOL]     assertEquals(julian.weeks(), julian.dayOfWeek().getRangeDurationField()); [EOL] } <line_num>: 218,271
public void testTimeFields() { [EOL]     final JulianChronology julian = JulianChronology.getInstance(); [EOL]     assertEquals("halfdayOfDay", julian.halfdayOfDay().getName()); [EOL]     assertEquals("clockhourOfHalfday", julian.clockhourOfHalfday().getName()); [EOL]     assertEquals("hourOfHalfday", julian.hourOfHalfday().getName()); [EOL]     assertEquals("clockhourOfDay", julian.clockhourOfDay().getName()); [EOL]     assertEquals("hourOfDay", julian.hourOfDay().getName()); [EOL]     assertEquals("minuteOfDay", julian.minuteOfDay().getName()); [EOL]     assertEquals("minuteOfHour", julian.minuteOfHour().getName()); [EOL]     assertEquals("secondOfDay", julian.secondOfDay().getName()); [EOL]     assertEquals("secondOfMinute", julian.secondOfMinute().getName()); [EOL]     assertEquals("millisOfDay", julian.millisOfDay().getName()); [EOL]     assertEquals("millisOfSecond", julian.millisOfSecond().getName()); [EOL]     assertEquals(true, julian.halfdayOfDay().isSupported()); [EOL]     assertEquals(true, julian.clockhourOfHalfday().isSupported()); [EOL]     assertEquals(true, julian.hourOfHalfday().isSupported()); [EOL]     assertEquals(true, julian.clockhourOfDay().isSupported()); [EOL]     assertEquals(true, julian.hourOfDay().isSupported()); [EOL]     assertEquals(true, julian.minuteOfDay().isSupported()); [EOL]     assertEquals(true, julian.minuteOfHour().isSupported()); [EOL]     assertEquals(true, julian.secondOfDay().isSupported()); [EOL]     assertEquals(true, julian.secondOfMinute().isSupported()); [EOL]     assertEquals(true, julian.millisOfDay().isSupported()); [EOL]     assertEquals(true, julian.millisOfSecond().isSupported()); [EOL] } <line_num>: 273,298