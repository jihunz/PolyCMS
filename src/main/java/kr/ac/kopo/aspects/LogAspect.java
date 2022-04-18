package kr.ac.kopo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.ac.kopo.model.Article;
import kr.ac.kopo.model.Member;

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	LogService service;
	
	// @AfterReturning: 메서드 실행 후 실행
	// login() 실행 후 반환 시 실행됨
	// pointcut: pointcut이 적용된 메서드의 어노테이션 이름 기술
	// args: 해당 메서드 파라미터의 이름
	// returning: 반환 값 이름
	@AfterReturning(pointcut = "@annotation(PointcutLogin) && args(member)", returning = "result")
	public void LogLogin(JoinPoint joinPoint, Member member, boolean result) {
		System.out.println("LOGIN: " + member.getId() + " -> " + result);
		
		service.login(member, result);
	}
	
	// @Before: 메서드 실행 전에 실행
	// execution: pointcut 지점 간접 지정
	@Before("execution(* kr.ac.kopo.service.ArticleService*.add(..)) && args(item)")
	public void LogArticleAdd(Article item) {
		System.out.println("새로운 글 등록:" + item.getSubject());
	}
}
