package com.dianping.dto.echarts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/15.
 */
public class Serie {

    private String name;

    private String type;

    private List<Long> data;

    public Serie() {
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }
}
