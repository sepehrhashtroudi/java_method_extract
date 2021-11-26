int getLineNumber() {	    return in.getLineNumber();	}
int readEscape(int c) throws IOException {	    c = in.read();	    switch(c) {	        case 'r':	            return '\r';	        case 'n':	            return '\n';	        case 't':	            return '\t';	        case 'b':	            return '\b';	        case 'f':	            return '\f';	        default:	            return c;	    }	}
void trimTrailingSpaces(StringBuilder buffer) {	    int length = buffer.length();	    while (length > 0 && Character.isWhitespace(buffer.charAt(length - 1))) {	        length = length - 1;	    }	    if (length != buffer.length()) {	        buffer.setLength(length);	    }	}
boolean isWhitespace(int c) {	    return (c != format.getDelimiter()) && Character.isWhitespace((char) c);	}
boolean isEndOfLine(int c) throws IOException {	    if (c == '\r' && in.lookAhead() == '\n') {	        c = in.read();	    }	    return (c == '\n' || c == '\r');	}
boolean isEndOfFile(int c) {	    return c == ExtendedBufferedReader.END_OF_STREAM;	}
abstract Token nextToken(Token reusableToken) throws IOException;
boolean isDelimiter(int c) {	    return c == delimiter;	}
boolean isEscape(int c) {	    return isEscaping && c == escape;	}
boolean isEncapsulator(int c) {	    return isEncapsulating && c == encapsulator;	}
boolean isCommentStart(int c) {	    return isCommentEnabled && c == commmentStart;	}
