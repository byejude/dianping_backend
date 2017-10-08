package com.dianping.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by byebyejude on 2017/10/5.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersFoyBuyDto {
    private Long id;
    private String token;
    private Integer num;
    private Double price;
    private Long username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }
}
