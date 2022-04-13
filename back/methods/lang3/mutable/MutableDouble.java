@Override [EOL] public Double getValue() { [EOL]     return Double.valueOf(this.value); [EOL] }
public void setValue(final double value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.doubleValue(); [EOL] }
public boolean isNaN() { [EOL]     return Double.isNaN(value); [EOL] }
public boolean isInfinite() { [EOL]     return Double.isInfinite(value); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final double operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.doubleValue(); [EOL] }
public void subtract(final double operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.doubleValue(); [EOL] }
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return (long) value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return (float) value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Double toDouble() { [EOL]     return Double.valueOf(doubleValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     return obj instanceof MutableDouble && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(value); [EOL] }
@Override [EOL] public int hashCode() { [EOL]     final long bits = Double.doubleToLongBits(value); [EOL]     return (int) (bits ^ bits >>> 32); [EOL] }
@Override [EOL] public int compareTo(final MutableDouble other) { [EOL]     final double anotherVal = other.value; [EOL]     return Double.compare(value, anotherVal); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
