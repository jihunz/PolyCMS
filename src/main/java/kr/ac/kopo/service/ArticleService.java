package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Article;

public interface ArticleService {

	List<Article> list(Long boardId);

	void add(Article item);

	Article item(Long boardId, Long articleId);

	void update(Article item);

	void delete(Long articleId, Long articleId2);

	void viewCount(Long boardId, Long articleId);

}
