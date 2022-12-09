public MutablePeriod()
public MutablePeriod(PeriodType type)
public MutablePeriod(int hours, int minutes, int seconds, int millis)
public MutablePeriod(int years, int months, int weeks, int days, int hours, int minutes, int seconds, int millis)
public MutablePeriod(int years, int months, int weeks, int days, int hours, int minutes, int seconds, int millis, PeriodType type)
public MutablePeriod(long duration)
public MutablePeriod(long duration, PeriodType type)
public MutablePeriod(long duration, Chronology chronology)
public MutablePeriod(long duration, PeriodType type, Chronology chronology)
public MutablePeriod(long startInstant, long endInstant)
public MutablePeriod(long startInstant, long endInstant, PeriodType type)
public MutablePeriod(long startInstant, long endInstant, Chronology chrono)
public MutablePeriod(long startInstant, long endInstant, PeriodType type, Chronology chrono)
public MutablePeriod(ReadableInstant startInstant, ReadableInstant endInstant)
public MutablePeriod(ReadableInstant startInstant, ReadableInstant endInstant, PeriodType type)
public MutablePeriod(ReadableInstant startInstant, ReadableDuration duration)
public MutablePeriod(ReadableInstant startInstant, ReadableDuration duration, PeriodType type)
public MutablePeriod(ReadableDuration duration, ReadableInstant endInstant)
public MutablePeriod(ReadableDuration duration, ReadableInstant endInstant, PeriodType type)
public MutablePeriod(Object period)
public MutablePeriod(Object period, PeriodType type)
public MutablePeriod(Object period, Chronology chrono)
public MutablePeriod(Object period, PeriodType type, Chronology chrono)
public static MutablePeriod parse(String str)
public static MutablePeriod parse(String str, PeriodFormatter formatter)
public void clear()
public void setValue(int index, int value)
public void set(DurationFieldType field, int value)
public void setPeriod(ReadablePeriod period)
public void setPeriod(int years, int months, int weeks, int days, int hours, int minutes, int seconds, int millis)
public void setPeriod(ReadableInterval interval)
public void setPeriod(ReadableInstant start, ReadableInstant end)
public void setPeriod(long startInstant, long endInstant)
public void setPeriod(long startInstant, long endInstant, Chronology chrono)
public void setPeriod(ReadableDuration duration)
public void setPeriod(ReadableDuration duration, Chronology chrono)
public void setPeriod(long duration)
public void setPeriod(long duration, Chronology chrono)
public void add(DurationFieldType field, int value)
public void add(ReadablePeriod period)
public void add(int years, int months, int weeks, int days, int hours, int minutes, int seconds, int millis)
public void add(ReadableInterval interval)
public void add(ReadableDuration duration)
public void add(long duration)
public void add(long duration, Chronology chrono)
public void mergePeriod(ReadablePeriod period)
public int getYears()
public int getMonths()
public int getWeeks()
public int getDays()
public int getHours()
public int getMinutes()
public int getSeconds()
public int getMillis()
public void setYears(int years)
public void addYears(int years)
public void setMonths(int months)
public void addMonths(int months)
public void setWeeks(int weeks)
public void addWeeks(int weeks)
public void setDays(int days)
public void addDays(int days)
public void setHours(int hours)
public void addHours(int hours)
public void setMinutes(int minutes)
public void addMinutes(int minutes)
public void setSeconds(int seconds)
public void addSeconds(int seconds)
public void setMillis(int millis)
public void addMillis(int millis)
public MutablePeriod copy()
public Object clone()