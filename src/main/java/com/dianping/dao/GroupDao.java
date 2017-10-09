package com.dianping.dao;

import com.dianping.bean.Group;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/9.
 */
public interface GroupDao {

    /**
     * 根据查询条件查询用户组列表
     * @param group 查询条件
     * @return 用户组列表
     */
    List<Group> select(Group group);

    /**
     * 新增
     * @param group
     * @return 影响行数：如果用户组名已存在，影响行数为0，新增成功，影响行数为1
     */
    int insert(Group group);

    /**
     * 根据主键获取用户组实体
     * @param id 主键
     * @return 用户组实体
     */
    Group selectById(Long id);

    /**
     * 修改
     * @param group
     * @return 影响行数：如用户组名将修改成与其他用户组的名称相同，影响行数为0；如果修改成功，影响行数为1
     */
    int update(Group group);

    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);

    /**
     * 根据主键获取用户组对应的菜单列表
     * @param id 主键
     * @return 用户组实体(包含菜单列表和动作列表)
     */
    Group selectMenuListById(Long id);

}
