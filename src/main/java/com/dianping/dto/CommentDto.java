package com.dianping.dto;

/**
 * Created by byebyejude on 2017/9/20.
 */
public class CommentDto {

    private String username;
    private String comment;
    private Integer star;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
