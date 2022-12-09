public XYStepRendererTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 83,85
public static Test suite() { [EOL]     return new TestSuite(XYStepRendererTests.class); [EOL] } <line_num>: 74,76
public void testEquals() { [EOL]     XYStepRenderer r1 = new XYStepRenderer(); [EOL]     XYStepRenderer r2 = new XYStepRenderer(); [EOL]     assertEquals(r1, r2); [EOL]     r1.setStepPoint(0.44); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setStepPoint(0.44); [EOL]     assertTrue(r1.equals(r2)); [EOL]     r1.setBaseCreateEntities(false); [EOL]     assertFalse(r1.equals(r2)); [EOL]     r2.setBaseCreateEntities(false); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 90,105
public void testHashcode() { [EOL]     XYStepRenderer r1 = new XYStepRenderer(); [EOL]     r1.setStepPoint(0.123); [EOL]     XYStepRenderer r2 = new XYStepRenderer(); [EOL]     r2.setStepPoint(0.123); [EOL]     assertTrue(r1.equals(r2)); [EOL]     int h1 = r1.hashCode(); [EOL]     int h2 = r2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 110,119
public void testCloning() { [EOL]     XYStepRenderer r1 = new XYStepRenderer(); [EOL]     XYStepRenderer r2 = null; [EOL]     try { [EOL]         r2 = (XYStepRenderer) r1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         System.err.println("Failed to clone."); [EOL]     } [EOL]     assertTrue(r1 != r2); [EOL]     assertTrue(r1.getClass() == r2.getClass()); [EOL]     assertTrue(r1.equals(r2)); [EOL] } <line_num>: 124,136
public void testPublicCloneable() { [EOL]     XYStepRenderer r1 = new XYStepRenderer(); [EOL]     assertTrue(r1 instanceof PublicCloneable); [EOL] } <line_num>: 141,144
public void testSerialization() { [EOL]     XYStepRenderer r1 = new XYStepRenderer(); [EOL]     r1.setStepPoint(0.123); [EOL]     XYStepRenderer r2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(r1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         r2 = (XYStepRenderer) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(r1, r2); [EOL] } <line_num>: 149,168
public void testDrawWithNullInfo() { [EOL]     boolean success = false; [EOL]     try { [EOL]         DefaultTableXYDataset dataset = new DefaultTableXYDataset(); [EOL]         XYSeries s1 = new XYSeries("Series 1", true, false); [EOL]         s1.add(5.0, 5.0); [EOL]         s1.add(10.0, 15.5); [EOL]         s1.add(15.0, 9.5); [EOL]         s1.add(20.0, 7.5); [EOL]         dataset.addSeries(s1); [EOL]         XYSeries s2 = new XYSeries("Series 2", true, false); [EOL]         s2.add(5.0, 5.0); [EOL]         s2.add(10.0, 15.5); [EOL]         s2.add(15.0, 9.5); [EOL]         s2.add(20.0, 3.5); [EOL]         dataset.addSeries(s2); [EOL]         XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new XYStepRenderer()); [EOL]         JFreeChart chart = new JFreeChart(plot); [EOL]         chart.createBufferedImage(300, 200, null); [EOL]         success = true; [EOL]     } catch (NullPointerException e) { [EOL]         e.printStackTrace(); [EOL]         success = false; [EOL]     } [EOL]     assertTrue(success); [EOL] } <line_num>: 174,205
public void testDrawWithNullValue() { [EOL]     boolean success = false; [EOL]     try { [EOL]         DefaultTableXYDataset dataset = new DefaultTableXYDataset(); [EOL]         XYSeries s1 = new XYSeries("Series 1", true, false); [EOL]         s1.add(5.0, 5.0); [EOL]         s1.add(10.0, null); [EOL]         s1.add(15.0, 9.5); [EOL]         s1.add(20.0, 7.5); [EOL]         dataset.addSeries(s1); [EOL]         XYSeries s2 = new XYSeries("Series 2", true, false); [EOL]         s2.add(5.0, 5.0); [EOL]         s2.add(10.0, 15.5); [EOL]         s2.add(15.0, null); [EOL]         s2.add(20.0, null); [EOL]         dataset.addSeries(s2); [EOL]         XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new XYStepRenderer()); [EOL]         JFreeChart chart = new JFreeChart(plot); [EOL]         chart.createBufferedImage(300, 200, null); [EOL]         success = true; [EOL]     } catch (NullPointerException e) { [EOL]         e.printStackTrace(); [EOL]         success = false; [EOL]     } [EOL]     assertTrue(success); [EOL] } <line_num>: 211,242
