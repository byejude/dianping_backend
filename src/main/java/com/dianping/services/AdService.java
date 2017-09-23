package com.dianping.services;

import com.dianping.dao.AdDao;
import com.dianping.dto.AdDto;

import java.util.List;

/**
 * Created by byebyejude on 2017/9/23.
 */
public interface AdService {

    boolean add(AdDto adDto);

    List<AdDto> searchByPage(AdDto adDto);

    boolean remove(Long id);

    AdDto getById(Long id);

    boolean modify(AdDto adDto);

}
