package com.jgeppert.struts2.jquery.components.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectParameterBuilder {
    private List<ObjectParameter> objectParameters = new ArrayList<>();

    public void addParameter(String key, String value) {
        objectParameters.add(new ObjectParameter(key, value));
    }

    public void addParameter(String key, String value, boolean quotedValue) {
        objectParameters.add(new ObjectParameter(key, value, quotedValue));
    }

    @Override
    public String toString() {
        String joinedParameters = objectParameters.stream()
                .map(ObjectParameter::toString)
                .collect(Collectors.joining(", "));
        return "{" + joinedParameters + "}";
    }
}
