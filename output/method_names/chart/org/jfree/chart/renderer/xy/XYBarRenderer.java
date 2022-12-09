public XYBarRendererState(PlotRenderingInfo info)
public XYBarRenderer()
public XYBarRenderer(double margin)
public static XYBarPainter getDefaultBarPainter()
public static void setDefaultBarPainter(XYBarPainter painter)
public static boolean getDefaultShadowsVisible()
public static void setDefaultShadowsVisible(boolean visible)
public double getG2Base()
public void setG2Base(double value)
public double getBase()
public void setBase(double base)
public boolean getUseYInterval()
public void setUseYInterval(boolean use)
public double getMargin()
public void setMargin(double margin)
public boolean isDrawBarOutline()
public void setDrawBarOutline(boolean draw)
public GradientPaintTransformer getGradientPaintTransformer()
public void setGradientPaintTransformer(GradientPaintTransformer transformer)
public Shape getLegendBar()
public void setLegendBar(Shape bar)
public ItemLabelPosition getPositiveItemLabelPositionFallback()
public void setPositiveItemLabelPositionFallback(ItemLabelPosition position)
public ItemLabelPosition getNegativeItemLabelPositionFallback()
public void setNegativeItemLabelPositionFallback(ItemLabelPosition position)
public XYBarPainter getBarPainter()
public void setBarPainter(XYBarPainter painter)
public boolean getShadowsVisible()
public void setShadowVisible(boolean visible)
public double getShadowXOffset()
public void setShadowXOffset(double offset)
public double getShadowYOffset()
public void setShadowYOffset(double offset)
public double getBarAlignmentFactor()
public void setBarAlignmentFactor(double factor)
protected XYItemRendererState createState(PlotRenderingInfo info)
public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset dataset, PlotRenderingInfo info)
public LegendItem getLegendItem(int datasetIndex, int series)
protected Rectangle2D createBar(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected)
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass)
protected void drawItemLabelForBar(Graphics2D g2, XYPlot plot, XYDataset dataset, int series, int item, boolean selected, XYItemLabelGenerator generator, Rectangle2D bar, boolean negative)
private Point2D calculateLabelAnchorPoint(ItemLabelAnchor anchor, Rectangle2D bar, PlotOrientation orientation)
private boolean isInternalAnchor(ItemLabelAnchor anchor)
public Rectangle2D createHotSpotBounds(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, Rectangle2D result)
public Range findDomainBounds(XYDataset dataset)
public Range findRangeBounds(XYDataset dataset)
public Object clone() throws CloneNotSupportedException
public boolean equals(Object obj)
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
private void writeObject(ObjectOutputStream stream) throws IOException
