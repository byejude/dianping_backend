package com.dianping.services.impl;

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

    @Override
    public boolean order(MenuForMoveDto menuForMoveDto) {
        return false;
    }

    @Override
    public List<MenuForZtreeDto> getZtreeList() {
        return null;
    }
}
