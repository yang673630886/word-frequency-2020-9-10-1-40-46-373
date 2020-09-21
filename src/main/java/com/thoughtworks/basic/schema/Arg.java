package com.thoughtworks.basic.schema;

import jdk.nashorn.internal.codegen.types.BooleanType;

import java.lang.reflect.InvocationTargetException;

public class Arg {
    private String flag;
    private String value;
    private String type;

    public Arg(String flag,String value){
        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public Object parseValue(String flag) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ValueTypeFactory valueTypeFactory = new ValueType();
        if(flag.equals("l")){
            Type booleanType = valueTypeFactory.createValueType(BooleanType.class);
            return booleanType.getType(value);
        }
        if(flag.equals("p")){
            Type integerType = valueTypeFactory.createValueType(IntegerType.class);
            return integerType.getType(value);
        }
        return value;
    }

    public String getValue() {
        return value;
    }



}
