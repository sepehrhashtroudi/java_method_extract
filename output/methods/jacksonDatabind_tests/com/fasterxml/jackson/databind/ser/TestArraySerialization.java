public void testLongStringArray() throws Exception { [EOL]     final int SIZE = 40000; [EOL]     StringBuilder sb = new StringBuilder(SIZE * 2); [EOL]     for (int i = 0; i < SIZE; ++i) { [EOL]         sb.append((char) i); [EOL]     } [EOL]     String str = sb.toString(); [EOL]     byte[] data = MAPPER.writeValueAsBytes(new String[] { "abc", str, null, str }); [EOL]     JsonParser jp = MAPPER.getFactory().createParser(data); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextToken()); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     assertEquals("abc", jp.getText()); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     String actual = jp.getText(); [EOL]     assertEquals(str.length(), actual.length()); [EOL]     assertEquals(str, actual); [EOL]     assertToken(JsonToken.VALUE_NULL, jp.nextToken()); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     assertEquals(str, jp.getText()); [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextToken()); [EOL]     assertNull(jp.nextToken()); [EOL] } <line_num>: 15,38
public void testIntArray() throws Exception { [EOL]     StringWriter sw = new StringWriter(); [EOL]     MAPPER.writeValue(sw, new int[] { 1, 2, 3, -7 }); [EOL]     assertEquals("[1,2,3,-7]", sw.toString().trim()); [EOL] } <line_num>: 40,45
public void testBigIntArray() throws Exception { [EOL]     final int SIZE = 99999; [EOL]     int[] ints = new int[SIZE]; [EOL]     for (int i = 0; i < ints.length; ++i) { [EOL]         ints[i] = i; [EOL]     } [EOL]     JsonFactory f = MAPPER.getFactory(); [EOL]     for (int round = 0; round < 3; ++round) { [EOL]         byte[] data = MAPPER.writeValueAsBytes(ints); [EOL]         JsonParser jp = f.createParser(data); [EOL]         assertToken(JsonToken.START_ARRAY, jp.nextToken()); [EOL]         for (int i = 0; i < SIZE; ++i) { [EOL]             assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextToken()); [EOL]             assertEquals(i, jp.getIntValue()); [EOL]         } [EOL]         assertToken(JsonToken.END_ARRAY, jp.nextToken()); [EOL]     } [EOL] } <line_num>: 47,69
public void testLongArray() throws Exception { [EOL]     StringWriter sw = new StringWriter(); [EOL]     MAPPER.writeValue(sw, new long[] { Long.MIN_VALUE, 0, Long.MAX_VALUE }); [EOL]     assertEquals("[" + Long.MIN_VALUE + ",0," + Long.MAX_VALUE + "]", sw.toString().trim()); [EOL] } <line_num>: 71,76
public void testStringArray() throws Exception { [EOL]     StringWriter sw = new StringWriter(); [EOL]     MAPPER.writeValue(sw, new String[] { "a", "\"foo\"", null }); [EOL]     assertEquals("[\"a\",\"\\\"foo\\\"\",null]", sw.toString().trim()); [EOL] } <line_num>: 78,83
public void testDoubleArray() throws Exception { [EOL]     StringWriter sw = new StringWriter(); [EOL]     MAPPER.writeValue(sw, new double[] { 1.01, 2.0, -7, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY }); [EOL]     assertEquals("[1.01,2.0,-7.0,\"NaN\",\"-Infinity\",\"Infinity\"]", sw.toString().trim()); [EOL] } <line_num>: 85,90
public void testFloatArray() throws Exception { [EOL]     StringWriter sw = new StringWriter(); [EOL]     MAPPER.writeValue(sw, new float[] { 1.01f, 2.0f, -7f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY }); [EOL]     assertEquals("[1.01,2.0,-7.0,\"NaN\",\"-Infinity\",\"Infinity\"]", sw.toString().trim()); [EOL] } <line_num>: 92,97
