public ScatterRenderer()
public boolean getUseSeriesOffset()
public void setUseSeriesOffset(boolean offset)
public double getItemMargin()
public void setItemMargin(double margin)
public boolean getDrawOutlines()
public void setDrawOutlines(boolean flag)
public boolean getUseOutlinePaint()
public void setUseOutlinePaint(boolean use)
public boolean getItemShapeFilled(int series, int item)
public boolean getSeriesShapesFilled(int series)
public void setSeriesShapesFilled(int series, Boolean filled)
public void setSeriesShapesFilled(int series, boolean filled)
public boolean getBaseShapesFilled()
public void setBaseShapesFilled(boolean flag)
public boolean getUseFillPaint()
public void setUseFillPaint(boolean flag)
public Range findRangeBounds(CategoryDataset dataset)
public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row, int column, boolean selected, int pass)
public LegendItem getLegendItem(int datasetIndex, int series)
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
BooleanList seriesShapesFilled
boolean baseShapesFilled
boolean useFillPaint
boolean drawOutlines
boolean useOutlinePaint
boolean useSeriesOffset
double itemMargin
