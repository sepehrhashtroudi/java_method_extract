@Test(expected = NotStrictlyPositiveException.class) [EOL] public void testPreconditions() { [EOL]     new Gaussian(1, 2, -1); [EOL] } <line_num>: 36,39
@Test [EOL] public void testSomeValues() { [EOL]     final UnivariateFunction f = new Gaussian(); [EOL]     Assert.assertEquals(1 / FastMath.sqrt(2 * Math.PI), f.value(0), EPS); [EOL] } <line_num>: 41,46
@Test [EOL] public void testLargeArguments() { [EOL]     final UnivariateFunction f = new Gaussian(); [EOL]     Assert.assertEquals(0, f.value(Double.NEGATIVE_INFINITY), 0); [EOL]     Assert.assertEquals(0, f.value(-Double.MAX_VALUE), 0); [EOL]     Assert.assertEquals(0, f.value(-1e2), 0); [EOL]     Assert.assertEquals(0, f.value(1e2), 0); [EOL]     Assert.assertEquals(0, f.value(Double.MAX_VALUE), 0); [EOL]     Assert.assertEquals(0, f.value(Double.POSITIVE_INFINITY), 0); [EOL] } <line_num>: 48,58
@Test [EOL] public void testDerivatives() { [EOL]     final UnivariateDifferentiableFunction gaussian = new Gaussian(2.0, 0.9, 3.0); [EOL]     final DerivativeStructure dsX = new DerivativeStructure(1, 4, 0, 1.1); [EOL]     final DerivativeStructure dsY = gaussian.value(dsX); [EOL]     Assert.assertEquals(1.9955604901712128349, dsY.getValue(), EPS); [EOL]     Assert.assertEquals(-0.044345788670471396332, dsY.getPartialDerivative(1), EPS); [EOL]     Assert.assertEquals(-0.22074348138190206174, dsY.getPartialDerivative(2), EPS); [EOL]     Assert.assertEquals(0.014760030401924800557, dsY.getPartialDerivative(3), EPS); [EOL]     Assert.assertEquals(0.073253159785035691678, dsY.getPartialDerivative(4), EPS); [EOL] } <line_num>: 60,70
@Test [EOL] public void testDerivativeLargeArguments() { [EOL]     final Gaussian f = new Gaussian(0, 1e-50); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, Double.NEGATIVE_INFINITY)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, -Double.MAX_VALUE)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, -1e50)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, -1e2)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, 1e2)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, 1e50)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, Double.MAX_VALUE)).getPartialDerivative(1), 0); [EOL]     Assert.assertEquals(0, f.value(new DerivativeStructure(1, 1, 0, Double.POSITIVE_INFINITY)).getPartialDerivative(1), 0); [EOL] } <line_num>: 72,84
@Test [EOL] public void testDerivativesNaN() { [EOL]     final Gaussian f = new Gaussian(0, 1e-50); [EOL]     final DerivativeStructure fx = f.value(new DerivativeStructure(1, 5, 0, Double.NaN)); [EOL]     for (int i = 0; i <= fx.getOrder(); ++i) { [EOL]         Assert.assertTrue(Double.isNaN(fx.getPartialDerivative(i))); [EOL]     } [EOL] } <line_num>: 86,93
@Test(expected = NullArgumentException.class) [EOL] public void testParametricUsage1() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.value(0, null); [EOL] } <line_num>: 95,99
@Test(expected = DimensionMismatchException.class) [EOL] public void testParametricUsage2() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.value(0, new double[] { 0 }); [EOL] } <line_num>: 101,105
@Test(expected = NotStrictlyPositiveException.class) [EOL] public void testParametricUsage3() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.value(0, new double[] { 0, 1, 0 }); [EOL] } <line_num>: 107,111
@Test(expected = NullArgumentException.class) [EOL] public void testParametricUsage4() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.gradient(0, null); [EOL] } <line_num>: 113,117
@Test(expected = DimensionMismatchException.class) [EOL] public void testParametricUsage5() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.gradient(0, new double[] { 0 }); [EOL] } <line_num>: 119,123
@Test(expected = NotStrictlyPositiveException.class) [EOL] public void testParametricUsage6() { [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     g.gradient(0, new double[] { 0, 1, 0 }); [EOL] } <line_num>: 125,129
@Test [EOL] public void testParametricValue() { [EOL]     final double norm = 2; [EOL]     final double mean = 3; [EOL]     final double sigma = 4; [EOL]     final Gaussian f = new Gaussian(norm, mean, sigma); [EOL]     final Gaussian.Parametric g = new Gaussian.Parametric(); [EOL]     Assert.assertEquals(f.value(-1), g.value(-1, new double[] { norm, mean, sigma }), 0); [EOL]     Assert.assertEquals(f.value(0), g.value(0, new double[] { norm, mean, sigma }), 0); [EOL]     Assert.assertEquals(f.value(2), g.value(2, new double[] { norm, mean, sigma }), 0); [EOL] } <line_num>: 131,142
@Test [EOL] public void testParametricGradient() { [EOL]     final double norm = 2; [EOL]     final double mean = 3; [EOL]     final double sigma = 4; [EOL]     final Gaussian.Parametric f = new Gaussian.Parametric(); [EOL]     final double x = 1; [EOL]     final double[] grad = f.gradient(1, new double[] { norm, mean, sigma }); [EOL]     final double diff = x - mean; [EOL]     final double n = FastMath.exp(-diff * diff / (2 * sigma * sigma)); [EOL]     Assert.assertEquals(n, grad[0], EPS); [EOL]     final double m = norm * n * diff / (sigma * sigma); [EOL]     Assert.assertEquals(m, grad[1], EPS); [EOL]     final double s = m * diff / sigma; [EOL]     Assert.assertEquals(s, grad[2], EPS); [EOL] } <line_num>: 144,160
