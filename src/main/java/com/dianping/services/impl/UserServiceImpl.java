package com.dianping.services.impl;

import com.dianping.bean.User;
import com.dianping.dao.UserDao;
import com.dianping.dto.UserDto;
import com.dianping.services.UserService;
import com.dianping.utils.CommonUtil;
import com.dianping.utils.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public boolean validate(UserDto userDto) {
        if(userDto != null && !CommonUtil.isEmpty(userDto.getName()) && !CommonUtil.isEmpty(userDto.getPassword())){
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            List<User> userList = userdao.select(user);
            if(userList.size() == 1){
                BeanUtils.copyProperties(userList.get(0),userDto);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public List<UserDto> getList() {
      List<UserDto> result = new ArrayList<>();
      User userForSelect = new User();
      List<User> userList = userdao.select(userForSelect);
        for (User userTemp:userList
             ) {
            UserDto userDtoTemp = new UserDto();
            BeanUtils.copyProperties(userTemp,userDtoTemp);
            userDtoTemp.setpId(0);
            result.add(userDtoTemp);
        }
        return result;
    }

    @Override
    public boolean modify(UserDto userDto) {
       User user = new User();
       BeanUtils.copyProperties(userDto,user);
        if (!CommonUtil.isEmpty(userDto.getPassword())){
            user.setPassword(MD5Util.getMD5(userDto.getPassword()));
            return userdao.update(user) == 1;
        }
        return false;
    }

    @Override
    public boolean add(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setPassword(MD5Util.getMD5(userDto.getPassword()));
        return userdao.insert(user) == 1;

    }

    @Override
    public boolean remove(Long id) {
       return userdao.delete(id) == 1;
    }

    @Override
    public UserDto getById(Long id) {
       UserDto userDto = new UserDto();
       User user = userdao.selectById(id);
       BeanUtils.copyProperties(user,userDto);

        return userDto;
    }
}