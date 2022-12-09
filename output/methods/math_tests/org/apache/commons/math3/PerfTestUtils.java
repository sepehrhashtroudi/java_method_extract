public RunTest(String name) { [EOL]     this.name = name; [EOL] } <line_num>: 246,248
public static StatisticalSummary[] time(int repeatChunk, int repeatStat, boolean runGC, Callable<Double>... methods) { [EOL]     final double[][][] times = timesAndResults(repeatChunk, repeatStat, runGC, methods); [EOL]     final int len = methods.length; [EOL]     final StatisticalSummary[] stats = new StatisticalSummary[len]; [EOL]     for (int j = 0; j < len; j++) { [EOL]         final SummaryStatistics s = new SummaryStatistics(); [EOL]         for (int k = 0; k < repeatStat; k++) { [EOL]             s.addValue(times[j][k][0]); [EOL]         } [EOL]         stats[j] = s.getSummary(); [EOL]     } [EOL]     return stats; [EOL] } <line_num>: 53,73
public static double[][][] timesAndResults(int repeatChunk, int repeatStat, boolean runGC, Callable<Double>... methods) { [EOL]     final int numMethods = methods.length; [EOL]     final double[][][] timesAndResults = new double[numMethods][repeatStat][2]; [EOL]     try { [EOL]         for (int k = 0; k < repeatStat; k++) { [EOL]             for (int j = 0; j < numMethods; j++) { [EOL]                 if (runGC) { [EOL]                     System.gc(); [EOL]                 } [EOL]                 final Callable<Double> r = methods[j]; [EOL]                 final double[] result = new double[repeatChunk]; [EOL]                 final long start = System.nanoTime(); [EOL]                 for (int i = 0; i < repeatChunk; i++) { [EOL]                     result[i] = r.call().doubleValue(); [EOL]                 } [EOL]                 final long stop = System.nanoTime(); [EOL]                 timesAndResults[j][k][0] = (stop - start) * NANO_TO_MILLI; [EOL]                 timesAndResults[j][k][1] = result[rng.nextInt(repeatChunk)]; [EOL]             } [EOL]         } [EOL]     } catch (Exception e) { [EOL]         throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, e.getMessage()); [EOL]     } [EOL]     final double normFactor = 1d / repeatChunk; [EOL]     for (int j = 0; j < numMethods; j++) { [EOL]         for (int k = 0; k < repeatStat; k++) { [EOL]             timesAndResults[j][k][0] *= normFactor; [EOL]         } [EOL]     } [EOL]     return timesAndResults; [EOL] } <line_num>: 97,141
@SuppressWarnings("boxing") [EOL] public static StatisticalSummary[] timeAndReport(String title, int repeatChunk, int repeatStat, boolean runGC, RunTest... methods) { [EOL]     final String hFormat = "%s (calls per timed block: %d, timed blocks: %d, time unit: ms)"; [EOL]     int nameLength = 0; [EOL]     for (RunTest m : methods) { [EOL]         int len = m.getName().length(); [EOL]         if (len > nameLength) { [EOL]             nameLength = len; [EOL]         } [EOL]     } [EOL]     final String nameLengthFormat = "%" + nameLength + "s"; [EOL]     final String cFormat = nameLengthFormat + " %14s %14s %10s %10s %15s"; [EOL]     final String format = nameLengthFormat + " %.8e %.8e %.4e %.4e % .8e"; [EOL]     System.out.println(String.format(hFormat, title, repeatChunk, repeatStat)); [EOL]     System.out.println(String.format(cFormat, "name", "time/call", "std error", "total time", "ratio", "difference")); [EOL]     final StatisticalSummary[] time = time(repeatChunk, repeatStat, runGC, methods); [EOL]     final double refSum = time[0].getSum() * repeatChunk; [EOL]     for (int i = 0, max = time.length; i < max; i++) { [EOL]         final StatisticalSummary s = time[i]; [EOL]         final double sum = s.getSum() * repeatChunk; [EOL]         System.out.println(String.format(format, methods[i].getName(), s.getMean(), s.getStandardDeviation(), sum, sum / refSum, sum - refSum)); [EOL]     } [EOL]     return time; [EOL] } <line_num>: 161,214
public static StatisticalSummary[] timeAndReport(String title, RunTest... methods) { [EOL]     return timeAndReport(title, DEFAULT_REPEAT_CHUNK, DEFAULT_REPEAT_STAT, false, methods); [EOL] } <line_num>: 228,235
public String getName() { [EOL]     return name; [EOL] } <line_num>: 253,255
public abstract Double call() throws Exception; <line_num>: 258,258
