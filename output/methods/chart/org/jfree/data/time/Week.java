public Week() { [EOL]     this(new Date()); [EOL] } <line_num>: 118,120
public Week(int week, int year) { [EOL]     if ((week < FIRST_WEEK_IN_YEAR) && (week > LAST_WEEK_IN_YEAR)) { [EOL]         throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53."); [EOL]     } [EOL]     this.week = (byte) week; [EOL]     this.year = (short) year; [EOL]     peg(Calendar.getInstance()); [EOL] } <line_num>: 128,136
public Week(int week, Year year) { [EOL]     if ((week < FIRST_WEEK_IN_YEAR) && (week > LAST_WEEK_IN_YEAR)) { [EOL]         throw new IllegalArgumentException("The 'week' argument must be in the range 1 - 53."); [EOL]     } [EOL]     this.week = (byte) week; [EOL]     this.year = (short) year.getYear(); [EOL]     peg(Calendar.getInstance()); [EOL] } <line_num>: 144,152
public Week(Date time) { [EOL]     this(time, TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 164,167
public Week(Date time, TimeZone zone) { [EOL]     this(time, zone, Locale.getDefault()); [EOL] } <line_num>: 178,181
public Week(Date time, TimeZone zone, Locale locale) { [EOL]     if (time == null) { [EOL]         throw new IllegalArgumentException("Null 'time' argument."); [EOL]     } [EOL]     if (zone == null) { [EOL]         throw new IllegalArgumentException("Null 'zone' argument."); [EOL]     } [EOL]     if (locale == null) { [EOL]         throw new IllegalArgumentException("Null 'locale' argument."); [EOL]     } [EOL]     Calendar calendar = Calendar.getInstance(zone, locale); [EOL]     calendar.setTime(time); [EOL]     int tempWeek = calendar.get(Calendar.WEEK_OF_YEAR); [EOL]     if (tempWeek == 1 && calendar.get(Calendar.MONTH) == Calendar.DECEMBER) { [EOL]         this.week = 1; [EOL]         this.year = (short) (calendar.get(Calendar.YEAR) + 1); [EOL]     } else { [EOL]         this.week = (byte) Math.min(tempWeek, LAST_WEEK_IN_YEAR); [EOL]         int yyyy = calendar.get(Calendar.YEAR); [EOL]         if (calendar.get(Calendar.MONTH) == Calendar.JANUARY && this.week >= 52) { [EOL]             yyyy--; [EOL]         } [EOL]         this.year = (short) yyyy; [EOL]     } [EOL]     peg(calendar); [EOL] } <line_num>: 193,227
public Year getYear() { [EOL]     return new Year(this.year); [EOL] } <line_num>: 234,236
public int getYearValue() { [EOL]     return this.year; [EOL] } <line_num>: 243,245
public int getWeek() { [EOL]     return this.week; [EOL] } <line_num>: 252,254
public long getFirstMillisecond() { [EOL]     return this.firstMillisecond; [EOL] } <line_num>: 266,268
public long getLastMillisecond() { [EOL]     return this.lastMillisecond; [EOL] } <line_num>: 280,282
public void peg(Calendar calendar) { [EOL]     this.firstMillisecond = getFirstMillisecond(calendar); [EOL]     this.lastMillisecond = getLastMillisecond(calendar); [EOL] } <line_num>: 292,295
public RegularTimePeriod previous() { [EOL]     Week result; [EOL]     if (this.week != FIRST_WEEK_IN_YEAR) { [EOL]         result = new Week(this.week - 1, this.year); [EOL]     } else { [EOL]         if (this.year > 1900) { [EOL]             int yy = this.year - 1; [EOL]             Calendar prevYearCalendar = Calendar.getInstance(); [EOL]             prevYearCalendar.set(yy, Calendar.DECEMBER, 31); [EOL]             result = new Week(prevYearCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR), yy); [EOL]         } else { [EOL]             result = null; [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 305,326
public RegularTimePeriod next() { [EOL]     Week result; [EOL]     if (this.week < 52) { [EOL]         result = new Week(this.week + 1, this.year); [EOL]     } else { [EOL]         Calendar calendar = Calendar.getInstance(); [EOL]         calendar.set(this.year, Calendar.DECEMBER, 31); [EOL]         int actualMaxWeek = calendar.getActualMaximum(Calendar.WEEK_OF_YEAR); [EOL]         if (this.week < actualMaxWeek) { [EOL]             result = new Week(this.week + 1, this.year); [EOL]         } else { [EOL]             if (this.year < 9999) { [EOL]                 result = new Week(FIRST_WEEK_IN_YEAR, this.year + 1); [EOL]             } else { [EOL]                 result = null; [EOL]             } [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 337,362
public long getSerialIndex() { [EOL]     return this.year * 53L + this.week; [EOL] } <line_num>: 369,371
public long getFirstMillisecond(Calendar calendar) { [EOL]     Calendar c = (Calendar) calendar.clone(); [EOL]     c.clear(); [EOL]     c.set(Calendar.YEAR, this.year); [EOL]     c.set(Calendar.WEEK_OF_YEAR, this.week); [EOL]     c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); [EOL]     c.set(Calendar.HOUR, 0); [EOL]     c.set(Calendar.MINUTE, 0); [EOL]     c.set(Calendar.SECOND, 0); [EOL]     c.set(Calendar.MILLISECOND, 0); [EOL]     return c.getTime().getTime(); [EOL] } <line_num>: 384,396
public long getLastMillisecond(Calendar calendar) { [EOL]     Calendar c = (Calendar) calendar.clone(); [EOL]     c.clear(); [EOL]     c.set(Calendar.YEAR, this.year); [EOL]     c.set(Calendar.WEEK_OF_YEAR, this.week + 1); [EOL]     c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); [EOL]     c.set(Calendar.HOUR, 0); [EOL]     c.set(Calendar.MINUTE, 0); [EOL]     c.set(Calendar.SECOND, 0); [EOL]     c.set(Calendar.MILLISECOND, 0); [EOL]     return c.getTime().getTime() - 1; [EOL] } <line_num>: 409,421
public String toString() { [EOL]     return "Week " + this.week + ", " + this.year; [EOL] } <line_num>: 430,432
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof Week)) { [EOL]         return false; [EOL]     } [EOL]     Week that = (Week) obj; [EOL]     if (this.week != that.week) { [EOL]         return false; [EOL]     } [EOL]     if (this.year != that.year) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 444,461
public int hashCode() { [EOL]     int result = 17; [EOL]     result = 37 * result + this.week; [EOL]     result = 37 * result + this.year; [EOL]     return result; [EOL] } <line_num>: 472,477
public int compareTo(Object o1) { [EOL]     int result; [EOL]     if (o1 instanceof Week) { [EOL]         Week w = (Week) o1; [EOL]         result = this.year - w.getYear().getYear(); [EOL]         if (result == 0) { [EOL]             result = this.week - w.getWeek(); [EOL]         } [EOL]     } else if (o1 instanceof RegularTimePeriod) { [EOL]         result = 0; [EOL]     } else { [EOL]         result = 1; [EOL]     } [EOL]     return result; [EOL] } <line_num>: 489,519
public static Week parseWeek(String s) { [EOL]     Week result = null; [EOL]     if (s != null) { [EOL]         s = s.trim(); [EOL]         int i = Week.findSeparator(s); [EOL]         if (i != -1) { [EOL]             String s1 = s.substring(0, i).trim(); [EOL]             String s2 = s.substring(i + 1, s.length()).trim(); [EOL]             Year y = Week.evaluateAsYear(s1); [EOL]             int w; [EOL]             if (y != null) { [EOL]                 w = Week.stringToWeek(s2); [EOL]                 if (w == -1) { [EOL]                     throw new TimePeriodFormatException("Can't evaluate the week."); [EOL]                 } [EOL]                 result = new Week(w, y); [EOL]             } else { [EOL]                 y = Week.evaluateAsYear(s2); [EOL]                 if (y != null) { [EOL]                     w = Week.stringToWeek(s1); [EOL]                     if (w == -1) { [EOL]                         throw new TimePeriodFormatException("Can't evaluate the week."); [EOL]                     } [EOL]                     result = new Week(w, y); [EOL]                 } else { [EOL]                     throw new TimePeriodFormatException("Can't evaluate the year."); [EOL]                 } [EOL]             } [EOL]         } else { [EOL]             throw new TimePeriodFormatException("Could not find separator."); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 532,580
private static int findSeparator(String s) { [EOL]     int result = s.indexOf('-'); [EOL]     if (result == -1) { [EOL]         result = s.indexOf(','); [EOL]     } [EOL]     if (result == -1) { [EOL]         result = s.indexOf(' '); [EOL]     } [EOL]     if (result == -1) { [EOL]         result = s.indexOf('.'); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 590,603
private static Year evaluateAsYear(String s) { [EOL]     Year result = null; [EOL]     try { [EOL]         result = Year.parseYear(s); [EOL]     } catch (TimePeriodFormatException e) { [EOL]     } [EOL]     return result; [EOL] } <line_num>: 614,625
private static int stringToWeek(String s) { [EOL]     int result = -1; [EOL]     s = s.replace('W', ' '); [EOL]     s = s.trim(); [EOL]     try { [EOL]         result = Integer.parseInt(s); [EOL]         if ((result < 1) || (result > LAST_WEEK_IN_YEAR)) { [EOL]             result = -1; [EOL]         } [EOL]     } catch (NumberFormatException e) { [EOL]     } [EOL]     return result; [EOL] } <line_num>: 634,650
