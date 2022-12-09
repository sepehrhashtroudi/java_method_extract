public TextBox() { [EOL]     this((TextBlock) null); [EOL] } <line_num>: 77,79
public TextBox(String text) { [EOL]     this((TextBlock) null); [EOL]     if (text != null) { [EOL]         this.textBlock = new TextBlock(); [EOL]         this.textBlock.addLine(text, new Font("Tahoma", Font.PLAIN, 10), Color.black); [EOL]     } [EOL] } <line_num>: 86,93
public TextBox(TextBlock block) { [EOL]     this.outlinePaint = Color.black; [EOL]     this.outlineStroke = new BasicStroke(1.0f); [EOL]     this.interiorGap = new RectangleInsets(1.0, 3.0, 1.0, 3.0); [EOL]     this.backgroundPaint = new Color(255, 255, 192); [EOL]     this.shadowPaint = Color.gray; [EOL]     this.shadowXOffset = 2.0; [EOL]     this.shadowYOffset = 2.0; [EOL]     this.textBlock = block; [EOL] } <line_num>: 100,109
public Paint getOutlinePaint() { [EOL]     return this.outlinePaint; [EOL] } <line_num>: 116,118
public void setOutlinePaint(Paint paint) { [EOL]     this.outlinePaint = paint; [EOL] } <line_num>: 125,127
public Stroke getOutlineStroke() { [EOL]     return this.outlineStroke; [EOL] } <line_num>: 134,136
public void setOutlineStroke(Stroke stroke) { [EOL]     this.outlineStroke = stroke; [EOL] } <line_num>: 143,145
public RectangleInsets getInteriorGap() { [EOL]     return this.interiorGap; [EOL] } <line_num>: 152,154
public void setInteriorGap(RectangleInsets gap) { [EOL]     this.interiorGap = gap; [EOL] } <line_num>: 161,163
public Paint getBackgroundPaint() { [EOL]     return this.backgroundPaint; [EOL] } <line_num>: 170,172
public void setBackgroundPaint(Paint paint) { [EOL]     this.backgroundPaint = paint; [EOL] } <line_num>: 179,181
public Paint getShadowPaint() { [EOL]     return this.shadowPaint; [EOL] } <line_num>: 188,190
public void setShadowPaint(Paint paint) { [EOL]     this.shadowPaint = paint; [EOL] } <line_num>: 197,199
public double getShadowXOffset() { [EOL]     return this.shadowXOffset; [EOL] } <line_num>: 206,208
public void setShadowXOffset(double offset) { [EOL]     this.shadowXOffset = offset; [EOL] } <line_num>: 215,217
public double getShadowYOffset() { [EOL]     return this.shadowYOffset; [EOL] } <line_num>: 224,226
public void setShadowYOffset(double offset) { [EOL]     this.shadowYOffset = offset; [EOL] } <line_num>: 233,235
public TextBlock getTextBlock() { [EOL]     return this.textBlock; [EOL] } <line_num>: 242,244
public void setTextBlock(TextBlock block) { [EOL]     this.textBlock = block; [EOL] } <line_num>: 251,253
public void draw(Graphics2D g2, float x, float y, RectangleAnchor anchor) { [EOL]     Size2D d1 = this.textBlock.calculateDimensions(g2); [EOL]     double w = this.interiorGap.extendWidth(d1.getWidth()); [EOL]     double h = this.interiorGap.extendHeight(d1.getHeight()); [EOL]     Size2D d2 = new Size2D(w, h); [EOL]     Rectangle2D bounds = RectangleAnchor.createRectangle(d2, x, y, anchor); [EOL]     double xx = bounds.getX(); [EOL]     double yy = bounds.getY(); [EOL]     if (this.shadowPaint != null) { [EOL]         Rectangle2D shadow = new Rectangle2D.Double(xx + this.shadowXOffset, yy + this.shadowYOffset, bounds.getWidth(), bounds.getHeight()); [EOL]         g2.setPaint(this.shadowPaint); [EOL]         g2.fill(shadow); [EOL]     } [EOL]     if (this.backgroundPaint != null) { [EOL]         g2.setPaint(this.backgroundPaint); [EOL]         g2.fill(bounds); [EOL]     } [EOL]     if (this.outlinePaint != null && this.outlineStroke != null) { [EOL]         g2.setPaint(this.outlinePaint); [EOL]         g2.setStroke(this.outlineStroke); [EOL]         g2.draw(bounds); [EOL]     } [EOL]     this.textBlock.draw(g2, (float) (xx + this.interiorGap.calculateLeftInset(w)), (float) (yy + this.interiorGap.calculateTopInset(h)), TextBlockAnchor.TOP_LEFT); [EOL] } <line_num>: 263,295
public double getHeight(Graphics2D g2) { [EOL]     Size2D d = this.textBlock.calculateDimensions(g2); [EOL]     return this.interiorGap.extendHeight(d.getHeight()); [EOL] } <line_num>: 304,307
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof TextBox)) { [EOL]         return false; [EOL]     } [EOL]     final TextBox that = (TextBox) obj; [EOL]     if (!ObjectUtilities.equal(this.outlinePaint, that.outlinePaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.outlineStroke, that.outlineStroke)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.interiorGap, that.interiorGap)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.backgroundPaint, that.backgroundPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.shadowPaint, that.shadowPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (this.shadowXOffset != that.shadowXOffset) { [EOL]         return false; [EOL]     } [EOL]     if (this.shadowYOffset != that.shadowYOffset) { [EOL]         return false; [EOL]     } [EOL]     if (!ObjectUtilities.equal(this.textBlock, that.textBlock)) { [EOL]         return false; [EOL]     } [EOL]     return true; [EOL] } <line_num>: 316,351
public int hashCode() { [EOL]     int result; [EOL]     long temp; [EOL]     result = (this.outlinePaint != null ? this.outlinePaint.hashCode() : 0); [EOL]     result = 29 * result + (this.outlineStroke != null ? this.outlineStroke.hashCode() : 0); [EOL]     result = 29 * result + (this.interiorGap != null ? this.interiorGap.hashCode() : 0); [EOL]     result = 29 * result + (this.backgroundPaint != null ? this.backgroundPaint.hashCode() : 0); [EOL]     result = 29 * result + (this.shadowPaint != null ? this.shadowPaint.hashCode() : 0); [EOL]     temp = this.shadowXOffset != +0.0d ? Double.doubleToLongBits(this.shadowXOffset) : 0L; [EOL]     result = 29 * result + (int) (temp ^ (temp >>> 32)); [EOL]     temp = this.shadowYOffset != +0.0d ? Double.doubleToLongBits(this.shadowYOffset) : 0L; [EOL]     result = 29 * result + (int) (temp ^ (temp >>> 32)); [EOL]     result = 29 * result + (this.textBlock != null ? this.textBlock.hashCode() : 0); [EOL]     return result; [EOL] } <line_num>: 358,379
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.outlinePaint, stream); [EOL]     SerialUtilities.writeStroke(this.outlineStroke, stream); [EOL]     SerialUtilities.writePaint(this.backgroundPaint, stream); [EOL]     SerialUtilities.writePaint(this.shadowPaint, stream); [EOL] } <line_num>: 388,395
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.outlinePaint = SerialUtilities.readPaint(stream); [EOL]     this.outlineStroke = SerialUtilities.readStroke(stream); [EOL]     this.backgroundPaint = SerialUtilities.readPaint(stream); [EOL]     this.shadowPaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 405,412