package com.dianping.dao;

import com.dianping.bean.Dic;

import java.util.List;

/**
 * Created by byebyejude on 2017/9/26.
 */
public interface DicDao {

    List<Dic> select(Dic dic);
}
