public ExceptionContext addContextValue(String label, Object value);
public ExceptionContext setContextValue(String label, Object value);
public List<Object> getContextValues(String label);
public Object getFirstContextValue(String label);
public Set<String> getContextLabels();
public List<Pair<String, Object>> getContextEntries();
public String getFormattedExceptionMessage(String baseMessage);
