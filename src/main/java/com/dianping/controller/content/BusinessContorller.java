package com.dianping.controller.content;

import com.dianping.constant.DicTypeConst;
import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.BusinessDto;
import com.dianping.services.BusinessService;
import com.dianping.services.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by byebyejude on 2017/9/26.
 */
@Controller
@RequestMapping("/businesses")
public class BusinessContorller {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private DicService dicService;

    //商户页面初始化
    @RequestMapping(method = RequestMethod.GET)
    public String initSearch(Model model, BusinessDto businessDto){
        System.out.println("********"+businessDto.getTitle()+"*******");
        model.addAttribute("list",businessService.selectByPage(businessDto));
        model.addAttribute("searchParam",businessDto);
        return "/content/businessList";
    }

    //添加商户页面初始化
    @RequestMapping(value="/addPage",method = RequestMethod.GET)
    public String initAdd(Model model){
        model.addAttribute("cityList",dicService.selectByType(DicTypeConst.CITY));
        model.addAttribute("categoryList",dicService.selectByType(DicTypeConst.CATEGORY));
         return "/content/businessAdd";
    }

    //添加商户
    @RequestMapping(method = RequestMethod.POST)
    public  String addBusiness(BusinessDto businessDto, RedirectAttributes attributes){
        if(businessService.add(businessDto)){
            attributes.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
            return "redirect:/businesses";
        }else {
            attributes.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL);
            return "redirect:/businesses/addPage";
        }



    }

    //修改商户初始化
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String modifyInit(@PathVariable("id")Long id,Model model){
        model.addAttribute("cityList",dicService.selectByType(DicTypeConst.CITY));
        model.addAttribute("categoryList",dicService.selectByType(DicTypeConst.CATEGORY));
        model.addAttribute("modifyObj",businessService.selectById(id));
        return "/content/businessModify";
    }

    //删除商户
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id")Long id, Model model){
        if(businessService.remove(id)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.REMOVE_SUCCESS);
        }else{
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.REMOVE_FAIL);
        }
        return "redirect:/businesses";
    }

    //修改商户
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public String modifyBusiness(Model model,BusinessDto businessDto){
        model.addAttribute("modifyObj",businessDto);
        if (businessService.modify(businessDto)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_SUCCESS);
        }else {
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_FAIL);
        }



        return "/content/businessModify";
    }


}
