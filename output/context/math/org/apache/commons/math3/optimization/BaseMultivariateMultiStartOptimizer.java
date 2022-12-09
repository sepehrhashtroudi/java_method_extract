protected BaseMultivariateMultiStartOptimizer(final BaseMultivariateOptimizer<FUNC> optimizer, final int starts, final RandomVectorGenerator generator)
public PointValuePair[] getOptima()
public int getMaxEvaluations()
public int getEvaluations()
public ConvergenceChecker<PointValuePair> getConvergenceChecker()
public PointValuePair optimize(int maxEval, final FUNC f, final GoalType goal, double[] startPoint)
public int compare(final PointValuePair o1, final PointValuePair o2)
private void sortPairs(final GoalType goal)
BaseMultivariateOptimizer<FUNC> optimizer
int maxEvaluations
int totalEvaluations
int starts
RandomVectorGenerator generator
PointValuePair[] optima
