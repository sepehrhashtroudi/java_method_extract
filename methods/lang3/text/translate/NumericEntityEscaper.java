public static NumericEntityEscaper below(final int codepoint) {	    return outsideOf(codepoint, Integer.MAX_VALUE);	}
public static NumericEntityEscaper above(final int codepoint) {	    return outsideOf(0, codepoint);	}
public static NumericEntityEscaper between(final int codepointLow, final int codepointHigh) {	    return new NumericEntityEscaper(codepointLow, codepointHigh, true);	}
public static NumericEntityEscaper outsideOf(final int codepointLow, final int codepointHigh) {	    return new NumericEntityEscaper(codepointLow, codepointHigh, false);	}
@Override	public boolean translate(final int codepoint, final Writer out) throws IOException {	    if (between) {	        if (codepoint < below || codepoint > above) {	            return false;	        }	    } else {	        if (codepoint >= below && codepoint <= above) {	            return false;	        }	    }	    out.write("&#");	    out.write(Integer.toString(codepoint, 10));	    out.write(';');	    return true;	}
