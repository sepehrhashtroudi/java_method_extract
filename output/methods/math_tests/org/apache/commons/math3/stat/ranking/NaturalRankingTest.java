@Test [EOL] public void testDefault() { [EOL]     NaturalRanking ranking = new NaturalRanking(); [EOL]     double[] ranks; [EOL]     try { [EOL]         ranks = ranking.rank(exampleData); [EOL]         Assert.fail("expected NotANumberException due to NaNStrategy.FAILED"); [EOL]     } catch (NotANumberException e) { [EOL]     } [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     double[] correctRanks = new double[] { 1.5, 1.5, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 3.5, 3.5, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     try { [EOL]         ranks = ranking.rank(multipleNaNs); [EOL]         Assert.fail("expected NotANumberException due to NaNStrategy.FAILED"); [EOL]     } catch (NotANumberException e) { [EOL]     } [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 4.5, 4.5, 6.5, 6.5, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 2.5, 2.5, 2.5, 2.5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 44,76
@Test [EOL] public void testNaNsMaximalTiesMinimum() { [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.MAXIMAL, TiesStrategy.MINIMUM); [EOL]     double[] ranks = ranking.rank(exampleData); [EOL]     double[] correctRanks = { 5, 2, 6, 7, 2, 8, 9, 1, 2 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     correctRanks = new double[] { 1, 1, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 3, 3, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleNaNs); [EOL]     correctRanks = new double[] { 1, 2, 3, 3 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 4, 4, 6, 6, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 1, 1, 1, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 78,99
@Test [EOL] public void testNaNsRemovedTiesSequential() { [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.REMOVED, TiesStrategy.SEQUENTIAL); [EOL]     double[] ranks = ranking.rank(exampleData); [EOL]     double[] correctRanks = { 5, 2, 6, 7, 3, 8, 1, 4 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     correctRanks = new double[] { 1, 2, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 3, 4, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleNaNs); [EOL]     correctRanks = new double[] { 1, 2 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 4, 5, 6, 7, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 1, 2, 3, 4 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 101,123
@Test [EOL] public void testNaNsMinimalTiesMaximum() { [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.MINIMAL, TiesStrategy.MAXIMUM); [EOL]     double[] ranks = ranking.rank(exampleData); [EOL]     double[] correctRanks = { 6, 5, 7, 8, 5, 9, 2, 2, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     correctRanks = new double[] { 2, 2, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 4, 4, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleNaNs); [EOL]     correctRanks = new double[] { 3, 4, 2, 2 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 5, 5, 7, 7, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 4, 4, 4, 4 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 125,147
@Test [EOL] public void testNaNsMinimalTiesAverage() { [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.MINIMAL); [EOL]     double[] ranks = ranking.rank(exampleData); [EOL]     double[] correctRanks = { 6, 4, 7, 8, 4, 9, 1.5, 1.5, 4 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     correctRanks = new double[] { 1.5, 1.5, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 3.5, 3.5, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleNaNs); [EOL]     correctRanks = new double[] { 3, 4, 1.5, 1.5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 4.5, 4.5, 6.5, 6.5, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 2.5, 2.5, 2.5, 2.5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 149,170
@Test [EOL] public void testNaNsFixedTiesRandom() { [EOL]     RandomGenerator randomGenerator = new JDKRandomGenerator(); [EOL]     randomGenerator.setSeed(1000); [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.FIXED, randomGenerator); [EOL]     double[] ranks = ranking.rank(exampleData); [EOL]     double[] correctRanks = { 5, 3, 6, 7, 3, 8, Double.NaN, 1, 2 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesFirst); [EOL]     correctRanks = new double[] { 1, 2, 4, 3, 5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(tiesLast); [EOL]     correctRanks = new double[] { 3, 3, 2, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleNaNs); [EOL]     correctRanks = new double[] { 1, 2, Double.NaN, Double.NaN }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(multipleTies); [EOL]     correctRanks = new double[] { 3, 2, 4, 4, 6, 7, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranks = ranking.rank(allSame); [EOL]     correctRanks = new double[] { 2, 3, 3, 3 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 172,196
@Test [EOL] public void testNaNsAndInfs() { [EOL]     double[] data = { 0, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY }; [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.MAXIMAL); [EOL]     double[] ranks = ranking.rank(data); [EOL]     double[] correctRanks = new double[] { 2, 3.5, 3.5, 1 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL]     ranking = new NaturalRanking(NaNStrategy.MINIMAL); [EOL]     ranks = ranking.rank(data); [EOL]     correctRanks = new double[] { 3, 4, 1.5, 1.5 }; [EOL]     TestUtils.assertEquals(correctRanks, ranks, 0d); [EOL] } <line_num>: 198,210
@Test(expected = NotANumberException.class) [EOL] public void testNaNsFailed() { [EOL]     double[] data = { 0, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY }; [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.FAILED); [EOL]     ranking.rank(data); [EOL] } <line_num>: 212,217
@Test [EOL] public void testNoNaNsFailed() { [EOL]     double[] data = { 1, 2, 3, 4 }; [EOL]     NaturalRanking ranking = new NaturalRanking(NaNStrategy.FAILED); [EOL]     double[] ranks = ranking.rank(data); [EOL]     TestUtils.assertEquals(data, ranks, 0d); [EOL] } <line_num>: 219,225