public static JavaUnicodeEscaper above(final int codepoint) {	    return outsideOf(0, codepoint);	}
public static JavaUnicodeEscaper below(final int codepoint) {	    return outsideOf(codepoint, Integer.MAX_VALUE);	}
public static JavaUnicodeEscaper between(final int codepointLow, final int codepointHigh) {	    return new JavaUnicodeEscaper(codepointLow, codepointHigh, true);	}
public static JavaUnicodeEscaper outsideOf(final int codepointLow, final int codepointHigh) {	    return new JavaUnicodeEscaper(codepointLow, codepointHigh, false);	}
@Override	protected String toUtf16Escape(final int codepoint) {	    final char[] surrogatePair = Character.toChars(codepoint);	    return "\\u" + hex(surrogatePair[0]) + "\\u" + hex(surrogatePair[1]);	}
