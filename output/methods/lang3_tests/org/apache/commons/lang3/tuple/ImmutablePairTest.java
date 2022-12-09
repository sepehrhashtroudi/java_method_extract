@Test [EOL] public void testBasic() throws Exception { [EOL]     final ImmutablePair<Integer, String> pair = new ImmutablePair<Integer, String>(0, "foo"); [EOL]     assertEquals(0, pair.left.intValue()); [EOL]     assertEquals(0, pair.getLeft().intValue()); [EOL]     assertEquals("foo", pair.right); [EOL]     assertEquals("foo", pair.getRight()); [EOL]     final ImmutablePair<Object, String> pair2 = new ImmutablePair<Object, String>(null, "bar"); [EOL]     assertNull(pair2.left); [EOL]     assertNull(pair2.getLeft()); [EOL]     assertEquals("bar", pair2.right); [EOL]     assertEquals("bar", pair2.getRight()); [EOL] } <line_num>: 37,49
@Test [EOL] public void testPairOf() throws Exception { [EOL]     final ImmutablePair<Integer, String> pair = ImmutablePair.of(0, "foo"); [EOL]     assertEquals(0, pair.left.intValue()); [EOL]     assertEquals(0, pair.getLeft().intValue()); [EOL]     assertEquals("foo", pair.right); [EOL]     assertEquals("foo", pair.getRight()); [EOL]     final ImmutablePair<Object, String> pair2 = ImmutablePair.of(null, "bar"); [EOL]     assertNull(pair2.left); [EOL]     assertNull(pair2.getLeft()); [EOL]     assertEquals("bar", pair2.right); [EOL]     assertEquals("bar", pair2.getRight()); [EOL] } <line_num>: 51,63
@Test [EOL] public void testEquals() throws Exception { [EOL]     assertEquals(ImmutablePair.of(null, "foo"), ImmutablePair.of(null, "foo")); [EOL]     assertFalse(ImmutablePair.of("foo", 0).equals(ImmutablePair.of("foo", null))); [EOL]     assertFalse(ImmutablePair.of("foo", "bar").equals(ImmutablePair.of("xyz", "bar"))); [EOL]     final ImmutablePair<String, String> p = ImmutablePair.of("foo", "bar"); [EOL]     assertTrue(p.equals(p)); [EOL]     assertFalse(p.equals(new Object())); [EOL] } <line_num>: 65,74
@Test [EOL] public void testHashCode() throws Exception { [EOL]     assertEquals(ImmutablePair.of(null, "foo").hashCode(), ImmutablePair.of(null, "foo").hashCode()); [EOL] } <line_num>: 76,79
@Test [EOL] public void testToString() throws Exception { [EOL]     assertEquals("(null,null)", ImmutablePair.of(null, null).toString()); [EOL]     assertEquals("(null,two)", ImmutablePair.of(null, "two").toString()); [EOL]     assertEquals("(one,null)", ImmutablePair.of("one", null).toString()); [EOL]     assertEquals("(one,two)", ImmutablePair.of("one", "two").toString()); [EOL] } <line_num>: 81,87
@Test [EOL] @SuppressWarnings("unchecked") [EOL] public void testSerialization() throws Exception { [EOL]     final ImmutablePair<Integer, String> origPair = ImmutablePair.of(0, "foo"); [EOL]     final ByteArrayOutputStream baos = new ByteArrayOutputStream(); [EOL]     final ObjectOutputStream out = new ObjectOutputStream(baos); [EOL]     out.writeObject(origPair); [EOL]     final ImmutablePair<Integer, String> deserializedPair = (ImmutablePair<Integer, String>) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject(); [EOL]     assertEquals(origPair, deserializedPair); [EOL]     assertEquals(origPair.hashCode(), deserializedPair.hashCode()); [EOL] } <line_num>: 89,100
