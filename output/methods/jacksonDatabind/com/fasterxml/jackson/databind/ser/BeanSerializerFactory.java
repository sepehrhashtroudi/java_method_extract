protected BeanSerializerFactory(SerializerFactoryConfig config) { [EOL]     super(config); [EOL] } <line_num>: 73,76
@Override [EOL] public SerializerFactory withConfig(SerializerFactoryConfig config) { [EOL]     if (_factoryConfig == config) { [EOL]         return this; [EOL]     } [EOL]     if (getClass() != BeanSerializerFactory.class) { [EOL]         throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions"); [EOL]     } [EOL]     return new BeanSerializerFactory(config); [EOL] } <line_num>: 84,102
@Override [EOL] protected Iterable<Serializers> customSerializers() { [EOL]     return _factoryConfig.serializers(); [EOL] } <line_num>: 104,107
@Override [EOL] @SuppressWarnings("unchecked") [EOL] public JsonSerializer<Object> createSerializer(SerializerProvider prov, JavaType origType) throws JsonMappingException { [EOL]     final SerializationConfig config = prov.getConfig(); [EOL]     BeanDescription beanDesc = config.introspect(origType); [EOL]     JsonSerializer<?> ser = findSerializerFromAnnotation(prov, beanDesc.getClassInfo()); [EOL]     if (ser != null) { [EOL]         return (JsonSerializer<Object>) ser; [EOL]     } [EOL]     boolean staticTyping; [EOL]     JavaType type = modifyTypeByAnnotation(config, beanDesc.getClassInfo(), origType); [EOL]     if (type == origType) { [EOL]         staticTyping = false; [EOL]     } else { [EOL]         staticTyping = true; [EOL]         if (type.getRawClass() != origType.getRawClass()) { [EOL]             beanDesc = config.introspect(type); [EOL]         } [EOL]     } [EOL]     Converter<Object, Object> conv = beanDesc.findSerializationConverter(); [EOL]     if (conv == null) { [EOL]         return (JsonSerializer<Object>) _createSerializer2(prov, type, beanDesc, staticTyping); [EOL]     } [EOL]     JavaType delegateType = conv.getOutputType(prov.getTypeFactory()); [EOL]     return new StdDelegatingSerializer(conv, delegateType, _createSerializer2(prov, delegateType, beanDesc, true)); [EOL] } <line_num>: 125,157
protected JsonSerializer<?> _createSerializer2(SerializerProvider prov, JavaType type, BeanDescription beanDesc, boolean staticTyping) throws JsonMappingException { [EOL]     JsonSerializer<?> ser = findSerializerByAnnotations(prov, type, beanDesc); [EOL]     if (ser != null) { [EOL]         return ser; [EOL]     } [EOL]     final SerializationConfig config = prov.getConfig(); [EOL]     if (type.isContainerType()) { [EOL]         if (!staticTyping) { [EOL]             staticTyping = usesStaticTyping(config, beanDesc, null); [EOL]         } [EOL]         ser = buildContainerSerializer(prov, type, beanDesc, staticTyping); [EOL]         if (ser != null) { [EOL]             return ser; [EOL]         } [EOL]     } else { [EOL]         for (Serializers serializers : customSerializers()) { [EOL]             ser = serializers.findSerializer(config, type, beanDesc); [EOL]             if (ser != null) { [EOL]                 break; [EOL]             } [EOL]         } [EOL]     } [EOL]     if (ser == null) { [EOL]         ser = findSerializerByLookup(type, config, beanDesc, staticTyping); [EOL]         if (ser == null) { [EOL]             ser = findSerializerByPrimaryType(prov, type, beanDesc, staticTyping); [EOL]             if (ser == null) { [EOL]                 ser = findBeanSerializer(prov, type, beanDesc); [EOL]                 if (ser == null) { [EOL]                     ser = findSerializerByAddonType(config, type, beanDesc, staticTyping); [EOL]                 } [EOL]             } [EOL]         } [EOL]     } [EOL]     if (ser != null) { [EOL]         if (_factoryConfig.hasSerializerModifiers()) { [EOL]             for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) { [EOL]                 ser = mod.modifySerializer(config, beanDesc, ser); [EOL]             } [EOL]         } [EOL]     } [EOL]     return ser; [EOL] } <line_num>: 159,230
@Deprecated [EOL] public final JsonSerializer<Object> findBeanSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc, BeanProperty property) throws JsonMappingException { [EOL]     return findBeanSerializer(prov, type, beanDesc); [EOL] } <line_num>: 245,250
public JsonSerializer<Object> findBeanSerializer(SerializerProvider prov, JavaType type, BeanDescription beanDesc) throws JsonMappingException { [EOL]     if (!isPotentialBeanType(type.getRawClass())) { [EOL]         if (!type.isEnumType()) { [EOL]             return null; [EOL]         } [EOL]     } [EOL]     return constructBeanSerializer(prov, beanDesc); [EOL] } <line_num>: 256,269
@Deprecated [EOL] public final TypeSerializer findPropertyTypeSerializer(JavaType baseType, SerializationConfig config, AnnotatedMember accessor, BeanProperty property) throws JsonMappingException { [EOL]     return findPropertyTypeSerializer(baseType, config, accessor); [EOL] } <line_num>: 274,279
public TypeSerializer findPropertyTypeSerializer(JavaType baseType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException { [EOL]     AnnotationIntrospector ai = config.getAnnotationIntrospector(); [EOL]     TypeResolverBuilder<?> b = ai.findPropertyTypeResolver(config, accessor, baseType); [EOL]     if (b == null) { [EOL]         return createTypeSerializer(config, baseType); [EOL]     } [EOL]     Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypes(accessor, config, ai, baseType); [EOL]     return b.buildTypeSerializer(config, baseType, subtypes); [EOL] } <line_num>: 291,304
public TypeSerializer findPropertyContentTypeSerializer(JavaType containerType, SerializationConfig config, AnnotatedMember accessor) throws JsonMappingException { [EOL]     JavaType contentType = containerType.getContentType(); [EOL]     AnnotationIntrospector ai = config.getAnnotationIntrospector(); [EOL]     TypeResolverBuilder<?> b = ai.findPropertyContentTypeResolver(config, accessor, containerType); [EOL]     if (b == null) { [EOL]         return createTypeSerializer(config, contentType); [EOL]     } [EOL]     Collection<NamedType> subtypes = config.getSubtypeResolver().collectAndResolveSubtypes(accessor, config, ai, contentType); [EOL]     return b.buildTypeSerializer(config, contentType, subtypes); [EOL] } <line_num>: 316,330
@Deprecated [EOL] protected final JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc, BeanProperty property) throws JsonMappingException { [EOL]     return constructBeanSerializer(prov, beanDesc); [EOL] } <line_num>: 344,350
@SuppressWarnings("unchecked") [EOL] protected JsonSerializer<Object> constructBeanSerializer(SerializerProvider prov, BeanDescription beanDesc) throws JsonMappingException { [EOL]     if (beanDesc.getBeanClass() == Object.class) { [EOL]         return prov.getUnknownTypeSerializer(Object.class); [EOL]     } [EOL]     final SerializationConfig config = prov.getConfig(); [EOL]     BeanSerializerBuilder builder = constructBeanSerializerBuilder(beanDesc); [EOL]     builder.setConfig(config); [EOL]     List<BeanPropertyWriter> props = findBeanProperties(prov, beanDesc, builder); [EOL]     if (props == null) { [EOL]         props = new ArrayList<BeanPropertyWriter>(); [EOL]     } [EOL]     if (_factoryConfig.hasSerializerModifiers()) { [EOL]         for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) { [EOL]             props = mod.changeProperties(config, beanDesc, props); [EOL]         } [EOL]     } [EOL]     props = filterBeanProperties(config, beanDesc, props); [EOL]     if (_factoryConfig.hasSerializerModifiers()) { [EOL]         for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) { [EOL]             props = mod.orderProperties(config, beanDesc, props); [EOL]         } [EOL]     } [EOL]     builder.setObjectIdWriter(constructObjectIdHandler(prov, beanDesc, props)); [EOL]     builder.setProperties(props); [EOL]     builder.setFilterId(findFilterId(config, beanDesc)); [EOL]     AnnotatedMember anyGetter = beanDesc.findAnyGetter(); [EOL]     if (anyGetter != null) { [EOL]         if (config.canOverrideAccessModifiers()) { [EOL]             anyGetter.fixAccess(); [EOL]         } [EOL]         JavaType type = anyGetter.getType(beanDesc.bindingsForBeanType()); [EOL]         boolean staticTyping = config.isEnabled(MapperFeature.USE_STATIC_TYPING); [EOL]         JavaType valueType = type.getContentType(); [EOL]         TypeSerializer typeSer = createTypeSerializer(config, valueType); [EOL]         MapSerializer mapSer = MapSerializer.construct(null, type, staticTyping, typeSer, null, null); [EOL]         BeanProperty.Std anyProp = new BeanProperty.Std(anyGetter.getName(), valueType, null, beanDesc.getClassAnnotations(), anyGetter, false); [EOL]         builder.setAnyGetter(new AnyGetterWriter(anyProp, anyGetter, mapSer)); [EOL]     } [EOL]     processViews(config, builder); [EOL]     if (_factoryConfig.hasSerializerModifiers()) { [EOL]         for (BeanSerializerModifier mod : _factoryConfig.serializerModifiers()) { [EOL]             builder = mod.updateBuilder(config, beanDesc, builder); [EOL]         } [EOL]     } [EOL]     JsonSerializer<Object> ser = (JsonSerializer<Object>) builder.build(); [EOL]     if (ser == null) { [EOL]         if (beanDesc.hasKnownClassAnnotations()) { [EOL]             return builder.createDummy(); [EOL]         } [EOL]     } [EOL]     return ser; [EOL] } <line_num>: 357,445
protected ObjectIdWriter constructObjectIdHandler(SerializerProvider prov, BeanDescription beanDesc, List<BeanPropertyWriter> props) throws JsonMappingException { [EOL]     ObjectIdInfo objectIdInfo = beanDesc.getObjectIdInfo(); [EOL]     if (objectIdInfo == null) { [EOL]         return null; [EOL]     } [EOL]     ObjectIdGenerator<?> gen; [EOL]     Class<?> implClass = objectIdInfo.getGeneratorType(); [EOL]     if (implClass == ObjectIdGenerators.PropertyGenerator.class) { [EOL]         String propName = objectIdInfo.getPropertyName(); [EOL]         BeanPropertyWriter idProp = null; [EOL]         for (int i = 0, len = props.size(); ; ++i) { [EOL]             if (i == len) { [EOL]                 throw new IllegalArgumentException("Invalid Object Id definition for " + beanDesc.getBeanClass().getName() + ": can not find property with name '" + propName + "'"); [EOL]             } [EOL]             BeanPropertyWriter prop = props.get(i); [EOL]             if (propName.equals(prop.getName())) { [EOL]                 idProp = prop; [EOL]                 if (i > 0) { [EOL]                     props.remove(i); [EOL]                     props.add(0, idProp); [EOL]                 } [EOL]                 break; [EOL]             } [EOL]         } [EOL]         JavaType idType = idProp.getType(); [EOL]         gen = new PropertyBasedObjectIdGenerator(objectIdInfo, idProp); [EOL]         return ObjectIdWriter.construct(idType, null, gen, objectIdInfo.getAlwaysAsId()); [EOL]     } [EOL]     JavaType type = prov.constructType(implClass); [EOL]     JavaType idType = prov.getTypeFactory().findTypeParameters(type, ObjectIdGenerator.class)[0]; [EOL]     gen = prov.objectIdGeneratorInstance(beanDesc.getClassInfo(), objectIdInfo); [EOL]     return ObjectIdWriter.construct(idType, objectIdInfo.getPropertyName(), gen, objectIdInfo.getAlwaysAsId()); [EOL] } <line_num>: 447,494
protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter writer, Class<?>[] inViews) { [EOL]     return FilteredBeanPropertyWriter.constructViewBased(writer, inViews); [EOL] } <line_num>: 501,505
protected PropertyBuilder constructPropertyBuilder(SerializationConfig config, BeanDescription beanDesc) { [EOL]     return new PropertyBuilder(config, beanDesc); [EOL] } <line_num>: 507,511
protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beanDesc) { [EOL]     return new BeanSerializerBuilder(beanDesc); [EOL] } <line_num>: 513,515
protected Object findFilterId(SerializationConfig config, BeanDescription beanDesc) { [EOL]     return config.getAnnotationIntrospector().findFilterId(beanDesc.getClassInfo()); [EOL] } <line_num>: 521,524
protected boolean isPotentialBeanType(Class<?> type) { [EOL]     return (ClassUtil.canBeABeanType(type) == null) && !ClassUtil.isProxyType(type); [EOL] } <line_num>: 540,543
protected List<BeanPropertyWriter> findBeanProperties(SerializerProvider prov, BeanDescription beanDesc, BeanSerializerBuilder builder) throws JsonMappingException { [EOL]     List<BeanPropertyDefinition> properties = beanDesc.findProperties(); [EOL]     final SerializationConfig config = prov.getConfig(); [EOL]     removeIgnorableTypes(config, beanDesc, properties); [EOL]     if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) { [EOL]         removeSetterlessGetters(config, beanDesc, properties); [EOL]     } [EOL]     if (properties.isEmpty()) { [EOL]         return null; [EOL]     } [EOL]     boolean staticTyping = usesStaticTyping(config, beanDesc, null); [EOL]     PropertyBuilder pb = constructPropertyBuilder(config, beanDesc); [EOL]     ArrayList<BeanPropertyWriter> result = new ArrayList<BeanPropertyWriter>(properties.size()); [EOL]     TypeBindings typeBind = beanDesc.bindingsForBeanType(); [EOL]     for (BeanPropertyDefinition property : properties) { [EOL]         final AnnotatedMember accessor = property.getAccessor(); [EOL]         if (property.isTypeId()) { [EOL]             if (accessor != null) { [EOL]                 if (config.canOverrideAccessModifiers()) { [EOL]                     accessor.fixAccess(); [EOL]                 } [EOL]                 builder.setTypeId(accessor); [EOL]             } [EOL]             continue; [EOL]         } [EOL]         AnnotationIntrospector.ReferenceProperty refType = property.findReferenceType(); [EOL]         if (refType != null && refType.isBackReference()) { [EOL]             continue; [EOL]         } [EOL]         if (accessor instanceof AnnotatedMethod) { [EOL]             result.add(_constructWriter(prov, property, typeBind, pb, staticTyping, (AnnotatedMethod) accessor)); [EOL]         } else { [EOL]             result.add(_constructWriter(prov, property, typeBind, pb, staticTyping, (AnnotatedField) accessor)); [EOL]         } [EOL]     } [EOL]     return result; [EOL] } <line_num>: 549,598
protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props) { [EOL]     AnnotationIntrospector intr = config.getAnnotationIntrospector(); [EOL]     AnnotatedClass ac = beanDesc.getClassInfo(); [EOL]     String[] ignored = intr.findPropertiesToIgnore(ac); [EOL]     if (ignored != null && ignored.length > 0) { [EOL]         HashSet<String> ignoredSet = ArrayBuilders.arrayToSet(ignored); [EOL]         Iterator<BeanPropertyWriter> it = props.iterator(); [EOL]         while (it.hasNext()) { [EOL]             if (ignoredSet.contains(it.next().getName())) { [EOL]                 it.remove(); [EOL]             } [EOL]         } [EOL]     } [EOL]     return props; [EOL] } <line_num>: 610,626
protected void processViews(SerializationConfig config, BeanSerializerBuilder builder) { [EOL]     List<BeanPropertyWriter> props = builder.getProperties(); [EOL]     boolean includeByDefault = config.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION); [EOL]     final int propCount = props.size(); [EOL]     int viewsFound = 0; [EOL]     BeanPropertyWriter[] filtered = new BeanPropertyWriter[propCount]; [EOL]     for (int i = 0; i < propCount; ++i) { [EOL]         BeanPropertyWriter bpw = props.get(i); [EOL]         Class<?>[] views = bpw.getViews(); [EOL]         if (views == null) { [EOL]             if (includeByDefault) { [EOL]                 filtered[i] = bpw; [EOL]             } [EOL]         } else { [EOL]             ++viewsFound; [EOL]             filtered[i] = constructFilteredBeanWriter(bpw, views); [EOL]         } [EOL]     } [EOL]     if (includeByDefault && viewsFound == 0) { [EOL]         return; [EOL]     } [EOL]     builder.setFilteredProperties(filtered); [EOL] } <line_num>: 637,663
protected void removeIgnorableTypes(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) { [EOL]     AnnotationIntrospector intr = config.getAnnotationIntrospector(); [EOL]     HashMap<Class<?>, Boolean> ignores = new HashMap<Class<?>, Boolean>(); [EOL]     Iterator<BeanPropertyDefinition> it = properties.iterator(); [EOL]     while (it.hasNext()) { [EOL]         BeanPropertyDefinition property = it.next(); [EOL]         AnnotatedMember accessor = property.getAccessor(); [EOL]         if (accessor == null) { [EOL]             it.remove(); [EOL]             continue; [EOL]         } [EOL]         Class<?> type = accessor.getRawType(); [EOL]         Boolean result = ignores.get(type); [EOL]         if (result == null) { [EOL]             BeanDescription desc = config.introspectClassAnnotations(type); [EOL]             AnnotatedClass ac = desc.getClassInfo(); [EOL]             result = intr.isIgnorableType(ac); [EOL]             if (result == null) { [EOL]                 result = Boolean.FALSE; [EOL]             } [EOL]             ignores.put(type, result); [EOL]         } [EOL]         if (result.booleanValue()) { [EOL]             it.remove(); [EOL]         } [EOL]     } [EOL] } <line_num>: 670,700
protected void removeSetterlessGetters(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> properties) { [EOL]     Iterator<BeanPropertyDefinition> it = properties.iterator(); [EOL]     while (it.hasNext()) { [EOL]         BeanPropertyDefinition property = it.next(); [EOL]         if (!property.couldDeserialize() && !property.isExplicitlyIncluded()) { [EOL]             it.remove(); [EOL]         } [EOL]     } [EOL] } <line_num>: 705,717
protected BeanPropertyWriter _constructWriter(SerializerProvider prov, BeanPropertyDefinition propDef, TypeBindings typeContext, PropertyBuilder pb, boolean staticTyping, AnnotatedMember accessor) throws JsonMappingException { [EOL]     final String name = propDef.getName(); [EOL]     if (prov.canOverrideAccessModifiers()) { [EOL]         accessor.fixAccess(); [EOL]     } [EOL]     JavaType type = accessor.getType(typeContext); [EOL]     BeanProperty.Std property = new BeanProperty.Std(name, type, propDef.getWrapperName(), pb.getClassAnnotations(), accessor, propDef.isRequired()); [EOL]     JsonSerializer<?> annotatedSerializer = findSerializerFromAnnotation(prov, accessor); [EOL]     if (annotatedSerializer instanceof ResolvableSerializer) { [EOL]         ((ResolvableSerializer) annotatedSerializer).resolve(prov); [EOL]     } [EOL]     if (annotatedSerializer instanceof ContextualSerializer) { [EOL]         annotatedSerializer = ((ContextualSerializer) annotatedSerializer).createContextual(prov, property); [EOL]     } [EOL]     TypeSerializer contentTypeSer = null; [EOL]     if (ClassUtil.isCollectionMapOrArray(type.getRawClass())) { [EOL]         contentTypeSer = findPropertyContentTypeSerializer(type, prov.getConfig(), accessor); [EOL]     } [EOL]     TypeSerializer typeSer = findPropertyTypeSerializer(type, prov.getConfig(), accessor); [EOL]     BeanPropertyWriter pbw = pb.buildWriter(propDef, type, annotatedSerializer, typeSer, contentTypeSer, accessor, staticTyping); [EOL]     return pbw; [EOL] } <line_num>: 729,765