public XYBoxAnnotationTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 87,89
public static Test suite() { [EOL]     return new TestSuite(XYBoxAnnotationTests.class); [EOL] } <line_num>: 78,80
public void testEquals() { [EOL]     XYBoxAnnotation a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     XYBoxAnnotation a2 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     assertTrue(a1.equals(a2)); [EOL]     assertTrue(a2.equals(a1)); [EOL]     a1 = new XYBoxAnnotation(2.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYBoxAnnotation(2.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), Color.red, Color.blue); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), Color.red, Color.blue); [EOL]     assertTrue(a1.equals(a2)); [EOL]     GradientPaint gp1a = new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red); [EOL]     GradientPaint gp1b = new GradientPaint(1.0f, 2.0f, Color.blue, 3.0f, 4.0f, Color.red); [EOL]     GradientPaint gp2a = new GradientPaint(5.0f, 6.0f, Color.pink, 7.0f, 8.0f, Color.white); [EOL]     GradientPaint gp2b = new GradientPaint(5.0f, 6.0f, Color.pink, 7.0f, 8.0f, Color.white); [EOL]     a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), gp1a, Color.blue); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), gp1b, Color.blue); [EOL]     assertTrue(a1.equals(a2)); [EOL]     a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), gp1a, gp2a); [EOL]     assertFalse(a1.equals(a2)); [EOL]     a2 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(2.3f), gp1b, gp2b); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 94,143
public void testHashCode() { [EOL]     XYBoxAnnotation a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     XYBoxAnnotation a2 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     assertTrue(a1.equals(a2)); [EOL]     int h1 = a1.hashCode(); [EOL]     int h2 = a2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 148,157
public void testCloning() { [EOL]     XYBoxAnnotation a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     XYBoxAnnotation a2 = null; [EOL]     try { [EOL]         a2 = (XYBoxAnnotation) a1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(a1 != a2); [EOL]     assertTrue(a1.getClass() == a2.getClass()); [EOL]     assertTrue(a1.equals(a2)); [EOL] } <line_num>: 162,175
public void testPublicCloneable() { [EOL]     XYBoxAnnotation a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     assertTrue(a1 instanceof PublicCloneable); [EOL] } <line_num>: 180,184
public void testSerialization() { [EOL]     XYBoxAnnotation a1 = new XYBoxAnnotation(1.0, 2.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue); [EOL]     XYBoxAnnotation a2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(a1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         a2 = (XYBoxAnnotation) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(a1, a2); [EOL] } <line_num>: 189,210
public void testDrawWithNullInfo() { [EOL]     boolean success = false; [EOL]     try { [EOL]         DefaultTableXYDataset dataset = new DefaultTableXYDataset(); [EOL]         XYSeries s1 = new XYSeries("Series 1", true, false); [EOL]         s1.add(5.0, 5.0); [EOL]         s1.add(10.0, 15.5); [EOL]         s1.add(15.0, 9.5); [EOL]         s1.add(20.0, 7.5); [EOL]         dataset.addSeries(s1); [EOL]         XYSeries s2 = new XYSeries("Series 2", true, false); [EOL]         s2.add(5.0, 5.0); [EOL]         s2.add(10.0, 15.5); [EOL]         s2.add(15.0, 9.5); [EOL]         s2.add(20.0, 3.5); [EOL]         dataset.addSeries(s2); [EOL]         XYPlot plot = new XYPlot(dataset, new NumberAxis("X"), new NumberAxis("Y"), new XYLineAndShapeRenderer()); [EOL]         plot.addAnnotation(new XYBoxAnnotation(10.0, 12.0, 3.0, 4.0, new BasicStroke(1.2f), Color.red, Color.blue)); [EOL]         JFreeChart chart = new JFreeChart(plot); [EOL]         chart.createBufferedImage(300, 200, null); [EOL]         success = true; [EOL]     } catch (NullPointerException e) { [EOL]         e.printStackTrace(); [EOL]         success = false; [EOL]     } [EOL]     assertTrue(success); [EOL] } <line_num>: 216,249