public HighLowItemLabelGenerator() { [EOL]     this(DateFormat.getInstance(), NumberFormat.getInstance()); [EOL] } <line_num>: 86,88
public HighLowItemLabelGenerator(DateFormat dateFormatter, NumberFormat numberFormatter) { [EOL]     if (dateFormatter == null) { [EOL]         throw new IllegalArgumentException("Null 'dateFormatter' argument."); [EOL]     } [EOL]     if (numberFormatter == null) { [EOL]         throw new IllegalArgumentException("Null 'numberFormatter' argument."); [EOL]     } [EOL]     this.dateFormatter = dateFormatter; [EOL]     this.numberFormatter = numberFormatter; [EOL] } <line_num>: 98,110
public String generateToolTip(XYDataset dataset, int series, int item) { [EOL]     String result = null; [EOL]     if (dataset instanceof OHLCDataset) { [EOL]         OHLCDataset d = (OHLCDataset) dataset; [EOL]         Number high = d.getHigh(series, item); [EOL]         Number low = d.getLow(series, item); [EOL]         Number open = d.getOpen(series, item); [EOL]         Number close = d.getClose(series, item); [EOL]         Number x = d.getX(series, item); [EOL]         result = d.getSeriesKey(series).toString(); [EOL]         if (x != null) { [EOL]             Date date = new Date(x.longValue()); [EOL]             result = result + "--> Date=" + this.dateFormatter.format(date); [EOL]             if (high != null) { [EOL]                 result = result + " High=" + this.numberFormatter.format(high.doubleValue()); [EOL]             } [EOL]             if (low != null) { [EOL]                 result = result + " Low=" + this.numberFormatter.format(low.doubleValue()); [EOL]             } [EOL]             if (open != null) { [EOL]                 result = result + " Open=" + this.numberFormatter.format(open.doubleValue()); [EOL]             } [EOL]             if (close != null) { [EOL]                 result = result + " Close=" + this.numberFormatter.format(close.doubleValue()); [EOL]             } [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 121,160
public String generateLabel(XYDataset dataset, int series, int category) { [EOL]     return null; [EOL] } <line_num>: 172,174
public Object clone() throws CloneNotSupportedException { [EOL]     HighLowItemLabelGenerator clone = (HighLowItemLabelGenerator) super.clone(); [EOL]     if (this.dateFormatter != null) { [EOL]         clone.dateFormatter = (DateFormat) this.dateFormatter.clone(); [EOL]     } [EOL]     if (this.numberFormatter != null) { [EOL]         clone.numberFormatter = (NumberFormat) this.numberFormatter.clone(); [EOL]     } [EOL]     return clone; [EOL] } <line_num>: 183,197
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof HighLowItemLabelGenerator)) { [EOL]         return false; [EOL]     } [EOL]     HighLowItemLabelGenerator generator = (HighLowItemLabelGenerator) obj; [EOL]     if (!this.dateFormatter.equals(generator.dateFormatter)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.numberFormatter.equals(generator.numberFormatter)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 206,221
public int hashCode() { [EOL]     int result = 127; [EOL]     result = HashUtilities.hashCode(result, this.dateFormatter); [EOL]     result = HashUtilities.hashCode(result, this.numberFormatter); [EOL]     return result; [EOL] } <line_num>: 228,233
