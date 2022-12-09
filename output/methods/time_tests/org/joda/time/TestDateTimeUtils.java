public TestDateTimeUtils(String name) { [EOL]     super(name); [EOL] } <line_num>: 128,130
public PermissionCollection getPermissions(CodeSource codesource) { [EOL]     Permissions p = new Permissions(); [EOL]     p.add(new AllPermission()); [EOL]     return p; [EOL] } <line_num>: 94,98
public void refresh() { [EOL] } <line_num>: 99,100
public boolean implies(ProtectionDomain domain, Permission permission) { [EOL]     if (permission instanceof JodaTimePermission) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 101,107
public PermissionCollection getPermissions(CodeSource codesource) { [EOL]     Permissions p = new Permissions(); [EOL]     p.add(new AllPermission()); [EOL]     return p; [EOL] } <line_num>: 110,114
public void refresh() { [EOL] } <line_num>: 115,116
public static void main(String[] args) { [EOL]     junit.textui.TestRunner.run(suite()); [EOL] } <line_num>: 120,122
public static TestSuite suite() { [EOL]     return new TestSuite(TestDateTimeUtils.class); [EOL] } <line_num>: 124,126
protected void setUp() throws Exception { [EOL] } <line_num>: 132,133
protected void tearDown() throws Exception { [EOL] } <line_num>: 135,136
public void testTest() { [EOL]     assertEquals("2002-06-09T00:00:00.000Z", new Instant(TEST_TIME_NOW).toString()); [EOL]     assertEquals("2002-04-05T12:24:00.000Z", new Instant(TEST_TIME1).toString()); [EOL]     assertEquals("2003-05-06T14:28:00.000Z", new Instant(TEST_TIME2).toString()); [EOL] } <line_num>: 139,143
public void testClass() { [EOL]     Class<?> cls = DateTimeUtils.class; [EOL]     assertEquals(true, Modifier.isPublic(cls.getModifiers())); [EOL]     assertEquals(false, Modifier.isFinal(cls.getModifiers())); [EOL]     assertEquals(1, cls.getDeclaredConstructors().length); [EOL]     assertEquals(true, Modifier.isProtected(cls.getDeclaredConstructors()[0].getModifiers())); [EOL]     new DateTimeUtils() { [EOL]     }; [EOL] } <line_num>: 146,155
public void testSystemMillis() { [EOL]     long nowSystem = System.currentTimeMillis(); [EOL]     long now = DateTimeUtils.currentTimeMillis(); [EOL]     assertTrue((now >= nowSystem)); [EOL]     assertTrue((now - nowSystem) < 10000L); [EOL] } <line_num>: 158,163
public void testSystemMillisSecurity() { [EOL]     if (OLD_JDK) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         try { [EOL]             Policy.setPolicy(RESTRICT); [EOL]             System.setSecurityManager(new SecurityManager()); [EOL]             DateTimeUtils.setCurrentMillisSystem(); [EOL]             fail(); [EOL]         } catch (SecurityException ex) { [EOL]         } finally { [EOL]             System.setSecurityManager(null); [EOL]             Policy.setPolicy(ALLOW); [EOL]         } [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 166,185
public void testFixedMillis() { [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisFixed(0L); [EOL]         assertEquals(0L, DateTimeUtils.currentTimeMillis()); [EOL]         assertEquals(0L, DateTimeUtils.currentTimeMillis()); [EOL]         assertEquals(0L, DateTimeUtils.currentTimeMillis()); [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL]     long nowSystem = System.currentTimeMillis(); [EOL]     long now = DateTimeUtils.currentTimeMillis(); [EOL]     assertTrue((now >= nowSystem)); [EOL]     assertTrue((now - nowSystem) < 10000L); [EOL] } <line_num>: 188,201
public void testFixedMillisSecurity() { [EOL]     if (OLD_JDK) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         try { [EOL]             Policy.setPolicy(RESTRICT); [EOL]             System.setSecurityManager(new SecurityManager()); [EOL]             DateTimeUtils.setCurrentMillisFixed(0L); [EOL]             fail(); [EOL]         } catch (SecurityException ex) { [EOL]         } finally { [EOL]             System.setSecurityManager(null); [EOL]             Policy.setPolicy(ALLOW); [EOL]         } [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 204,223
public void testOffsetMillis() { [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisOffset(-24 * 60 * 60 * 1000); [EOL]         long nowSystem = System.currentTimeMillis(); [EOL]         long now = DateTimeUtils.currentTimeMillis(); [EOL]         long nowAdjustDay = now + (24 * 60 * 60 * 1000); [EOL]         assertTrue((now < nowSystem)); [EOL]         assertTrue((nowAdjustDay >= nowSystem)); [EOL]         assertTrue((nowAdjustDay - nowSystem) < 10000L); [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL]     long nowSystem = System.currentTimeMillis(); [EOL]     long now = DateTimeUtils.currentTimeMillis(); [EOL]     assertTrue((now >= nowSystem)); [EOL]     assertTrue((now - nowSystem) < 10000L); [EOL] } <line_num>: 226,243
public void testOffsetMillisToZero() { [EOL] } <line_num>: 246,246
public void testOffsetMillisSecurity() { [EOL]     if (OLD_JDK) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         try { [EOL]             Policy.setPolicy(RESTRICT); [EOL]             System.setSecurityManager(new SecurityManager()); [EOL]             DateTimeUtils.setCurrentMillisOffset(-24 * 60 * 60 * 1000); [EOL]             fail(); [EOL]         } catch (SecurityException ex) { [EOL]         } finally { [EOL]             System.setSecurityManager(null); [EOL]             Policy.setPolicy(ALLOW); [EOL]         } [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 262,281
public long getMillis() { [EOL]     return 1L; [EOL] } <line_num>: 287,289
public void testMillisProvider() { [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisProvider(new MillisProvider() { [EOL]  [EOL]             public long getMillis() { [EOL]                 return 1L; [EOL]             } [EOL]         }); [EOL]         assertEquals(1L, DateTimeUtils.currentTimeMillis()); [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 284,295
public void testMillisProvider_null() { [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisProvider(null); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 297,303
public long getMillis() { [EOL]     return 0L; [EOL] } <line_num>: 315,317
public void testMillisProviderSecurity() { [EOL]     if (OLD_JDK) { [EOL]         return; [EOL]     } [EOL]     try { [EOL]         try { [EOL]             Policy.setPolicy(RESTRICT); [EOL]             System.setSecurityManager(new SecurityManager()); [EOL]             DateTimeUtils.setCurrentMillisProvider(new MillisProvider() { [EOL]  [EOL]                 public long getMillis() { [EOL]                     return 0L; [EOL]                 } [EOL]             }); [EOL]             fail(); [EOL]         } catch (SecurityException ex) { [EOL]         } finally { [EOL]             System.setSecurityManager(null); [EOL]             Policy.setPolicy(ALLOW); [EOL]         } [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 306,329
public void testGetInstantMillis_RI() { [EOL]     Instant i = new Instant(123L); [EOL]     assertEquals(123L, DateTimeUtils.getInstantMillis(i)); [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]         assertEquals(TEST_TIME_NOW, DateTimeUtils.getInstantMillis(null)); [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 332,341
public long getMillis() { [EOL]     return 0L; [EOL] } <line_num>: 352,354
public Chronology getChronology() { [EOL]     return null; [EOL] } <line_num>: 355,357
public void testGetInstantChronology_RI() { [EOL]     DateTime dt = new DateTime(123L, BuddhistChronology.getInstance()); [EOL]     assertEquals(BuddhistChronology.getInstance(), DateTimeUtils.getInstantChronology(dt)); [EOL]     Instant i = new Instant(123L); [EOL]     assertEquals(ISOChronology.getInstanceUTC(), DateTimeUtils.getInstantChronology(i)); [EOL]     AbstractInstant ai = new AbstractInstant() { [EOL]  [EOL]         public long getMillis() { [EOL]             return 0L; [EOL]         } [EOL]  [EOL]         public Chronology getChronology() { [EOL]             return null; [EOL]         } [EOL]     }; [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getInstantChronology(ai)); [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getInstantChronology(null)); [EOL] } <line_num>: 344,362
public Chronology getChronology() { [EOL]     return null; [EOL] } <line_num>: 374,376
public void testGetIntervalChronology_RInterval() { [EOL]     Interval dt = new Interval(123L, 456L, BuddhistChronology.getInstance()); [EOL]     assertEquals(BuddhistChronology.getInstance(), DateTimeUtils.getIntervalChronology(dt)); [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getIntervalChronology(null)); [EOL]     MutableInterval ai = new MutableInterval() { [EOL]  [EOL]         private static final long serialVersionUID = 1L; [EOL]  [EOL]         public Chronology getChronology() { [EOL]             return null; [EOL]         } [EOL]     }; [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getIntervalChronology(ai)); [EOL] } <line_num>: 365,379
public void testGetIntervalChronology_RI_RI() { [EOL]     DateTime dt1 = new DateTime(123L, BuddhistChronology.getInstance()); [EOL]     DateTime dt2 = new DateTime(123L, CopticChronology.getInstance()); [EOL]     assertEquals(BuddhistChronology.getInstance(), DateTimeUtils.getIntervalChronology(dt1, dt2)); [EOL]     assertEquals(BuddhistChronology.getInstance(), DateTimeUtils.getIntervalChronology(dt1, null)); [EOL]     assertEquals(CopticChronology.getInstance(), DateTimeUtils.getIntervalChronology(null, dt2)); [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getIntervalChronology(null, null)); [EOL] } <line_num>: 382,389
public void testGetReadableInterval_ReadableInterval() { [EOL]     ReadableInterval input = new Interval(0, 100L); [EOL]     assertEquals(input, DateTimeUtils.getReadableInterval(input)); [EOL]     try { [EOL]         DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW); [EOL]         assertEquals(new Interval(TEST_TIME_NOW, TEST_TIME_NOW), DateTimeUtils.getReadableInterval(null)); [EOL]     } finally { [EOL]         DateTimeUtils.setCurrentMillisSystem(); [EOL]     } [EOL] } <line_num>: 392,402
public void testGetChronology_Chronology() { [EOL]     assertEquals(BuddhistChronology.getInstance(), DateTimeUtils.getChronology(BuddhistChronology.getInstance())); [EOL]     assertEquals(ISOChronology.getInstance(), DateTimeUtils.getChronology(null)); [EOL] } <line_num>: 405,408
public void testGetZone_Zone() { [EOL]     assertEquals(PARIS, DateTimeUtils.getZone(PARIS)); [EOL]     assertEquals(DateTimeZone.getDefault(), DateTimeUtils.getZone(null)); [EOL] } <line_num>: 411,414
public void testGetPeriodType_PeriodType() { [EOL]     assertEquals(PeriodType.dayTime(), DateTimeUtils.getPeriodType(PeriodType.dayTime())); [EOL]     assertEquals(PeriodType.standard(), DateTimeUtils.getPeriodType(null)); [EOL] } <line_num>: 417,420
public void testGetDurationMillis_RI() { [EOL]     Duration dur = new Duration(123L); [EOL]     assertEquals(123L, DateTimeUtils.getDurationMillis(dur)); [EOL]     assertEquals(0L, DateTimeUtils.getDurationMillis(null)); [EOL] } <line_num>: 423,427
@SuppressWarnings("deprecation") [EOL] public void testIsContiguous_RP() { [EOL]     YearMonthDay ymd = new YearMonthDay(2005, 6, 9); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(ymd)); [EOL]     TimeOfDay tod = new TimeOfDay(12, 20, 30, 0); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(tod)); [EOL]     Partial year = new Partial(DateTimeFieldType.year(), 2005); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(year)); [EOL]     Partial hourOfDay = new Partial(DateTimeFieldType.hourOfDay(), 12); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(hourOfDay)); [EOL]     Partial yearHour = year.with(DateTimeFieldType.hourOfDay(), 12); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(yearHour)); [EOL]     Partial ymdd = new Partial(ymd).with(DateTimeFieldType.dayOfWeek(), 2); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(ymdd)); [EOL]     Partial dd = new Partial(DateTimeFieldType.dayOfMonth(), 13).with(DateTimeFieldType.dayOfWeek(), 5); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(dd)); [EOL]     try { [EOL]         DateTimeUtils.isContiguous((ReadablePartial) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 430,451
@SuppressWarnings("deprecation") [EOL] public void testIsContiguous_RP_GJChronology() { [EOL]     YearMonthDay ymd = new YearMonthDay(2005, 6, 9, GJ); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(ymd)); [EOL]     TimeOfDay tod = new TimeOfDay(12, 20, 30, 0, GJ); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(tod)); [EOL]     Partial year = new Partial(DateTimeFieldType.year(), 2005, GJ); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(year)); [EOL]     Partial hourOfDay = new Partial(DateTimeFieldType.hourOfDay(), 12, GJ); [EOL]     assertEquals(true, DateTimeUtils.isContiguous(hourOfDay)); [EOL]     Partial yearHour = year.with(DateTimeFieldType.hourOfDay(), 12); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(yearHour)); [EOL]     Partial ymdd = new Partial(ymd).with(DateTimeFieldType.dayOfWeek(), 2); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(ymdd)); [EOL]     Partial dd = new Partial(DateTimeFieldType.dayOfMonth(), 13).with(DateTimeFieldType.dayOfWeek(), 5); [EOL]     assertEquals(false, DateTimeUtils.isContiguous(dd)); [EOL]     try { [EOL]         DateTimeUtils.isContiguous((ReadablePartial) null); [EOL]         fail(); [EOL]     } catch (IllegalArgumentException ex) { [EOL]     } [EOL] } <line_num>: 454,475
public void test_julianDay() { [EOL]     DateTime base = new DateTime(1970, 1, 1, 0, 0, DateTimeZone.UTC); [EOL]     assertEquals(2440587.5d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2440588, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(2440587.5d)); [EOL]     base = base.plusHours(6); [EOL]     assertEquals(2440587.75d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2440588, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(2440587.75d)); [EOL]     base = base.plusHours(6); [EOL]     assertEquals(2440588d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2440588, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(2440588d)); [EOL]     base = base.plusHours(6); [EOL]     assertEquals(2440588.25d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2440588, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(2440588.25d)); [EOL]     base = base.plusHours(6); [EOL]     assertEquals(2440588.5d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2440589, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(2440588.5d)); [EOL]     base = new DateTime(2012, 8, 31, 23, 50, DateTimeZone.UTC); [EOL]     assertEquals(2456171.4930555555, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(2456171, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     base = new DateTime(-4713, 1, 1, 12, 0, JulianChronology.getInstanceUTC()); [EOL]     assertEquals(0d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(0, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(0d)); [EOL]     base = new DateTime(-4713, 1, 1, 0, 0, JulianChronology.getInstanceUTC()); [EOL]     assertEquals(-0.5d, DateTimeUtils.toJulianDay(base.getMillis()), 0.0001d); [EOL]     assertEquals(0, DateTimeUtils.toJulianDayNumber(base.getMillis())); [EOL]     assertEquals(base.getMillis(), DateTimeUtils.fromJulianDay(-0.5d)); [EOL] } <line_num>: 478,518