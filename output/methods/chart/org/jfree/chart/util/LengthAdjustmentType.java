private LengthAdjustmentType(String name) { [EOL]     this.name = name; [EOL] } <line_num>: 76,78
public String toString() { [EOL]     return this.name; [EOL] } <line_num>: 85,87
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof LengthAdjustmentType)) { [EOL]         return false; [EOL]     } [EOL]     final LengthAdjustmentType that = (LengthAdjustmentType) obj; [EOL]     if (!this.name.equals(that.name)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 97,109
public int hashCode() { [EOL]     return this.name.hashCode(); [EOL] } <line_num>: 116,118
private Object readResolve() throws ObjectStreamException { [EOL]     if (this.equals(LengthAdjustmentType.NO_CHANGE)) { [EOL]         return LengthAdjustmentType.NO_CHANGE; [EOL]     } else if (this.equals(LengthAdjustmentType.EXPAND)) { [EOL]         return LengthAdjustmentType.EXPAND; [EOL]     } else if (this.equals(LengthAdjustmentType.CONTRACT)) { [EOL]         return LengthAdjustmentType.CONTRACT; [EOL]     } [EOL]     return null; [EOL] } <line_num>: 127,138
