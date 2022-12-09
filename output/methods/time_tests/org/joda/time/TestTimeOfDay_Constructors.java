public TestTimeOfDay_Constructors(String name) { [EOL]     super(name); [EOL] } <line_num>: 72,74
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 64,66
public static TestSuite suite() { [EOL]     return new TestSuite(TestTimeOfDay_Constructors.class); [EOL] } <line_num>: 68,70
protected void setUp() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]     zone = DateTimeZone.getDefault(); [EOL]     DateTimeZone.setDefault(LONDON); [EOL]     java.util.TimeZone.setDefault(LONDON.toTimeZone()); [EOL] } <line_num>: 76,81
protected void tearDown() throws Exception { [EOL]     DateTimeUtils.setCurrentMillisSystem(); [EOL]     DateTimeZone.setDefault(zone); [EOL]     java.util.TimeZone.setDefault(zone.toTimeZone()); [EOL]     zone = null; [EOL] } <line_num>: 83,88
public void testConstantMidnight() throws Throwable { [EOL]     TimeOfDay test = TimeOfDay.MIDNIGHT; [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(0, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 94,101
public void testFactory_FromCalendarFields() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1970, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     TimeOfDay expected = new TimeOfDay(4, 5, 6, 7); [EOL]     assertEquals(expected, TimeOfDay.fromCalendarFields(cal)); [EOL]     try { [EOL]         TimeOfDay.fromCalendarFields(null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 104,113
public void testFactory_FromDateFields_after1970() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1970, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     TimeOfDay expected = new TimeOfDay(4, 5, 6, 7); [EOL]     assertEquals(expected, TimeOfDay.fromDateFields(cal.getTime())); [EOL] } <line_num>: 116,121
public void testFactory_FromDateFields_before1970() throws Exception { [EOL]     GregorianCalendar cal = new GregorianCalendar(1969, 1, 3, 4, 5, 6); [EOL]     cal.set(Calendar.MILLISECOND, 7); [EOL]     TimeOfDay expected = new TimeOfDay(4, 5, 6, 7); [EOL]     assertEquals(expected, TimeOfDay.fromDateFields(cal.getTime())); [EOL] } <line_num>: 123,128
public void testFactory_FromDateFields_null() throws Exception { [EOL]     try { [EOL]         TimeOfDay.fromDateFields(null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 130,135
public void testFactoryMillisOfDay_long1() throws Throwable { [EOL]     TimeOfDay test = TimeOfDay.fromMillisOfDay(TEST_TIME1); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 141,148
public void testFactoryMillisOfDay_long1_Chronology() throws Throwable { [EOL]     TimeOfDay test = TimeOfDay.fromMillisOfDay(TEST_TIME1, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(1, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 153,160
public void testFactoryMillisOfDay_long_nullChronology() throws Throwable { [EOL]     TimeOfDay test = TimeOfDay.fromMillisOfDay(TEST_TIME1, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 165,172
public void testConstructor() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 178,185
public void testConstructor_DateTimeZone() throws Throwable { [EOL]     DateTime dt = new DateTime(2005, 6, 8, 23, 59, 30, 40, LONDON); [EOL]     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); [EOL]     TimeOfDay test = new TimeOfDay(LONDON); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(23, test.getHourOfDay()); [EOL]     assertEquals(59, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     test = new TimeOfDay(PARIS); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(0, test.getHourOfDay()); [EOL]     assertEquals(59, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 190,208
public void testConstructor_nullDateTimeZone() throws Throwable { [EOL]     DateTime dt = new DateTime(2005, 6, 8, 23, 59, 30, 40, LONDON); [EOL]     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); [EOL]     TimeOfDay test = new TimeOfDay((DateTimeZone) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(23, test.getHourOfDay()); [EOL]     assertEquals(59, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 213,224
public void testConstructor_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 229,236
public void testConstructor_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay((Chronology) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 241,248
public void testConstructor_long1() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(TEST_TIME1); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 254,261
public void testConstructor_long2() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(TEST_TIME2); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(5 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(6, test.getMinuteOfHour()); [EOL]     assertEquals(7, test.getSecondOfMinute()); [EOL]     assertEquals(8, test.getMillisOfSecond()); [EOL] } <line_num>: 266,273
public void testConstructor_long1_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(TEST_TIME1, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 278,285
public void testConstructor_long2_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(TEST_TIME2, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(5 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(6, test.getMinuteOfHour()); [EOL]     assertEquals(7, test.getSecondOfMinute()); [EOL]     assertEquals(8, test.getMillisOfSecond()); [EOL] } <line_num>: 290,297
public void testConstructor_long_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(TEST_TIME1, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 302,309
public void testConstructor_Object1() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     TimeOfDay test = new TimeOfDay(date); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 315,323
public void testConstructor_Object2() throws Throwable { [EOL]     Calendar cal = new GregorianCalendar(); [EOL]     cal.setTime(new Date(TEST_TIME1)); [EOL]     TimeOfDay test = new TimeOfDay(cal); [EOL]     assertEquals(GJChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 328,337
public void testConstructor_nullObject() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay((Object) null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 342,349
public void testConstructor_todObject() throws Throwable { [EOL]     TimeOfDay base = new TimeOfDay(10, 20, 30, 40, CopticChronology.getInstance(PARIS)); [EOL]     TimeOfDay test = new TimeOfDay(base); [EOL]     assertEquals(CopticChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 354,362
public void testConstructor_ObjectString1() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("10:20:30.040"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 364,371
public void testConstructor_ObjectString2() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("10:20:30.040+04:00"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET - 4, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 373,380
public void testConstructor_ObjectString3() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("T10:20:30.040"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 382,389
public void testConstructor_ObjectString4() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("T10:20:30.040+04:00"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET - 4, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 391,398
public void testConstructor_ObjectString5() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("10:20"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 400,407
public void testConstructor_ObjectString6() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("10"); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(0, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 409,416
public void testConstructor_ObjectStringEx1() throws Throwable { [EOL]     try { [EOL]         new TimeOfDay("1970-04-06"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 418,423
public void testConstructor_ObjectStringEx2() throws Throwable { [EOL]     try { [EOL]         new TimeOfDay("1970-04-06T+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 425,430
public void testConstructor_ObjectStringEx3() throws Throwable { [EOL]     try { [EOL]         new TimeOfDay("1970-04-06T10:20:30.040"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 432,437
public void testConstructor_ObjectStringEx4() throws Throwable { [EOL]     try { [EOL]         new TimeOfDay("1970-04-06T10:20:30.040+14:00"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 439,444
public void testConstructor_Object_Chronology() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     TimeOfDay test = new TimeOfDay(date, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 450,458
public void testConstructor2_Object_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay("T10:20"); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay("T1020"); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 463,474
public void testConstructor_nullObject_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay((Object) null, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 479,486
public void testConstructor_Object_nullChronology() throws Throwable { [EOL]     Date date = new Date(TEST_TIME1); [EOL]     TimeOfDay test = new TimeOfDay(date, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(1 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(2, test.getMinuteOfHour()); [EOL]     assertEquals(3, test.getSecondOfMinute()); [EOL]     assertEquals(4, test.getMillisOfSecond()); [EOL] } <line_num>: 491,499
public void testConstructor_nullObject_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay((Object) null, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10 + OFFSET, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 504,511
public void testConstructor_int_int() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 517,540
public void testConstructor_int_int_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 545,568
public void testConstructor_int_int_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(0, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 573,580
public void testConstructor_int_int_int() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20, 30); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20, 30); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1, 30); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60, 30); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, -1); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 60); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 585,616
public void testConstructor_int_int_int_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20, 30, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20, 30, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1, 30, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60, 30, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, -1, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 60, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 621,652
public void testConstructor_int_int_int_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(0, test.getMillisOfSecond()); [EOL] } <line_num>: 657,664
public void testConstructor_int_int_int_int() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60, 30, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, -1, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 60, 40); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 30, -1); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 30, 1000); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 669,708
public void testConstructor_int_int_int_int_Chronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30, 40, JulianChronology.getInstance()); [EOL]     assertEquals(JulianChronology.getInstanceUTC(), test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL]     try { [EOL]         new TimeOfDay(-1, 20, 30, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(24, 20, 30, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, -1, 30, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 60, 30, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, -1, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 60, 40, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 30, -1, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL]     try { [EOL]         new TimeOfDay(10, 20, 30, 1000, JulianChronology.getInstance()); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 713,752
public void testConstructor_int_int_int_int_nullChronology() throws Throwable { [EOL]     TimeOfDay test = new TimeOfDay(10, 20, 30, 40, null); [EOL]     assertEquals(ISO_UTC, test.getChronology()); [EOL]     assertEquals(10, test.getHourOfDay()); [EOL]     assertEquals(20, test.getMinuteOfHour()); [EOL]     assertEquals(30, test.getSecondOfMinute()); [EOL]     assertEquals(40, test.getMillisOfSecond()); [EOL] } <line_num>: 757,764
