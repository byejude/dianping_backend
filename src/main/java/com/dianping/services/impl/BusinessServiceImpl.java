package com.dianping.services.impl;
import com.dianping.bean.Business;
import com.dianping.dao.BusinessDao;
import com.dianping.dto.BusinessDto;
import com.dianping.services.BusinessService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService{
    @Autowired
    private BusinessDao businessDao;

    @Value("${businessImage.savePath}")
    private String businessImagesavePath;

    @Value("${businessImage.url}")
    private String businessImageUrl;

    @Override
    public boolean add(BusinessDto businessDto) {
        return false;
    }

    @Override
    public List<BusinessDto> selectByPage(BusinessDto businessDto) {
        List<BusinessDto> result = new ArrayList<BusinessDto>();
        Business business4Select = new Business();
        BeanUtils.copyProperties(businessDto,business4Select);
        List<Business> businessList = businessDao.selectByPage(business4Select);
        for (Business business:businessList
             ) {
            BusinessDto businessTemp = new BusinessDto();
            businessTemp.setImg(businessImageUrl+business.getImgFileName());
            businessTemp.setStar(this.getStar(business));
            BeanUtils.copyProperties(business,businessTemp);
            result.add(businessTemp);
        }

        return result;
    }

    @Override
    public BusinessDto selectById(Long id) {
        BusinessDto result = new BusinessDto();
        Business business = businessDao.selectById(id);
        BeanUtils.copyProperties(business, result);
        result.setImg(businessImageUrl + business.getImgFileName());

        result.setStar(this.getStar(business));

        return result;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean modify(BusinessDto businessDto) {
        return false;
    }

    private int getStar(Business business) {
        if(business.getStarTotalNum() != null && business.getCommentTotalNum() != null && business.getCommentTotalNum() != 0) {
            return (int)(business.getStarTotalNum() / business.getCommentTotalNum());
        } else {
            return 0;
        }
    }
}