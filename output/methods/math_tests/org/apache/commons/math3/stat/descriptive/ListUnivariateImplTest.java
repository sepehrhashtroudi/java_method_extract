@Test [EOL] public void testStats() { [EOL]     List<Object> externalList = new ArrayList<Object>(); [EOL]     DescriptiveStatistics u = new ListUnivariateImpl(externalList); [EOL]     Assert.assertEquals("total count", 0, u.getN(), tolerance); [EOL]     u.addValue(one); [EOL]     u.addValue(two); [EOL]     u.addValue(two); [EOL]     u.addValue(three); [EOL]     Assert.assertEquals("N", n, u.getN(), tolerance); [EOL]     Assert.assertEquals("sum", sum, u.getSum(), tolerance); [EOL]     Assert.assertEquals("sumsq", sumSq, u.getSumsq(), tolerance); [EOL]     Assert.assertEquals("var", var, u.getVariance(), tolerance); [EOL]     Assert.assertEquals("std", std, u.getStandardDeviation(), tolerance); [EOL]     Assert.assertEquals("mean", mean, u.getMean(), tolerance); [EOL]     Assert.assertEquals("min", min, u.getMin(), tolerance); [EOL]     Assert.assertEquals("max", max, u.getMax(), tolerance); [EOL]     u.clear(); [EOL]     Assert.assertEquals("total count", 0, u.getN(), tolerance); [EOL] } <line_num>: 51,72
@Test [EOL] public void testN0andN1Conditions() { [EOL]     List<Object> list = new ArrayList<Object>(); [EOL]     DescriptiveStatistics u = new ListUnivariateImpl(list); [EOL]     Assert.assertTrue("Mean of n = 0 set should be NaN", Double.isNaN(u.getMean())); [EOL]     Assert.assertTrue("Standard Deviation of n = 0 set should be NaN", Double.isNaN(u.getStandardDeviation())); [EOL]     Assert.assertTrue("Variance of n = 0 set should be NaN", Double.isNaN(u.getVariance())); [EOL]     list.add(Double.valueOf(one)); [EOL]     Assert.assertTrue("Mean of n = 1 set should be value of single item n1", u.getMean() == one); [EOL]     Assert.assertTrue("StdDev of n = 1 set should be zero, instead it is: " + u.getStandardDeviation(), u.getStandardDeviation() == 0); [EOL]     Assert.assertTrue("Variance of n = 1 set should be zero", u.getVariance() == 0); [EOL] } <line_num>: 74,89
@Test [EOL] public void testSkewAndKurtosis() { [EOL]     DescriptiveStatistics u = new DescriptiveStatistics(); [EOL]     double[] testArray = { 12.5, 12, 11.8, 14.2, 14.9, 14.5, 21, 8.2, 10.3, 11.3, 14.1, 9.9, 12.2, 12, 12.1, 11, 19.8, 11, 10, 8.8, 9, 12.3 }; [EOL]     for (int i = 0; i < testArray.length; i++) { [EOL]         u.addValue(testArray[i]); [EOL]     } [EOL]     Assert.assertEquals("mean", 12.40455, u.getMean(), 0.0001); [EOL]     Assert.assertEquals("variance", 10.00236, u.getVariance(), 0.0001); [EOL]     Assert.assertEquals("skewness", 1.437424, u.getSkewness(), 0.0001); [EOL]     Assert.assertEquals("kurtosis", 2.37719, u.getKurtosis(), 0.0001); [EOL] } <line_num>: 91,105
@Test [EOL] public void testProductAndGeometricMean() { [EOL]     ListUnivariateImpl u = new ListUnivariateImpl(new ArrayList<Object>()); [EOL]     u.setWindowSize(10); [EOL]     u.addValue(1.0); [EOL]     u.addValue(2.0); [EOL]     u.addValue(3.0); [EOL]     u.addValue(4.0); [EOL]     Assert.assertEquals("Geometric mean not expected", 2.213364, u.getGeometricMean(), 0.00001); [EOL]     for (int i = 0; i < 10; i++) { [EOL]         u.addValue(i + 2); [EOL]     } [EOL]     Assert.assertEquals("Geometric mean not expected", 5.755931, u.getGeometricMean(), 0.00001); [EOL] } <line_num>: 107,129
@Test [EOL] public void testSerialization() { [EOL]     DescriptiveStatistics u = new ListUnivariateImpl(); [EOL]     Assert.assertEquals("total count", 0, u.getN(), tolerance); [EOL]     u.addValue(one); [EOL]     u.addValue(two); [EOL]     DescriptiveStatistics u2 = (DescriptiveStatistics) TestUtils.serializeAndRecover(u); [EOL]     u2.addValue(two); [EOL]     u2.addValue(three); [EOL]     Assert.assertEquals("N", n, u2.getN(), tolerance); [EOL]     Assert.assertEquals("sum", sum, u2.getSum(), tolerance); [EOL]     Assert.assertEquals("sumsq", sumSq, u2.getSumsq(), tolerance); [EOL]     Assert.assertEquals("var", var, u2.getVariance(), tolerance); [EOL]     Assert.assertEquals("std", std, u2.getStandardDeviation(), tolerance); [EOL]     Assert.assertEquals("mean", mean, u2.getMean(), tolerance); [EOL]     Assert.assertEquals("min", min, u2.getMin(), tolerance); [EOL]     Assert.assertEquals("max", max, u2.getMax(), tolerance); [EOL]     u2.clear(); [EOL]     Assert.assertEquals("total count", 0, u2.getN(), tolerance); [EOL] } <line_num>: 132,157