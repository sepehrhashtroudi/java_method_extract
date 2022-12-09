public GanttRenderer()
public Paint getCompletePaint()
public void setCompletePaint(Paint paint)
public Paint getIncompletePaint()
public void setIncompletePaint(Paint paint)
public double getStartPercent()
public void setStartPercent(double percent)
public double getEndPercent()
public void setEndPercent(double percent)
public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row, int column, boolean selected, int pass)
protected void drawTasks(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, GanttCategoryDataset dataset, int row, int column, boolean selected)
protected void drawTask(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, GanttCategoryDataset dataset, int row, int column, boolean selected)
public double getItemMiddle(Comparable rowKey, Comparable columnKey, CategoryDataset dataset, CategoryAxis axis, Rectangle2D area, RectangleEdge edge)
public boolean equals(Object obj)
private void writeObject(ObjectOutputStream stream) throws IOException
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
long serialVersionUID=Optional[-4010349116350119512L]
Paint completePaint
Paint incompletePaint
double startPercent
double endPercent
