public DefaultPolarItemRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 76,78
public static Test suite() { [EOL]     return new TestSuite(DefaultPolarItemRendererTests.class); [EOL] } <line_num>: 67,69
public void testEquals() { [EOL]     DefaultPolarItemRenderer r1 = new DefaultPolarItemRenderer(); [EOL]     DefaultPolarItemRenderer r2 = new DefaultPolarItemRenderer(); [EOL]     assertEquals(r1, r2); [EOL]     r1.setSeriesFilled(1, true); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setSeriesFilled(1, true); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 83,93
public void testHashcode() { [EOL]     DefaultPolarItemRenderer r1 = new DefaultPolarItemRenderer(); [EOL]     DefaultPolarItemRenderer r2 = new DefaultPolarItemRenderer(); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 98,105
public void testCloning() { [EOL]     DefaultPolarItemRenderer r1 = new DefaultPolarItemRenderer(); [EOL]     DefaultPolarItemRenderer r2 = null; [EOL]     try { [EOL]         r2 = (DefaultPolarItemRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setSeriesFilled(1, true); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setSeriesFilled(1, true); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 110,127
public void testSerialization() { [EOL]     DefaultPolarItemRenderer r1 = new DefaultPolarItemRenderer(); [EOL]     DefaultPolarItemRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (DefaultPolarItemRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 132,150