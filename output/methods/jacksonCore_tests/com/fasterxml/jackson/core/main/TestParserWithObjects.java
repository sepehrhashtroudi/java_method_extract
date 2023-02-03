public void testNextValue() throws IOException { [EOL]     _testNextValueBasic(false); [EOL]     _testNextValueBasic(true); [EOL] } <line_num>: 21,26
public void testNextValueNested() throws IOException { [EOL]     _testNextValueNested(false); [EOL]     _testNextValueNested(true); [EOL] } <line_num>: 29,34
@SuppressWarnings("resource") [EOL] public void testIsClosed() throws IOException { [EOL]     for (int i = 0; i < 4; ++i) { [EOL]         String JSON = "[ 1, 2, 3 ]"; [EOL]         boolean stream = ((i & 1) == 0); [EOL]         JsonParser jp = stream ? createParserUsingStream(JSON, "UTF-8") : createParserUsingReader(JSON); [EOL]         boolean partial = ((i & 2) == 0); [EOL]         assertFalse(jp.isClosed()); [EOL]         assertToken(JsonToken.START_ARRAY, jp.nextToken()); [EOL]         assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextToken()); [EOL]         assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextToken()); [EOL]         assertFalse(jp.isClosed()); [EOL]         if (partial) { [EOL]             jp.close(); [EOL]             assertTrue(jp.isClosed()); [EOL]         } else { [EOL]             assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextToken()); [EOL]             assertToken(JsonToken.END_ARRAY, jp.nextToken()); [EOL]             assertNull(jp.nextToken()); [EOL]             assertTrue(jp.isClosed()); [EOL]         } [EOL]     } [EOL] } <line_num>: 36,64
private void _testNextValueBasic(boolean useStream) throws IOException { [EOL]     JsonParser jp = _getParser("[ 1, 2, 3, 4 ]", useStream); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextValue()); [EOL]     for (int i = 1; i <= 4; ++i) { [EOL]         assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextValue()); [EOL]         assertEquals(i, jp.getIntValue()); [EOL]     } [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextValue()); [EOL]     assertNull(jp.nextValue()); [EOL]     jp.close(); [EOL]     jp = _getParser("{ \"3\" :3, \"4\": 4, \"5\" : 5 }", useStream); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextValue()); [EOL]     for (int i = 3; i <= 5; ++i) { [EOL]         assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextValue()); [EOL]         assertEquals(String.valueOf(i), jp.getCurrentName()); [EOL]         assertEquals(i, jp.getIntValue()); [EOL]     } [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextValue()); [EOL]     assertNull(jp.nextValue()); [EOL]     jp.close(); [EOL]     jp = _getParser("[ true, [ ], { \"a\" : 3 } ]", useStream); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextValue()); [EOL]     assertToken(JsonToken.VALUE_TRUE, jp.nextValue()); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextValue()); [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextValue()); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextValue()); [EOL]     assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextValue()); [EOL]     assertEquals("a", jp.getCurrentName()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextValue()); [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextValue()); [EOL]     assertNull(jp.nextValue()); [EOL]     jp.close(); [EOL] } <line_num>: 72,113
private void _testNextValueNested(boolean useStream) throws IOException { [EOL]     JsonParser jp; [EOL]     jp = _getParser("{\"a\": { \"b\" : true, \"c\": false }, \"d\": 3 }", useStream); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextValue()); [EOL]     assertNull(jp.getCurrentName()); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextValue()); [EOL]     assertEquals("a", jp.getCurrentName()); [EOL]     assertToken(JsonToken.VALUE_TRUE, jp.nextValue()); [EOL]     assertEquals("b", jp.getCurrentName()); [EOL]     assertToken(JsonToken.VALUE_FALSE, jp.nextValue()); [EOL]     assertEquals("c", jp.getCurrentName()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextValue()); [EOL]     assertEquals("a", jp.getCurrentName()); [EOL]     assertToken(JsonToken.VALUE_NUMBER_INT, jp.nextValue()); [EOL]     assertEquals("d", jp.getCurrentName()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextValue()); [EOL]     assertNull(jp.getCurrentName()); [EOL]     assertNull(jp.nextValue()); [EOL]     jp.close(); [EOL]     jp = _getParser("{\"a\": [ false ] }", useStream); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextValue()); [EOL]     assertNull(jp.getCurrentName()); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextValue()); [EOL]     assertEquals("a", jp.getCurrentName()); [EOL]     assertToken(JsonToken.VALUE_FALSE, jp.nextValue()); [EOL]     assertNull(jp.getCurrentName()); [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextValue()); [EOL]     assertEquals("a", jp.getCurrentName()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextValue()); [EOL]     assertNull(jp.getCurrentName()); [EOL]     assertNull(jp.nextValue()); [EOL]     jp.close(); [EOL] } <line_num>: 116,159
private JsonParser _getParser(String doc, boolean useStream) throws IOException { [EOL]     JsonFactory jf = new JsonFactory(); [EOL]     if (useStream) { [EOL]         return jf.createParser(doc.getBytes("UTF-8")); [EOL]     } [EOL]     return jf.createParser(new StringReader(doc)); [EOL] } <line_num>: 161,169
