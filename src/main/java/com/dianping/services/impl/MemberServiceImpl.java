package com.dianping.services.impl;


import com.dianping.bean.Member;
import com.dianping.cache.CodeCache;
import com.dianping.cache.TokenCache;
import com.dianping.dao.MemberDao;
import com.dianping.services.MemberService;
import com.dianping.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/2.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao memberDao;


    private final static Logger logger = LoggerFactory
            .getLogger(MemberService.class);

    @Override
    public boolean exists(Long phone) {
        Member member = new Member();
        member.setPhone(phone);
        List<Member> membersList = memberDao.select(member);
        return (membersList!=null&&membersList.size()==1);
    }

    @Override
    public boolean saveCode(Long phone, String code) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.save(phone, MD5Util.getMD5(code));
    }

    @Override
    public boolean sendCode(Long phone, String content) {
        logger.info(phone+"|||"+content);
        return true;
    }

    @Override
    public String getCode(Long phone) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.getCode(phone);
    }

    @Override
    public void saveToken(String token, Long phone) {
        TokenCache tokenCache = TokenCache.getInstance();
        tokenCache.save(token,phone);
    }

    @Override
    public Long getPhone(String token) {
        TokenCache tokenCache = TokenCache.getInstance();
        return tokenCache.getPhone(token);
    }

    @Override
    public Long getIdByPhone(Long phone) {
        Member member = new Member();
        member.setPhone(phone);
        List<Member> memberList = memberDao.select(member);
        if(memberList != null&&memberList.size() == 1){
            return memberList.get(0).getId();
        }
        return null;
    }
}
