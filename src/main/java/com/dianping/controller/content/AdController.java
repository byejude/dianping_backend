package com.dianping.controller.content;

/**
 * Created by byebyejude on 2017/9/19.
 */

import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.AdDto;
import com.dianping.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping
    public String adInit(Model model) {
        AdDto adDto = new AdDto();
        model.addAttribute("list",adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }

    //加载广告添加起始页
    @RequestMapping("/adAdd")
    public String addInit() {
        return "/content/adAdd";
    }

    //加载广告修改起始页
    @RequestMapping("/modifyInit")
    public String modifyInit(Model model,@RequestParam("id") Long id){
        model.addAttribute("modifyobj",adService.getById(id));
        return "/content/admodify";
    }

    @RequestMapping("/add")
    public String adAdd(Model model,AdDto adDto) {
        if(adService.add(adDto)){
           model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
        }else{
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL);
        }
        return "/content/adAdd";
    }

    @RequestMapping("/search")
    public String search(Model model,AdDto adDto){
        model.addAttribute("list",adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam("id")Long id, Model model){
        if(adService.remove(id)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.REMOVE_SUCCESS);
        }else{
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.REMOVE_FAIL);
        }
        return  "redirect:/ad";
    }


    @RequestMapping("/modify")
   public String modify(Model model,AdDto adDto){
      if (adService.modify(adDto)){
          model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_SUCCESS);
      }else{
          model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_FAIL);
      }
      return  "redirect:/ad";

  }


}