private PieLabelLinkStyle(String name) { [EOL]     this.name = name; [EOL] } <line_num>: 74,76
public String toString() { [EOL]     return this.name; [EOL] } <line_num>: 83,85
public boolean equals(Object obj) { [EOL]     if (this == obj) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof PieLabelLinkStyle)) { [EOL]         return false; [EOL]     } [EOL]     PieLabelLinkStyle style = (PieLabelLinkStyle) obj; [EOL]     if (!this.name.equals(style.toString())) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 95,107
public int hashCode() { [EOL]     return this.name.hashCode(); [EOL] } <line_num>: 114,116
private Object readResolve() throws ObjectStreamException { [EOL]     Object result = null; [EOL]     if (this.equals(PieLabelLinkStyle.STANDARD)) { [EOL]         result = PieLabelLinkStyle.STANDARD; [EOL]     } else if (this.equals(PieLabelLinkStyle.QUAD_CURVE)) { [EOL]         result = PieLabelLinkStyle.QUAD_CURVE; [EOL]     } else if (this.equals(PieLabelLinkStyle.CUBIC_CURVE)) { [EOL]         result = PieLabelLinkStyle.CUBIC_CURVE; [EOL]     } [EOL]     return result; [EOL] } <line_num>: 125,137