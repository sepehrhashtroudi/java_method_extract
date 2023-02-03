private MapType(Class<?> mapType, JavaType keyT, JavaType valueT, Object valueHandler, Object typeHandler, boolean asStatic)
public static MapType construct(Class<?> rawType, JavaType keyT, JavaType valueT)
protected JavaType _narrow(Class<?> subclass)
public JavaType narrowContentsBy(Class<?> contentClass)
public JavaType widenContentsBy(Class<?> contentClass)
public JavaType narrowKey(Class<?> keySubclass)
public JavaType widenKey(Class<?> keySubclass)
public MapType withTypeHandler(Object h)
public MapType withContentTypeHandler(Object h)
public MapType withValueHandler(Object h)
public MapType withContentValueHandler(Object h)
public MapType withStaticTyping()
public MapType withKeyTypeHandler(Object h)
public MapType withKeyValueHandler(Object h)
public String toString()
long serialVersionUID=Optional[-811146779148281500L]
