@Override [EOL] public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     return formatter.format(obj, toAppendTo, pos); [EOL] }
@Override [EOL] public Object parseObject(final String source, final ParsePosition pos) { [EOL]     return parser.parseObject(source, pos); [EOL] }
public Format getParser() { [EOL]     return this.parser; [EOL] }
public Format getFormatter() { [EOL]     return this.formatter; [EOL] }
public String reformat(final String input) throws ParseException { [EOL]     return format(parseObject(input)); [EOL] }
