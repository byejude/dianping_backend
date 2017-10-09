package com.dianping.services.impl;

import com.dianping.bean.Action;
import com.dianping.dao.ActionDao;
import com.dianping.dto.ActionDto;
import com.dianping.services.ActionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDao actionDao;

    @Override
    public boolean add(ActionDto dto) {
          return actionDao.insert(dto) == 1;
    }

    @Override
    public boolean remove(Long id) {
          return actionDao.deleteById(id) == 1;
    }

    @Override
    public boolean modify(ActionDto dto) {
          return actionDao.update(dto) == 1;
    }

    @Override
    public ActionDto getById(Long id) {
        ActionDto actionDto = new ActionDto();
        Action action = actionDao.selectById(id);
        BeanUtils.copyProperties(action,actionDto);
        return actionDto;
    }
}