package com.dianping.controller.content;

import com.dianping.dto.BusinessDto;
import com.dianping.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byebyejude on 2017/9/26.
 */
@Controller
@RequestMapping("/businesses")
public class BusinessContorller {

    @Autowired
    private BusinessService businessService;

    //商户页面初始化
    @RequestMapping(method = RequestMethod.GET)
    public String initSearch(Model model, BusinessDto businessDto){
        model.addAttribute("list",businessService.selectByPage(businessDto));
        model.addAttribute("searchParam",businessDto);

        return "/content/businessList";
    }

    //添加商户页面初始化
    @RequestMapping(value="/addPage",method = RequestMethod.GET)
    public String initAdd(){

         return "/content/businessAdd";
    }

    //添加商户
    @RequestMapping(method = RequestMethod.POST)
    public  String addBusiness(){
        
        return "redirect:/business";
    }

    //修改商户初始化
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String modifyInit(){

        return "/content/businessModify";
    }

    //删除商户
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(){
        return "redirect:/business";
    }

    //修改商户
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public String modifyBusiness(){
    return "/content/businessModify";
    }


}
