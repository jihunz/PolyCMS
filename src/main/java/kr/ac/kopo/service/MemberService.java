package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;

public interface MemberService {

	List<Member> list(Pager pager);

	void add(Member item);

	Member item(String id);

	void update(Member item);

	void delete(String id);

	boolean login(Member item);

}
