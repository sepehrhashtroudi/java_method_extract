public TimeSeries(Comparable name)
public TimeSeries(Comparable name, String domain, String range)
public String getDomainDescription()
public void setDomainDescription(String description)
public String getRangeDescription()
public void setRangeDescription(String description)
public int getItemCount()
public List getItems()
public int getMaximumItemCount()
public void setMaximumItemCount(int maximum)
public long getMaximumItemAge()
public void setMaximumItemAge(long periods)
public double getMinY()
public double getMaxY()
public Class getTimePeriodClass()
public TimeSeriesDataItem getDataItem(int index)
public TimeSeriesDataItem getDataItem(RegularTimePeriod period)
 TimeSeriesDataItem getRawDataItem(int index)
 TimeSeriesDataItem getRawDataItem(RegularTimePeriod period)
public RegularTimePeriod getTimePeriod(int index)
public RegularTimePeriod getNextTimePeriod()
public Collection getTimePeriods()
public Collection getTimePeriodsUniqueToOtherSeries(TimeSeries series)
public int getIndex(RegularTimePeriod period)
public Number getValue(int index)
public Number getValue(RegularTimePeriod period)
public void add(TimeSeriesDataItem item)
public void add(TimeSeriesDataItem item, boolean notify)
public void add(RegularTimePeriod period, double value)
public void add(RegularTimePeriod period, double value, boolean notify)
public void add(RegularTimePeriod period, Number value)
public void add(RegularTimePeriod period, Number value, boolean notify)
public void update(RegularTimePeriod period, Number value)
public void update(int index, Number value)
public TimeSeries addAndOrUpdate(TimeSeries series)
public TimeSeriesDataItem addOrUpdate(RegularTimePeriod period, double value)
public TimeSeriesDataItem addOrUpdate(RegularTimePeriod period, Number value)
public TimeSeriesDataItem addOrUpdate(TimeSeriesDataItem item)
public void removeAgedItems(boolean notify)
public void removeAgedItems(long latest, boolean notify)
public void clear()
public void delete(RegularTimePeriod period)
public void delete(int start, int end)
public void delete(int start, int end, boolean notify)
public Object clone() throws CloneNotSupportedException
public TimeSeries createCopy(int start, int end) throws CloneNotSupportedException
public TimeSeries createCopy(RegularTimePeriod start, RegularTimePeriod end) throws CloneNotSupportedException
public boolean equals(Object obj)
public int hashCode()
private void updateBoundsForAddedItem(TimeSeriesDataItem item)
private void updateBoundsForRemovedItem(TimeSeriesDataItem item)
private void findBoundsByIteration()
private double minIgnoreNaN(double a, double b)
private double maxIgnoreNaN(double a, double b)
long serialVersionUID=Optional[-5032960206869675528L]
String DEFAULT_DOMAIN_DESCRIPTION=Optional["Time"]
String DEFAULT_RANGE_DESCRIPTION=Optional["Value"]
String domain
String range
Class timePeriodClass
List data
int maximumItemCount
long maximumItemAge
double minY
double maxY
