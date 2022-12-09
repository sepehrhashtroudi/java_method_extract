public MullerSolver()
public MullerSolver(double absoluteAccuracy)
public MullerSolver(double relativeAccuracy, double absoluteAccuracy)
protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException
private double solve(double min, double max, double fMin, double fMax) throws TooManyEvaluationsException
double DEFAULT_ABSOLUTE_ACCURACY=Optional[1e-6]
