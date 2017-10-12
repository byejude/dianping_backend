package com.dianping.controller.system;

import com.dianping.constant.DicTypeConst;
import com.dianping.services.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController  {

    @Autowired
    private DicService dicService;

    @RequestMapping
    public String init(Model model){
        model.addAttribute("httpMethodList",dicService.selectByType(DicTypeConst.HTTP_METHOD));
        return "/system/auth";
    }
}