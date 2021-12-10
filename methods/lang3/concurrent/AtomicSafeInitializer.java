@Override	public final T get() throws ConcurrentException {	    T result;	    while ((result = reference.get()) == null) {	        if (factory.compareAndSet(null, this)) {	            reference.set(initialize());	        }	    }	    return result;	}
protected abstract T initialize() throws ConcurrentException;
