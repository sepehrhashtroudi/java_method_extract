public static StrLookup<?> noneLookup() {	    return NONE_LOOKUP;	}
public static StrLookup<String> systemPropertiesLookup() {	    return SYSTEM_PROPERTIES_LOOKUP;	}
public static <V> StrLookup<V> mapLookup(final Map<String, V> map) {	    return new MapStrLookup<V>(map);	}
public abstract String lookup(String key);
@Override	public String lookup(final String key) {	    if (map == null) {	        return null;	    }	    final Object obj = map.get(key);	    if (obj == null) {	        return null;	    }	    return obj.toString();	}
