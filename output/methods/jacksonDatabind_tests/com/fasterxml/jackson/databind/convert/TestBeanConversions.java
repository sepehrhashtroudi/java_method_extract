public Point() { [EOL] } <line_num>: 21,21
public Point(int a, int b, int c) { [EOL]     x = a; [EOL]     y = b; [EOL]     z = c; [EOL] } <line_num>: 22,27
public PointStrings(String x, String y) { [EOL]     this.x = x; [EOL]     this.y = y; [EOL] } <line_num>: 33,36
public ObjectWrapper() { [EOL] } <line_num>: 51,51
public ObjectWrapper(Object o) { [EOL]     data = o; [EOL] } <line_num>: 52,52
public Leaf() { [EOL] } <line_num>: 61,61
public Leaf(int v) { [EOL]     value = v; [EOL] } <line_num>: 62,62
public Object getData() { [EOL]     return data; [EOL] } <line_num>: 54,54
public void setData(Object data) { [EOL]     this.data = data; [EOL] } <line_num>: 55,55
public void testBeanConvert() { [EOL]     PointStrings input = new PointStrings("37", "-9"); [EOL]     Point point = MAPPER.convertValue(input, Point.class); [EOL]     assertEquals(37, point.x); [EOL]     assertEquals(-9, point.y); [EOL]     assertEquals(-13, point.z); [EOL] } <line_num>: 71,80
public void testErrorReporting() throws Exception { [EOL]     try { [EOL]         MAPPER.readValue("{\"unknownProp\":true}", BooleanBean.class); [EOL]     } catch (JsonProcessingException e) { [EOL]         verifyException(e, "unknownProp"); [EOL]     } [EOL]     try { [EOL]         MAPPER.readValue("{\"boolProp\":\"foobar\"}", BooleanBean.class); [EOL]     } catch (JsonProcessingException e) { [EOL]         verifyException(e, "boolProp"); [EOL]     } [EOL] } <line_num>: 84,100
public void testIssue458() throws Exception { [EOL]     ObjectWrapper a = new ObjectWrapper("foo"); [EOL]     ObjectWrapper b = new ObjectWrapper(a); [EOL]     ObjectWrapper b2 = MAPPER.convertValue(b, ObjectWrapper.class); [EOL]     ObjectWrapper a2 = MAPPER.convertValue(b2.getData(), ObjectWrapper.class); [EOL]     assertEquals("foo", a2.getData()); [EOL] } <line_num>: 102,109
public void testWrapping() throws Exception { [EOL]     ObjectMapper wrappingMapper = new ObjectMapper(); [EOL]     wrappingMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE); [EOL]     wrappingMapper.enable(SerializationFeature.WRAP_ROOT_VALUE); [EOL]     _convertAndVerifyPoint(wrappingMapper); [EOL]     wrappingMapper = new ObjectMapper(); [EOL]     wrappingMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE); [EOL]     wrappingMapper.disable(SerializationFeature.WRAP_ROOT_VALUE); [EOL]     _convertAndVerifyPoint(wrappingMapper); [EOL]     wrappingMapper = new ObjectMapper(); [EOL]     wrappingMapper.disable(DeserializationFeature.UNWRAP_ROOT_VALUE); [EOL]     wrappingMapper.enable(SerializationFeature.WRAP_ROOT_VALUE); [EOL]     _convertAndVerifyPoint(wrappingMapper); [EOL] } <line_num>: 112,132
public void testConvertUsingCast() throws Exception { [EOL]     String str = new String("foo"); [EOL]     CharSequence seq = str; [EOL]     String result = MAPPER.convertValue(seq, String.class); [EOL]     assertSame(str, result); [EOL] } <line_num>: 135,142
public void testNodeConvert() throws Exception { [EOL]     ObjectNode src = (ObjectNode) MAPPER.readTree("{}"); [EOL]     TreeNode node = src; [EOL]     ObjectNode result = MAPPER.treeToValue(node, ObjectNode.class); [EOL]     assertSame(src, result); [EOL] } <line_num>: 145,152
private void _convertAndVerifyPoint(ObjectMapper m) { [EOL]     final Point input = new Point(1, 2, 3); [EOL]     Point output = m.convertValue(input, Point.class); [EOL]     assertEquals(1, output.x); [EOL]     assertEquals(2, output.y); [EOL]     assertEquals(3, output.z); [EOL] } <line_num>: 154,161
public void testIssue11() throws Exception { [EOL]     ObjectNode root = MAPPER.createObjectNode(); [EOL]     JsonNode n = root; [EOL]     ObjectNode ob2 = MAPPER.convertValue(n, ObjectNode.class); [EOL]     assertSame(root, ob2); [EOL]     JsonNode n2 = MAPPER.convertValue(n, JsonNode.class); [EOL]     assertSame(root, n2); [EOL]     String STR = "test"; [EOL]     CharSequence seq = MAPPER.convertValue(STR, CharSequence.class); [EOL]     assertSame(STR, seq); [EOL]     Leaf l = new Leaf(13); [EOL]     Map<?, ?> m = MAPPER.convertValue(l, Map.class); [EOL]     assertNotNull(m); [EOL]     assertEquals(1, m.size()); [EOL]     assertEquals(Integer.valueOf(13), m.get("value")); [EOL]     Leaf l2 = MAPPER.convertValue(m, Leaf.class); [EOL]     assertEquals(13, l2.value); [EOL]     Object ob = MAPPER.convertValue(l, Object.class); [EOL]     assertNotNull(ob); [EOL]     assertEquals(LinkedHashMap.class, ob.getClass()); [EOL]     final Object plaino = new Object(); [EOL]     try { [EOL]         m = MAPPER.convertValue(plaino, Map.class); [EOL]         fail("Conversion should have failed"); [EOL]     } catch (IllegalArgumentException e) { [EOL]         verifyException(e, "no properties discovered"); [EOL]     } [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); [EOL]     try { [EOL]         assertEquals("{}", mapper.writeValueAsString(plaino)); [EOL]     } catch (Exception e) { [EOL]         throw (Exception) e.getCause(); [EOL]     } [EOL]     m = mapper.convertValue(plaino, Map.class); [EOL]     assertNotNull(m); [EOL]     assertEquals(0, m.size()); [EOL] } <line_num>: 166,219