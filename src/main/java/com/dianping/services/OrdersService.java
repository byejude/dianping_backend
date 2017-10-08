package com.dianping.services;

import com.dianping.dto.OrderForBackDto;
import com.dianping.dto.OrdersDto;
import com.dianping.dto.OrdersFoyBuyDto;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/4.
 */
public interface OrdersService {

    boolean add(OrdersDto ordersDto);

    OrdersDto getById(Long id);

    List<OrdersDto> getListByMemberId(Long id);

    List<OrderForBackDto> searchByPage(OrderForBackDto orderForBackDto);

    List<OrderForBackDto> searchByPhone(OrderForBackDto orderForBackDto);
}

