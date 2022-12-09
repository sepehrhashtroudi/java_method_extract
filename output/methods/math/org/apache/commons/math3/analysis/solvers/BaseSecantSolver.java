protected BaseSecantSolver(final double absoluteAccuracy, final Method method) { [EOL]     super(absoluteAccuracy); [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL]     this.method = method; [EOL] } <line_num>: 68,72
protected BaseSecantSolver(final double relativeAccuracy, final double absoluteAccuracy, final Method method) { [EOL]     super(relativeAccuracy, absoluteAccuracy); [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL]     this.method = method; [EOL] } <line_num>: 81,87
protected BaseSecantSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy, final Method method) { [EOL]     super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy); [EOL]     this.allowed = AllowedSolution.ANY_SIDE; [EOL]     this.method = method; [EOL] } <line_num>: 97,104
public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final AllowedSolution allowedSolution) { [EOL]     return solve(maxEval, f, min, max, min + 0.5 * (max - min), allowedSolution); [EOL] } <line_num>: 107,111
public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final double startValue, final AllowedSolution allowedSolution) { [EOL]     this.allowed = allowedSolution; [EOL]     return super.solve(maxEval, f, min, max, startValue); [EOL] } <line_num>: 114,119
@Override [EOL] public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final double startValue) { [EOL]     return solve(maxEval, f, min, max, startValue, AllowedSolution.ANY_SIDE); [EOL] } <line_num>: 122,126
@Override [EOL] protected final double doSolve() throws ConvergenceException { [EOL]     double x0 = getMin(); [EOL]     double x1 = getMax(); [EOL]     double f0 = computeObjectiveValue(x0); [EOL]     double f1 = computeObjectiveValue(x1); [EOL]     if (f0 == 0.0) { [EOL]         return x0; [EOL]     } [EOL]     if (f1 == 0.0) { [EOL]         return x1; [EOL]     } [EOL]     verifyBracketing(x0, x1); [EOL]     final double ftol = getFunctionValueAccuracy(); [EOL]     final double atol = getAbsoluteAccuracy(); [EOL]     final double rtol = getRelativeAccuracy(); [EOL]     boolean inverted = false; [EOL]     while (true) { [EOL]         final double x = x1 - ((f1 * (x1 - x0)) / (f1 - f0)); [EOL]         final double fx = computeObjectiveValue(x); [EOL]         if (fx == 0.0) { [EOL]             return x; [EOL]         } [EOL]         if (f1 * fx < 0) { [EOL]             x0 = x1; [EOL]             f0 = f1; [EOL]             inverted = !inverted; [EOL]         } else { [EOL]             switch(method) { [EOL]                 case ILLINOIS: [EOL]                     f0 *= 0.5; [EOL]                     break; [EOL]                 case PEGASUS: [EOL]                     f0 *= f1 / (f1 + fx); [EOL]                     break; [EOL]                 case REGULA_FALSI: [EOL]                     if (x == x1) { [EOL]                         throw new ConvergenceException(); [EOL]                     } [EOL]                     break; [EOL]                 default: [EOL]                     throw new MathInternalError(); [EOL]             } [EOL]         } [EOL]         x1 = x; [EOL]         f1 = fx; [EOL]         if (FastMath.abs(f1) <= ftol) { [EOL]             switch(allowed) { [EOL]                 case ANY_SIDE: [EOL]                     return x1; [EOL]                 case LEFT_SIDE: [EOL]                     if (inverted) { [EOL]                         return x1; [EOL]                     } [EOL]                     break; [EOL]                 case RIGHT_SIDE: [EOL]                     if (!inverted) { [EOL]                         return x1; [EOL]                     } [EOL]                     break; [EOL]                 case BELOW_SIDE: [EOL]                     if (f1 <= 0) { [EOL]                         return x1; [EOL]                     } [EOL]                     break; [EOL]                 case ABOVE_SIDE: [EOL]                     if (f1 >= 0) { [EOL]                         return x1; [EOL]                     } [EOL]                     break; [EOL]                 default: [EOL]                     throw new MathInternalError(); [EOL]             } [EOL]         } [EOL]         if (FastMath.abs(x1 - x0) < FastMath.max(rtol * FastMath.abs(x1), atol)) { [EOL]             switch(allowed) { [EOL]                 case ANY_SIDE: [EOL]                     return x1; [EOL]                 case LEFT_SIDE: [EOL]                     return inverted ? x1 : x0; [EOL]                 case RIGHT_SIDE: [EOL]                     return inverted ? x0 : x1; [EOL]                 case BELOW_SIDE: [EOL]                     return (f1 <= 0) ? x1 : x0; [EOL]                 case ABOVE_SIDE: [EOL]                     return (f1 >= 0) ? x1 : x0; [EOL]                 default: [EOL]                     throw new MathInternalError(); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 134,261
