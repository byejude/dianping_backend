package com.dianping.services.impl;

import com.dianping.bean.Dic;
import com.dianping.dao.DicDao;
import com.dianping.services.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by byebyejude on 2017/9/27.
 */
@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicDao dicDao;

    @Override
    public List<Dic> selectByType(String type) {
        Dic dicTemp = new Dic();
        dicTemp.setType(type);
        List<Dic> dicList = dicDao.select(dicTemp);
        return dicList;
    }
}
