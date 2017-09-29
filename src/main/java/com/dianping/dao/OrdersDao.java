package com.dianping.dao;

import com.dianping.bean.Orders;

import java.util.List;

public interface OrdersDao {
    int insert(Orders orders);

    Orders selectById(Long id);

    int update(Orders orders);

    List<Orders> select(Orders orders);
}