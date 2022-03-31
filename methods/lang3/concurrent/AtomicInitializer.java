@Override [EOL] public T get() throws ConcurrentException { [EOL]     T result = reference.get(); [EOL]     if (result == null) { [EOL]         result = initialize(); [EOL]         if (!reference.compareAndSet(null, result)) { [EOL]             result = reference.get(); [EOL]         } [EOL]     } [EOL]     return result; [EOL] }
protected abstract T initialize() throws ConcurrentException;
