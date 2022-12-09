protected ScriptRuntime() { [EOL] } <line_num>: 63,64
public static boolean isJSLineTerminator(int c) { [EOL]     if ((c & 0xDFD0) != 0) { [EOL]         return false; [EOL]     } [EOL]     return c == '\n' || c == '\r' || c == 0x2028 || c == 0x2029; [EOL] } <line_num>: 67,74
@SuppressWarnings("fallthrough") [EOL] static double stringToNumber(String s, int start, int radix) { [EOL]     char digitMax = '9'; [EOL]     char lowerCaseBound = 'a'; [EOL]     char upperCaseBound = 'A'; [EOL]     int len = s.length(); [EOL]     if (radix < 10) { [EOL]         digitMax = (char) ('0' + radix - 1); [EOL]     } [EOL]     if (radix > 10) { [EOL]         lowerCaseBound = (char) ('a' + radix - 10); [EOL]         upperCaseBound = (char) ('A' + radix - 10); [EOL]     } [EOL]     int end; [EOL]     double sum = 0.0; [EOL]     for (end = start; end < len; end++) { [EOL]         char c = s.charAt(end); [EOL]         int newDigit; [EOL]         if ('0' <= c && c <= digitMax) [EOL]             newDigit = c - '0'; [EOL]         else if ('a' <= c && c < lowerCaseBound) [EOL]             newDigit = c - 'a' + 10; [EOL]         else if ('A' <= c && c < upperCaseBound) [EOL]             newDigit = c - 'A' + 10; [EOL]         else [EOL]             break; [EOL]         sum = sum * radix + newDigit; [EOL]     } [EOL]     if (start == end) { [EOL]         return NaN; [EOL]     } [EOL]     if (sum >= 9007199254740992.0) { [EOL]         if (radix == 10) { [EOL]             try { [EOL]                 return Double.valueOf(s.substring(start, end)).doubleValue(); [EOL]             } catch (NumberFormatException nfe) { [EOL]                 return NaN; [EOL]             } [EOL]         } else if (radix == 2 || radix == 4 || radix == 8 || radix == 16 || radix == 32) { [EOL]             int bitShiftInChar = 1; [EOL]             int digit = 0; [EOL]             final int SKIP_LEADING_ZEROS = 0; [EOL]             final int FIRST_EXACT_53_BITS = 1; [EOL]             final int AFTER_BIT_53 = 2; [EOL]             final int ZEROS_AFTER_54 = 3; [EOL]             final int MIXED_AFTER_54 = 4; [EOL]             int state = SKIP_LEADING_ZEROS; [EOL]             int exactBitsLimit = 53; [EOL]             double factor = 0.0; [EOL]             boolean bit53 = false; [EOL]             boolean bit54 = false; [EOL]             for (; ; ) { [EOL]                 if (bitShiftInChar == 1) { [EOL]                     if (start == end) [EOL]                         break; [EOL]                     digit = s.charAt(start++); [EOL]                     if ('0' <= digit && digit <= '9') [EOL]                         digit -= '0'; [EOL]                     else if ('a' <= digit && digit <= 'z') [EOL]                         digit -= 'a' - 10; [EOL]                     else [EOL]                         digit -= 'A' - 10; [EOL]                     bitShiftInChar = radix; [EOL]                 } [EOL]                 bitShiftInChar >>= 1; [EOL]                 boolean bit = (digit & bitShiftInChar) != 0; [EOL]                 switch(state) { [EOL]                     case SKIP_LEADING_ZEROS: [EOL]                         if (bit) { [EOL]                             --exactBitsLimit; [EOL]                             sum = 1.0; [EOL]                             state = FIRST_EXACT_53_BITS; [EOL]                         } [EOL]                         break; [EOL]                     case FIRST_EXACT_53_BITS: [EOL]                         sum *= 2.0; [EOL]                         if (bit) [EOL]                             sum += 1.0; [EOL]                         --exactBitsLimit; [EOL]                         if (exactBitsLimit == 0) { [EOL]                             bit53 = bit; [EOL]                             state = AFTER_BIT_53; [EOL]                         } [EOL]                         break; [EOL]                     case AFTER_BIT_53: [EOL]                         bit54 = bit; [EOL]                         factor = 2.0; [EOL]                         state = ZEROS_AFTER_54; [EOL]                         break; [EOL]                     case ZEROS_AFTER_54: [EOL]                         if (bit) { [EOL]                             state = MIXED_AFTER_54; [EOL]                         } [EOL]                     case MIXED_AFTER_54: [EOL]                         factor *= 2; [EOL]                         break; [EOL]                 } [EOL]             } [EOL]             switch(state) { [EOL]                 case SKIP_LEADING_ZEROS: [EOL]                     sum = 0.0; [EOL]                     break; [EOL]                 case FIRST_EXACT_53_BITS: [EOL]                 case AFTER_BIT_53: [EOL]                     break; [EOL]                 case ZEROS_AFTER_54: [EOL]                     if (bit54 & bit53) [EOL]                         sum += 1.0; [EOL]                     sum *= factor; [EOL]                     break; [EOL]                 case MIXED_AFTER_54: [EOL]                     if (bit54) [EOL]                         sum += 1.0; [EOL]                     sum *= factor; [EOL]                     break; [EOL]             } [EOL]         } [EOL]     } [EOL]     return sum; [EOL] } <line_num>: 90,237
public static String escapeString(String s) { [EOL]     return escapeString(s, '"'); [EOL] } <line_num>: 239,241
public static String escapeString(String s, char escapeQuote) { [EOL]     if (!(escapeQuote == '"' || escapeQuote == '\'')) { [EOL]         throw new IllegalStateException("unexpected quote char:" + escapeQuote); [EOL]     } [EOL]     StringBuffer sb = null; [EOL]     for (int i = 0, L = s.length(); i != L; ++i) { [EOL]         int c = s.charAt(i); [EOL]         if (' ' <= c && c <= '~' && c != escapeQuote && c != '\\') { [EOL]             if (sb != null) { [EOL]                 sb.append((char) c); [EOL]             } [EOL]             continue; [EOL]         } [EOL]         if (sb == null) { [EOL]             sb = new StringBuffer(L + 3); [EOL]             sb.append(s); [EOL]             sb.setLength(i); [EOL]         } [EOL]         int escape = -1; [EOL]         switch(c) { [EOL]             case '\b': [EOL]                 escape = 'b'; [EOL]                 break; [EOL]             case '\f': [EOL]                 escape = 'f'; [EOL]                 break; [EOL]             case '\n': [EOL]                 escape = 'n'; [EOL]                 break; [EOL]             case '\r': [EOL]                 escape = 'r'; [EOL]                 break; [EOL]             case '\t': [EOL]                 escape = 't'; [EOL]                 break; [EOL]             case 0xb: [EOL]                 escape = 'v'; [EOL]                 break; [EOL]             case ' ': [EOL]                 escape = ' '; [EOL]                 break; [EOL]             case '\\': [EOL]                 escape = '\\'; [EOL]                 break; [EOL]         } [EOL]         if (escape >= 0) { [EOL]             sb.append('\\'); [EOL]             sb.append((char) escape); [EOL]         } else if (c == escapeQuote) { [EOL]             sb.append('\\'); [EOL]             sb.append(escapeQuote); [EOL]         } else { [EOL]             int hexSize; [EOL]             if (c < 256) { [EOL]                 sb.append("\\x"); [EOL]                 hexSize = 2; [EOL]             } else { [EOL]                 sb.append("\\u"); [EOL]                 hexSize = 4; [EOL]             } [EOL]             for (int shift = (hexSize - 1) * 4; shift >= 0; shift -= 4) { [EOL]                 int digit = 0xf & (c >> shift); [EOL]                 int hc = (digit < 10) ? '0' + digit : 'a' - 10 + digit; [EOL]                 sb.append((char) hc); [EOL]             } [EOL]         } [EOL]     } [EOL]     return (sb == null) ? s : sb.toString(); [EOL] } <line_num>: 247,308
static boolean isValidIdentifierName(String s) { [EOL]     int L = s.length(); [EOL]     if (L == 0) [EOL]         return false; [EOL]     if (!Character.isJavaIdentifierStart(s.charAt(0))) [EOL]         return false; [EOL]     for (int i = 1; i != L; ++i) { [EOL]         if (!Character.isJavaIdentifierPart(s.charAt(i))) [EOL]             return false; [EOL]     } [EOL]     return !TokenStream.isKeyword(s); [EOL] } <line_num>: 310,321
public static long testUint32String(String str) { [EOL]     final int MAX_VALUE_LENGTH = 10; [EOL]     int len = str.length(); [EOL]     if (1 <= len && len <= MAX_VALUE_LENGTH) { [EOL]         int c = str.charAt(0); [EOL]         c -= '0'; [EOL]         if (c == 0) { [EOL]             return (len == 1) ? 0L : -1L; [EOL]         } [EOL]         if (1 <= c && c <= 9) { [EOL]             long v = c; [EOL]             for (int i = 1; i != len; ++i) { [EOL]                 c = str.charAt(i) - '0'; [EOL]                 if (!(0 <= c && c <= 9)) { [EOL]                     return -1; [EOL]                 } [EOL]                 v = 10 * v + c; [EOL]             } [EOL]             if ((v >>> 32) == 0) { [EOL]                 return v; [EOL]             } [EOL]         } [EOL]     } [EOL]     return -1; [EOL] } <line_num>: 327,356
static boolean isSpecialProperty(String s) { [EOL]     return s.equals("__proto__") || s.equals("__parent__"); [EOL] } <line_num>: 358,360
public static String getMessage0(String messageId) { [EOL]     return getMessage(messageId, null); [EOL] } <line_num>: 366,368
public static String getMessage1(String messageId, Object arg1) { [EOL]     Object[] arguments = { arg1 }; [EOL]     return getMessage(messageId, arguments); [EOL] } <line_num>: 370,373
public static String getMessage(String messageId, Object[] arguments) { [EOL]     final String defaultResource = "rhino_ast.java.com.google.javascript.rhino.Messages"; [EOL]     Locale locale = Locale.getDefault(); [EOL]     ResourceBundle rb = ResourceBundle.getBundle(defaultResource, locale); [EOL]     String formatString; [EOL]     try { [EOL]         formatString = rb.getString(messageId); [EOL]     } catch (java.util.MissingResourceException mre) { [EOL]         throw new RuntimeException("no message resource found for message property " + messageId); [EOL]     } [EOL]     MessageFormat formatter = new MessageFormat(formatString); [EOL]     return formatter.format(arguments); [EOL] } <line_num>: 379,404