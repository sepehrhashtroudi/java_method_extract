public TextBlock()
public HorizontalAlignment getLineAlignment()
public void setLineAlignment(HorizontalAlignment alignment)
public void addLine(String text, Font font, Paint paint)
public void addLine(TextLine line)
public TextLine getLastLine()
public List getLines()
public Size2D calculateDimensions(Graphics2D g2)
public Shape calculateBounds(Graphics2D g2, float anchorX, float anchorY, TextBlockAnchor anchor, float rotateX, float rotateY, double angle)
public void draw(Graphics2D g2, float x, float y, TextBlockAnchor anchor)
public void draw(Graphics2D g2, float anchorX, float anchorY, TextBlockAnchor anchor, float rotateX, float rotateY, double angle)
private float[] calculateOffsets(TextBlockAnchor anchor, double width, double height)
public boolean equals(Object obj)
public int hashCode()
long serialVersionUID=Optional[-4333175719424385526L]
List lines
HorizontalAlignment lineAlignment
