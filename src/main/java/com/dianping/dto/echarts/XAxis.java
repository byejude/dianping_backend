package com.dianping.dto.echarts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/15.
 */
public class XAxis {
    private List<String> data;

    public XAxis() {
        this.data = new ArrayList<>();
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
