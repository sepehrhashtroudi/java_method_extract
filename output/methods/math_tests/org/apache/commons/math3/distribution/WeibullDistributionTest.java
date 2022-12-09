@Override [EOL] public WeibullDistribution makeDistribution() { [EOL]     return new WeibullDistribution(1.2, 2.1); [EOL] } <line_num>: 38,41
@Override [EOL] public double[] makeCumulativeTestPoints() { [EOL]     return new double[] { 0.00664355180993, 0.0454328283309, 0.0981162737374, 0.176713524579, 0.321946865392, 10.5115496887, 7.4976304671, 6.23205600701, 5.23968436955, 4.2079028257 }; [EOL] } <line_num>: 44,49
@Override [EOL] public double[] makeCumulativeTestValues() { [EOL]     return new double[] { 0.001, 0.01, 0.025, 0.05, 0.1, 0.999, 0.990, 0.975, 0.950, 0.900 }; [EOL] } <line_num>: 52,55
@Override [EOL] public double[] makeDensityTestValues() { [EOL]     return new double[] { 0.180535929306, 0.262801138133, 0.301905425199, 0.330899152971, 0.353441418887, 0.000788590320203, 0.00737060094841, 0.0177576041516, 0.0343043442574, 0.065664589369 }; [EOL] } <line_num>: 58,62
@Test [EOL] public void testInverseCumulativeProbabilityExtremes() { [EOL]     setInverseCumulativeTestPoints(new double[] { 0.0, 1.0 }); [EOL]     setInverseCumulativeTestValues(new double[] { 0.0, Double.POSITIVE_INFINITY }); [EOL]     verifyInverseCumulativeProbabilities(); [EOL] } <line_num>: 66,72
@Test [EOL] public void testAlpha() { [EOL]     WeibullDistribution dist = new WeibullDistribution(1, 2); [EOL]     Assert.assertEquals(1, dist.getShape(), 0); [EOL]     try { [EOL]         new WeibullDistribution(0, 2); [EOL]         Assert.fail("NotStrictlyPositiveException expected"); [EOL]     } catch (NotStrictlyPositiveException e) { [EOL]     } [EOL] } <line_num>: 74,84
@Test [EOL] public void testBeta() { [EOL]     WeibullDistribution dist = new WeibullDistribution(1, 2); [EOL]     Assert.assertEquals(2, dist.getScale(), 0); [EOL]     try { [EOL]         new WeibullDistribution(1, 0); [EOL]         Assert.fail("NotStrictlyPositiveException expected"); [EOL]     } catch (NotStrictlyPositiveException e) { [EOL]     } [EOL] } <line_num>: 86,96
@Test [EOL] public void testMoments() { [EOL]     final double tol = 1e-9; [EOL]     WeibullDistribution dist; [EOL]     dist = new WeibullDistribution(2.5, 3.5); [EOL]     Assert.assertEquals(dist.getNumericalMean(), 3.5 * FastMath.exp(Gamma.logGamma(1 + (1 / 2.5))), tol); [EOL]     Assert.assertEquals(dist.getNumericalVariance(), (3.5 * 3.5) * FastMath.exp(Gamma.logGamma(1 + (2 / 2.5))) - (dist.getNumericalMean() * dist.getNumericalMean()), tol); [EOL]     dist = new WeibullDistribution(10.4, 2.222); [EOL]     Assert.assertEquals(dist.getNumericalMean(), 2.222 * FastMath.exp(Gamma.logGamma(1 + (1 / 10.4))), tol); [EOL]     Assert.assertEquals(dist.getNumericalVariance(), (2.222 * 2.222) * FastMath.exp(Gamma.logGamma(1 + (2 / 10.4))) - (dist.getNumericalMean() * dist.getNumericalMean()), tol); [EOL] } <line_num>: 98,115
@Test [EOL] public void testSampling() { [EOL] } <line_num>: 117,118