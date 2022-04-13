@Override [EOL] public Boolean getValue() { [EOL]     return Boolean.valueOf(this.value); [EOL] }
public void setValue(final boolean value) { [EOL]     this.value = value; [EOL] }
@Override [EOL] public void setValue(final Boolean value) { [EOL]     this.value = value.booleanValue(); [EOL] }
public boolean isTrue() { [EOL]     return value == true; [EOL] }
public boolean isFalse() { [EOL]     return value == false; [EOL] }
public boolean booleanValue() { [EOL]     return value; [EOL] }
public Boolean toBoolean() { [EOL]     return Boolean.valueOf(booleanValue()); [EOL] }
@Override [EOL] public boolean equals(final Object obj) { [EOL]     if (obj instanceof MutableBoolean) { [EOL]         return value == ((MutableBoolean) obj).booleanValue(); [EOL]     } [EOL]     return false; [EOL] }
@Override [EOL] public int hashCode() { [EOL]     return value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode(); [EOL] }
@Override [EOL] public int compareTo(final MutableBoolean other) { [EOL]     final boolean anotherVal = other.value; [EOL]     return value == anotherVal ? 0 : (value ? 1 : -1); [EOL] }
@Override [EOL] public String toString() { [EOL]     return String.valueOf(value); [EOL] }
