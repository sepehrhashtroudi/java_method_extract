@Override [EOL] public Long getValue() { [EOL]     return Long.valueOf(this.value); [EOL] }
public void setValue(final long value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.longValue(); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final long operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.longValue(); [EOL] }
public void subtract(final long operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.longValue(); [EOL] }
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Long toLong() { [EOL]     return Long.valueOf(longValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableLong) { [EOL]         return value == ((MutableLong) obj).longValue(); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return (int) (value ^ (value >>> 32)); [EOL] }
@Override [EOL] public int compareTo(final MutableLong other) { [EOL]     final long anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
