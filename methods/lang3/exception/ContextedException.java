@Override	public ContextedException addContextValue(final String label, final Object value) {	    exceptionContext.addContextValue(label, value);	    return this;	}
@Override	public ContextedException setContextValue(final String label, final Object value) {	    exceptionContext.setContextValue(label, value);	    return this;	}
@Override	public List<Object> getContextValues(final String label) {	    return this.exceptionContext.getContextValues(label);	}
@Override	public Object getFirstContextValue(final String label) {	    return this.exceptionContext.getFirstContextValue(label);	}
@Override	public List<Pair<String, Object>> getContextEntries() {	    return this.exceptionContext.getContextEntries();	}
@Override	public Set<String> getContextLabels() {	    return exceptionContext.getContextLabels();	}
@Override	public String getMessage() {	    return getFormattedExceptionMessage(super.getMessage());	}
public String getRawMessage() {	    return super.getMessage();	}
@Override	public String getFormattedExceptionMessage(final String baseMessage) {	    return exceptionContext.getFormattedExceptionMessage(baseMessage);	}
