package com.thoughtworks.basic.schema;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private List<Arg> argsPairs;
    private Schema schema;

    public Args(String argsText,Schema schema){
        this.argsText = argsText;
        this.schema = schema;
    }

    public List<Arg> scan(){
        List<String> keyValueStringList = Arrays.asList(argsText.split(" -"));
        keyValueStringList = keyValueStringList.stream().map(String::trim).collect(Collectors.toList());
        List<Arg> keyValuePairs = new ArrayList<>();
        for(String kv : keyValueStringList){
            try{
                String key = kv.split(" ")[0];
                String value = "";
                if(kv.split(" ").length > 1){
                    value = kv.split(" ")[1];
                }else{
                    value = new FlagsSchema().getDefaultValue(key).toString();
                }
                Arg arg = new Arg(key,value);
                checkFlag(keyValuePairs,arg);
                keyValuePairs.add(arg);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return keyValuePairs;
    }

    public Object getValueOf(String flag) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        argsPairs = new Args(argsText,schema).scan();
        for(int i = 0; i < argsPairs.size();i++){
            if(argsPairs.get(i).getFlag().equals(flag)){
                return argsPairs.get(i).parseValue(flag);
            }
        }
        return null;
    }

    public void checkFlag(List<Arg> argsPairs,Arg arg) throws Exception {
        for(Arg arg1 : argsPairs){
            if(arg.getFlag().equals(arg1.getFlag())){
                throw new Exception("输入的Flag重复");
            }
        }
    }
}
