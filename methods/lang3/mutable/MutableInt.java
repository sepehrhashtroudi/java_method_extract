@Override [EOL] public Integer getValue() { [EOL]     return Integer.valueOf(this.value); [EOL] }
public void setValue(final int value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.intValue(); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final int operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.intValue(); [EOL] }
public void subtract(final int operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.intValue(); [EOL] }
@Override [EOL] public int intValue() { [EOL]     return value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Integer toInteger() { [EOL]     return Integer.valueOf(intValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableInt) { [EOL]         return value == ((MutableInt) obj).intValue(); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return value; [EOL] }
@Override [EOL] public int compareTo(final MutableInt other) { [EOL]     final int anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
