package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.Reply;

@Mapper
public interface ReplyDao {

	@Insert("""
			INSERT INTO reply
				SET regDate = NOW()
					, memberId = #{loginedMemberId}
					, relId = #{relId}
					, `body` = #{body}
			""")
	public void writeReply(int loginedMemberId, int relId, String body);
	
	@Select("""
			SELECT r.*, m.email
				FROM reply AS r
				INNER JOIN `member` AS m
				ON r.memberId = m.id
				WHERE relId = #{relId}
			""")
	public List<Reply> getReplies(int relId);
}
