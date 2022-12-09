public SymbolAxis(String label, String[] sv) { [EOL]     super(label); [EOL]     this.symbols = Arrays.asList(sv); [EOL]     this.gridBandsVisible = true; [EOL]     this.gridBandPaint = DEFAULT_GRID_BAND_PAINT; [EOL]     this.gridBandAlternatePaint = DEFAULT_GRID_BAND_ALTERNATE_PAINT; [EOL]     setAutoTickUnitSelection(false, false); [EOL]     setAutoRangeStickyZero(false); [EOL] } <line_num>: 156,165
public String[] getSymbols() { [EOL]     String[] result = new String[this.symbols.size()]; [EOL]     result = (String[]) this.symbols.toArray(result); [EOL]     return result; [EOL] } <line_num>: 172,176
public boolean isGridBandsVisible() { [EOL]     return this.gridBandsVisible; [EOL] } <line_num>: 187,189
public void setGridBandsVisible(boolean flag) { [EOL]     if (this.gridBandsVisible != flag) { [EOL]         this.gridBandsVisible = flag; [EOL]         notifyListeners(new AxisChangeEvent(this)); [EOL]     } [EOL] } <line_num>: 199,204
public Paint getGridBandPaint() { [EOL]     return this.gridBandPaint; [EOL] } <line_num>: 214,216
public void setGridBandPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.gridBandPaint = paint; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 226,232
public Paint getGridBandAlternatePaint() { [EOL]     return this.gridBandAlternatePaint; [EOL] } <line_num>: 244,246
public void setGridBandAlternatePaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.gridBandAlternatePaint = paint; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 259,265
protected void selectAutoTickUnit(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     throw new UnsupportedOperationException(); [EOL] } <line_num>: 274,277
public AxisState draw(Graphics2D g2, double cursor, Rectangle2D plotArea, Rectangle2D dataArea, RectangleEdge edge, PlotRenderingInfo plotState) { [EOL]     AxisState info = new AxisState(cursor); [EOL]     if (isVisible()) { [EOL]         info = super.draw(g2, cursor, plotArea, dataArea, edge, plotState); [EOL]     } [EOL]     if (this.gridBandsVisible) { [EOL]         drawGridBands(g2, plotArea, dataArea, edge, info.getTicks()); [EOL]     } [EOL]     return info; [EOL] } <line_num>: 295,311
protected void drawGridBands(Graphics2D g2, Rectangle2D plotArea, Rectangle2D dataArea, RectangleEdge edge, List ticks) { [EOL]     Shape savedClip = g2.getClip(); [EOL]     g2.clip(dataArea); [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         drawGridBandsHorizontal(g2, plotArea, dataArea, true, ticks); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         drawGridBandsVertical(g2, plotArea, dataArea, true, ticks); [EOL]     } [EOL]     g2.setClip(savedClip); [EOL] } <line_num>: 325,341
protected void drawGridBandsHorizontal(Graphics2D g2, Rectangle2D plotArea, Rectangle2D dataArea, boolean firstGridBandIsDark, List ticks) { [EOL]     boolean currentGridBandIsDark = firstGridBandIsDark; [EOL]     double yy = dataArea.getY(); [EOL]     double xx1, xx2; [EOL]     double outlineStrokeWidth; [EOL]     if (getPlot().getOutlineStroke() != null) { [EOL]         outlineStrokeWidth = ((BasicStroke) getPlot().getOutlineStroke()).getLineWidth(); [EOL]     } else { [EOL]         outlineStrokeWidth = 1d; [EOL]     } [EOL]     Iterator iterator = ticks.iterator(); [EOL]     ValueTick tick; [EOL]     Rectangle2D band; [EOL]     while (iterator.hasNext()) { [EOL]         tick = (ValueTick) iterator.next(); [EOL]         xx1 = valueToJava2D(tick.getValue() - 0.5d, dataArea, RectangleEdge.BOTTOM); [EOL]         xx2 = valueToJava2D(tick.getValue() + 0.5d, dataArea, RectangleEdge.BOTTOM); [EOL]         if (currentGridBandIsDark) { [EOL]             g2.setPaint(this.gridBandPaint); [EOL]         } else { [EOL]             g2.setPaint(this.gridBandAlternatePaint); [EOL]         } [EOL]         band = new Rectangle2D.Double(xx1, yy + outlineStrokeWidth, xx2 - xx1, dataArea.getMaxY() - yy - outlineStrokeWidth); [EOL]         g2.fill(band); [EOL]         currentGridBandIsDark = !currentGridBandIsDark; [EOL]     } [EOL]     g2.setPaintMode(); [EOL] } <line_num>: 357,398
protected void drawGridBandsVertical(Graphics2D g2, Rectangle2D drawArea, Rectangle2D plotArea, boolean firstGridBandIsDark, List ticks) { [EOL]     boolean currentGridBandIsDark = firstGridBandIsDark; [EOL]     double xx = plotArea.getX(); [EOL]     double yy1, yy2; [EOL]     double outlineStrokeWidth; [EOL]     Stroke outlineStroke = getPlot().getOutlineStroke(); [EOL]     if (outlineStroke != null && outlineStroke instanceof BasicStroke) { [EOL]         outlineStrokeWidth = ((BasicStroke) outlineStroke).getLineWidth(); [EOL]     } else { [EOL]         outlineStrokeWidth = 1d; [EOL]     } [EOL]     Iterator iterator = ticks.iterator(); [EOL]     ValueTick tick; [EOL]     Rectangle2D band; [EOL]     while (iterator.hasNext()) { [EOL]         tick = (ValueTick) iterator.next(); [EOL]         yy1 = valueToJava2D(tick.getValue() + 0.5d, plotArea, RectangleEdge.LEFT); [EOL]         yy2 = valueToJava2D(tick.getValue() - 0.5d, plotArea, RectangleEdge.LEFT); [EOL]         if (currentGridBandIsDark) { [EOL]             g2.setPaint(this.gridBandPaint); [EOL]         } else { [EOL]             g2.setPaint(this.gridBandAlternatePaint); [EOL]         } [EOL]         band = new Rectangle2D.Double(xx + outlineStrokeWidth, yy1, plotArea.getMaxX() - xx - outlineStrokeWidth, yy2 - yy1); [EOL]         g2.fill(band); [EOL]         currentGridBandIsDark = !currentGridBandIsDark; [EOL]     } [EOL]     g2.setPaintMode(); [EOL] } <line_num>: 414,455
protected void autoAdjustRange() { [EOL]     Plot plot = getPlot(); [EOL]     if (plot == null) { [EOL]         return; [EOL]     } [EOL]     if (plot instanceof ValueAxisPlot) { [EOL]         double upper = this.symbols.size() - 1; [EOL]         double lower = 0; [EOL]         double range = upper - lower; [EOL]         double minRange = getAutoRangeMinimumSize(); [EOL]         if (range < minRange) { [EOL]             upper = (upper + lower + minRange) / 2; [EOL]             lower = (upper + lower - minRange) / 2; [EOL]         } [EOL]         double upperMargin = 0.5; [EOL]         double lowerMargin = 0.5; [EOL]         if (getAutoRangeIncludesZero()) { [EOL]             if (getAutoRangeStickyZero()) { [EOL]                 if (upper <= 0.0) { [EOL]                     upper = 0.0; [EOL]                 } else { [EOL]                     upper = upper + upperMargin; [EOL]                 } [EOL]                 if (lower >= 0.0) { [EOL]                     lower = 0.0; [EOL]                 } else { [EOL]                     lower = lower - lowerMargin; [EOL]                 } [EOL]             } else { [EOL]                 upper = Math.max(0.0, upper + upperMargin); [EOL]                 lower = Math.min(0.0, lower - lowerMargin); [EOL]             } [EOL]         } else { [EOL]             if (getAutoRangeStickyZero()) { [EOL]                 if (upper <= 0.0) { [EOL]                     upper = Math.min(0.0, upper + upperMargin); [EOL]                 } else { [EOL]                     upper = upper + upperMargin * range; [EOL]                 } [EOL]                 if (lower >= 0.0) { [EOL]                     lower = Math.max(0.0, lower - lowerMargin); [EOL]                 } else { [EOL]                     lower = lower - lowerMargin; [EOL]                 } [EOL]             } else { [EOL]                 upper = upper + upperMargin; [EOL]                 lower = lower - lowerMargin; [EOL]             } [EOL]         } [EOL]         setRange(new Range(lower, upper), false, false); [EOL]     } [EOL] } <line_num>: 460,530
public List refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     List ticks = null; [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         ticks = refreshTicksHorizontal(g2, dataArea, edge); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         ticks = refreshTicksVertical(g2, dataArea, edge); [EOL]     } [EOL]     return ticks; [EOL] } <line_num>: 543,555
protected List refreshTicksHorizontal(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     List ticks = new java.util.ArrayList(); [EOL]     Font tickLabelFont = getTickLabelFont(); [EOL]     g2.setFont(tickLabelFont); [EOL]     double size = getTickUnit().getSize(); [EOL]     int count = calculateVisibleTickCount(); [EOL]     double lowestTickValue = calculateLowestVisibleTickValue(); [EOL]     double previousDrawnTickLabelPos = 0.0; [EOL]     double previousDrawnTickLabelLength = 0.0; [EOL]     if (count <= ValueAxis.MAXIMUM_TICK_COUNT) { [EOL]         for (int i = 0; i < count; i++) { [EOL]             double currentTickValue = lowestTickValue + (i * size); [EOL]             double xx = valueToJava2D(currentTickValue, dataArea, edge); [EOL]             String tickLabel; [EOL]             NumberFormat formatter = getNumberFormatOverride(); [EOL]             if (formatter != null) { [EOL]                 tickLabel = formatter.format(currentTickValue); [EOL]             } else { [EOL]                 tickLabel = valueToString(currentTickValue); [EOL]             } [EOL]             Rectangle2D bounds = TextUtilities.getTextBounds(tickLabel, g2, g2.getFontMetrics()); [EOL]             double tickLabelLength = isVerticalTickLabels() ? bounds.getHeight() : bounds.getWidth(); [EOL]             boolean tickLabelsOverlapping = false; [EOL]             if (i > 0) { [EOL]                 double avgTickLabelLength = (previousDrawnTickLabelLength + tickLabelLength) / 2.0; [EOL]                 if (Math.abs(xx - previousDrawnTickLabelPos) < avgTickLabelLength) { [EOL]                     tickLabelsOverlapping = true; [EOL]                 } [EOL]             } [EOL]             if (tickLabelsOverlapping) { [EOL]                 tickLabel = ""; [EOL]             } else { [EOL]                 previousDrawnTickLabelPos = xx; [EOL]                 previousDrawnTickLabelLength = tickLabelLength; [EOL]             } [EOL]             TextAnchor anchor = null; [EOL]             TextAnchor rotationAnchor = null; [EOL]             double angle = 0.0; [EOL]             if (isVerticalTickLabels()) { [EOL]                 anchor = TextAnchor.CENTER_RIGHT; [EOL]                 rotationAnchor = TextAnchor.CENTER_RIGHT; [EOL]                 if (edge == RectangleEdge.TOP) { [EOL]                     angle = Math.PI / 2.0; [EOL]                 } else { [EOL]                     angle = -Math.PI / 2.0; [EOL]                 } [EOL]             } else { [EOL]                 if (edge == RectangleEdge.TOP) { [EOL]                     anchor = TextAnchor.BOTTOM_CENTER; [EOL]                     rotationAnchor = TextAnchor.BOTTOM_CENTER; [EOL]                 } else { [EOL]                     anchor = TextAnchor.TOP_CENTER; [EOL]                     rotationAnchor = TextAnchor.TOP_CENTER; [EOL]                 } [EOL]             } [EOL]             Tick tick = new NumberTick(new Double(currentTickValue), tickLabel, anchor, rotationAnchor, angle); [EOL]             ticks.add(tick); [EOL]         } [EOL]     } [EOL]     return ticks; [EOL] } <line_num>: 567,649
protected List refreshTicksVertical(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     List ticks = new java.util.ArrayList(); [EOL]     Font tickLabelFont = getTickLabelFont(); [EOL]     g2.setFont(tickLabelFont); [EOL]     double size = getTickUnit().getSize(); [EOL]     int count = calculateVisibleTickCount(); [EOL]     double lowestTickValue = calculateLowestVisibleTickValue(); [EOL]     double previousDrawnTickLabelPos = 0.0; [EOL]     double previousDrawnTickLabelLength = 0.0; [EOL]     if (count <= ValueAxis.MAXIMUM_TICK_COUNT) { [EOL]         for (int i = 0; i < count; i++) { [EOL]             double currentTickValue = lowestTickValue + (i * size); [EOL]             double yy = valueToJava2D(currentTickValue, dataArea, edge); [EOL]             String tickLabel; [EOL]             NumberFormat formatter = getNumberFormatOverride(); [EOL]             if (formatter != null) { [EOL]                 tickLabel = formatter.format(currentTickValue); [EOL]             } else { [EOL]                 tickLabel = valueToString(currentTickValue); [EOL]             } [EOL]             Rectangle2D bounds = TextUtilities.getTextBounds(tickLabel, g2, g2.getFontMetrics()); [EOL]             double tickLabelLength = isVerticalTickLabels() ? bounds.getWidth() : bounds.getHeight(); [EOL]             boolean tickLabelsOverlapping = false; [EOL]             if (i > 0) { [EOL]                 double avgTickLabelLength = (previousDrawnTickLabelLength + tickLabelLength) / 2.0; [EOL]                 if (Math.abs(yy - previousDrawnTickLabelPos) < avgTickLabelLength) { [EOL]                     tickLabelsOverlapping = true; [EOL]                 } [EOL]             } [EOL]             if (tickLabelsOverlapping) { [EOL]                 tickLabel = ""; [EOL]             } else { [EOL]                 previousDrawnTickLabelPos = yy; [EOL]                 previousDrawnTickLabelLength = tickLabelLength; [EOL]             } [EOL]             TextAnchor anchor = null; [EOL]             TextAnchor rotationAnchor = null; [EOL]             double angle = 0.0; [EOL]             if (isVerticalTickLabels()) { [EOL]                 anchor = TextAnchor.BOTTOM_CENTER; [EOL]                 rotationAnchor = TextAnchor.BOTTOM_CENTER; [EOL]                 if (edge == RectangleEdge.LEFT) { [EOL]                     angle = -Math.PI / 2.0; [EOL]                 } else { [EOL]                     angle = Math.PI / 2.0; [EOL]                 } [EOL]             } else { [EOL]                 if (edge == RectangleEdge.LEFT) { [EOL]                     anchor = TextAnchor.CENTER_RIGHT; [EOL]                     rotationAnchor = TextAnchor.CENTER_RIGHT; [EOL]                 } else { [EOL]                     anchor = TextAnchor.CENTER_LEFT; [EOL]                     rotationAnchor = TextAnchor.CENTER_LEFT; [EOL]                 } [EOL]             } [EOL]             Tick tick = new NumberTick(new Double(currentTickValue), tickLabel, anchor, rotationAnchor, angle); [EOL]             ticks.add(tick); [EOL]         } [EOL]     } [EOL]     return ticks; [EOL] } <line_num>: 661,743
public String valueToString(double value) { [EOL]     String strToReturn; [EOL]     try { [EOL]         strToReturn = (String) this.symbols.get((int) value); [EOL]     } catch (IndexOutOfBoundsException ex) { [EOL]         strToReturn = ""; [EOL]     } [EOL]     return strToReturn; [EOL] } <line_num>: 752,761
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof SymbolAxis)) { [EOL]         return false; [EOL]     } [EOL]     SymbolAxis that = (SymbolAxis) obj; [EOL]     if (!this.symbols.equals(that.symbols)) { [EOL]         return false; [EOL]     } [EOL]     if (this.gridBandsVisible != that.gridBandsVisible) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.gridBandPaint, that.gridBandPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!PaintUtilities.equal(this.gridBandAlternatePaint, that.gridBandAlternatePaint)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 770,792
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writePaint(this.gridBandPaint, stream); [EOL]     SerialUtilities.writePaint(this.gridBandAlternatePaint, stream); [EOL] } <line_num>: 801,805
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.gridBandPaint = SerialUtilities.readPaint(stream); [EOL]     this.gridBandAlternatePaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 815,820