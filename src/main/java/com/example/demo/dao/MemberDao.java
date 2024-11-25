package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.Member;

@Mapper
public interface MemberDao {
	
	@Insert("""
			INSERT INTO `member`
				SET email = #{email}
				, loginPw = #{loginPw}
				, name = #{name}
			""")
	void joinMember(String email, String loginPw, String name);
	
	@Select("""
			SELECT * FROM `member`
				WHERE email = #{email}
			""")
	Member getMemberId(String email);
	
	@Update("""
			UPDATE `member`
				SET loginPw = #{loginPw}
				WHERE id = #{id}
			""")
	void modifyPw(int id, String loginPw);
	
	

}
