protected void drawNeedle(Graphics2D g2, Rectangle2D plotArea, Point2D rotate, double angle) { [EOL]     GeneralPath shape = new GeneralPath(); [EOL]     shape.append(new Arc2D.Double(-9.0, -7.0, 10, 14, 0.0, 25.5, Arc2D.OPEN), true); [EOL]     shape.append(new Arc2D.Double(0.0, -7.0, 10, 14, 154.5, 25.5, Arc2D.OPEN), true); [EOL]     shape.closePath(); [EOL]     getTransform().setToTranslation(plotArea.getMinX(), plotArea.getMaxY()); [EOL]     getTransform().scale(plotArea.getWidth(), plotArea.getHeight() / 3); [EOL]     shape.transform(getTransform()); [EOL]     if ((rotate != null) && (angle != 0)) { [EOL]         getTransform().setToRotation(angle, rotate.getX(), rotate.getY()); [EOL]         shape.transform(getTransform()); [EOL]     } [EOL]     defaultDisplay(g2, shape); [EOL] } <line_num>: 73,93
public boolean equals(Object object) { [EOL]     if (object == null) { [EOL]         return false; [EOL]     } [EOL]     if (object == this) { [EOL]         return true; [EOL]     } [EOL]     if (super.equals(object) && object instanceof ShipNeedle) { [EOL]         return true; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 102,113
public int hashCode() { [EOL]     return super.hashCode(); [EOL] } <line_num>: 120,122
public Object clone() throws CloneNotSupportedException { [EOL]     return super.clone(); [EOL] } <line_num>: 132,134