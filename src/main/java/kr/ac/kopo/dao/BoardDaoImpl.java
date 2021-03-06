package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Board;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession sql;
	
	final String NAMESPACE = "board.";
	
	@Override
	public List<Board> list() {
		return sql.selectList(NAMESPACE+"list");
	}

	@Override
	public Board item(Long boardId) {
		return sql.selectOne(NAMESPACE+"item", boardId);
	}

	@Override
	public void add(Board item) {
		sql.insert(NAMESPACE+"add", item);
	}

	@Override
	public void update(Board item) {
		sql.update(NAMESPACE+"update", item);
	}

	@Override
	public void delete(Long boardId) {
		sql.delete(NAMESPACE+"delete", boardId);
	}

	@Override
	public void createTable(Long boardId) {
		sql.update("board.create_board", boardId);
		
	}

	@Override
	public void deleteTable(Long boardId) {
		sql.update("board.delete_board", boardId);
		
	}

	@Override
	public void createSeq(Long boardId) {
		sql.update("board.create_board_seq", boardId);
		
	}

	@Override
	public void deleteSeq(Long boardId) {
		sql.update("board.delete_board_seq", boardId);
		
	}

	

}
