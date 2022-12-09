public PeriodAxis(String label) { [EOL]     this(label, new Day(), new Day()); [EOL] } <line_num>: 185,187
public PeriodAxis(String label, RegularTimePeriod first, RegularTimePeriod last) { [EOL]     this(label, first, last, TimeZone.getDefault(), Locale.getDefault()); [EOL] } <line_num>: 198,201
public PeriodAxis(String label, RegularTimePeriod first, RegularTimePeriod last, TimeZone timeZone, Locale locale) { [EOL]     super(label, null); [EOL]     if (timeZone == null) { [EOL]         throw new IllegalArgumentException("Null 'timeZone' argument."); [EOL]     } [EOL]     if (locale == null) { [EOL]         throw new IllegalArgumentException("Null 'locale' argument."); [EOL]     } [EOL]     this.first = first; [EOL]     this.last = last; [EOL]     this.timeZone = timeZone; [EOL]     this.locale = locale; [EOL]     this.calendar = Calendar.getInstance(timeZone, locale); [EOL]     this.first.peg(this.calendar); [EOL]     this.last.peg(this.calendar); [EOL]     this.autoRangeTimePeriodClass = first.getClass(); [EOL]     this.majorTickTimePeriodClass = first.getClass(); [EOL]     this.minorTickMarksVisible = false; [EOL]     this.minorTickTimePeriodClass = RegularTimePeriod.downsize(this.majorTickTimePeriodClass); [EOL]     setAutoRange(true); [EOL]     this.labelInfo = new PeriodAxisLabelInfo[2]; [EOL]     this.labelInfo[0] = new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM", locale)); [EOL]     this.labelInfo[1] = new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy", locale)); [EOL] } <line_num>: 216,243
public RegularTimePeriod getFirst() { [EOL]     return this.first; [EOL] } <line_num>: 250,252
public void setFirst(RegularTimePeriod first) { [EOL]     if (first == null) { [EOL]         throw new IllegalArgumentException("Null 'first' argument."); [EOL]     } [EOL]     this.first = first; [EOL]     this.first.peg(this.calendar); [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 260,267
public RegularTimePeriod getLast() { [EOL]     return this.last; [EOL] } <line_num>: 274,276
public void setLast(RegularTimePeriod last) { [EOL]     if (last == null) { [EOL]         throw new IllegalArgumentException("Null 'last' argument."); [EOL]     } [EOL]     this.last = last; [EOL]     this.last.peg(this.calendar); [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 284,291
public TimeZone getTimeZone() { [EOL]     return this.timeZone; [EOL] } <line_num>: 299,301
public void setTimeZone(TimeZone zone) { [EOL]     if (zone == null) { [EOL]         throw new IllegalArgumentException("Null 'zone' argument."); [EOL]     } [EOL]     this.timeZone = zone; [EOL]     this.calendar = Calendar.getInstance(zone, this.locale); [EOL]     this.first.peg(this.calendar); [EOL]     this.last.peg(this.calendar); [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 309,318
public Locale getLocale() { [EOL]     return this.locale; [EOL] } <line_num>: 327,329
public Class getAutoRangeTimePeriodClass() { [EOL]     return this.autoRangeTimePeriodClass; [EOL] } <line_num>: 337,339
public void setAutoRangeTimePeriodClass(Class c) { [EOL]     if (c == null) { [EOL]         throw new IllegalArgumentException("Null 'c' argument."); [EOL]     } [EOL]     this.autoRangeTimePeriodClass = c; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 348,354
public Class getMajorTickTimePeriodClass() { [EOL]     return this.majorTickTimePeriodClass; [EOL] } <line_num>: 361,363
public void setMajorTickTimePeriodClass(Class c) { [EOL]     if (c == null) { [EOL]         throw new IllegalArgumentException("Null 'c' argument."); [EOL]     } [EOL]     this.majorTickTimePeriodClass = c; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 372,378
public boolean isMinorTickMarksVisible() { [EOL]     return this.minorTickMarksVisible; [EOL] } <line_num>: 386,388
public void setMinorTickMarksVisible(boolean visible) { [EOL]     this.minorTickMarksVisible = visible; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 397,400
public Class getMinorTickTimePeriodClass() { [EOL]     return this.minorTickTimePeriodClass; [EOL] } <line_num>: 407,409
public void setMinorTickTimePeriodClass(Class c) { [EOL]     if (c == null) { [EOL]         throw new IllegalArgumentException("Null 'c' argument."); [EOL]     } [EOL]     this.minorTickTimePeriodClass = c; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 418,424
public Stroke getMinorTickMarkStroke() { [EOL]     return this.minorTickMarkStroke; [EOL] } <line_num>: 432,434
public void setMinorTickMarkStroke(Stroke stroke) { [EOL]     if (stroke == null) { [EOL]         throw new IllegalArgumentException("Null 'stroke' argument."); [EOL]     } [EOL]     this.minorTickMarkStroke = stroke; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 443,449
public Paint getMinorTickMarkPaint() { [EOL]     return this.minorTickMarkPaint; [EOL] } <line_num>: 457,459
public void setMinorTickMarkPaint(Paint paint) { [EOL]     if (paint == null) { [EOL]         throw new IllegalArgumentException("Null 'paint' argument."); [EOL]     } [EOL]     this.minorTickMarkPaint = paint; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 468,474
public float getMinorTickMarkInsideLength() { [EOL]     return this.minorTickMarkInsideLength; [EOL] } <line_num>: 481,483
public void setMinorTickMarkInsideLength(float length) { [EOL]     this.minorTickMarkInsideLength = length; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 491,494
public float getMinorTickMarkOutsideLength() { [EOL]     return this.minorTickMarkOutsideLength; [EOL] } <line_num>: 501,503
public void setMinorTickMarkOutsideLength(float length) { [EOL]     this.minorTickMarkOutsideLength = length; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 511,514
public PeriodAxisLabelInfo[] getLabelInfo() { [EOL]     return this.labelInfo; [EOL] } <line_num>: 521,523
public void setLabelInfo(PeriodAxisLabelInfo[] info) { [EOL]     this.labelInfo = info; [EOL]     notifyListeners(new AxisChangeEvent(this)); [EOL] } <line_num>: 531,534
public Range getRange() { [EOL]     return new Range(this.first.getFirstMillisecond(this.calendar), this.last.getLastMillisecond(this.calendar)); [EOL] } <line_num>: 541,545
public void setRange(Range range, boolean turnOffAutoRange, boolean notify) { [EOL]     long upper = Math.round(range.getUpperBound()); [EOL]     long lower = Math.round(range.getLowerBound()); [EOL]     this.first = createInstance(this.autoRangeTimePeriodClass, new Date(lower), this.timeZone, this.locale); [EOL]     this.last = createInstance(this.autoRangeTimePeriodClass, new Date(upper), this.timeZone, this.locale); [EOL]     super.setRange(new Range(this.first.getFirstMillisecond(), this.last.getLastMillisecond() + 1.0), turnOffAutoRange, notify); [EOL] } <line_num>: 558,569
public void configure() { [EOL]     if (this.isAutoRange()) { [EOL]         autoAdjustRange(); [EOL]     } [EOL] } <line_num>: 575,579
public AxisSpace reserveSpace(Graphics2D g2, Plot plot, Rectangle2D plotArea, RectangleEdge edge, AxisSpace space) { [EOL]     if (space == null) { [EOL]         space = new AxisSpace(); [EOL]     } [EOL]     if (!isVisible()) { [EOL]         return space; [EOL]     } [EOL]     double dimension = getFixedDimension(); [EOL]     if (dimension > 0.0) { [EOL]         space.ensureAtLeast(dimension, edge); [EOL]     } [EOL]     Rectangle2D labelEnclosure = getLabelEnclosure(g2, edge); [EOL]     double labelHeight = 0.0; [EOL]     double labelWidth = 0.0; [EOL]     double tickLabelBandsDimension = 0.0; [EOL]     for (int i = 0; i < this.labelInfo.length; i++) { [EOL]         PeriodAxisLabelInfo info = this.labelInfo[i]; [EOL]         FontMetrics fm = g2.getFontMetrics(info.getLabelFont()); [EOL]         tickLabelBandsDimension += info.getPadding().extendHeight(fm.getHeight()); [EOL]     } [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         labelHeight = labelEnclosure.getHeight(); [EOL]         space.add(labelHeight + tickLabelBandsDimension, edge); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         labelWidth = labelEnclosure.getWidth(); [EOL]         space.add(labelWidth + tickLabelBandsDimension, edge); [EOL]     } [EOL]     double tickMarkSpace = 0.0; [EOL]     if (isTickMarksVisible()) { [EOL]         tickMarkSpace = getTickMarkOutsideLength(); [EOL]     } [EOL]     if (this.minorTickMarksVisible) { [EOL]         tickMarkSpace = Math.max(tickMarkSpace, this.minorTickMarkOutsideLength); [EOL]     } [EOL]     space.add(tickMarkSpace, edge); [EOL]     return space; [EOL] } <line_num>: 594,646
public AxisState draw(Graphics2D g2, double cursor, Rectangle2D plotArea, Rectangle2D dataArea, RectangleEdge edge, PlotRenderingInfo plotState) { [EOL]     AxisState axisState = new AxisState(cursor); [EOL]     if (isAxisLineVisible()) { [EOL]         drawAxisLine(g2, cursor, dataArea, edge); [EOL]     } [EOL]     if (isTickMarksVisible()) { [EOL]         drawTickMarks(g2, axisState, dataArea, edge); [EOL]     } [EOL]     if (isTickLabelsVisible()) { [EOL]         for (int band = 0; band < this.labelInfo.length; band++) { [EOL]             axisState = drawTickLabels(band, g2, axisState, dataArea, edge); [EOL]         } [EOL]     } [EOL]     axisState = drawLabel(getLabel(), g2, plotArea, dataArea, edge, axisState, plotState); [EOL]     return axisState; [EOL] } <line_num>: 662,685
protected void drawTickMarks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         drawTickMarksHorizontal(g2, state, dataArea, edge); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         drawTickMarksVertical(g2, state, dataArea, edge); [EOL]     } [EOL] } <line_num>: 695,704
protected void drawTickMarksHorizontal(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     List ticks = new ArrayList(); [EOL]     double x0 = dataArea.getX(); [EOL]     double y0 = state.getCursor(); [EOL]     double insideLength = getTickMarkInsideLength(); [EOL]     double outsideLength = getTickMarkOutsideLength(); [EOL]     RegularTimePeriod t = createInstance(this.majorTickTimePeriodClass, this.first.getStart(), getTimeZone(), this.locale); [EOL]     long t0 = t.getFirstMillisecond(); [EOL]     Line2D inside = null; [EOL]     Line2D outside = null; [EOL]     long firstOnAxis = getFirst().getFirstMillisecond(); [EOL]     long lastOnAxis = getLast().getLastMillisecond() + 1; [EOL]     while (t0 <= lastOnAxis) { [EOL]         ticks.add(new NumberTick(new Double(t0), "", TextAnchor.CENTER, TextAnchor.CENTER, 0.0)); [EOL]         x0 = valueToJava2D(t0, dataArea, edge); [EOL]         if (edge == RectangleEdge.TOP) { [EOL]             inside = new Line2D.Double(x0, y0, x0, y0 + insideLength); [EOL]             outside = new Line2D.Double(x0, y0, x0, y0 - outsideLength); [EOL]         } else if (edge == RectangleEdge.BOTTOM) { [EOL]             inside = new Line2D.Double(x0, y0, x0, y0 - insideLength); [EOL]             outside = new Line2D.Double(x0, y0, x0, y0 + outsideLength); [EOL]         } [EOL]         if (t0 >= firstOnAxis) { [EOL]             g2.setPaint(getTickMarkPaint()); [EOL]             g2.setStroke(getTickMarkStroke()); [EOL]             g2.draw(inside); [EOL]             g2.draw(outside); [EOL]         } [EOL]         if (this.minorTickMarksVisible) { [EOL]             RegularTimePeriod tminor = createInstance(this.minorTickTimePeriodClass, new Date(t0), getTimeZone(), this.locale); [EOL]             long tt0 = tminor.getFirstMillisecond(); [EOL]             while (tt0 < t.getLastMillisecond() && tt0 < lastOnAxis) { [EOL]                 double xx0 = valueToJava2D(tt0, dataArea, edge); [EOL]                 if (edge == RectangleEdge.TOP) { [EOL]                     inside = new Line2D.Double(xx0, y0, xx0, y0 + this.minorTickMarkInsideLength); [EOL]                     outside = new Line2D.Double(xx0, y0, xx0, y0 - this.minorTickMarkOutsideLength); [EOL]                 } else if (edge == RectangleEdge.BOTTOM) { [EOL]                     inside = new Line2D.Double(xx0, y0, xx0, y0 - this.minorTickMarkInsideLength); [EOL]                     outside = new Line2D.Double(xx0, y0, xx0, y0 + this.minorTickMarkOutsideLength); [EOL]                 } [EOL]                 if (tt0 >= firstOnAxis) { [EOL]                     g2.setPaint(this.minorTickMarkPaint); [EOL]                     g2.setStroke(this.minorTickMarkStroke); [EOL]                     g2.draw(inside); [EOL]                     g2.draw(outside); [EOL]                 } [EOL]                 tminor = tminor.next(); [EOL]                 tminor.peg(this.calendar); [EOL]                 tt0 = tminor.getFirstMillisecond(); [EOL]             } [EOL]         } [EOL]         t = t.next(); [EOL]         t.peg(this.calendar); [EOL]         t0 = t.getFirstMillisecond(); [EOL]     } [EOL]     if (edge == RectangleEdge.TOP) { [EOL]         state.cursorUp(Math.max(outsideLength, this.minorTickMarkOutsideLength)); [EOL]     } else if (edge == RectangleEdge.BOTTOM) { [EOL]         state.cursorDown(Math.max(outsideLength, this.minorTickMarkOutsideLength)); [EOL]     } [EOL]     state.setTicks(ticks); [EOL] } <line_num>: 715,793
protected void drawTickMarksVertical(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL] } <line_num>: 803,807
protected AxisState drawTickLabels(int band, Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     double delta1 = 0.0; [EOL]     FontMetrics fm = g2.getFontMetrics(this.labelInfo[band].getLabelFont()); [EOL]     if (edge == RectangleEdge.BOTTOM) { [EOL]         delta1 = this.labelInfo[band].getPadding().calculateTopOutset(fm.getHeight()); [EOL]     } else if (edge == RectangleEdge.TOP) { [EOL]         delta1 = this.labelInfo[band].getPadding().calculateBottomOutset(fm.getHeight()); [EOL]     } [EOL]     state.moveCursor(delta1, edge); [EOL]     long axisMin = this.first.getFirstMillisecond(); [EOL]     long axisMax = this.last.getLastMillisecond(); [EOL]     g2.setFont(this.labelInfo[band].getLabelFont()); [EOL]     g2.setPaint(this.labelInfo[band].getLabelPaint()); [EOL]     RegularTimePeriod p1 = this.labelInfo[band].createInstance(new Date(axisMin), this.timeZone, this.locale); [EOL]     RegularTimePeriod p2 = this.labelInfo[band].createInstance(new Date(axisMax), this.timeZone, this.locale); [EOL]     String label1 = this.labelInfo[band].getDateFormat().format(new Date(p1.getMiddleMillisecond())); [EOL]     String label2 = this.labelInfo[band].getDateFormat().format(new Date(p2.getMiddleMillisecond())); [EOL]     Rectangle2D b1 = TextUtilities.getTextBounds(label1, g2, g2.getFontMetrics()); [EOL]     Rectangle2D b2 = TextUtilities.getTextBounds(label2, g2, g2.getFontMetrics()); [EOL]     double w = Math.max(b1.getWidth(), b2.getWidth()); [EOL]     long ww = Math.round(java2DToValue(dataArea.getX() + w + 5.0, dataArea, edge)); [EOL]     if (isInverted()) { [EOL]         ww = axisMax - ww; [EOL]     } else { [EOL]         ww = ww - axisMin; [EOL]     } [EOL]     long length = p1.getLastMillisecond() - p1.getFirstMillisecond(); [EOL]     int periods = (int) (ww / length) + 1; [EOL]     RegularTimePeriod p = this.labelInfo[band].createInstance(new Date(axisMin), this.timeZone, this.locale); [EOL]     Rectangle2D b = null; [EOL]     long lastXX = 0L; [EOL]     float y = (float) (state.getCursor()); [EOL]     TextAnchor anchor = TextAnchor.TOP_CENTER; [EOL]     float yDelta = (float) b1.getHeight(); [EOL]     if (edge == RectangleEdge.TOP) { [EOL]         anchor = TextAnchor.BOTTOM_CENTER; [EOL]         yDelta = -yDelta; [EOL]     } [EOL]     while (p.getFirstMillisecond() <= axisMax) { [EOL]         float x = (float) valueToJava2D(p.getMiddleMillisecond(), dataArea, edge); [EOL]         DateFormat df = this.labelInfo[band].getDateFormat(); [EOL]         String label = df.format(new Date(p.getMiddleMillisecond())); [EOL]         long first = p.getFirstMillisecond(); [EOL]         long last = p.getLastMillisecond(); [EOL]         if (last > axisMax) { [EOL]             Rectangle2D bb = TextUtilities.getTextBounds(label, g2, g2.getFontMetrics()); [EOL]             if ((x + bb.getWidth() / 2) > dataArea.getMaxX()) { [EOL]                 float xstart = (float) valueToJava2D(Math.max(first, axisMin), dataArea, edge); [EOL]                 if (bb.getWidth() < (dataArea.getMaxX() - xstart)) { [EOL]                     x = ((float) dataArea.getMaxX() + xstart) / 2.0f; [EOL]                 } else { [EOL]                     label = null; [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (first < axisMin) { [EOL]             Rectangle2D bb = TextUtilities.getTextBounds(label, g2, g2.getFontMetrics()); [EOL]             if ((x - bb.getWidth() / 2) < dataArea.getX()) { [EOL]                 float xlast = (float) valueToJava2D(Math.min(last, axisMax), dataArea, edge); [EOL]                 if (bb.getWidth() < (xlast - dataArea.getX())) { [EOL]                     x = (xlast + (float) dataArea.getX()) / 2.0f; [EOL]                 } else { [EOL]                     label = null; [EOL]                 } [EOL]             } [EOL]         } [EOL]         if (label != null) { [EOL]             g2.setPaint(this.labelInfo[band].getLabelPaint()); [EOL]             b = TextUtilities.drawAlignedString(label, g2, x, y, anchor); [EOL]         } [EOL]         if (lastXX > 0L) { [EOL]             if (this.labelInfo[band].getDrawDividers()) { [EOL]                 long nextXX = p.getFirstMillisecond(); [EOL]                 long mid = (lastXX + nextXX) / 2; [EOL]                 float mid2d = (float) valueToJava2D(mid, dataArea, edge); [EOL]                 g2.setStroke(this.labelInfo[band].getDividerStroke()); [EOL]                 g2.setPaint(this.labelInfo[band].getDividerPaint()); [EOL]                 g2.draw(new Line2D.Float(mid2d, y, mid2d, y + yDelta)); [EOL]             } [EOL]         } [EOL]         lastXX = last; [EOL]         for (int i = 0; i < periods; i++) { [EOL]             p = p.next(); [EOL]         } [EOL]         p.peg(this.calendar); [EOL]     } [EOL]     double used = 0.0; [EOL]     if (b != null) { [EOL]         used = b.getHeight(); [EOL]         if (edge == RectangleEdge.BOTTOM) { [EOL]             used += this.labelInfo[band].getPadding().calculateBottomOutset(fm.getHeight()); [EOL]         } else if (edge == RectangleEdge.TOP) { [EOL]             used += this.labelInfo[band].getPadding().calculateTopOutset(fm.getHeight()); [EOL]         } [EOL]     } [EOL]     state.moveCursor(used, edge); [EOL]     return state; [EOL] } <line_num>: 820,953
public List refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) { [EOL]     return Collections.EMPTY_LIST; [EOL] } <line_num>: 966,969
public double valueToJava2D(double value, Rectangle2D area, RectangleEdge edge) { [EOL]     double result = Double.NaN; [EOL]     double axisMin = this.first.getFirstMillisecond(); [EOL]     double axisMax = this.last.getLastMillisecond(); [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         double minX = area.getX(); [EOL]         double maxX = area.getMaxX(); [EOL]         if (isInverted()) { [EOL]             result = maxX + ((value - axisMin) / (axisMax - axisMin)) * (minX - maxX); [EOL]         } else { [EOL]             result = minX + ((value - axisMin) / (axisMax - axisMin)) * (maxX - minX); [EOL]         } [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         double minY = area.getMinY(); [EOL]         double maxY = area.getMaxY(); [EOL]         if (isInverted()) { [EOL]             result = minY + (((value - axisMin) / (axisMax - axisMin)) * (maxY - minY)); [EOL]         } else { [EOL]             result = maxY - (((value - axisMin) / (axisMax - axisMin)) * (maxY - minY)); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 983,1015
public double java2DToValue(double java2DValue, Rectangle2D area, RectangleEdge edge) { [EOL]     double result = Double.NaN; [EOL]     double min = 0.0; [EOL]     double max = 0.0; [EOL]     double axisMin = this.first.getFirstMillisecond(); [EOL]     double axisMax = this.last.getLastMillisecond(); [EOL]     if (RectangleEdge.isTopOrBottom(edge)) { [EOL]         min = area.getX(); [EOL]         max = area.getMaxX(); [EOL]     } else if (RectangleEdge.isLeftOrRight(edge)) { [EOL]         min = area.getMaxY(); [EOL]         max = area.getY(); [EOL]     } [EOL]     if (isInverted()) { [EOL]         result = axisMax - ((java2DValue - min) / (max - min) * (axisMax - axisMin)); [EOL]     } else { [EOL]         result = axisMin + ((java2DValue - min) / (max - min) * (axisMax - axisMin)); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1027,1052
protected void autoAdjustRange() { [EOL]     Plot plot = getPlot(); [EOL]     if (plot == null) { [EOL]         return; [EOL]     } [EOL]     if (plot instanceof ValueAxisPlot) { [EOL]         ValueAxisPlot vap = (ValueAxisPlot) plot; [EOL]         Range r = vap.getDataRange(this); [EOL]         if (r == null) { [EOL]             r = getDefaultAutoRange(); [EOL]         } [EOL]         long upper = Math.round(r.getUpperBound()); [EOL]         long lower = Math.round(r.getLowerBound()); [EOL]         this.first = createInstance(this.autoRangeTimePeriodClass, new Date(lower), this.timeZone, this.locale); [EOL]         this.last = createInstance(this.autoRangeTimePeriodClass, new Date(upper), this.timeZone, this.locale); [EOL]         setRange(r, false, false); [EOL]     } [EOL] } <line_num>: 1057,1081
public boolean equals(Object obj) { [EOL]     if (obj == this) { [EOL]         return true; [EOL]     } [EOL]     if (!(obj instanceof PeriodAxis)) { [EOL]         return false; [EOL]     } [EOL]     PeriodAxis that = (PeriodAxis) obj; [EOL]     if (!this.first.equals(that.first)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.last.equals(that.last)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.timeZone.equals(that.timeZone)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.locale.equals(that.locale)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.autoRangeTimePeriodClass.equals(that.autoRangeTimePeriodClass)) { [EOL]         return false; [EOL]     } [EOL]     if (!(isMinorTickMarksVisible() == that.isMinorTickMarksVisible())) { [EOL]         return false; [EOL]     } [EOL]     if (!this.majorTickTimePeriodClass.equals(that.majorTickTimePeriodClass)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.minorTickTimePeriodClass.equals(that.minorTickTimePeriodClass)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.minorTickMarkPaint.equals(that.minorTickMarkPaint)) { [EOL]         return false; [EOL]     } [EOL]     if (!this.minorTickMarkStroke.equals(that.minorTickMarkStroke)) { [EOL]         return false; [EOL]     } [EOL]     if (!Arrays.equals(this.labelInfo, that.labelInfo)) { [EOL]         return false; [EOL]     } [EOL]     return super.equals(obj); [EOL] } <line_num>: 1090,1136
public int hashCode() { [EOL]     if (getLabel() != null) { [EOL]         return getLabel().hashCode(); [EOL]     } else { [EOL]         return 0; [EOL]     } [EOL] } <line_num>: 1143,1150
public Object clone() throws CloneNotSupportedException { [EOL]     PeriodAxis clone = (PeriodAxis) super.clone(); [EOL]     clone.timeZone = (TimeZone) this.timeZone.clone(); [EOL]     clone.labelInfo = new PeriodAxisLabelInfo[this.labelInfo.length]; [EOL]     for (int i = 0; i < this.labelInfo.length; i++) { [EOL]         clone.labelInfo[i] = this.labelInfo[i]; [EOL]     } [EOL]     return clone; [EOL] } <line_num>: 1160,1169
private RegularTimePeriod createInstance(Class periodClass, Date millisecond, TimeZone zone, Locale locale) { [EOL]     RegularTimePeriod result = null; [EOL]     try { [EOL]         Constructor c = periodClass.getDeclaredConstructor(new Class[] { Date.class, TimeZone.class, Locale.class }); [EOL]         result = (RegularTimePeriod) c.newInstance(new Object[] { millisecond, zone, locale }); [EOL]     } catch (Exception e) { [EOL]         try { [EOL]             Constructor c = periodClass.getDeclaredConstructor(new Class[] { Date.class }); [EOL]             result = (RegularTimePeriod) c.newInstance(new Object[] { millisecond }); [EOL]         } catch (Exception e2) { [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1183,1204
private void writeObject(ObjectOutputStream stream) throws IOException { [EOL]     stream.defaultWriteObject(); [EOL]     SerialUtilities.writeStroke(this.minorTickMarkStroke, stream); [EOL]     SerialUtilities.writePaint(this.minorTickMarkPaint, stream); [EOL] } <line_num>: 1213,1217
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { [EOL]     stream.defaultReadObject(); [EOL]     this.minorTickMarkStroke = SerialUtilities.readStroke(stream); [EOL]     this.minorTickMarkPaint = SerialUtilities.readPaint(stream); [EOL] } <line_num>: 1227,1232