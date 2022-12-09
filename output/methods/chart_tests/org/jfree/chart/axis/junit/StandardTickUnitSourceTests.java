public StandardTickUnitSourceTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 75,77
public static Test suite() { [EOL]     return new TestSuite(StandardTickUnitSourceTests.class); [EOL] } <line_num>: 66,68
public void testEquals() { [EOL]     StandardTickUnitSource t1 = new StandardTickUnitSource(); [EOL]     StandardTickUnitSource t2 = new StandardTickUnitSource(); [EOL]     assertTrue(t1.equals(t2)); [EOL] } <line_num>: 82,86
public void testSerialization() { [EOL]     StandardTickUnitSource t1 = new StandardTickUnitSource(); [EOL]     StandardTickUnitSource t2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(t1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         t2 = (StandardTickUnitSource) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(t1, t2); [EOL] } <line_num>: 91,112