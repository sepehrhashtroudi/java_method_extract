@Override [EOL] public T getValue() { [EOL]     return this.value; [EOL] }
@Override [EOL] public void setValue(final T value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj == null) { [EOL]         return false; [EOL]     } [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (this.getClass() == obj.getClass()) { [EOL]         final MutableObject<?> that = (MutableObject<?>) obj; [EOL]         return this.value.equals(that.value); [EOL]     } else { [EOL]         return false; [EOL]     } [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return value == null ? 0 : value.hashCode(); [EOL] }
@Override [EOL] public String toString() { [EOL]     return value == null ? "null" : value.toString(); [EOL] }
