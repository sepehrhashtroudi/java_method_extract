public void testSimpleObject() throws Exception { [EOL]     String JSON = "{ \"key\" : 1, \"b\" : \"x\" }"; [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     JsonNode root = mapper.readTree(JSON); [EOL]     assertFalse(root.isValueNode()); [EOL]     assertTrue(root.isContainerNode()); [EOL]     assertFalse(root.isArray()); [EOL]     assertTrue(root.isObject()); [EOL]     assertEquals(2, root.size()); [EOL]     Iterator<JsonNode> it = root.iterator(); [EOL]     assertNotNull(it); [EOL]     assertTrue(it.hasNext()); [EOL]     JsonNode n = it.next(); [EOL]     assertNotNull(n); [EOL]     assertEquals(IntNode.valueOf(1), n); [EOL]     assertTrue(it.hasNext()); [EOL]     n = it.next(); [EOL]     assertNotNull(n); [EOL]     assertEquals(TextNode.valueOf("x"), n); [EOL]     assertFalse(it.hasNext()); [EOL]     ObjectNode obNode = (ObjectNode) root; [EOL]     Iterator<Map.Entry<String, JsonNode>> fit = obNode.fields(); [EOL]     assertTrue(fit.hasNext()); [EOL]     Map.Entry<String, JsonNode> en = fit.next(); [EOL]     assertEquals("key", en.getKey()); [EOL]     assertEquals(IntNode.valueOf(1), en.getValue()); [EOL]     assertTrue(fit.hasNext()); [EOL]     en = fit.next(); [EOL]     assertEquals("b", en.getKey()); [EOL]     assertEquals(TextNode.valueOf("x"), en.getValue()); [EOL]     fit.remove(); [EOL]     assertEquals(1, obNode.size()); [EOL]     assertEquals(IntNode.valueOf(1), root.get("key")); [EOL]     assertNull(root.get("b")); [EOL] } <line_num>: 15,62
public void testSimplePath() throws Exception { [EOL]     JsonNode root = new ObjectMapper().readTree("{ \"results\" : { \"a\" : 3 } }"); [EOL]     assertTrue(root.isObject()); [EOL]     JsonNode rnode = root.path("results"); [EOL]     assertNotNull(rnode); [EOL]     assertTrue(rnode.isObject()); [EOL]     assertEquals(3, rnode.path("a").intValue()); [EOL] } <line_num>: 64,72