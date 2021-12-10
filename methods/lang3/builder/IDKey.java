@Override	public int hashCode() {	    return id;	}
@Override	public boolean equals(final Object other) {	    if (!(other instanceof IDKey)) {	        return false;	    }	    final IDKey idKey = (IDKey) other;	    if (id != idKey.id) {	        return false;	    }	    return value == idKey.value;	}
