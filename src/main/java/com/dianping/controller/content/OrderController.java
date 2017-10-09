package com.dianping.controller.content;

import com.dianping.dto.OrderForBackDto;
import com.dianping.dto.OrdersDto;
import com.dianping.dto.OrdersFoyBuyDto;
import com.dianping.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by byebyejude on 2017/10/8.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping
    public String init(Model model, OrderForBackDto orderForBackDto) {

        model.addAttribute("list",ordersService.searchByPage(orderForBackDto));
        model.addAttribute("searchParam", orderForBackDto);
        return "/content/orderList";
    }

    @RequestMapping("/search")
    public String search(Model model,OrderForBackDto orderForBackDto){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        model.addAttribute("list",ordersService.searchByPhone(orderForBackDto));
        model.addAttribute("searchParam", orderForBackDto);
        return "/content/orderList";
    }
}
