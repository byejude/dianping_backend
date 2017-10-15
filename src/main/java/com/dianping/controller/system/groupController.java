package com.dianping.controller.system;

import com.dianping.bean.Group;
import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.GroupDto;
import com.dianping.dto.PageCodeDto;
import com.dianping.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/14.
 */

@RestController
@RequestMapping("/groups")
public class groupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupDto> getList(){
        return groupService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public PageCodeDto add(GroupDto groupDto){
        PageCodeDto result;
        if(groupService.add(groupDto)){
            result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.ADD_FAIL);
        }
        return result;
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public GroupDto getGroupById(@PathVariable("id") Long id){
        return groupService.getById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public PageCodeDto modify(GroupDto groupDto){
        PageCodeDto result;
        if(groupService.modify(groupDto)){
            result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
        }else{
            result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
        }
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public PageCodeDto delete(@PathVariable("id") Long id){
        PageCodeDto result;
        if(groupService.remove(id)){
            result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
        }else{
            result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
        }
        return result;
    }

    @RequestMapping(value = "/{id}/menus",method = RequestMethod.GET)
    public GroupDto getMenuList(@PathVariable("id")Long id){
        return groupService.getByIdWithMenuAction(id);
    }

    @RequestMapping(value = "/{id}/menus",method = RequestMethod.POST)
    public PageCodeDto assignMenus(GroupDto groupDto){
        PageCodeDto result;
        if(groupService.assignMenu(groupDto)){
            result = new PageCodeDto(PageCodeEnum.ASSIGN_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.ASSIGN_FAIL);
        }
        return result;
    }



}
