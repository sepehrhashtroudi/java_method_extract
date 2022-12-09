public DefaultIntervalXYDataset() { [EOL]     this.seriesKeys = new java.util.ArrayList(); [EOL]     this.seriesList = new java.util.ArrayList(); [EOL] } <line_num>: 86,89
public int getSeriesCount() { [EOL]     return this.seriesList.size(); [EOL] } <line_num>: 96,98
public Comparable getSeriesKey(int series) { [EOL]     if ((series < 0) || (series >= getSeriesCount())) { [EOL]         throw new IllegalArgumentException("Series index out of bounds"); [EOL]     } [EOL]     return (Comparable) this.seriesKeys.get(series); [EOL] } <line_num>: 111,116
public int getItemCount(int series) { [EOL]     if ((series < 0) || (series >= getSeriesCount())) { [EOL]         throw new IllegalArgumentException("Series index out of bounds"); [EOL]     } [EOL]     double[][] seriesArray = (double[][]) this.seriesList.get(series); [EOL]     return seriesArray[0].length; [EOL] } <line_num>: 129,135
public double getXValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[0][item]; [EOL] } <line_num>: 154,157
public double getYValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[3][item]; [EOL] } <line_num>: 176,179
public double getStartXValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[1][item]; [EOL] } <line_num>: 198,201
public double getEndXValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[2][item]; [EOL] } <line_num>: 220,223
public double getStartYValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[4][item]; [EOL] } <line_num>: 242,245
public double getEndYValue(int series, int item) { [EOL]     double[][] seriesData = (double[][]) this.seriesList.get(series); [EOL]     return seriesData[5][item]; [EOL] } <line_num>: 264,267
public Number getEndX(int series, int item) { [EOL]     return new Double(getEndXValue(series, item)); [EOL] } <line_num>: 286,288
public Number getEndY(int series, int item) { [EOL]     return new Double(getEndYValue(series, item)); [EOL] } <line_num>: 307,309
public Number getStartX(int series, int item) { [EOL]     return new Double(getStartXValue(series, item)); [EOL] } <line_num>: 328,330
public Number getStartY(int series, int item) { [EOL]     return new Double(getStartYValue(series, item)); [EOL] } <line_num>: 349,351
public Number getX(int series, int item) { [EOL]     return new Double(getXValue(series, item)); [EOL] } <line_num>: 370,372
public Number getY(int series, int item) { [EOL]     return new Double(getYValue(series, item)); [EOL] } <line_num>: 391,393
public void addSeries(Comparable seriesKey, double[][] data) { [EOL]     if (seriesKey == null) { [EOL]         throw new IllegalArgumentException("The 'seriesKey' cannot be null."); [EOL]     } [EOL]     if (data == null) { [EOL]         throw new IllegalArgumentException("The 'data' is null."); [EOL]     } [EOL]     if (data.length != 6) { [EOL]         throw new IllegalArgumentException("The 'data' array must have length == 6."); [EOL]     } [EOL]     int length = data[0].length; [EOL]     if (length != data[1].length || length != data[2].length || length != data[3].length || length != data[4].length || length != data[5].length) { [EOL]         throw new IllegalArgumentException("The 'data' array must contain six arrays with equal length."); [EOL]     } [EOL]     int seriesIndex = indexOf(seriesKey); [EOL]     if (seriesIndex == -1) { [EOL]         this.seriesKeys.add(seriesKey); [EOL]         this.seriesList.add(data); [EOL]     } else { [EOL]         this.seriesList.remove(seriesIndex); [EOL]         this.seriesList.add(seriesIndex, data); [EOL]     } [EOL]     fireDatasetChanged(new DatasetChangeInfo()); [EOL] } <line_num>: 406,436
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof DefaultIntervalXYDataset)) { [EOL]         return false; [EOL]     } [EOL]     DefaultIntervalXYDataset that = (DefaultIntervalXYDataset) obj; [EOL]     if (!this.seriesKeys.equals(that.seriesKeys)) { [EOL]         return false; [EOL]     } [EOL]     for (int i = 0; i < this.seriesList.size(); i++) { [EOL]         double[][] d1 = (double[][]) this.seriesList.get(i); [EOL]         double[][] d2 = (double[][]) that.seriesList.get(i); [EOL]         double[] d1x = d1[0]; [EOL]         double[] d2x = d2[0]; [EOL]         if (!Arrays.equals(d1x, d2x)) { [EOL]             return false; [EOL]         } [EOL]         double[] d1xs = d1[1]; [EOL]         double[] d2xs = d2[1]; [EOL]         if (!Arrays.equals(d1xs, d2xs)) { [EOL]             return false; [EOL]         } [EOL]         double[] d1xe = d1[2]; [EOL]         double[] d2xe = d2[2]; [EOL]         if (!Arrays.equals(d1xe, d2xe)) { [EOL]             return false; [EOL]         } [EOL]         double[] d1y = d1[3]; [EOL]         double[] d2y = d2[3]; [EOL]         if (!Arrays.equals(d1y, d2y)) { [EOL]             return false; [EOL]         } [EOL]         double[] d1ys = d1[4]; [EOL]         double[] d2ys = d2[4]; [EOL]         if (!Arrays.equals(d1ys, d2ys)) { [EOL]             return false; [EOL]         } [EOL]         double[] d1ye = d1[5]; [EOL]         double[] d2ye = d2[5]; [EOL]         if (!Arrays.equals(d1ye, d2ye)) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 454,500
public int hashCode() { [EOL]     int result; [EOL]     result = this.seriesKeys.hashCode(); [EOL]     result = 29 * result + this.seriesList.hashCode(); [EOL]     return result; [EOL] } <line_num>: 507,512
public Object clone() throws CloneNotSupportedException { [EOL]     DefaultIntervalXYDataset clone = (DefaultIntervalXYDataset) super.clone(); [EOL]     clone.seriesKeys = new java.util.ArrayList(this.seriesKeys); [EOL]     clone.seriesList = new ArrayList(this.seriesList.size()); [EOL]     for (int i = 0; i < this.seriesList.size(); i++) { [EOL]         double[][] data = (double[][]) this.seriesList.get(i); [EOL]         double[] x = data[0]; [EOL]         double[] xStart = data[1]; [EOL]         double[] xEnd = data[2]; [EOL]         double[] y = data[3]; [EOL]         double[] yStart = data[4]; [EOL]         double[] yEnd = data[5]; [EOL]         double[] xx = new double[x.length]; [EOL]         double[] xxStart = new double[xStart.length]; [EOL]         double[] xxEnd = new double[xEnd.length]; [EOL]         double[] yy = new double[y.length]; [EOL]         double[] yyStart = new double[yStart.length]; [EOL]         double[] yyEnd = new double[yEnd.length]; [EOL]         System.arraycopy(x, 0, xx, 0, x.length); [EOL]         System.arraycopy(xStart, 0, xxStart, 0, xStart.length); [EOL]         System.arraycopy(xEnd, 0, xxEnd, 0, xEnd.length); [EOL]         System.arraycopy(y, 0, yy, 0, y.length); [EOL]         System.arraycopy(yStart, 0, yyStart, 0, yStart.length); [EOL]         System.arraycopy(yEnd, 0, yyEnd, 0, yEnd.length); [EOL]         clone.seriesList.add(i, new double[][] { xx, xxStart, xxEnd, yy, yyStart, yyEnd }); [EOL]     } [EOL]     return clone; [EOL] } <line_num>: 522,551
