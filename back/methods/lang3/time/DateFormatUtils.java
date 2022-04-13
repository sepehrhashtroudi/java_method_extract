public static String formatUTC(final long millis, final String pattern) { [EOL]     return format(new Date(millis), pattern, UTC_TIME_ZONE, null); [EOL] }
public static String formatUTC(final Date date, final String pattern) { [EOL]     return format(date, pattern, UTC_TIME_ZONE, null); [EOL] }
public static String formatUTC(final long millis, final String pattern, final Locale locale) { [EOL]     return format(new Date(millis), pattern, UTC_TIME_ZONE, locale); [EOL] }
public static String formatUTC(final Date date, final String pattern, final Locale locale) { [EOL]     return format(date, pattern, UTC_TIME_ZONE, locale); [EOL] }
public static String format(final long millis, final String pattern) { [EOL]     return format(new Date(millis), pattern, null, null); [EOL] }
public static String format(final Date date, final String pattern) { [EOL]     return format(date, pattern, null, null); [EOL] }
public static String format(final Calendar calendar, final String pattern) { [EOL]     return format(calendar, pattern, null, null); [EOL] }
public static String format(final long millis, final String pattern, final TimeZone timeZone) { [EOL]     return format(new Date(millis), pattern, timeZone, null); [EOL] }
public static String format(final Date date, final String pattern, final TimeZone timeZone) { [EOL]     return format(date, pattern, timeZone, null); [EOL] }
public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone) { [EOL]     return format(calendar, pattern, timeZone, null); [EOL] }
public static String format(final long millis, final String pattern, final Locale locale) { [EOL]     return format(new Date(millis), pattern, null, locale); [EOL] }
public static String format(final Date date, final String pattern, final Locale locale) { [EOL]     return format(date, pattern, null, locale); [EOL] }
public static String format(final Calendar calendar, final String pattern, final Locale locale) { [EOL]     return format(calendar, pattern, null, locale); [EOL] }
public static String format(final long millis, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     return format(new Date(millis), pattern, timeZone, locale); [EOL] }
public static String format(final Date date, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale); [EOL]     return df.format(date); [EOL] }
public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone, final Locale locale) { [EOL]     final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale); [EOL]     return df.format(calendar); [EOL] }
