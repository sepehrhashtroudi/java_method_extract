public DefaultPieDataset() { [EOL]     this.data = new KeyedObjects(); [EOL]     setSelectionState(this); [EOL] } <line_num>: 90,93
public DefaultPieDataset(KeyedValues data) { [EOL]     if (data == null) { [EOL]         throw new IllegalArgumentException("Null 'data' argument."); [EOL]     } [EOL]     this.data = new KeyedObjects(); [EOL]     for (int i = 0; i < data.getItemCount(); i++) { [EOL]         SelectableValue dataItem = new SelectableValue(data.getValue(i)); [EOL]         this.data.addObject(data.getKey(i), dataItem); [EOL]     } [EOL] } <line_num>: 101,110
public int getItemCount() { [EOL]     return this.data.getItemCount(); [EOL] } <line_num>: 117,119
public List getKeys() { [EOL]     return Collections.unmodifiableList(this.data.getKeys()); [EOL] } <line_num>: 127,130
public Comparable getKey(int item) { [EOL]     return this.data.getKey(item); [EOL] } <line_num>: 143,145
public int getIndex(Comparable key) { [EOL]     return this.data.getIndex(key); [EOL] } <line_num>: 157,159
public Number getValue(int item) { [EOL]     Number result = null; [EOL]     if (getItemCount() > item) { [EOL]         SelectableValue dataItem = (SelectableValue) this.data.getObject(item); [EOL]         result = dataItem.getValue(); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 168,175
public Number getValue(Comparable key) { [EOL]     if (key == null) { [EOL]         throw new IllegalArgumentException("Null 'key' argument."); [EOL]     } [EOL]     SelectableValue dataItem = (SelectableValue) this.data.getObject(key); [EOL]     return dataItem.getValue(); [EOL] } <line_num>: 186,192
public void setValue(Comparable key, Number value) { [EOL]     int index = this.data.getIndex(key); [EOL]     PieDatasetChangeType ct = PieDatasetChangeType.ADD; [EOL]     if (index >= 0) { [EOL]         ct = PieDatasetChangeType.UPDATE; [EOL]     } [EOL]     this.data.setObject(key, new SelectableValue(value)); [EOL]     PieDatasetChangeInfo info = new PieDatasetChangeInfo(ct, index, index); [EOL]     fireDatasetChanged(info); [EOL] } <line_num>: 204,214
public void setValue(Comparable key, double value) { [EOL]     setValue(key, new Double(value)); [EOL] } <line_num>: 226,228
public void insertValue(int position, Comparable key, double value) { [EOL]     insertValue(position, key, new Double(value)); [EOL] } <line_num>: 243,245
public void insertValue(int position, Comparable key, Number value) { [EOL]     this.data.insertValue(position, key, value); [EOL]     PieDatasetChangeType ct = PieDatasetChangeType.ADD; [EOL]     fireDatasetChanged(new PieDatasetChangeInfo(ct, position, position)); [EOL] } <line_num>: 260,265
public void remove(Comparable key) { [EOL]     int i = getIndex(key); [EOL]     this.data.removeValue(key); [EOL]     PieDatasetChangeType ct = PieDatasetChangeType.REMOVE; [EOL]     fireDatasetChanged(new PieDatasetChangeInfo(ct, i, i)); [EOL] } <line_num>: 276,281
public void clear() { [EOL]     if (getItemCount() > 0) { [EOL]         this.data.clear(); [EOL]         PieDatasetChangeType ct = PieDatasetChangeType.CLEAR; [EOL]         fireDatasetChanged(new PieDatasetChangeInfo(ct, -1, -1)); [EOL]     } [EOL] } <line_num>: 289,295
public void sortByKeys(SortOrder order) { [EOL]     this.data.sortByKeys(order); [EOL]     PieDatasetChangeType ct = PieDatasetChangeType.UPDATE; [EOL]     fireDatasetChanged(new PieDatasetChangeInfo(ct, 0, getItemCount() - 1)); [EOL] } <line_num>: 305,310
public void sortByValues(SortOrder order) { [EOL]     this.data.sortByObjects(order); [EOL]     PieDatasetChangeType ct = PieDatasetChangeType.UPDATE; [EOL]     fireDatasetChanged(new PieDatasetChangeInfo(ct, 0, getItemCount() - 1)); [EOL] } <line_num>: 320,325
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof PieDataset)) { [EOL]         return false; [EOL]     } [EOL]     PieDataset that = (PieDataset) obj; [EOL]     int count = getItemCount(); [EOL]     if (that.getItemCount() != count) { [EOL]         return false; [EOL]     } [EOL]     for (int i = 0; i < count; i++) { [EOL]         Comparable k1 = getKey(i); [EOL]         Comparable k2 = that.getKey(i); [EOL]         if (!k1.equals(k2)) { [EOL]             return false; [EOL]         } [EOL]         Number v1 = getValue(i); [EOL]         Number v2 = that.getValue(i); [EOL]         if (v1 == null) { [EOL]             if (v2 != null) { [EOL]                 return false; [EOL]             } [EOL]         } else { [EOL]             if (!v1.equals(v2)) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 334,370
public int hashCode() { [EOL]     return this.data.hashCode(); [EOL] } <line_num>: 377,379
public Object clone() throws CloneNotSupportedException { [EOL]     DefaultPieDataset clone = (DefaultPieDataset) super.clone(); [EOL]     clone.data = (KeyedObjects) this.data.clone(); [EOL]     return clone; [EOL] } <line_num>: 389,393
public boolean isSelected(Comparable key) { [EOL]     SelectableValue item = (SelectableValue) this.data.getObject(key); [EOL]     return item.isSelected(); [EOL] } <line_num>: 395,398
public void setSelected(Comparable key, boolean selected) { [EOL]     setSelected(key, selected, true); [EOL] } <line_num>: 400,402
public void setSelected(Comparable key, boolean selected, boolean notify) { [EOL]     SelectableValue item = (SelectableValue) this.data.getObject(key); [EOL]     item.setSelected(selected); [EOL]     if (notify) { [EOL]         fireSelectionEvent(); [EOL]     } [EOL] } <line_num>: 404,410
public void clearSelection() { [EOL]     int itemCount = getItemCount(); [EOL]     for (int i = 0; i < itemCount; i++) { [EOL]         SelectableValue item = (SelectableValue) this.data.getObject(i); [EOL]         item.setSelected(false); [EOL]     } [EOL]     fireSelectionEvent(); [EOL] } <line_num>: 412,419
public void fireSelectionEvent() { [EOL]     this.fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 421,423
