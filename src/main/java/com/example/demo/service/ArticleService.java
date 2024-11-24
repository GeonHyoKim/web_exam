package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Article;
import com.example.demo.dao.ArticleDao;

@Service
public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
	public void writeArticle(int id, String title, String body) {
		articleDao.writeArticle(id, title, body);
	}


	public List<Article> getArticles() {
		return articleDao.getArticles();
	}


	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}
	
}
