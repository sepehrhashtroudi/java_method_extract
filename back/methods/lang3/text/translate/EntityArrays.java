public static String[][] ISO8859_1_ESCAPE() { [EOL]     return ISO8859_1_ESCAPE.clone(); [EOL] }
public static String[][] ISO8859_1_UNESCAPE() { [EOL]     return ISO8859_1_UNESCAPE.clone(); [EOL] }
public static String[][] HTML40_EXTENDED_ESCAPE() { [EOL]     return HTML40_EXTENDED_ESCAPE.clone(); [EOL] }
public static String[][] HTML40_EXTENDED_UNESCAPE() { [EOL]     return HTML40_EXTENDED_UNESCAPE.clone(); [EOL] }
public static String[][] BASIC_ESCAPE() { [EOL]     return BASIC_ESCAPE.clone(); [EOL] }
public static String[][] BASIC_UNESCAPE() { [EOL]     return BASIC_UNESCAPE.clone(); [EOL] }
public static String[][] APOS_ESCAPE() { [EOL]     return APOS_ESCAPE.clone(); [EOL] }
public static String[][] APOS_UNESCAPE() { [EOL]     return APOS_UNESCAPE.clone(); [EOL] }
public static String[][] JAVA_CTRL_CHARS_ESCAPE() { [EOL]     return JAVA_CTRL_CHARS_ESCAPE.clone(); [EOL] }
public static String[][] JAVA_CTRL_CHARS_UNESCAPE() { [EOL]     return JAVA_CTRL_CHARS_UNESCAPE.clone(); [EOL] }
public static String[][] invert(final String[][] array) { [EOL]     final String[][] newarray = new String[array.length][2]; [EOL]     for (int i = 0; i < array.length; i++) { [EOL]         newarray[i][0] = array[i][1]; [EOL]         newarray[i][1] = array[i][0]; [EOL]     } [EOL]     return newarray; [EOL] }
