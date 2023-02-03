public JsonDeserializationVisitor(JsonElement json, Type targetType, ObjectNavigatorFactory factory, ObjectConstructor objectConstructor, ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers, JsonDeserializationContext context) { [EOL]     Preconditions.checkNotNull(json); [EOL]     this.targetType = targetType; [EOL]     this.factory = factory; [EOL]     this.objectConstructor = objectConstructor; [EOL]     this.deserializers = deserializers; [EOL]     this.json = json; [EOL]     this.context = context; [EOL]     this.constructed = false; [EOL] } <line_num>: 40,52
public T getTarget() { [EOL]     if (!constructed) { [EOL]         target = constructTarget(); [EOL]         constructed = true; [EOL]     } [EOL]     return target; [EOL] } <line_num>: 54,60
protected abstract T constructTarget(); <line_num>: 62,62
public void start(ObjectTypePair node) { [EOL] } <line_num>: 64,65
public void end(ObjectTypePair node) { [EOL] } <line_num>: 67,68
@SuppressWarnings("unchecked") [EOL] public final boolean visitUsingCustomHandler(ObjectTypePair objTypePair) { [EOL]     Pair<JsonDeserializer<?>, ObjectTypePair> pair = objTypePair.getMatchingHandler(deserializers); [EOL]     if (pair == null) { [EOL]         return false; [EOL]     } [EOL]     Object value = invokeCustomDeserializer(json, pair); [EOL]     target = (T) value; [EOL]     constructed = true; [EOL]     return true; [EOL] } <line_num>: 70,80
protected Object invokeCustomDeserializer(JsonElement element, Pair<JsonDeserializer<?>, ObjectTypePair> pair) { [EOL]     if (element == null || element.isJsonNull()) { [EOL]         return null; [EOL]     } [EOL]     Type objType = pair.second.type; [EOL]     return (pair.first).deserialize(element, objType, context); [EOL] } <line_num>: 82,89
final Object visitChildAsObject(Type childType, JsonElement jsonChild) { [EOL]     JsonDeserializationVisitor<?> childVisitor = new JsonObjectDeserializationVisitor<Object>(jsonChild, childType, factory, objectConstructor, deserializers, context); [EOL]     return visitChild(childType, childVisitor); [EOL] } <line_num>: 91,96
final Object visitChildAsArray(Type childType, JsonArray jsonChild) { [EOL]     JsonDeserializationVisitor<?> childVisitor = new JsonArrayDeserializationVisitor<Object>(jsonChild.getAsJsonArray(), childType, factory, objectConstructor, deserializers, context); [EOL]     return visitChild(childType, childVisitor); [EOL] } <line_num>: 98,103
private Object visitChild(Type type, JsonDeserializationVisitor<?> childVisitor) { [EOL]     ObjectNavigator on = factory.create(new ObjectTypePair(null, type, false)); [EOL]     on.accept(childVisitor); [EOL]     return childVisitor.getTarget(); [EOL] } <line_num>: 105,111