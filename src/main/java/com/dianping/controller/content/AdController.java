package com.dianping.controller.content;

/**
 * Created by byebyejude on 2017/9/19.
 */

import com.dianping.dto.AdDto;
import com.dianping.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ad")
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping
    public String adInit(Model model, HttpServletRequest request) {
        AdDto adDto = new AdDto();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+request);
        model.addAttribute("list",adService.searchByPage(adDto));
        return "/content/adList";
    }

    @RequestMapping("/adAdd")
    public String addInit() {
//        if(adService.add(adDto)){
//            System.out.println("yes！");
//        }else{
//            System.out.println("nono!");
//        }
        return "/content/adAdd";
    }

    @RequestMapping("/add")
    public String adAdd(AdDto adDto) {
        if(adService.add(adDto)){
            System.out.println("yes！");
        }else{
            System.out.println("nono!");
        }
        return "/content/adAdd";
    }

}