public XYStepAreaRenderer()
public XYStepAreaRenderer(int type)
public XYStepAreaRenderer(int type, XYToolTipGenerator toolTipGenerator, XYURLGenerator urlGenerator)
public boolean isOutline()
public void setOutline(boolean show)
public boolean getShapesVisible()
public void setShapesVisible(boolean flag)
public boolean isShapesFilled()
public void setShapesFilled(boolean filled)
public boolean getPlotArea()
public void setPlotArea(boolean flag)
public double getRangeBase()
public void setRangeBase(double val)
public XYItemRendererState initialise(Graphics2D g2, Rectangle2D dataArea, XYPlot plot, XYDataset data, PlotRenderingInfo info)
public void drawItem(Graphics2D g2, XYItemRendererState state, Rectangle2D dataArea, XYPlot plot, ValueAxis domainAxis, ValueAxis rangeAxis, XYDataset dataset, int series, int item, boolean selected, int pass)
public boolean equals(Object obj)
public Object clone() throws CloneNotSupportedException
protected static double restrictValueToDataArea(double value, XYPlot plot, Rectangle2D dataArea)
long serialVersionUID=Optional[-7311560779702649635L]
int SHAPES=Optional[1]
int AREA=Optional[2]
int AREA_AND_SHAPES=Optional[3]
boolean shapesVisible
boolean shapesFilled
boolean plotArea
boolean showOutline
Polygon pArea=Optional[null]
double rangeBase
