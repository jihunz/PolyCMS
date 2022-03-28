package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;

public interface ArticleService {

	List<Article> list(Long boardId);

	void add(Article item);

	Article item(Long boardId, Long articleId);

	void update(Article item);

	void delete(Long BoardId, Long articleId);

	void viewCount(Long boardId, Long articleId);

	void goodCount(Long boardId, Long articleId);

	void badCount(Long boardId, Long articleId);

	void updateCount(ArticleCount item);

}
