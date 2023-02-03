@SuppressWarnings("unused") [EOL] private DataHolder() { [EOL]     throw new IllegalStateException(); [EOL] } <line_num>: 71,74
public DataHolder(String data) { [EOL]     this.data = data; [EOL] } <line_num>: 76,78
@SuppressWarnings("unused") [EOL] private DataHolderWrapper() { [EOL]     this(new DataHolder(DEFAULT_VALUE)); [EOL] } <line_num>: 89,92
public DataHolderWrapper(DataHolder data) { [EOL]     this.wrappedData = data; [EOL] } <line_num>: 94,96
private SubTypes(Type subClass) { [EOL]     this.subClass = subClass; [EOL] } <line_num>: 133,135
@Override [EOL] protected void setUp() throws Exception { [EOL]     super.setUp(); [EOL]     gson = new GsonBuilder().registerTypeAdapter(DataHolder.class, new DataHolderDeserializer()).create(); [EOL] } <line_num>: 45,49
public void testDefaultConstructorNotCalledOnObject() throws Exception { [EOL]     DataHolder data = new DataHolder(DEFAULT_VALUE); [EOL]     String json = gson.toJson(data); [EOL]     DataHolder actual = gson.fromJson(json, DataHolder.class); [EOL]     assertEquals(DEFAULT_VALUE + SUFFIX, actual.getData()); [EOL] } <line_num>: 51,57
public void testDefaultConstructorNotCalledOnField() throws Exception { [EOL]     DataHolderWrapper dataWrapper = new DataHolderWrapper(new DataHolder(DEFAULT_VALUE)); [EOL]     String json = gson.toJson(dataWrapper); [EOL]     DataHolderWrapper actual = gson.fromJson(json, DataHolderWrapper.class); [EOL]     assertEquals(DEFAULT_VALUE + SUFFIX, actual.getWrappedData().getData()); [EOL] } <line_num>: 59,65
public String getData() { [EOL]     return data; [EOL] } <line_num>: 80,82
public DataHolder getWrappedData() { [EOL]     return wrappedData; [EOL] } <line_num>: 98,100
public DataHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     JsonObject jsonObj = json.getAsJsonObject(); [EOL]     String dataString = jsonObj.get("data").getAsString(); [EOL]     return new DataHolder(dataString + SUFFIX); [EOL] } <line_num>: 104,109
public MyBase deserialize(JsonElement json, Type pojoType, JsonDeserializationContext context) throws JsonParseException { [EOL]     String type = json.getAsJsonObject().get(MyBase.TYPE_ACCESS).getAsString(); [EOL]     return context.deserialize(json, SubTypes.valueOf(type).getSubclass()); [EOL] } <line_num>: 115,119
public void testJsonTypeFieldBasedDeserialization() { [EOL]     String json = "{field1:'abc',field2:'def',__type__:'SUB_TYPE1'}"; [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(MyBase.class, new JsonDeserializer<MyBase>() { [EOL]  [EOL]         public MyBase deserialize(JsonElement json, Type pojoType, JsonDeserializationContext context) throws JsonParseException { [EOL]             String type = json.getAsJsonObject().get(MyBase.TYPE_ACCESS).getAsString(); [EOL]             return context.deserialize(json, SubTypes.valueOf(type).getSubclass()); [EOL]         } [EOL]     }).create(); [EOL]     SubType1 target = (SubType1) gson.fromJson(json, MyBase.class); [EOL]     assertEquals("abc", target.field1); [EOL] } <line_num>: 112,123
public Type getSubclass() { [EOL]     return subClass; [EOL] } <line_num>: 136,138
public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 153,156
public void testCustomDeserializerReturnsNullForTopLevelObject() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(Base.class, new JsonDeserializer<Base>() { [EOL]  [EOL]         public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "{baseName:'Base',subName:'SubRevised'}"; [EOL]     Base target = gson.fromJson(json, Base.class); [EOL]     assertNull(target); [EOL] } <line_num>: 150,161
public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 166,169
public void testCustomDeserializerReturnsNull() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(Base.class, new JsonDeserializer<Base>() { [EOL]  [EOL]         public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "{base:{baseName:'Base',subName:'SubRevised'}}"; [EOL]     ClassWithBaseField target = gson.fromJson(json, ClassWithBaseField.class); [EOL]     assertNull(target.base); [EOL] } <line_num>: 163,174
public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 179,182
public void testCustomDeserializerReturnsNullForTopLevelPrimitives() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(long.class, new JsonDeserializer<Long>() { [EOL]  [EOL]         public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "10"; [EOL]     assertNull(gson.fromJson(json, long.class)); [EOL] } <line_num>: 176,186
public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 191,194
public void testCustomDeserializerReturnsNullForPrimitiveFields() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(long.class, new JsonDeserializer<Long>() { [EOL]  [EOL]         public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "{field:10}"; [EOL]     ClassWithLong target = gson.fromJson(json, ClassWithLong.class); [EOL]     assertEquals(0, target.field); [EOL] } <line_num>: 188,199
public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 207,210
public void testCustomDeserializerReturnsNullForArrayElements() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(Base.class, new JsonDeserializer<Base>() { [EOL]  [EOL]         public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "[{baseName:'Base'},{baseName:'Base'}]"; [EOL]     Base[] target = gson.fromJson(json, Base[].class); [EOL]     assertNull(target[0]); [EOL]     assertNull(target[1]); [EOL] } <line_num>: 204,216
public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]     return null; [EOL] } <line_num>: 221,224
public void testCustomDeserializerReturnsNullForArrayElementsForArrayField() { [EOL]     Gson gson = new GsonBuilder().registerTypeAdapter(Base.class, new JsonDeserializer<Base>() { [EOL]  [EOL]         public Base deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException { [EOL]             return null; [EOL]         } [EOL]     }).create(); [EOL]     String json = "{bases:[{baseName:'Base'},{baseName:'Base'}]}"; [EOL]     ClassWithBaseArray target = gson.fromJson(json, ClassWithBaseArray.class); [EOL]     assertNull(target.bases[0]); [EOL]     assertNull(target.bases[1]); [EOL] } <line_num>: 218,230
