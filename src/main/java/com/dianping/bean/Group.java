package com.dianping.bean;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/9.
 */
public class Group {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    private Long id;
    private String name;
    private List<Menu> menuList;
    private List<Action> actionList;

}
