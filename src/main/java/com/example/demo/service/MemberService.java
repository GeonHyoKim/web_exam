package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Member;
import com.example.demo.dao.MemberDao;

@Service
public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	public void joinMember(String eMail, String loginPw, String name) {
		memberDao.joinMember(eMail, loginPw, name);
	}


	public Member getLoginId(String eMail) {
		return memberDao.getLoginId(eMail);
	}


	public void modifyPw(int id, String loginPw) {
		memberDao.modifyPw(id, loginPw);
	}


}
