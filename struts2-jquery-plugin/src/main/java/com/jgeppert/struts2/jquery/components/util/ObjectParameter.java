package com.jgeppert.struts2.jquery.components.util;

public class ObjectParameter {
    private String key;
    private String value;
    private boolean quotedKey = false;
    private boolean quotedValue = true;
    
    public ObjectParameter(final String key, final String value) {
        this(key, value, false, true);
    }
    
    public ObjectParameter(final String key, final String value, final boolean quotedValue) {
        this(key, value, false, quotedValue);
    }
    
    public ObjectParameter(final String key, final String value, final boolean quotedKey, final boolean quotedValue) {
        this.key = key;
        this.value = value;
        this.quotedKey = quotedKey;
        this.quotedValue = quotedValue;
    }
    
    @Override
    public String toString() {
        if(quotedKey && quotedValue) {
            return String.format("'%s': '%s'", key, value);
        } else if (quotedKey && !quotedValue) {
            return String.format("'%s': %s", key, value);
        } else if (!quotedKey && quotedValue) {
            return String.format("%s: '%s'", key, value);
        } else {
            return String.format("%s: %s", key, value);
        }
    }
}
