package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.Dto.Member;

@Mapper
public interface MemberDao {
	
	@Insert("""
			INSERT INTO `member`
				SET eMail = #{eMail}
				, loginPw = #{loginPw}
				, name = #{name}
			""")
	void joinMember(String eMail, String loginPw, String name);
	
	@Select("""
			SELECT * FROM `member`
				WHERE email = #{email}
			""")
	Member getLoginId(String eMail);
	
	
	@Update("""
			UPDATE `member`
				SET loginPw = #{loginPw}
				WHERE id = #{id}
			""")
	void modifyPw(int id, String loginPw);

}
