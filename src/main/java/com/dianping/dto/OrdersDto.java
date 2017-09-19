package com.dianping.dto;

/**
 * Created by byebyejude on 2017/9/20.
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrdersDto {

    private Long id;
    private String img;
    private String title;
    private Integer count;
    private String price;
    private Integer commentState;

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Integer getCommentState() {
        return commentState;
    }
    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }
}
