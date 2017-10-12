package com.dianping.dto;

import com.dianping.constant.PageCodeEnum;

/**
 * Created by byebyejude on 2017/10/11.
 */
public class PageCodeDto {
    private Integer code;
    private String msg;

    public PageCodeDto(){

    }

    public PageCodeDto(PageCodeEnum pageCodeEnum) {
        this.code = pageCodeEnum.getCode();
        this.msg = pageCodeEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
