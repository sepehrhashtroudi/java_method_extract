public Base()
public Base(int v)
public Impl()
public Impl(int v, int e)
private Base811()
public Base811(Process owner)
public Process()
public Activity(Process owner, Activity parent)
private Activity()
public Scope(Process owner, Activity parent)
private Scope()
public FaultHandler(Process owner)
protected FaultHandler()
public Catch(Process owner, Activity parent)
protected Catch()
public void testPolymorphicRoundtrip() throws Exception
public void testIssue811() throws Exception
ObjectMapper mapper=Optional[new ObjectMapper()]
