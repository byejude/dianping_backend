package com.dianping.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by byebyejude on 2017/9/21.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ad extends BaseBean{
    private Long id;
    private String title;
    private String img_File_Name;
    private String link;
    private Long weight;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgFileName() {
        return img_File_Name;
    }

    public String getLink() {
        return link;
    }

    public Long getWeight() {
        return weight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgFileName(String imgFileName) {
        this.img_File_Name = imgFileName;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

}
