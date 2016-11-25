package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice
{
	public void exceptionLog(JoinPoint jp, Exception exceptObj)
	{
		String method=jp.getSignature().getName();
		
		if(exceptObj==null)
			System.out.println("널값이다. 에러객체 안만든듯.");
		else
			System.out.println("[예외처리] "+method+"() 메소드 수행 중 발생된 예외메세지: "+exceptObj.getMessage());
	}
}
