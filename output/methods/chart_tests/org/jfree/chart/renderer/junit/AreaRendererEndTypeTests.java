public AreaRendererEndTypeTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 75,77
public static Test suite() { [EOL]     return new TestSuite(AreaRendererEndTypeTests.class); [EOL] } <line_num>: 66,68
public void testEquals() { [EOL]     assertEquals(AreaRendererEndType.LEVEL, AreaRendererEndType.LEVEL); [EOL]     assertEquals(AreaRendererEndType.TAPER, AreaRendererEndType.TAPER); [EOL]     assertEquals(AreaRendererEndType.TRUNCATE, AreaRendererEndType.TRUNCATE); [EOL] } <line_num>: 82,88
public void testSerialization() { [EOL]     AreaRendererEndType t1 = AreaRendererEndType.TAPER; [EOL]     AreaRendererEndType t2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(t1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         t2 = (AreaRendererEndType) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         System.out.println(e.toString()); [EOL]     } [EOL]     assertEquals(t1, t2); [EOL]     boolean same = t1 == t2; [EOL]     assertEquals(true, same); [EOL] } <line_num>: 93,116
