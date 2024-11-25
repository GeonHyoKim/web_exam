package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ReplyDao;
import com.example.demo.dto.Reply;

@Service
public class ReplyService {

	private ReplyDao replyDao;

	public ReplyService(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public void writeReply(int memberId, int relId, String body) {
		replyDao.writeReply(memberId, relId, body);
	}

	public List<Reply> getReplies(int relId) {
		return replyDao.getReplies(relId);
	}

	
}
