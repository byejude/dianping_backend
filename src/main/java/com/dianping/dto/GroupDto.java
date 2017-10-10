package com.dianping.dto;

import com.dianping.bean.Group;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/9.
 */
public class GroupDto extends Group {

    private Integer pId;
    private List<Long> menuIdList;
    private List<Long> actionIdList;
    private List<MenuDto> menuDtoList;
    private List<ActionDto> actionDtoList;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getActionIdList() {
        return actionIdList;
    }

    public void setActionIdList(List<Long> actionIdList) {
        this.actionIdList = actionIdList;
    }

    public List<MenuDto> getMenuDtoList() {
        return menuDtoList;
    }

    public void setMenuDtoList(List<MenuDto> menuDtoList) {
        this.menuDtoList = menuDtoList;
    }

    public List<ActionDto> getActionDtoList() {
        return actionDtoList;
    }

    public void setActionDtoList(List<ActionDto> actionDtoList) {
        this.actionDtoList = actionDtoList;
    }
}
