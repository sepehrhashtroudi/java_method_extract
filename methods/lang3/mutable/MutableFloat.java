@Override [EOL] public Float getValue() { [EOL]     return Float.valueOf(this.value); [EOL] }
public void setValue(final float value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Number value) { [EOL]     this.value = value.floatValue(); [EOL] }
public boolean isNaN() { [EOL]     return Float.isNaN(value); [EOL] }
public boolean isInfinite() { [EOL]     return Float.isInfinite(value); [EOL] }
public void increment() { [EOL]     value++; [EOL] }
public void decrement() { [EOL]     value--; [EOL] }
public void add(final float operand) { [EOL]     this.value += operand; [EOL] }
public void add(final Number operand) { [EOL]     this.value += operand.floatValue(); [EOL] }
public void subtract(final float operand) { [EOL]     this.value -= operand; [EOL] }
public void subtract(final Number operand) { [EOL]     this.value -= operand.floatValue(); [EOL] }
@Override [EOL] public int intValue() { [EOL]     return (int) value; [EOL] }
@Override [EOL] public long longValue() { [EOL]     return (long) value; [EOL] }
@Override [EOL] public float floatValue() { [EOL]     return value; [EOL] }
@Override [EOL] public double doubleValue() { [EOL]     return value; [EOL] }
public Float toFloat() { [EOL]     return Float.valueOf(floatValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     return obj instanceof MutableFloat && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(value); [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return Float.floatToIntBits(value); [EOL] }
@Override [EOL] public int compareTo(final MutableFloat other) { [EOL]     final float anotherVal = other.value; [EOL]     return Float.compare(value, anotherVal); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
