@Override [EOL] protected PointVectorValuePair doOptimize() { [EOL]     final double[] params = getStartPoint(); [EOL]     final double[] res = computeResiduals(computeObjectiveValue(params)); [EOL]     setCost(computeCost(res)); [EOL]     return new PointVectorValuePair(params, null); [EOL] } <line_num>: 30,36
public static AbstractLeastSquaresOptimizer createOptimizer() { [EOL]     return new AbstractLeastSquaresOptimizer(null) { [EOL]  [EOL]         @Override [EOL]         protected PointVectorValuePair doOptimize() { [EOL]             final double[] params = getStartPoint(); [EOL]             final double[] res = computeResiduals(computeObjectiveValue(params)); [EOL]             setCost(computeCost(res)); [EOL]             return new PointVectorValuePair(params, null); [EOL]         } [EOL]     }; [EOL] } <line_num>: 27,38
@Test [EOL] public void testGetChiSquare() throws IOException { [EOL]     final StatisticalReferenceDataset dataset; [EOL]     dataset = StatisticalReferenceDatasetFactory.createKirby2(); [EOL]     final AbstractLeastSquaresOptimizer optimizer; [EOL]     optimizer = createOptimizer(); [EOL]     final double[] a = dataset.getParameters(); [EOL]     final double[] y = dataset.getData()[1]; [EOL]     final double[] w = new double[y.length]; [EOL]     Arrays.fill(w, 1.0); [EOL]     optimizer.optimize(1, dataset.getLeastSquaresProblem(), y, w, a); [EOL]     final double expected = dataset.getResidualSumOfSquares(); [EOL]     final double actual = optimizer.getChiSquare(); [EOL]     Assert.assertEquals(dataset.getName(), expected, actual, 1E-11 * expected); [EOL] } <line_num>: 40,56
@Test [EOL] public void testGetRMS() throws IOException { [EOL]     final StatisticalReferenceDataset dataset; [EOL]     dataset = StatisticalReferenceDatasetFactory.createKirby2(); [EOL]     final AbstractLeastSquaresOptimizer optimizer; [EOL]     optimizer = createOptimizer(); [EOL]     final double[] a = dataset.getParameters(); [EOL]     final double[] y = dataset.getData()[1]; [EOL]     final double[] w = new double[y.length]; [EOL]     Arrays.fill(w, 1.0); [EOL]     optimizer.optimize(1, dataset.getLeastSquaresProblem(), y, w, a); [EOL]     final double expected = FastMath.sqrt(dataset.getResidualSumOfSquares() / dataset.getNumObservations()); [EOL]     final double actual = optimizer.getRMS(); [EOL]     Assert.assertEquals(dataset.getName(), expected, actual, 1E-11 * expected); [EOL] } <line_num>: 58,76
@Test [EOL] public void testComputeSigma() throws IOException { [EOL]     final StatisticalReferenceDataset dataset; [EOL]     dataset = StatisticalReferenceDatasetFactory.createKirby2(); [EOL]     final AbstractLeastSquaresOptimizer optimizer; [EOL]     optimizer = createOptimizer(); [EOL]     final double[] a = dataset.getParameters(); [EOL]     final double[] y = dataset.getData()[1]; [EOL]     final double[] w = new double[y.length]; [EOL]     Arrays.fill(w, 1.0); [EOL]     final int dof = y.length - a.length; [EOL]     final PointVectorValuePair optimum = optimizer.optimize(1, dataset.getLeastSquaresProblem(), y, w, a); [EOL]     final double[] sig = optimizer.computeSigma(optimum.getPoint(), 1e-14); [EOL]     final double[] expected = dataset.getParametersStandardDeviations(); [EOL]     for (int i = 0; i < sig.length; i++) { [EOL]         final double actual = FastMath.sqrt(optimizer.getChiSquare() / dof) * sig[i]; [EOL]         Assert.assertEquals(dataset.getName() + ", parameter #" + i, expected[i], actual, 1e-7 * expected[i]); [EOL]     } [EOL] } <line_num>: 78,98
