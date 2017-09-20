package com.dianping.controller.content;

/**
 * Created by byebyejude on 2017/9/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ad")
public class AdController {

    @RequestMapping
    public String adInit() {
        System.out.print("222222222222222222222222");
        return "/content/adList";
    }

    @RequestMapping("/adAdd")
    public String adAdd() {
        return "/content/adAdd";
    }
}