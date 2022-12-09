public StackedAreaRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 77,79
public static Test suite() { [EOL]     return new TestSuite(StackedAreaRendererTests.class); [EOL] } <line_num>: 68,70
public void testEquals() { [EOL]     StackedAreaRenderer r1 = new StackedAreaRenderer(); [EOL]     StackedAreaRenderer r2 = new StackedAreaRenderer(); [EOL]     assertEquals(r1, r2); [EOL]     r1.setRenderAsPercentages(true); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setRenderAsPercentages(true); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 84,93
public void testHashcode() { [EOL]     StackedAreaRenderer r1 = new StackedAreaRenderer(); [EOL]     StackedAreaRenderer r2 = new StackedAreaRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 98,105
public void testCloning() { [EOL]     StackedAreaRenderer r1 = new StackedAreaRenderer(); [EOL]     StackedAreaRenderer r2 = null; [EOL]     try { [EOL]         r2 = (StackedAreaRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 110,123
public void testPublicCloneable() { [EOL]     StackedAreaRenderer r1 = new StackedAreaRenderer(); [EOL]     assertTrue(r1 instanceof PublicCloneable); [EOL] } <line_num>: 128,131
public void testSerialization() { [EOL]     StackedAreaRenderer r1 = new StackedAreaRenderer(); [EOL]     StackedAreaRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (StackedAreaRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 136,157