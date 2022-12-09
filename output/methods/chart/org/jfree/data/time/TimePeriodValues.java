public TimePeriodValues(Comparable name) { [EOL]     this(name, DEFAULT_DOMAIN_DESCRIPTION, DEFAULT_RANGE_DESCRIPTION); [EOL] } <line_num>: 113,115
public TimePeriodValues(Comparable name, String domain, String range) { [EOL]     super(name); [EOL]     this.domain = domain; [EOL]     this.range = range; [EOL]     this.data = new ArrayList(); [EOL] } <line_num>: 128,133
public String getDomainDescription() { [EOL]     return this.domain; [EOL] } <line_num>: 143,145
public void setDomainDescription(String description) { [EOL]     String old = this.domain; [EOL]     this.domain = description; [EOL]     firePropertyChange("Domain", old, description); [EOL] } <line_num>: 155,159
public String getRangeDescription() { [EOL]     return this.range; [EOL] } <line_num>: 169,171
public void setRangeDescription(String description) { [EOL]     String old = this.range; [EOL]     this.range = description; [EOL]     firePropertyChange("Range", old, description); [EOL] } <line_num>: 181,185
public int getItemCount() { [EOL]     return this.data.size(); [EOL] } <line_num>: 192,194
public TimePeriodValue getDataItem(int index) { [EOL]     return (TimePeriodValue) this.data.get(index); [EOL] } <line_num>: 204,206
public TimePeriod getTimePeriod(int index) { [EOL]     return getDataItem(index).getPeriod(); [EOL] } <line_num>: 218,220
public Number getValue(int index) { [EOL]     return getDataItem(index).getValue(); [EOL] } <line_num>: 232,234
public void add(TimePeriodValue item) { [EOL]     if (item == null) { [EOL]         throw new IllegalArgumentException("Null item not allowed."); [EOL]     } [EOL]     this.data.add(item); [EOL]     updateBounds(item.getPeriod(), this.data.size() - 1); [EOL]     fireSeriesChanged(); [EOL] } <line_num>: 242,249
private void updateBounds(TimePeriod period, int index) { [EOL]     long start = period.getStart().getTime(); [EOL]     long end = period.getEnd().getTime(); [EOL]     long middle = start + ((end - start) / 2); [EOL]     if (this.minStartIndex >= 0) { [EOL]         long minStart = getDataItem(this.minStartIndex).getPeriod().getStart().getTime(); [EOL]         if (start < minStart) { [EOL]             this.minStartIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.minStartIndex = index; [EOL]     } [EOL]     if (this.maxStartIndex >= 0) { [EOL]         long maxStart = getDataItem(this.maxStartIndex).getPeriod().getStart().getTime(); [EOL]         if (start > maxStart) { [EOL]             this.maxStartIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.maxStartIndex = index; [EOL]     } [EOL]     if (this.minMiddleIndex >= 0) { [EOL]         long s = getDataItem(this.minMiddleIndex).getPeriod().getStart().getTime(); [EOL]         long e = getDataItem(this.minMiddleIndex).getPeriod().getEnd().getTime(); [EOL]         long minMiddle = s + (e - s) / 2; [EOL]         if (middle < minMiddle) { [EOL]             this.minMiddleIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.minMiddleIndex = index; [EOL]     } [EOL]     if (this.maxMiddleIndex >= 0) { [EOL]         long s = getDataItem(this.maxMiddleIndex).getPeriod().getStart().getTime(); [EOL]         long e = getDataItem(this.maxMiddleIndex).getPeriod().getEnd().getTime(); [EOL]         long maxMiddle = s + (e - s) / 2; [EOL]         if (middle > maxMiddle) { [EOL]             this.maxMiddleIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.maxMiddleIndex = index; [EOL]     } [EOL]     if (this.minEndIndex >= 0) { [EOL]         long minEnd = getDataItem(this.minEndIndex).getPeriod().getEnd().getTime(); [EOL]         if (end < minEnd) { [EOL]             this.minEndIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.minEndIndex = index; [EOL]     } [EOL]     if (this.maxEndIndex >= 0) { [EOL]         long maxEnd = getDataItem(this.maxEndIndex).getPeriod().getEnd().getTime(); [EOL]         if (end > maxEnd) { [EOL]             this.maxEndIndex = index; [EOL]         } [EOL]     } else { [EOL]         this.maxEndIndex = index; [EOL]     } [EOL] } <line_num>: 257,335
private void recalculateBounds() { [EOL]     this.minStartIndex = -1; [EOL]     this.minMiddleIndex = -1; [EOL]     this.minEndIndex = -1; [EOL]     this.maxStartIndex = -1; [EOL]     this.maxMiddleIndex = -1; [EOL]     this.maxEndIndex = -1; [EOL]     for (int i = 0; i < this.data.size(); i++) { [EOL]         TimePeriodValue tpv = (TimePeriodValue) this.data.get(i); [EOL]         updateBounds(tpv.getPeriod(), i); [EOL]     } [EOL] } <line_num>: 340,351
public void add(TimePeriod period, double value) { [EOL]     TimePeriodValue item = new TimePeriodValue(period, value); [EOL]     add(item); [EOL] } <line_num>: 362,365
public void add(TimePeriod period, Number value) { [EOL]     TimePeriodValue item = new TimePeriodValue(period, value); [EOL]     add(item); [EOL] } <line_num>: 374,377
public void update(int index, Number value) { [EOL]     TimePeriodValue item = getDataItem(index); [EOL]     item.setValue(value); [EOL]     fireSeriesChanged(); [EOL] } <line_num>: 386,390
public void delete(int start, int end) { [EOL]     for (int i = 0; i <= (end - start); i++) { [EOL]         this.data.remove(start); [EOL]     } [EOL]     recalculateBounds(); [EOL]     fireSeriesChanged(); [EOL] } <line_num>: 399,405
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TimePeriodValues)) { [EOL]         return false; [EOL]     } [EOL]     if (!super.equals(obj)) { [EOL]         return false; [EOL]     } [EOL]     TimePeriodValues that = (TimePeriodValues) obj; [EOL]     if (!ObjectUtilities.equal(this.getDomainDescription(), that.getDomainDescription())) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.getRangeDescription(), that.getRangeDescription())) { [EOL]         return false; [EOL]     } [EOL]     int count = getItemCount(); [EOL]     if (count != that.getItemCount()) { [EOL]         return false; [EOL]     } [EOL]     for (int i = 0; i < count; i++) { [EOL]         if (!getDataItem(i).equals(that.getDataItem(i))) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 414,443
public int hashCode() { [EOL]     int result; [EOL]     result = (this.domain != null ? this.domain.hashCode() : 0); [EOL]     result = 29 * result + (this.range != null ? this.range.hashCode() : 0); [EOL]     result = 29 * result + this.data.hashCode(); [EOL]     result = 29 * result + this.minStartIndex; [EOL]     result = 29 * result + this.maxStartIndex; [EOL]     result = 29 * result + this.minMiddleIndex; [EOL]     result = 29 * result + this.maxMiddleIndex; [EOL]     result = 29 * result + this.minEndIndex; [EOL]     result = 29 * result + this.maxEndIndex; [EOL]     return result; [EOL] } <line_num>: 450,462
public Object clone() throws CloneNotSupportedException { [EOL]     Object clone = createCopy(0, getItemCount() - 1); [EOL]     return clone; [EOL] } <line_num>: 479,482
public TimePeriodValues createCopy(int start, int end) throws CloneNotSupportedException { [EOL]     TimePeriodValues copy = (TimePeriodValues) super.clone(); [EOL]     copy.data = new ArrayList(); [EOL]     if (this.data.size() > 0) { [EOL]         for (int index = start; index <= end; index++) { [EOL]             TimePeriodValue item = (TimePeriodValue) this.data.get(index); [EOL]             TimePeriodValue clone = (TimePeriodValue) item.clone(); [EOL]             try { [EOL]                 copy.add(clone); [EOL]             } catch (SeriesException e) { [EOL]                 System.err.println("Failed to add cloned item."); [EOL]             } [EOL]         } [EOL]     } [EOL]     return copy; [EOL] } <line_num>: 495,515
public int getMinStartIndex() { [EOL]     return this.minStartIndex; [EOL] } <line_num>: 522,524
public int getMaxStartIndex() { [EOL]     return this.maxStartIndex; [EOL] } <line_num>: 531,533
public int getMinMiddleIndex() { [EOL]     return this.minMiddleIndex; [EOL] } <line_num>: 541,543
public int getMaxMiddleIndex() { [EOL]     return this.maxMiddleIndex; [EOL] } <line_num>: 551,553
public int getMinEndIndex() { [EOL]     return this.minEndIndex; [EOL] } <line_num>: 560,562
public int getMaxEndIndex() { [EOL]     return this.maxEndIndex; [EOL] } <line_num>: 569,571