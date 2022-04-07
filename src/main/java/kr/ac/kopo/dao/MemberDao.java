package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

public interface MemberDao {

	List<Member> list(Pager pager);

	void add(Member item);

	Member item(String id);

	void update(Member item);

	void delete(String id);

	Long total(Pager pager);

	Member login(Member item);

}
