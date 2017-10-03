package com.dianping.services.impl;
import com.dianping.bean.Business;
import com.dianping.bean.Page;
import com.dianping.constant.CategoryConst;
import com.dianping.dao.BusinessDao;
import com.dianping.dto.BusinessDto;
import com.dianping.dto.BusinessListDto;
import com.dianping.services.BusinessService;
import com.dianping.utils.CommonUtil;
import com.dianping.utils.FileUtil;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.dianping.utils.FileUtil.save;

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
        Business businessTemp = new Business();
        BeanUtils.copyProperties(businessDto,businessTemp);
        if(businessDto.getImgFile()!=null&&businessDto.getImgFile().getSize()>0){
            try {
                String filename = save(businessDto.getImgFile(),businessImagesavePath);
                businessTemp.setImgFileName(filename);
                businessTemp.setNumber(0);
                businessTemp.setStarTotalNum(0L);
                businessTemp.setCommentTotalNum(0L);
                businessDao.insert(businessTemp);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
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
        Business business = businessDao.selectById(id);
        FileUtil.delete(businessImagesavePath+business.getImgFileName());

        return businessDao.delete(id) ==1;
    }

    @Override
    public boolean modify(BusinessDto businessDto) {
        Business businessTemp = new Business();
        BeanUtils.copyProperties(businessDto,businessTemp);
        String filename = null;
        if(businessDto.getImgFile()!=null&&businessDto.getImgFile().getSize()>0){
            try {
                filename =  FileUtil.save(businessDto.getImgFile(),businessImagesavePath);
                businessTemp.setImgFileName(filename);
            } catch (IOException e) {
                return false;
            }
        }
        //todo 删除老图片
        int updaterow = businessDao.updateBusiness(businessTemp);
        if (updaterow!=1){

                return false;
            }
        return true;
    }


    @Override
    public BusinessListDto searchByPageForApi(BusinessDto businessDto) {
        BusinessListDto result = new BusinessListDto();
        Business businessTemp = new Business();
        BeanUtils.copyProperties(businessDto,businessTemp);
        String keyWord = businessDto.getKeyword();
        System.out.println( "businessDto.getKeyword()————————————》"+keyWord);
        if(!CommonUtil.isEmpty(keyWord)){
            System.out.println( "businessDto.getKeyword()————————————》"+keyWord);
            businessTemp.setTitle(keyWord);
           businessTemp.setSubtitle(keyWord);
           businessTemp.setDesc(keyWord);
        }
        System.out.println( "businessDto.getKeyword()11111111111————————————》"+businessTemp.getTitle());
        System.out.println( "businessDto.getKeyword()22222222222————————————》"+businessTemp.getSubtitle());
        System.out.println( "businessDto.getKeyword()—33333333333———————————》"+businessTemp.getDesc());
        System.out.println("businessDto.getCategory()_____>"+businessDto.getCategory());
        if(businessDto.getCategory()!=null&&businessDto.getCategory().equals(CategoryConst.ALL)){
            businessTemp.setCategory(null);
        }

        int currentPageFromFront = businessDto.getPage().getCurrentPage();
        System.out.println("businessDto.getPage().getCurrentPage()_____>"+businessDto.getPage().getCurrentPage());
        businessTemp.getPage().setCurrentPage(currentPageFromFront+1);

        Page page = businessTemp.getPage();
        result.setHasMore(page.getCurrentPage()<page.getTotalPage());

        List<Business> list = businessDao.selectLikeByPage(businessTemp);

        for (Business bs:list
             ) {
            System.out.print("!!!!!!!_________________!!!"+bs.getTitle());
            BusinessDto bsd = new BusinessDto();
            BeanUtils.copyProperties(bs,bsd);
            bsd.setImg(businessImageUrl+bs.getImgFileName());

            bsd.setMumber(bs.getNumber());

            bsd.setStar(this.getStar(bs));
            result.getData().add(bsd);

        }
        System.out.println("3333333333333333333333333333333333333333");
        return result;
    }

    private int getStar(Business business) {
        if(business.getStarTotalNum() != null && business.getCommentTotalNum() != null && business.getCommentTotalNum() != 0) {
            return (int)(business.getStarTotalNum() / business.getCommentTotalNum());
        } else {
            return 0;
        }
    }
}