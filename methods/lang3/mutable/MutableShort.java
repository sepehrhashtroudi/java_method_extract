@Override [EOL] public Short getValue() { [EOL]     return Short.valueOf(this.value); [EOL] }
public void setValue(final short value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.shortValue(); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final short operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.shortValue(); [EOL] }
public void subtract(final short operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.shortValue(); [EOL] }
@Override [EOL] public short shortValue() { [EOL]     return value; [EOL] }
@Override [EOL] public int intValue() { [EOL]     return value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Short toShort() { [EOL]     return Short.valueOf(shortValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableShort) { [EOL]         return value == ((MutableShort) obj).shortValue(); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return value; [EOL] }
@Override [EOL] public int compareTo(final MutableShort other) { [EOL]     final short anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
