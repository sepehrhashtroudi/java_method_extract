public TestLocalDateTime_Constructors(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 69,71
public static TestSuite suite() { [EOL]     return new TestSuite(TestLocalDateTime_Constructors.class); [EOL] } <line_num>: 73,75
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     zone = DateTimeZone.getDefault(); [EOL]     DateTimeZone.setDefault(MOSCOW); [EOL] } <line_num>: 81,85
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(zone); [EOL]     zone = null; [EOL] } <line_num>: 87,91
public void testParse_noFormatter() throws Throwable { [EOL]     assertEquals(new LocalDateTime(2010, 6, 30, 1, 20), LocalDateTime.parse("2010-06-30T01:20")); [EOL]     assertEquals(new LocalDateTime(2010, 1, 2, 14, 50, 30, 432), LocalDateTime.parse("2010-002T14:50:30.432")); [EOL] } <line_num>: 94,97
public void testParse_formatter() throws Throwable { [EOL]     DateTimeFormatter f = DateTimeFormat.forPattern("yyyy--dd MM HH").withChronology(ISOChronology.getInstance(PARIS)); [EOL]     assertEquals(new LocalDateTime(2010, 6, 30, 13, 0), LocalDateTime.parse("2010--30 06 13", f)); [EOL] } <line_num>: 99,102
public void testFactory_fromCalendarFields() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1970, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(1970, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromCalendarFields(cal)); [EOL] } <line_num>: 105,110
public void testFactory_fromCalendarFields_beforeYearZero1() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(0, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromCalendarFields(cal)); [EOL] } <line_num>: 112,118
public void testFactory_fromCalendarFields_beforeYearZero3() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(3, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(-2, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromCalendarFields(cal)); [EOL] } <line_num>: 120,126
public void testFactory_fromCalendarFields_null() throws Exception { [EOL]     try { [EOL]         LocalDateTime.fromCalendarFields((Calendar) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 128,133
public void testFactory_fromDateFields_after1970() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1970, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(1970, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromDateFields(cal.getTime())); [EOL] } <line_num>: 136,141
public void testFactory_fromDateFields_before1970() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1969, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(1969, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromDateFields(cal.getTime())); [EOL] } <line_num>: 143,148
public void testFactory_fromDateFields_beforeYearZero1() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(0, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromDateFields(cal.getTime())); [EOL] } <line_num>: 150,156
public void testFactory_fromDateFields_beforeYearZero3() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(3, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.ERA, GregorianCalendar.BC); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     LocalDateTime expected = new LocalDateTime(-2, 2, 3, 4, 5, 6, 7); [EOL]     assertEquals(expected, LocalDateTime.fromDateFields(cal.getTime())); [EOL] } <line_num>: 158,164
public void testFactory_fromDateFields_null() throws Exception { [EOL]     try { [EOL]         LocalDateTime.fromDateFields((Date) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 166,171
public void testConstructor() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     assertEquals(test, LocalDateTime.now()); [EOL] } <line_num>: 174,185
public void testConstructor_DateTimeZone() throws Throwable { [EOL]     DateTime dt = new DateTime(2005, 6, 8, 23, 59, 0, 0, LONDON); [EOL]     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); [EOL]     LocalDateTime test = new LocalDateTime(LONDON); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(8, test.getDayOfMonth()); [EOL]     assertEquals(23, test.getHourOfDay()); [EOL]     assertEquals(59, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     assertEquals(test, LocalDateTime.now(LONDON)); [EOL]     test = new LocalDateTime(PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(59, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     assertEquals(test, LocalDateTime.now(PARIS)); [EOL] } <line_num>: 188,214
public void testConstructor_nullDateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((DateTimeZone) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 216,226
public void testConstructor_Chronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     assertEquals(test, LocalDateTime.now(GREGORIAN_PARIS)); [EOL] } <line_num>: 229,240
public void testConstructor_nullChronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Chronology) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 242,252
public void testConstructor_long1() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME1); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 255,265
public void testConstructor_long2() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME2); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1971, test.getYear()); [EOL]     assertEquals(5, test.getMonthOfYear()); [EOL]     assertEquals(7, test.getDayOfMonth()); [EOL]     assertEquals(14 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(28, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 267,277
public void testConstructor_long1_DateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME1, PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 280,290
public void testConstructor_long2_DateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME2, PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1971, test.getYear()); [EOL]     assertEquals(5, test.getMonthOfYear()); [EOL]     assertEquals(7, test.getDayOfMonth()); [EOL]     assertEquals(14 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(28, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 292,302
public void testConstructor_long_nullDateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME1, (DateTimeZone) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 304,314
public void testConstructor_long1_Chronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME1, GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 317,327
public void testConstructor_long2_Chronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME2, GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1971, test.getYear()); [EOL]     assertEquals(5, test.getMonthOfYear()); [EOL]     assertEquals(7, test.getDayOfMonth()); [EOL]     assertEquals(14 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(28, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 329,339
public void testConstructor_long_nullChronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(TEST_TIME1, (Chronology) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 341,351
public void testConstructor_Object1() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     LocalDateTime test = new LocalDateTime(date); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 354,365
public void testConstructor_nullObject() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Object) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 367,377
public void testConstructor_ObjectString1() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1972-04-06"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1972, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(0, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 379,389
public void testConstructor_ObjectString2() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1972-037"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1972, test.getYear()); [EOL]     assertEquals(2, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(0, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 391,401
public void testConstructor_ObjectString3() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1972-04-06T10:20:30.040"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1972, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 403,413
public void testConstructor_ObjectString4() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1972-04-06T10:20"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1972, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 415,425
public void testConstructor_ObjectStringEx1() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("1970-04-06T+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 427,432
public void testConstructor_ObjectStringEx2() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("1970-04-06T10:20:30.040+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 434,439
public void testConstructor_ObjectStringEx3() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("T10:20:30.040"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 441,446
public void testConstructor_ObjectStringEx4() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("T10:20:30.040+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 448,453
public void testConstructor_ObjectStringEx5() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("10:20:30.040"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 455,460
public void testConstructor_ObjectStringEx6() throws Throwable { [EOL]     try { [EOL]         new LocalDateTime("10:20:30.040+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 462,467
public void testConstructor_ObjectLocalDateTime() throws Throwable { [EOL]     LocalDateTime dt = new LocalDateTime(1970, 5, 6, 10, 20, 30, 40, BUDDHIST_UTC); [EOL]     LocalDateTime test = new LocalDateTime(dt); [EOL]     assertEquals(BUDDHIST_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(5, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 469,480
public void testConstructor_ObjectLocalDate() throws Throwable { [EOL]     LocalDate date = new LocalDate(1970, 5, 6); [EOL]     try { [EOL]         new LocalDateTime(date); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 482,488
public void testConstructor_ObjectLocalTime() throws Throwable { [EOL]     LocalTime time = new LocalTime(10, 20, 30, 40); [EOL]     try { [EOL]         new LocalDateTime(time); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 490,496
public void testConstructor_Object_DateTimeZone() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     LocalDateTime test = new LocalDateTime(date, PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 499,510
public void testConstructor_Object_DateTimeZoneMoscow() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1970-04-06T12:24:00", MOSCOW); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 512,522
public void testConstructor_Object_DateTimeZoneMoscowBadDateTime() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1981-04-01T00:30:00", MOSCOW); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1981, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(1, test.getDayOfMonth()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(30, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 524,538
public void testConstructor_nullObject_DateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Object) null, PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 540,550
public void testConstructor_Object_nullDateTimeZone() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     LocalDateTime test = new LocalDateTime(date, (DateTimeZone) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 552,563
public void testConstructor_nullObject_nullDateTimeZone() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Object) null, (DateTimeZone) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 565,575
public void testConstructor_Object_Chronology() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     LocalDateTime test = new LocalDateTime(date, GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 578,589
public void testConstructor_Object_Chronology_crossChronology() throws Throwable { [EOL]     LocalDateTime input = new LocalDateTime(1970, 4, 6, 12, 30, 0, 0, ISO_UTC); [EOL]     LocalDateTime test = new LocalDateTime(input, BUDDHIST_UTC); [EOL]     assertEquals(BUDDHIST_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12, test.getHourOfDay()); [EOL]     assertEquals(30, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 591,602
public void testConstructor_Object_ChronologyMoscow() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1970-04-06T12:24:00", GREGORIAN_MOSCOW); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 604,614
public void testConstructor_Object_ChronologyMoscowBadDateTime() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime("1981-04-01T00:30:00", GREGORIAN_MOSCOW); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1981, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(1, test.getDayOfMonth()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(30, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 616,630
public void testConstructor_nullObject_Chronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Object) null, GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_PARIS, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 632,642
public void testConstructor_Object_nullChronology() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     LocalDateTime test = new LocalDateTime(date, (Chronology) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(4, test.getMonthOfYear()); [EOL]     assertEquals(6, test.getDayOfMonth()); [EOL]     assertEquals(12 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(24, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 644,655
public void testConstructor_nullObject_nullChronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime((Object) null, (Chronology) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1970, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10 + OFFSET_MOSCOW, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 657,667
public void testConstructor_int_int_int_int_int() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 670,680
public void testConstructor_int_int_int_int_int_int() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 683,693
public void testConstructor_int_int_int_int_int_int_int() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     try { [EOL]         new LocalDateTime(Integer.MIN_VALUE, 6, 9, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(Integer.MAX_VALUE, 6, 9, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 0, 9, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 13, 9, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 6, 0, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 6, 31, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     new LocalDateTime(2005, 7, 31, 10, 20, 30, 40); [EOL]     try { [EOL]         new LocalDateTime(2005, 7, 32, 10, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 696,735
public void testConstructor_int_int_int_Chronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]     assertEquals(GREGORIAN_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     try { [EOL]         new LocalDateTime(Integer.MIN_VALUE, 6, 9, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(Integer.MAX_VALUE, 6, 9, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 0, 9, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 13, 9, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 6, 0, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new LocalDateTime(2005, 6, 31, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     new LocalDateTime(2005, 7, 31, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]     try { [EOL]         new LocalDateTime(2005, 7, 32, 10, 20, 30, 40, GREGORIAN_PARIS); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 737,776
public void testConstructor_int_int_int_nullChronology() throws Throwable { [EOL]     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(2005, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL] } <line_num>: 778,784