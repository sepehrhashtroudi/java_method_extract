public void warning(String message, String sourceName, int line, int lineOffset)
public void error(String message, String sourceName, int line, int lineOffset)
public List<String> errors()
public List<String> warnings()
private String formatDetailedMessage(String message, String sourceName, int lineNumber, int lineOffset)