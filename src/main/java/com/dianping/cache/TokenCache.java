package com.dianping.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by byebyejude on 2017/10/3.
 */
public class TokenCache {
    private static TokenCache instance;

    private Map<String,Long> tokenMap;

    private  TokenCache(){
        tokenMap = new HashMap<>();
    }

    public static TokenCache getInstance(){
        if(instance == null ){
            synchronized (TokenCache.class){
                if(instance == null){
                    instance = new TokenCache();
                }
            }
        }
        return instance;
    }


    public void save(String token,Long phone){
        tokenMap.put(token,phone);
    }

    public Long getPhone(String token){
        return tokenMap.get(token);
    }
}
