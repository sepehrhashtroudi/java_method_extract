public RingPlotTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 80,82
public static Test suite() { [EOL]     return new TestSuite(RingPlotTests.class); [EOL] } <line_num>: 71,73
public void testEquals() { [EOL]     RingPlot plot1 = new RingPlot(null); [EOL]     RingPlot plot2 = new RingPlot(null); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     assertTrue(plot2.equals(plot1)); [EOL]     plot1.setSeparatorsVisible(false); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setSeparatorsVisible(false); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     Stroke s = new BasicStroke(1.1f); [EOL]     plot1.setSeparatorStroke(s); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setSeparatorStroke(s); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setSeparatorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 2.0f, 1.0f, Color.blue)); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setSeparatorPaint(new GradientPaint(1.0f, 2.0f, Color.red, 2.0f, 1.0f, Color.blue)); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setInnerSeparatorExtension(0.01); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setInnerSeparatorExtension(0.01); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setOuterSeparatorExtension(0.02); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setOuterSeparatorExtension(0.02); [EOL]     assertTrue(plot1.equals(plot2)); [EOL]     plot1.setSectionDepth(0.12); [EOL]     assertFalse(plot1.equals(plot2)); [EOL]     plot2.setSectionDepth(0.12); [EOL]     assertTrue(plot1.equals(plot2)); [EOL] } <line_num>: 87,133
public void testCloning() { [EOL]     RingPlot p1 = new RingPlot(null); [EOL]     GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red); [EOL]     p1.setSeparatorPaint(gp); [EOL]     RingPlot p2 = null; [EOL]     try { [EOL]         p2 = (RingPlot) p1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(p1 != p2); [EOL]     assertTrue(p1.getClass() == p2.getClass()); [EOL]     assertTrue(p1.equals(p2)); [EOL] } <line_num>: 138,153
public void testSerialization() { [EOL]     RingPlot p1 = new RingPlot(null); [EOL]     GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.yellow, 3.0f, 4.0f, Color.red); [EOL]     p1.setSeparatorPaint(gp); [EOL]     RingPlot p2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(p1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         p2 = (RingPlot) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(p1, p2); [EOL] } <line_num>: 158,180