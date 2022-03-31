@Override [EOL] public Byte getValue() { [EOL]     return Byte.valueOf(this.value); [EOL] }
public void setValue(final byte value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.byteValue(); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final byte operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.byteValue(); [EOL] }
public void subtract(final byte operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.byteValue(); [EOL] }
@Override [EOL] public byte byteValue() { [EOL]     return value; [EOL] }
@Override [EOL] public int intValue() { [EOL]     return value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Byte toByte() { [EOL]     return Byte.valueOf(byteValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableByte) { [EOL]         return value == ((MutableByte) obj).byteValue(); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return value; [EOL] }
@Override [EOL] public int compareTo(final MutableByte other) { [EOL]     final byte anotherVal = other.value; [EOL]     return value < anotherVal ? -1 : (value == anotherVal ? 0 : 1); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
