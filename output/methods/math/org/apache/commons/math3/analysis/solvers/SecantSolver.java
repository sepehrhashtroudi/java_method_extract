public SecantSolver() { [EOL]     super(DEFAULT_ABSOLUTE_ACCURACY); [EOL] } <line_num>: 49,51
public SecantSolver(final double absoluteAccuracy) { [EOL]     super(absoluteAccuracy); [EOL] } <line_num>: 58,60
public SecantSolver(final double relativeAccuracy, final double absoluteAccuracy) { [EOL]     super(relativeAccuracy, absoluteAccuracy); [EOL] } <line_num>: 68,71
@Override [EOL] protected final double doSolve() throws TooManyEvaluationsException, NoBracketingException { [EOL]     double x0 = getMin(); [EOL]     double x1 = getMax(); [EOL]     double f0 = computeObjectiveValue(x0); [EOL]     double f1 = computeObjectiveValue(x1); [EOL]     if (f0 == 0.0) { [EOL]         return x0; [EOL]     } [EOL]     if (f1 == 0.0) { [EOL]         return x1; [EOL]     } [EOL]     verifyBracketing(x0, x1); [EOL]     final double ftol = getFunctionValueAccuracy(); [EOL]     final double atol = getAbsoluteAccuracy(); [EOL]     final double rtol = getRelativeAccuracy(); [EOL]     while (true) { [EOL]         final double x = x1 - ((f1 * (x1 - x0)) / (f1 - f0)); [EOL]         final double fx = computeObjectiveValue(x); [EOL]         if (fx == 0.0) { [EOL]             return x; [EOL]         } [EOL]         x0 = x1; [EOL]         f0 = f1; [EOL]         x1 = x; [EOL]         f1 = fx; [EOL]         if (FastMath.abs(f1) <= ftol) { [EOL]             return x1; [EOL]         } [EOL]         if (FastMath.abs(x1 - x0) < FastMath.max(rtol * FastMath.abs(x1), atol)) { [EOL]             return x1; [EOL]         } [EOL]     } [EOL] } <line_num>: 74,134
