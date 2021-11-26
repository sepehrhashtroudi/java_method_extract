public String get(int i) {	    return values[i];	}
public String get(String name) {	    if (mapping == null) {	        throw new IllegalStateException("No header was specified, the record values can't be accessed by name");	    }	    Integer index = mapping.get(name);	    return index != null ? values[index.intValue()] : null;	}
public Iterator<String> iterator() {	    return Arrays.asList(values).iterator();	}
String[] values() {	    return values;	}
public int size() {	    return values.length;	}
@Override	public String toString() {	    return Arrays.toString(values);	}
