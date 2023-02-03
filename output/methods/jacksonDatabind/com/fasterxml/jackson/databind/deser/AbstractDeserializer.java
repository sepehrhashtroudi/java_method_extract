public AbstractDeserializer(BeanDeserializerBuilder builder, BeanDescription beanDesc, Map<String, SettableBeanProperty> backRefProps) { [EOL]     _baseType = beanDesc.getType(); [EOL]     _objectIdReader = builder.getObjectIdReader(); [EOL]     _backRefProperties = backRefProps; [EOL]     Class<?> cls = _baseType.getRawClass(); [EOL]     _acceptString = cls.isAssignableFrom(String.class); [EOL]     _acceptBoolean = (cls == Boolean.TYPE) || cls.isAssignableFrom(Boolean.class); [EOL]     _acceptInt = (cls == Integer.TYPE) || cls.isAssignableFrom(Integer.class); [EOL]     _acceptDouble = (cls == Double.TYPE) || cls.isAssignableFrom(Double.class); [EOL] } <line_num>: 39,50
@Override [EOL] public boolean isCachable() { [EOL]     return true; [EOL] } <line_num>: 58,59
@Override [EOL] public ObjectIdReader getObjectIdReader() { [EOL]     return _objectIdReader; [EOL] } <line_num>: 66,69
public SettableBeanProperty findBackReference(String logicalName) { [EOL]     return (_backRefProperties == null) ? null : _backRefProperties.get(logicalName); [EOL] } <line_num>: 75,78
@Override [EOL] public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException, JsonProcessingException { [EOL]     if (_objectIdReader != null) { [EOL]         JsonToken t = jp.getCurrentToken(); [EOL]         if (t != null && t.isScalarValue()) { [EOL]             return _deserializeFromObjectId(jp, ctxt); [EOL]         } [EOL]     } [EOL]     Object result = _deserializeIfNatural(jp, ctxt); [EOL]     if (result != null) { [EOL]         return result; [EOL]     } [EOL]     return typeDeserializer.deserializeTypedFromObject(jp, ctxt); [EOL] } <line_num>: 86,107
@Override [EOL] public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     throw ctxt.instantiationException(_baseType.getRawClass(), "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information"); [EOL] } <line_num>: 109,116
@SuppressWarnings("incomplete-switch") [EOL] protected Object _deserializeIfNatural(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     switch(jp.getCurrentToken()) { [EOL]         case VALUE_STRING: [EOL]             if (_acceptString) { [EOL]                 return jp.getText(); [EOL]             } [EOL]             break; [EOL]         case VALUE_NUMBER_INT: [EOL]             if (_acceptInt) { [EOL]                 return jp.getIntValue(); [EOL]             } [EOL]             break; [EOL]         case VALUE_NUMBER_FLOAT: [EOL]             if (_acceptDouble) { [EOL]                 return Double.valueOf(jp.getDoubleValue()); [EOL]             } [EOL]             break; [EOL]         case VALUE_TRUE: [EOL]             if (_acceptBoolean) { [EOL]                 return Boolean.TRUE; [EOL]             } [EOL]             break; [EOL]         case VALUE_FALSE: [EOL]             if (_acceptBoolean) { [EOL]                 return Boolean.FALSE; [EOL]             } [EOL]             break; [EOL]     } [EOL]     return null; [EOL] } <line_num>: 124,163
protected Object _deserializeFromObjectId(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException { [EOL]     Object id = _objectIdReader.deserializer.deserialize(jp, ctxt); [EOL]     ReadableObjectId roid = ctxt.findObjectId(id, _objectIdReader.generator); [EOL]     Object pojo = roid.item; [EOL]     if (pojo == null) { [EOL]         throw new IllegalStateException("Could not resolve Object Id [" + id + "] -- unresolved forward-reference?"); [EOL]     } [EOL]     return pojo; [EOL] } <line_num>: 169,180