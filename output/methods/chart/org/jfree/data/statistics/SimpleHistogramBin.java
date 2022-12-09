public SimpleHistogramBin(double lowerBound, double upperBound) { [EOL]     this(lowerBound, upperBound, true, true); [EOL] } <line_num>: 92,94
public SimpleHistogramBin(double lowerBound, double upperBound, boolean includeLowerBound, boolean includeUpperBound) { [EOL]     if (lowerBound >= upperBound) { [EOL]         throw new IllegalArgumentException("Invalid bounds; " + lowerBound + " to " + upperBound); [EOL]     } [EOL]     this.lowerBound = lowerBound; [EOL]     this.upperBound = upperBound; [EOL]     this.includeLowerBound = includeLowerBound; [EOL]     this.includeUpperBound = includeUpperBound; [EOL]     this.itemCount = 0; [EOL]     this.selected = false; [EOL] } <line_num>: 104,117
public double getLowerBound() { [EOL]     return this.lowerBound; [EOL] } <line_num>: 126,128
public double getUpperBound() { [EOL]     return this.upperBound; [EOL] } <line_num>: 137,139
public int getItemCount() { [EOL]     return this.itemCount; [EOL] } <line_num>: 148,150
public void setItemCount(int count) { [EOL]     this.itemCount = count; [EOL] } <line_num>: 163,165
public boolean isSelected() { [EOL]     return this.selected; [EOL] } <line_num>: 176,178
public void setSelected(boolean selected) { [EOL]     this.selected = selected; [EOL] } <line_num>: 189,191
public boolean accepts(double value) { [EOL]     if (Double.isNaN(value)) { [EOL]         return false; [EOL]     } [EOL]     if (value < this.lowerBound) { [EOL]         return false; [EOL]     } [EOL]     if (value > this.upperBound) { [EOL]         return false; [EOL]     } [EOL]     if (value == this.lowerBound) { [EOL]         return this.includeLowerBound; [EOL]     } [EOL]     if (value == this.upperBound) { [EOL]         return this.includeUpperBound; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 201,218
public boolean overlapsWith(SimpleHistogramBin bin) { [EOL]     if (this.upperBound < bin.lowerBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.lowerBound > bin.upperBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.upperBound == bin.lowerBound) { [EOL]         return this.includeUpperBound && bin.includeLowerBound; [EOL]     } [EOL]     if (this.lowerBound == bin.upperBound) { [EOL]         return this.includeLowerBound && bin.includeUpperBound; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 228,242
public int compareTo(Object obj) { [EOL]     if (!(obj instanceof SimpleHistogramBin)) { [EOL]         return 0; [EOL]     } [EOL]     SimpleHistogramBin bin = (SimpleHistogramBin) obj; [EOL]     if (this.lowerBound < bin.lowerBound) { [EOL]         return -1; [EOL]     } [EOL]     if (this.lowerBound > bin.lowerBound) { [EOL]         return 1; [EOL]     } [EOL]     if (this.upperBound < bin.upperBound) { [EOL]         return -1; [EOL]     } [EOL]     if (this.upperBound > bin.upperBound) { [EOL]         return 1; [EOL]     } [EOL]     return 0; [EOL] } <line_num>: 253,272
public boolean equals(Object obj) { [EOL]     if (!(obj instanceof SimpleHistogramBin)) { [EOL]         return false; [EOL]     } [EOL]     SimpleHistogramBin that = (SimpleHistogramBin) obj; [EOL]     if (this.lowerBound != that.lowerBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.upperBound != that.upperBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.includeLowerBound != that.includeLowerBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.includeUpperBound != that.includeUpperBound) { [EOL]         return false; [EOL]     } [EOL]     if (this.itemCount != that.itemCount) { [EOL]         return false; [EOL]     } [EOL]     if (this.selected != that.selected) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 281,305
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 314,316
