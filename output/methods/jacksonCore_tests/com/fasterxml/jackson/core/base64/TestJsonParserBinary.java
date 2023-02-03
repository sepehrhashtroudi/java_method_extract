public void testSimple() throws IOException { [EOL]     _testSimple(false); [EOL]     _testSimple(true); [EOL] } <line_num>: 21,27
public void testInArray() throws IOException { [EOL]     _testInArray(false); [EOL]     _testInArray(true); [EOL] } <line_num>: 29,35
public void testWithEscaped() throws IOException { [EOL]     _testEscaped(false); [EOL]     _testEscaped(true); [EOL] } <line_num>: 37,42
private void _testSimple(boolean useStream) throws IOException { [EOL]     final String RESULT = "Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure."; [EOL]     final byte[] RESULT_BYTES = RESULT.getBytes("US-ASCII"); [EOL]     final String INPUT_STR = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz" + "IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg" + "dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu" + "dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo" + "ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="; [EOL]     final String DOC = "\"" + INPUT_STR + "\""; [EOL]     JsonParser jp = _getParser(DOC, useStream); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     byte[] data = jp.getBinaryValue(); [EOL]     assertNotNull(data); [EOL]     assertArrayEquals(RESULT_BYTES, data); [EOL]     jp.close(); [EOL] } <line_num>: 50,76
private void _testInArray(boolean useStream) throws IOException { [EOL]     JsonFactory jf = new JsonFactory(); [EOL]     final int entryCount = 7; [EOL]     StringWriter sw = new StringWriter(); [EOL]     JsonGenerator jg = jf.createGenerator(sw); [EOL]     jg.writeStartArray(); [EOL]     byte[][] entries = new byte[entryCount][]; [EOL]     for (int i = 0; i < entryCount; ++i) { [EOL]         byte[] b = new byte[200 + i * 100]; [EOL]         for (int x = 0; x < b.length; ++x) { [EOL]             b[x] = (byte) (i + x); [EOL]         } [EOL]         entries[i] = b; [EOL]         jg.writeBinary(b); [EOL]     } [EOL]     jg.writeEndArray(); [EOL]     jg.close(); [EOL]     JsonParser jp = _getParser(sw.toString(), useStream); [EOL]     assertToken(JsonToken.START_ARRAY, jp.nextToken()); [EOL]     for (int i = 0; i < entryCount; ++i) { [EOL]         assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]         byte[] b = jp.getBinaryValue(); [EOL]         assertArrayEquals(entries[i], b); [EOL]     } [EOL]     assertToken(JsonToken.END_ARRAY, jp.nextToken()); [EOL]     jp.close(); [EOL] } <line_num>: 78,113
private void _testEscaped(boolean useStream) throws IOException { [EOL]     String DOC = quote("VGVz\\ndCE="); [EOL]     JsonParser jp = _getParser(DOC, useStream); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     byte[] b = jp.getBinaryValue(); [EOL]     assertEquals("Test!", new String(b, "US-ASCII")); [EOL]     assertNull(jp.nextToken()); [EOL]     jp.close(); [EOL]     DOC = quote("V\\u0047V\\u007AdCE="); [EOL]     jp = _getParser(DOC, useStream); [EOL]     assertToken(JsonToken.VALUE_STRING, jp.nextToken()); [EOL]     b = jp.getBinaryValue(); [EOL]     assertEquals("Test!", new String(b, "US-ASCII")); [EOL]     assertNull(jp.nextToken()); [EOL]     jp.close(); [EOL] } <line_num>: 115,138
private JsonParser _getParser(String doc, boolean useStream) throws IOException { [EOL]     JsonFactory jf = new JsonFactory(); [EOL]     if (useStream) { [EOL]         return jf.createParser(doc.getBytes("UTF-8")); [EOL]     } [EOL]     return jf.createParser(new StringReader(doc)); [EOL] } <line_num>: 146,154