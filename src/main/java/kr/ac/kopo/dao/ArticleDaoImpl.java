package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.ArticleCount;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	SqlSession sql;

	@Override
	public List<Article> list(Long boardId) {
		return sql.selectList("article.list", boardId);
	}

	@Override
	public void add(Article item) {
		sql.insert("article.add", item);
	}

	@Override
	public Article item(Long boardId, Long articleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("boardId", boardId);
		map.put("articleId", articleId);

		return sql.selectOne("article.item", map);
	}

	@Override
	public void update(Article item) {
		sql.update("article.update", item);
	}

	@Override
	public void delete(Long boardId, Long articleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("boardId", boardId);
		map.put("articleId", articleId);

		sql.delete("article.delete", map);
	}

	@Override
	public void viewCount(Long boardId, Long articleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("boardId", boardId);
		map.put("articleId", articleId);

		sql.update("article.viewCount", map);

	}
	
	@Override
	public void goodCount(Long boardId, Long articleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("boardId", boardId);
		map.put("articleId", articleId);

		sql.update("article.goodCount", map);
	}

	@Override
	public void badCount(Long boardId, Long articleId) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("boardId", boardId);
		map.put("articleId", articleId);

		sql.update("article.badCount", map);
	}

	@Override
	public void viewSeq(Long articleId) {
		sql.update("article.create_view_seq", articleId);
	}

	@Override
	public void goodSeq(Long articleId) {
		sql.update("article.create_good_seq", articleId);

	}

	@Override
	public void badSeq(Long articleId) {
		sql.update("article.create_bad_seq", articleId);

	}

	@Override
	public void deleteViewSeq(Long articleId) {
		sql.delete("article.delete_view_seq", articleId);
	}

	@Override
	public void deleteGoodSeq(Long articleId) {
		sql.delete("article.delete_good_seq", articleId);

	}

	@Override
	public void deleteBadSeq(Long articleId) {
		sql.delete("article.delete_bad_seq", articleId);

	}

	@Override
	public void refCount(ArticleCount item) {
		sql.update("article.ref_count", item);
		
	}

	@Override
	public void goodCount(ArticleCount item) {
		sql.update("article.good_count", item);
		
	}

	@Override
	public void badCount(ArticleCount item) {
		sql.update("article.bad_count", item);
	}

}
