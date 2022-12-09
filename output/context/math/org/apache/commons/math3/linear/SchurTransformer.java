public SchurTransformer(final RealMatrix matrix)
public RealMatrix getP()
public RealMatrix getPT()
public RealMatrix getT()
private void transform()
private double getNorm()
private int findSmallSubDiagonalElement(final int startIdx, final double norm)
private void computeShift(final int l, final int idx, final int iteration, final ShiftInfo shift)
private int initQRStep(int il, final int iu, final ShiftInfo shift, double[] hVec)
private void performDoubleQRStep(final int il, final int im, final int iu, final ShiftInfo shift, final double[] hVec)
int MAX_ITERATIONS=Optional[100]
double[][] matrixP
double[][] matrixT
RealMatrix cachedP
RealMatrix cachedT
RealMatrix cachedPt
double epsilon=Optional[Precision.EPSILON]
