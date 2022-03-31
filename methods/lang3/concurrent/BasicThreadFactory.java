public final ThreadFactory getWrappedFactory() { [EOL]     return wrappedFactory; [EOL] }
public final String getNamingPattern() { [EOL]     return namingPattern; [EOL] }
public final Boolean getDaemonFlag() { [EOL]     return daemonFlag; [EOL] }
public final Integer getPriority() { [EOL]     return priority; [EOL] }
public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() { [EOL]     return uncaughtExceptionHandler; [EOL] }
public long getThreadCount() { [EOL]     return threadCounter.get(); [EOL] }
@Override [EOL] public Thread newThread(final Runnable r) { [EOL]     final Thread t = getWrappedFactory().newThread(r); [EOL]     initializeThread(t); [EOL]     return t; [EOL] }
private void initializeThread(final Thread t) { [EOL]     if (getNamingPattern() != null) { [EOL]         final Long count = Long.valueOf(threadCounter.incrementAndGet()); [EOL]         t.setName(String.format(getNamingPattern(), count)); [EOL]     } [EOL]     if (getUncaughtExceptionHandler() != null) { [EOL]         t.setUncaughtExceptionHandler(getUncaughtExceptionHandler()); [EOL]     } [EOL]     if (getPriority() != null) { [EOL]         t.setPriority(getPriority().intValue()); [EOL]     } [EOL]     if (getDaemonFlag() != null) { [EOL]         t.setDaemon(getDaemonFlag().booleanValue()); [EOL]     } [EOL] }
public Builder wrappedFactory(final ThreadFactory factory) { [EOL]     if (factory == null) { [EOL]         throw new NullPointerException("Wrapped ThreadFactory must not be null!"); [EOL]     } [EOL]     wrappedFactory = factory; [EOL]     return this; [EOL] }
public Builder namingPattern(final String pattern) { [EOL]     if (pattern == null) { [EOL]         throw new NullPointerException("Naming pattern must not be null!"); [EOL]     } [EOL]     namingPattern = pattern; [EOL]     return this; [EOL] }
public Builder daemon(final boolean f) { [EOL]     daemonFlag = Boolean.valueOf(f); [EOL]     return this; [EOL] }
public Builder priority(final int prio) { [EOL]     priority = Integer.valueOf(prio); [EOL]     return this; [EOL] }
public Builder uncaughtExceptionHandler(final Thread.UncaughtExceptionHandler handler) { [EOL]     if (handler == null) { [EOL]         throw new NullPointerException("Uncaught exception handler must not be null!"); [EOL]     } [EOL]     exceptionHandler = handler; [EOL]     return this; [EOL] }
public void reset() { [EOL]     wrappedFactory = null; [EOL]     exceptionHandler = null; [EOL]     namingPattern = null; [EOL]     priority = null; [EOL]     daemonFlag = null; [EOL] }
@Override [EOL] public BasicThreadFactory build() { [EOL]     final BasicThreadFactory factory = new BasicThreadFactory(this); [EOL]     reset(); [EOL]     return factory; [EOL] }
