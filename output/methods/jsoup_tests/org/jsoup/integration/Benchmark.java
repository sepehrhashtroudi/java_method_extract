public static void run(Runnable a, Runnable b, int count) { [EOL]     long aMillis; [EOL]     long bMillis; [EOL]     print("Running test A (x%d)", count); [EOL]     aMillis = time(a, count); [EOL]     print("Running test B"); [EOL]     bMillis = time(b, count); [EOL]     print("\nResults:"); [EOL]     print("A: %.2fs", aMillis / 1000f); [EOL]     print("B: %.2fs", bMillis / 1000f); [EOL]     print("\nB ran in %.2f %% time of A\n", (bMillis * 1f / aMillis * 1f) * 100f); [EOL] } <line_num>: 10,23
private static long time(Runnable test, int count) { [EOL]     Date start = new Date(); [EOL]     for (int i = 0; i < count; i++) { [EOL]         test.run(); [EOL]     } [EOL]     Date end = new Date(); [EOL]     return end.getTime() - start.getTime(); [EOL] } <line_num>: 25,32
private static void print(String msgFormat, Object... msgParams) { [EOL]     System.out.println(String.format(msgFormat, msgParams)); [EOL] } <line_num>: 34,36
