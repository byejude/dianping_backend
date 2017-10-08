package com.dianping.dto;

import com.dianping.bean.Comment;

/**
 * Created by byebyejude on 2017/9/20.
 */
public class CommentDto extends Comment {

    /**
     * 隐藏中间4位的手机号
     */
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
