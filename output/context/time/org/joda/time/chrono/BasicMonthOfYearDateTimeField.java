 BasicMonthOfYearDateTimeField(BasicChronology chronology, int leapMonth)
public boolean isLenient()
public int get(long instant)
public long add(long instant, int months)
public long add(long instant, long months)
public int[] add(ReadablePartial partial, int fieldIndex, int[] values, int valueToAdd)
public long addWrapField(long instant, int months)
public long getDifferenceAsLong(long minuendInstant, long subtrahendInstant)
public long set(long instant, int month)
public DurationField getRangeDurationField()
public boolean isLeap(long instant)
public int getLeapAmount(long instant)
public DurationField getLeapDurationField()
public int getMinimumValue()
public int getMaximumValue()
public long roundFloor(long instant)
public long remainder(long instant)
private Object readResolve()
long serialVersionUID=Optional[-8258715387168736L]
int MIN=Optional[DateTimeConstants.JANUARY]
BasicChronology iChronology
int iMax
int iLeapMonth
