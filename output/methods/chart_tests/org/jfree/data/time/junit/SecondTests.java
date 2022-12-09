public SecondTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 90,92
public static Test suite() { [EOL]     return new TestSuite(SecondTests.class); [EOL] } <line_num>: 81,83
protected void setUp() { [EOL] } <line_num>: 97,99
public void testEqualsSelf() { [EOL]     Second second = new Second(); [EOL]     assertTrue(second.equals(second)); [EOL] } <line_num>: 106,109
public void testEquals() { [EOL]     Day day1 = new Day(29, MonthConstants.MARCH, 2002); [EOL]     Hour hour1 = new Hour(15, day1); [EOL]     Minute minute1 = new Minute(15, hour1); [EOL]     Second second1 = new Second(34, minute1); [EOL]     Day day2 = new Day(29, MonthConstants.MARCH, 2002); [EOL]     Hour hour2 = new Hour(15, day2); [EOL]     Minute minute2 = new Minute(15, hour2); [EOL]     Second second2 = new Second(34, minute2); [EOL]     assertTrue(second1.equals(second2)); [EOL] } <line_num>: 114,124
public void testDateConstructor1() { [EOL]     TimeZone zone = TimeZone.getTimeZone("GMT"); [EOL]     Calendar c = new GregorianCalendar(zone); [EOL]     Second s1 = new Second(new Date(1016729758999L), zone); [EOL]     Second s2 = new Second(new Date(1016729759000L), zone); [EOL]     assertEquals(58, s1.getSecond()); [EOL]     assertEquals(1016729758999L, s1.getLastMillisecond(c)); [EOL]     assertEquals(59, s2.getSecond()); [EOL]     assertEquals(1016729759000L, s2.getFirstMillisecond(c)); [EOL] } <line_num>: 130,143
public void testDateConstructor2() { [EOL]     TimeZone zone = TimeZone.getTimeZone("America/Chicago"); [EOL]     Calendar c = new GregorianCalendar(zone); [EOL]     Second s1 = new Second(new Date(1016751358999L), zone); [EOL]     Second s2 = new Second(new Date(1016751359000L), zone); [EOL]     assertEquals(58, s1.getSecond()); [EOL]     assertEquals(1016751358999L, s1.getLastMillisecond(c)); [EOL]     assertEquals(59, s2.getSecond()); [EOL]     assertEquals(1016751359000L, s2.getFirstMillisecond(c)); [EOL] } <line_num>: 149,162
public void testSerialization() { [EOL]     Second s1 = new Second(); [EOL]     Second s2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(s1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         s2 = (Second) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(s1, s2); [EOL] } <line_num>: 167,189
public void testHashcode() { [EOL]     Second s1 = new Second(13, 45, 5, 1, 2, 2003); [EOL]     Second s2 = new Second(13, 45, 5, 1, 2, 2003); [EOL]     assertTrue(s1.equals(s2)); [EOL]     int h1 = s1.hashCode(); [EOL]     int h2 = s2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 194,201
public void testNotCloneable() { [EOL]     Second s = new Second(13, 45, 5, 1, 2, 2003); [EOL]     assertFalse(s instanceof Cloneable); [EOL] } <line_num>: 207,210
public void testGetFirstMillisecond() { [EOL]     Locale saved = Locale.getDefault(); [EOL]     Locale.setDefault(Locale.UK); [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Second s = new Second(15, 43, 15, 1, 4, 2006); [EOL]     assertEquals(1143902595000L, s.getFirstMillisecond()); [EOL]     Locale.setDefault(saved); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 215,224
public void testGetFirstMillisecondWithTimeZone() { [EOL]     Second s = new Second(50, 59, 15, 1, 4, 1950); [EOL]     TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles"); [EOL]     Calendar c = new GregorianCalendar(zone); [EOL]     assertEquals(-623289610000L, s.getFirstMillisecond(c)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         s.getFirstMillisecond((Calendar) null); [EOL]     } catch (NullPointerException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 229,244
public void testGetFirstMillisecondWithCalendar() { [EOL]     Second s = new Second(55, 40, 2, 15, 4, 2000); [EOL]     GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY); [EOL]     calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt")); [EOL]     assertEquals(955766455000L, s.getFirstMillisecond(calendar)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         s.getFirstMillisecond((Calendar) null); [EOL]     } catch (NullPointerException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 249,264
public void testGetLastMillisecond() { [EOL]     Locale saved = Locale.getDefault(); [EOL]     Locale.setDefault(Locale.UK); [EOL]     TimeZone savedZone = TimeZone.getDefault(); [EOL]     TimeZone.setDefault(TimeZone.getTimeZone("Europe/London")); [EOL]     Second s = new Second(1, 1, 1, 1, 1, 1970); [EOL]     assertEquals(61999L, s.getLastMillisecond()); [EOL]     Locale.setDefault(saved); [EOL]     TimeZone.setDefault(savedZone); [EOL] } <line_num>: 269,278
public void testGetLastMillisecondWithTimeZone() { [EOL]     Second s = new Second(55, 1, 2, 7, 7, 1950); [EOL]     TimeZone zone = TimeZone.getTimeZone("America/Los_Angeles"); [EOL]     Calendar c = new GregorianCalendar(zone); [EOL]     assertEquals(-614962684001L, s.getLastMillisecond(c)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         s.getLastMillisecond((Calendar) null); [EOL]     } catch (NullPointerException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 283,298
public void testGetLastMillisecondWithCalendar() { [EOL]     Second s = new Second(50, 45, 21, 21, 4, 2001); [EOL]     GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY); [EOL]     calendar.setTimeZone(TimeZone.getTimeZone("Europe/Frankfurt")); [EOL]     assertEquals(987889550999L, s.getLastMillisecond(calendar)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         s.getLastMillisecond((Calendar) null); [EOL]     } catch (NullPointerException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 303,318
public void testGetSerialIndex() { [EOL]     Second s = new Second(1, 1, 1, 1, 1, 2000); [EOL]     assertEquals(3155850061L, s.getSerialIndex()); [EOL]     s = new Second(1, 1, 1, 1, 1, 1900); [EOL]     assertEquals(176461L, s.getSerialIndex()); [EOL] } <line_num>: 323,328
public void testNext() { [EOL]     Second s = new Second(55, 30, 1, 12, 12, 2000); [EOL]     s = (Second) s.next(); [EOL]     assertEquals(2000, s.getMinute().getHour().getYear()); [EOL]     assertEquals(12, s.getMinute().getHour().getMonth()); [EOL]     assertEquals(12, s.getMinute().getHour().getDayOfMonth()); [EOL]     assertEquals(1, s.getMinute().getHour().getHour()); [EOL]     assertEquals(30, s.getMinute().getMinute()); [EOL]     assertEquals(56, s.getSecond()); [EOL]     s = new Second(59, 59, 23, 31, 12, 9999); [EOL]     assertNull(s.next()); [EOL] } <line_num>: 333,344
public void testGetStart() { [EOL]     Locale saved = Locale.getDefault(); [EOL]     Locale.setDefault(Locale.ITALY); [EOL]     Calendar cal = Calendar.getInstance(Locale.ITALY); [EOL]     cal.set(2006, Calendar.JANUARY, 16, 3, 47, 55); [EOL]     cal.set(Calendar.MILLISECOND, 0); [EOL]     Second s = new Second(55, 47, 3, 16, 1, 2006); [EOL]     assertEquals(cal.getTime(), s.getStart()); [EOL]     Locale.setDefault(saved); [EOL] } <line_num>: 349,358
public void testGetEnd() { [EOL]     Locale saved = Locale.getDefault(); [EOL]     Locale.setDefault(Locale.ITALY); [EOL]     Calendar cal = Calendar.getInstance(Locale.ITALY); [EOL]     cal.set(2006, Calendar.JANUARY, 16, 3, 47, 55); [EOL]     cal.set(Calendar.MILLISECOND, 999); [EOL]     Second s = new Second(55, 47, 3, 16, 1, 2006); [EOL]     assertEquals(cal.getTime(), s.getEnd()); [EOL]     Locale.setDefault(saved); [EOL] } <line_num>: 363,372