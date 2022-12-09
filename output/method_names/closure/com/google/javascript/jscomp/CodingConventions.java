private CodingConventions()
protected Proxy(CodingConvention convention)
public static CodingConvention getDefault()
public boolean isConstant(String variableName)
public boolean isConstantKey(String keyName)
public boolean isValidEnumKey(String key)
public boolean isOptionalParameter(Node parameter)
public boolean isVarArgsParameter(Node parameter)
public boolean isExported(String name, boolean local)
public final boolean isExported(String name)
public boolean isPrivate(String name)
public SubclassRelationship getClassesDefinedByCall(Node callNode)
public boolean isSuperClassReference(String propertyName)
public String extractClassNameIfProvide(Node node, Node parent)
public String extractClassNameIfRequire(Node node, Node parent)
public String getExportPropertyFunction()
public String getExportSymbolFunction()
public List<String> identifyTypeDeclarationCall(Node n)
public void applySubclassRelationship(FunctionType parentCtor, FunctionType childCtor, SubclassType type)
public String getAbstractMethodName()
public String getSingletonGetterClassName(Node callNode)
public void applySingletonGetter(FunctionType functionType, FunctionType getterType, ObjectType objectType)
public boolean isInlinableFunction(Node n)
public DelegateRelationship getDelegateRelationship(Node callNode)
public void applyDelegateRelationship(ObjectType delegateSuperclass, ObjectType delegateBase, ObjectType delegator, FunctionType delegateProxy, FunctionType findDelegate)
public String getDelegateSuperclassName()
public void checkForCallingConventionDefiningCalls(Node n, Map<String, String> delegateCallingConventions)
public void defineDelegateProxyPrototypeProperties(JSTypeRegistry registry, StaticScope<JSType> scope, List<ObjectType> delegateProxyPrototypes, Map<String, String> delegateCallingConventions)
public String getGlobalObject()
public Collection<AssertionFunctionSpec> getAssertionFunctions()
public Bind describeFunctionBind(Node n)
public Bind describeFunctionBind(Node n, boolean useTypeInfo)
public boolean isPropertyTestFunction(Node call)
public boolean isPrototypeAlias(Node getProp)
public ObjectLiteralCast getObjectLiteralCast(Node callNode)
public Collection<String> getIndirectlyDeclaredProperties()
public boolean isConstant(String variableName)
public boolean isConstantKey(String variableName)
public boolean isValidEnumKey(String key)
public boolean isOptionalParameter(Node parameter)
public boolean isVarArgsParameter(Node parameter)
public boolean isExported(String name, boolean local)
public boolean isExported(String name)
public boolean isPrivate(String name)
public SubclassRelationship getClassesDefinedByCall(Node callNode)
public boolean isSuperClassReference(String propertyName)
public String extractClassNameIfProvide(Node node, Node parent)
public String extractClassNameIfRequire(Node node, Node parent)
public String getExportPropertyFunction()
public String getExportSymbolFunction()
public List<String> identifyTypeDeclarationCall(Node n)
public void applySubclassRelationship(FunctionType parentCtor, FunctionType childCtor, SubclassType type)
public String getAbstractMethodName()
public String getSingletonGetterClassName(Node callNode)
public void applySingletonGetter(FunctionType functionType, FunctionType getterType, ObjectType objectType)
public boolean isInlinableFunction(Node n)
public DelegateRelationship getDelegateRelationship(Node callNode)
public void applyDelegateRelationship(ObjectType delegateSuperclass, ObjectType delegateBase, ObjectType delegator, FunctionType delegateProxy, FunctionType findDelegate)
public String getDelegateSuperclassName()
public void checkForCallingConventionDefiningCalls(Node n, Map<String, String> delegateCallingConventions)
public void defineDelegateProxyPrototypeProperties(JSTypeRegistry registry, StaticScope<JSType> scope, List<ObjectType> delegateProxyPrototypes, Map<String, String> delegateCallingConventions)
public String getGlobalObject()
public boolean isPropertyTestFunction(Node call)
public boolean isPrototypeAlias(Node getProp)
public ObjectLiteralCast getObjectLiteralCast(Node callNode)
public Collection<AssertionFunctionSpec> getAssertionFunctions()
public Bind describeFunctionBind(Node n)
public Bind describeFunctionBind(Node n, boolean useTypeInfo)
public Collection<String> getIndirectlyDeclaredProperties()
private Node safeNext(Node n)
