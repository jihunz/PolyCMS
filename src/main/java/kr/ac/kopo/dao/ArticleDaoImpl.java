package kr.ac.kopo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Article;

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

}
