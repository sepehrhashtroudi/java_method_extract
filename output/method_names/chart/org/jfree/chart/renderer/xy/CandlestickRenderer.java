public CandlestickRenderer()
public CandlestickRenderer(double candleWidth)
public CandlestickRenderer(double candleWidth, boolean drawVolume, XYToolTipGenerator toolTipGenerator)
public double getCandleWidth()
public void setCandleWidth(double width)
public double getMaxCandleWidthInMilliseconds()
public void setMaxCandleWidthInMilliseconds(double millis)
public int getAutoWidthMethod()
public void setAutoWidthMethod(int autoWidthMethod)
public double getAutoWidthFactor()
public void setAutoWidthFactor(double autoWidthFactor)
public double getAutoWidthGap()
public void setAutoWidthGap(double autoWidthGap)
public Paint getUpPaint()
public void setUpPaint(Paint paint)
public Paint getDownPaint()
public void setDownPaint(Paint paint)
public boolean getDrawVolume()
public void setDrawVolume(boolean flag)
public Paint getVolumePaint()
public void setVolumePaint(Paint paint)
public boolean getUseOutlinePaint()
public void setUseOutlinePaint(boolean use)
public Range findRangeBounds(XYDataset dataset)
public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset dataset, PlotRenderingInfo info)
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass)
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
public Rectangle2D createHotSpotBounds(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, XYItemRendererState state, Rectangle2D result)