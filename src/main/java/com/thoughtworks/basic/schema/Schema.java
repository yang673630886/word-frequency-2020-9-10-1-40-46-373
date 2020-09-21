package com.thoughtworks.basic.schema;


import java.util.Set;

public class Schema {
    Set<FlagsSchema> flagsSchema;

    public Schema(Set<FlagsSchema> flagsSchema){
        this.flagsSchema = flagsSchema;
    }

    //获得schema中的类型
    public Object getValueOf(String flag){
        return flagsSchema.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }

}
