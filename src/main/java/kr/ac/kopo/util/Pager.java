package kr.ac.kopo.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 10;
	private double total;
	private int perGroup = 5;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getPerGroup() {
		return perGroup;
	}

	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	
	// 이하 연산을 통해 얻는 값 -> 필드가 필요 없음
	public int getLast() {
		return (int) Math.ceil(total / perPage);
	}
	
	//그룹: 그룹 단위로 이동 / 페이지: 이전 그룹의 첫 번째 페이지로 이동
	// page - 1: 나누어 떨어지는 결과 방지
	// (연산값) - 1: 이전 그룹으로 이동
	public int getPrev() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
	}
	
	//다음이 마지막 페이지보다 클 경우 last
	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		
		int last = getLast();
		
		return next < last ? next : last;
	}
	
	//현재 그룹의 list 반환, 현재 페이지가 마지막 페이지보다 적을 경우도 고려
	public List<Integer> getList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int startPage = (((page - 1) / perGroup)) * perGroup + 1;
		
		for(int index=startPage; index < (startPage + perGroup) && index <= getLast(); index++) {
			list.add(index);
		}
		
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}
}
