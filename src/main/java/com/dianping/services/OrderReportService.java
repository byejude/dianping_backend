package com.dianping.services;

import com.dianping.dto.echarts.Option;

/**
 * Created by byebyejude on 2017/10/15.
 */
public interface OrderReportService {

    /**
     * 按商户类别、每小时为一个时间段（00-01点，01-02点……23-00点）
     * 统计当前系统时间前一天订单数量
     * 并把数据组织成echarts所需参数格式
     * @return 报表参数
     */
    Option count();
}
