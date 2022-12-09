public BiQuadratic(final double xOptimum, final double yOptimum, final double xMin, final double xMax, final double yMin, final double yMax) { [EOL]     this.xOptimum = xOptimum; [EOL]     this.yOptimum = yOptimum; [EOL]     this.xMin = xMin; [EOL]     this.xMax = xMax; [EOL]     this.yMin = yMin; [EOL]     this.yMax = yMax; [EOL] } <line_num>: 149,158
@Test [EOL] public void testStartSimplexInsideRange() { [EOL]     final BiQuadratic biQuadratic = new BiQuadratic(2.0, 2.5, 1.0, 3.0, 2.0, 3.0); [EOL]     final MultivariateFunctionPenaltyAdapter wrapped = new MultivariateFunctionPenaltyAdapter(biQuadratic, biQuadratic.getLower(), biQuadratic.getUpper(), 1000.0, new double[] { 100.0, 100.0 }); [EOL]     SimplexOptimizer optimizer = new SimplexOptimizer(1e-10, 1e-30); [EOL]     optimizer.setSimplex(new NelderMeadSimplex(new double[] { 1.0, 0.5 })); [EOL]     final PointValuePair optimum = optimizer.optimize(300, wrapped, GoalType.MINIMIZE, new double[] { 1.5, 2.25 }); [EOL]     Assert.assertEquals(biQuadratic.getBoundedXOptimum(), optimum.getPoint()[0], 2e-7); [EOL]     Assert.assertEquals(biQuadratic.getBoundedYOptimum(), optimum.getPoint()[1], 2e-7); [EOL] } <line_num>: 30,49
@Test [EOL] public void testStartSimplexOutsideRange() { [EOL]     final BiQuadratic biQuadratic = new BiQuadratic(2.0, 2.5, 1.0, 3.0, 2.0, 3.0); [EOL]     final MultivariateFunctionPenaltyAdapter wrapped = new MultivariateFunctionPenaltyAdapter(biQuadratic, biQuadratic.getLower(), biQuadratic.getUpper(), 1000.0, new double[] { 100.0, 100.0 }); [EOL]     SimplexOptimizer optimizer = new SimplexOptimizer(1e-10, 1e-30); [EOL]     optimizer.setSimplex(new NelderMeadSimplex(new double[] { 1.0, 0.5 })); [EOL]     final PointValuePair optimum = optimizer.optimize(300, wrapped, GoalType.MINIMIZE, new double[] { -1.5, 4.0 }); [EOL]     Assert.assertEquals(biQuadratic.getBoundedXOptimum(), optimum.getPoint()[0], 2e-7); [EOL]     Assert.assertEquals(biQuadratic.getBoundedYOptimum(), optimum.getPoint()[1], 2e-7); [EOL] } <line_num>: 51,70
@Test [EOL] public void testOptimumOutsideRange() { [EOL]     final BiQuadratic biQuadratic = new BiQuadratic(4.0, 0.0, 1.0, 3.0, 2.0, 3.0); [EOL]     final MultivariateFunctionPenaltyAdapter wrapped = new MultivariateFunctionPenaltyAdapter(biQuadratic, biQuadratic.getLower(), biQuadratic.getUpper(), 1000.0, new double[] { 100.0, 100.0 }); [EOL]     SimplexOptimizer optimizer = new SimplexOptimizer(new SimplePointChecker<PointValuePair>(1.0e-11, 1.0e-20)); [EOL]     optimizer.setSimplex(new NelderMeadSimplex(new double[] { 1.0, 0.5 })); [EOL]     final PointValuePair optimum = optimizer.optimize(600, wrapped, GoalType.MINIMIZE, new double[] { -1.5, 4.0 }); [EOL]     Assert.assertEquals(biQuadratic.getBoundedXOptimum(), optimum.getPoint()[0], 2e-7); [EOL]     Assert.assertEquals(biQuadratic.getBoundedYOptimum(), optimum.getPoint()[1], 2e-7); [EOL] } <line_num>: 72,91
@Test [EOL] public void testUnbounded() { [EOL]     final BiQuadratic biQuadratic = new BiQuadratic(4.0, 0.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY); [EOL]     final MultivariateFunctionPenaltyAdapter wrapped = new MultivariateFunctionPenaltyAdapter(biQuadratic, biQuadratic.getLower(), biQuadratic.getUpper(), 1000.0, new double[] { 100.0, 100.0 }); [EOL]     SimplexOptimizer optimizer = new SimplexOptimizer(1e-10, 1e-30); [EOL]     optimizer.setSimplex(new NelderMeadSimplex(new double[] { 1.0, 0.5 })); [EOL]     final PointValuePair optimum = optimizer.optimize(300, wrapped, GoalType.MINIMIZE, new double[] { -1.5, 4.0 }); [EOL]     Assert.assertEquals(biQuadratic.getBoundedXOptimum(), optimum.getPoint()[0], 2e-7); [EOL]     Assert.assertEquals(biQuadratic.getBoundedYOptimum(), optimum.getPoint()[1], 2e-7); [EOL] } <line_num>: 93,114
@Test [EOL] public void testHalfBounded() { [EOL]     final BiQuadratic biQuadratic = new BiQuadratic(4.0, 4.0, 1.0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0); [EOL]     final MultivariateFunctionPenaltyAdapter wrapped = new MultivariateFunctionPenaltyAdapter(biQuadratic, biQuadratic.getLower(), biQuadratic.getUpper(), 1000.0, new double[] { 100.0, 100.0 }); [EOL]     SimplexOptimizer optimizer = new SimplexOptimizer(new SimplePointChecker<PointValuePair>(1.0e-10, 1.0e-20)); [EOL]     optimizer.setSimplex(new NelderMeadSimplex(new double[] { 1.0, 0.5 })); [EOL]     final PointValuePair optimum = optimizer.optimize(400, wrapped, GoalType.MINIMIZE, new double[] { -1.5, 4.0 }); [EOL]     Assert.assertEquals(biQuadratic.getBoundedXOptimum(), optimum.getPoint()[0], 2e-7); [EOL]     Assert.assertEquals(biQuadratic.getBoundedYOptimum(), optimum.getPoint()[1], 2e-7); [EOL] } <line_num>: 116,137
public double value(double[] point) { [EOL]     Assert.assertTrue(point[0] >= xMin); [EOL]     Assert.assertTrue(point[0] <= xMax); [EOL]     Assert.assertTrue(point[1] >= yMin); [EOL]     Assert.assertTrue(point[1] <= yMax); [EOL]     final double dx = point[0] - xOptimum; [EOL]     final double dy = point[1] - yOptimum; [EOL]     return dx * dx + dy * dy; [EOL] } <line_num>: 160,172
public double[] getLower() { [EOL]     return new double[] { xMin, yMin }; [EOL] } <line_num>: 174,176
public double[] getUpper() { [EOL]     return new double[] { xMax, yMax }; [EOL] } <line_num>: 178,180
public double getBoundedXOptimum() { [EOL]     return (xOptimum < xMin) ? xMin : ((xOptimum > xMax) ? xMax : xOptimum); [EOL] } <line_num>: 182,184
public double getBoundedYOptimum() { [EOL]     return (yOptimum < yMin) ? yMin : ((yOptimum > yMax) ? yMax : yOptimum); [EOL] } <line_num>: 186,188
