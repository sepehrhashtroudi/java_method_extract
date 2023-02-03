public T getResult() { [EOL]     return result; [EOL] } <line_num>: 22,24
public void setResult(T result) { [EOL]     this.result = result; [EOL] } <line_num>: 26,28
public void testSubTypesFor356() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     Version v = mapper.version(); [EOL]     if (v.getMajorVersion() == 1 && v.getMinorVersion() == 6) { [EOL]         System.err.println("Note: skipping test for Jackson 1.6"); [EOL]         return; [EOL]     } [EOL]     JSONResponse<List<Parent>> input = new JSONResponse<List<Parent>>(); [EOL]     List<Parent> embedded = new ArrayList<Parent>(); [EOL]     embedded.add(new Child1()); [EOL]     embedded.add(new Child2()); [EOL]     input.setResult(embedded); [EOL]     mapper.configure(MapperFeature.USE_STATIC_TYPING, true); [EOL]     JavaType rootType = TypeFactory.defaultInstance().constructType(new TypeReference<JSONResponse<List<Parent>>>() { [EOL]     }); [EOL]     byte[] json = mapper.writerWithType(rootType).writeValueAsBytes(input); [EOL]     JSONResponse<List<Parent>> out = mapper.readValue(json, 0, json.length, rootType); [EOL]     List<Parent> deserializedContent = (List<Parent>) out.getResult(); [EOL]     assertEquals(2, deserializedContent.size()); [EOL]     assertTrue(deserializedContent.get(0) instanceof Parent); [EOL]     assertTrue(deserializedContent.get(0) instanceof Child1); [EOL]     assertFalse(deserializedContent.get(0) instanceof Child2); [EOL]     assertTrue(deserializedContent.get(1) instanceof Child2); [EOL]     assertFalse(deserializedContent.get(1) instanceof Child1); [EOL]     assertEquals("PARENT", ((Child1) deserializedContent.get(0)).parentContent); [EOL]     assertEquals("PARENT", ((Child2) deserializedContent.get(1)).parentContent); [EOL]     assertEquals("CHILD1", ((Child1) deserializedContent.get(0)).childContent1); [EOL]     assertEquals("CHILD2", ((Child2) deserializedContent.get(1)).childContent2); [EOL] } <line_num>: 50,91
