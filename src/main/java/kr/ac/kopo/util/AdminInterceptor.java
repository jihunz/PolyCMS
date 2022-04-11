package kr.ac.kopo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.model.Member;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		if(member != null && member.getGrade() > 99) {
			//인터셉터에서 true이기 떄문에 컨트롤러로 이동
			return true;	
		}
		
		//false 이전에 일반 사용자가 로그인 시 index로 이동
		if(member != null) {
			response.sendRedirect("/");
		//로그인이 필요한 페이지 접근 시 요청 목적지의 URI, 쿼리스트링을 저장 -> 로그인 페이지로 sendRedirect
		} else {
			String query  = request.getQueryString();
			session.setAttribute("target", request.getRequestURI() + (query != null ? "?" + query : ""));
			response.sendRedirect("/login");
		}
		return false;
	}
}
