package com.dianping.services;

import com.dianping.bean.Dic;

import java.util.List;

/**
 * Created by byebyejude on 2017/9/27.
 */
public interface DicService {
    public List<Dic> selectByType(String type);
}
