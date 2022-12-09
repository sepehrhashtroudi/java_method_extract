public TestBaseSingleFieldPeriod(String name)
public Single(int period)
public static void main(String[] args)
public static TestSuite suite()
protected void setUp() throws Exception
protected void tearDown() throws Exception
public void testFactory_between_RInstant()
public void testFactory_between_RPartial()
public void testFactory_standardPeriodIn_RPeriod()
public void testValueIndexMethods()
public void testFieldTypeIndexMethods()
public void testIsSupported()
public void testGet()
public void testEqualsHashCode()
public void testCompareTo()
public void testToPeriod()
public void testToMutablePeriod()
public void testGetSetValue()
public static int between(ReadableInstant start, ReadableInstant end, DurationFieldType field)
public static int between(ReadablePartial start, ReadablePartial end, ReadablePeriod zeroInstance)
public static int standardPeriodIn(ReadablePeriod period, long millisPerUnit)
public DurationFieldType getFieldType()
public PeriodType getPeriodType()
public int getValue()
public void setValue(int value)
DateTimeZone PARIS=Optional[DateTimeZone.forID("Europe/Paris")]