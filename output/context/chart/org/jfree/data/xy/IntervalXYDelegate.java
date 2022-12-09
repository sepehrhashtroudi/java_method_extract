public IntervalXYDelegate(XYDataset dataset)
public IntervalXYDelegate(XYDataset dataset, boolean autoWidth)
public boolean isAutoWidth()
public void setAutoWidth(boolean b)
public double getIntervalPositionFactor()
public void setIntervalPositionFactor(double d)
public double getFixedIntervalWidth()
public void setFixedIntervalWidth(double w)
public double getIntervalWidth()
public Number getStartX(int series, int item)
public double getStartXValue(int series, int item)
public Number getEndX(int series, int item)
public double getEndXValue(int series, int item)
public double getDomainLowerBound(boolean includeInterval)
public double getDomainUpperBound(boolean includeInterval)
public Range getDomainBounds(boolean includeInterval)
public void datasetChanged(DatasetChangeEvent e)
private double recalculateInterval()
private double calculateIntervalForSeries(int series)
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
public int hashCode()
long serialVersionUID=Optional[-685166711639592857L]
XYDataset dataset
boolean autoWidth
double intervalPositionFactor
double fixedIntervalWidth
double autoIntervalWidth
