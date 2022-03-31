public static StrMatcher commaMatcher() { [EOL]     return COMMA_MATCHER; [EOL] }
public static StrMatcher tabMatcher() { [EOL]     return TAB_MATCHER; [EOL] }
public static StrMatcher spaceMatcher() { [EOL]     return SPACE_MATCHER; [EOL] }
public static StrMatcher splitMatcher() { [EOL]     return SPLIT_MATCHER; [EOL] }
public static StrMatcher trimMatcher() { [EOL]     return TRIM_MATCHER; [EOL] }
public static StrMatcher singleQuoteMatcher() { [EOL]     return SINGLE_QUOTE_MATCHER; [EOL] }
public static StrMatcher doubleQuoteMatcher() { [EOL]     return DOUBLE_QUOTE_MATCHER; [EOL] }
public static StrMatcher quoteMatcher() { [EOL]     return QUOTE_MATCHER; [EOL] }
public static StrMatcher noneMatcher() { [EOL]     return NONE_MATCHER; [EOL] }
public static StrMatcher charMatcher(final char ch) { [EOL]     return new CharMatcher(ch); [EOL] }
public static StrMatcher charSetMatcher(final char... chars) { [EOL]     if (chars == null || chars.length == 0) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     if (chars.length == 1) { [EOL]         return new CharMatcher(chars[0]); [EOL]     } [EOL]     return new CharSetMatcher(chars); [EOL] }
public static StrMatcher charSetMatcher(final String chars) { [EOL]     if (StringUtils.isEmpty(chars)) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     if (chars.length() == 1) { [EOL]         return new CharMatcher(chars.charAt(0)); [EOL]     } [EOL]     return new CharSetMatcher(chars.toCharArray()); [EOL] }
public static StrMatcher stringMatcher(final String str) { [EOL]     if (StringUtils.isEmpty(str)) { [EOL]         return NONE_MATCHER; [EOL]     } [EOL]     return new StringMatcher(str); [EOL] }
public abstract int isMatch(char[] buffer, int pos, int bufferStart, int bufferEnd);
public int isMatch(final char[] buffer, final int pos) { [EOL]     return isMatch(buffer, pos, 0, buffer.length); [EOL] }
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return Arrays.binarySearch(chars, buffer[pos]) >= 0 ? 1 : 0; [EOL] }
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return ch == buffer[pos] ? 1 : 0; [EOL] }
@Override [EOL] public int isMatch(final char[] buffer, int pos, final int bufferStart, final int bufferEnd) { [EOL]     final int len = chars.length; [EOL]     if (pos + len > bufferEnd) { [EOL]         return 0; [EOL]     } [EOL]     for (int i = 0; i < chars.length; i++, pos++) { [EOL]         if (chars[i] != buffer[pos]) { [EOL]             return 0; [EOL]         } [EOL]     } [EOL]     return len; [EOL] }
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return 0; [EOL] }
@Override [EOL] public int isMatch(final char[] buffer, final int pos, final int bufferStart, final int bufferEnd) { [EOL]     return buffer[pos] <= 32 ? 1 : 0; [EOL] }
