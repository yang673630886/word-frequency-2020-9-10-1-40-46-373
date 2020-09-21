package com.thoughtworks.basic.schema;

public class FlagsSchema {
    private String flag;
    private Object valueType;

    public FlagsSchema(){

    }

    public FlagsSchema(String flag,Object valueType){
        this.flag = flag;
        this.valueType = valueType;
    }

    public String getFlag(){
        return flag;
    }

    public Object getType(){
        return valueType;
    }

    public boolean equalsWith(String flag){
        return flag.equals(this.flag);
    }

    public Object getDefaultValue(String flag){
        switch(flag){
            case "l":
                return String.valueOf(false);
            case "p":
                return String.valueOf(0);
            case "d":
                return "";
        }
        return null;
    }
}
