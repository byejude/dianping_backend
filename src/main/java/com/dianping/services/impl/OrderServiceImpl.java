package com.dianping.services.impl;

import com.dianping.bean.Member;
import com.dianping.bean.Orders;
import com.dianping.constant.CommentStateConst;
import com.dianping.dao.MemberDao;
import com.dianping.dao.OrdersDao;
import com.dianping.dto.OrderForBackDto;
import com.dianping.dto.OrdersDto;
import com.dianping.dto.OrdersFoyBuyDto;
import com.dianping.services.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/4.
 */
@Service
public class OrderServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private MemberDao memberDao;

    @Value("${businessImage.url}")
    private String businessImageUrl;

    @Override
    public boolean add(OrdersDto ordersDto) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);
        orders.setcommentState(CommentStateConst.NOT_COMMENT);
        orders.setCreateTime(new Date());
        ordersDao.insert(orders);
        return true;

    }

    @Override
    public OrdersDto getById(Long id) {
        OrdersDto ordersDto = new OrdersDto();
        Orders orders = ordersDao.selectById(id);
        BeanUtils.copyProperties(orders,ordersDto);
        return ordersDto;
    }

    @Override
    public List<OrdersDto> getListByMemberId(Long id) {
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        Orders ordersForSelect = new Orders();
        ordersForSelect.setMemberId(id);
        List<Orders> ordersList = ordersDao.select(ordersForSelect);
        for(Orders orders:ordersList){
            OrdersDto ordersDto = new OrdersDto();
            ordersDto.setTitle(orders.getBusiness().getTitle());
            ordersDto.setImg(businessImageUrl+orders.getBusiness().getImgFileName());
            ordersDto.setCount(orders.getBusiness().getNumber());
            BeanUtils.copyProperties(orders,ordersDto);
            ordersDtoList.add(ordersDto);
        }
        return ordersDtoList;
    }

    @Override
    public List<OrderForBackDto> searchByPage(OrderForBackDto orderForBackDto) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setNum(orderForBackDto.getNum());
        ordersDto.setPrice(orderForBackDto.getPrice());
        ordersDto.setBusinessId(orderForBackDto.getId());
        List<OrderForBackDto> result = new ArrayList<>();
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto,orders);
        List<Orders> ordersList = ordersDao.select(orders);

        for (Orders orderTemp:ordersList
             ) {
            OrderForBackDto ordersFoyBackDtoTemp = new OrderForBackDto();
            ordersFoyBackDtoTemp.setNum(orderTemp.getNum());
            Member member = new Member();
            member.setId(orderTemp.getMemberId());
            List<Member> memberList = memberDao.select(member);
            if(memberList != null&&memberList.size() == 1){
                ordersFoyBackDtoTemp.setUsername(memberList.get(0).getPhone());
            }
            ordersFoyBackDtoTemp.setPrice(orderTemp.getPrice());
            ordersFoyBackDtoTemp.setId(orderTemp.getId());
            result.add(ordersFoyBackDtoTemp);
        }
        return result;
    }


    @Override
    public List<OrderForBackDto> searchByPhone(OrderForBackDto orderForBackDto) {
        Long phone  = orderForBackDto.getUsername();
        Member member = new Member();
        Orders orders = new Orders();
        List<OrderForBackDto> result = new ArrayList<>();
        member.setPhone(phone);
        List<Member> memberList = memberDao.select(member);
        if(memberList != null&&memberList.size() == 1){
            orders.setMember(member);
        }
        List<Orders>ordersList = ordersDao.selectByPhone(orders);
        for (Orders orderTemp:ordersList
                ) {
              OrderForBackDto orderForBackDtoTemp = new OrderForBackDto();
              orderForBackDtoTemp.setPrice(orderTemp.getPrice());
              orderForBackDtoTemp.setId(orderTemp.getId());
              orderForBackDtoTemp.setUsername(orderTemp.getMember().getPhone());
              result.add(orderForBackDtoTemp);
        }
        return result;
    }
}
