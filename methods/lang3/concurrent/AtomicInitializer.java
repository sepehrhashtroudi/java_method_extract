@Override	public T get() throws ConcurrentException {	    T result = reference.get();	    if (result == null) {	        result = initialize();	        if (!reference.compareAndSet(null, result)) {	            result = reference.get();	        }	    }	    return result;	}
protected abstract T initialize() throws ConcurrentException;
