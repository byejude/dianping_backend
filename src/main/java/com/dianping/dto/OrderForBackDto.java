package com.dianping.dto;

import com.dianping.bean.Orders;

/**
 * Created by byebyejude on 2017/10/8.
 */
public class OrderForBackDto extends Orders{

    private  Long username;


    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
}
