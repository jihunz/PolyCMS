package kr.ac.kopo.aspects;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.model.Member;

@Repository
public class LogDaoImpl implements LogDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public void login(Member member, boolean result) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("member", member);
		map.put("result", result);
		
		sql.insert("log.login", map);
	}

}
