package kr.ac.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.ArticleDao;
import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	ArticleDao dao;

	@Override
	public List<Article> list(Long boardId) {
		return dao.list(boardId);
	}

	@Override
	public void add(Article item) {
		dao.add(item);
		
		dao.viewSeq(item.getArticleId());
		dao.goodSeq(item.getArticleId());
		dao.badSeq(item.getArticleId());
	}

	@Override
	public Article item(Long boardId, Long articleId) {
		return dao.item(boardId, articleId);
	}

	@Override
	public void update(Article item) {
		dao.update(item);
	}

	@Override
	public void delete(Long boardId, Long articleId) {
		dao.delete(boardId, articleId);
		
		dao.deleteViewSeq(articleId);
		dao.deleteGoodSeq(articleId);
		dao.deleteBadSeq(articleId);
	}

	@Override
	public void viewCount(Long boardId, Long articleId) {
		dao.viewCount(boardId, articleId);
	}

	@Override
	public void goodCount(Long boardId, Long articleId) {
		dao.goodCount(boardId, articleId);
		
	}

	@Override
	public void badCount(Long boardId, Long articleId) {
		dao.badCount(boardId, articleId);
		
	}

	@Override
	public void updateCount(ArticleCount item) {
		if("ref_count".equals(item.getType())) {
			dao.refCount(item);
		} else if("good_count".equals(item.getType())) {
			dao.goodCount(item);
		} else if("bad_count".equals(item.getType())) {
			dao.badCount(item);
		}
		
	}

}
