package com.dianping.bean;


import java.util.Date;

/**
 * Created by byebyejude on 2017/10/7.
 */
public class SysParam {
    private String paramKey;
    private Date paramValue;
    private String paramDesc;


    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public Date getParamValue() {
        return paramValue;
    }

    public void setParamValue(Date paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamDesc() {
        return paramDesc;
    }

    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
}
