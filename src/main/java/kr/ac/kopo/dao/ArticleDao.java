package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;
import kr.ac.kopo.pager.ArticlePager;

public interface ArticleDao {

	List<Article> list(ArticlePager pager);

	void add(Article item);

	Article item(Long boardId, Long articleId);

	void update(Article item);

	void delete(Long boardId, Long articleId);

	void refCount(ArticleCount item);

	void goodCount(ArticleCount item);

	void badCount(ArticleCount item);

	double total(ArticlePager pager);

}
