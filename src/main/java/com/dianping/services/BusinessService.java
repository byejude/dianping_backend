package com.dianping.services;


public interface BusinessService {
    
    boolean add(BusinessDto businessDto);

    List<BusinessDto> selectByPage(BusinessDto businessDto);

    BusinessDto selectById(Long id);

    boolean remove(Long id);

    boolean modify(BusinessDto businessDto);

   // BusinessListDto searchByPageForApi(BusinessDto businessDto);
}