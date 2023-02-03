package com.fasterxml.jackson.databind;

/**
 * Simple value class used for containing names of properties as defined
 * by annotations (and possibly other configuration sources).
 * 
 * @since 2.1
 */
public class PropertyName
    implements java.io.Serializable
{
    private static final long serialVersionUID = 7930806520033045126L;

    private final static String _USE_DEFAULT = "";
    private final static String _NO_NAME = "#disabled";

    /**
     * Special placeholder value that indicates that name to use should be
     * based on the standard heuristics. This can be different from returning
     * null, as null means "no information available, whereas this value
     * indicates explicit defaulting.
     */
    public final static PropertyName USE_DEFAULT = new PropertyName(_USE_DEFAULT, null);

    /**
     * Special placeholder value that indicates that there is no name associated.
     * Exact semantics to use (if any) depend on actual annotation in use, but
     * commonly this value disables behavior for which name would be needed.
     */
    public final static PropertyName NO_NAME = new PropertyName(new String(_NO_NAME), null);
    
    /**
     * Basic name of the property.
     */
    protected final String _simpleName;

    /**
     * Additional namespace, for formats that have such concept (JSON
     * does not, XML does, for example).
     */
    protected final String _namespace;

    public PropertyName(String simpleName) {
        this(simpleName, null);
    }

    public PropertyName(String simpleName, String namespace)
    {
        _simpleName = (simpleName == null) ? "" : simpleName;
        _namespace = namespace;
    }

    // To support JDK serialization, recovery of Singleton instance
    protected Object readResolve() {
        if (_simpleName == null || _USE_DEFAULT.equals(_simpleName)) {
            return USE_DEFAULT;
        }
        if (_simpleName.equals(_NO_NAME)) {
            return NO_NAME;
        }
        return this;
    }
    
    public static PropertyName construct(String simpleName, String ns)
    {
        if (simpleName == null) {
            simpleName = "";
        }
        if (ns == null && simpleName.length() == 0) {
            return USE_DEFAULT;
        }
        return new PropertyName(simpleName, ns);
    }
    
    /**
     * Fluent factory method for constructing an instance with different
     * simple name.
     */
    public PropertyName withSimpleName(String simpleName)
    {
        if (simpleName == null) {
            simpleName = "";
        }
        if (simpleName.equals(_simpleName)) {
            return this;
        }
        return new PropertyName(simpleName, _namespace);
    }
    
    /**
     * Fluent factory method for constructing an instance with different
     * namespace.
     */
    public PropertyName withNamespace(String ns) {
        if (ns == null) {
            if (_namespace == null) {
                return this;
            }
        } else if (ns.equals(_namespace)) {
            return this;
        }
        return new PropertyName(_simpleName, ns);
    }
    
    /*
    /**********************************************************
    /* Accessors
    /**********************************************************
     */
    
    public String getSimpleName() {
        return _simpleName;
    }

    public String getNamespace() {
        return _namespace;
    }

    public boolean hasSimpleName() {
        return _simpleName.length() > 0;
    }

    public boolean hasNamespace() {
        return _namespace != null;
    }
    
    /*
    /**********************************************************
    /* Std method overrides
    /**********************************************************
     */

    @Override
    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (o == null) return false;
        /* 13-Nov-2012, tatu: by default, require strict type equality.
         *   Re-evaluate if this becomes an issue.
         */
        if (o.getClass() != getClass()) return false;
        // 13-Nov-2012, tatu: Should we have specific rules on matching USE_DEFAULT?
        //   (like, it only ever matching exact instance)
        //   If we did, would need to check symmetrically; that is, if either 'this'
        //   or 'o' was USE_DEFAULT, both would have to be.
        PropertyName other = (PropertyName) o;
        if (_simpleName == null) {
            if (other._simpleName != null) return false;
        } else if (!_simpleName.equals(other._simpleName)) {
            return false;
        }
        if (_namespace == null) {
            return (null == other._namespace);
        }
        return _namespace.equals(other._namespace);
    }
    
    @Override
    public int hashCode() {
        if (_namespace == null) {
            return _simpleName.hashCode();
        }
        return _namespace.hashCode() ^  _simpleName.hashCode();
    }
    
    @Override
    public String toString() {
        if (_namespace == null) {
            return _simpleName;
        }
        return "{"+_namespace + "}" + _simpleName;
    }
}
