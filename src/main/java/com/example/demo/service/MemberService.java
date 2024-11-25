package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.Member;

@Service
public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void joinMember(String email, String loginPw, String name) {
		memberDao.joinMember(email, loginPw, name);
	}


	public Member getMemberId(String email) {
		return memberDao.getMemberId(email);
	}

	public void modifyPw(int id, String loginPw) {
		memberDao.modifyPw(id, loginPw);
	}

}
