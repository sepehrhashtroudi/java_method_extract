public LegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws MathIllegalArgumentException, NotStrictlyPositiveException, NumberIsTooSmallException { [EOL]     super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount); [EOL]     switch(n) { [EOL]         case 2: [EOL]             abscissas = ABSCISSAS_2; [EOL]             weights = WEIGHTS_2; [EOL]             break; [EOL]         case 3: [EOL]             abscissas = ABSCISSAS_3; [EOL]             weights = WEIGHTS_3; [EOL]             break; [EOL]         case 4: [EOL]             abscissas = ABSCISSAS_4; [EOL]             weights = WEIGHTS_4; [EOL]             break; [EOL]         case 5: [EOL]             abscissas = ABSCISSAS_5; [EOL]             weights = WEIGHTS_5; [EOL]             break; [EOL]         default: [EOL]             throw new MathIllegalArgumentException(LocalizedFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, n, 2, 5); [EOL]     } [EOL] } <line_num>: 137,167
public LegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy) throws MathIllegalArgumentException { [EOL]     this(n, relativeAccuracy, absoluteAccuracy, DEFAULT_MIN_ITERATIONS_COUNT, DEFAULT_MAX_ITERATIONS_COUNT); [EOL] } <line_num>: 176,182
public LegendreGaussIntegrator(final int n, final int minimalIterationCount, final int maximalIterationCount) throws MathIllegalArgumentException { [EOL]     this(n, DEFAULT_RELATIVE_ACCURACY, DEFAULT_ABSOLUTE_ACCURACY, minimalIterationCount, maximalIterationCount); [EOL] } <line_num>: 195,201
@Override [EOL] protected double doIntegrate() throws MathIllegalArgumentException, TooManyEvaluationsException, MaxCountExceededException { [EOL]     double oldt = stage(1); [EOL]     int n = 2; [EOL]     while (true) { [EOL]         final double t = stage(n); [EOL]         final double delta = FastMath.abs(t - oldt); [EOL]         final double limit = FastMath.max(getAbsoluteAccuracy(), getRelativeAccuracy() * (FastMath.abs(oldt) + FastMath.abs(t)) * 0.5); [EOL]         if ((iterations.getCount() + 1 >= getMinimalIterationCount()) && (delta <= limit)) { [EOL]             return t; [EOL]         } [EOL]         double ratio = FastMath.min(4, FastMath.pow(delta / limit, 0.5 / abscissas.length)); [EOL]         n = FastMath.max((int) (ratio * n), n + 1); [EOL]         oldt = t; [EOL]         iterations.incrementCount(); [EOL]     } [EOL] } <line_num>: 204,236
private double stage(final int n) throws TooManyEvaluationsException { [EOL]     final double step = (getMax() - getMin()) / n; [EOL]     final double halfStep = step / 2.0; [EOL]     double midPoint = getMin() + halfStep; [EOL]     double sum = 0.0; [EOL]     for (int i = 0; i < n; ++i) { [EOL]         for (int j = 0; j < abscissas.length; ++j) { [EOL]             sum += weights[j] * computeObjectiveValue(midPoint + halfStep * abscissas[j]); [EOL]         } [EOL]         midPoint += step; [EOL]     } [EOL]     return halfStep * sum; [EOL] } <line_num>: 245,264