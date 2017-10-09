package com.dianping.controller.system;

import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by byebyejude on 2017/10/9.
 */
@Controller
@RequestMapping("/login")
public class LoginController {


    /**
     * 登录页面
     */
    @RequestMapping
    public String index() {
        return "/system/login";
    }

    /**
     * session超时
     */
    @RequestMapping("/sessionTimeout")
    public String sessionTimeout(Model model) {

        return "/system/error";
    }

    /**
     * 没有权限访问
     */
    @RequestMapping("/noAuth")
    public String noAuth(Model model) {

        return "/system/error";
    }

    /**
     * 验证用户名/密码是否正确 验证通过跳转至后台管理首页，验证失败，返回至登录页。
     */
    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes attr) {

        return "redirect:/login";
    }


}
