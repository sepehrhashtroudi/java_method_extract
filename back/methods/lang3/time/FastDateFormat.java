@Override [EOL] protected FastDateFormat createInstance(final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return new FastDateFormat(pattern, timeZone, locale); [EOL] }
public static FastDateFormat getInstance() { [EOL]     return cache.getInstance(); [EOL] }
public static FastDateFormat getInstance(final String pattern) { [EOL]     return cache.getInstance(pattern, null, null); [EOL] }
public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone) { [EOL]     return cache.getInstance(pattern, timeZone, null); [EOL] }
public static FastDateFormat getInstance(final String pattern, final Locale locale) { [EOL]     return cache.getInstance(pattern, null, locale); [EOL] }
public static FastDateFormat getInstance(final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getInstance(pattern, timeZone, locale); [EOL] }
public static FastDateFormat getDateInstance(final int style) { [EOL]     return cache.getDateInstance(style, null, null); [EOL] }
public static FastDateFormat getDateInstance(final int style, final Locale locale) { [EOL]     return cache.getDateInstance(style, null, locale); [EOL] }
public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone) { [EOL]     return cache.getDateInstance(style, timeZone, null); [EOL] }
public static FastDateFormat getDateInstance(final int style, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getDateInstance(style, timeZone, locale); [EOL] }
public static FastDateFormat getTimeInstance(final int style) { [EOL]     return cache.getTimeInstance(style, null, null); [EOL] }
public static FastDateFormat getTimeInstance(final int style, final Locale locale) { [EOL]     return cache.getTimeInstance(style, null, locale); [EOL] }
public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone) { [EOL]     return cache.getTimeInstance(style, timeZone, null); [EOL] }
public static FastDateFormat getTimeInstance(final int style, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getTimeInstance(style, timeZone, locale); [EOL] }
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, null, null); [EOL] }
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final Locale locale) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, null, locale); [EOL] }
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone) { [EOL]     return getDateTimeInstance(dateStyle, timeStyle, timeZone, null); [EOL] }
public static FastDateFormat getDateTimeInstance(final int dateStyle, final int timeStyle, final TimeZone timeZone, final Locale locale) { [EOL]     return cache.getDateTimeInstance(dateStyle, timeStyle, timeZone, locale); [EOL] }
@Override [EOL] public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     return printer.format(obj, toAppendTo, pos); [EOL] }
@Override [EOL] public String format(final long millis) { [EOL]     return printer.format(millis); [EOL] }
@Override [EOL] public String format(final Date date) { [EOL]     return printer.format(date); [EOL] }
@Override [EOL] public String format(final Calendar calendar) { [EOL]     return printer.format(calendar); [EOL] }
@Override [EOL] public StringBuffer format(final long millis, final StringBuffer buf) { [EOL]     return printer.format(millis, buf); [EOL] }
@Override [EOL] public StringBuffer format(final Date date, final StringBuffer buf) { [EOL]     return printer.format(date, buf); [EOL] }
@Override [EOL] public StringBuffer format(final Calendar calendar, final StringBuffer buf) { [EOL]     return printer.format(calendar, buf); [EOL] }
@Override [EOL] public Date parse(final String source) throws ParseException { [EOL]     return parser.parse(source); [EOL] }
@Override [EOL] public Date parse(final String source, final ParsePosition pos) { [EOL]     return parser.parse(source, pos); [EOL] }
@Override [EOL] public Object parseObject(final String source, final ParsePosition pos) { [EOL]     return parser.parseObject(source, pos); [EOL] }
@Override [EOL] public String getPattern() { [EOL]     return printer.getPattern(); [EOL] }
@Override [EOL] public TimeZone getTimeZone() { [EOL]     return printer.getTimeZone(); [EOL] }
@Override [EOL] public Locale getLocale() { [EOL]     return printer.getLocale(); [EOL] }
public int getMaxLengthEstimate() { [EOL]     return printer.getMaxLengthEstimate(); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof FastDateFormat == false) { [EOL]         return false; [EOL]     } [EOL]     final FastDateFormat other = (FastDateFormat) obj; [EOL]     return printer.equals(other.printer); [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return printer.hashCode(); [EOL] }
@Override [EOL] public String toString() { [EOL]     return "FastDateFormat[" + printer.getPattern() + "," + printer.getLocale() + "," + printer.getTimeZone().getID() + "]"; [EOL] }
protected StringBuffer applyRules(final Calendar calendar, final StringBuffer buf) { [EOL]     return printer.applyRules(calendar, buf); [EOL] }
