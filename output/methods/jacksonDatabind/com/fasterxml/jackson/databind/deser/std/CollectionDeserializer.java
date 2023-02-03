public CollectionDeserializer(JavaType collectionType, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, ValueInstantiator valueInstantiator) { [EOL]     this(collectionType, valueDeser, valueTypeDeser, valueInstantiator, null); [EOL] } <line_num>: 67,72
protected CollectionDeserializer(JavaType collectionType, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser, ValueInstantiator valueInstantiator, JsonDeserializer<Object> delegateDeser) { [EOL]     super(collectionType.getRawClass()); [EOL]     _collectionType = collectionType; [EOL]     _valueDeserializer = valueDeser; [EOL]     _valueTypeDeserializer = valueTypeDeser; [EOL]     _valueInstantiator = valueInstantiator; [EOL]     _delegateDeserializer = delegateDeser; [EOL] } <line_num>: 77,88
protected CollectionDeserializer(CollectionDeserializer src) { [EOL]     super(src._valueClass); [EOL]     _collectionType = src._collectionType; [EOL]     _valueDeserializer = src._valueDeserializer; [EOL]     _valueTypeDeserializer = src._valueTypeDeserializer; [EOL]     _valueInstantiator = src._valueInstantiator; [EOL]     _delegateDeserializer = src._delegateDeserializer; [EOL] } <line_num>: 94,102
@SuppressWarnings("unchecked") [EOL] protected CollectionDeserializer withResolved(JsonDeserializer<?> dd, JsonDeserializer<?> vd, TypeDeserializer vtd) { [EOL]     if ((dd == _delegateDeserializer) && (vd == _valueDeserializer) && (vtd == _valueTypeDeserializer)) { [EOL]         return this; [EOL]     } [EOL]     return new CollectionDeserializer(_collectionType, (JsonDeserializer<Object>) vd, vtd, _valueInstantiator, (JsonDeserializer<Object>) dd); [EOL] } <line_num>: 107,118
@Override [EOL] public CollectionDeserializer createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException { [EOL]     JsonDeserializer<Object> delegateDeser = null; [EOL]     if ((_valueInstantiator != null) && _valueInstantiator.canCreateUsingDelegate()) { [EOL]         JavaType delegateType = _valueInstantiator.getDelegateType(ctxt.getConfig()); [EOL]         if (delegateType == null) { [EOL]             throw new IllegalArgumentException("Invalid delegate-creator definition for " + _collectionType + ": value instantiator (" + _valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'"); [EOL]         } [EOL]         delegateDeser = findDeserializer(ctxt, delegateType, property); [EOL]     } [EOL]     JsonDeserializer<?> valueDeser = _valueDeserializer; [EOL]     valueDeser = findConvertingContentDeserializer(ctxt, property, valueDeser); [EOL]     if (valueDeser == null) { [EOL]         valueDeser = ctxt.findContextualValueDeserializer(_collectionType.getContentType(), property); [EOL]     } else { [EOL]         if (valueDeser instanceof ContextualDeserializer) { [EOL]             valueDeser = ((ContextualDeserializer) valueDeser).createContextual(ctxt, property); [EOL]         } [EOL]     } [EOL]     TypeDeserializer valueTypeDeser = _valueTypeDeserializer; [EOL]     if (valueTypeDeser != null) { [EOL]         valueTypeDeser = valueTypeDeser.forProperty(property); [EOL]     } [EOL]     return withResolved(delegateDeser, valueDeser, valueTypeDeser); [EOL] } <line_num>: 131,164
@Override [EOL] public JavaType getContentType() { [EOL]     return _collectionType.getContentType(); [EOL] } <line_num>: 172,175
@Override [EOL] public JsonDeserializer<Object> getContentDeserializer() { [EOL]     return _valueDeserializer; [EOL] } <line_num>: 177,180
@SuppressWarnings("unchecked") [EOL] @Override [EOL] public Collection<Object> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     if (_delegateDeserializer != null) { [EOL]         return (Collection<Object>) _valueInstantiator.createUsingDelegate(ctxt, _delegateDeserializer.deserialize(jp, ctxt)); [EOL]     } [EOL]     if (jp.getCurrentToken() == JsonToken.VALUE_STRING) { [EOL]         String str = jp.getText(); [EOL]         if (str.length() == 0) { [EOL]             return (Collection<Object>) _valueInstantiator.createFromString(ctxt, str); [EOL]         } [EOL]     } [EOL]     return deserialize(jp, ctxt, (Collection<Object>) _valueInstantiator.createUsingDefault(ctxt)); [EOL] } <line_num>: 188,208
@Override [EOL] public Collection<Object> deserialize(JsonParser jp, DeserializationContext ctxt, Collection<Object> result) throws IOException, JsonProcessingException { [EOL]     if (!jp.isExpectedStartArrayToken()) { [EOL]         return handleNonArray(jp, ctxt, result); [EOL]     } [EOL]     JsonDeserializer<Object> valueDes = _valueDeserializer; [EOL]     JsonToken t; [EOL]     final TypeDeserializer typeDeser = _valueTypeDeserializer; [EOL]     while ((t = jp.nextToken()) != JsonToken.END_ARRAY) { [EOL]         Object value; [EOL]         if (t == JsonToken.VALUE_NULL) { [EOL]             value = null; [EOL]         } else if (typeDeser == null) { [EOL]             value = valueDes.deserialize(jp, ctxt); [EOL]         } else { [EOL]             value = valueDes.deserializeWithType(jp, ctxt, typeDeser); [EOL]         } [EOL]         result.add(value); [EOL]     } [EOL]     return result; [EOL] } <line_num>: 210,237
@Override [EOL] public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException { [EOL]     return typeDeserializer.deserializeTypedFromArray(jp, ctxt); [EOL] } <line_num>: 239,246
protected final Collection<Object> handleNonArray(JsonParser jp, DeserializationContext ctxt, Collection<Object> result) throws IOException, JsonProcessingException { [EOL]     if (!ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) { [EOL]         throw ctxt.mappingException(_collectionType.getRawClass()); [EOL]     } [EOL]     JsonDeserializer<Object> valueDes = _valueDeserializer; [EOL]     final TypeDeserializer typeDeser = _valueTypeDeserializer; [EOL]     JsonToken t = jp.getCurrentToken(); [EOL]     Object value; [EOL]     if (t == JsonToken.VALUE_NULL) { [EOL]         value = null; [EOL]     } else if (typeDeser == null) { [EOL]         value = valueDes.deserialize(jp, ctxt); [EOL]     } else { [EOL]         value = valueDes.deserializeWithType(jp, ctxt, typeDeser); [EOL]     } [EOL]     result.add(value); [EOL]     return result; [EOL] } <line_num>: 253,276
