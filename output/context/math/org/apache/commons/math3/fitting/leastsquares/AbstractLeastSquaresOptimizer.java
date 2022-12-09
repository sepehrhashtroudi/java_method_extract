protected AbstractLeastSquaresOptimizer()
protected AbstractLeastSquaresOptimizer(AbstractLeastSquaresOptimizer other)
public OPTIM withTarget(double[] newTarget)
public OPTIM withWeight(RealMatrix newWeight)
public OPTIM withModelAndJacobian(MultivariateVectorFunction newModel, MultivariateMatrixFunction newJacobian)
public OPTIM withStartPoint(double[] newStart)
public double[] getTarget()
public double[] getStart()
public RealMatrix getWeightSquareRoot()
public MultivariateVectorFunction getModel()
public MultivariateMatrixFunction getJacobian()
public double[][] computeCovariances(double[] params, double threshold)
public double[] computeSigma(double[] params, double covarianceSingularityThreshold)
public RealMatrix getWeight()
public double computeRMS(double[] params)
protected double[] computeObjectiveValue(double[] params)
protected RealMatrix computeWeightedJacobian(double[] params)
protected double[][] computeJacobian(final double[] params)
protected double computeCost(double[] residuals)
protected double[] computeResiduals(double[] objectiveValue)
private RealMatrix squareRoot(RealMatrix m)
double[] target
RealMatrix weight
MultivariateVectorFunction model
MultivariateMatrixFunction jacobian
RealMatrix weightSqrt
double[] start
