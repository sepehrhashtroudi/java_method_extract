public static StrLookup<?> noneLookup() { [EOL]     return NONE_LOOKUP; [EOL] }
public static StrLookup<String> systemPropertiesLookup() { [EOL]     return SYSTEM_PROPERTIES_LOOKUP; [EOL] }
public static <V> StrLookup<V> mapLookup(final Map<String, V> map) { [EOL]     return new MapStrLookup<V>(map); [EOL] }
public abstract String lookup(String key);
@Override [EOL] public String lookup(final String key) { [EOL]     if (map == null) { [EOL]         return null; [EOL]     } [EOL]     final Object obj = map.get(key); [EOL]     if (obj == null) { [EOL]         return null; [EOL]     } [EOL]     return obj.toString(); [EOL] }
