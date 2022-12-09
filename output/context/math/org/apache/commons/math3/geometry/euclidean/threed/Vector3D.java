public Vector3D(double x, double y, double z)
public Vector3D(double[] v) throws DimensionMismatchException
public Vector3D(double alpha, double delta)
public Vector3D(double a, Vector3D u)
public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2)
public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3)
public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3, double a4, Vector3D u4)
public double getX()
public double getY()
public double getZ()
public double[] toArray()
public Space getSpace()
public Vector3D getZero()
public double getNorm1()
public double getNorm()
public double getNormSq()
public double getNormInf()
public double getAlpha()
public double getDelta()
public Vector3D add(final Vector<Euclidean3D> v)
public Vector3D add(double factor, final Vector<Euclidean3D> v)
public Vector3D subtract(final Vector<Euclidean3D> v)
public Vector3D subtract(final double factor, final Vector<Euclidean3D> v)
public Vector3D normalize() throws MathArithmeticException
public Vector3D orthogonal() throws MathArithmeticException
public static double angle(Vector3D v1, Vector3D v2) throws MathArithmeticException
public Vector3D negate()
public Vector3D scalarMultiply(double a)
public boolean isNaN()
public boolean isInfinite()
public boolean equals(Object other)
public int hashCode()
public double dotProduct(final Vector<Euclidean3D> v)
public Vector3D crossProduct(final Vector<Euclidean3D> v)
public double distance1(Vector<Euclidean3D> v)
public double distance(Vector<Euclidean3D> v)
public double distanceInf(Vector<Euclidean3D> v)
public double distanceSq(Vector<Euclidean3D> v)
public static double dotProduct(Vector3D v1, Vector3D v2)
public static Vector3D crossProduct(final Vector3D v1, final Vector3D v2)
public static double distance1(Vector3D v1, Vector3D v2)
public static double distance(Vector3D v1, Vector3D v2)
public static double distanceInf(Vector3D v1, Vector3D v2)
public static double distanceSq(Vector3D v1, Vector3D v2)
public String toString()
public String toString(final NumberFormat format)
Vector3D ZERO=Optional[new Vector3D(0, 0, 0)]
Vector3D PLUS_I=Optional[new Vector3D(1, 0, 0)]
Vector3D MINUS_I=Optional[new Vector3D(-1, 0, 0)]
Vector3D PLUS_J=Optional[new Vector3D(0, 1, 0)]
Vector3D MINUS_J=Optional[new Vector3D(0, -1, 0)]
Vector3D PLUS_K=Optional[new Vector3D(0, 0, 1)]
Vector3D MINUS_K=Optional[new Vector3D(0, 0, -1)]
Vector3D NaN=Optional[new Vector3D(Double.NaN, Double.NaN, Double.NaN)]
Vector3D POSITIVE_INFINITY=Optional[new Vector3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)]
Vector3D NEGATIVE_INFINITY=Optional[new Vector3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)]
long serialVersionUID=Optional[1313493323784566947L]
double x
double y
double z
