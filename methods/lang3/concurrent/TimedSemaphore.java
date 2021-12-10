public final synchronized int getLimit() {	    return limit;	}
public final synchronized void setLimit(final int limit) {	    this.limit = limit;	}
public synchronized void shutdown() {	    if (!shutdown) {	        if (ownExecutor) {	            getExecutorService().shutdownNow();	        }	        if (task != null) {	            task.cancel(false);	        }	        shutdown = true;	    }	}
public synchronized boolean isShutdown() {	    return shutdown;	}
public synchronized void acquire() throws InterruptedException {	    if (isShutdown()) {	        throw new IllegalStateException("TimedSemaphore is shut down!");	    }	    if (task == null) {	        task = startTimer();	    }	    boolean canPass = false;	    do {	        canPass = getLimit() <= NO_LIMIT || acquireCount < getLimit();	        if (!canPass) {	            wait();	        } else {	            acquireCount++;	        }	    } while (!canPass);	}
public synchronized int getLastAcquiresPerPeriod() {	    return lastCallsPerPeriod;	}
public synchronized int getAcquireCount() {	    return acquireCount;	}
public synchronized int getAvailablePermits() {	    return getLimit() - getAcquireCount();	}
public synchronized double getAverageCallsPerPeriod() {	    return periodCount == 0 ? 0 : (double) totalAcquireCount / (double) periodCount;	}
public long getPeriod() {	    return period;	}
public TimeUnit getUnit() {	    return unit;	}
protected ScheduledExecutorService getExecutorService() {	    return executorService;	}
@Override	public void run() {	    endOfPeriod();	}
protected ScheduledFuture<?> startTimer() {	    return getExecutorService().scheduleAtFixedRate(new Runnable() {		        @Override	        public void run() {	            endOfPeriod();	        }	    }, getPeriod(), getPeriod(), getUnit());	}
synchronized void endOfPeriod() {	    lastCallsPerPeriod = acquireCount;	    totalAcquireCount += acquireCount;	    periodCount++;	    acquireCount = 0;	    notifyAll();	}
