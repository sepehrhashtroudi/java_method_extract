public final ThreadFactory getWrappedFactory() {	    return wrappedFactory;	}
public final String getNamingPattern() {	    return namingPattern;	}
public final Boolean getDaemonFlag() {	    return daemonFlag;	}
public final Integer getPriority() {	    return priority;	}
public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {	    return uncaughtExceptionHandler;	}
public long getThreadCount() {	    return threadCounter.get();	}
@Override	public Thread newThread(final Runnable r) {	    final Thread t = getWrappedFactory().newThread(r);	    initializeThread(t);	    return t;	}
private void initializeThread(final Thread t) {	    if (getNamingPattern() != null) {	        final Long count = Long.valueOf(threadCounter.incrementAndGet());	        t.setName(String.format(getNamingPattern(), count));	    }	    if (getUncaughtExceptionHandler() != null) {	        t.setUncaughtExceptionHandler(getUncaughtExceptionHandler());	    }	    if (getPriority() != null) {	        t.setPriority(getPriority().intValue());	    }	    if (getDaemonFlag() != null) {	        t.setDaemon(getDaemonFlag().booleanValue());	    }	}
public Builder wrappedFactory(final ThreadFactory factory) {	    if (factory == null) {	        throw new NullPointerException("Wrapped ThreadFactory must not be null!");	    }	    wrappedFactory = factory;	    return this;	}
public Builder namingPattern(final String pattern) {	    if (pattern == null) {	        throw new NullPointerException("Naming pattern must not be null!");	    }	    namingPattern = pattern;	    return this;	}
public Builder daemon(final boolean f) {	    daemonFlag = Boolean.valueOf(f);	    return this;	}
public Builder priority(final int prio) {	    priority = Integer.valueOf(prio);	    return this;	}
public Builder uncaughtExceptionHandler(final Thread.UncaughtExceptionHandler handler) {	    if (handler == null) {	        throw new NullPointerException("Uncaught exception handler must not be null!");	    }	    exceptionHandler = handler;	    return this;	}
public void reset() {	    wrappedFactory = null;	    exceptionHandler = null;	    namingPattern = null;	    priority = null;	    daemonFlag = null;	}
@Override	public BasicThreadFactory build() {	    final BasicThreadFactory factory = new BasicThreadFactory(this);	    reset();	    return factory;	}
