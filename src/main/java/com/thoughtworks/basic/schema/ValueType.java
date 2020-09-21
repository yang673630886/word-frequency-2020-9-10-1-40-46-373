package com.thoughtworks.basic.schema;

import java.lang.reflect.InvocationTargetException;

public class ValueType extends ValueTypeFactory{

    @Override
    public <T extends Type> T createValueType(Class<T> c) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Type valueType = null;
        valueType = c.getDeclaredConstructor().newInstance();
        return (T)valueType;
    }
}
