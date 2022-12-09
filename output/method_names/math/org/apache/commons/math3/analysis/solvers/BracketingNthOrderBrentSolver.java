public BracketingNthOrderBrentSolver()
public BracketingNthOrderBrentSolver(final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException
public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException
public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy, final int maximalOrder) throws NumberIsTooSmallException
public int getMaximalOrder()
protected double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException
private double guessX(final double targetY, final double[] x, final double[] y, final int start, final int end)
public double solve(int maxEval, UnivariateFunction f, double min, double max, AllowedSolution allowedSolution) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException
public double solve(int maxEval, UnivariateFunction f, double min, double max, double startValue, AllowedSolution allowedSolution) throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException
