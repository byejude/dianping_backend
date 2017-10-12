package com.dianping.controller.system;

import com.dianping.constant.SessionKeyConst;
import com.dianping.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/11.
 */

@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private HttpSession session;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/menus",method = RequestMethod.GET)
    @ResponseBody
    public List<MenuDto> getUserMenuList(MenuDto menuDto){
        return (List<MenuDto>)session.getAttribute(SessionKeyConst.MENU_INFO);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public String signOut(){
        session.invalidate();
        return "redirect:/login";
    }


}
