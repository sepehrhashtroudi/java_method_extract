public final synchronized ExecutorService getExternalExecutor() { [EOL]     return externalExecutor; [EOL] }
public synchronized boolean isStarted() { [EOL]     return future != null; [EOL] }
public final synchronized void setExternalExecutor(final ExecutorService externalExecutor) { [EOL]     if (isStarted()) { [EOL]         throw new IllegalStateException("Cannot set ExecutorService after start()!"); [EOL]     } [EOL]     this.externalExecutor = externalExecutor; [EOL] }
public synchronized boolean start() { [EOL]     if (!isStarted()) { [EOL]         ExecutorService tempExec; [EOL]         executor = getExternalExecutor(); [EOL]         if (executor == null) { [EOL]             executor = tempExec = createExecutor(); [EOL]         } else { [EOL]             tempExec = null; [EOL]         } [EOL]         future = executor.submit(createTask(tempExec)); [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public T get() throws ConcurrentException { [EOL]     try { [EOL]         return getFuture().get(); [EOL]     } catch (final ExecutionException execex) { [EOL]         ConcurrentUtils.handleCause(execex); [EOL]         return null; [EOL]     } catch (final InterruptedException iex) { [EOL]         Thread.currentThread().interrupt(); [EOL]         throw new ConcurrentException(iex); [EOL]     } [EOL] }
public synchronized Future<T> getFuture() { [EOL]     if (future == null) { [EOL]         throw new IllegalStateException("start() must be called first!"); [EOL]     } [EOL]     return future; [EOL] }
protected synchronized final ExecutorService getActiveExecutor() { [EOL]     return executor; [EOL] }
protected int getTaskCount() { [EOL]     return 1; [EOL] }
protected abstract T initialize() throws Exception;
private Callable<T> createTask(final ExecutorService execDestroy) { [EOL]     return new InitializationTask(execDestroy); [EOL] }
private ExecutorService createExecutor() { [EOL]     return Executors.newFixedThreadPool(getTaskCount()); [EOL] }
@Override [EOL] public T call() throws Exception { [EOL]     try { [EOL]         return initialize(); [EOL]     } finally { [EOL]         if (execFinally != null) { [EOL]             execFinally.shutdown(); [EOL]         } [EOL]     } [EOL] }
