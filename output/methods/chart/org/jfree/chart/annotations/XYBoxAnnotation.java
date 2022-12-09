public XYBoxAnnotation(double x0, double y0, double x1, double y1) { [EOL]     this(x0, y0, x1, y1, new BasicStroke(1.0f), Color.black); [EOL] } <line_num>: 107,109
public XYBoxAnnotation(double x0, double y0, double x1, double y1, Stroke stroke, Paint outlinePaint) { [EOL]     this(x0, y0, x1, y1, stroke, outlinePaint, null); [EOL] } <line_num>: 122,125
public XYBoxAnnotation(double x0, double y0, double x1, double y1, Stroke stroke, Paint outlinePaint, Paint fillPaint) { [EOL]     super(); [EOL]     this.x0 = x0; [EOL]     this.y0 = y0; [EOL]     this.x1 = x1; [EOL]     this.y1 = y1; [EOL]     this.stroke = stroke; [EOL]     this.outlinePaint = outlinePaint; [EOL]     this.fillPaint = fillPaint; [EOL] } <line_num>: 139,149
public void draw(Graphics2D g2, XYPlot plot, Rectangle2D dataArea, ValueAxis domainAxis, ValueAxis rangeAxis, int rendererIndex, PlotRenderingInfo info) { [EOL]     PlotOrientation orientation = plot.getOrientation(); [EOL]     RectangleEdge domainEdge = Plot.resolveDomainAxisLocation(plot.getDomainAxisLocation(), orientation); [EOL]     RectangleEdge rangeEdge = Plot.resolveRangeAxisLocation(plot.getRangeAxisLocation(), orientation); [EOL]     double transX0 = domainAxis.valueToJava2D(this.x0, dataArea, domainEdge); [EOL]     double transY0 = rangeAxis.valueToJava2D(this.y0, dataArea, rangeEdge); [EOL]     double transX1 = domainAxis.valueToJava2D(this.x1, dataArea, domainEdge); [EOL]     double transY1 = rangeAxis.valueToJava2D(this.y1, dataArea, rangeEdge); [EOL]     Rectangle2D box = null; [EOL]     if (orientation == PlotOrientation.HORIZONTAL) { [EOL]         box = new Rectangle2D.Double(transY0, transX1, transY1 - transY0, transX0 - transX1); [EOL]     } else if (orientation == PlotOrientation.VERTICAL) { [EOL]         box = new Rectangle2D.Double(transX0, transY1, transX1 - transX0, transY0 - transY1); [EOL]     } [EOL]     if (this.fillPaint != null) { [EOL]         g2.setPaint(this.fillPaint); [EOL]         g2.fill(box); [EOL]     } [EOL]     if (this.stroke != null && this.outlinePaint != null) { [EOL]         g2.setPaint(this.outlinePaint); [EOL]         g2.setStroke(this.stroke); [EOL]         g2.draw(box); [EOL]     } [EOL]     addEntity(info, box, rendererIndex, getToolTipText(), getURL()); [EOL] } <line_num>: 163,202
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!super.equals(obj)) { [EOL]         return false; [EOL]     } [EOL]     if (!(obj instanceof XYBoxAnnotation)) { [EOL]         return false; [EOL]     } [EOL]     XYBoxAnnotation that = (XYBoxAnnotation) obj; [EOL]     if (!(this.x0 == that.x0)) { [EOL]         return false; [EOL]     } [EOL]     if (!(this.y0 == that.y0)) { [EOL]         return false; [EOL]     } [EOL]     if (!(this.x1 == that.x1)) { [EOL]         return false; [EOL]     } [EOL]     if (!(this.y1 == that.y1)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.stroke, that.stroke)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.outlinePaint, that.outlinePaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.fillPaint, that.fillPaint)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 211,246
public int hashCode() { [EOL]     int result; [EOL]     long temp; [EOL]     temp = Double.doubleToLongBits(this.x0); [EOL]     result = (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.x1); [EOL]     result = 29 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.y0); [EOL]     result = 29 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = Double.doubleToLongBits(this.y1); [EOL]     result = 29 * result + (int) (temp ^ (temp >>> 32)); [EOL]     return result; [EOL] } <line_num>: 253,265
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 275,277
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writeStroke(this.stroke, stream); [EOL]     SerialUtilities.writePaint(this.outlinePaint, stream); [EOL]     SerialUtilities.writePaint(this.fillPaint, stream); [EOL] } <line_num>: 286,291
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.stroke = SerialUtilities.readStroke(stream); [EOL]     this.outlinePaint = SerialUtilities.readPaint(stream); [EOL]     this.fillPaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 301,308
