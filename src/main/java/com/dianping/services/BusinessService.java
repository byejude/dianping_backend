package com.dianping.services;


import com.dianping.dto.BusinessDto;
import com.dianping.dto.BusinessListDto;

import java.util.List;

public interface BusinessService {
    
    boolean add(BusinessDto businessDto);

    List<BusinessDto> selectByPage(BusinessDto businessDto);

    BusinessDto selectById(Long id);

    boolean remove(Long id);

    boolean modify(BusinessDto businessDto);

    BusinessListDto searchByPageForApi(BusinessDto businessDto);
}