public DefaultKeyedValuesTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 84,86
public static Test suite() { [EOL]     return new TestSuite(DefaultKeyedValuesTests.class); [EOL] } <line_num>: 75,77
protected void setUp() { [EOL] } <line_num>: 91,93
public void testConstructor() { [EOL]     DefaultKeyedValues d = new DefaultKeyedValues(); [EOL]     assertEquals(0, d.getItemCount()); [EOL] } <line_num>: 98,101
public void testGetItemCount() { [EOL]     DefaultKeyedValues d = new DefaultKeyedValues(); [EOL]     assertEquals(0, d.getItemCount()); [EOL]     d.addValue("A", 1.0); [EOL]     assertEquals(1, d.getItemCount()); [EOL]     d.addValue("B", 2.0); [EOL]     assertEquals(2, d.getItemCount()); [EOL]     d.clear(); [EOL]     assertEquals(0, d.getItemCount()); [EOL] } <line_num>: 106,115
public void testGetKeys() { [EOL]     DefaultKeyedValues d = new DefaultKeyedValues(); [EOL]     List keys = d.getKeys(); [EOL]     assertTrue(keys.isEmpty()); [EOL]     d.addValue("A", 1.0); [EOL]     keys = d.getKeys(); [EOL]     assertEquals(1, keys.size()); [EOL]     assertTrue(keys.contains("A")); [EOL]     d.addValue("B", 2.0); [EOL]     keys = d.getKeys(); [EOL]     assertEquals(2, keys.size()); [EOL]     assertTrue(keys.contains("A")); [EOL]     assertTrue(keys.contains("B")); [EOL]     d.clear(); [EOL]     keys = d.getKeys(); [EOL]     assertEquals(0, keys.size()); [EOL] } <line_num>: 120,136
public void testClear() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     v1.addValue("A", 1.0); [EOL]     v1.addValue("B", 2.0); [EOL]     assertEquals(2, v1.getItemCount()); [EOL]     v1.clear(); [EOL]     assertEquals(0, v1.getItemCount()); [EOL] } <line_num>: 141,148
public void testGetValue() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     try { [EOL]         v1.getValue(-1); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     try { [EOL]         v1.getValue(0); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     DefaultKeyedValues v2 = new DefaultKeyedValues(); [EOL]     v2.addValue("K1", new Integer(1)); [EOL]     v2.addValue("K2", new Integer(2)); [EOL]     v2.addValue("K3", new Integer(3)); [EOL]     assertEquals(new Integer(3), v2.getValue(2)); [EOL]     boolean pass = false; [EOL]     try { [EOL]         v2.getValue("KK"); [EOL]     } catch (UnknownKeyException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 153,183
public void testGetKey() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     try { [EOL]         v1.getKey(-1); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     try { [EOL]         v1.getKey(0); [EOL]         assertTrue(false); [EOL]     } catch (IndexOutOfBoundsException e) { [EOL]     } [EOL]     DefaultKeyedValues v2 = new DefaultKeyedValues(); [EOL]     v2.addValue("K1", new Integer(1)); [EOL]     v2.addValue("K2", new Integer(2)); [EOL]     v2.addValue("K3", new Integer(3)); [EOL]     assertEquals("K2", v2.getKey(1)); [EOL] } <line_num>: 188,209
public void testGetIndex() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     assertEquals(-1, v1.getIndex("K1")); [EOL]     DefaultKeyedValues v2 = new DefaultKeyedValues(); [EOL]     v2.addValue("K1", new Integer(1)); [EOL]     v2.addValue("K2", new Integer(2)); [EOL]     v2.addValue("K3", new Integer(3)); [EOL]     assertEquals(2, v2.getIndex("K3")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         v2.getIndex(null); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 214,233
public void testGetIndex2() { [EOL]     DefaultKeyedValues v = new DefaultKeyedValues(); [EOL]     assertEquals(-1, v.getIndex("K1")); [EOL]     v.addValue("K1", 1.0); [EOL]     assertEquals(0, v.getIndex("K1")); [EOL]     v.removeValue("K1"); [EOL]     assertEquals(-1, v.getIndex("K1")); [EOL] } <line_num>: 238,245
public void testAddValue() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     v1.addValue("A", 1.0); [EOL]     assertEquals(new Double(1.0), v1.getValue("A")); [EOL]     v1.addValue("B", 2.0); [EOL]     assertEquals(new Double(2.0), v1.getValue("B")); [EOL]     v1.addValue("B", 3.0); [EOL]     assertEquals(new Double(3.0), v1.getValue("B")); [EOL]     assertEquals(2, v1.getItemCount()); [EOL]     v1.addValue("A", null); [EOL]     assertNull(v1.getValue("A")); [EOL]     assertEquals(2, v1.getItemCount()); [EOL]     boolean pass = false; [EOL]     try { [EOL]         v1.addValue(null, 99.9); [EOL]     } catch (IllegalArgumentException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 250,271
public void testInsertValue() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     v1.insertValue(0, "A", 1.0); [EOL]     assertEquals(new Double(1.0), v1.getValue(0)); [EOL]     v1.insertValue(0, "B", 2.0); [EOL]     assertEquals(new Double(2.0), v1.getValue(0)); [EOL]     assertEquals(new Double(1.0), v1.getValue(1)); [EOL]     v1.insertValue(2, "C", 3.0); [EOL]     assertEquals(new Double(2.0), v1.getValue(0)); [EOL]     assertEquals(new Double(1.0), v1.getValue(1)); [EOL]     assertEquals(new Double(3.0), v1.getValue(2)); [EOL]     v1.insertValue(2, "B", 4.0); [EOL]     assertEquals(new Double(1.0), v1.getValue(0)); [EOL]     assertEquals(new Double(3.0), v1.getValue(1)); [EOL]     assertEquals(new Double(4.0), v1.getValue(2)); [EOL] } <line_num>: 276,295
public void testCloning() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     v1.addValue("V1", new Integer(1)); [EOL]     v1.addValue("V2", null); [EOL]     v1.addValue("V3", new Integer(3)); [EOL]     DefaultKeyedValues v2 = null; [EOL]     try { [EOL]         v2 = (DefaultKeyedValues) v1.clone(); [EOL]     } catch (CloneNotSupportedException e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertTrue(v1 != v2); [EOL]     assertTrue(v1.getClass() == v2.getClass()); [EOL]     assertTrue(v1.equals(v2)); [EOL]     v2.setValue("V1", new Integer(44)); [EOL]     assertFalse(v1.equals(v2)); [EOL] } <line_num>: 300,319
public void testInsertAndRetrieve() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("A", new Double(1.0)); [EOL]     data.addValue("B", new Double(2.0)); [EOL]     data.addValue("C", new Double(3.0)); [EOL]     data.addValue("D", null); [EOL]     assertEquals(data.getKey(0), "A"); [EOL]     assertEquals(data.getKey(1), "B"); [EOL]     assertEquals(data.getKey(2), "C"); [EOL]     assertEquals(data.getKey(3), "D"); [EOL]     assertEquals(data.getValue("A"), new Double(1.0)); [EOL]     assertEquals(data.getValue("B"), new Double(2.0)); [EOL]     assertEquals(data.getValue("C"), new Double(3.0)); [EOL]     assertEquals(data.getValue("D"), null); [EOL]     assertEquals(data.getValue(0), new Double(1.0)); [EOL]     assertEquals(data.getValue(1), new Double(2.0)); [EOL]     assertEquals(data.getValue(2), new Double(3.0)); [EOL]     assertEquals(data.getValue(3), null); [EOL] } <line_num>: 324,348
public void testRemoveValue() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("A", new Double(1.0)); [EOL]     data.addValue("B", null); [EOL]     data.addValue("C", new Double(3.0)); [EOL]     data.addValue("D", new Double(2.0)); [EOL]     assertEquals(1, data.getIndex("B")); [EOL]     data.removeValue("B"); [EOL]     assertEquals(-1, data.getIndex("B")); [EOL]     boolean pass = false; [EOL]     try { [EOL]         data.removeValue("XXX"); [EOL]     } catch (UnknownKeyException e) { [EOL]         pass = true; [EOL]     } [EOL]     assertTrue(pass); [EOL] } <line_num>: 353,371
public void testSortByKeyAscending() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("C", new Double(1.0)); [EOL]     data.addValue("B", null); [EOL]     data.addValue("D", new Double(3.0)); [EOL]     data.addValue("A", new Double(2.0)); [EOL]     data.sortByKeys(SortOrder.ASCENDING); [EOL]     assertEquals(data.getKey(0), "A"); [EOL]     assertEquals(data.getKey(1), "B"); [EOL]     assertEquals(data.getKey(2), "C"); [EOL]     assertEquals(data.getKey(3), "D"); [EOL]     assertEquals(data.getValue("A"), new Double(2.0)); [EOL]     assertEquals(data.getValue("B"), null); [EOL]     assertEquals(data.getValue("C"), new Double(1.0)); [EOL]     assertEquals(data.getValue("D"), new Double(3.0)); [EOL]     assertEquals(data.getValue(0), new Double(2.0)); [EOL]     assertEquals(data.getValue(1), null); [EOL]     assertEquals(data.getValue(2), new Double(1.0)); [EOL]     assertEquals(data.getValue(3), new Double(3.0)); [EOL] } <line_num>: 376,402
public void testSortByKeyDescending() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("C", new Double(1.0)); [EOL]     data.addValue("B", null); [EOL]     data.addValue("D", new Double(3.0)); [EOL]     data.addValue("A", new Double(2.0)); [EOL]     data.sortByKeys(SortOrder.DESCENDING); [EOL]     assertEquals(data.getKey(0), "D"); [EOL]     assertEquals(data.getKey(1), "C"); [EOL]     assertEquals(data.getKey(2), "B"); [EOL]     assertEquals(data.getKey(3), "A"); [EOL]     assertEquals(data.getValue("A"), new Double(2.0)); [EOL]     assertEquals(data.getValue("B"), null); [EOL]     assertEquals(data.getValue("C"), new Double(1.0)); [EOL]     assertEquals(data.getValue("D"), new Double(3.0)); [EOL]     assertEquals(data.getValue(0), new Double(3.0)); [EOL]     assertEquals(data.getValue(1), new Double(1.0)); [EOL]     assertEquals(data.getValue(2), null); [EOL]     assertEquals(data.getValue(3), new Double(2.0)); [EOL] } <line_num>: 407,433
public void testSortByValueAscending() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("C", new Double(1.0)); [EOL]     data.addValue("B", null); [EOL]     data.addValue("D", new Double(3.0)); [EOL]     data.addValue("A", new Double(2.0)); [EOL]     data.sortByValues(SortOrder.ASCENDING); [EOL]     assertEquals(data.getKey(0), "C"); [EOL]     assertEquals(data.getKey(1), "A"); [EOL]     assertEquals(data.getKey(2), "D"); [EOL]     assertEquals(data.getKey(3), "B"); [EOL]     assertEquals(data.getValue("A"), new Double(2.0)); [EOL]     assertEquals(data.getValue("B"), null); [EOL]     assertEquals(data.getValue("C"), new Double(1.0)); [EOL]     assertEquals(data.getValue("D"), new Double(3.0)); [EOL]     assertEquals(data.getValue(0), new Double(1.0)); [EOL]     assertEquals(data.getValue(1), new Double(2.0)); [EOL]     assertEquals(data.getValue(2), new Double(3.0)); [EOL]     assertEquals(data.getValue(3), null); [EOL] } <line_num>: 438,464
public void testSortByValueDescending() { [EOL]     DefaultKeyedValues data = new DefaultKeyedValues(); [EOL]     data.addValue("C", new Double(1.0)); [EOL]     data.addValue("B", null); [EOL]     data.addValue("D", new Double(3.0)); [EOL]     data.addValue("A", new Double(2.0)); [EOL]     data.sortByValues(SortOrder.DESCENDING); [EOL]     assertEquals(data.getKey(0), "D"); [EOL]     assertEquals(data.getKey(1), "A"); [EOL]     assertEquals(data.getKey(2), "C"); [EOL]     assertEquals(data.getKey(3), "B"); [EOL]     assertEquals(data.getValue("A"), new Double(2.0)); [EOL]     assertEquals(data.getValue("B"), null); [EOL]     assertEquals(data.getValue("C"), new Double(1.0)); [EOL]     assertEquals(data.getValue("D"), new Double(3.0)); [EOL]     assertEquals(data.getValue(0), new Double(3.0)); [EOL]     assertEquals(data.getValue(1), new Double(2.0)); [EOL]     assertEquals(data.getValue(2), new Double(1.0)); [EOL]     assertEquals(data.getValue(3), null); [EOL] } <line_num>: 469,495
public void testSerialization() { [EOL]     DefaultKeyedValues v1 = new DefaultKeyedValues(); [EOL]     v1.addValue("Key 1", new Double(23)); [EOL]     v1.addValue("Key 2", null); [EOL]     v1.addValue("Key 3", new Double(42)); [EOL]     DefaultKeyedValues v2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(v1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         v2 = (DefaultKeyedValues) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(v1, v2); [EOL] } <line_num>: 500,521
