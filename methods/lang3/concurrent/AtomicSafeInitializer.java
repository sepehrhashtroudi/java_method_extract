@Override [EOL] public final T get() throws ConcurrentException { [EOL]     T result; [EOL]     while ((result = reference.get()) == null) { [EOL]         if (factory.compareAndSet(null, this)) { [EOL]             reference.set(initialize()); [EOL]         } [EOL]     } [EOL]     return result; [EOL] }
protected abstract T initialize() throws ConcurrentException;
