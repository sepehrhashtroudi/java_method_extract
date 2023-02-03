protected StdArraySerializers() { [EOL] } <line_num>: 39,39
protected TypedPrimitiveArraySerializer(Class<T> cls) { [EOL]     super(cls); [EOL]     _valueTypeSerializer = null; [EOL] } <line_num>: 68,71
protected TypedPrimitiveArraySerializer(TypedPrimitiveArraySerializer<T> src, BeanProperty prop, TypeSerializer vts) { [EOL]     super(src, prop); [EOL]     _valueTypeSerializer = vts; [EOL] } <line_num>: 73,77
public BooleanArraySerializer() { [EOL]     super(boolean[].class, null); [EOL] } <line_num>: 93,93
public ByteArraySerializer() { [EOL]     super(byte[].class); [EOL] } <line_num>: 166,168
public ShortArraySerializer() { [EOL]     super(short[].class); [EOL] } <line_num>: 223,223
public ShortArraySerializer(ShortArraySerializer src, BeanProperty prop, TypeSerializer vts) { [EOL]     super(src, prop, vts); [EOL] } <line_num>: 224,226
public CharArraySerializer() { [EOL]     super(char[].class); [EOL] } <line_num>: 305,305
public IntArraySerializer() { [EOL]     super(int[].class, null); [EOL] } <line_num>: 381,381
public LongArraySerializer() { [EOL]     super(long[].class); [EOL] } <line_num>: 450,450
public LongArraySerializer(LongArraySerializer src, BeanProperty prop, TypeSerializer vts) { [EOL]     super(src, prop, vts); [EOL] } <line_num>: 451,454
public FloatArraySerializer() { [EOL]     super(float[].class); [EOL] } <line_num>: 528,530
public FloatArraySerializer(FloatArraySerializer src, BeanProperty prop, TypeSerializer vts) { [EOL]     super(src, prop, vts); [EOL] } <line_num>: 531,534
public DoubleArraySerializer() { [EOL]     super(double[].class, null); [EOL] } <line_num>: 607,607
public static JsonSerializer<?> findStandardImpl(Class<?> cls) { [EOL]     return _arraySerializers.get(cls.getName()); [EOL] } <line_num>: 45,48
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return this; [EOL] } <line_num>: 99,102
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 104,107
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 109,113
@Override [EOL] public boolean isEmpty(boolean[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 115,118
@Override [EOL] public boolean hasSingleElement(boolean[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 120,123
@Override [EOL] public void serializeContents(boolean[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeBoolean(value[i]); [EOL]     } [EOL] } <line_num>: 125,132
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("boolean")); [EOL]     return o; [EOL] } <line_num>: 134,140
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.BOOLEAN); [EOL]         } [EOL]     } [EOL] } <line_num>: 142,152
@Override [EOL] public boolean isEmpty(byte[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 170,173
@Override [EOL] public void serialize(byte[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     jgen.writeBinary(provider.getConfig().getBase64Variant(), value, 0, value.length); [EOL] } <line_num>: 175,181
@Override [EOL] public void serializeWithType(byte[] value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonGenerationException { [EOL]     typeSer.writeTypePrefixForScalar(value, jgen); [EOL]     jgen.writeBinary(provider.getConfig().getBase64Variant(), value, 0, value.length); [EOL]     typeSer.writeTypeSuffixForScalar(value, jgen); [EOL] } <line_num>: 183,192
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     ObjectNode itemSchema = createSchemaNode("string"); [EOL]     o.put("items", itemSchema); [EOL]     return o; [EOL] } <line_num>: 194,201
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.STRING); [EOL]         } [EOL]     } [EOL] } <line_num>: 203,213
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return new ShortArraySerializer(this, _property, vts); [EOL] } <line_num>: 228,231
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 233,236
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 238,242
@Override [EOL] public boolean isEmpty(short[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 244,247
@Override [EOL] public boolean hasSingleElement(short[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 249,252
@SuppressWarnings("cast") [EOL] @Override [EOL] public void serializeContents(short[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     if (_valueTypeSerializer != null) { [EOL]         for (int i = 0, len = value.length; i < len; ++i) { [EOL]             _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Short.TYPE); [EOL]             jgen.writeNumber(value[i]); [EOL]             _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen); [EOL]         } [EOL]         return; [EOL]     } [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeNumber((int) value[i]); [EOL]     } [EOL] } <line_num>: 254,270
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("integer")); [EOL]     return o; [EOL] } <line_num>: 272,279
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.INTEGER); [EOL]         } [EOL]     } [EOL] } <line_num>: 281,291
@Override [EOL] public boolean isEmpty(char[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 307,310
@Override [EOL] public void serialize(char[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) { [EOL]         jgen.writeStartArray(); [EOL]         _writeArrayContents(jgen, value); [EOL]         jgen.writeEndArray(); [EOL]     } else { [EOL]         jgen.writeString(value, 0, value.length); [EOL]     } [EOL] } <line_num>: 312,324
@Override [EOL] public void serializeWithType(char[] value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonGenerationException { [EOL]     if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) { [EOL]         typeSer.writeTypePrefixForArray(value, jgen); [EOL]         _writeArrayContents(jgen, value); [EOL]         typeSer.writeTypeSuffixForArray(value, jgen); [EOL]     } else { [EOL]         typeSer.writeTypePrefixForScalar(value, jgen); [EOL]         jgen.writeString(value, 0, value.length); [EOL]         typeSer.writeTypeSuffixForScalar(value, jgen); [EOL]     } [EOL] } <line_num>: 326,341
private final void _writeArrayContents(JsonGenerator jgen, char[] value) throws IOException, JsonGenerationException { [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeString(value, i, 1); [EOL]     } [EOL] } <line_num>: 343,349
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     ObjectNode itemSchema = createSchemaNode("string"); [EOL]     itemSchema.put("type", "string"); [EOL]     o.put("items", itemSchema); [EOL]     return o; [EOL] } <line_num>: 351,359
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.STRING); [EOL]         } [EOL]     } [EOL] } <line_num>: 361,371
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return this; [EOL] } <line_num>: 387,390
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 392,395
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 397,401
@Override [EOL] public boolean isEmpty(int[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 403,406
@Override [EOL] public boolean hasSingleElement(int[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 408,411
@Override [EOL] public void serializeContents(int[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeNumber(value[i]); [EOL]     } [EOL] } <line_num>: 413,420
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("integer")); [EOL]     return o; [EOL] } <line_num>: 422,428
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.INTEGER); [EOL]         } [EOL]     } [EOL] } <line_num>: 430,440
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return new LongArraySerializer(this, _property, vts); [EOL] } <line_num>: 456,459
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 461,464
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 466,470
@Override [EOL] public boolean isEmpty(long[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 472,475
@Override [EOL] public boolean hasSingleElement(long[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 477,480
@Override [EOL] public void serializeContents(long[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     if (_valueTypeSerializer != null) { [EOL]         for (int i = 0, len = value.length; i < len; ++i) { [EOL]             _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Long.TYPE); [EOL]             jgen.writeNumber(value[i]); [EOL]             _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen); [EOL]         } [EOL]         return; [EOL]     } [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeNumber(value[i]); [EOL]     } [EOL] } <line_num>: 482,498
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("number", true)); [EOL]     return o; [EOL] } <line_num>: 500,506
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.NUMBER); [EOL]         } [EOL]     } [EOL] } <line_num>: 508,518
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return new FloatArraySerializer(this, _property, vts); [EOL] } <line_num>: 536,539
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 541,544
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 546,550
@Override [EOL] public boolean isEmpty(float[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 552,555
@Override [EOL] public boolean hasSingleElement(float[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 557,560
@Override [EOL] public void serializeContents(float[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     if (_valueTypeSerializer != null) { [EOL]         for (int i = 0, len = value.length; i < len; ++i) { [EOL]             _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Float.TYPE); [EOL]             jgen.writeNumber(value[i]); [EOL]             _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen); [EOL]         } [EOL]         return; [EOL]     } [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeNumber(value[i]); [EOL]     } [EOL] } <line_num>: 562,577
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("number")); [EOL]     return o; [EOL] } <line_num>: 579,585
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.NUMBER); [EOL]         } [EOL]     } [EOL] } <line_num>: 587,597
@Override [EOL] public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts) { [EOL]     return this; [EOL] } <line_num>: 613,616
@Override [EOL] public JavaType getContentType() { [EOL]     return VALUE_TYPE; [EOL] } <line_num>: 618,621
@Override [EOL] public JsonSerializer<?> getContentSerializer() { [EOL]     return null; [EOL] } <line_num>: 623,627
@Override [EOL] public boolean isEmpty(double[] value) { [EOL]     return (value == null) || (value.length == 0); [EOL] } <line_num>: 629,632
@Override [EOL] public boolean hasSingleElement(double[] value) { [EOL]     return (value.length == 1); [EOL] } <line_num>: 634,637
@Override [EOL] public void serializeContents(double[] value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException { [EOL]     for (int i = 0, len = value.length; i < len; ++i) { [EOL]         jgen.writeNumber(value[i]); [EOL]     } [EOL] } <line_num>: 639,646
@Override [EOL] public JsonNode getSchema(SerializerProvider provider, Type typeHint) { [EOL]     ObjectNode o = createSchemaNode("array", true); [EOL]     o.put("items", createSchemaNode("number")); [EOL]     return o; [EOL] } <line_num>: 648,654
@Override [EOL] public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException { [EOL]     if (visitor != null) { [EOL]         JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint); [EOL]         if (v2 != null) { [EOL]             v2.itemsFormat(JsonFormatTypes.NUMBER); [EOL]         } [EOL]     } [EOL] } <line_num>: 656,666
