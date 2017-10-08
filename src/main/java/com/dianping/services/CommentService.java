package com.dianping.services;

import com.dianping.bean.Comment;
import com.dianping.bean.Page;
import com.dianping.dto.CommentDto;
import com.dianping.dto.CommentForSubmitDto;
import com.dianping.dto.CommentListDto;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/8.
 */
public interface CommentService {

    boolean add(CommentForSubmitDto commentForSubmitDto);

    CommentListDto getListByBusinessId(Long businessId,Page page);

    List<CommentDto> selectByPage(CommentDto commentDto);
}
