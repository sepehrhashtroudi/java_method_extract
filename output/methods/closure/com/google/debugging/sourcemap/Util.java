static String escapeString(String s) { [EOL]     return escapeString(s, '"', "\\\"", "\'", "\\\\", null); [EOL] } <line_num>: 33,35
static String escapeString(String s, char quote, String doublequoteEscape, String singlequoteEscape, String backslashEscape, CharsetEncoder outputCharsetEncoder) { [EOL]     StringBuilder sb = new StringBuilder(s.length() + 2); [EOL]     sb.append(quote); [EOL]     for (int i = 0; i < s.length(); i++) { [EOL]         char c = s.charAt(i); [EOL]         switch(c) { [EOL]             case '\n': [EOL]                 sb.append("\\n"); [EOL]                 break; [EOL]             case '\r': [EOL]                 sb.append("\\r"); [EOL]                 break; [EOL]             case '\t': [EOL]                 sb.append("\\t"); [EOL]                 break; [EOL]             case '\\': [EOL]                 sb.append(backslashEscape); [EOL]                 break; [EOL]             case '\"': [EOL]                 sb.append(doublequoteEscape); [EOL]                 break; [EOL]             case '\'': [EOL]                 sb.append(singlequoteEscape); [EOL]                 break; [EOL]             case '>': [EOL]                 if (i >= 2 && ((s.charAt(i - 1) == '-' && s.charAt(i - 2) == '-') || (s.charAt(i - 1) == ']' && s.charAt(i - 2) == ']'))) { [EOL]                     sb.append("\\>"); [EOL]                 } else { [EOL]                     sb.append(c); [EOL]                 } [EOL]                 break; [EOL]             case '<': [EOL]                 final String END_SCRIPT = "/script"; [EOL]                 final String START_COMMENT = "!--"; [EOL]                 if (s.regionMatches(true, i + 1, END_SCRIPT, 0, END_SCRIPT.length())) { [EOL]                     sb.append("<\\"); [EOL]                 } else if (s.regionMatches(false, i + 1, START_COMMENT, 0, START_COMMENT.length())) { [EOL]                     sb.append("<\\"); [EOL]                 } else { [EOL]                     sb.append(c); [EOL]                 } [EOL]                 break; [EOL]             default: [EOL]                 if (outputCharsetEncoder != null) { [EOL]                     if (outputCharsetEncoder.canEncode(c)) { [EOL]                         sb.append(c); [EOL]                     } else { [EOL]                         appendCharAsHex(sb, c); [EOL]                     } [EOL]                 } else { [EOL]                     if (c > 0x1f && c <= 0x7f) { [EOL]                         sb.append(c); [EOL]                     } else { [EOL]                         appendCharAsHex(sb, c); [EOL]                     } [EOL]                 } [EOL]         } [EOL]     } [EOL]     sb.append(quote); [EOL]     return sb.toString(); [EOL] } <line_num>: 38,107
@SuppressWarnings("cast") [EOL] private static void appendCharAsHex(StringBuilder sb, char c) { [EOL]     try { [EOL]         appendHexJavaScriptRepresentation(sb, (int) c); [EOL]     } catch (IOException ex) { [EOL]         throw new RuntimeException(ex); [EOL]     } [EOL] } <line_num>: 112,121
private static void appendHexJavaScriptRepresentation(Appendable out, int codePoint) throws IOException { [EOL]     if (Character.isSupplementaryCodePoint(codePoint)) { [EOL]         char[] surrogates = Character.toChars(codePoint); [EOL]         appendHexJavaScriptRepresentation(out, surrogates[0]); [EOL]         appendHexJavaScriptRepresentation(out, surrogates[1]); [EOL]         return; [EOL]     } [EOL]     out.append("\\u").append(HEX_CHARS[(codePoint >>> 12) & 0xf]).append(HEX_CHARS[(codePoint >>> 8) & 0xf]).append(HEX_CHARS[(codePoint >>> 4) & 0xf]).append(HEX_CHARS[codePoint & 0xf]); [EOL] } <line_num>: 129,147
