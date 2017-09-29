package com.dianping.dao;

import com.dianping.bean.Comment;

import java.util.List;

public interface CommentDao {

    int insert(Comment comment);

    List<Comment> selectByPage(Comment comment);

}