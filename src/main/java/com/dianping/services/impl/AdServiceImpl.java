package com.dianping.services.impl;


import com.dianping.bean.Ad;
import com.dianping.dao.AdDao;
import com.dianping.dto.AdDto;
import com.dianping.services.AdService;
import com.dianping.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by byebyejude on 2017/9/23.
 */

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDao adDao;

    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Value("${adImage.url}")
    private String adInageUrl;

    @Override
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());
//        if(adDto.getImgFile()!=null&&adDto.getImgFile().getSize()>0){
//            String filename = adImageSavePath+System.currentTimeMillis()+"_"+adDto.getImgFile().getOriginalFilename();
//            File file = new File(filename);
//            File fileFolder = new File(adImageSavePath);
//            if(!fileFolder.exists()){
//                fileFolder.mkdirs();
//            }
//            try {
//        adDto.getImgFile().transferTo(file);
//                ad.setImgFileName(filename);
//                adDao.insert(ad);
//                return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//                return false;
//        }
//
//        }else{
//        return false;
//
//        }
        //服务端校验
        if(adDto.getImgFile()!=null&&adDto.getImgFile().getSize()>0){
        try {
            String filename = FileUtil.save(adDto.getImgFile(),adImageSavePath);
            if (filename!=null){
            ad.setImgFileName(filename);
            adDao.insert(ad);
            return true;
            }else {
            return  false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        }else {
            return  false;
        }

    }

    @Override
    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result= new ArrayList<AdDto>();
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto,ad);
        List<Ad> adList= adDao.selectByPage(ad);

        for (Ad adTemp :adList
             ) {
            AdDto adDtoTemp = new AdDto();
            adDtoTemp.setImg(adInageUrl+adTemp.getImgFileName());
            BeanUtils.copyProperties(adTemp,adDtoTemp);
            result.add(adDtoTemp);
        }
        return result;
    }

    @Override
    public boolean remove(Long id) {
        Ad ad = adDao.selectById(id);
        if(FileUtil.delete(adImageSavePath+ad.getImgFileName())){
        int deleteRows = adDao.delete(id);
          return  deleteRows == 1;
        }else{
        return false;
        }
    }

    @Override
    public AdDto getById(Long id) {
        return null;
    }

    @Override
    public boolean modify(AdDto adDto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto,ad);
        String filename = null;
        if(adDto.getImgFile()!=null&&adDto.getImgFile().getSize()>0){
            try {
                filename = FileUtil.save(adDto.getImgFile(),adImageSavePath);
                if (filename.equals("")){
                ad.setImgFileName(filename);}
                else{
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int updateCount = adDao.update(ad);
        if(updateCount!=1){
            return false;
        }
        if (filename!=null){
            return FileUtil.delete(adImageSavePath + adDto.getImgFileName());
        }
        return false;
    }
}