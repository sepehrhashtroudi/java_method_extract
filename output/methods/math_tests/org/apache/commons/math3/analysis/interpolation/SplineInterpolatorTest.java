@Test [EOL] public void testInterpolateLinearDegenerateTwoSegment() { [EOL]     double[] x = { 0.0, 0.5, 1.0 }; [EOL]     double[] y = { 0.0, 0.5, 1.0 }; [EOL]     UnivariateInterpolator i = new SplineInterpolator(); [EOL]     UnivariateFunction f = i.interpolate(x, y); [EOL]     verifyInterpolation(f, x, y); [EOL]     verifyConsistency((PolynomialSplineFunction) f, x); [EOL]     PolynomialFunction[] polynomials = ((PolynomialSplineFunction) f).getPolynomials(); [EOL]     double[] target = { y[0], 1d }; [EOL]     TestUtils.assertEquals(polynomials[0].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[1], 1d }; [EOL]     TestUtils.assertEquals(polynomials[1].getCoefficients(), target, coefficientTolerance); [EOL]     Assert.assertEquals(0.0, f.value(0.0), interpolationTolerance); [EOL]     Assert.assertEquals(0.4, f.value(0.4), interpolationTolerance); [EOL]     Assert.assertEquals(1.0, f.value(1.0), interpolationTolerance); [EOL] } <line_num>: 46,67
@Test [EOL] public void testInterpolateLinearDegenerateThreeSegment() { [EOL]     double[] x = { 0.0, 0.5, 1.0, 1.5 }; [EOL]     double[] y = { 0.0, 0.5, 1.0, 1.5 }; [EOL]     UnivariateInterpolator i = new SplineInterpolator(); [EOL]     UnivariateFunction f = i.interpolate(x, y); [EOL]     verifyInterpolation(f, x, y); [EOL]     PolynomialFunction[] polynomials = ((PolynomialSplineFunction) f).getPolynomials(); [EOL]     double[] target = { y[0], 1d }; [EOL]     TestUtils.assertEquals(polynomials[0].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[1], 1d }; [EOL]     TestUtils.assertEquals(polynomials[1].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[2], 1d }; [EOL]     TestUtils.assertEquals(polynomials[2].getCoefficients(), target, coefficientTolerance); [EOL]     Assert.assertEquals(0, f.value(0), interpolationTolerance); [EOL]     Assert.assertEquals(1.4, f.value(1.4), interpolationTolerance); [EOL]     Assert.assertEquals(1.5, f.value(1.5), interpolationTolerance); [EOL] } <line_num>: 69,91
@Test [EOL] public void testInterpolateLinear() { [EOL]     double[] x = { 0.0, 0.5, 1.0 }; [EOL]     double[] y = { 0.0, 0.5, 0.0 }; [EOL]     UnivariateInterpolator i = new SplineInterpolator(); [EOL]     UnivariateFunction f = i.interpolate(x, y); [EOL]     verifyInterpolation(f, x, y); [EOL]     verifyConsistency((PolynomialSplineFunction) f, x); [EOL]     PolynomialFunction[] polynomials = ((PolynomialSplineFunction) f).getPolynomials(); [EOL]     double[] target = { y[0], 1.5d, 0d, -2d }; [EOL]     TestUtils.assertEquals(polynomials[0].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[1], 0d, -3d, 2d }; [EOL]     TestUtils.assertEquals(polynomials[1].getCoefficients(), target, coefficientTolerance); [EOL] } <line_num>: 93,108
@Test [EOL] public void testInterpolateSin() { [EOL]     double[] x = { 0.0, FastMath.PI / 6d, FastMath.PI / 2d, 5d * FastMath.PI / 6d, FastMath.PI, 7d * FastMath.PI / 6d, 3d * FastMath.PI / 2d, 11d * FastMath.PI / 6d, 2.d * FastMath.PI }; [EOL]     double[] y = { 0d, 0.5d, 1d, 0.5d, 0d, -0.5d, -1d, -0.5d, 0d }; [EOL]     UnivariateInterpolator i = new SplineInterpolator(); [EOL]     UnivariateFunction f = i.interpolate(x, y); [EOL]     verifyInterpolation(f, x, y); [EOL]     verifyConsistency((PolynomialSplineFunction) f, x); [EOL]     PolynomialFunction[] polynomials = ((PolynomialSplineFunction) f).getPolynomials(); [EOL]     double[] target = { y[0], 1.002676d, 0d, -0.17415829d }; [EOL]     TestUtils.assertEquals(polynomials[0].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[1], 8.594367e-01, -2.735672e-01, -0.08707914 }; [EOL]     TestUtils.assertEquals(polynomials[1].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[2], 1.471804e-17, -5.471344e-01, 0.08707914 }; [EOL]     TestUtils.assertEquals(polynomials[2].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[3], -8.594367e-01, -2.735672e-01, 0.17415829 }; [EOL]     TestUtils.assertEquals(polynomials[3].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[4], -1.002676, 6.548562e-17, 0.17415829 }; [EOL]     TestUtils.assertEquals(polynomials[4].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[5], -8.594367e-01, 2.735672e-01, 0.08707914 }; [EOL]     TestUtils.assertEquals(polynomials[5].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[6], 3.466465e-16, 5.471344e-01, -0.08707914 }; [EOL]     TestUtils.assertEquals(polynomials[6].getCoefficients(), target, coefficientTolerance); [EOL]     target = new double[] { y[7], 8.594367e-01, 2.735672e-01, -0.17415829 }; [EOL]     TestUtils.assertEquals(polynomials[7].getCoefficients(), target, coefficientTolerance); [EOL]     Assert.assertEquals(FastMath.sqrt(2d) / 2d, f.value(FastMath.PI / 4d), interpolationTolerance); [EOL]     Assert.assertEquals(FastMath.sqrt(2d) / 2d, f.value(3d * FastMath.PI / 4d), interpolationTolerance); [EOL] } <line_num>: 110,159
@Test [EOL] public void testIllegalArguments() { [EOL]     UnivariateInterpolator i = new SplineInterpolator(); [EOL]     try { [EOL]         double[] xval = { 0.0, 1.0 }; [EOL]         double[] yval = { 0.0, 1.0, 2.0 }; [EOL]         i.interpolate(xval, yval); [EOL]         Assert.fail("Failed to detect data set array with different sizes."); [EOL]     } catch (DimensionMismatchException iae) { [EOL]     } [EOL]     try { [EOL]         double[] xval = { 0.0, 1.0, 0.5 }; [EOL]         double[] yval = { 0.0, 1.0, 2.0 }; [EOL]         i.interpolate(xval, yval); [EOL]         Assert.fail("Failed to detect unsorted arguments."); [EOL]     } catch (NonMonotonicSequenceException iae) { [EOL]     } [EOL]     try { [EOL]         double[] xval = { 0.0, 1.0 }; [EOL]         double[] yval = { 0.0, 1.0 }; [EOL]         i.interpolate(xval, yval); [EOL]         Assert.fail("Failed to detect unsorted arguments."); [EOL]     } catch (NumberIsTooSmallException iae) { [EOL]     } [EOL] } <line_num>: 161,191
protected void verifyInterpolation(UnivariateFunction f, double[] x, double[] y) { [EOL]     for (int i = 0; i < x.length; i++) { [EOL]         Assert.assertEquals(f.value(x[i]), y[i], knotTolerance); [EOL]     } [EOL] } <line_num>: 196,201
protected void verifyConsistency(PolynomialSplineFunction f, double[] x) { [EOL]     PolynomialFunction[] polynomials = f.getPolynomials(); [EOL]     for (int i = 1; i < x.length - 2; i++) { [EOL]         Assert.assertEquals(polynomials[i].value(x[i + 1] - x[i]), polynomials[i + 1].value(0), 0.1); [EOL]         Assert.assertEquals(polynomials[i].derivative().value(x[i + 1] - x[i]), polynomials[i + 1].derivative().value(0), 0.5); [EOL]         Assert.assertEquals(polynomials[i].polynomialDerivative().derivative().value(x[i + 1] - x[i]), polynomials[i + 1].polynomialDerivative().derivative().value(0), 0.5); [EOL]     } [EOL] } <line_num>: 207,218
