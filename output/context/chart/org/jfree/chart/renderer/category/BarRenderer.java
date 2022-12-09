public BarRenderer()
public static BarPainter getDefaultBarPainter()
public static void setDefaultBarPainter(BarPainter painter)
public static boolean getDefaultShadowsVisible()
public static void setDefaultShadowsVisible(boolean visible)
public double getBase()
public void setBase(double base)
public double getItemMargin()
public void setItemMargin(double percent)
public boolean isDrawBarOutline()
public void setDrawBarOutline(boolean draw)
public double getMaximumBarWidth()
public void setMaximumBarWidth(double percent)
public double getMinimumBarLength()
public void setMinimumBarLength(double min)
public GradientPaintTransformer getGradientPaintTransformer()
public void setGradientPaintTransformer(GradientPaintTransformer transformer)
public ItemLabelPosition getPositiveItemLabelPositionFallback()
public void setPositiveItemLabelPositionFallback(ItemLabelPosition position)
public ItemLabelPosition getNegativeItemLabelPositionFallback()
public void setNegativeItemLabelPositionFallback(ItemLabelPosition position)
public boolean getIncludeBaseInRange()
public void setIncludeBaseInRange(boolean include)
public BarPainter getBarPainter()
public void setBarPainter(BarPainter painter)
public boolean getShadowsVisible()
public void setShadowVisible(boolean visible)
public Paint getShadowPaint()
public void setShadowPaint(Paint paint)
public double getShadowXOffset()
public void setShadowXOffset(double offset)
public double getShadowYOffset()
public void setShadowYOffset(double offset)
public CategoryItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, CategoryPlot plot, CategoryDataset dataset, PlotRenderingInfo info)
protected void calculateBarWidth(CategoryPlot plot, Rectangle2D dataArea, CategoryDataset dataset, CategoryItemRendererState state)
protected double calculateBarW0(CategoryPlot plot, PlotOrientation orientation, Rectangle2D dataArea, CategoryAxis domainAxis, CategoryItemRendererState state, int row, int column)
protected double[] calculateBarL0L1(double value, double min, double max)
public Range findRangeBounds(CategoryDataset dataset, boolean includeInterval)
public LegendItem getLegendItem(int datasetIndex, int series)
public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row, int column, boolean selected, int pass)
protected double calculateSeriesWidth(double space, CategoryAxis axis, int categories, int series)
protected void drawItemLabelForBar(Graphics2D g2, CategoryPlot plot, CategoryDataset dataset, int row, int column, boolean selected, CategoryItemLabelGenerator generator, Rectangle2D bar, boolean negative)
private Point2D calculateLabelAnchorPoint(ItemLabelAnchor anchor, Rectangle2D bar, PlotOrientation orientation)
private boolean isInternalAnchor(ItemLabelAnchor anchor)
public boolean equals(Object obj)
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
public Rectangle2D createHotSpotBounds(Graphics2D g2, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row, int column, boolean selected, CategoryItemRendererState state, Rectangle2D result)
long serialVersionUID=Optional[6000649414965887481L]
double DEFAULT_ITEM_MARGIN=Optional[0.20]
double BAR_OUTLINE_WIDTH_THRESHOLD=Optional[3.0]
BarPainter defaultBarPainter=Optional[new GradientBarPainter()]
boolean defaultShadowsVisible=Optional[true]
double itemMargin
boolean drawBarOutline
double maximumBarWidth
double minimumBarLength
GradientPaintTransformer gradientPaintTransformer
ItemLabelPosition positiveItemLabelPositionFallback
ItemLabelPosition negativeItemLabelPositionFallback
double base
boolean includeBaseInRange
BarPainter barPainter
boolean shadowsVisible
Paint shadowPaint
double shadowXOffset
double shadowYOffset