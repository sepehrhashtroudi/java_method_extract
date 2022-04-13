public final synchronized int getLimit() { [EOL]     return limit; [EOL] }
public final synchronized void setLimit(final int limit) { [EOL]     this.limit = limit; [EOL] }
public synchronized void shutdown() { [EOL]     if (!shutdown) { [EOL]         if (ownExecutor) { [EOL]             getExecutorService().shutdownNow(); [EOL]         } [EOL]         if (task != null) { [EOL]             task.cancel(false); [EOL]         } [EOL]         shutdown = true; [EOL]     } [EOL] }
public synchronized boolean isShutdown() { [EOL]     return shutdown; [EOL] }
public synchronized void acquire() throws InterruptedException { [EOL]     if (isShutdown()) { [EOL]         throw new IllegalStateException("TimedSemaphore is shut down!"); [EOL]     } [EOL]     if (task == null) { [EOL]         task = startTimer(); [EOL]     } [EOL]     boolean canPass = false; [EOL]     do { [EOL]         canPass = getLimit() <= NO_LIMIT || acquireCount < getLimit(); [EOL]         if (!canPass) { [EOL]             wait(); [EOL]         } else { [EOL]             acquireCount++; [EOL]         } [EOL]     } while (!canPass); [EOL] }
public synchronized int getLastAcquiresPerPeriod() { [EOL]     return lastCallsPerPeriod; [EOL] }
public synchronized int getAcquireCount() { [EOL]     return acquireCount; [EOL] }
public synchronized int getAvailablePermits() { [EOL]     return getLimit() - getAcquireCount(); [EOL] }
public synchronized double getAverageCallsPerPeriod() { [EOL]     return periodCount == 0 ? 0 : (double) totalAcquireCount / (double) periodCount; [EOL] }
public long getPeriod() { [EOL]     return period; [EOL] }
public TimeUnit getUnit() { [EOL]     return unit; [EOL] }
protected ScheduledExecutorService getExecutorService() { [EOL]     return executorService; [EOL] }
@Override [EOL] public void run() { [EOL]     endOfPeriod(); [EOL] }
protected ScheduledFuture<?> startTimer() { [EOL]     return getExecutorService().scheduleAtFixedRate(new Runnable() { [EOL]  [EOL]         @Override [EOL]         public void run() { [EOL]             endOfPeriod(); [EOL]         } [EOL]     }, getPeriod(), getPeriod(), getUnit()); [EOL] }
synchronized void endOfPeriod() { [EOL]     lastCallsPerPeriod = acquireCount; [EOL]     totalAcquireCount += acquireCount; [EOL]     periodCount++; [EOL]     acquireCount = 0; [EOL]     notifyAll(); [EOL] }
