package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Dto.Article;

@Mapper
public interface ArticleDao {
	
	@Insert("""
			INSERT INTO article
				SET title = #{title}
				, `body` = #{body}
				, memberId = #{id}
			""")
	void writeArticle(int id, String title, String body);
	
	@Select("""
			SELECT * FROM article
			""")
	List<Article> getArticles();
	
	@Select("""
			SELECT * FROM article
				WHERE id = #{id}
			""")
	Article getArticleById(int id);

}
