private SymbolInfo(String functionName, String symbol) { [EOL]     this.functionName = functionName; [EOL]     this.symbol = symbol; [EOL] } <line_num>: 42,45
public JsFunctionParser(Collection<String> functions, ErrorManager errorManager) { [EOL]     super(errorManager); [EOL]     functionsToParse = functions; [EOL]     pattern = getPattern(functions); [EOL]     matcher = pattern.matcher(""); [EOL] } <line_num>: 69,75
private Pattern getPattern(Collection<String> functions) { [EOL]     StringBuilder sb = new StringBuilder("(?:^|;)\\s*("); [EOL]     for (String function : functions) { [EOL]         sb.append(Pattern.quote(function) + "|"); [EOL]     } [EOL]     sb.deleteCharAt(sb.length() - 1); [EOL]     sb.append(")\\s*\\((.*?)\\)"); [EOL]     return Pattern.compile(sb.toString()); [EOL] } <line_num>: 83,95
public Collection<SymbolInfo> parseFile(String filePath, String fileContents) { [EOL]     return parseReader(filePath, new StringReader(fileContents)); [EOL] } <line_num>: 106,109
private Collection<SymbolInfo> parseReader(String filePath, Reader fileContents) { [EOL]     symbols = Lists.newArrayList(); [EOL]     logger.fine("Parsing Source: " + filePath); [EOL]     doParse(filePath, fileContents); [EOL]     return symbols; [EOL] } <line_num>: 111,119
@Override [EOL] protected boolean parseLine(String line) throws ParseException { [EOL]     boolean hasFunctions = false; [EOL]     boolean parseLine = false; [EOL]     for (String function : functionsToParse) { [EOL]         if (line.indexOf(function) != -1) { [EOL]             parseLine = true; [EOL]             break; [EOL]         } [EOL]     } [EOL]     if (parseLine) { [EOL]         matcher.reset(line); [EOL]         while (matcher.find()) { [EOL]             hasFunctions = true; [EOL]             String functionName = matcher.group(1); [EOL]             String arg = parseJsString(matcher.group(2)); [EOL]             symbols.add(new SymbolInfo(functionName, arg)); [EOL]         } [EOL]     } [EOL]     return !shortcutMode || hasFunctions || CharMatcher.WHITESPACE.matchesAllOf(line); [EOL] } <line_num>: 124,150
