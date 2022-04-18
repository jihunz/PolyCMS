package kr.ac.kopo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import kr.ac.kopo.model.Member;

@Aspect
@Component
public class LogAspect {
	
	// login() 실행 후 반환 시 실행됨
	// pointcut: 적용된 메서드의 어노테이션 이름
	// args: 파라미터의 이름
	// returnings: 반환 데이터 이름
	@AfterReturning(pointcut = "@annotation(PointcutLogin) && args(member)", returning = "result")
	public void LogLogin(JoinPoint joinPoint, Member member, boolean result) {
		System.out.println("LOGIN: " + member.getId() + " -> " + result);
	}
}
