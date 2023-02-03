public void testGeneratorFeatures() throws Exception { [EOL]     JsonFactory f = new JsonFactory(); [EOL]     assertNull(f.getCodec()); [EOL]     f.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true); [EOL]     assertTrue(f.isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)); [EOL]     f.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false); [EOL]     assertFalse(f.isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)); [EOL] } <line_num>: 10,19
public void testParserFeatures() throws Exception { [EOL]     JsonFactory f = new JsonFactory(); [EOL]     assertNull(f.getCodec()); [EOL]     f.configure(JsonFactory.Feature.INTERN_FIELD_NAMES, true); [EOL]     assertTrue(f.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES)); [EOL]     f.configure(JsonFactory.Feature.INTERN_FIELD_NAMES, false); [EOL]     assertFalse(f.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES)); [EOL] } <line_num>: 21,30
public void testJsonWithFiles() throws Exception { [EOL]     File file = File.createTempFile("jackson-test", null); [EOL]     file.deleteOnExit(); [EOL]     JsonFactory f = new JsonFactory(); [EOL]     JsonGenerator jg = f.createGenerator(file, JsonEncoding.UTF16_LE); [EOL]     jg.writeStartObject(); [EOL]     jg.writeRaw("   "); [EOL]     jg.writeEndObject(); [EOL]     jg.close(); [EOL]     JsonParser jp = f.createParser(file); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextToken()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextToken()); [EOL]     assertNull(jp.nextToken()); [EOL]     jp.close(); [EOL]     jp = f.createParser(file.toURI().toURL()); [EOL]     assertToken(JsonToken.START_OBJECT, jp.nextToken()); [EOL]     assertToken(JsonToken.END_OBJECT, jp.nextToken()); [EOL]     assertNull(jp.nextToken()); [EOL]     jp.close(); [EOL]     file.delete(); [EOL] } <line_num>: 32,62
public void testCopy() throws Exception { [EOL]     JsonFactory jf = new JsonFactory(); [EOL]     assertTrue(jf.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES)); [EOL]     assertFalse(jf.isEnabled(JsonParser.Feature.ALLOW_COMMENTS)); [EOL]     assertFalse(jf.isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)); [EOL]     jf.disable(JsonFactory.Feature.INTERN_FIELD_NAMES); [EOL]     jf.enable(JsonParser.Feature.ALLOW_COMMENTS); [EOL]     jf.enable(JsonGenerator.Feature.ESCAPE_NON_ASCII); [EOL]     assertFalse(jf.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES)); [EOL]     assertTrue(jf.isEnabled(JsonParser.Feature.ALLOW_COMMENTS)); [EOL]     assertTrue(jf.isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)); [EOL]     JsonFactory jf2 = jf.copy(); [EOL]     assertFalse(jf2.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES)); [EOL]     assertTrue(jf.isEnabled(JsonParser.Feature.ALLOW_COMMENTS)); [EOL]     assertTrue(jf.isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)); [EOL] } <line_num>: 65,84
