public DelegatingDeserializer(JsonDeserializer<?> delegatee) { [EOL]     super(_figureType(delegatee)); [EOL]     _delegatee = delegatee; [EOL] } <line_num>: 35,39
protected abstract JsonDeserializer<?> newDelegatingInstance(JsonDeserializer<?> newDelegatee); <line_num>: 41,41
private static Class<?> _figureType(JsonDeserializer<?> deser) { [EOL]     if (deser instanceof StdDeserializer<?>) { [EOL]         return ((StdDeserializer<?>) deser).getValueClass(); [EOL]     } [EOL]     return Object.class; [EOL] } <line_num>: 43,49
@Override [EOL] public void resolve(DeserializationContext ctxt) throws JsonMappingException { [EOL]     if (_delegatee instanceof ResolvableDeserializer) { [EOL]         ((ResolvableDeserializer) _delegatee).resolve(ctxt); [EOL]     } [EOL] } <line_num>: 57,62
@Override [EOL] public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException { [EOL]     JsonDeserializer<?> del = _delegatee; [EOL]     if (del instanceof ContextualDeserializer) { [EOL]         del = ((ContextualDeserializer) del).createContextual(ctxt, property); [EOL]     } [EOL]     return _createContextual(ctxt, property, del); [EOL] } <line_num>: 64,74
protected JsonDeserializer<?> _createContextual(DeserializationContext ctxt, BeanProperty property, JsonDeserializer<?> newDelegatee) { [EOL]     if (newDelegatee == _delegatee) { [EOL]         return this; [EOL]     } [EOL]     return newDelegatingInstance(newDelegatee); [EOL] } <line_num>: 76,83
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     return _delegatee.deserialize(jp, ctxt); [EOL] } <line_num>: 91,96
@SuppressWarnings("unchecked") [EOL] @Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt, Object intoValue) throws IOException, JsonProcessingException { [EOL]     return ((JsonDeserializer<Object>) _delegatee).deserialize(jp, ctxt, intoValue); [EOL] } <line_num>: 98,105
@Override [EOL] public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException { [EOL]     return _delegatee.deserializeWithType(jp, ctxt, typeDeserializer); [EOL] } <line_num>: 107,113
@Override [EOL] public JsonDeserializer<?> replaceDelegatee(JsonDeserializer<?> delegatee) { [EOL]     if (delegatee == _delegatee) { [EOL]         return this; [EOL]     } [EOL]     return newDelegatingInstance(delegatee); [EOL] } <line_num>: 121,128
@Override [EOL] public Object getNullValue() { [EOL]     return _delegatee.getNullValue(); [EOL] } <line_num>: 130,131
@Override [EOL] public Object getEmptyValue() { [EOL]     return _delegatee.getEmptyValue(); [EOL] } <line_num>: 133,134
@Override [EOL] public Collection<Object> getKnownPropertyNames() { [EOL]     return _delegatee.getKnownPropertyNames(); [EOL] } <line_num>: 136,137
@Override [EOL] public boolean isCachable() { [EOL]     return false; [EOL] } <line_num>: 139,140
@Override [EOL] public ObjectIdReader getObjectIdReader() { [EOL]     return _delegatee.getObjectIdReader(); [EOL] } <line_num>: 142,143
@Override [EOL] public JsonDeserializer<?> getDelegatee() { [EOL]     return _delegatee; [EOL] } <line_num>: 145,148
