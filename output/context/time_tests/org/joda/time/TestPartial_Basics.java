public TestPartial_Basics(String name)
public static void main(String[] args)
public static TestSuite suite()
protected void setUp() throws Exception
protected void tearDown() throws Exception
public void testGet()
public void testSize()
public void testGetFieldType()
public void testGetFieldTypes()
public void testGetField()
public void testGetFields()
public void testGetValue()
public void testGetValues()
public void testIsSupported()
public void testEqualsHashCode()
public void testCompareTo()
public void testIsEqual_TOD()
public void testIsBefore_TOD()
public void testIsAfter_TOD()
public void testWithChronologyRetainFields_Chrono()
public void testWithChronologyRetainFields_sameChrono()
public void testWithChronologyRetainFields_nullChrono()
public void testWith1()
public void testWith2()
public void testWith3()
public void testWith3a()
public void testWith3b()
public void testWith3c()
public void testWith3d()
public void testWith3e()
public void testWith3f()
public void testWith4()
public void testWith_baseHasNoRange()
public void testWith_argHasNoRange()
public void testWith_baseAndArgHaveNoRange()
public void testWithout1()
public void testWithout2()
public void testWithout3()
public void testWithout4()
public void testWithout5()
public void testWithField1()
public void testWithField2()
public void testWithField3()
public void testWithField4()
public void testWithFieldAdded1()
public void testWithFieldAdded2()
public void testWithFieldAdded3()
public void testWithFieldAdded4()
public void testWithFieldAdded5()
public void testWithFieldAdded6()
public void testWithFieldAdded7()
public void testWithFieldAdded8()
public void testWithFieldAddWrapped1()
public void testWithFieldAddWrapped2()
public void testWithFieldAddWrapped3()
public void testWithFieldAddWrapped4()
public void testWithFieldAddWrapped5()
public void testWithFieldAddWrapped6()
public void testWithFieldAddWrapped7()
public void testWithFieldAddWrapped8()
public void testPlus_RP()
public void testMinus_RP()
public void testToDateTime_RI()
public void testToDateTime_nullRI()
public void testProperty()
public void testSerialization() throws Exception
public void testGetFormatter1()
public void testGetFormatter2()
public void testGetFormatter3()
public void testToString1()
public void testToString2()
public void testToString3()
public void testToString4()
public void testToString5()
public void testToString_String()
public void testToString_String_Locale()
public void testToString_DTFormatter()
private Partial createHourMinPartial()
private Partial createHourMinPartial(Chronology chrono)
private Partial createHourMinPartial2(Chronology chrono)
private Partial createHourMinPartial(int hour, int min, Chronology chrono)
private Partial createTODPartial(Chronology chrono)
private void check(Partial test, int hour, int min)
DateTimeZone PARIS=Optional[DateTimeZone.forID("Europe/Paris")]
DateTimeZone LONDON=Optional[DateTimeZone.forID("Europe/London")]
DateTimeZone TOKYO=Optional[DateTimeZone.forID("Asia/Tokyo")]
Chronology COPTIC_PARIS=Optional[CopticChronology.getInstance(PARIS)]
Chronology COPTIC_TOKYO=Optional[CopticChronology.getInstance(TOKYO)]
Chronology COPTIC_UTC=Optional[CopticChronology.getInstanceUTC()]
Chronology ISO_UTC=Optional[ISOChronology.getInstanceUTC()]
Chronology BUDDHIST_LONDON=Optional[BuddhistChronology.getInstance(LONDON)]
Chronology BUDDHIST_TOKYO=Optional[BuddhistChronology.getInstance(TOKYO)]
Chronology BUDDHIST_UTC=Optional[BuddhistChronology.getInstanceUTC()]
long TEST_TIME_NOW=Optional[10L * DateTimeConstants.MILLIS_PER_HOUR + 20L * DateTimeConstants.MILLIS_PER_MINUTE + 30L * DateTimeConstants.MILLIS_PER_SECOND + 40L]
long TEST_TIME2=Optional[1L * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L]
DateTimeZone zone=Optional[null]