package com.thoughtworks.basic.schema;

public class IntegerType implements Type{
    @Override
    public Object getType(String value) {
        Object o = null;
        try{
            o = Integer.parseInt(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        return o;
    }
}
