package com.dianping.controller.system;

/**
 * Created by byebyejude on 2017/9/19.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping
    public String init() {
        return "/system/index";
    }
}