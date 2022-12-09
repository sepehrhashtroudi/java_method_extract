public StandardPieURLGeneratorTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 81,83
public static Test suite() { [EOL]     return new TestSuite(StandardPieURLGeneratorTests.class); [EOL] } <line_num>: 72,74
public void testEquals() { [EOL]     StandardPieURLGenerator g1 = new StandardPieURLGenerator(); [EOL]     StandardPieURLGenerator g2 = new StandardPieURLGenerator(); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new StandardPieURLGenerator("prefix", "category", "index"); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new StandardPieURLGenerator("prefix", "category", "index"); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new StandardPieURLGenerator("prefix2", "category", "index"); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new StandardPieURLGenerator("prefix2", "category", "index"); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new StandardPieURLGenerator("prefix2", "category2", "index"); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new StandardPieURLGenerator("prefix2", "category2", "index"); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new StandardPieURLGenerator("prefix2", "category2", "index2"); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new StandardPieURLGenerator("prefix2", "category2", "index2"); [EOL]     assertTrue(g1.equals(g2)); [EOL]     g1 = new StandardPieURLGenerator("prefix2", "category2", null); [EOL]     assertFalse(g1.equals(g2)); [EOL]     g2 = new StandardPieURLGenerator("prefix2", "category2", null); [EOL]     assertTrue(g1.equals(g2)); [EOL] } <line_num>: 88,117
public void testPublicCloneable() { [EOL]     StandardPieURLGenerator g1 = new StandardPieURLGenerator("index.html?", "cat"); [EOL]     assertFalse(g1 instanceof PublicCloneable); [EOL] } <line_num>: 123,127
public void testSerialization() { [EOL]     StandardPieURLGenerator g1 = new StandardPieURLGenerator("index.html?", "cat"); [EOL]     StandardPieURLGenerator g2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(g1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         g2 = (StandardPieURLGenerator) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(g1, g2); [EOL] } <line_num>: 132,154
public void testURL() { [EOL]     DefaultPieDataset dataset = new DefaultPieDataset(); [EOL]     dataset.setValue("Alpha '1'", new Double(5.0)); [EOL]     dataset.setValue("Beta", new Double(5.5)); [EOL]     StandardPieURLGenerator g1 = new StandardPieURLGenerator("chart.jsp", "category"); [EOL]     String url = g1.generateURL(dataset, "Beta", 0); [EOL]     assertEquals("chart.jsp?category=Beta&amp;pieIndex=0", url); [EOL]     url = g1.generateURL(dataset, "Alpha '1'", 0); [EOL]     assertEquals("chart.jsp?category=Alpha+%271%27&amp;pieIndex=0", url); [EOL] } <line_num>: 159,169