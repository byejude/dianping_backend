package com.dianping.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by byebyejude on 2017/10/2.
 */
public class CodeCache {

    private static CodeCache instance;
    private Map<Long,String> codeMap;

    private CodeCache(){
        codeMap = new HashMap<>();
    }

    public static CodeCache getInstance(){
        if(instance == null){
            synchronized (CodeCache.class){
                if(instance == null){
                    instance =new CodeCache();
                }
            }
        }
        return instance;
    }

    public  boolean save(Long phone,String code){
         if(codeMap.containsKey(phone)){
            return false;
         }else {
             codeMap.put(phone,code);
             return true;
         }
    }

    public String getCode(Long phone){
        return codeMap.get(phone);
    }

}
