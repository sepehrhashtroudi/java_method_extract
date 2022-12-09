public DefaultIntervalCategoryDatasetTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 78,80
public static Test suite() { [EOL]     return new TestSuite(DefaultIntervalCategoryDatasetTests.class); [EOL] } <line_num>: 69,71
public void testGetValue() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     assertEquals(new Double(0.1), d.getStartValue("Series 1", "Category 1")); [EOL]     assertEquals(new Double(0.2), d.getStartValue("Series 1", "Category 2")); [EOL]     assertEquals(new Double(0.3), d.getStartValue("Series 1", "Category 3")); [EOL]     assertEquals(new Double(0.3), d.getStartValue("Series 2", "Category 1")); [EOL]     assertEquals(new Double(0.4), d.getStartValue("Series 2", "Category 2")); [EOL]     assertEquals(new Double(0.5), d.getStartValue("Series 2", "Category 3")); [EOL]     assertEquals(new Double(0.5), d.getEndValue("Series 1", "Category 1")); [EOL]     assertEquals(new Double(0.6), d.getEndValue("Series 1", "Category 2")); [EOL]     assertEquals(new Double(0.7), d.getEndValue("Series 1", "Category 3")); [EOL]     assertEquals(new Double(0.7), d.getEndValue("Series 2", "Category 1")); [EOL]     assertEquals(new Double(0.8), d.getEndValue("Series 2", "Category 2")); [EOL]     assertEquals(new Double(0.9), d.getEndValue("Series 2", "Category 3")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d.getValue("XX", "Category 1"); [EOL]     } catch (UnknownKeyException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         d.getValue("Series 1", "XX"); [EOL]     } catch (UnknownKeyException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 85,138
public void testGetRowAndColumnCount() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     assertEquals(2, d.getRowCount()); [EOL]     assertEquals(3, d.getColumnCount()); [EOL] } <line_num>: 144,156
public void testEquals() { [EOL]     double[] starts_S1A = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2A = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1A = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2A = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] startsA = new double[][] { starts_S1A, starts_S2A }; [EOL]     double[][] endsA = new double[][] { ends_S1A, ends_S2A }; [EOL]     DefaultIntervalCategoryDataset dA = new DefaultIntervalCategoryDataset(startsA, endsA); [EOL]     double[] starts_S1B = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2B = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1B = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2B = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] startsB = new double[][] { starts_S1B, starts_S2B }; [EOL]     double[][] endsB = new double[][] { ends_S1B, ends_S2B }; [EOL]     DefaultIntervalCategoryDataset dB = new DefaultIntervalCategoryDataset(startsB, endsB); [EOL]     assertTrue(dA.equals(dB)); [EOL]     assertTrue(dB.equals(dA)); [EOL]     DefaultIntervalCategoryDataset empty1 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     DefaultIntervalCategoryDataset empty2 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertTrue(empty1.equals(empty2)); [EOL] } <line_num>: 161,191
public void testSerialization() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     DefaultIntervalCategoryDataset d2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(d1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         d2 = (DefaultIntervalCategoryDataset) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(d1, d2); [EOL] } <line_num>: 196,224
public void testCloning() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     DefaultIntervalCategoryDataset d2 = null; [EOL]     try { [EOL]         d2 = (DefaultIntervalCategoryDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL]     d1.setStartValue(0, "Category 1", new Double(0.99)); [EOL]     assertFalse(d1.equals(d2)); [EOL]     d2.setStartValue(0, "Category 1", new Double(0.99)); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 229,254
public void testCloning2() { [EOL]     DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     DefaultIntervalCategoryDataset d2 = null; [EOL]     try { [EOL]         d2 = (DefaultIntervalCategoryDataset) d1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(d1 != d2); [EOL]     assertTrue(d1.getClass() == d2.getClass()); [EOL]     assertTrue(d1.equals(d2)); [EOL] } <line_num>: 259,273
public void testSetStartValue() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     d1.setStartValue(0, "Category 2", new Double(99.9)); [EOL]     assertEquals(new Double(99.9), d1.getStartValue("Series 1", "Category 2")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d1.setStartValue(-1, "Category 2", new Double(99.9)); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         d1.setStartValue(2, "Category 2", new Double(99.9)); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 278,308
public void testSetEndValue() { [EOL]     double[] starts_S1 = new double[] { 0.1, 0.2, 0.3 }; [EOL]     double[] starts_S2 = new double[] { 0.3, 0.4, 0.5 }; [EOL]     double[] ends_S1 = new double[] { 0.5, 0.6, 0.7 }; [EOL]     double[] ends_S2 = new double[] { 0.7, 0.8, 0.9 }; [EOL]     double[][] starts = new double[][] { starts_S1, starts_S2 }; [EOL]     double[][] ends = new double[][] { ends_S1, ends_S2 }; [EOL]     DefaultIntervalCategoryDataset d1 = new DefaultIntervalCategoryDataset(starts, ends); [EOL]     d1.setEndValue(0, "Category 2", new Double(99.9)); [EOL]     assertEquals(new Double(99.9), d1.getEndValue("Series 1", "Category 2")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         d1.setEndValue(-1, "Category 2", new Double(99.9)); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL]     pass = false; [EOL]     try { [EOL]         d1.setEndValue(2, "Category 2", new Double(99.9)); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 313,343
public void testGetSeriesCount() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(0, empty.getSeriesCount()); [EOL] } <line_num>: 348,354
public void testGetCategoryCount() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(0, empty.getCategoryCount()); [EOL] } <line_num>: 359,365
public void testGetSeriesIndex() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(-1, empty.getSeriesIndex("ABC")); [EOL] } <line_num>: 370,376
public void testGetRowIndex() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(-1, empty.getRowIndex("ABC")); [EOL] } <line_num>: 381,387
public void testSetSeriesKeys() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     boolean pass = true; [EOL]     try { [EOL]         empty.setSeriesKeys(new String[0]); [EOL]     } catch (RuntimeException e) { [EOL]         pass = false; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 392,405
public void testGetCategoryIndex() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(-1, empty.getCategoryIndex("ABC")); [EOL] } <line_num>: 410,416
public void testGetColumnIndex() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(-1, empty.getColumnIndex("ABC")); [EOL] } <line_num>: 421,427
public void testSetCategoryKeys() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     boolean pass = true; [EOL]     try { [EOL]         empty.setCategoryKeys(new String[0]); [EOL]     } catch (RuntimeException e) { [EOL]         pass = false; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 432,445
public void testGetColumnKeys() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     List keys = empty.getColumnKeys(); [EOL]     assertEquals(0, keys.size()); [EOL] } <line_num>: 450,457
public void testGetRowKeys() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     List keys = empty.getRowKeys(); [EOL]     assertEquals(0, keys.size()); [EOL] } <line_num>: 462,469
public void testGetColumnCount() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(0, empty.getColumnCount()); [EOL] } <line_num>: 474,480
public void testGetRowCount() { [EOL]     DefaultIntervalCategoryDataset empty = new DefaultIntervalCategoryDataset(new double[0][0], new double[0][0]); [EOL]     assertEquals(0, empty.getColumnCount()); [EOL] } <line_num>: 485,491
