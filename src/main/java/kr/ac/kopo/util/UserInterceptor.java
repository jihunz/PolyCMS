package kr.ac.kopo.util;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.ac.kopo.model.Member;

public class UserInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		if (member != null) {
			return true;
		}
		
		String query  = request.getQueryString();
				
		session.setAttribute("target", request.getRequestURI() + (query != null ? "?" + query : ""));
		
		response.sendRedirect("/login");
		return false;
	}
}
