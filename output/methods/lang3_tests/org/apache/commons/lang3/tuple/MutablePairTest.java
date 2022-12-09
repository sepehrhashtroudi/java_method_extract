@Test [EOL] public void testBasic() throws Exception { [EOL]     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); [EOL]     assertEquals(0, pair.getLeft().intValue()); [EOL]     assertEquals("foo", pair.getRight()); [EOL]     final MutablePair<Object, String> pair2 = new MutablePair<Object, String>(null, "bar"); [EOL]     assertNull(pair2.getLeft()); [EOL]     assertEquals("bar", pair2.getRight()); [EOL] } <line_num>: 37,45
@Test [EOL] public void testDefault() throws Exception { [EOL]     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(); [EOL]     assertNull(pair.getLeft()); [EOL]     assertNull(pair.getRight()); [EOL] } <line_num>: 47,52
@Test [EOL] public void testMutate() throws Exception { [EOL]     final MutablePair<Integer, String> pair = new MutablePair<Integer, String>(0, "foo"); [EOL]     pair.setLeft(42); [EOL]     pair.setRight("bar"); [EOL]     assertEquals(42, pair.getLeft().intValue()); [EOL]     assertEquals("bar", pair.getRight()); [EOL] } <line_num>: 54,61
@Test [EOL] public void testPairOf() throws Exception { [EOL]     final MutablePair<Integer, String> pair = MutablePair.of(0, "foo"); [EOL]     assertEquals(0, pair.getLeft().intValue()); [EOL]     assertEquals("foo", pair.getRight()); [EOL]     final MutablePair<Object, String> pair2 = MutablePair.of(null, "bar"); [EOL]     assertNull(pair2.getLeft()); [EOL]     assertEquals("bar", pair2.getRight()); [EOL] } <line_num>: 63,71
@Test [EOL] public void testEquals() throws Exception { [EOL]     assertEquals(MutablePair.of(null, "foo"), MutablePair.of(null, "foo")); [EOL]     assertFalse(MutablePair.of("foo", 0).equals(MutablePair.of("foo", null))); [EOL]     assertFalse(MutablePair.of("foo", "bar").equals(MutablePair.of("xyz", "bar"))); [EOL]     final MutablePair<String, String> p = MutablePair.of("foo", "bar"); [EOL]     assertTrue(p.equals(p)); [EOL]     assertFalse(p.equals(new Object())); [EOL] } <line_num>: 73,82
@Test [EOL] public void testHashCode() throws Exception { [EOL]     assertEquals(MutablePair.of(null, "foo").hashCode(), MutablePair.of(null, "foo").hashCode()); [EOL] } <line_num>: 84,87
@Test [EOL] public void testToString() throws Exception { [EOL]     assertEquals("(null,null)", MutablePair.of(null, null).toString()); [EOL]     assertEquals("(null,two)", MutablePair.of(null, "two").toString()); [EOL]     assertEquals("(one,null)", MutablePair.of("one", null).toString()); [EOL]     assertEquals("(one,two)", MutablePair.of("one", "two").toString()); [EOL] } <line_num>: 89,95
@Test [EOL] @SuppressWarnings("unchecked") [EOL] public void testSerialization() throws Exception { [EOL]     final MutablePair<Integer, String> origPair = MutablePair.of(0, "foo"); [EOL]     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); [EOL]     final ObjectOutputStream out = new ObjectOutputStream(baos); [EOL]     out.writeObject(origPair); [EOL]     final MutablePair<Integer, String> deserializedPair = (MutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); [EOL]     assertEquals(origPair, deserializedPair); [EOL]     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); [EOL] } <line_num>: 97,108
