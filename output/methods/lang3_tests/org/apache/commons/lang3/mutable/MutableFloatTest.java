@Test [EOL] public void testConstructors() { [EOL]     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); [EOL]     assertEquals(1f, new MutableFloat(1f).floatValue(), 0.0001f); [EOL]     assertEquals(2f, new MutableFloat(Float.valueOf(2f)).floatValue(), 0.0001f); [EOL]     assertEquals(3f, new MutableFloat(new MutableFloat(3f)).floatValue(), 0.0001f); [EOL]     assertEquals(2f, new MutableFloat("2.0").floatValue(), 0.0001f); [EOL] } <line_num>: 31,42
@Test(expected = NullPointerException.class) [EOL] public void testConstructorNull() { [EOL]     new MutableFloat((Number) null); [EOL] } <line_num>: 44,47
@Test [EOL] public void testGetSet() { [EOL]     final MutableFloat mutNum = new MutableFloat(0f); [EOL]     assertEquals(0f, new MutableFloat().floatValue(), 0.0001f); [EOL]     assertEquals(Float.valueOf(0), new MutableFloat().getValue()); [EOL]     mutNum.setValue(1); [EOL]     assertEquals(1f, mutNum.floatValue(), 0.0001f); [EOL]     assertEquals(Float.valueOf(1f), mutNum.getValue()); [EOL]     mutNum.setValue(Float.valueOf(2f)); [EOL]     assertEquals(2f, mutNum.floatValue(), 0.0001f); [EOL]     assertEquals(Float.valueOf(2f), mutNum.getValue()); [EOL]     mutNum.setValue(new MutableFloat(3f)); [EOL]     assertEquals(3f, mutNum.floatValue(), 0.0001f); [EOL]     assertEquals(Float.valueOf(3f), mutNum.getValue()); [EOL] } <line_num>: 49,66
@Test(expected = NullPointerException.class) [EOL] public void testSetNull() { [EOL]     final MutableFloat mutNum = new MutableFloat(0f); [EOL]     mutNum.setValue(null); [EOL] } <line_num>: 68,72
@Test [EOL] public void testNanInfinite() { [EOL]     MutableFloat mutNum = new MutableFloat(Float.NaN); [EOL]     assertTrue(mutNum.isNaN()); [EOL]     mutNum = new MutableFloat(Float.POSITIVE_INFINITY); [EOL]     assertTrue(mutNum.isInfinite()); [EOL]     mutNum = new MutableFloat(Float.NEGATIVE_INFINITY); [EOL]     assertTrue(mutNum.isInfinite()); [EOL] } <line_num>: 74,84
@Test [EOL] public void testEquals() { [EOL]     final MutableFloat mutNumA = new MutableFloat(0f); [EOL]     final MutableFloat mutNumB = new MutableFloat(0f); [EOL]     final MutableFloat mutNumC = new MutableFloat(1f); [EOL]     assertTrue(mutNumA.equals(mutNumA)); [EOL]     assertTrue(mutNumA.equals(mutNumB)); [EOL]     assertTrue(mutNumB.equals(mutNumA)); [EOL]     assertTrue(mutNumB.equals(mutNumB)); [EOL]     assertFalse(mutNumA.equals(mutNumC)); [EOL]     assertFalse(mutNumB.equals(mutNumC)); [EOL]     assertTrue(mutNumC.equals(mutNumC)); [EOL]     assertFalse(mutNumA.equals(null)); [EOL]     assertFalse(mutNumA.equals(Float.valueOf(0f))); [EOL]     assertFalse(mutNumA.equals("0")); [EOL] } <line_num>: 86,102
@Test [EOL] public void testHashCode() { [EOL]     final MutableFloat mutNumA = new MutableFloat(0f); [EOL]     final MutableFloat mutNumB = new MutableFloat(0f); [EOL]     final MutableFloat mutNumC = new MutableFloat(1f); [EOL]     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); [EOL]     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); [EOL]     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); [EOL]     assertTrue(mutNumA.hashCode() == Float.valueOf(0f).hashCode()); [EOL] } <line_num>: 104,114
@Test [EOL] public void testCompareTo() { [EOL]     final MutableFloat mutNum = new MutableFloat(0f); [EOL]     assertEquals(0, mutNum.compareTo(new MutableFloat(0f))); [EOL]     assertEquals(+1, mutNum.compareTo(new MutableFloat(-1f))); [EOL]     assertEquals(-1, mutNum.compareTo(new MutableFloat(1f))); [EOL] } <line_num>: 116,123
@Test(expected = NullPointerException.class) [EOL] public void testCompareToNull() { [EOL]     final MutableFloat mutNum = new MutableFloat(0f); [EOL]     mutNum.compareTo(null); [EOL] } <line_num>: 125,129
@Test [EOL] public void testPrimitiveValues() { [EOL]     final MutableFloat mutNum = new MutableFloat(1.7F); [EOL]     assertEquals(1, mutNum.intValue()); [EOL]     assertEquals(1.7, mutNum.doubleValue(), 0.00001); [EOL]     assertEquals((byte) 1, mutNum.byteValue()); [EOL]     assertEquals((short) 1, mutNum.shortValue()); [EOL]     assertEquals(1, mutNum.intValue()); [EOL]     assertEquals(1L, mutNum.longValue()); [EOL] } <line_num>: 131,141
@Test [EOL] public void testToFloat() { [EOL]     assertEquals(Float.valueOf(0f), new MutableFloat(0f).toFloat()); [EOL]     assertEquals(Float.valueOf(12.3f), new MutableFloat(12.3f).toFloat()); [EOL] } <line_num>: 143,147
@Test [EOL] public void testIncrement() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.increment(); [EOL]     assertEquals(2, mutNum.intValue()); [EOL]     assertEquals(2L, mutNum.longValue()); [EOL] } <line_num>: 149,156
@Test [EOL] public void testDecrement() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.decrement(); [EOL]     assertEquals(0, mutNum.intValue()); [EOL]     assertEquals(0L, mutNum.longValue()); [EOL] } <line_num>: 158,165
@Test [EOL] public void testAddValuePrimitive() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.add(1.1f); [EOL]     assertEquals(2.1f, mutNum.floatValue(), 0.01f); [EOL] } <line_num>: 167,173
@Test [EOL] public void testAddValueObject() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.add(Float.valueOf(1.1f)); [EOL]     assertEquals(2.1f, mutNum.floatValue(), 0.01f); [EOL] } <line_num>: 175,181
@Test [EOL] public void testSubtractValuePrimitive() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.subtract(0.9f); [EOL]     assertEquals(0.1f, mutNum.floatValue(), 0.01f); [EOL] } <line_num>: 183,189
@Test [EOL] public void testSubtractValueObject() { [EOL]     final MutableFloat mutNum = new MutableFloat(1); [EOL]     mutNum.subtract(Float.valueOf(0.9f)); [EOL]     assertEquals(0.1f, mutNum.floatValue(), 0.01f); [EOL] } <line_num>: 191,197
@Test [EOL] public void testToString() { [EOL]     assertEquals("0.0", new MutableFloat(0f).toString()); [EOL]     assertEquals("10.0", new MutableFloat(10f).toString()); [EOL]     assertEquals("-123.0", new MutableFloat(-123f).toString()); [EOL] } <line_num>: 199,204