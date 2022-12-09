public LegendItem(String label)
public LegendItem(String label, Paint paint)
public LegendItem(String label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint)
public LegendItem(String label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint, Stroke outlineStroke, Paint outlinePaint)
public LegendItem(String label, String description, String toolTipText, String urlText, Shape line, Stroke lineStroke, Paint linePaint)
public LegendItem(String label, String description, String toolTipText, String urlText, boolean shapeVisible, Shape shape, boolean shapeFilled, Paint fillPaint, boolean shapeOutlineVisible, Paint outlinePaint, Stroke outlineStroke, boolean lineVisible, Shape line, Stroke lineStroke, Paint linePaint)
public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint)
public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape shape, Paint fillPaint, Stroke outlineStroke, Paint outlinePaint)
public LegendItem(AttributedString label, String description, String toolTipText, String urlText, Shape line, Stroke lineStroke, Paint linePaint)
public LegendItem(AttributedString label, String description, String toolTipText, String urlText, boolean shapeVisible, Shape shape, boolean shapeFilled, Paint fillPaint, boolean shapeOutlineVisible, Paint outlinePaint, Stroke outlineStroke, boolean lineVisible, Shape line, Stroke lineStroke, Paint linePaint)
private String characterIteratorToString(CharacterIterator iterator)
public Dataset getDataset()
public void setDataset(Dataset dataset)
public int getDatasetIndex()
public void setDatasetIndex(int index)
public Comparable getSeriesKey()
public void setSeriesKey(Comparable key)
public int getSeriesIndex()
public void setSeriesIndex(int index)
public String getLabel()
public Font getLabelFont()
public void setLabelFont(Font font)
public Paint getLabelPaint()
public void setLabelPaint(Paint paint)
public AttributedString getAttributedLabel()
public String getDescription()
public void setDescription(String text)
public String getToolTipText()
public void setToolTipText(String text)
public String getURLText()
public void setURLText(String text)
public boolean isShapeVisible()
public void setShapeVisible(boolean visible)
public Shape getShape()
public void setShape(Shape shape)
public boolean isShapeFilled()
public Paint getFillPaint()
public void setFillPaint(Paint paint)
public boolean isShapeOutlineVisible()
public Stroke getLineStroke()
public Paint getLinePaint()
public void setLinePaint(Paint paint)
public Paint getOutlinePaint()
public void setOutlinePaint(Paint paint)
public Stroke getOutlineStroke()
public void setOutlineStroke(Stroke stroke)
public boolean isLineVisible()
public void setLineVisible(boolean visible)
public Shape getLine()
public void setLine(Shape line)
public GradientPaintTransformer getFillPaintTransformer()
public void setFillPaintTransformer(GradientPaintTransformer transformer)
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
long serialVersionUID=Optional[-797214582948827144L]
Dataset dataset
Comparable seriesKey
int datasetIndex
int series
String label
Font labelFont
Paint labelPaint
AttributedString attributedLabel
String description
String toolTipText
String urlText
boolean shapeVisible
Shape shape
boolean shapeFilled
Paint fillPaint
GradientPaintTransformer fillPaintTransformer
boolean shapeOutlineVisible
Paint outlinePaint
Stroke outlineStroke
boolean lineVisible
Shape line
Stroke lineStroke
Paint linePaint
Shape UNUSED_SHAPE=Optional[new Line2D.Float()]
Stroke UNUSED_STROKE=Optional[new BasicStroke(0.0f)]