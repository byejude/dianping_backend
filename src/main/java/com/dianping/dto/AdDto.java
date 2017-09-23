package com.dianping.dto;

/**
 * Created by byebyejude on 2017/9/20.
 */
import com.dianping.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(Include.NON_NULL)
public class AdDto extends Ad{
    private String img;
    private MultipartFile imgFile;

    public String getImg() {
        return img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}