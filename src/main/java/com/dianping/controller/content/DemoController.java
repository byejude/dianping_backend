package com.dianping.controller.content;

/**
 * Created by byebyejude on 2017/9/19.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/initList")
    public String initList() {
        return "/content/list";
    }

    @RequestMapping("/initModify")
    public String initModify() {
        return "/content/modify";
    }
}