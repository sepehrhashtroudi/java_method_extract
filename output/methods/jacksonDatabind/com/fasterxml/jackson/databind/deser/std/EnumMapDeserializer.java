@Deprecated [EOL] public EnumMapDeserializer(JavaType mapType, JsonDeserializer<?> keyDeserializer, JsonDeserializer<?> valueDeser) { [EOL]     this(mapType, keyDeserializer, valueDeser, null); [EOL] } <line_num>: 51,55
public EnumMapDeserializer(JavaType mapType, JsonDeserializer<?> keyDeserializer, JsonDeserializer<?> valueDeser, TypeDeserializer valueTypeDeser) { [EOL]     super(EnumMap.class); [EOL]     _mapType = mapType; [EOL]     _enumClass = mapType.getKeyType().getRawClass(); [EOL]     _keyDeserializer = (JsonDeserializer<Enum<?>>) keyDeserializer; [EOL]     _valueDeserializer = (JsonDeserializer<Object>) valueDeser; [EOL]     _valueTypeDeserializer = valueTypeDeser; [EOL] } <line_num>: 57,67
@Deprecated [EOL] public EnumMapDeserializer withResolved(JsonDeserializer<?> keyDeserializer, JsonDeserializer<?> valueDeserializer) { [EOL]     return withResolved(keyDeserializer, valueDeserializer, null); [EOL] } <line_num>: 72,77
public EnumMapDeserializer withResolved(JsonDeserializer<?> keyDeserializer, JsonDeserializer<?> valueDeserializer, TypeDeserializer valueTypeDeser) { [EOL]     if ((keyDeserializer == _keyDeserializer) && (valueDeserializer == _valueDeserializer) && (valueTypeDeser == _valueTypeDeserializer)) { [EOL]         return this; [EOL]     } [EOL]     return new EnumMapDeserializer(_mapType, keyDeserializer, valueDeserializer, _valueTypeDeserializer); [EOL] } <line_num>: 79,89
@Override [EOL] public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException { [EOL]     JsonDeserializer<?> kd = _keyDeserializer; [EOL]     if (kd == null) { [EOL]         kd = ctxt.findContextualValueDeserializer(_mapType.getKeyType(), property); [EOL]     } [EOL]     JsonDeserializer<?> vd = _valueDeserializer; [EOL]     if (vd == null) { [EOL]         vd = ctxt.findContextualValueDeserializer(_mapType.getContentType(), property); [EOL]     } else { [EOL]         if (vd instanceof ContextualDeserializer) { [EOL]             vd = ((ContextualDeserializer) vd).createContextual(ctxt, property); [EOL]         } [EOL]     } [EOL]     TypeDeserializer vtd = _valueTypeDeserializer; [EOL]     if (vtd != null) { [EOL]         vtd = vtd.forProperty(property); [EOL]     } [EOL]     return withResolved(kd, vd, vtd); [EOL] } <line_num>: 95,119
@Override [EOL] public boolean isCachable() { [EOL]     return true; [EOL] } <line_num>: 125,126
@Override [EOL] public EnumMap<?, ?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     if (jp.getCurrentToken() != JsonToken.START_OBJECT) { [EOL]         throw ctxt.mappingException(EnumMap.class); [EOL]     } [EOL]     EnumMap result = constructMap(); [EOL]     final JsonDeserializer<Object> valueDes = _valueDeserializer; [EOL]     final TypeDeserializer typeDeser = _valueTypeDeserializer; [EOL]     while ((jp.nextToken()) != JsonToken.END_OBJECT) { [EOL]         Enum<?> key = _keyDeserializer.deserialize(jp, ctxt); [EOL]         if (key == null) { [EOL]             if (!ctxt.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) { [EOL]                 String value = null; [EOL]                 try { [EOL]                     if (jp.hasCurrentToken()) { [EOL]                         value = jp.getText(); [EOL]                     } [EOL]                 } catch (Exception e) { [EOL]                 } [EOL]                 throw ctxt.weirdStringException(value, _enumClass, "value not one of declared Enum instance names"); [EOL]             } [EOL]             jp.nextToken(); [EOL]             jp.skipChildren(); [EOL]             continue; [EOL]         } [EOL]         JsonToken t = jp.nextToken(); [EOL]         Object value; [EOL]         if (t == JsonToken.VALUE_NULL) { [EOL]             value = null; [EOL]         } else if (typeDeser == null) { [EOL]             value = valueDes.deserialize(jp, ctxt); [EOL]         } else { [EOL]             value = valueDes.deserializeWithType(jp, ctxt, typeDeser); [EOL]         } [EOL]         result.put(key, value); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 134,182
@Override [EOL] public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException { [EOL]     return typeDeserializer.deserializeTypedFromObject(jp, ctxt); [EOL] } <line_num>: 184,191
private EnumMap<?, ?> constructMap() { [EOL]     return new EnumMap(_enumClass); [EOL] } <line_num>: 193,195
