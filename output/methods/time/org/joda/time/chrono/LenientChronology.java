private LenientChronology(Chronology base) { [EOL]     super(base, null); [EOL] } <line_num>: 58,60
public static LenientChronology getInstance(Chronology base) { [EOL]     if (base == null) { [EOL]         throw new IllegalArgumentException("Must supply a chronology"); [EOL]     } [EOL]     return new LenientChronology(base); [EOL] } <line_num>: 44,49
public Chronology withUTC() { [EOL]     if (iWithUTC == null) { [EOL]         if (getZone() == DateTimeZone.UTC) { [EOL]             iWithUTC = this; [EOL]         } else { [EOL]             iWithUTC = LenientChronology.getInstance(getBase().withUTC()); [EOL]         } [EOL]     } [EOL]     return iWithUTC; [EOL] } <line_num>: 62,71
public Chronology withZone(DateTimeZone zone) { [EOL]     if (zone == null) { [EOL]         zone = DateTimeZone.getDefault(); [EOL]     } [EOL]     if (zone == DateTimeZone.UTC) { [EOL]         return withUTC(); [EOL]     } [EOL]     if (zone == getZone()) { [EOL]         return this; [EOL]     } [EOL]     return LenientChronology.getInstance(getBase().withZone(zone)); [EOL] } <line_num>: 73,84
protected void assemble(Fields fields) { [EOL]     fields.year = convertField(fields.year); [EOL]     fields.yearOfEra = convertField(fields.yearOfEra); [EOL]     fields.yearOfCentury = convertField(fields.yearOfCentury); [EOL]     fields.centuryOfEra = convertField(fields.centuryOfEra); [EOL]     fields.era = convertField(fields.era); [EOL]     fields.dayOfWeek = convertField(fields.dayOfWeek); [EOL]     fields.dayOfMonth = convertField(fields.dayOfMonth); [EOL]     fields.dayOfYear = convertField(fields.dayOfYear); [EOL]     fields.monthOfYear = convertField(fields.monthOfYear); [EOL]     fields.weekOfWeekyear = convertField(fields.weekOfWeekyear); [EOL]     fields.weekyear = convertField(fields.weekyear); [EOL]     fields.weekyearOfCentury = convertField(fields.weekyearOfCentury); [EOL]     fields.millisOfSecond = convertField(fields.millisOfSecond); [EOL]     fields.millisOfDay = convertField(fields.millisOfDay); [EOL]     fields.secondOfMinute = convertField(fields.secondOfMinute); [EOL]     fields.secondOfDay = convertField(fields.secondOfDay); [EOL]     fields.minuteOfHour = convertField(fields.minuteOfHour); [EOL]     fields.minuteOfDay = convertField(fields.minuteOfDay); [EOL]     fields.hourOfDay = convertField(fields.hourOfDay); [EOL]     fields.hourOfHalfday = convertField(fields.hourOfHalfday); [EOL]     fields.clockhourOfDay = convertField(fields.clockhourOfDay); [EOL]     fields.clockhourOfHalfday = convertField(fields.clockhourOfHalfday); [EOL]     fields.halfdayOfDay = convertField(fields.halfdayOfDay); [EOL] } <line_num>: 86,111
private final DateTimeField convertField(DateTimeField field) { [EOL]     return LenientDateTimeField.getInstance(field, getBase()); [EOL] } <line_num>: 113,115
public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (obj instanceof LenientChronology == false) { [EOL]         return false; [EOL]     } [EOL]     LenientChronology chrono = (LenientChronology) obj; [EOL]     return getBase().equals(chrono.getBase()); [EOL] } <line_num>: 126,135
public int hashCode() { [EOL]     return 236548278 + getBase().hashCode() * 7; [EOL] } <line_num>: 143,145
public String toString() { [EOL]     return "LenientChronology[" + getBase().toString() + ']'; [EOL] } <line_num>: 152,154