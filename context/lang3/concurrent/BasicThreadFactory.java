Builder
BasicThreadFactory
public final ThreadFactory getWrappedFactory()
public final String getNamingPattern()
public final Boolean getDaemonFlag()
public final Integer getPriority()
public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler()
public long getThreadCount()
public Thread newThread(final Runnable r)
private void initializeThread(final Thread t)
public Builder wrappedFactory(final ThreadFactory factory)
public Builder namingPattern(final String pattern)
public Builder daemon(final boolean f)
public Builder priority(final int prio)
public Builder uncaughtExceptionHandler(final Thread.UncaughtExceptionHandler handler)
public void reset()
public BasicThreadFactory build()
AtomicLong threadCounter
ThreadFactory wrappedFactory
Thread.UncaughtExceptionHandler uncaughtExceptionHandler
String namingPattern
Integer priority
Boolean daemonFlag
