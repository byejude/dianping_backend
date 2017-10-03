package com.dianping.services;

import org.springframework.stereotype.Service;

/**
 * Created by byebyejude on 2017/10/2.
 */
@Service
public interface MemberService {
    boolean exists(Long phone);

    boolean saveCode(Long phone,String code);

    boolean sendCode(Long phone,String content);

    String getCode(Long phone);

    void saveToken(String token,Long phone);

    Long getPhone(String token);

    Long getIdByPhone(Long phone);
}
