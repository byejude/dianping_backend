package com.dianping.utils;

import java.util.UUID;

public class CommonUtil {

    public static boolean isEmpty(String str){
        if(str==null&&str.trim().equals("")){
            return true;
        }else {
            return false;
        }

    }


    public static int random(int number){
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, number - 1));
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}