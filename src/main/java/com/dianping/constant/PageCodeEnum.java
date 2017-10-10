package com.dianping.constant;

/**
 * Created by byebyejude on 2017/9/24.
 */
public enum PageCodeEnum {
    ADD_SUCCESS(1000,"新增成功！"),
    ADD_FAIL(1001,"新增失败！"),
    MODIFY_SUCCESS(1100,"修改成功！"),
    MODIFY_FAIL(1101,"修改失败！"),
    REMOVE_SUCCESS(1200,"删除成功！"),
    REMOVE_FAIL(1201,"删除失败！"),
    SESSION_TIMEOUT(1302,"session超时，请重新登录！");

    private Integer code;
    private String  msg;

    public static final String KEY = "pageCode";

    PageCodeEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
