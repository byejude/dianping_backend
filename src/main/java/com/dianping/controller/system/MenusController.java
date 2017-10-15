package com.dianping.controller.system;

import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.MenuDto;
import com.dianping.dto.MenuForMoveDto;
import com.dianping.dto.MenuForZtreeDto;
import com.dianping.dto.PageCodeDto;
import com.dianping.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/14.
 */
@RestController
@RequestMapping("/menus")
public class MenusController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuForZtreeDto> getList(){
        return  menuService.getZtreeList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public PageCodeDto add(MenuDto menuDto){
        PageCodeDto result;
        if(menuService.add(menuDto)){
            result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
        }else{
            result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
        }
        return  result;
    }

    @RequestMapping(value = "/{dropNodeId}/{targetNodeId}/{moveType}",method = RequestMethod.PUT)
    public PageCodeDto order(MenuForMoveDto menuForMoveDto){
        PageCodeDto result;
        if(menuService.order(menuForMoveDto)){
            result = new PageCodeDto(PageCodeEnum.ORDER_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.ORDER_FAIL);
        }
        return  result;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public PageCodeDto modify(MenuDto menuDto){
        PageCodeDto result;
        if(menuService.modify(menuDto)){
            result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
        }
        return  result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public PageCodeDto remove(@PathVariable("id")Long id){
        PageCodeDto result;
        MenuDto menuDto = new MenuDto();
        menuDto.setParentId(id);
        List<MenuDto> menuDtoList = menuService.getList(menuDto);
        if(menuDtoList.size() > 0){
            result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
        }
        return  result;
    }
}
