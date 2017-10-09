package com.dianping.dto;

/**
 * Created by byebyejude on 2017/10/9.
 */
public class MenuForZtreeDto {

    /**
     * 这个节点在数据库里的主键值
     */
    private Long id;
    /**
     * 这个节点在数据库里的父节点主键值
     */
    private Long parentId;

    /**
     * 树上显示的名称
     */
    private String name;

    /**
     * ztree上是否默认展开
     */
    private boolean open;

    /**
     * 用来表示zTree上父子节点关系的节点ID：
     * 因将会在一颗树上展示两种节点：菜单、动作
     * 这两个来自两张表，表的主键会重复，这样会造成ztree展示时混乱，为了区分ztree上两种节点，将在这两种节点的原主键上加前缀：
     * 来自菜单表的节点：菜单前缀+菜单表ID
     * 来自动作表的节点：动作前缀+动作表ID
     */
    private String comboId;

    /**
     * 用来表示zTree上父子节点关系的父节点ID：
     * 与comboId原因相同。
     */
    private String comboParentId;

    /**
     * 菜单表节点前缀
     */
    public static final String PREFIX_MENU = "MENU_";
    /**
     * 动作表节点前缀
     */
    public static final String PREFIX_ACTION = "ACTION_";

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }

    public String getComboParentId() {
        return comboParentId;
    }

    public void setComboParentId(String comboParentId) {
        this.comboParentId = comboParentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
