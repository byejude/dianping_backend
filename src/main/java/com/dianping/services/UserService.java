package com.dianping.services;

import com.dianping.dto.UserDto;

import java.util.List;

/**
 * Created by byebyejude on 2017/10/9.
 */
public interface UserService {
    /**
     * 校验用户名/密码是否正确
     * @param userDto 待校验dto对象
     * @return true：用户名/密码正确，如果正确，将dto对象里其他属性补齐
     *                false：用户名/密码错误
     */
    boolean validate(UserDto userDto);

    /**
     * 获取用户列表
     * @return 用户列表
     */
    List<UserDto> getList();

    /**
     * 修改用户
     * @param userDto
     * @return true:修改成功;false:因已存在相同的用户名修改失败
     */
    boolean modify(UserDto userDto);

    /**
     * 新增用户
     * @param userDto
     * @return true:新增成功;false:因已存在相同用户名新增失败
     */
    boolean add(UserDto userDto);

    /**
     * 删除用户
     * @param id
     * @return true:删除成功;false:删除失败
     */
    boolean remove(Long id);

    /**
     * 通过id获取用户
     * @param id
     * @return 用户对象
     */
    UserDto getById(Long id);
}
