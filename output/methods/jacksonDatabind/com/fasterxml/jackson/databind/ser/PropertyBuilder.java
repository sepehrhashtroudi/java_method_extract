public PropertyBuilder(SerializationConfig config, BeanDescription beanDesc) { [EOL]     _config = config; [EOL]     _beanDesc = beanDesc; [EOL]     _outputProps = beanDesc.findSerializationInclusion(config.getSerializationInclusion()); [EOL]     _annotationIntrospector = _config.getAnnotationIntrospector(); [EOL] } <line_num>: 32,38
public Annotations getClassAnnotations() { [EOL]     return _beanDesc.getClassAnnotations(); [EOL] } <line_num>: 46,48
protected BeanPropertyWriter buildWriter(BeanPropertyDefinition propDef, JavaType declaredType, JsonSerializer<?> ser, TypeSerializer typeSer, TypeSerializer contentTypeSer, AnnotatedMember am, boolean defaultUseStaticTyping) { [EOL]     JavaType serializationType = findSerializationType(am, defaultUseStaticTyping, declaredType); [EOL]     if (contentTypeSer != null) { [EOL]         if (serializationType == null) { [EOL]             serializationType = declaredType; [EOL]         } [EOL]         JavaType ct = serializationType.getContentType(); [EOL]         if (ct == null) { [EOL]             throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + propDef.getName() + "' (of type " + _beanDesc.getType() + "); serialization type " + serializationType + " has no content"); [EOL]         } [EOL]         serializationType = serializationType.withContentTypeHandler(contentTypeSer); [EOL]         ct = serializationType.getContentType(); [EOL]     } [EOL]     Object valueToSuppress = null; [EOL]     boolean suppressNulls = false; [EOL]     JsonInclude.Include methodProps = _annotationIntrospector.findSerializationInclusion(am, _outputProps); [EOL]     if (methodProps != null) { [EOL]         switch(methodProps) { [EOL]             case NON_DEFAULT: [EOL]                 valueToSuppress = getDefaultValue(propDef.getName(), am); [EOL]                 if (valueToSuppress == null) { [EOL]                     suppressNulls = true; [EOL]                 } else { [EOL]                     if (valueToSuppress.getClass().isArray()) { [EOL]                         valueToSuppress = ArrayBuilders.getArrayComparator(valueToSuppress); [EOL]                     } [EOL]                 } [EOL]                 break; [EOL]             case NON_EMPTY: [EOL]                 suppressNulls = true; [EOL]                 valueToSuppress = BeanPropertyWriter.MARKER_FOR_EMPTY; [EOL]                 break; [EOL]             case NON_NULL: [EOL]                 suppressNulls = true; [EOL]             case ALWAYS: [EOL]                 if (declaredType.isContainerType() && !_config.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS)) { [EOL]                     valueToSuppress = BeanPropertyWriter.MARKER_FOR_EMPTY; [EOL]                 } [EOL]                 break; [EOL]         } [EOL]     } [EOL]     BeanPropertyWriter bpw = new BeanPropertyWriter(propDef, am, _beanDesc.getClassAnnotations(), declaredType, ser, typeSer, serializationType, suppressNulls, valueToSuppress); [EOL]     NameTransformer unwrapper = _annotationIntrospector.findUnwrappingNameTransformer(am); [EOL]     if (unwrapper != null) { [EOL]         bpw = bpw.unwrappingWriter(unwrapper); [EOL]     } [EOL]     return bpw; [EOL] } <line_num>: 55,132
protected JavaType findSerializationType(Annotated a, boolean useStaticTyping, JavaType declaredType) { [EOL]     Class<?> serClass = _annotationIntrospector.findSerializationType(a); [EOL]     if (serClass != null) { [EOL]         Class<?> rawDeclared = declaredType.getRawClass(); [EOL]         if (serClass.isAssignableFrom(rawDeclared)) { [EOL]             declaredType = declaredType.widenBy(serClass); [EOL]         } else { [EOL]             if (!rawDeclared.isAssignableFrom(serClass)) { [EOL]                 throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + a.getName() + "': class " + serClass.getName() + " not a super-type of (declared) class " + rawDeclared.getName()); [EOL]             } [EOL]             declaredType = _config.constructSpecializedType(declaredType, serClass); [EOL]         } [EOL]         useStaticTyping = true; [EOL]     } [EOL]     JavaType secondary = BeanSerializerFactory.modifySecondaryTypesByAnnotation(_config, a, declaredType); [EOL]     if (secondary != declaredType) { [EOL]         useStaticTyping = true; [EOL]         declaredType = secondary; [EOL]     } [EOL]     if (!useStaticTyping) { [EOL]         JsonSerialize.Typing typing = _annotationIntrospector.findSerializationTyping(a); [EOL]         if (typing != null) { [EOL]             useStaticTyping = (typing == JsonSerialize.Typing.STATIC); [EOL]         } [EOL]     } [EOL]     return useStaticTyping ? declaredType : null; [EOL] } <line_num>: 146,190
protected Object getDefaultBean() { [EOL]     if (_defaultBean == null) { [EOL]         _defaultBean = _beanDesc.instantiateBean(_config.canOverrideAccessModifiers()); [EOL]         if (_defaultBean == null) { [EOL]             Class<?> cls = _beanDesc.getClassInfo().getAnnotated(); [EOL]             throw new IllegalArgumentException("Class " + cls.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation"); [EOL]         } [EOL]     } [EOL]     return _defaultBean; [EOL] } <line_num>: 198,211
protected Object getDefaultValue(String name, AnnotatedMember member) { [EOL]     Object defaultBean = getDefaultBean(); [EOL]     try { [EOL]         return member.getValue(defaultBean); [EOL]     } catch (Exception e) { [EOL]         return _throwWrapped(e, name, defaultBean); [EOL]     } [EOL] } <line_num>: 213,221
protected Object _throwWrapped(Exception e, String propName, Object defaultBean) { [EOL]     Throwable t = e; [EOL]     while (t.getCause() != null) { [EOL]         t = t.getCause(); [EOL]     } [EOL]     if (t instanceof Error) [EOL]         throw (Error) t; [EOL]     if (t instanceof RuntimeException) [EOL]         throw (RuntimeException) t; [EOL]     throw new IllegalArgumentException("Failed to get property '" + propName + "' of default " + defaultBean.getClass().getName() + " instance"); [EOL] } <line_num>: 229,238