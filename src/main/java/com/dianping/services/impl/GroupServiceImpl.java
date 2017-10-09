package com.dianping.services.impl;

import com.dianping.bean.Group;
import com.dianping.dao.GroupActionDao;
import com.dianping.dao.GroupDao;
import com.dianping.dao.GroupMenuDao;
import com.dianping.dto.GroupDto;
import com.dianping.services.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupActionDao groupActionDao;

    @Autowired
    private GroupMenuDao groupMenuDao;

    @Override
    public List<GroupDto> getList() {
        List<GroupDto> result = new ArrayList<>();
        List<Group> groupList = groupDao.select(new Group());
        for (Group groupTemp:groupList
             ) {
            GroupDto groupDtoTemp = new GroupDto();
            BeanUtils.copyProperties(groupTemp,groupDtoTemp);
            groupDtoTemp.setpId(0);
            result.add(groupDtoTemp);
        }
        return result;
    }

    @Override
    public boolean modify(GroupDto groupDto) {
           Group group = new Group();
           BeanUtils.copyProperties(groupDto,group);
           return groupDao.update(group) == 1;
    }

    @Override
    public boolean add(GroupDto groupDto) {

    }

    @Override
    public boolean remove(Long id) {

    }

    @Override
    public GroupDto getById(Long id) {

    }

    @Override
    public GroupDto getByIdWithMenuAction(Long id) {

    }

    @Override
    public boolean assignMenu(GroupDto groupDto) {

    }
}