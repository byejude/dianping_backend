package com.dianping.controller.system;

import com.dianping.constant.PageCodeEnum;
import com.dianping.constant.SessionKeyConst;
import com.dianping.dto.GroupDto;
import com.dianping.dto.UserDto;
import com.dianping.services.GroupService;
import com.dianping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by byebyejude on 2017/10/9.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private GroupService groupService;

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
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
        return "/system/error";
    }

    /**
     * 没有权限访问
     */
    @RequestMapping("/noAuth")
    public String noAuth(Model model) {
        model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.NO_AUTH);
        session.invalidate();
        return "/system/error";
    }

    /**
     * 验证用户名/密码是否正确 验证通过跳转至后台管理首页，验证失败，返回至登录页。
     */
    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes attr) {
               if(userService.validate(userDto)){
                   session.setAttribute(SessionKeyConst.USER_INFO,userDto);
                   GroupDto groupDto = groupService.getByIdWithMenuAction(userDto.getGroupId());
                   session.setAttribute(SessionKeyConst.MENU_INFO,groupDto.getMenuDtoList());
                   session.setAttribute(SessionKeyConst.ACTION_INFO,groupDto.getActionDtoList());
                   return "redirect:/index";
               }
        attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
        return "redirect:/login";
    }


}
