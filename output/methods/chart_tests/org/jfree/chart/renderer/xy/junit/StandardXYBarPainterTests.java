public StandardXYBarPainterTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 76,78
public static Test suite() { [EOL]     return new TestSuite(StandardXYBarPainterTests.class); [EOL] } <line_num>: 67,69
public void testEquals() { [EOL]     StandardXYBarPainter p1 = new StandardXYBarPainter(); [EOL]     StandardXYBarPainter p2 = new StandardXYBarPainter(); [EOL]     assertEquals(p1, p2); [EOL] } <line_num>: 83,87
public void testHashcode() { [EOL]     StandardXYBarPainter p1 = new StandardXYBarPainter(); [EOL]     StandardXYBarPainter p2 = new StandardXYBarPainter(); [EOL]     assertTrue(p1.equals(p2)); [EOL]     int h1 = p1.hashCode(); [EOL]     int h2 = p2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 92,99
public void testCloning() { [EOL]     StandardXYBarPainter p1 = new StandardXYBarPainter(); [EOL]     assertFalse(p1 instanceof Cloneable); [EOL]     assertFalse(p1 instanceof PublicCloneable); [EOL] } <line_num>: 105,109
public void testSerialization() { [EOL]     StandardXYBarPainter p1 = new StandardXYBarPainter(); [EOL]     StandardXYBarPainter p2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(p1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         p2 = (StandardXYBarPainter) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(p1, p2); [EOL] } <line_num>: 114,131
