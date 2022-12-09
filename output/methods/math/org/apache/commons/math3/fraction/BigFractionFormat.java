public BigFractionFormat() { [EOL] } <line_num>: 50,51
public BigFractionFormat(final NumberFormat format) { [EOL]     super(format); [EOL] } <line_num>: 58,60
public BigFractionFormat(final NumberFormat numeratorFormat, final NumberFormat denominatorFormat) { [EOL]     super(numeratorFormat, denominatorFormat); [EOL] } <line_num>: 68,71
public static Locale[] getAvailableLocales() { [EOL]     return NumberFormat.getAvailableLocales(); [EOL] } <line_num>: 78,80
public static String formatBigFraction(final BigFraction f) { [EOL]     return getImproperInstance().format(f); [EOL] } <line_num>: 89,91
public static BigFractionFormat getImproperInstance() { [EOL]     return getImproperInstance(Locale.getDefault()); [EOL] } <line_num>: 97,99
public static BigFractionFormat getImproperInstance(final Locale locale) { [EOL]     return new BigFractionFormat(getDefaultNumberFormat(locale)); [EOL] } <line_num>: 106,108
public static BigFractionFormat getProperInstance() { [EOL]     return getProperInstance(Locale.getDefault()); [EOL] } <line_num>: 114,116
public static BigFractionFormat getProperInstance(final Locale locale) { [EOL]     return new ProperBigFractionFormat(getDefaultNumberFormat(locale)); [EOL] } <line_num>: 123,125
public StringBuffer format(final BigFraction BigFraction, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     pos.setBeginIndex(0); [EOL]     pos.setEndIndex(0); [EOL]     getNumeratorFormat().format(BigFraction.getNumerator(), toAppendTo, pos); [EOL]     toAppendTo.append(" / "); [EOL]     getDenominatorFormat().format(BigFraction.getDenominator(), toAppendTo, pos); [EOL]     return toAppendTo; [EOL] } <line_num>: 137,148
@Override [EOL] public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) { [EOL]     final StringBuffer ret; [EOL]     if (obj instanceof BigFraction) { [EOL]         ret = format((BigFraction) obj, toAppendTo, pos); [EOL]     } else if (obj instanceof BigInteger) { [EOL]         ret = format(new BigFraction((BigInteger) obj), toAppendTo, pos); [EOL]     } else if (obj instanceof Number) { [EOL]         ret = format(new BigFraction(((Number) obj).doubleValue()), toAppendTo, pos); [EOL]     } else { [EOL]         throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION); [EOL]     } [EOL]     return ret; [EOL] } <line_num>: 164,181
@Override [EOL] public BigFraction parse(final String source) throws MathParseException { [EOL]     final ParsePosition parsePosition = new ParsePosition(0); [EOL]     final BigFraction result = parse(source, parsePosition); [EOL]     if (parsePosition.getIndex() == 0) { [EOL]         throw new MathParseException(source, parsePosition.getErrorIndex(), BigFraction.class); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 190,198
@Override [EOL] public BigFraction parse(final String source, final ParsePosition pos) { [EOL]     final int initialIndex = pos.getIndex(); [EOL]     parseAndIgnoreWhitespace(source, pos); [EOL]     final BigInteger num = parseNextBigInteger(source, pos); [EOL]     if (num == null) { [EOL]         pos.setIndex(initialIndex); [EOL]         return null; [EOL]     } [EOL]     final int startIndex = pos.getIndex(); [EOL]     final char c = parseNextCharacter(source, pos); [EOL]     switch(c) { [EOL]         case 0: [EOL]             return new BigFraction(num); [EOL]         case '/': [EOL]             break; [EOL]         default: [EOL]             pos.setIndex(initialIndex); [EOL]             pos.setErrorIndex(startIndex); [EOL]             return null; [EOL]     } [EOL]     parseAndIgnoreWhitespace(source, pos); [EOL]     final BigInteger den = parseNextBigInteger(source, pos); [EOL]     if (den == null) { [EOL]         pos.setIndex(initialIndex); [EOL]         return null; [EOL]     } [EOL]     return new BigFraction(num, den); [EOL] } <line_num>: 207,258
protected BigInteger parseNextBigInteger(final String source, final ParsePosition pos) { [EOL]     final int start = pos.getIndex(); [EOL]     int end = (source.charAt(start) == '-') ? (start + 1) : start; [EOL]     while ((end < source.length()) && Character.isDigit(source.charAt(end))) { [EOL]         ++end; [EOL]     } [EOL]     try { [EOL]         BigInteger n = new BigInteger(source.substring(start, end)); [EOL]         pos.setIndex(end); [EOL]         return n; [EOL]     } catch (NumberFormatException nfe) { [EOL]         pos.setErrorIndex(start); [EOL]         return null; [EOL]     } [EOL] } <line_num>: 267,286