@Override	public int read() throws IOException {	    int current = super.read();	    if (current == '\n') {	        lineCounter++;	    }	    lastChar = current;	    return lastChar;	}
int readAgain() {	    return lastChar;	}
@Override	public int read(char[] buf, int offset, int length) throws IOException {	    if (length == 0) {	        return 0;	    }	    int len = super.read(buf, offset, length);	    if (len > 0) {	        for (int i = offset; i < offset + len; i++) {	            char ch = buf[i];	            if (ch == '\n') {	                if ('\r' != (i > 0 ? buf[i - 1] : lastChar)) {	                    lineCounter++;	                }	            } else if (ch == '\r') {	                lineCounter++;	            }	        }	        lastChar = buf[offset + len - 1];	    } else if (len == -1) {	        lastChar = END_OF_STREAM;	    }	    return len;	}
@Override	public String readLine() throws IOException {	    String line = super.readLine();	    if (line != null) {	        if (line.length() > 0) {	            lastChar = line.charAt(line.length() - 1);	        }	        lineCounter++;	    } else {	        lastChar = END_OF_STREAM;	    }	    return line;	}
int lookAhead() throws IOException {	    super.mark(1);	    int c = super.read();	    super.reset();	    return c;	}
int getLineNumber() {	    return lineCounter;	}
