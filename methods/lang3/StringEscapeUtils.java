@Override [EOL] public int translate(final CharSequence input, final int index, final Writer out) throws IOException { [EOL]     if (index != 0) { [EOL]         throw new IllegalStateException("CsvEscaper should never reach the [1] index"); [EOL]     } [EOL]     if (StringUtils.containsNone(input.toString(), CSV_SEARCH_CHARS)) { [EOL]         out.write(input.toString()); [EOL]     } else { [EOL]         out.write(CSV_QUOTE); [EOL]         out.write(StringUtils.replace(input.toString(), CSV_QUOTE_STR, CSV_QUOTE_STR + CSV_QUOTE_STR)); [EOL]         out.write(CSV_QUOTE); [EOL]     } [EOL]     return input.length(); [EOL] }
@Override [EOL] public int translate(final CharSequence input, final int index, final Writer out) throws IOException { [EOL]     if (index != 0) { [EOL]         throw new IllegalStateException("CsvUnescaper should never reach the [1] index"); [EOL]     } [EOL]     if (input.charAt(0) != CSV_QUOTE || input.charAt(input.length() - 1) != CSV_QUOTE) { [EOL]         out.write(input.toString()); [EOL]         return input.length(); [EOL]     } [EOL]     final String quoteless = input.subSequence(1, input.length() - 1).toString(); [EOL]     if (StringUtils.containsAny(quoteless, CSV_SEARCH_CHARS)) { [EOL]         out.write(StringUtils.replace(quoteless, CSV_QUOTE_STR + CSV_QUOTE_STR, CSV_QUOTE_STR)); [EOL]     } else { [EOL]         out.write(input.toString()); [EOL]     } [EOL]     return input.length(); [EOL] }
public static final String escapeJava(final String input) { [EOL]     return ESCAPE_JAVA.translate(input); [EOL] }
public static final String escapeEcmaScript(final String input) { [EOL]     return ESCAPE_ECMASCRIPT.translate(input); [EOL] }
public static final String escapeJson(final String input) { [EOL]     return ESCAPE_JSON.translate(input); [EOL] }
public static final String unescapeJava(final String input) { [EOL]     return UNESCAPE_JAVA.translate(input); [EOL] }
public static final String unescapeEcmaScript(final String input) { [EOL]     return UNESCAPE_ECMASCRIPT.translate(input); [EOL] }
public static final String unescapeJson(final String input) { [EOL]     return UNESCAPE_JSON.translate(input); [EOL] }
public static final String escapeHtml4(final String input) { [EOL]     return ESCAPE_HTML4.translate(input); [EOL] }
public static final String escapeHtml3(final String input) { [EOL]     return ESCAPE_HTML3.translate(input); [EOL] }
public static final String unescapeHtml4(final String input) { [EOL]     return UNESCAPE_HTML4.translate(input); [EOL] }
public static final String unescapeHtml3(final String input) { [EOL]     return UNESCAPE_HTML3.translate(input); [EOL] }
public static final String escapeXml(final String input) { [EOL]     return ESCAPE_XML.translate(input); [EOL] }
public static final String unescapeXml(final String input) { [EOL]     return UNESCAPE_XML.translate(input); [EOL] }
public static final String escapeCsv(final String input) { [EOL]     return ESCAPE_CSV.translate(input); [EOL] }
public static final String unescapeCsv(final String input) { [EOL]     return UNESCAPE_CSV.translate(input); [EOL] }
