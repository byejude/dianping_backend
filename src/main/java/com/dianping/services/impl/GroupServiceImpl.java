package com.dianping.services.impl;

import com.dianping.bean.*;
import com.dianping.dao.GroupActionDao;
import com.dianping.dao.GroupDao;
import com.dianping.dao.GroupMenuDao;
import com.dianping.dto.ActionDto;
import com.dianping.dto.GroupDto;
import com.dianping.dto.MenuDto;
import com.dianping.services.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Group group = new Group();
        BeanUtils.copyProperties(groupDto,group);
        return groupDao.insert(group) == 1;
    }

    @Override
    public boolean remove(Long id) {
        return groupDao.delete(id) == 1;
    }

    @Override
    public GroupDto getById(Long id) {
        GroupDto groupDto = new GroupDto();
        Group group = groupDao.selectById(id);
        BeanUtils.copyProperties(group, groupDto);
        return groupDto;
    }

    @Override
    public GroupDto getByIdWithMenuAction(Long id) {
        GroupDto result = new GroupDto();
        List<MenuDto> menuDtoList = new ArrayList<>();
        List<ActionDto> actionDtoList = new ArrayList<>();
        result.setActionDtoList(actionDtoList);
        result.setMenuDtoList(menuDtoList);

        Group group = groupDao.selectMenuListById(id);
        if(group != null){
            BeanUtils.copyProperties(group,result);
            for(Menu menuTemp:group.getMenuList()){
                MenuDto menuDto = new MenuDto();
                BeanUtils.copyProperties(menuTemp,menuDto);
                menuDtoList.add(menuDto);
            }
            for(Action actionTemp:group.getActionList()){
                ActionDto actionDto = new ActionDto();
                BeanUtils.copyProperties(actionTemp,actionDto);
                actionDtoList.add(actionDto);
            }

        }
        return result;
    }

    @Transactional
    @Override
    public boolean assignMenu(GroupDto groupDto) {
         //删除原先用户组分配的菜单及动作
          groupMenuDao.deleteByGroupId(groupDto.getId());
          groupActionDao.deleteByGroupId(groupDto.getId());

        // 保存为用户组分配的菜单
        if(groupDto.getMenuIdList() != null &&groupDto.getMenuIdList().size()>0){
            List<GroupMenu> newGroupMenuList = new ArrayList<>();
            for(Long menuId:groupDto.getMenuIdList()){
                if (menuId != null){
                    GroupMenu groupMenu = new GroupMenu();
                    groupMenu.setGroupId(menuId);
                    groupMenu.setGroupId(groupDto.getId());
                    newGroupMenuList.add(groupMenu);
                }
            }
            groupMenuDao.insertBatch(newGroupMenuList);
        }

        // 保存为用户组分配的动作
        if(groupDto.getActionIdList() != null &&groupDto.getActionIdList().size()>0){
            List<GroupAction> newGroupActionList = new ArrayList<>();
            for(Long actionId:groupDto.getActionIdList()){
                if (actionId != null){
                    GroupAction groupAction = new GroupAction();
                    groupAction.setGroupId(actionId);
                    groupAction.setGroupId(groupDto.getId());
                    newGroupActionList.add(groupAction);
                }
            }
            groupActionDao.insertBatch(newGroupActionList);
        }
        return true;
    }
}