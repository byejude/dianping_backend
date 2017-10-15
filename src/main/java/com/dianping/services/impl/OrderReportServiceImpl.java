package com.dianping.services.impl;

import com.dianping.dao.ReportDao;
import com.dianping.dto.echarts.Option;
import com.dianping.dto.echarts.Serie;
import com.dianping.services.OrderReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by byebyejude on 2017/10/15.
 */
@Service
public class OrderReportServiceImpl implements OrderReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public Option count() {
        Option option = new Option();
        List<Map<String,String>> list = reportDao.countOrder();

        Set<String> categoryNameSet = new TreeSet<>();

        Map<String,Long> countMap = new HashMap<>();
        for (Map<String,String>map:list){
            categoryNameSet.add(map.get("categoryName"));
            countMap.put(map.get("categopryName")+map.get("hour"),Long.valueOf(map.get("count")));
        }

        option.getLegend().setData(new ArrayList<>(categoryNameSet));

        List<String> hours = new ArrayList<String>();
        for(int i = 0; i <= 23; i++) {
            hours.add(String.format("%02d", i));
        }
        option.getxAxis().setData(hours);

        for(String categoryName:option.getLegend().getData()){
            Serie serie = new Serie();
            option.getSeries().add(serie);
            serie.setName(categoryName);
            serie.setType("line");
            for (String hour:hours
                 ) {
                serie.getData().add(countMap.get(categoryName + hour) == null ? (long)0 : countMap.get(categoryName + hour));
            }
        }
        return option;
    }
}
