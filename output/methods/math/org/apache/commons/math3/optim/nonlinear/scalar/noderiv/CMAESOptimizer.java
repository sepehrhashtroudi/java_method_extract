public CMAESOptimizer(int maxIterations, double stopFitness, boolean isActiveCMA, int diagonalOnly, int checkFeasableCount, RandomGenerator random, boolean generateStatistics, ConvergenceChecker<PointValuePair> checker) { [EOL]     super(checker); [EOL]     this.maxIterations = maxIterations; [EOL]     this.stopFitness = stopFitness; [EOL]     this.isActiveCMA = isActiveCMA; [EOL]     this.diagonalOnly = diagonalOnly; [EOL]     this.checkFeasableCount = checkFeasableCount; [EOL]     this.random = random; [EOL]     this.generateStatistics = generateStatistics; [EOL] } <line_num>: 223,239
public Sigma(double[] s) throws NotPositiveException { [EOL]     for (int i = 0; i < s.length; i++) { [EOL]         if (s[i] < 0) { [EOL]             throw new NotPositiveException(s[i]); [EOL]         } [EOL]     } [EOL]     sigma = s.clone(); [EOL] } <line_num>: 289,298
public PopulationSize(int size) throws NotStrictlyPositiveException { [EOL]     if (size <= 0) { [EOL]         throw new NotStrictlyPositiveException(size); [EOL]     } [EOL]     lambda = size; [EOL] } <line_num>: 326,332
DoubleIndex(double value, int index) { [EOL]     this.value = value; [EOL]     this.index = index; [EOL] } <line_num>: 840,843
public FitnessFunction() { [EOL]     valueRange = 1; [EOL]     isRepairMode = true; [EOL] } <line_num>: 889,892
public List<Double> getStatisticsSigmaHistory() { [EOL]     return statisticsSigmaHistory; [EOL] } <line_num>: 244,246
public List<RealMatrix> getStatisticsMeanHistory() { [EOL]     return statisticsMeanHistory; [EOL] } <line_num>: 251,253
public List<Double> getStatisticsFitnessHistory() { [EOL]     return statisticsFitnessHistory; [EOL] } <line_num>: 258,260
public List<RealMatrix> getStatisticsDHistory() { [EOL]     return statisticsDHistory; [EOL] } <line_num>: 265,267
public double[] getSigma() { [EOL]     return sigma.clone(); [EOL] } <line_num>: 303,305
public int getPopulationSize() { [EOL]     return lambda; [EOL] } <line_num>: 337,339
@Override [EOL] public PointValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException, DimensionMismatchException { [EOL]     return super.optimize(optData); [EOL] } <line_num>: 358,364
@Override [EOL] protected PointValuePair doOptimize() { [EOL]     isMinimize = getGoalType().equals(GoalType.MINIMIZE); [EOL]     final FitnessFunction fitfun = new FitnessFunction(); [EOL]     final double[] guess = getStartPoint(); [EOL]     dimension = guess.length; [EOL]     initializeCMA(guess); [EOL]     iterations = 0; [EOL]     double bestValue = fitfun.value(guess); [EOL]     push(fitnessHistory, bestValue); [EOL]     PointValuePair optimum = new PointValuePair(getStartPoint(), isMinimize ? bestValue : -bestValue); [EOL]     PointValuePair lastResult = null; [EOL]     generationLoop: for (iterations = 1; iterations <= maxIterations; iterations++) { [EOL]         incrementIterationCount(); [EOL]         final RealMatrix arz = randn1(dimension, lambda); [EOL]         final RealMatrix arx = zeros(dimension, lambda); [EOL]         final double[] fitness = new double[lambda]; [EOL]         for (int k = 0; k < lambda; k++) { [EOL]             RealMatrix arxk = null; [EOL]             for (int i = 0; i < checkFeasableCount + 1; i++) { [EOL]                 if (diagonalOnly <= 0) { [EOL]                     arxk = xmean.add(BD.multiply(arz.getColumnMatrix(k)).scalarMultiply(sigma)); [EOL]                 } else { [EOL]                     arxk = xmean.add(times(diagD, arz.getColumnMatrix(k)).scalarMultiply(sigma)); [EOL]                 } [EOL]                 if (i >= checkFeasableCount || fitfun.isFeasible(arxk.getColumn(0))) { [EOL]                     break; [EOL]                 } [EOL]                 arz.setColumn(k, randn(dimension)); [EOL]             } [EOL]             copyColumn(arxk, 0, arx, k); [EOL]             try { [EOL]                 fitness[k] = fitfun.value(arx.getColumn(k)); [EOL]             } catch (TooManyEvaluationsException e) { [EOL]                 break generationLoop; [EOL]             } [EOL]         } [EOL]         final int[] arindex = sortedIndices(fitness); [EOL]         final RealMatrix xold = xmean; [EOL]         final RealMatrix bestArx = selectColumns(arx, MathArrays.copyOf(arindex, mu)); [EOL]         xmean = bestArx.multiply(weights); [EOL]         final RealMatrix bestArz = selectColumns(arz, MathArrays.copyOf(arindex, mu)); [EOL]         final RealMatrix zmean = bestArz.multiply(weights); [EOL]         final boolean hsig = updateEvolutionPaths(zmean, xold); [EOL]         if (diagonalOnly <= 0) { [EOL]             updateCovariance(hsig, bestArx, arz, arindex, xold); [EOL]         } else { [EOL]             updateCovarianceDiagonalOnly(hsig, bestArz); [EOL]         } [EOL]         sigma *= Math.exp(Math.min(1, (normps / chiN - 1) * cs / damps)); [EOL]         final double bestFitness = fitness[arindex[0]]; [EOL]         final double worstFitness = fitness[arindex[arindex.length - 1]]; [EOL]         if (bestValue > bestFitness) { [EOL]             bestValue = bestFitness; [EOL]             lastResult = optimum; [EOL]             optimum = new PointValuePair(fitfun.repair(bestArx.getColumn(0)), isMinimize ? bestFitness : -bestFitness); [EOL]             if (getConvergenceChecker() != null && lastResult != null && getConvergenceChecker().converged(iterations, optimum, lastResult)) { [EOL]                 break generationLoop; [EOL]             } [EOL]         } [EOL]         if (stopFitness != 0 && bestFitness < (isMinimize ? stopFitness : -stopFitness)) { [EOL]             break generationLoop; [EOL]         } [EOL]         final double[] sqrtDiagC = sqrt(diagC).getColumn(0); [EOL]         final double[] pcCol = pc.getColumn(0); [EOL]         for (int i = 0; i < dimension; i++) { [EOL]             if (sigma * Math.max(Math.abs(pcCol[i]), sqrtDiagC[i]) > stopTolX) { [EOL]                 break; [EOL]             } [EOL]             if (i >= dimension - 1) { [EOL]                 break generationLoop; [EOL]             } [EOL]         } [EOL]         for (int i = 0; i < dimension; i++) { [EOL]             if (sigma * sqrtDiagC[i] > stopTolUpX) { [EOL]                 break generationLoop; [EOL]             } [EOL]         } [EOL]         final double historyBest = min(fitnessHistory); [EOL]         final double historyWorst = max(fitnessHistory); [EOL]         if (iterations > 2 && Math.max(historyWorst, worstFitness) - Math.min(historyBest, bestFitness) < stopTolFun) { [EOL]             break generationLoop; [EOL]         } [EOL]         if (iterations > fitnessHistory.length && historyWorst - historyBest < stopTolHistFun) { [EOL]             break generationLoop; [EOL]         } [EOL]         if (max(diagD) / min(diagD) > 1e7) { [EOL]             break generationLoop; [EOL]         } [EOL]         if (getConvergenceChecker() != null) { [EOL]             final PointValuePair current = new PointValuePair(bestArx.getColumn(0), isMinimize ? bestFitness : -bestFitness); [EOL]             if (lastResult != null && getConvergenceChecker().converged(iterations, current, lastResult)) { [EOL]                 break generationLoop; [EOL]             } [EOL]             lastResult = current; [EOL]         } [EOL]         if (bestValue == fitness[arindex[(int) (0.1 + lambda / 4.)]]) { [EOL]             sigma = sigma * Math.exp(0.2 + cs / damps); [EOL]         } [EOL]         if (iterations > 2 && Math.max(historyWorst, bestFitness) - Math.min(historyBest, bestFitness) == 0) { [EOL]             sigma = sigma * Math.exp(0.2 + cs / damps); [EOL]         } [EOL]         push(fitnessHistory, bestFitness); [EOL]         fitfun.setValueRange(worstFitness - bestFitness); [EOL]         if (generateStatistics) { [EOL]             statisticsSigmaHistory.add(sigma); [EOL]             statisticsFitnessHistory.add(bestFitness); [EOL]             statisticsMeanHistory.add(xmean.transpose()); [EOL]             statisticsDHistory.add(diagD.transpose().scalarMultiply(1E5)); [EOL]         } [EOL]     } [EOL]     return optimum; [EOL] } <line_num>: 367,512
@Override [EOL] protected void parseOptimizationData(OptimizationData... optData) { [EOL]     super.parseOptimizationData(optData); [EOL]     for (OptimizationData data : optData) { [EOL]         if (data instanceof Sigma) { [EOL]             inputSigma = ((Sigma) data).getSigma(); [EOL]             continue; [EOL]         } [EOL]         if (data instanceof PopulationSize) { [EOL]             lambda = ((PopulationSize) data).getPopulationSize(); [EOL]             continue; [EOL]         } [EOL]     } [EOL]     checkParameters(); [EOL] } <line_num>: 524,543
private void checkParameters() { [EOL]     final double[] init = getStartPoint(); [EOL]     final double[] lB = getLowerBound(); [EOL]     final double[] uB = getUpperBound(); [EOL]     if (inputSigma != null) { [EOL]         if (inputSigma.length != init.length) { [EOL]             throw new DimensionMismatchException(inputSigma.length, init.length); [EOL]         } [EOL]         for (int i = 0; i < init.length; i++) { [EOL]             if (inputSigma[i] > uB[i] - lB[i]) { [EOL]                 throw new OutOfRangeException(inputSigma[i], 0, uB[i] - lB[i]); [EOL]             } [EOL]         } [EOL]     } [EOL] } <line_num>: 548,563
private void initializeCMA(double[] guess) { [EOL]     if (lambda <= 0) { [EOL]         throw new NotStrictlyPositiveException(lambda); [EOL]     } [EOL]     final double[][] sigmaArray = new double[guess.length][1]; [EOL]     for (int i = 0; i < guess.length; i++) { [EOL]         sigmaArray[i][0] = inputSigma[i]; [EOL]     } [EOL]     final RealMatrix insigma = new Array2DRowRealMatrix(sigmaArray, false); [EOL]     sigma = max(insigma); [EOL]     stopTolUpX = 1e3 * max(insigma); [EOL]     stopTolX = 1e-11 * max(insigma); [EOL]     stopTolFun = 1e-12; [EOL]     stopTolHistFun = 1e-13; [EOL]     mu = lambda / 2; [EOL]     logMu2 = Math.log(mu + 0.5); [EOL]     weights = log(sequence(1, mu, 1)).scalarMultiply(-1).scalarAdd(logMu2); [EOL]     double sumw = 0; [EOL]     double sumwq = 0; [EOL]     for (int i = 0; i < mu; i++) { [EOL]         double w = weights.getEntry(i, 0); [EOL]         sumw += w; [EOL]         sumwq += w * w; [EOL]     } [EOL]     weights = weights.scalarMultiply(1 / sumw); [EOL]     mueff = sumw * sumw / sumwq; [EOL]     cc = (4 + mueff / dimension) / (dimension + 4 + 2 * mueff / dimension); [EOL]     cs = (mueff + 2) / (dimension + mueff + 3.); [EOL]     damps = (1 + 2 * Math.max(0, Math.sqrt((mueff - 1) / (dimension + 1)) - 1)) * Math.max(0.3, 1 - dimension / (1e-6 + maxIterations)) + cs; [EOL]     ccov1 = 2 / ((dimension + 1.3) * (dimension + 1.3) + mueff); [EOL]     ccovmu = Math.min(1 - ccov1, 2 * (mueff - 2 + 1 / mueff) / ((dimension + 2) * (dimension + 2) + mueff)); [EOL]     ccov1Sep = Math.min(1, ccov1 * (dimension + 1.5) / 3); [EOL]     ccovmuSep = Math.min(1 - ccov1, ccovmu * (dimension + 1.5) / 3); [EOL]     chiN = Math.sqrt(dimension) * (1 - 1 / ((double) 4 * dimension) + 1 / ((double) 21 * dimension * dimension)); [EOL]     xmean = MatrixUtils.createColumnRealMatrix(guess); [EOL]     diagD = insigma.scalarMultiply(1 / sigma); [EOL]     diagC = square(diagD); [EOL]     pc = zeros(dimension, 1); [EOL]     ps = zeros(dimension, 1); [EOL]     normps = ps.getFrobeniusNorm(); [EOL]     B = eye(dimension, dimension); [EOL]     D = ones(dimension, 1); [EOL]     BD = times(B, repmat(diagD.transpose(), dimension, 1)); [EOL]     C = B.multiply(diag(square(D)).multiply(B.transpose())); [EOL]     historySize = 10 + (int) (3 * 10 * dimension / (double) lambda); [EOL]     fitnessHistory = new double[historySize]; [EOL]     for (int i = 0; i < historySize; i++) { [EOL]         fitnessHistory[i] = Double.MAX_VALUE; [EOL]     } [EOL] } <line_num>: 570,634
private boolean updateEvolutionPaths(RealMatrix zmean, RealMatrix xold) { [EOL]     ps = ps.scalarMultiply(1 - cs).add(B.multiply(zmean).scalarMultiply(Math.sqrt(cs * (2 - cs) * mueff))); [EOL]     normps = ps.getFrobeniusNorm(); [EOL]     final boolean hsig = normps / Math.sqrt(1 - Math.pow(1 - cs, 2 * iterations)) / chiN < 1.4 + 2 / ((double) dimension + 1); [EOL]     pc = pc.scalarMultiply(1 - cc); [EOL]     if (hsig) { [EOL]         pc = pc.add(xmean.subtract(xold).scalarMultiply(Math.sqrt(cc * (2 - cc) * mueff) / sigma)); [EOL]     } [EOL]     return hsig; [EOL] } <line_num>: 644,657
private void updateCovarianceDiagonalOnly(boolean hsig, final RealMatrix bestArz) { [EOL]     double oldFac = hsig ? 0 : ccov1Sep * cc * (2 - cc); [EOL]     oldFac += 1 - ccov1Sep - ccovmuSep; [EOL]     diagC = diagC.scalarMultiply(oldFac).add(square(pc).scalarMultiply(ccov1Sep)).add((times(diagC, square(bestArz).multiply(weights))).scalarMultiply(ccovmuSep)); [EOL]     diagD = sqrt(diagC); [EOL]     if (diagonalOnly > 1 && iterations > diagonalOnly) { [EOL]         diagonalOnly = 0; [EOL]         B = eye(dimension, dimension); [EOL]         BD = diag(diagD); [EOL]         C = diag(diagC); [EOL]     } [EOL] } <line_num>: 666,684
private void updateCovariance(boolean hsig, final RealMatrix bestArx, final RealMatrix arz, final int[] arindex, final RealMatrix xold) { [EOL]     double negccov = 0; [EOL]     if (ccov1 + ccovmu > 0) { [EOL]         final RealMatrix arpos = bestArx.subtract(repmat(xold, 1, mu)).scalarMultiply(1 / sigma); [EOL]         final RealMatrix roneu = pc.multiply(pc.transpose()).scalarMultiply(ccov1); [EOL]         double oldFac = hsig ? 0 : ccov1 * cc * (2 - cc); [EOL]         oldFac += 1 - ccov1 - ccovmu; [EOL]         if (isActiveCMA) { [EOL]             negccov = (1 - ccovmu) * 0.25 * mueff / (Math.pow(dimension + 2, 1.5) + 2 * mueff); [EOL]             final double negminresidualvariance = 0.66; [EOL]             final double negalphaold = 0.5; [EOL]             final int[] arReverseIndex = reverse(arindex); [EOL]             RealMatrix arzneg = selectColumns(arz, MathArrays.copyOf(arReverseIndex, mu)); [EOL]             RealMatrix arnorms = sqrt(sumRows(square(arzneg))); [EOL]             final int[] idxnorms = sortedIndices(arnorms.getRow(0)); [EOL]             final RealMatrix arnormsSorted = selectColumns(arnorms, idxnorms); [EOL]             final int[] idxReverse = reverse(idxnorms); [EOL]             final RealMatrix arnormsReverse = selectColumns(arnorms, idxReverse); [EOL]             arnorms = divide(arnormsReverse, arnormsSorted); [EOL]             final int[] idxInv = inverse(idxnorms); [EOL]             final RealMatrix arnormsInv = selectColumns(arnorms, idxInv); [EOL]             final double negcovMax = (1 - negminresidualvariance) / square(arnormsInv).multiply(weights).getEntry(0, 0); [EOL]             if (negccov > negcovMax) { [EOL]                 negccov = negcovMax; [EOL]             } [EOL]             arzneg = times(arzneg, repmat(arnormsInv, dimension, 1)); [EOL]             final RealMatrix artmp = BD.multiply(arzneg); [EOL]             final RealMatrix Cneg = artmp.multiply(diag(weights)).multiply(artmp.transpose()); [EOL]             oldFac += negalphaold * negccov; [EOL]             C = C.scalarMultiply(oldFac).add(roneu).add(arpos.scalarMultiply(ccovmu + (1 - negalphaold) * negccov).multiply(times(repmat(weights, 1, dimension), arpos.transpose()))).subtract(Cneg.scalarMultiply(negccov)); [EOL]         } else { [EOL]             C = C.scalarMultiply(oldFac).add(roneu).add(arpos.scalarMultiply(ccovmu).multiply(times(repmat(weights, 1, dimension), arpos.transpose()))); [EOL]         } [EOL]     } [EOL]     updateBD(negccov); [EOL] } <line_num>: 697,756
private void updateBD(double negccov) { [EOL]     if (ccov1 + ccovmu + negccov > 0 && (iterations % 1. / (ccov1 + ccovmu + negccov) / dimension / 10.) < 1) { [EOL]         C = triu(C, 0).add(triu(C, 1).transpose()); [EOL]         final EigenDecomposition eig = new EigenDecomposition(C); [EOL]         B = eig.getV(); [EOL]         D = eig.getD(); [EOL]         diagD = diag(D); [EOL]         if (min(diagD) <= 0) { [EOL]             for (int i = 0; i < dimension; i++) { [EOL]                 if (diagD.getEntry(i, 0) < 0) { [EOL]                     diagD.setEntry(i, 0, 0); [EOL]                 } [EOL]             } [EOL]             final double tfac = max(diagD) / 1e14; [EOL]             C = C.add(eye(dimension, dimension).scalarMultiply(tfac)); [EOL]             diagD = diagD.add(ones(dimension, 1).scalarMultiply(tfac)); [EOL]         } [EOL]         if (max(diagD) > 1e14 * min(diagD)) { [EOL]             final double tfac = max(diagD) / 1e14 - min(diagD); [EOL]             C = C.add(eye(dimension, dimension).scalarMultiply(tfac)); [EOL]             diagD = diagD.add(ones(dimension, 1).scalarMultiply(tfac)); [EOL]         } [EOL]         diagC = diag(C); [EOL]         diagD = sqrt(diagD); [EOL]         BD = times(B, repmat(diagD.transpose(), dimension, 1)); [EOL]     } [EOL] } <line_num>: 763,792
private static void push(double[] vals, double val) { [EOL]     for (int i = vals.length - 1; i > 0; i--) { [EOL]         vals[i] = vals[i - 1]; [EOL]     } [EOL]     vals[0] = val; [EOL] } <line_num>: 800,805
private int[] sortedIndices(final double[] doubles) { [EOL]     final DoubleIndex[] dis = new DoubleIndex[doubles.length]; [EOL]     for (int i = 0; i < doubles.length; i++) { [EOL]         dis[i] = new DoubleIndex(doubles[i], i); [EOL]     } [EOL]     Arrays.sort(dis); [EOL]     final int[] indices = new int[doubles.length]; [EOL]     for (int i = 0; i < doubles.length; i++) { [EOL]         indices[i] = dis[i].index; [EOL]     } [EOL]     return indices; [EOL] } <line_num>: 813,824
public int compareTo(DoubleIndex o) { [EOL]     return Double.compare(value, o.value); [EOL] } <line_num>: 846,848
@Override [EOL] public boolean equals(Object other) { [EOL]     if (this == other) { [EOL]         return true; [EOL]     } [EOL]     if (other instanceof DoubleIndex) { [EOL]         return Double.compare(value, ((DoubleIndex) other).value) == 0; [EOL]     } [EOL]     return false; [EOL] } <line_num>: 851,863
@Override [EOL] public int hashCode() { [EOL]     long bits = Double.doubleToLongBits(value); [EOL]     return (int) ((1438542 ^ (bits >>> 32) ^ bits) & 0xffffffff); [EOL] } <line_num>: 866,870
public double value(final double[] point) { [EOL]     double value; [EOL]     if (isRepairMode) { [EOL]         double[] repaired = repair(point); [EOL]         value = CMAESOptimizer.this.computeObjectiveValue(repaired) + penalty(point, repaired); [EOL]     } else { [EOL]         value = CMAESOptimizer.this.computeObjectiveValue(point); [EOL]     } [EOL]     return isMinimize ? value : -value; [EOL] } <line_num>: 898,908
public boolean isFeasible(final double[] x) { [EOL]     final double[] lB = CMAESOptimizer.this.getLowerBound(); [EOL]     final double[] uB = CMAESOptimizer.this.getUpperBound(); [EOL]     for (int i = 0; i < x.length; i++) { [EOL]         if (x[i] < lB[i]) { [EOL]             return false; [EOL]         } [EOL]         if (x[i] > uB[i]) { [EOL]             return false; [EOL]         } [EOL]     } [EOL]     return true; [EOL] } <line_num>: 914,927
public void setValueRange(double valueRange) { [EOL]     this.valueRange = valueRange; [EOL] } <line_num>: 932,934
private double[] repair(final double[] x) { [EOL]     final double[] lB = CMAESOptimizer.this.getLowerBound(); [EOL]     final double[] uB = CMAESOptimizer.this.getUpperBound(); [EOL]     final double[] repaired = new double[x.length]; [EOL]     for (int i = 0; i < x.length; i++) { [EOL]         if (x[i] < lB[i]) { [EOL]             repaired[i] = lB[i]; [EOL]         } else if (x[i] > uB[i]) { [EOL]             repaired[i] = uB[i]; [EOL]         } else { [EOL]             repaired[i] = x[i]; [EOL]         } [EOL]     } [EOL]     return repaired; [EOL] } <line_num>: 940,955
private double penalty(final double[] x, final double[] repaired) { [EOL]     double penalty = 0; [EOL]     for (int i = 0; i < x.length; i++) { [EOL]         double diff = Math.abs(x[i] - repaired[i]); [EOL]         penalty += diff * valueRange; [EOL]     } [EOL]     return isMinimize ? penalty : -penalty; [EOL] } <line_num>: 962,969
private static RealMatrix log(final RealMatrix m) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             d[r][c] = Math.log(m.getEntry(r, c)); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 978,986
private static RealMatrix sqrt(final RealMatrix m) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             d[r][c] = Math.sqrt(m.getEntry(r, c)); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 992,1000
private static RealMatrix square(final RealMatrix m) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             double e = m.getEntry(r, c); [EOL]             d[r][c] = e * e; [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1006,1015
private static RealMatrix times(final RealMatrix m, final RealMatrix n) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             d[r][c] = m.getEntry(r, c) * n.getEntry(r, c); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1022,1030
private static RealMatrix divide(final RealMatrix m, final RealMatrix n) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             d[r][c] = m.getEntry(r, c) / n.getEntry(r, c); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1037,1045
private static RealMatrix selectColumns(final RealMatrix m, final int[] cols) { [EOL]     final double[][] d = new double[m.getRowDimension()][cols.length]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < cols.length; c++) { [EOL]             d[r][c] = m.getEntry(r, cols[c]); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1052,1060
private static RealMatrix triu(final RealMatrix m, int k) { [EOL]     final double[][] d = new double[m.getRowDimension()][m.getColumnDimension()]; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             d[r][c] = r <= c - k ? m.getEntry(r, c) : 0; [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1067,1075
private static RealMatrix sumRows(final RealMatrix m) { [EOL]     final double[][] d = new double[1][m.getColumnDimension()]; [EOL]     for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]         double sum = 0; [EOL]         for (int r = 0; r < m.getRowDimension(); r++) { [EOL]             sum += m.getEntry(r, c); [EOL]         } [EOL]         d[0][c] = sum; [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1081,1091
private static RealMatrix diag(final RealMatrix m) { [EOL]     if (m.getColumnDimension() == 1) { [EOL]         final double[][] d = new double[m.getRowDimension()][m.getRowDimension()]; [EOL]         for (int i = 0; i < m.getRowDimension(); i++) { [EOL]             d[i][i] = m.getEntry(i, 0); [EOL]         } [EOL]         return new Array2DRowRealMatrix(d, false); [EOL]     } else { [EOL]         final double[][] d = new double[m.getRowDimension()][1]; [EOL]         for (int i = 0; i < m.getColumnDimension(); i++) { [EOL]             d[i][0] = m.getEntry(i, i); [EOL]         } [EOL]         return new Array2DRowRealMatrix(d, false); [EOL]     } [EOL] } <line_num>: 1098,1112
private static void copyColumn(final RealMatrix m1, int col1, RealMatrix m2, int col2) { [EOL]     for (int i = 0; i < m1.getRowDimension(); i++) { [EOL]         m2.setEntry(i, col2, m1.getEntry(i, col1)); [EOL]     } [EOL] } <line_num>: 1122,1127
private static RealMatrix ones(int n, int m) { [EOL]     final double[][] d = new double[n][m]; [EOL]     for (int r = 0; r < n; r++) { [EOL]         Arrays.fill(d[r], 1); [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1134,1140
private static RealMatrix eye(int n, int m) { [EOL]     final double[][] d = new double[n][m]; [EOL]     for (int r = 0; r < n; r++) { [EOL]         if (r < m) { [EOL]             d[r][r] = 1; [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1148,1156
private static RealMatrix zeros(int n, int m) { [EOL]     return new Array2DRowRealMatrix(n, m); [EOL] } <line_num>: 1163,1165
private static RealMatrix repmat(final RealMatrix mat, int n, int m) { [EOL]     final int rd = mat.getRowDimension(); [EOL]     final int cd = mat.getColumnDimension(); [EOL]     final double[][] d = new double[n * rd][m * cd]; [EOL]     for (int r = 0; r < n * rd; r++) { [EOL]         for (int c = 0; c < m * cd; c++) { [EOL]             d[r][c] = mat.getEntry(r % rd, c % cd); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1173,1183
private static RealMatrix sequence(double start, double end, double step) { [EOL]     final int size = (int) ((end - start) / step + 1); [EOL]     final double[][] d = new double[size][1]; [EOL]     double value = start; [EOL]     for (int r = 0; r < size; r++) { [EOL]         d[r][0] = value; [EOL]         value += step; [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1191,1200
private static double max(final RealMatrix m) { [EOL]     double max = -Double.MAX_VALUE; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             double e = m.getEntry(r, c); [EOL]             if (max < e) { [EOL]                 max = e; [EOL]             } [EOL]         } [EOL]     } [EOL]     return max; [EOL] } <line_num>: 1206,1217
private static double min(final RealMatrix m) { [EOL]     double min = Double.MAX_VALUE; [EOL]     for (int r = 0; r < m.getRowDimension(); r++) { [EOL]         for (int c = 0; c < m.getColumnDimension(); c++) { [EOL]             double e = m.getEntry(r, c); [EOL]             if (min > e) { [EOL]                 min = e; [EOL]             } [EOL]         } [EOL]     } [EOL]     return min; [EOL] } <line_num>: 1223,1234
private static double max(final double[] m) { [EOL]     double max = -Double.MAX_VALUE; [EOL]     for (int r = 0; r < m.length; r++) { [EOL]         if (max < m[r]) { [EOL]             max = m[r]; [EOL]         } [EOL]     } [EOL]     return max; [EOL] } <line_num>: 1240,1248
private static double min(final double[] m) { [EOL]     double min = Double.MAX_VALUE; [EOL]     for (int r = 0; r < m.length; r++) { [EOL]         if (min > m[r]) { [EOL]             min = m[r]; [EOL]         } [EOL]     } [EOL]     return min; [EOL] } <line_num>: 1254,1262
private static int[] inverse(final int[] indices) { [EOL]     final int[] inverse = new int[indices.length]; [EOL]     for (int i = 0; i < indices.length; i++) { [EOL]         inverse[indices[i]] = i; [EOL]     } [EOL]     return inverse; [EOL] } <line_num>: 1268,1274
private static int[] reverse(final int[] indices) { [EOL]     final int[] reverse = new int[indices.length]; [EOL]     for (int i = 0; i < indices.length; i++) { [EOL]         reverse[i] = indices[indices.length - i - 1]; [EOL]     } [EOL]     return reverse; [EOL] } <line_num>: 1280,1286
private double[] randn(int size) { [EOL]     final double[] randn = new double[size]; [EOL]     for (int i = 0; i < size; i++) { [EOL]         randn[i] = random.nextGaussian(); [EOL]     } [EOL]     return randn; [EOL] } <line_num>: 1292,1298
private RealMatrix randn1(int size, int popSize) { [EOL]     final double[][] d = new double[size][popSize]; [EOL]     for (int r = 0; r < size; r++) { [EOL]         for (int c = 0; c < popSize; c++) { [EOL]             d[r][c] = random.nextGaussian(); [EOL]         } [EOL]     } [EOL]     return new Array2DRowRealMatrix(d, false); [EOL] } <line_num>: 1305,1313
