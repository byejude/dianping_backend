package com.dianping.services.impl;

import com.dianping.bean.Action;
import com.dianping.bean.Menu;
import com.dianping.dao.ActionDao;
import com.dianping.dao.MenuDao;
import com.dianping.dto.MenuDto;
import com.dianping.dto.MenuForMoveDto;
import com.dianping.dto.MenuForZtreeDto;
import com.dianping.services.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/10.
 */
@Service
public class MenuServiceAImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private ActionDao actionDao;

    @Override
    public List<MenuDto> getList(MenuDto menuDto) {
        List<MenuDto> result = new ArrayList<>();
        Menu menuForSelect =new Menu();
        BeanUtils.copyProperties(menuDto,menuForSelect);
        List<Menu> menuList = menuDao.select(menuForSelect);
        for (Menu menuTemp:menuList
             ) {
            MenuDto menuDtoTemp = new MenuDto();
            BeanUtils.copyProperties(menuTemp,menuDtoTemp);
            result.add(menuDtoTemp);
        }
        return result;
    }

    @Override
    public boolean add(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto,menu);
        return menuDao.insert(menu) == 1;
    }

    @Override
    @Transactional
    public boolean remove(Long id) {
        actionDao.deleteById(id);
        return menuDao.delete(id) == 1;
    }

    @Override
    public MenuDto getById(Long id) {
        MenuDto result = new MenuDto();
        Menu menu = menuDao.selectById(id);
        BeanUtils.copyProperties(menu,result);
        return result;
    }

    @Override
    public boolean modify(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto,menu);
        return menuDao.update(menu) == 1;
    }

    @Transactional
    @Override
    public boolean order(MenuForMoveDto menuForMoveDto) {
        if(menuForMoveDto.getMoveType().equals(MenuForMoveDto.MOVE_TYPE_INNER)){
           menuDao.updateOrderNumByParentId(menuForMoveDto.getTargetNodeId());

            Menu menuForInner = new Menu();
            menuForInner.setOrderNum(1);
            menuForInner.setParentId(menuForMoveDto.getTargetNodeId());
            menuForInner.setId(menuForMoveDto.getDropNodeId());
            menuDao.update(menuForInner);
        }else {
            Menu menuAim = menuDao.selectById(menuForMoveDto.getTargetNodeId());
            if(menuAim != null){
                if(menuForMoveDto.getMoveType().equals(MenuForMoveDto.MOVE_TYPE_PREV)){
                    menuDao.updateOrderNumByIdInclude(menuForMoveDto.getTargetNodeId());

                    Menu menuForPrev = new Menu();
                    menuForPrev.setOrderNum(menuAim.getOrderNum());
                    menuForPrev.setParentId(menuAim.getParentId());
                    menuForPrev.setId(menuForMoveDto.getDropNodeId());
                    menuDao.update(menuForPrev);
                }else if(menuForMoveDto.getMoveType().equals(MenuForMoveDto.MOVE_TYPE_NEXT)){
                    menuDao.updateOrderNumByParentId(menuForMoveDto.getTargetNodeId());

                    Menu menuForLast = new Menu();
                    menuForLast.setOrderNum(menuAim.getOrderNum()+1);
                    menuForLast.setId(menuForMoveDto.getDropNodeId());
                    menuForLast.setParentId(menuAim.getParentId());
                    menuDao.update(menuForLast);
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<MenuForZtreeDto> getZtreeList() {
        List<MenuForZtreeDto> result = new ArrayList<>();
        List<Menu> menuList = menuDao.selectWithAction(new Menu());

        for (Menu menuTemp:menuList
             ) {
            MenuForZtreeDto menuForZtreeDto4Menu = new MenuForZtreeDto();
            BeanUtils.copyProperties(menuTemp,menuForZtreeDto4Menu);
            menuForZtreeDto4Menu.setOpen(true);
            menuForZtreeDto4Menu.setComboId(MenuForZtreeDto.PREFIX_MENU+menuTemp.getId());
            menuForZtreeDto4Menu.setComboParentId(MenuForZtreeDto.PREFIX_MENU+menuTemp.getParentId());
            result.add(menuForZtreeDto4Menu);

            for (Action actionTemp:menuTemp.getActionList()
                 ) {
                MenuForZtreeDto menuForZtreeDto4Action = new MenuForZtreeDto();
                menuForZtreeDto4Action.setName(actionTemp.getName());
                menuForZtreeDto4Action.setComboParentId(MenuForZtreeDto.PREFIX_ACTION+actionTemp.getMenuId());
                menuForZtreeDto4Action.setComboId(MenuForZtreeDto.PREFIX_ACTION+actionTemp.getId());
                menuForZtreeDto4Action.setParentId(actionTemp.getMenuId());
                menuForZtreeDto4Action.setId(actionTemp.getId());
                result.add(menuForZtreeDto4Action);
            }
        }


        return result;
    }
}
