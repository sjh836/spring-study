package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice
{
	//@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	//public void allPointcut(){}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable
	{
		String method=pjp.getSignature().getName();
		
		System.out.println("[before] 비즈니스 메소드 수행전에 처리할 내용");
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		
		Object Obj=pjp.proceed();
		
		stopWatch.stop();
		
		System.out.println("[after] "+method+"() 수행에 걸린시간: "+stopWatch.getTotalTimeMillis()+"(ms)초");
		
		return Obj;
	}
}
