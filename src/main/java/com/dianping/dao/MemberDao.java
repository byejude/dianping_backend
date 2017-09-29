package com.dianping.dao;

import com.dianping.bean.Member;

import java.util.List;

public interface MemberDao {


    List<Member> select(Member member);
}