public CategoryLabelWidthTypeTests(String name) { [EOL]     super(name); [EOL] } <line_num>: 75,77
public static Test suite() { [EOL]     return new TestSuite(CategoryLabelWidthTypeTests.class); [EOL] } <line_num>: 66,68
public void testEquals() { [EOL]     assertEquals(CategoryLabelWidthType.CATEGORY, CategoryLabelWidthType.CATEGORY); [EOL]     assertEquals(CategoryLabelWidthType.RANGE, CategoryLabelWidthType.RANGE); [EOL] } <line_num>: 82,87
public void testHashCode() { [EOL]     CategoryLabelWidthType a1 = CategoryLabelWidthType.CATEGORY; [EOL]     CategoryLabelWidthType a2 = CategoryLabelWidthType.CATEGORY; [EOL]     assertTrue(a1.equals(a2)); [EOL]     int h1 = a1.hashCode(); [EOL]     int h2 = a2.hashCode(); [EOL]     assertEquals(h1, h2); [EOL] } <line_num>: 92,99
public void testSerialization() { [EOL]     CategoryLabelWidthType w1 = CategoryLabelWidthType.RANGE; [EOL]     CategoryLabelWidthType w2 = null; [EOL]     try { [EOL]         ByteArrayOutputStream buffer = new ByteArrayOutputStream(); [EOL]         ObjectOutput out = new ObjectOutputStream(buffer); [EOL]         out.writeObject(w1); [EOL]         out.close(); [EOL]         ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray())); [EOL]         w2 = (CategoryLabelWidthType) in.readObject(); [EOL]         in.close(); [EOL]     } catch (Exception e) { [EOL]         e.printStackTrace(); [EOL]     } [EOL]     assertEquals(w1, w2); [EOL]     assertTrue(w1 == w2); [EOL] } <line_num>: 104,124