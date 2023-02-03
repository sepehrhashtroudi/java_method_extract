public Bean() { [EOL] } <line_num>: 30,30
public Bean(String a, String b) { [EOL]     this.a = a; [EOL]     this.b = b; [EOL] } <line_num>: 31,34
public ModuleImpl(BeanDeserializerModifier modifier) { [EOL]     super("test", Version.unknownVersion()); [EOL]     this.modifier = modifier; [EOL] } <line_num>: 41,45
public RemovingModifier(String remove) { [EOL]     _removedProperty = remove; [EOL] } <line_num>: 61,61
public ReplacingModifier(JsonDeserializer<?> s) { [EOL]     _deserializer = s; [EOL] } <line_num>: 75,75
public BogusBeanDeserializer(String a, String b) { [EOL]     this.a = a; [EOL]     this.b = b; [EOL] } <line_num>: 88,91
public Issue476Deserializer(BeanDeserializer src) { [EOL]     super(src); [EOL] } <line_num>: 112,114
public Issue476Module() { [EOL]     super("Issue476Module", Version.unknownVersion()); [EOL] } <line_num>: 135,137
@Override [EOL] public void setupModule(SetupContext context) { [EOL]     super.setupModule(context); [EOL]     if (modifier != null) { [EOL]         context.addBeanDeserializerModifier(modifier); [EOL]     } [EOL] } <line_num>: 47,54
@Override [EOL] public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc, BeanDeserializerBuilder builder) { [EOL]     builder.addIgnorable(_removedProperty); [EOL]     return builder; [EOL] } <line_num>: 63,68
@Override [EOL] public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     return _deserializer; [EOL] } <line_num>: 77,81
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     return new Bean(a, b); [EOL] } <line_num>: 93,98
@Override [EOL] public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException { [EOL]     propCount++; [EOL]     return this; [EOL] } <line_num>: 116,121
@Override [EOL] public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     if (Issue476Type.class == beanDesc.getBeanClass()) { [EOL]         return new Issue476Deserializer((BeanDeserializer) deserializer); [EOL]     } [EOL]     return super.modifyDeserializer(config, beanDesc, deserializer); [EOL] } <line_num>: 124,131
@Override [EOL] public void setupModule(SetupContext context) { [EOL]     context.addBeanDeserializerModifier(new Issue476DeserializerModifier()); [EOL] } <line_num>: 139,142
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]     return new String[] { "foo" }; [EOL] } <line_num>: 154,157
@Override [EOL] public JsonDeserializer<?> modifyArrayDeserializer(DeserializationConfig config, ArrayType valueType, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     return (JsonDeserializer<?>) new StdDeserializer<Object>(Object.class) { [EOL]  [EOL]         @Override [EOL]         public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]             return new String[] { "foo" }; [EOL]         } [EOL]     }; [EOL] } <line_num>: 150,159
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]     ArrayList<String> list = new ArrayList<String>(); [EOL]     list.add("foo"); [EOL]     return list; [EOL] } <line_num>: 167,172
@Override [EOL] public JsonDeserializer<?> modifyCollectionDeserializer(DeserializationConfig config, CollectionType valueType, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     return (JsonDeserializer<?>) new StdDeserializer<Object>(Object.class) { [EOL]  [EOL]         @Override [EOL]         public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]             ArrayList<String> list = new ArrayList<String>(); [EOL]             list.add("foo"); [EOL]             return list; [EOL]         } [EOL]     }; [EOL] } <line_num>: 163,174
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]     HashMap<String, String> map = new HashMap<String, String>(); [EOL]     map.put("a", "foo"); [EOL]     return map; [EOL] } <line_num>: 182,187
@Override [EOL] public JsonDeserializer<?> modifyMapDeserializer(DeserializationConfig config, MapType valueType, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     return (JsonDeserializer<?>) new StdDeserializer<Object>(Object.class) { [EOL]  [EOL]         @Override [EOL]         public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]             HashMap<String, String> map = new HashMap<String, String>(); [EOL]             map.put("a", "foo"); [EOL]             return map; [EOL]         } [EOL]     }; [EOL] } <line_num>: 178,189
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]     return "foo"; [EOL] } <line_num>: 197,200
@Override [EOL] public JsonDeserializer<?> modifyEnumDeserializer(DeserializationConfig config, JavaType valueType, BeanDescription beanDesc, JsonDeserializer<?> deserializer) { [EOL]     return (JsonDeserializer<?>) new StdDeserializer<Object>(Object.class) { [EOL]  [EOL]         @Override [EOL]         public Object deserialize(JsonParser jp, DeserializationContext ctxt) { [EOL]             return "foo"; [EOL]         } [EOL]     }; [EOL] } <line_num>: 193,202
@Override [EOL] public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     return "foo"; [EOL] } <line_num>: 210,215
@Override [EOL] public KeyDeserializer modifyKeyDeserializer(DeserializationConfig config, JavaType valueType, KeyDeserializer kd) { [EOL]     return new KeyDeserializer() { [EOL]  [EOL]         @Override [EOL]         public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]             return "foo"; [EOL]         } [EOL]     }; [EOL] } <line_num>: 206,217
public void testPropertyRemoval() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new ModuleImpl(new RemovingModifier("a"))); [EOL]     Bean bean = mapper.readValue("{\"b\":\"2\"}", Bean.class); [EOL]     assertEquals("2", bean.b); [EOL]     assertEquals("a", bean.a); [EOL] } <line_num>: 226,234
public void testDeserializerReplacement() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new ModuleImpl(new ReplacingModifier(new BogusBeanDeserializer("foo", "bar")))); [EOL]     Bean bean = mapper.readValue("{\"a\":\"xyz\"}", Bean.class); [EOL]     assertEquals("foo", bean.a); [EOL]     assertEquals("bar", bean.b); [EOL] } <line_num>: 236,244
public void testIssue476() throws Exception { [EOL]     final String JSON = "{\"value1\" : {\"name\" : \"fruit\", \"value\" : \"apple\"}, \"value2\" : {\"name\" : \"color\", \"value\" : \"red\"}}"; [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new Issue476Module()); [EOL]     mapper.readValue(JSON, Issue476Bean.class); [EOL]     assertEquals(2, Issue476Deserializer.propCount); [EOL] } <line_num>: 246,256
public void testPOJOFromEmptyString() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     try { [EOL]         mapper.readValue(quote(""), Bean.class); [EOL]         fail("Should not accept Empty String for POJO"); [EOL]     } catch (JsonProcessingException e) { [EOL]         verifyException(e, "from String value"); [EOL]     } [EOL]     mapper = new ObjectMapper(); [EOL]     mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true); [EOL]     Bean result = mapper.readValue(quote(""), Bean.class); [EOL]     assertNull(result); [EOL] } <line_num>: 258,274
public void testModifyArrayDeserializer() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new SimpleModule("test").setDeserializerModifier(new ArrayDeserializerModifier())); [EOL]     Object[] result = mapper.readValue("[1,2]", Object[].class); [EOL]     assertEquals(1, result.length); [EOL]     assertEquals("foo", result[0]); [EOL] } <line_num>: 277,285
public void testModifyCollectionDeserializer() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new SimpleModule("test").setDeserializerModifier(new CollectionDeserializerModifier())); [EOL]     List<?> result = mapper.readValue("[1,2]", List.class); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals("foo", result.get(0)); [EOL] } <line_num>: 287,296
public void testModifyMapDeserializer() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new SimpleModule("test").setDeserializerModifier(new MapDeserializerModifier())); [EOL]     Map<?, ?> result = mapper.readValue("{\"a\":1,\"b\":2}", Map.class); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals("foo", result.get("a")); [EOL] } <line_num>: 298,307
public void testModifyEnumDeserializer() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new SimpleModule("test").setDeserializerModifier(new EnumDeserializerModifier())); [EOL]     Object result = mapper.readValue(quote("B"), EnumABC.class); [EOL]     assertEquals("foo", result); [EOL] } <line_num>: 309,317
public void testModifyKeyDeserializer() throws Exception { [EOL]     ObjectMapper mapper = new ObjectMapper(); [EOL]     mapper.registerModule(new SimpleModule("test").setDeserializerModifier(new KeyDeserializerModifier())); [EOL]     Map<?, ?> result = mapper.readValue("{\"a\":1}", Map.class); [EOL]     assertEquals(1, result.size()); [EOL]     assertEquals("foo", result.entrySet().iterator().next().getKey()); [EOL] } <line_num>: 319,328