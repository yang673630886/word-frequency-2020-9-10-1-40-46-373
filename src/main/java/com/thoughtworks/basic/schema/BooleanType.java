package com.thoughtworks.basic.schema;

public class BooleanType implements Type{
    @Override
    public Object getType(String value) {
        Object o = null;
        try{
            o = Boolean.parseBoolean(value);
        }catch(Exception e){

        }
        return o;
    }
}
