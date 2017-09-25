package com.dianping.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byebyejude on 2017/9/26.
 */
@Controller
@RequestMapping("/business")
public class BusinessContorller {

    @RequestMapping(method = RequestMethod.GET)
    public String initSearch(){

        return "/content/businessList";
    }
}
