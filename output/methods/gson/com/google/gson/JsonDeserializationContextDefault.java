JsonDeserializationContextDefault(ObjectNavigatorFactory navigatorFactory, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers, MappedObjectConstructor objectConstructor) { [EOL]     this.navigatorFactory = navigatorFactory; [EOL]     this.deserializers = deserializers; [EOL]     this.objectConstructor = objectConstructor; [EOL] } <line_num>: 32,38
ObjectConstructor getObjectConstructor() { [EOL]     return objectConstructor; [EOL] } <line_num>: 40,42
@SuppressWarnings("unchecked") [EOL] public <T> T deserialize(JsonElement json, Type typeOfT) throws JsonParseException { [EOL]     if (json == null || json.isJsonNull()) { [EOL]         return null; [EOL]     } else if (json.isJsonArray()) { [EOL]         return (T) fromJsonArray(typeOfT, json.getAsJsonArray(), this); [EOL]     } else if (json.isJsonObject()) { [EOL]         return (T) fromJsonObject(typeOfT, json.getAsJsonObject(), this); [EOL]     } else if (json.isJsonPrimitive()) { [EOL]         return (T) fromJsonPrimitive(typeOfT, json.getAsJsonPrimitive(), this); [EOL]     } else { [EOL]         throw new JsonParseException("Failed parsing JSON source: " + json + " to Json"); [EOL]     } [EOL] } <line_num>: 44,57
private <T> T fromJsonArray(Type arrayType, JsonArray jsonArray, JsonDeserializationContext context) throws JsonParseException { [EOL]     JsonArrayDeserializationVisitor<T> visitor = new JsonArrayDeserializationVisitor<T>(jsonArray, arrayType, navigatorFactory, objectConstructor, deserializers, context); [EOL]     ObjectNavigator on = navigatorFactory.create(new ObjectTypePair(null, arrayType, true)); [EOL]     on.accept(visitor); [EOL]     return visitor.getTarget(); [EOL] } <line_num>: 59,66
private <T> T fromJsonObject(Type typeOfT, JsonObject jsonObject, JsonDeserializationContext context) throws JsonParseException { [EOL]     JsonObjectDeserializationVisitor<T> visitor = new JsonObjectDeserializationVisitor<T>(jsonObject, typeOfT, navigatorFactory, objectConstructor, deserializers, context); [EOL]     ObjectNavigator on = navigatorFactory.create(new ObjectTypePair(null, typeOfT, true)); [EOL]     on.accept(visitor); [EOL]     return visitor.getTarget(); [EOL] } <line_num>: 68,75
@SuppressWarnings("unchecked") [EOL] private <T> T fromJsonPrimitive(Type typeOfT, JsonPrimitive json, JsonDeserializationContext context) throws JsonParseException { [EOL]     JsonObjectDeserializationVisitor<T> visitor = new JsonObjectDeserializationVisitor<T>(json, typeOfT, navigatorFactory, objectConstructor, deserializers, context); [EOL]     ObjectNavigator on = navigatorFactory.create(new ObjectTypePair(json.getAsObject(), typeOfT, true)); [EOL]     on.accept(visitor); [EOL]     Object target = visitor.getTarget(); [EOL]     return (T) target; [EOL] } <line_num>: 77,87
