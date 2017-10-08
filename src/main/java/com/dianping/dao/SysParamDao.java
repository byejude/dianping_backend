package com.dianping.dao;

import com.dianping.bean.SysParam;

/**
 * Created by byebyejude on 2017/10/7.
 */
public interface SysParamDao {

    SysParam selectByKey(String key);

    int updateByKey(SysParam sysParam);
}
