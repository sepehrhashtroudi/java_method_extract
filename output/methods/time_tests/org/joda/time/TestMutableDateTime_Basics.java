public TestMutableDateTime_Basics(String name) { [EOL]     super(name); [EOL] } <line_num>: 89,91
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 81,83
public static TestSuite suite() { [EOL]     return new TestSuite(TestMutableDateTime_Basics.class); [EOL] } <line_num>: 85,87
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     originalDateTimeZone = DateTimeZone.getDefault(); [EOL]     originalTimeZone = TimeZone.getDefault(); [EOL]     originalLocale = Locale.getDefault(); [EOL]     DateTimeZone.setDefault(LONDON); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Locale.setDefault(Locale.UK); [EOL] } <line_num>: 93,101
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(originalDateTimeZone); [EOL]     TimeZone.setDefault(originalTimeZone); [EOL]     Locale.setDefault(originalLocale); [EOL]     originalDateTimeZone = null; [EOL]     originalTimeZone = null; [EOL]     originalLocale = null; [EOL] } <line_num>: 103,111
public void testTest() { [EOL]     assertEquals("2002-06-09T00:00:00.000Z", new Instant(TEST_TIME_NOW).toString()); [EOL]     assertEquals("2002-04-05T12:24:00.000Z", new Instant(TEST_TIME1).toString()); [EOL]     assertEquals("2003-05-06T14:28:00.000Z", new Instant(TEST_TIME2).toString()); [EOL] } <line_num>: 114,118
public void testGet_DateTimeField() { [EOL]     MutableDateTime test = new MutableDateTime(); [EOL]     assertEquals(1, test.get(ISOChronology.getInstance().era())); [EOL]     assertEquals(20, test.get(ISOChronology.getInstance().centuryOfEra())); [EOL]     assertEquals(2, test.get(ISOChronology.getInstance().yearOfCentury())); [EOL]     assertEquals(2002, test.get(ISOChronology.getInstance().yearOfEra())); [EOL]     assertEquals(2002, test.get(ISOChronology.getInstance().year())); [EOL]     assertEquals(6, test.get(ISOChronology.getInstance().monthOfYear())); [EOL]     assertEquals(9, test.get(ISOChronology.getInstance().dayOfMonth())); [EOL]     assertEquals(2002, test.get(ISOChronology.getInstance().weekyear())); [EOL]     assertEquals(23, test.get(ISOChronology.getInstance().weekOfWeekyear())); [EOL]     assertEquals(7, test.get(ISOChronology.getInstance().dayOfWeek())); [EOL]     assertEquals(160, test.get(ISOChronology.getInstance().dayOfYear())); [EOL]     assertEquals(0, test.get(ISOChronology.getInstance().halfdayOfDay())); [EOL]     assertEquals(1, test.get(ISOChronology.getInstance().hourOfHalfday())); [EOL]     assertEquals(1, test.get(ISOChronology.getInstance().clockhourOfDay())); [EOL]     assertEquals(1, test.get(ISOChronology.getInstance().clockhourOfHalfday())); [EOL]     assertEquals(1, test.get(ISOChronology.getInstance().hourOfDay())); [EOL]     assertEquals(0, test.get(ISOChronology.getInstance().minuteOfHour())); [EOL]     assertEquals(60, test.get(ISOChronology.getInstance().minuteOfDay())); [EOL]     assertEquals(0, test.get(ISOChronology.getInstance().secondOfMinute())); [EOL]     assertEquals(60 * 60, test.get(ISOChronology.getInstance().secondOfDay())); [EOL]     assertEquals(0, test.get(ISOChronology.getInstance().millisOfSecond())); [EOL]     assertEquals(60 * 60 * 1000, test.get(ISOChronology.getInstance().millisOfDay())); [EOL]     try { [EOL]         test.get((DateTimeField) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 121,149
public void testGet_DateTimeFieldType() { [EOL]     MutableDateTime test = new MutableDateTime(); [EOL]     assertEquals(1, test.get(DateTimeFieldType.era())); [EOL]     assertEquals(20, test.get(DateTimeFieldType.centuryOfEra())); [EOL]     assertEquals(2, test.get(DateTimeFieldType.yearOfCentury())); [EOL]     assertEquals(2002, test.get(DateTimeFieldType.yearOfEra())); [EOL]     assertEquals(2002, test.get(DateTimeFieldType.year())); [EOL]     assertEquals(6, test.get(DateTimeFieldType.monthOfYear())); [EOL]     assertEquals(9, test.get(DateTimeFieldType.dayOfMonth())); [EOL]     assertEquals(2002, test.get(DateTimeFieldType.weekyear())); [EOL]     assertEquals(23, test.get(DateTimeFieldType.weekOfWeekyear())); [EOL]     assertEquals(7, test.get(DateTimeFieldType.dayOfWeek())); [EOL]     assertEquals(160, test.get(DateTimeFieldType.dayOfYear())); [EOL]     assertEquals(0, test.get(DateTimeFieldType.halfdayOfDay())); [EOL]     assertEquals(1, test.get(DateTimeFieldType.hourOfHalfday())); [EOL]     assertEquals(1, test.get(DateTimeFieldType.clockhourOfDay())); [EOL]     assertEquals(1, test.get(DateTimeFieldType.clockhourOfHalfday())); [EOL]     assertEquals(1, test.get(DateTimeFieldType.hourOfDay())); [EOL]     assertEquals(0, test.get(DateTimeFieldType.minuteOfHour())); [EOL]     assertEquals(60, test.get(DateTimeFieldType.minuteOfDay())); [EOL]     assertEquals(0, test.get(DateTimeFieldType.secondOfMinute())); [EOL]     assertEquals(60 * 60, test.get(DateTimeFieldType.secondOfDay())); [EOL]     assertEquals(0, test.get(DateTimeFieldType.millisOfSecond())); [EOL]     assertEquals(60 * 60 * 1000, test.get(DateTimeFieldType.millisOfDay())); [EOL]     try { [EOL]         test.get((DateTimeFieldType) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 151,179
public void testGetMethods() { [EOL]     MutableDateTime test = new MutableDateTime(); [EOL]     assertEquals(ISOChronology.getInstance(), test.getChronology()); [EOL]     assertEquals(LONDON, test.getZone()); [EOL]     assertEquals(TEST_TIME_NOW, test.getMillis()); [EOL]     assertEquals(1, test.getEra()); [EOL]     assertEquals(20, test.getCenturyOfEra()); [EOL]     assertEquals(2, test.getYearOfCentury()); [EOL]     assertEquals(2002, test.getYearOfEra()); [EOL]     assertEquals(2002, test.getYear()); [EOL]     assertEquals(6, test.getMonthOfYear()); [EOL]     assertEquals(9, test.getDayOfMonth()); [EOL]     assertEquals(2002, test.getWeekyear()); [EOL]     assertEquals(23, test.getWeekOfWeekyear()); [EOL]     assertEquals(7, test.getDayOfWeek()); [EOL]     assertEquals(160, test.getDayOfYear()); [EOL]     assertEquals(1, test.getHourOfDay()); [EOL]     assertEquals(0, test.getMinuteOfHour()); [EOL]     assertEquals(60, test.getMinuteOfDay()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(60 * 60, test.getSecondOfDay()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     assertEquals(60 * 60 * 1000, test.getMillisOfDay()); [EOL] } <line_num>: 181,206
public void testEqualsHashCode() { [EOL]     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime test2 = new MutableDateTime(TEST_TIME1); [EOL]     assertEquals(true, test1.equals(test2)); [EOL]     assertEquals(true, test2.equals(test1)); [EOL]     assertEquals(true, test1.equals(test1)); [EOL]     assertEquals(true, test2.equals(test2)); [EOL]     assertEquals(true, test1.hashCode() == test2.hashCode()); [EOL]     assertEquals(true, test1.hashCode() == test1.hashCode()); [EOL]     assertEquals(true, test2.hashCode() == test2.hashCode()); [EOL]     MutableDateTime test3 = new MutableDateTime(TEST_TIME2); [EOL]     assertEquals(false, test1.equals(test3)); [EOL]     assertEquals(false, test2.equals(test3)); [EOL]     assertEquals(false, test3.equals(test1)); [EOL]     assertEquals(false, test3.equals(test2)); [EOL]     assertEquals(false, test1.hashCode() == test3.hashCode()); [EOL]     assertEquals(false, test2.hashCode() == test3.hashCode()); [EOL]     DateTime test4 = new DateTime(TEST_TIME2); [EOL]     assertEquals(true, test4.equals(test3)); [EOL]     assertEquals(true, test3.equals(test4)); [EOL]     assertEquals(false, test4.equals(test1)); [EOL]     assertEquals(false, test1.equals(test4)); [EOL]     assertEquals(true, test3.hashCode() == test4.hashCode()); [EOL]     assertEquals(false, test1.hashCode() == test4.hashCode()); [EOL]     MutableDateTime test5 = new MutableDateTime(TEST_TIME2); [EOL]     test5.setRounding(ISOChronology.getInstance().millisOfSecond()); [EOL]     assertEquals(true, test5.equals(test3)); [EOL]     assertEquals(true, test5.equals(test4)); [EOL]     assertEquals(true, test3.equals(test5)); [EOL]     assertEquals(true, test4.equals(test5)); [EOL]     assertEquals(true, test3.hashCode() == test5.hashCode()); [EOL]     assertEquals(true, test4.hashCode() == test5.hashCode()); [EOL]     assertEquals(false, test1.equals("Hello")); [EOL]     assertEquals(true, test1.equals(new MockInstant())); [EOL]     assertEquals(false, test1.equals(new MutableDateTime(TEST_TIME1, GregorianChronology.getInstance()))); [EOL]     assertEquals(true, new MutableDateTime(TEST_TIME1, new MockEqualsChronology()).equals(new MutableDateTime(TEST_TIME1, new MockEqualsChronology()))); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME1, new MockEqualsChronology()).equals(new MutableDateTime(TEST_TIME1, ISOChronology.getInstance()))); [EOL] } <line_num>: 208,249
public String toString() { [EOL]     return null; [EOL] } <line_num>: 252,254
public long getMillis() { [EOL]     return TEST_TIME1; [EOL] } <line_num>: 255,257
public Chronology getChronology() { [EOL]     return ISOChronology.getInstance(); [EOL] } <line_num>: 258,260
public boolean equals(Object obj) { [EOL]     return obj instanceof MockEqualsChronology; [EOL] } <line_num>: 265,267
public DateTimeZone getZone() { [EOL]     return null; [EOL] } <line_num>: 268,270
public Chronology withUTC() { [EOL]     return this; [EOL] } <line_num>: 271,273
public Chronology withZone(DateTimeZone zone) { [EOL]     return this; [EOL] } <line_num>: 274,276
public String toString() { [EOL]     return ""; [EOL] } <line_num>: 277,279
public void testCompareTo() { [EOL]     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime test1a = new MutableDateTime(TEST_TIME1); [EOL]     assertEquals(0, test1.compareTo(test1a)); [EOL]     assertEquals(0, test1a.compareTo(test1)); [EOL]     assertEquals(0, test1.compareTo(test1)); [EOL]     assertEquals(0, test1a.compareTo(test1a)); [EOL]     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); [EOL]     assertEquals(-1, test1.compareTo(test2)); [EOL]     assertEquals(+1, test2.compareTo(test1)); [EOL]     MutableDateTime test3 = new MutableDateTime(TEST_TIME2, GregorianChronology.getInstance(PARIS)); [EOL]     assertEquals(-1, test1.compareTo(test3)); [EOL]     assertEquals(+1, test3.compareTo(test1)); [EOL]     assertEquals(0, test3.compareTo(test2)); [EOL]     assertEquals(+1, test2.compareTo(new MockInstant())); [EOL]     assertEquals(0, test1.compareTo(new MockInstant())); [EOL]     try { [EOL]         test1.compareTo(null); [EOL]         fail(); [EOL]     } catch (NullPointerException ex) { [EOL]     } [EOL] } <line_num>: 282,310
public void testIsEqual() { [EOL]     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime test1a = new MutableDateTime(TEST_TIME1); [EOL]     assertEquals(true, test1.isEqual(test1a)); [EOL]     assertEquals(true, test1a.isEqual(test1)); [EOL]     assertEquals(true, test1.isEqual(test1)); [EOL]     assertEquals(true, test1a.isEqual(test1a)); [EOL]     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); [EOL]     assertEquals(false, test1.isEqual(test2)); [EOL]     assertEquals(false, test2.isEqual(test1)); [EOL]     MutableDateTime test3 = new MutableDateTime(TEST_TIME2, GregorianChronology.getInstance(PARIS)); [EOL]     assertEquals(false, test1.isEqual(test3)); [EOL]     assertEquals(false, test3.isEqual(test1)); [EOL]     assertEquals(true, test3.isEqual(test2)); [EOL]     assertEquals(false, test2.isEqual(new MockInstant())); [EOL]     assertEquals(true, test1.isEqual(new MockInstant())); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW + 1).isEqual(null)); [EOL]     assertEquals(true, new MutableDateTime(TEST_TIME_NOW).isEqual(null)); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW - 1).isEqual(null)); [EOL] } <line_num>: 312,335
public void testIsBefore() { [EOL]     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime test1a = new MutableDateTime(TEST_TIME1); [EOL]     assertEquals(false, test1.isBefore(test1a)); [EOL]     assertEquals(false, test1a.isBefore(test1)); [EOL]     assertEquals(false, test1.isBefore(test1)); [EOL]     assertEquals(false, test1a.isBefore(test1a)); [EOL]     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); [EOL]     assertEquals(true, test1.isBefore(test2)); [EOL]     assertEquals(false, test2.isBefore(test1)); [EOL]     MutableDateTime test3 = new MutableDateTime(TEST_TIME2, GregorianChronology.getInstance(PARIS)); [EOL]     assertEquals(true, test1.isBefore(test3)); [EOL]     assertEquals(false, test3.isBefore(test1)); [EOL]     assertEquals(false, test3.isBefore(test2)); [EOL]     assertEquals(false, test2.isBefore(new MockInstant())); [EOL]     assertEquals(false, test1.isBefore(new MockInstant())); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW + 1).isBefore(null)); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW).isBefore(null)); [EOL]     assertEquals(true, new MutableDateTime(TEST_TIME_NOW - 1).isBefore(null)); [EOL] } <line_num>: 337,360
public void testIsAfter() { [EOL]     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime test1a = new MutableDateTime(TEST_TIME1); [EOL]     assertEquals(false, test1.isAfter(test1a)); [EOL]     assertEquals(false, test1a.isAfter(test1)); [EOL]     assertEquals(false, test1.isAfter(test1)); [EOL]     assertEquals(false, test1a.isAfter(test1a)); [EOL]     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); [EOL]     assertEquals(false, test1.isAfter(test2)); [EOL]     assertEquals(true, test2.isAfter(test1)); [EOL]     MutableDateTime test3 = new MutableDateTime(TEST_TIME2, GregorianChronology.getInstance(PARIS)); [EOL]     assertEquals(false, test1.isAfter(test3)); [EOL]     assertEquals(true, test3.isAfter(test1)); [EOL]     assertEquals(false, test3.isAfter(test2)); [EOL]     assertEquals(true, test2.isAfter(new MockInstant())); [EOL]     assertEquals(false, test1.isAfter(new MockInstant())); [EOL]     assertEquals(true, new MutableDateTime(TEST_TIME_NOW + 1).isAfter(null)); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW).isAfter(null)); [EOL]     assertEquals(false, new MutableDateTime(TEST_TIME_NOW - 1).isAfter(null)); [EOL] } <line_num>: 362,385
public void testSerialization() throws Exception { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); [EOL]     ByteArrayOutputStream baos = new ByteArrayOutputStream(); [EOL]     ObjectOutputStream oos = new ObjectOutputStream(baos); [EOL]     oos.writeObject(test); [EOL]     byte[] bytes = baos.toByteArray(); [EOL]     oos.close(); [EOL]     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); [EOL]     ObjectInputStream ois = new ObjectInputStream(bais); [EOL]     MutableDateTime result = (MutableDateTime) ois.readObject(); [EOL]     ois.close(); [EOL]     assertEquals(test, result); [EOL] } <line_num>: 388,403
public void testToString() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); [EOL]     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString()); [EOL]     test = new MutableDateTime(TEST_TIME_NOW, PARIS); [EOL]     assertEquals("2002-06-09T02:00:00.000+02:00", test.toString()); [EOL] } <line_num>: 406,412
public void testToString_String() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); [EOL]     assertEquals("2002 01", test.toString("yyyy HH")); [EOL]     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString((String) null)); [EOL] } <line_num>: 414,418
public void testToString_String_String() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); [EOL]     assertEquals("Sun 9/6", test.toString("EEE d/M", Locale.ENGLISH)); [EOL]     assertEquals("dim. 9/6", test.toString("EEE d/M", Locale.FRENCH)); [EOL]     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, Locale.ENGLISH)); [EOL]     assertEquals("Sun 9/6", test.toString("EEE d/M", null)); [EOL]     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, null)); [EOL] } <line_num>: 420,427
public void testToString_DTFormatter() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); [EOL]     assertEquals("2002 01", test.toString(DateTimeFormat.forPattern("yyyy HH"))); [EOL]     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString((DateTimeFormatter) null)); [EOL] } <line_num>: 429,433
public void testToInstant() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     Instant result = test.toInstant(); [EOL]     assertEquals(TEST_TIME1, result.getMillis()); [EOL] } <line_num>: 436,440
public void testToDateTime() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     DateTime result = test.toDateTime(); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(PARIS), result.getChronology()); [EOL] } <line_num>: 442,447
public void testToDateTimeISO() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     DateTime result = test.toDateTimeISO(); [EOL]     assertSame(DateTime.class, result.getClass()); [EOL]     assertSame(ISOChronology.class, result.getChronology().getClass()); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(PARIS), result.getChronology()); [EOL] } <line_num>: 449,456
public void testToDateTime_DateTimeZone() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = test.toMutableDateTime(LONDON); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(test.getChronology(), result.getChronology()); [EOL]     assertEquals(LONDON, result.getZone()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime(PARIS); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(PARIS, result.getZone()); [EOL]     test = new MutableDateTime(TEST_TIME1, GregorianChronology.getInstance(PARIS)); [EOL]     result = test.toMutableDateTime((DateTimeZone) null); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(GregorianChronology.getInstance(LONDON), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     result = test.toMutableDateTime((DateTimeZone) null); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(LONDON, result.getZone()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime((DateTimeZone) null); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(LONDON, result.getZone()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL] } <line_num>: 458,485
public void testToDateTime_Chronology() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = test.toMutableDateTime(ISOChronology.getInstance()); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime(GregorianChronology.getInstance(PARIS)); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(GregorianChronology.getInstance(PARIS), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1, GregorianChronology.getInstance(PARIS)); [EOL]     result = test.toMutableDateTime((Chronology) null); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime((Chronology) null); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL] } <line_num>: 487,507
public void testToMutableDateTime() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     MutableDateTime result = test.toMutableDateTime(); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(PARIS), result.getChronology()); [EOL] } <line_num>: 509,515
public void testToMutableDateTimeISO() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     MutableDateTime result = test.toMutableDateTimeISO(); [EOL]     assertSame(MutableDateTime.class, result.getClass()); [EOL]     assertSame(ISOChronology.class, result.getChronology().getClass()); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(PARIS), result.getChronology()); [EOL]     assertNotSame(test, result); [EOL] } <line_num>: 517,525
public void testToMutableDateTime_DateTimeZone() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = test.toMutableDateTime(LONDON); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(LONDON), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime(PARIS); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(PARIS), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     result = test.toMutableDateTime((DateTimeZone) null); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime((DateTimeZone) null); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL] } <line_num>: 527,551
public void testToMutableDateTime_Chronology() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = test.toMutableDateTime(ISOChronology.getInstance()); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime(GregorianChronology.getInstance(PARIS)); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(GregorianChronology.getInstance(PARIS), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1, GregorianChronology.getInstance(PARIS)); [EOL]     result = test.toMutableDateTime((Chronology) null); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL]     test = new MutableDateTime(TEST_TIME1); [EOL]     result = test.toMutableDateTime((Chronology) null); [EOL]     assertTrue(test != result); [EOL]     assertEquals(test.getMillis(), result.getMillis()); [EOL]     assertEquals(ISOChronology.getInstance(), result.getChronology()); [EOL] } <line_num>: 553,577
public void testToDate() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     Date result = test.toDate(); [EOL]     assertEquals(test.getMillis(), result.getTime()); [EOL] } <line_num>: 579,583
public void testToCalendar_Locale() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     Calendar result = test.toCalendar(null); [EOL]     assertEquals(test.getMillis(), result.getTime().getTime()); [EOL]     assertEquals(TimeZone.getTimeZone("Europe/London"), result.getTimeZone()); [EOL]     test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     result = test.toCalendar(null); [EOL]     assertEquals(test.getMillis(), result.getTime().getTime()); [EOL]     assertEquals(TimeZone.getTimeZone("Europe/Paris"), result.getTimeZone()); [EOL]     test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     result = test.toCalendar(Locale.UK); [EOL]     assertEquals(test.getMillis(), result.getTime().getTime()); [EOL]     assertEquals(TimeZone.getTimeZone("Europe/Paris"), result.getTimeZone()); [EOL] } <line_num>: 585,600
public void testToGregorianCalendar() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     GregorianCalendar result = test.toGregorianCalendar(); [EOL]     assertEquals(test.getMillis(), result.getTime().getTime()); [EOL]     assertEquals(TimeZone.getTimeZone("Europe/London"), result.getTimeZone()); [EOL]     test = new MutableDateTime(TEST_TIME1, PARIS); [EOL]     result = test.toGregorianCalendar(); [EOL]     assertEquals(test.getMillis(), result.getTime().getTime()); [EOL]     assertEquals(TimeZone.getTimeZone("Europe/Paris"), result.getTimeZone()); [EOL] } <line_num>: 602,612
public void testClone() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = (MutableDateTime) test.clone(); [EOL]     assertEquals(true, test.equals(result)); [EOL]     assertEquals(true, test != result); [EOL] } <line_num>: 614,619
public void testCopy() { [EOL]     MutableDateTime test = new MutableDateTime(TEST_TIME1); [EOL]     MutableDateTime result = test.copy(); [EOL]     assertEquals(true, test.equals(result)); [EOL]     assertEquals(true, test != result); [EOL] } <line_num>: 621,626
public void testRounding1() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay()); [EOL]     assertEquals("2002-06-09T05:00:00.000+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_FLOOR, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL] } <line_num>: 628,634
public void testRounding2() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_CEILING); [EOL]     assertEquals("2002-06-09T06:00:00.000+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_CEILING, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL] } <line_num>: 636,642
public void testRounding3() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_CEILING); [EOL]     assertEquals("2002-06-09T05:00:00.000+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_HALF_CEILING, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL]     test = new MutableDateTime(2002, 6, 9, 5, 30, 0, 0); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_CEILING); [EOL]     assertEquals("2002-06-09T06:00:00.000+01:00", test.toString()); [EOL] } <line_num>: 644,654
public void testRounding4() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_FLOOR); [EOL]     assertEquals("2002-06-09T05:00:00.000+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_HALF_FLOOR, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL]     test = new MutableDateTime(2002, 6, 9, 5, 30, 0, 0); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_FLOOR); [EOL]     assertEquals("2002-06-09T05:00:00.000+01:00", test.toString()); [EOL] } <line_num>: 656,666
public void testRounding5() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_EVEN); [EOL]     assertEquals("2002-06-09T05:00:00.000+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_HALF_EVEN, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL]     test = new MutableDateTime(2002, 6, 9, 5, 30, 0, 0); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_EVEN); [EOL]     assertEquals("2002-06-09T06:00:00.000+01:00", test.toString()); [EOL]     test = new MutableDateTime(2002, 6, 9, 4, 30, 0, 0); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_HALF_EVEN); [EOL]     assertEquals("2002-06-09T04:00:00.000+01:00", test.toString()); [EOL] } <line_num>: 668,682
public void testRounding6() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_NONE); [EOL]     assertEquals("2002-06-09T05:06:07.008+01:00", test.toString()); [EOL]     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); [EOL]     assertEquals(null, test.getRoundingField()); [EOL] } <line_num>: 684,690
public void testRounding7() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     try { [EOL]         test.setRounding(ISOChronology.getInstance().hourOfDay(), -1); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 692,698
public void testRounding8() { [EOL]     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); [EOL]     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); [EOL]     assertEquals(null, test.getRoundingField()); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_CEILING); [EOL]     assertEquals(MutableDateTime.ROUND_CEILING, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_NONE); [EOL]     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); [EOL]     assertEquals(null, test.getRoundingField()); [EOL]     test.setRounding(null, -1); [EOL]     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); [EOL]     assertEquals(null, test.getRoundingField()); [EOL]     test.setRounding(ISOChronology.getInstance().hourOfDay()); [EOL]     assertEquals(MutableDateTime.ROUND_FLOOR, test.getRoundingMode()); [EOL]     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); [EOL]     test.setRounding(null); [EOL]     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); [EOL]     assertEquals(null, test.getRoundingField()); [EOL] } <line_num>: 700,724
public DurationFieldType getDurationType() { [EOL]     return DurationFieldType.weeks(); [EOL] } <line_num>: 735,737
public DurationFieldType getRangeDurationType() { [EOL]     return null; [EOL] } <line_num>: 738,740
public DateTimeField getField(Chronology chronology) { [EOL]     return UnsupportedDateTimeField.getInstance(this, UnsupportedDurationField.getInstance(getDurationType())); [EOL] } <line_num>: 741,743
public void testProperty() { [EOL]     MutableDateTime test = new MutableDateTime(); [EOL]     assertEquals(test.year(), test.property(DateTimeFieldType.year())); [EOL]     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); [EOL]     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); [EOL]     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); [EOL]     DateTimeFieldType bad = new DateTimeFieldType("bad") { [EOL]  [EOL]         private static final long serialVersionUID = 1L; [EOL]  [EOL]         public DurationFieldType getDurationType() { [EOL]             return DurationFieldType.weeks(); [EOL]         } [EOL]  [EOL]         public DurationFieldType getRangeDurationType() { [EOL]             return null; [EOL]         } [EOL]  [EOL]         public DateTimeField getField(Chronology chronology) { [EOL]             return UnsupportedDateTimeField.getInstance(this, UnsupportedDurationField.getInstance(getDurationType())); [EOL]         } [EOL]     }; [EOL]     try { [EOL]         test.property(bad); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         test.property(null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 727,753