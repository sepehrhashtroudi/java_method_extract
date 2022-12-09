public Stats(String pass)
 PerformanceTracker(Node jsRoot, TracerMode mode)
private CodeSizeEstimatePrinter(boolean trackGzippedSize)
 CodeChangeHandler getCodeChangeHandler()
 void recordPassStart(String passName)
 void recordPassStop(String passName, long result)
private void updateStats(Stats stats, long result, CodeSizeEstimatePrinter printer)
private static void recordSizeChange(int oldSize, int newSize, Stats record)
private static void recordGzSizeChange(int oldSize, int newSize, Stats record)
private final CodeSizeEstimatePrinter estimateCodeSize(Node root)
public ImmutableMap<String, Stats> getStats()
public int compare(Entry<String, Stats> e1, Entry<String, Stats> e2)
public void outputTracerReport(PrintStream pstr)
 void append(String str)
 char getLastChar()
private int calcSize()
private int calcZippedSize()
Node jsRoot
boolean trackSize
boolean trackGzippedSize
RecentChange codeChange=Optional[new RecentChange()]
int curCodeSizeEstimate=Optional[-1]
int curZippedCodeSizeEstimate=Optional[-1]
Deque<String> currentRunningPass=Optional[new ArrayDeque<String>()]
Map<String, Stats> summary=Optional[Maps.newHashMap()]
ImmutableMap<String, Stats> summaryCopy=Optional[null]
List<Stats> log=Optional[Lists.newArrayList()]
