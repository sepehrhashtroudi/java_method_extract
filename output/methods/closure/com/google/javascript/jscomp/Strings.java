private Strings() { [EOL] } <line_num>: 27,27
static String truncateAtMaxLength(String source, int maxLength, boolean addEllipsis) { [EOL]     if (source.length() <= maxLength) { [EOL]         return source; [EOL]     } [EOL]     if (addEllipsis && maxLength > 3) { [EOL]         return unicodePreservingSubstring(source, 0, maxLength - 3) + "..."; [EOL]     } [EOL]     return unicodePreservingSubstring(source, 0, maxLength); [EOL] } <line_num>: 45,55
private static int unicodePreservingIndex(String str, int index) { [EOL]     if (index > 0 && index < str.length()) { [EOL]         if (Character.isHighSurrogate(str.charAt(index - 1)) && Character.isLowSurrogate(str.charAt(index))) { [EOL]             return index - 1; [EOL]         } [EOL]     } [EOL]     return index; [EOL] } <line_num>: 74,82
private static String unicodePreservingSubstring(String str, int begin, int end) { [EOL]     return str.substring(unicodePreservingIndex(str, begin), unicodePreservingIndex(str, end)); [EOL] } <line_num>: 114,118
