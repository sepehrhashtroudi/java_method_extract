@Test(expected = OutOfRangeException.class) [EOL] public void testPreconditions1() { [EOL]     final double lo = -1; [EOL]     final double hi = 2; [EOL]     final UnivariateFunction f = new Logit(lo, hi); [EOL]     f.value(lo - 1); [EOL] } <line_num>: 40,47
@Test(expected = OutOfRangeException.class) [EOL] public void testPreconditions2() { [EOL]     final double lo = -1; [EOL]     final double hi = 2; [EOL]     final UnivariateFunction f = new Logit(lo, hi); [EOL]     f.value(hi + 1); [EOL] } <line_num>: 49,56
@Test [EOL] public void testSomeValues() { [EOL]     final double lo = 1; [EOL]     final double hi = 2; [EOL]     final UnivariateFunction f = new Logit(lo, hi); [EOL]     Assert.assertEquals(Double.NEGATIVE_INFINITY, f.value(1), EPS); [EOL]     Assert.assertEquals(Double.POSITIVE_INFINITY, f.value(2), EPS); [EOL]     Assert.assertEquals(0, f.value(1.5), EPS); [EOL] } <line_num>: 58,67
@Test [EOL] public void testDerivative() { [EOL]     final double lo = 1; [EOL]     final double hi = 2; [EOL]     final Logit f = new Logit(lo, hi); [EOL]     final DerivativeStructure f15 = f.value(new DerivativeStructure(1, 1, 0, 1.5)); [EOL]     Assert.assertEquals(4, f15.getPartialDerivative(1), EPS); [EOL] } <line_num>: 69,77
@Test [EOL] public void testDerivativeLargeArguments() { [EOL]     final Logit f = new Logit(1, 2); [EOL]     for (double arg : new double[] { Double.NEGATIVE_INFINITY, -Double.MAX_VALUE, -1e155, 1e155, Double.MAX_VALUE, Double.POSITIVE_INFINITY }) { [EOL]         try { [EOL]             f.value(new DerivativeStructure(1, 1, 0, arg)); [EOL]             Assert.fail("an exception should have been thrown"); [EOL]         } catch (OutOfRangeException ore) { [EOL]         } catch (Exception e) { [EOL]             Assert.fail("wrong exception caught: " + e.getMessage()); [EOL]         } [EOL]     } [EOL] } <line_num>: 79,95
@Test [EOL] public void testDerivativesHighOrder() { [EOL]     DerivativeStructure l = new Logit(1, 3).value(new DerivativeStructure(1, 5, 0, 1.2)); [EOL]     Assert.assertEquals(-2.1972245773362193828, l.getPartialDerivative(0), 1.0e-16); [EOL]     Assert.assertEquals(5.5555555555555555555, l.getPartialDerivative(1), 9.0e-16); [EOL]     Assert.assertEquals(-24.691358024691358025, l.getPartialDerivative(2), 2.0e-14); [EOL]     Assert.assertEquals(250.34293552812071331, l.getPartialDerivative(3), 2.0e-13); [EOL]     Assert.assertEquals(-3749.4284407864654778, l.getPartialDerivative(4), 4.0e-12); [EOL]     Assert.assertEquals(75001.270131585632282, l.getPartialDerivative(5), 8.0e-11); [EOL] } <line_num>: 97,106
@Test(expected = NullArgumentException.class) [EOL] public void testParametricUsage1() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.value(0, null); [EOL] } <line_num>: 108,112
@Test(expected = DimensionMismatchException.class) [EOL] public void testParametricUsage2() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.value(0, new double[] { 0 }); [EOL] } <line_num>: 114,118
@Test(expected = NullArgumentException.class) [EOL] public void testParametricUsage3() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.gradient(0, null); [EOL] } <line_num>: 120,124
@Test(expected = DimensionMismatchException.class) [EOL] public void testParametricUsage4() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.gradient(0, new double[] { 0 }); [EOL] } <line_num>: 126,130
@Test(expected = OutOfRangeException.class) [EOL] public void testParametricUsage5() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.value(-1, new double[] { 0, 1 }); [EOL] } <line_num>: 132,136
@Test(expected = OutOfRangeException.class) [EOL] public void testParametricUsage6() { [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     g.value(2, new double[] { 0, 1 }); [EOL] } <line_num>: 138,142
@Test [EOL] public void testParametricValue() { [EOL]     final double lo = 2; [EOL]     final double hi = 3; [EOL]     final Logit f = new Logit(lo, hi); [EOL]     final Logit.Parametric g = new Logit.Parametric(); [EOL]     Assert.assertEquals(f.value(2), g.value(2, new double[] { lo, hi }), 0); [EOL]     Assert.assertEquals(f.value(2.34567), g.value(2.34567, new double[] { lo, hi }), 0); [EOL]     Assert.assertEquals(f.value(3), g.value(3, new double[] { lo, hi }), 0); [EOL] } <line_num>: 144,154
@Test [EOL] public void testValueWithInverseFunction() { [EOL]     final double lo = 2; [EOL]     final double hi = 3; [EOL]     final Logit f = new Logit(lo, hi); [EOL]     final Sigmoid g = new Sigmoid(lo, hi); [EOL]     RandomGenerator random = new Well1024a(0x49914cdd9f0b8db5l); [EOL]     final UnivariateDifferentiableFunction id = FunctionUtils.compose((UnivariateDifferentiableFunction) g, (UnivariateDifferentiableFunction) f); [EOL]     for (int i = 0; i < 10; i++) { [EOL]         final double x = lo + random.nextDouble() * (hi - lo); [EOL]         Assert.assertEquals(x, id.value(new DerivativeStructure(1, 1, 0, x)).getValue(), EPS); [EOL]     } [EOL]     Assert.assertEquals(lo, id.value(new DerivativeStructure(1, 1, 0, lo)).getValue(), EPS); [EOL]     Assert.assertEquals(hi, id.value(new DerivativeStructure(1, 1, 0, hi)).getValue(), EPS); [EOL] } <line_num>: 156,173
@Test [EOL] public void testDerivativesWithInverseFunction() { [EOL]     double[] epsilon = new double[] { 1.0e-20, 4.0e-16, 3.0e-15, 2.0e-11, 3.0e-9, 1.0e-6 }; [EOL]     final double lo = 2; [EOL]     final double hi = 3; [EOL]     final Logit f = new Logit(lo, hi); [EOL]     final Sigmoid g = new Sigmoid(lo, hi); [EOL]     RandomGenerator random = new Well1024a(0x96885e9c1f81cea5l); [EOL]     final UnivariateDifferentiableFunction id = FunctionUtils.compose((UnivariateDifferentiableFunction) g, (UnivariateDifferentiableFunction) f); [EOL]     for (int maxOrder = 0; maxOrder < 6; ++maxOrder) { [EOL]         double max = 0; [EOL]         for (int i = 0; i < 10; i++) { [EOL]             final double x = lo + random.nextDouble() * (hi - lo); [EOL]             final DerivativeStructure dsX = new DerivativeStructure(1, maxOrder, 0, x); [EOL]             max = FastMath.max(max, FastMath.abs(dsX.getPartialDerivative(maxOrder) - id.value(dsX).getPartialDerivative(maxOrder))); [EOL]             Assert.assertEquals(dsX.getPartialDerivative(maxOrder), id.value(dsX).getPartialDerivative(maxOrder), epsilon[maxOrder]); [EOL]         } [EOL]         final DerivativeStructure dsLo = new DerivativeStructure(1, maxOrder, 0, lo); [EOL]         if (maxOrder == 0) { [EOL]             Assert.assertTrue(Double.isInfinite(f.value(dsLo).getPartialDerivative(maxOrder))); [EOL]             Assert.assertEquals(lo, id.value(dsLo).getPartialDerivative(maxOrder), epsilon[maxOrder]); [EOL]         } else if (maxOrder == 1) { [EOL]             Assert.assertTrue(Double.isInfinite(f.value(dsLo).getPartialDerivative(maxOrder))); [EOL]             Assert.assertTrue(Double.isNaN(id.value(dsLo).getPartialDerivative(maxOrder))); [EOL]         } else { [EOL]             Assert.assertTrue(Double.isNaN(f.value(dsLo).getPartialDerivative(maxOrder))); [EOL]             Assert.assertTrue(Double.isNaN(id.value(dsLo).getPartialDerivative(maxOrder))); [EOL]         } [EOL]         final DerivativeStructure dsHi = new DerivativeStructure(1, maxOrder, 0, hi); [EOL]         if (maxOrder == 0) { [EOL]             Assert.assertTrue(Double.isInfinite(f.value(dsHi).getPartialDerivative(maxOrder))); [EOL]             Assert.assertEquals(hi, id.value(dsHi).getPartialDerivative(maxOrder), epsilon[maxOrder]); [EOL]         } else if (maxOrder == 1) { [EOL]             Assert.assertTrue(Double.isInfinite(f.value(dsHi).getPartialDerivative(maxOrder))); [EOL]             Assert.assertTrue(Double.isNaN(id.value(dsHi).getPartialDerivative(maxOrder))); [EOL]         } else { [EOL]             Assert.assertTrue(Double.isNaN(f.value(dsHi).getPartialDerivative(maxOrder))); [EOL]             Assert.assertTrue(Double.isNaN(id.value(dsHi).getPartialDerivative(maxOrder))); [EOL]         } [EOL]     } [EOL] } <line_num>: 175,224
