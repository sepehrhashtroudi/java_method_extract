@Test [EOL] public void testSumSinc() { [EOL]     final MultivariateFunction func = new SumSincFunction(-1); [EOL]     int dim = 2; [EOL]     final double[] minPoint = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         minPoint[i] = 0; [EOL]     } [EOL]     double[] init = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = minPoint[i]; [EOL]     } [EOL]     doTest(func, minPoint, init, GoalType.MINIMIZE, 1e-9, 1e-9); [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = minPoint[i] + 3; [EOL]     } [EOL]     doTest(func, minPoint, init, GoalType.MINIMIZE, 1e-9, 1e-5); [EOL]     doTest(func, minPoint, init, GoalType.MINIMIZE, 1e-9, 1e-9, 1e-7); [EOL] } <line_num>: 33,59
public double value(double[] x) { [EOL]     final double a = x[0] - 1; [EOL]     final double b = x[1] - 1; [EOL]     return a * a + b * b + 1; [EOL] } <line_num>: 64,68
@Test [EOL] public void testQuadratic() { [EOL]     final MultivariateFunction func = new MultivariateFunction() { [EOL]  [EOL]         public double value(double[] x) { [EOL]             final double a = x[0] - 1; [EOL]             final double b = x[1] - 1; [EOL]             return a * a + b * b + 1; [EOL]         } [EOL]     }; [EOL]     int dim = 2; [EOL]     final double[] minPoint = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         minPoint[i] = 1; [EOL]     } [EOL]     double[] init = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = minPoint[i]; [EOL]     } [EOL]     doTest(func, minPoint, init, GoalType.MINIMIZE, 1e-9, 1e-8); [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = minPoint[i] - 20; [EOL]     } [EOL]     doTest(func, minPoint, init, GoalType.MINIMIZE, 1e-9, 1e-8); [EOL] } <line_num>: 61,90
public double value(double[] x) { [EOL]     final double a = x[0] - 1; [EOL]     final double b = x[1] - 1; [EOL]     return -a * a - b * b + 1; [EOL] } <line_num>: 95,99
@Test [EOL] public void testMaximizeQuadratic() { [EOL]     final MultivariateFunction func = new MultivariateFunction() { [EOL]  [EOL]         public double value(double[] x) { [EOL]             final double a = x[0] - 1; [EOL]             final double b = x[1] - 1; [EOL]             return -a * a - b * b + 1; [EOL]         } [EOL]     }; [EOL]     int dim = 2; [EOL]     final double[] maxPoint = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         maxPoint[i] = 1; [EOL]     } [EOL]     double[] init = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = maxPoint[i]; [EOL]     } [EOL]     doTest(func, maxPoint, init, GoalType.MAXIMIZE, 1e-9, 1e-8); [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = maxPoint[i] - 20; [EOL]     } [EOL]     doTest(func, maxPoint, init, GoalType.MAXIMIZE, 1e-9, 1e-8); [EOL] } <line_num>: 92,121
public double value(double[] x) { [EOL]     final double a = x[0] - 1; [EOL]     final double b = x[1] - 1; [EOL]     return a * a * FastMath.sqrt(FastMath.abs(a)) + b * b + 1; [EOL] } <line_num>: 133,137
public double value(double[] x) { [EOL]     return scale * func.value(x); [EOL] } <line_num>: 165,167
@Test [EOL] public void testRelativeToleranceOnScaledValues() { [EOL]     final MultivariateFunction func = new MultivariateFunction() { [EOL]  [EOL]         public double value(double[] x) { [EOL]             final double a = x[0] - 1; [EOL]             final double b = x[1] - 1; [EOL]             return a * a * FastMath.sqrt(FastMath.abs(a)) + b * b + 1; [EOL]         } [EOL]     }; [EOL]     int dim = 2; [EOL]     final double[] minPoint = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         minPoint[i] = 1; [EOL]     } [EOL]     double[] init = new double[dim]; [EOL]     for (int i = 0; i < dim; i++) { [EOL]         init[i] = minPoint[i] - 20; [EOL]     } [EOL]     final double relTol = 1e-10; [EOL]     final int maxEval = 1000; [EOL]     final MultivariateOptimizer optim = new PowellOptimizer(relTol, 1e-100); [EOL]     final PointValuePair funcResult = optim.optimize(maxEval, func, GoalType.MINIMIZE, init); [EOL]     final double funcValue = func.value(funcResult.getPoint()); [EOL]     final int funcEvaluations = optim.getEvaluations(); [EOL]     final double scale = 1e10; [EOL]     final MultivariateFunction funcScaled = new MultivariateFunction() { [EOL]  [EOL]         public double value(double[] x) { [EOL]             return scale * func.value(x); [EOL]         } [EOL]     }; [EOL]     final PointValuePair funcScaledResult = optim.optimize(maxEval, funcScaled, GoalType.MINIMIZE, init); [EOL]     final double funcScaledValue = funcScaled.value(funcScaledResult.getPoint()); [EOL]     final int funcScaledEvaluations = optim.getEvaluations(); [EOL]     Assert.assertEquals(1, funcScaledValue / (scale * funcValue), relTol); [EOL]     Assert.assertEquals(funcEvaluations, funcScaledEvaluations); [EOL] } <line_num>: 130,180
private void doTest(MultivariateFunction func, double[] optimum, double[] init, GoalType goal, double fTol, double pointTol) { [EOL]     final MultivariateOptimizer optim = new PowellOptimizer(fTol, Math.ulp(1d)); [EOL]     final PointValuePair result = optim.optimize(1000, func, goal, init); [EOL]     final double[] point = result.getPoint(); [EOL]     for (int i = 0, dim = optimum.length; i < dim; i++) { [EOL]         Assert.assertEquals("found[" + i + "]=" + point[i] + " value=" + result.getValue(), optimum[i], point[i], pointTol); [EOL]     } [EOL] } <line_num>: 191,206
private void doTest(MultivariateFunction func, double[] optimum, double[] init, GoalType goal, double fTol, double fLineTol, double pointTol) { [EOL]     final MultivariateOptimizer optim = new PowellOptimizer(fTol, Math.ulp(1d), fLineTol, Math.ulp(1d)); [EOL]     final PointValuePair result = optim.optimize(1000, func, goal, init); [EOL]     final double[] point = result.getPoint(); [EOL]     for (int i = 0, dim = optimum.length; i < dim; i++) { [EOL]         Assert.assertEquals("found[" + i + "]=" + point[i] + " value=" + result.getValue(), optimum[i], point[i], pointTol); [EOL]     } [EOL] } <line_num>: 219,236