public Plane(final Vector3D normal) throws MathArithmeticException { [EOL]     setNormal(normal); [EOL]     originOffset = 0; [EOL]     setFrame(); [EOL] } <line_num>: 55,59
public Plane(final Vector3D p, final Vector3D normal) throws MathArithmeticException { [EOL]     setNormal(normal); [EOL]     originOffset = -p.dotProduct(w); [EOL]     setFrame(); [EOL] } <line_num>: 66,70
public Plane(final Vector3D p1, final Vector3D p2, final Vector3D p3) throws MathArithmeticException { [EOL]     this(p1, p2.subtract(p1).crossProduct(p3.subtract(p1))); [EOL] } <line_num>: 80,83
public Plane(final Plane plane) { [EOL]     originOffset = plane.originOffset; [EOL]     origin = plane.origin; [EOL]     u = plane.u; [EOL]     v = plane.v; [EOL]     w = plane.w; [EOL] } <line_num>: 91,97
public Plane copySelf() { [EOL]     return new Plane(this); [EOL] } <line_num>: 105,107
public void reset(final Vector3D p, final Vector3D normal) throws MathArithmeticException { [EOL]     setNormal(normal); [EOL]     originOffset = -p.dotProduct(w); [EOL]     setFrame(); [EOL] } <line_num>: 114,118
public void reset(final Plane original) { [EOL]     originOffset = original.originOffset; [EOL]     origin = original.origin; [EOL]     u = original.u; [EOL]     v = original.v; [EOL]     w = original.w; [EOL] } <line_num>: 126,132
private void setNormal(final Vector3D normal) throws MathArithmeticException { [EOL]     final double norm = normal.getNorm(); [EOL]     if (norm < 1.0e-10) { [EOL]         throw new MathArithmeticException(LocalizedFormats.ZERO_NORM); [EOL]     } [EOL]     w = new Vector3D(1.0 / norm, normal); [EOL] } <line_num>: 138,144
private void setFrame() { [EOL]     origin = new Vector3D(-originOffset, w); [EOL]     u = w.orthogonal(); [EOL]     v = Vector3D.crossProduct(w, u); [EOL] } <line_num>: 148,152
public Vector3D getOrigin() { [EOL]     return origin; [EOL] } <line_num>: 160,162
public Vector3D getNormal() { [EOL]     return w; [EOL] } <line_num>: 172,174
public Vector3D getU() { [EOL]     return u; [EOL] } <line_num>: 184,186
public Vector3D getV() { [EOL]     return v; [EOL] } <line_num>: 196,198
public void revertSelf() { [EOL]     final Vector3D tmp = u; [EOL]     u = v; [EOL]     v = tmp; [EOL]     w = w.negate(); [EOL]     originOffset = -originOffset; [EOL] } <line_num>: 211,217
public Vector2D toSubSpace(final Vector<Euclidean3D> point) { [EOL]     return new Vector2D(point.dotProduct(u), point.dotProduct(v)); [EOL] } <line_num>: 226,228
public Vector3D toSpace(final Vector<Euclidean2D> point) { [EOL]     final Vector2D p2D = (Vector2D) point; [EOL]     return new Vector3D(p2D.getX(), u, p2D.getY(), v, -originOffset, w); [EOL] } <line_num>: 236,239
public Vector3D getPointAt(final Vector2D inPlane, final double offset) { [EOL]     return new Vector3D(inPlane.getX(), u, inPlane.getY(), v, offset - originOffset, w); [EOL] } <line_num>: 248,250
public boolean isSimilarTo(final Plane plane) { [EOL]     final double angle = Vector3D.angle(w, plane.w); [EOL]     return ((angle < 1.0e-10) && (FastMath.abs(originOffset - plane.originOffset) < 1.0e-10)) || ((angle > (FastMath.PI - 1.0e-10)) && (FastMath.abs(originOffset + plane.originOffset) < 1.0e-10)); [EOL] } <line_num>: 259,263
public Plane rotate(final Vector3D center, final Rotation rotation) { [EOL]     final Vector3D delta = origin.subtract(center); [EOL]     final Plane plane = new Plane(center.add(rotation.applyTo(delta)), rotation.applyTo(w)); [EOL]     plane.u = rotation.applyTo(u); [EOL]     plane.v = rotation.applyTo(v); [EOL]     return plane; [EOL] } <line_num>: 271,283
public Plane translate(final Vector3D translation) { [EOL]     final Plane plane = new Plane(origin.add(translation), w); [EOL]     plane.u = u; [EOL]     plane.v = v; [EOL]     return plane; [EOL] } <line_num>: 290,300
public Vector3D intersection(final Line line) { [EOL]     final Vector3D direction = line.getDirection(); [EOL]     final double dot = w.dotProduct(direction); [EOL]     if (FastMath.abs(dot) < 1.0e-10) { [EOL]         return null; [EOL]     } [EOL]     final Vector3D point = line.toSpace(Vector1D.ZERO); [EOL]     final double k = -(originOffset + w.dotProduct(point)) / dot; [EOL]     return new Vector3D(1.0, point, k, direction); [EOL] } <line_num>: 307,316
public Line intersection(final Plane other) { [EOL]     final Vector3D direction = Vector3D.crossProduct(w, other.w); [EOL]     if (direction.getNorm() < 1.0e-10) { [EOL]         return null; [EOL]     } [EOL]     final Vector3D point = intersection(this, other, new Plane(direction)); [EOL]     return new Line(point, point.add(direction)); [EOL] } <line_num>: 323,330
public static Vector3D intersection(final Plane plane1, final Plane plane2, final Plane plane3) { [EOL]     final double a1 = plane1.w.getX(); [EOL]     final double b1 = plane1.w.getY(); [EOL]     final double c1 = plane1.w.getZ(); [EOL]     final double d1 = plane1.originOffset; [EOL]     final double a2 = plane2.w.getX(); [EOL]     final double b2 = plane2.w.getY(); [EOL]     final double c2 = plane2.w.getZ(); [EOL]     final double d2 = plane2.originOffset; [EOL]     final double a3 = plane3.w.getX(); [EOL]     final double b3 = plane3.w.getY(); [EOL]     final double c3 = plane3.w.getZ(); [EOL]     final double d3 = plane3.originOffset; [EOL]     final double a23 = b2 * c3 - b3 * c2; [EOL]     final double b23 = c2 * a3 - c3 * a2; [EOL]     final double c23 = a2 * b3 - a3 * b2; [EOL]     final double determinant = a1 * a23 + b1 * b23 + c1 * c23; [EOL]     if (FastMath.abs(determinant) < 1.0e-10) { [EOL]         return null; [EOL]     } [EOL]     final double r = 1.0 / determinant; [EOL]     return new Vector3D((-a23 * d1 - (c1 * b3 - c3 * b1) * d2 - (c2 * b1 - c1 * b2) * d3) * r, (-b23 * d1 - (c3 * a1 - c1 * a3) * d2 - (c1 * a2 - c2 * a1) * d3) * r, (-c23 * d1 - (b1 * a3 - b3 * a1) * d2 - (b2 * a1 - b1 * a2) * d3) * r); [EOL] } <line_num>: 338,372
public SubPlane wholeHyperplane() { [EOL]     return new SubPlane(this, new PolygonsSet()); [EOL] } <line_num>: 377,379
public PolyhedronsSet wholeSpace() { [EOL]     return new PolyhedronsSet(); [EOL] } <line_num>: 385,387
public boolean contains(final Vector3D p) { [EOL]     return FastMath.abs(getOffset(p)) < 1.0e-10; [EOL] } <line_num>: 393,395
public double getOffset(final Plane plane) { [EOL]     return originOffset + (sameOrientationAs(plane) ? -plane.originOffset : plane.originOffset); [EOL] } <line_num>: 407,409
public double getOffset(final Vector<Euclidean3D> point) { [EOL]     return point.dotProduct(w) + originOffset; [EOL] } <line_num>: 419,421
public boolean sameOrientationAs(final Hyperplane<Euclidean3D> other) { [EOL]     return (((Plane) other).w).dotProduct(w) > 0.0; [EOL] } <line_num>: 428,430