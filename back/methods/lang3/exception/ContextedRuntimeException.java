@Override [EOL] public ContextedRuntimeException addContextValue(final String label, final Object value) { [EOL]     exceptionContext.addContextValue(label, value); [EOL]     return this; [EOL] }
@Override [EOL] public ContextedRuntimeException setContextValue(final String label, final Object value) { [EOL]     exceptionContext.setContextValue(label, value); [EOL]     return this; [EOL] }
@Override [EOL] public List<Object> getContextValues(final String label) { [EOL]     return this.exceptionContext.getContextValues(label); [EOL] }
@Override [EOL] public Object getFirstContextValue(final String label) { [EOL]     return this.exceptionContext.getFirstContextValue(label); [EOL] }
@Override [EOL] public List<Pair<String, Object>> getContextEntries() { [EOL]     return this.exceptionContext.getContextEntries(); [EOL] }
@Override [EOL] public Set<String> getContextLabels() { [EOL]     return exceptionContext.getContextLabels(); [EOL] }
@Override [EOL] public String getMessage() { [EOL]     return getFormattedExceptionMessage(super.getMessage()); [EOL] }
public String getRawMessage() { [EOL]     return super.getMessage(); [EOL] }
@Override [EOL] public String getFormattedExceptionMessage(final String baseMessage) { [EOL]     return exceptionContext.getFormattedExceptionMessage(baseMessage); [EOL] }
