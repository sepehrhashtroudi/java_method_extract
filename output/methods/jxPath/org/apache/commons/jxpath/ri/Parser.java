public static Object parseExpression(String expression, Compiler compiler) { [EOL]     synchronized (parser) { [EOL]         parser.setCompiler(compiler); [EOL]         Object expr = null; [EOL]         try { [EOL]             parser.ReInit(new StringReader(expression)); [EOL]             expr = parser.parseExpression(); [EOL]         } catch (TokenMgrError e) { [EOL]             throw new JXPathInvalidSyntaxException("Invalid XPath: '" + addEscapes(expression) + "'. Invalid symbol '" + addEscapes(String.valueOf(e.getCharacter())) + "' " + describePosition(expression, e.getPosition())); [EOL]         } catch (ParseException e) { [EOL]             throw new JXPathInvalidSyntaxException("Invalid XPath: '" + addEscapes(expression) + "'. Syntax error " + describePosition(expression, e.currentToken.beginColumn)); [EOL]         } [EOL]         return expr; [EOL]     } [EOL] } <line_num>: 40,71
private static String describePosition(String expression, int position) { [EOL]     if (position <= 0) { [EOL]         return "at the beginning of the expression"; [EOL]     } else if (position >= expression.length()) { [EOL]         return "- expression incomplete"; [EOL]     } else { [EOL]         return "after: '" + addEscapes(expression.substring(0, position)) + "'"; [EOL]     } [EOL] } <line_num>: 73,84
private static String addEscapes(String string) { [EOL]     return TokenMgrError.addEscapes(string); [EOL] } <line_num>: 86,89