public static UnicodeEscaper below(final int codepoint) {	    return outsideOf(codepoint, Integer.MAX_VALUE);	}
public static UnicodeEscaper above(final int codepoint) {	    return outsideOf(0, codepoint);	}
public static UnicodeEscaper outsideOf(final int codepointLow, final int codepointHigh) {	    return new UnicodeEscaper(codepointLow, codepointHigh, false);	}
public static UnicodeEscaper between(final int codepointLow, final int codepointHigh) {	    return new UnicodeEscaper(codepointLow, codepointHigh, true);	}
@Override	public boolean translate(final int codepoint, final Writer out) throws IOException {	    if (between) {	        if (codepoint < below || codepoint > above) {	            return false;	        }	    } else {	        if (codepoint >= below && codepoint <= above) {	            return false;	        }	    }	    if (codepoint > 0xffff) {	        out.write(toUtf16Escape(codepoint));	    } else if (codepoint > 0xfff) {	        out.write("\\u" + hex(codepoint));	    } else if (codepoint > 0xff) {	        out.write("\\u0" + hex(codepoint));	    } else if (codepoint > 0xf) {	        out.write("\\u00" + hex(codepoint));	    } else {	        out.write("\\u000" + hex(codepoint));	    }	    return true;	}
protected String toUtf16Escape(final int codepoint) {	    return "\\u" + hex(codepoint);	}