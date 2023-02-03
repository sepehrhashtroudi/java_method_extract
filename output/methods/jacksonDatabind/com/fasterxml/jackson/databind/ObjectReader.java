protected ObjectReader(ObjectMapper mapper, DeserializationConfig config) { [EOL]     this(mapper, config, null, null, null, null); [EOL] } <line_num>: 159,162
protected ObjectReader(ObjectMapper mapper, DeserializationConfig config, JavaType valueType, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues) { [EOL]     _config = config; [EOL]     _context = mapper._deserializationContext; [EOL]     _rootDeserializers = mapper._rootDeserializers; [EOL]     _jsonFactory = mapper._jsonFactory; [EOL]     _rootNames = mapper._rootNames; [EOL]     _valueType = valueType; [EOL]     _valueToUpdate = valueToUpdate; [EOL]     if (valueToUpdate != null && valueType.isArrayType()) { [EOL]         throw new IllegalArgumentException("Can not update an array value"); [EOL]     } [EOL]     _schema = schema; [EOL]     _injectableValues = injectableValues; [EOL]     _unwrapRoot = config.useRootWrapping(); [EOL]     _rootDeserializer = _prefetchRootDeserializer(config, valueType); [EOL]     _dataFormatReaders = null; [EOL] } <line_num>: 168,188
protected ObjectReader(ObjectReader base, DeserializationConfig config, JavaType valueType, JsonDeserializer<Object> rootDeser, Object valueToUpdate, FormatSchema schema, InjectableValues injectableValues, DataFormatReaders dataFormatReaders) { [EOL]     _config = config; [EOL]     _context = base._context; [EOL]     _rootDeserializers = base._rootDeserializers; [EOL]     _jsonFactory = base._jsonFactory; [EOL]     _rootNames = base._rootNames; [EOL]     _valueType = valueType; [EOL]     _rootDeserializer = rootDeser; [EOL]     _valueToUpdate = valueToUpdate; [EOL]     if (valueToUpdate != null && valueType.isArrayType()) { [EOL]         throw new IllegalArgumentException("Can not update an array value"); [EOL]     } [EOL]     _schema = schema; [EOL]     _injectableValues = injectableValues; [EOL]     _unwrapRoot = config.useRootWrapping(); [EOL]     _dataFormatReaders = dataFormatReaders; [EOL] } <line_num>: 193,215
protected ObjectReader(ObjectReader base, DeserializationConfig config) { [EOL]     _config = config; [EOL]     _context = base._context; [EOL]     _rootDeserializers = base._rootDeserializers; [EOL]     _jsonFactory = base._jsonFactory; [EOL]     _rootNames = base._rootNames; [EOL]     _valueType = base._valueType; [EOL]     _rootDeserializer = base._rootDeserializer; [EOL]     _valueToUpdate = base._valueToUpdate; [EOL]     _schema = base._schema; [EOL]     _injectableValues = base._injectableValues; [EOL]     _unwrapRoot = config.useRootWrapping(); [EOL]     _dataFormatReaders = base._dataFormatReaders; [EOL] } <line_num>: 220,236
protected ObjectReader(ObjectReader base, JsonFactory f) { [EOL]     _config = base._config; [EOL]     _context = base._context; [EOL]     _rootDeserializers = base._rootDeserializers; [EOL]     _jsonFactory = f; [EOL]     _rootNames = base._rootNames; [EOL]     _valueType = base._valueType; [EOL]     _rootDeserializer = base._rootDeserializer; [EOL]     _valueToUpdate = base._valueToUpdate; [EOL]     _schema = base._schema; [EOL]     _injectableValues = base._injectableValues; [EOL]     _unwrapRoot = base._unwrapRoot; [EOL]     _dataFormatReaders = base._dataFormatReaders; [EOL] } <line_num>: 238,254
@Override [EOL] public Version version() { [EOL]     return com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION; [EOL] } <line_num>: 260,263
public ObjectReader with(DeserializationConfig config) { [EOL]     return _with(config); [EOL] } <line_num>: 271,273
public ObjectReader with(DeserializationFeature feature) { [EOL]     return _with(_config.with(feature)); [EOL] } <line_num>: 279,281
public ObjectReader with(DeserializationFeature first, DeserializationFeature... other) { [EOL]     return _with(_config.with(first, other)); [EOL] } <line_num>: 287,291
public ObjectReader withFeatures(DeserializationFeature... features) { [EOL]     return _with(_config.withFeatures(features)); [EOL] } <line_num>: 297,299
public ObjectReader without(DeserializationFeature feature) { [EOL]     return _with(_config.without(feature)); [EOL] } <line_num>: 305,307
public ObjectReader without(DeserializationFeature first, DeserializationFeature... other) { [EOL]     return _with(_config.without(first, other)); [EOL] } <line_num>: 313,317
public ObjectReader withoutFeatures(DeserializationFeature... features) { [EOL]     return _with(_config.withoutFeatures(features)); [EOL] } <line_num>: 323,325
public ObjectReader with(InjectableValues injectableValues) { [EOL]     if (_injectableValues == injectableValues) { [EOL]         return this; [EOL]     } [EOL]     return new ObjectReader(this, _config, _valueType, _rootDeserializer, _valueToUpdate, _schema, injectableValues, _dataFormatReaders); [EOL] } <line_num>: 334,342
public ObjectReader with(JsonNodeFactory f) { [EOL]     return _with(_config.with(f)); [EOL] } <line_num>: 352,354
public ObjectReader with(JsonFactory f) { [EOL]     if (f == _jsonFactory) { [EOL]         return this; [EOL]     } [EOL]     ObjectReader r = new ObjectReader(this, f); [EOL]     if (f.getCodec() == null) { [EOL]         f.setCodec(r); [EOL]     } [EOL]     return r; [EOL] } <line_num>: 367,377
public ObjectReader withRootName(String rootName) { [EOL]     return _with(_config.withRootName(rootName)); [EOL] } <line_num>: 388,390
public ObjectReader with(FormatSchema schema) { [EOL]     if (_schema == schema) { [EOL]         return this; [EOL]     } [EOL]     _verifySchemaType(schema); [EOL]     return new ObjectReader(this, _config, _valueType, _rootDeserializer, _valueToUpdate, schema, _injectableValues, _dataFormatReaders); [EOL] } <line_num>: 400,408
public ObjectReader withType(JavaType valueType) { [EOL]     if (valueType != null && valueType.equals(_valueType)) { [EOL]         return this; [EOL]     } [EOL]     JsonDeserializer<Object> rootDeser = _prefetchRootDeserializer(_config, valueType); [EOL]     DataFormatReaders det = _dataFormatReaders; [EOL]     if (det != null) { [EOL]         det = det.withType(valueType); [EOL]     } [EOL]     return new ObjectReader(this, _config, valueType, rootDeser, _valueToUpdate, _schema, _injectableValues, det); [EOL] } <line_num>: 417,430
public ObjectReader withType(Class<?> valueType) { [EOL]     return withType(_config.constructType(valueType)); [EOL] } <line_num>: 439,441
public ObjectReader withType(java.lang.reflect.Type valueType) { [EOL]     return withType(_config.getTypeFactory().constructType(valueType)); [EOL] } <line_num>: 450,452
public ObjectReader withType(TypeReference<?> valueTypeRef) { [EOL]     return withType(_config.getTypeFactory().constructType(valueTypeRef.getType())); [EOL] } <line_num>: 461,463
public ObjectReader withValueToUpdate(Object value) { [EOL]     if (value == _valueToUpdate) [EOL]         return this; [EOL]     if (value == null) { [EOL]         throw new IllegalArgumentException("cat not update null value"); [EOL]     } [EOL]     JavaType t; [EOL]     if (_valueType == null) { [EOL]         t = _config.constructType(value.getClass()); [EOL]     } else { [EOL]         t = _valueType; [EOL]     } [EOL]     return new ObjectReader(this, _config, t, _rootDeserializer, value, _schema, _injectableValues, _dataFormatReaders); [EOL] } <line_num>: 473,492
public ObjectReader withView(Class<?> activeView) { [EOL]     return _with(_config.withView(activeView)); [EOL] } <line_num>: 501,503
public ObjectReader with(Locale l) { [EOL]     return _with(_config.with(l)); [EOL] } <line_num>: 505,507
public ObjectReader with(TimeZone tz) { [EOL]     return _with(_config.with(tz)); [EOL] } <line_num>: 509,511
public ObjectReader withHandler(DeserializationProblemHandler h) { [EOL]     return _with(_config.withHandler(h)); [EOL] } <line_num>: 513,515
public ObjectReader with(Base64Variant defaultBase64) { [EOL]     return _with(_config.with(defaultBase64)); [EOL] } <line_num>: 517,519
public ObjectReader withFormatDetection(ObjectReader... readers) { [EOL]     return withFormatDetection(new DataFormatReaders(readers)); [EOL] } <line_num>: 543,546
public ObjectReader withFormatDetection(DataFormatReaders readers) { [EOL]     return new ObjectReader(this, _config, _valueType, _rootDeserializer, _valueToUpdate, _schema, _injectableValues, readers); [EOL] } <line_num>: 563,567
public boolean isEnabled(DeserializationFeature f) { [EOL]     return _config.isEnabled(f); [EOL] } <line_num>: 575,577
public boolean isEnabled(MapperFeature f) { [EOL]     return _config.isEnabled(f); [EOL] } <line_num>: 579,581
public boolean isEnabled(JsonParser.Feature f) { [EOL]     return _jsonFactory.isEnabled(f); [EOL] } <line_num>: 583,585
public DeserializationConfig getConfig() { [EOL]     return _config; [EOL] } <line_num>: 590,592
@Override [EOL] public JsonFactory getFactory() { [EOL]     return _jsonFactory; [EOL] } <line_num>: 597,600
@Deprecated [EOL] @Override [EOL] public JsonFactory getJsonFactory() { [EOL]     return _jsonFactory; [EOL] } <line_num>: 605,609
public TypeFactory getTypeFactory() { [EOL]     return _config.getTypeFactory(); [EOL] } <line_num>: 611,613
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(JsonParser jp) throws IOException, JsonProcessingException { [EOL]     return (T) _bind(jp, _valueToUpdate); [EOL] } <line_num>: 631,636
@SuppressWarnings("unchecked") [EOL] @Override [EOL] public <T> T readValue(JsonParser jp, Class<T> valueType) throws IOException, JsonProcessingException { [EOL]     return (T) withType(valueType).readValue(jp); [EOL] } <line_num>: 648,654
@SuppressWarnings("unchecked") [EOL] @Override [EOL] public <T> T readValue(JsonParser jp, TypeReference<?> valueTypeRef) throws IOException, JsonProcessingException { [EOL]     return (T) withType(valueTypeRef).readValue(jp); [EOL] } <line_num>: 666,672
@Override [EOL] @SuppressWarnings("unchecked") [EOL] public <T> T readValue(JsonParser jp, ResolvedType valueType) throws IOException, JsonProcessingException { [EOL]     return (T) withType((JavaType) valueType).readValue(jp); [EOL] } <line_num>: 684,688
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(JsonParser jp, JavaType valueType) throws IOException, JsonProcessingException { [EOL]     return (T) withType(valueType).readValue(jp); [EOL] } <line_num>: 696,699
@SuppressWarnings("unchecked") [EOL] @Override [EOL] public <T extends TreeNode> T readTree(JsonParser jp) throws IOException, JsonProcessingException { [EOL]     return (T) _bindAsTree(jp); [EOL] } <line_num>: 712,718
@Override [EOL] public <T> Iterator<T> readValues(JsonParser jp, Class<T> valueType) throws IOException, JsonProcessingException { [EOL]     return withType(valueType).readValues(jp); [EOL] } <line_num>: 729,733
@Override [EOL] public <T> Iterator<T> readValues(JsonParser jp, TypeReference<?> valueTypeRef) throws IOException, JsonProcessingException { [EOL]     return withType(valueTypeRef).readValues(jp); [EOL] } <line_num>: 744,748
@Override [EOL] public <T> Iterator<T> readValues(JsonParser jp, ResolvedType valueType) throws IOException, JsonProcessingException { [EOL]     return readValues(jp, (JavaType) valueType); [EOL] } <line_num>: 759,763
public <T> Iterator<T> readValues(JsonParser jp, JavaType valueType) throws IOException, JsonProcessingException { [EOL]     return withType(valueType).readValues(jp); [EOL] } <line_num>: 774,777
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(InputStream src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return (T) _detectBindAndClose(_dataFormatReaders.findFormat(src), false); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 791,799
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(Reader src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(src); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 807,815
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(String src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(src); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 823,831
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(byte[] src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return (T) _detectBindAndClose(src, 0, src.length); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 839,847
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(byte[] src, int offset, int length) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return (T) _detectBindAndClose(src, offset, length); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src, offset, length), _valueToUpdate); [EOL] } <line_num>: 855,863
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(File src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return (T) _detectBindAndClose(_dataFormatReaders.findFormat(_inputStream(src)), true); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 865,873
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(URL src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return (T) _detectBindAndClose(_dataFormatReaders.findFormat(_inputStream(src)), true); [EOL]     } [EOL]     return (T) _bindAndClose(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 881,889
@SuppressWarnings("unchecked") [EOL] public <T> T readValue(JsonNode src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(src); [EOL]     } [EOL]     return (T) _bindAndClose(treeAsTokens(src), _valueToUpdate); [EOL] } <line_num>: 898,906
public JsonNode readTree(InputStream in) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return _detectBindAndCloseAsTree(in); [EOL]     } [EOL]     return _bindAndCloseAsTree(_jsonFactory.createParser(in)); [EOL] } <line_num>: 917,924
public JsonNode readTree(Reader r) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(r); [EOL]     } [EOL]     return _bindAndCloseAsTree(_jsonFactory.createParser(r)); [EOL] } <line_num>: 935,942
public JsonNode readTree(String json) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(json); [EOL]     } [EOL]     return _bindAndCloseAsTree(_jsonFactory.createParser(json)); [EOL] } <line_num>: 953,960
public <T> MappingIterator<T> readValues(JsonParser jp) throws IOException, JsonProcessingException { [EOL]     DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]     return new MappingIterator<T>(_valueType, jp, ctxt, _findRootDeserializer(ctxt, _valueType), false, _valueToUpdate); [EOL] } <line_num>: 979,987
public <T> MappingIterator<T> readValues(InputStream src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return _detectBindAndReadValues(_dataFormatReaders.findFormat(src), false); [EOL]     } [EOL]     return _bindAndReadValues(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 1009,1016
public <T> MappingIterator<T> readValues(Reader src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(src); [EOL]     } [EOL]     JsonParser jp = _jsonFactory.createParser(src); [EOL]     if (_schema != null) { [EOL]         jp.setSchema(_schema); [EOL]     } [EOL]     jp.nextToken(); [EOL]     DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]     return new MappingIterator<T>(_valueType, jp, ctxt, _findRootDeserializer(ctxt, _valueType), true, _valueToUpdate); [EOL] } <line_num>: 1021,1035
public <T> MappingIterator<T> readValues(String json) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         _reportUndetectableSource(json); [EOL]     } [EOL]     JsonParser jp = _jsonFactory.createParser(json); [EOL]     if (_schema != null) { [EOL]         jp.setSchema(_schema); [EOL]     } [EOL]     jp.nextToken(); [EOL]     DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]     return new MappingIterator<T>(_valueType, jp, ctxt, _findRootDeserializer(ctxt, _valueType), true, _valueToUpdate); [EOL] } <line_num>: 1042,1056
public <T> MappingIterator<T> readValues(byte[] src, int offset, int length) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return _detectBindAndReadValues(_dataFormatReaders.findFormat(src, offset, length), false); [EOL]     } [EOL]     return _bindAndReadValues(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 1061,1068
public final <T> MappingIterator<T> readValues(byte[] src) throws IOException, JsonProcessingException { [EOL]     return readValues(src, 0, src.length); [EOL] } <line_num>: 1073,1076
public <T> MappingIterator<T> readValues(File src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return _detectBindAndReadValues(_dataFormatReaders.findFormat(_inputStream(src)), false); [EOL]     } [EOL]     return _bindAndReadValues(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 1081,1089
public <T> MappingIterator<T> readValues(URL src) throws IOException, JsonProcessingException { [EOL]     if (_dataFormatReaders != null) { [EOL]         return _detectBindAndReadValues(_dataFormatReaders.findFormat(_inputStream(src)), true); [EOL]     } [EOL]     return _bindAndReadValues(_jsonFactory.createParser(src), _valueToUpdate); [EOL] } <line_num>: 1096,1104
@Override [EOL] public JsonNode createArrayNode() { [EOL]     return _config.getNodeFactory().arrayNode(); [EOL] } <line_num>: 1112,1115
@Override [EOL] public JsonNode createObjectNode() { [EOL]     return _config.getNodeFactory().objectNode(); [EOL] } <line_num>: 1117,1120
@Override [EOL] public JsonParser treeAsTokens(TreeNode n) { [EOL]     return new TreeTraversingParser((JsonNode) n, this); [EOL] } <line_num>: 1122,1125
@Override [EOL] public <T> T treeToValue(TreeNode n, Class<T> valueType) throws JsonProcessingException { [EOL]     try { [EOL]         return readValue(treeAsTokens(n), valueType); [EOL]     } catch (JsonProcessingException e) { [EOL]         throw e; [EOL]     } catch (IOException e) { [EOL]         throw new IllegalArgumentException(e.getMessage(), e); [EOL]     } [EOL] } <line_num>: 1127,1138
@Override [EOL] public void writeValue(JsonGenerator jgen, Object value) throws IOException, JsonProcessingException { [EOL]     throw new UnsupportedOperationException("Not implemented for ObjectReader"); [EOL] } <line_num>: 1140,1144
protected Object _bind(JsonParser jp, Object valueToUpdate) throws IOException, JsonParseException, JsonMappingException { [EOL]     Object result; [EOL]     JsonToken t = _initForReading(jp); [EOL]     if (t == JsonToken.VALUE_NULL) { [EOL]         if (valueToUpdate == null) { [EOL]             DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]             result = _findRootDeserializer(ctxt, _valueType).getNullValue(); [EOL]         } else { [EOL]             result = valueToUpdate; [EOL]         } [EOL]     } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) { [EOL]         result = valueToUpdate; [EOL]     } else { [EOL]         DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]         JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, _valueType); [EOL]         if (_unwrapRoot) { [EOL]             result = _unwrapAndDeserialize(jp, ctxt, _valueType, deser); [EOL]         } else { [EOL]             if (valueToUpdate == null) { [EOL]                 result = deser.deserialize(jp, ctxt); [EOL]             } else { [EOL]                 deser.deserialize(jp, ctxt, valueToUpdate); [EOL]                 result = valueToUpdate; [EOL]             } [EOL]         } [EOL]     } [EOL]     jp.clearCurrentToken(); [EOL]     return result; [EOL] } <line_num>: 1155,1189
protected Object _bindAndClose(JsonParser jp, Object valueToUpdate) throws IOException, JsonParseException, JsonMappingException { [EOL]     if (_schema != null) { [EOL]         jp.setSchema(_schema); [EOL]     } [EOL]     try { [EOL]         Object result; [EOL]         JsonToken t = _initForReading(jp); [EOL]         if (t == JsonToken.VALUE_NULL) { [EOL]             if (valueToUpdate == null) { [EOL]                 DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]                 result = _findRootDeserializer(ctxt, _valueType).getNullValue(); [EOL]             } else { [EOL]                 result = valueToUpdate; [EOL]             } [EOL]         } else if (t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) { [EOL]             result = valueToUpdate; [EOL]         } else { [EOL]             DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]             JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, _valueType); [EOL]             if (_unwrapRoot) { [EOL]                 result = _unwrapAndDeserialize(jp, ctxt, _valueType, deser); [EOL]             } else { [EOL]                 if (valueToUpdate == null) { [EOL]                     result = deser.deserialize(jp, ctxt); [EOL]                 } else { [EOL]                     deser.deserialize(jp, ctxt, valueToUpdate); [EOL]                     result = valueToUpdate; [EOL]                 } [EOL]             } [EOL]         } [EOL]         return result; [EOL]     } finally { [EOL]         try { [EOL]             jp.close(); [EOL]         } catch (IOException ioe) { [EOL]         } [EOL]     } [EOL] } <line_num>: 1191,1229
protected JsonNode _bindAsTree(JsonParser jp) throws IOException, JsonParseException, JsonMappingException { [EOL]     JsonNode result; [EOL]     JsonToken t = _initForReading(jp); [EOL]     if (t == JsonToken.VALUE_NULL || t == JsonToken.END_ARRAY || t == JsonToken.END_OBJECT) { [EOL]         result = NullNode.instance; [EOL]     } else { [EOL]         DeserializationContext ctxt = createDeserializationContext(jp, _config); [EOL]         JsonDeserializer<Object> deser = _findRootDeserializer(ctxt, JSON_NODE_TYPE); [EOL]         if (_unwrapRoot) { [EOL]             result = (JsonNode) _unwrapAndDeserialize(jp, ctxt, JSON_NODE_TYPE, deser); [EOL]         } else { [EOL]             result = (JsonNode) deser.deserialize(jp, ctxt); [EOL]         } [EOL]     } [EOL]     jp.clearCurrentToken(); [EOL]     return result; [EOL] } <line_num>: 1231,1250
protected JsonNode _bindAndCloseAsTree(JsonParser jp) throws IOException, JsonParseException, JsonMappingException { [EOL]     if (_schema != null) { [EOL]         jp.setSchema(_schema); [EOL]     } [EOL]     try { [EOL]         return _bindAsTree(jp); [EOL]     } finally { [EOL]         try { [EOL]             jp.close(); [EOL]         } catch (IOException ioe) { [EOL]         } [EOL]     } [EOL] } <line_num>: 1252,1265
protected <T> MappingIterator<T> _bindAndReadValues(JsonParser p, Object valueToUpdate) throws IOException, JsonProcessingException { [EOL]     if (_schema != null) { [EOL]         p.setSchema(_schema); [EOL]     } [EOL]     p.nextToken(); [EOL]     DeserializationContext ctxt = createDeserializationContext(p, _config); [EOL]     return new MappingIterator<T>(_valueType, p, ctxt, _findRootDeserializer(ctxt, _valueType), true, _valueToUpdate); [EOL] } <line_num>: 1270,1282
protected static JsonToken _initForReading(JsonParser jp) throws IOException, JsonParseException, JsonMappingException { [EOL]     JsonToken t = jp.getCurrentToken(); [EOL]     if (t == null) { [EOL]         t = jp.nextToken(); [EOL]         if (t == null) { [EOL]             throw JsonMappingException.from(jp, "No content to map due to end-of-input"); [EOL]         } [EOL]     } [EOL]     return t; [EOL] } <line_num>: 1284,1302
protected JsonDeserializer<Object> _findRootDeserializer(DeserializationContext ctxt, JavaType valueType) throws JsonMappingException { [EOL]     if (_rootDeserializer != null) { [EOL]         return _rootDeserializer; [EOL]     } [EOL]     if (valueType == null) { [EOL]         throw new JsonMappingException("No value type configured for ObjectReader"); [EOL]     } [EOL]     JsonDeserializer<Object> deser = _rootDeserializers.get(valueType); [EOL]     if (deser != null) { [EOL]         return deser; [EOL]     } [EOL]     deser = ctxt.findRootValueDeserializer(valueType); [EOL]     if (deser == null) { [EOL]         throw new JsonMappingException("Can not find a deserializer for type " + valueType); [EOL]     } [EOL]     _rootDeserializers.put(valueType, deser); [EOL]     return deser; [EOL] } <line_num>: 1307,1332
protected JsonDeserializer<Object> _prefetchRootDeserializer(DeserializationConfig config, JavaType valueType) { [EOL]     if (valueType == null || !_config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) { [EOL]         return null; [EOL]     } [EOL]     JsonDeserializer<Object> deser = _rootDeserializers.get(valueType); [EOL]     if (deser == null) { [EOL]         try { [EOL]             DeserializationContext ctxt = createDeserializationContext(null, _config); [EOL]             deser = ctxt.findRootValueDeserializer(valueType); [EOL]             if (deser != null) { [EOL]                 _rootDeserializers.put(valueType, deser); [EOL]             } [EOL]             return deser; [EOL]         } catch (JsonProcessingException e) { [EOL]         } [EOL]     } [EOL]     return deser; [EOL] } <line_num>: 1339,1362
protected Object _unwrapAndDeserialize(JsonParser jp, DeserializationContext ctxt, JavaType rootType, JsonDeserializer<Object> deser) throws IOException, JsonParseException, JsonMappingException { [EOL]     String expName = _config.getRootName(); [EOL]     if (expName == null) { [EOL]         SerializedString sstr = _rootNames.findRootName(rootType, _config); [EOL]         expName = sstr.getValue(); [EOL]     } [EOL]     if (jp.getCurrentToken() != JsonToken.START_OBJECT) { [EOL]         throw JsonMappingException.from(jp, "Current token not START_OBJECT (needed to unwrap root name '" + expName + "'), but " + jp.getCurrentToken()); [EOL]     } [EOL]     if (jp.nextToken() != JsonToken.FIELD_NAME) { [EOL]         throw JsonMappingException.from(jp, "Current token not FIELD_NAME (to contain expected root name '" + expName + "'), but " + jp.getCurrentToken()); [EOL]     } [EOL]     String actualName = jp.getCurrentName(); [EOL]     if (!expName.equals(actualName)) { [EOL]         throw JsonMappingException.from(jp, "Root name '" + actualName + "' does not match expected ('" + expName + "') for type " + rootType); [EOL]     } [EOL]     jp.nextToken(); [EOL]     Object result; [EOL]     if (_valueToUpdate == null) { [EOL]         result = deser.deserialize(jp, ctxt); [EOL]     } else { [EOL]         deser.deserialize(jp, ctxt, _valueToUpdate); [EOL]         result = _valueToUpdate; [EOL]     } [EOL]     if (jp.nextToken() != JsonToken.END_OBJECT) { [EOL]         throw JsonMappingException.from(jp, "Current token not END_OBJECT (to match wrapper object with root name '" + expName + "'), but " + jp.getCurrentToken()); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 1364,1401
protected Object _detectBindAndClose(byte[] src, int offset, int length) throws IOException { [EOL]     DataFormatReaders.Match match = _dataFormatReaders.findFormat(src, offset, length); [EOL]     if (!match.hasMatch()) { [EOL]         _reportUnkownFormat(_dataFormatReaders, match); [EOL]     } [EOL]     JsonParser jp = match.createParserWithMatch(); [EOL]     return match.getReader()._bindAndClose(jp, _valueToUpdate); [EOL] } <line_num>: 1409,1417
protected Object _detectBindAndClose(DataFormatReaders.Match match, boolean forceClosing) throws IOException { [EOL]     if (!match.hasMatch()) { [EOL]         _reportUnkownFormat(_dataFormatReaders, match); [EOL]     } [EOL]     JsonParser p = match.createParserWithMatch(); [EOL]     if (forceClosing) { [EOL]         p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE); [EOL]     } [EOL]     return match.getReader()._bindAndClose(p, _valueToUpdate); [EOL] } <line_num>: 1419,1433
protected <T> MappingIterator<T> _detectBindAndReadValues(DataFormatReaders.Match match, boolean forceClosing) throws IOException, JsonProcessingException { [EOL]     if (!match.hasMatch()) { [EOL]         _reportUnkownFormat(_dataFormatReaders, match); [EOL]     } [EOL]     JsonParser p = match.createParserWithMatch(); [EOL]     if (forceClosing) { [EOL]         p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE); [EOL]     } [EOL]     return match.getReader()._bindAndReadValues(p, _valueToUpdate); [EOL] } <line_num>: 1435,1449
protected JsonNode _detectBindAndCloseAsTree(InputStream in) throws IOException { [EOL]     DataFormatReaders.Match match = _dataFormatReaders.findFormat(in); [EOL]     if (!match.hasMatch()) { [EOL]         _reportUnkownFormat(_dataFormatReaders, match); [EOL]     } [EOL]     JsonParser p = match.createParserWithMatch(); [EOL]     p.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE); [EOL]     return match.getReader()._bindAndCloseAsTree(p); [EOL] } <line_num>: 1451,1460
protected void _reportUnkownFormat(DataFormatReaders detector, DataFormatReaders.Match match) throws JsonProcessingException { [EOL]     throw new JsonParseException("Can not detect format from input, does not look like any of detectable formats " + detector.toString(), JsonLocation.NA); [EOL] } <line_num>: 1466,1471
protected void _verifySchemaType(FormatSchema schema) { [EOL]     if (schema != null) { [EOL]         if (!_jsonFactory.canUseSchema(schema)) { [EOL]             throw new IllegalArgumentException("Can not use FormatSchema of type " + schema.getClass().getName() + " for format " + _jsonFactory.getFormatName()); [EOL]         } [EOL]     } [EOL] } <line_num>: 1482,1490
protected DefaultDeserializationContext createDeserializationContext(JsonParser jp, DeserializationConfig cfg) { [EOL]     return _context.createInstance(cfg, jp, _injectableValues); [EOL] } <line_num>: 1497,1501
protected ObjectReader _with(DeserializationConfig newConfig) { [EOL]     if (newConfig == _config) { [EOL]         return this; [EOL]     } [EOL]     if (_dataFormatReaders != null) { [EOL]         return new ObjectReader(this, newConfig).withFormatDetection(_dataFormatReaders.with(newConfig)); [EOL]     } [EOL]     return new ObjectReader(this, newConfig); [EOL] } <line_num>: 1503,1512
protected void _reportUndetectableSource(Object src) throws JsonProcessingException { [EOL]     throw new JsonParseException("Can not use source of type " + src.getClass().getName() + " with format auto-detection: must be byte- not char-based", JsonLocation.NA); [EOL] } <line_num>: 1514,1519
protected InputStream _inputStream(URL src) throws IOException { [EOL]     return src.openStream(); [EOL] } <line_num>: 1521,1523
protected InputStream _inputStream(File f) throws IOException { [EOL]     return new FileInputStream(f); [EOL] } <line_num>: 1525,1527
