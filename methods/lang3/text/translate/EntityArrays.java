public static String[][] ISO8859_1_ESCAPE() {	    return ISO8859_1_ESCAPE.clone();	}
public static String[][] ISO8859_1_UNESCAPE() {	    return ISO8859_1_UNESCAPE.clone();	}
public static String[][] HTML40_EXTENDED_ESCAPE() {	    return HTML40_EXTENDED_ESCAPE.clone();	}
public static String[][] HTML40_EXTENDED_UNESCAPE() {	    return HTML40_EXTENDED_UNESCAPE.clone();	}
public static String[][] BASIC_ESCAPE() {	    return BASIC_ESCAPE.clone();	}
public static String[][] BASIC_UNESCAPE() {	    return BASIC_UNESCAPE.clone();	}
public static String[][] APOS_ESCAPE() {	    return APOS_ESCAPE.clone();	}
public static String[][] APOS_UNESCAPE() {	    return APOS_UNESCAPE.clone();	}
public static String[][] JAVA_CTRL_CHARS_ESCAPE() {	    return JAVA_CTRL_CHARS_ESCAPE.clone();	}
public static String[][] JAVA_CTRL_CHARS_UNESCAPE() {	    return JAVA_CTRL_CHARS_UNESCAPE.clone();	}
public static String[][] invert(final String[][] array) {	    final String[][] newarray = new String[array.length][2];	    for (int i = 0; i < array.length; i++) {	        newarray[i][0] = array[i][1];	        newarray[i][1] = array[i][0];	    }	    return newarray;	}
