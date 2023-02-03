public StdDateFormat() { [EOL] } <line_num>: 117,117
public StdDateFormat(TimeZone tz) { [EOL]     _timezone = tz; [EOL] } <line_num>: 118,120
public static TimeZone getDefaultTimeZone() { [EOL]     return DEFAULT_TIMEZONE; [EOL] } <line_num>: 122,124
public StdDateFormat withTimeZone(TimeZone tz) { [EOL]     if (tz == null) { [EOL]         tz = DEFAULT_TIMEZONE; [EOL]     } [EOL]     return new StdDateFormat(tz); [EOL] } <line_num>: 130,135
@Override [EOL] public StdDateFormat clone() { [EOL]     return new StdDateFormat(); [EOL] } <line_num>: 137,143
public static DateFormat getBlueprintISO8601Format() { [EOL]     return DATE_FORMAT_ISO8601; [EOL] } <line_num>: 150,152
public static DateFormat getISO8601Format(TimeZone tz) { [EOL]     return _cloneFormat(DATE_FORMAT_ISO8601, tz); [EOL] } <line_num>: 159,161
public static DateFormat getBlueprintRFC1123Format() { [EOL]     return DATE_FORMAT_RFC1123; [EOL] } <line_num>: 168,170
public static DateFormat getRFC1123Format(TimeZone tz) { [EOL]     return _cloneFormat(DATE_FORMAT_RFC1123, tz); [EOL] } <line_num>: 178,180
@Override [EOL] public void setTimeZone(TimeZone tz) { [EOL]     if (tz != _timezone) { [EOL]         _formatRFC1123 = null; [EOL]         _formatISO8601 = null; [EOL]         _formatISO8601_z = null; [EOL]         _formatPlain = null; [EOL]         _timezone = tz; [EOL]     } [EOL] } <line_num>: 188,201
@Override [EOL] public Date parse(String dateStr) throws ParseException { [EOL]     dateStr = dateStr.trim(); [EOL]     ParsePosition pos = new ParsePosition(0); [EOL]     Date result = parse(dateStr, pos); [EOL]     if (result != null) { [EOL]         return result; [EOL]     } [EOL]     StringBuilder sb = new StringBuilder(); [EOL]     for (String f : ALL_FORMATS) { [EOL]         if (sb.length() > 0) { [EOL]             sb.append("\", \""); [EOL]         } else { [EOL]             sb.append('"'); [EOL]         } [EOL]         sb.append(f); [EOL]     } [EOL]     sb.append('"'); [EOL]     throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", dateStr, sb.toString()), pos.getErrorIndex()); [EOL] } <line_num>: 203,226
@Override [EOL] public Date parse(String dateStr, ParsePosition pos) { [EOL]     if (looksLikeISO8601(dateStr)) { [EOL]         return parseAsISO8601(dateStr, pos); [EOL]     } [EOL]     int i = dateStr.length(); [EOL]     while (--i >= 0) { [EOL]         char ch = dateStr.charAt(i); [EOL]         if (ch < '0' || ch > '9') [EOL]             break; [EOL]     } [EOL]     if (i < 0) { [EOL]         if (NumberInput.inLongRange(dateStr, false)) { [EOL]             return new Date(Long.parseLong(dateStr)); [EOL]         } [EOL]     } [EOL]     return parseAsRFC1123(dateStr, pos); [EOL] } <line_num>: 228,249
@Override [EOL] public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) { [EOL]     if (_formatISO8601 == null) { [EOL]         _formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601); [EOL]     } [EOL]     return _formatISO8601.format(date, toAppendTo, fieldPosition); [EOL] } <line_num>: 251,259
protected boolean looksLikeISO8601(String dateStr) { [EOL]     if (dateStr.length() >= 5 && Character.isDigit(dateStr.charAt(0)) && Character.isDigit(dateStr.charAt(3)) && dateStr.charAt(4) == '-') { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 271,281
protected Date parseAsISO8601(String dateStr, ParsePosition pos) { [EOL]     int len = dateStr.length(); [EOL]     char c = dateStr.charAt(len - 1); [EOL]     DateFormat df; [EOL]     if (len <= 10 && Character.isDigit(c)) { [EOL]         df = _formatPlain; [EOL]         if (df == null) { [EOL]             df = _formatPlain = _cloneFormat(DATE_FORMAT_PLAIN); [EOL]         } [EOL]     } else if (c == 'Z') { [EOL]         df = _formatISO8601_z; [EOL]         if (df == null) { [EOL]             df = _formatISO8601_z = _cloneFormat(DATE_FORMAT_ISO8601_Z); [EOL]         } [EOL]         if (dateStr.charAt(len - 4) == ':') { [EOL]             StringBuilder sb = new StringBuilder(dateStr); [EOL]             sb.insert(len - 1, ".000"); [EOL]             dateStr = sb.toString(); [EOL]         } [EOL]     } else { [EOL]         if (hasTimeZone(dateStr)) { [EOL]             c = dateStr.charAt(len - 3); [EOL]             if (c == ':') { [EOL]                 StringBuilder sb = new StringBuilder(dateStr); [EOL]                 sb.delete(len - 3, len - 2); [EOL]                 dateStr = sb.toString(); [EOL]             } else if (c == '+' || c == '-') { [EOL]                 dateStr += "00"; [EOL]             } [EOL]             len = dateStr.length(); [EOL]             c = dateStr.charAt(len - 9); [EOL]             if (Character.isDigit(c)) { [EOL]                 StringBuilder sb = new StringBuilder(dateStr); [EOL]                 sb.insert(len - 5, ".000"); [EOL]                 dateStr = sb.toString(); [EOL]             } [EOL]             df = _formatISO8601; [EOL]             if (_formatISO8601 == null) { [EOL]                 df = _formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601); [EOL]             } [EOL]         } else { [EOL]             StringBuilder sb = new StringBuilder(dateStr); [EOL]             int timeLen = len - dateStr.lastIndexOf('T') - 1; [EOL]             if (timeLen <= 8) { [EOL]                 sb.append(".000"); [EOL]             } [EOL]             sb.append('Z'); [EOL]             dateStr = sb.toString(); [EOL]             df = _formatISO8601_z; [EOL]             if (df == null) { [EOL]                 df = _formatISO8601_z = _cloneFormat(DATE_FORMAT_ISO8601_Z); [EOL]             } [EOL]         } [EOL]     } [EOL]     return df.parse(dateStr, pos); [EOL] } <line_num>: 283,362
protected Date parseAsRFC1123(String dateStr, ParsePosition pos) { [EOL]     if (_formatRFC1123 == null) { [EOL]         _formatRFC1123 = _cloneFormat(DATE_FORMAT_RFC1123); [EOL]     } [EOL]     return _formatRFC1123.parse(dateStr, pos); [EOL] } <line_num>: 364,370
private final static boolean hasTimeZone(String str) { [EOL]     int len = str.length(); [EOL]     if (len >= 6) { [EOL]         char c = str.charAt(len - 6); [EOL]         if (c == '+' || c == '-') [EOL]             return true; [EOL]         c = str.charAt(len - 5); [EOL]         if (c == '+' || c == '-') [EOL]             return true; [EOL]         c = str.charAt(len - 3); [EOL]         if (c == '+' || c == '-') [EOL]             return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 372,385
private final DateFormat _cloneFormat(DateFormat df) { [EOL]     return _cloneFormat(df, _timezone); [EOL] } <line_num>: 387,389
private final static DateFormat _cloneFormat(DateFormat df, TimeZone tz) { [EOL]     df = (DateFormat) df.clone(); [EOL]     if (tz != null) { [EOL]         df.setTimeZone(tz); [EOL]     } [EOL]     return df; [EOL] } <line_num>: 391,398