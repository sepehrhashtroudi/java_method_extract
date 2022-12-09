public SubLine(final Line line, final IntervalsSet remainingRegion) { [EOL]     this.line = line; [EOL]     this.remainingRegion = remainingRegion; [EOL] } <line_num>: 44,47
public SubLine(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException { [EOL]     this(new Line(start, end), buildIntervalSet(start, end)); [EOL] } <line_num>: 54,57
public SubLine(final Segment segment) throws MathIllegalArgumentException { [EOL]     this(segment.getLine(), buildIntervalSet(segment.getStart(), segment.getEnd())); [EOL] } <line_num>: 63,65
public List<Segment> getSegments() { [EOL]     final List<Interval> list = remainingRegion.asList(); [EOL]     final List<Segment> segments = new ArrayList<Segment>(list.size()); [EOL]     for (final Interval interval : list) { [EOL]         final Vector3D start = line.toSpace(new Vector1D(interval.getInf())); [EOL]         final Vector3D end = line.toSpace(new Vector1D(interval.getSup())); [EOL]         segments.add(new Segment(start, end, line)); [EOL]     } [EOL]     return segments; [EOL] } <line_num>: 81,94
public Vector3D intersection(final SubLine subLine, final boolean includeEndPoints) { [EOL]     Vector3D v1D = line.intersection(subLine.line); [EOL]     if (v1D == null) { [EOL]         return null; [EOL]     } [EOL]     Location loc1 = remainingRegion.checkPoint(line.toSubSpace(v1D)); [EOL]     Location loc2 = subLine.remainingRegion.checkPoint(subLine.line.toSubSpace(v1D)); [EOL]     if (includeEndPoints) { [EOL]         return ((loc1 != Location.OUTSIDE) && (loc2 != Location.OUTSIDE)) ? v1D : null; [EOL]     } else { [EOL]         return ((loc1 == Location.INSIDE) && (loc2 == Location.INSIDE)) ? v1D : null; [EOL]     } [EOL] } <line_num>: 110,130
private static IntervalsSet buildIntervalSet(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException { [EOL]     final Line line = new Line(start, end); [EOL]     return new IntervalsSet(line.toSubSpace(start).getX(), line.toSubSpace(end).getX()); [EOL] } <line_num>: 138,143