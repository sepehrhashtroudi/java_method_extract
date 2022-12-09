public TimePeriodAnchorTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 75,77
public static Test suite() { [EOL]     return new TestSuite(TimePeriodAnchorTests.class); [EOL] } <line_num>: 66,68
public void testEquals() { [EOL]     assertTrue(TimePeriodAnchor.START.equals(TimePeriodAnchor.START)); [EOL]     assertTrue(TimePeriodAnchor.MIDDLE.equals(TimePeriodAnchor.MIDDLE)); [EOL]     assertTrue(TimePeriodAnchor.END.equals(TimePeriodAnchor.END)); [EOL] } <line_num>: 82,86
public void testSerialization() { [EOL]     TimePeriodAnchor a1 = TimePeriodAnchor.START; [EOL]     TimePeriodAnchor a2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(a1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         a2 = (TimePeriodAnchor) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertTrue(a1 == a2); [EOL] } <line_num>: 91,113
