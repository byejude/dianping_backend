package com.dianping.controller.system;

import com.dianping.constant.PageCodeEnum;
import com.dianping.dto.ActionDto;
import com.dianping.dto.PageCodeDto;
import com.dianping.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by byebyejude on 2017/10/11.
 */
@Controller
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(method = RequestMethod.POST)
    public PageCodeDto add(ActionDto actionDto){
        PageCodeDto pageCodeDto ;
        if(actionService.add(actionDto)){
            pageCodeDto = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
        }else {
            pageCodeDto = new PageCodeDto(PageCodeEnum.ADD_FAIL);
        }
        return pageCodeDto;
    }


    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public PageCodeDto remove(@PathVariable("id")Long id) {
        PageCodeDto result;
        if(actionService.remove(id)) {
            result = new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
        }
        return result;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public PageCodeDto modify(ActionDto actionDto) {
        PageCodeDto result;
        if(actionService.modify(actionDto)) {
            result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.MODIFY_FAIL);
        }
        return result;
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ActionDto getById(@PathVariable("id") Long id) {
        return actionService.getById(id);
    }

}
