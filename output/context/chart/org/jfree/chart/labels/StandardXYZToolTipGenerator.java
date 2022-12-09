public StandardXYZToolTipGenerator()
public StandardXYZToolTipGenerator(String formatString, NumberFormat xFormat, NumberFormat yFormat, NumberFormat zFormat)
public StandardXYZToolTipGenerator(String formatString, DateFormat xFormat, DateFormat yFormat, DateFormat zFormat)
public NumberFormat getZFormat()
public DateFormat getZDateFormat()
public String generateToolTip(XYZDataset dataset, int series, int item)
public String generateLabelString(XYDataset dataset, int series, int item)
protected Object[] createItemArray(XYZDataset dataset, int series, int item)
public boolean equals(Object obj)
long serialVersionUID=Optional[-2961577421889473503L]
String DEFAULT_TOOL_TIP_FORMAT=Optional["{0}: ({1}, {2}, {3})"]
NumberFormat zFormat
DateFormat zDateFormat
