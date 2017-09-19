package com.dianping.dto;

/**
 * Created by byebyejude on 2017/9/20.
 */
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CommentListDto {

    private boolean hasMore;
    private List<CommentDto> data;

    public boolean isHasMore() {
        return hasMore;
    }
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
    public List<CommentDto> getData() {
        return data;
    }
    public void setData(List<CommentDto> data) {
        this.data = data;
    }
}
