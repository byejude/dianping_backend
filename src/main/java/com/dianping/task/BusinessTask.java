package com.dianping.task;

import com.dianping.bean.SysParam;
import com.dianping.constant.SysParamKeyConst;
import com.dianping.dao.BusinessDao;
import com.dianping.dao.SysParamDao;
import com.dianping.dto.BusinessDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by byebyejude on 2017/10/7.
 */
@Component("BusinessTask")
public class BusinessTask {
    private static final Logger logger = LoggerFactory.getLogger(BusinessTask.class);

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private SysParamDao sysParamDao;

    public void synNumber(){
        logger.info("**********synNumber begin*************");
        businessDao.updateNumber();
        logger.info("**********synNumber end***************");
    }


    public  void synStar(){
        logger.info("***********synNumber begin************");
        SysParam sysParam = sysParamDao.selectByKey(SysParamKeyConst.LAST_SYNC_STAR_TIME);
        Map<String,Date> timeMap = new HashMap<>();
        timeMap.put("startTime",sysParam.getParamValue());
        Date endTime = new Date();
        timeMap.put("endTime",endTime);
        businessDao.updateStar(timeMap);

        SysParam sysParam1ForUpdate = new SysParam();
        sysParam1ForUpdate.setParamKey(SysParamKeyConst.LAST_SYNC_STAR_TIME);
        sysParam1ForUpdate.setParamValue(endTime);
        sysParamDao.updateByKey(sysParam1ForUpdate);
        logger.info("***********synNumber end*************");
    }

}
