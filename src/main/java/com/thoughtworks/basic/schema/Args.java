package com.thoughtworks.basic.schema;

import java.util.List;

public class Args {
    private String argsText;
    private List<Arg> argsPairs;
    private Schema schema;

    public Args(String argsText,Schema schema){
        this.argsText = argsText;
        this.schema = schema;
    }
    public List<Arg> scan() {
        return null;
    }
}
