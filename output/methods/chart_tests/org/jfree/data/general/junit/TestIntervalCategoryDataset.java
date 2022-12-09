public TestIntervalCategoryDataset() { [EOL]     this.data = new KeyedObjects2D(); [EOL] } <line_num>: 68,70
public int getRowCount() { [EOL]     return this.data.getRowCount(); [EOL] } <line_num>: 79,81
public int getColumnCount() { [EOL]     return this.data.getColumnCount(); [EOL] } <line_num>: 90,92
public Number getValue(int row, int column) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(row, column); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getValue(); [EOL] } <line_num>: 105,112
public Comparable getRowKey(int row) { [EOL]     return this.data.getRowKey(row); [EOL] } <line_num>: 125,127
public int getRowIndex(Comparable key) { [EOL]     return this.data.getRowIndex(key); [EOL] } <line_num>: 138,141
public List getRowKeys() { [EOL]     return this.data.getRowKeys(); [EOL] } <line_num>: 150,152
public Comparable getColumnKey(int column) { [EOL]     return this.data.getColumnKey(column); [EOL] } <line_num>: 163,165
public int getColumnIndex(Comparable key) { [EOL]     return this.data.getColumnIndex(key); [EOL] } <line_num>: 176,179
public List getColumnKeys() { [EOL]     return this.data.getColumnKeys(); [EOL] } <line_num>: 188,190
public Number getValue(Comparable rowKey, Comparable columnKey) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(rowKey, columnKey); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getValue(); [EOL] } <line_num>: 204,211
public void addItem(Number value, Number lower, Number upper, Comparable rowKey, Comparable columnKey) { [EOL]     IntervalDataItem item = new IntervalDataItem(value, lower, upper); [EOL]     this.data.addObject(item, rowKey, columnKey); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 223,228
public void addItem(double value, double lower, double upper, Comparable rowKey, Comparable columnKey) { [EOL]     addItem(new Double(value), new Double(lower), new Double(upper), rowKey, columnKey); [EOL] } <line_num>: 239,243
public void setItem(Number value, Number lower, Number upper, Comparable rowKey, Comparable columnKey) { [EOL]     IntervalDataItem item = new IntervalDataItem(value, lower, upper); [EOL]     this.data.addObject(item, rowKey, columnKey); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 255,260
public void setItem(double value, double lower, double upper, Comparable rowKey, Comparable columnKey) { [EOL]     setItem(new Double(value), new Double(lower), new Double(upper), rowKey, columnKey); [EOL] } <line_num>: 272,276
public void removeItem(Comparable rowKey, Comparable columnKey) { [EOL]     this.data.removeObject(rowKey, columnKey); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 287,290
public void removeRow(int rowIndex) { [EOL]     this.data.removeRow(rowIndex); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 300,303
public void removeRow(Comparable rowKey) { [EOL]     this.data.removeRow(rowKey); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 313,316
public void removeColumn(int columnIndex) { [EOL]     this.data.removeColumn(columnIndex); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 326,329
public void removeColumn(Comparable columnKey) { [EOL]     this.data.removeColumn(columnKey); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 342,345
public void clear() { [EOL]     this.data.clear(); [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 351,354
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TestIntervalCategoryDataset)) { [EOL]         return false; [EOL]     } [EOL]     TestIntervalCategoryDataset that = (TestIntervalCategoryDataset) obj; [EOL]     if (!getRowKeys().equals(that.getRowKeys())) { [EOL]         return false; [EOL]     } [EOL]     if (!getColumnKeys().equals(that.getColumnKeys())) { [EOL]         return false; [EOL]     } [EOL]     int rowCount = getRowCount(); [EOL]     int colCount = getColumnCount(); [EOL]     for (int r = 0; r < rowCount; r++) { [EOL]         for (int c = 0; c < colCount; c++) { [EOL]             Number v1 = getValue(r, c); [EOL]             Number v2 = that.getValue(r, c); [EOL]             if (v1 == null) { [EOL]                 if (v2 != null) { [EOL]                     return false; [EOL]                 } [EOL]             } else if (!v1.equals(v2)) { [EOL]                 return false; [EOL]             } [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 363,394
public int hashCode() { [EOL]     return this.data.hashCode(); [EOL] } <line_num>: 401,403
public Object clone() throws CloneNotSupportedException { [EOL]     TestIntervalCategoryDataset clone = (TestIntervalCategoryDataset) super.clone(); [EOL]     clone.data = (KeyedObjects2D) this.data.clone(); [EOL]     return clone; [EOL] } <line_num>: 413,418
public Number getStartValue(int series, int category) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(series, category); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getLowerBound(); [EOL] } <line_num>: 420,427
public Number getStartValue(Comparable series, Comparable category) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(series, category); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getLowerBound(); [EOL] } <line_num>: 429,436
public Number getEndValue(int series, int category) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(series, category); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getUpperBound(); [EOL] } <line_num>: 438,445
public Number getEndValue(Comparable series, Comparable category) { [EOL]     IntervalDataItem item = (IntervalDataItem) this.data.getObject(series, category); [EOL]     if (item == null) { [EOL]         return null; [EOL]     } [EOL]     return item.getUpperBound(); [EOL] } <line_num>: 447,454