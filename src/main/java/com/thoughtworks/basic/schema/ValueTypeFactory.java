package com.thoughtworks.basic.schema;

import java.lang.reflect.InvocationTargetException;

public abstract class ValueTypeFactory {
    public abstract <T extends Type> T createValueType(Class<T> c) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
