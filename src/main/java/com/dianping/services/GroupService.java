package com.dianping.services;

import com.dianping.dto.GroupDto;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/9.
 */
public interface GroupService {

    /**
     * 获取用户组列表
     */
    List<GroupDto> getList();

    /**
     * 修改用户组
     * @param groupDto
     * @return true:修改成功;false:因已存在相同的用户组名修改失败
     */
    boolean modify(GroupDto groupDto);

    /**
     * 新增用户组
     * @param groupDto
     * @return true:新增成功;false:因已存在相同用户组名新增失败
     */
    boolean add(GroupDto groupDto);

    /**
     * 删除用户组
     * @param id
     * @return true:删除成功;false:删除失败
     */
    boolean remove(Long id);

    /**
     * 根据主键获取用户组
     * @param id 主键
     * @return 用户组对象
     */
    GroupDto getById(Long id);

    /**
     * 根据主键获取用户组(包括用户组对应可以访问的菜单和动作)
     * @param id
     * @return 用户组对象
     */
    GroupDto getByIdWithMenuAction(Long id);

    /**
     * 为用户组分配可以访问的菜单
     * @param groupDto
     * @return
     */
    boolean assignMenu(GroupDto groupDto);
}
