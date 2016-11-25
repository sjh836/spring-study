package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice
{
	public void afterLog(JoinPoint jp, Object returnObj)
	{
		String method=jp.getSignature().getName();
		
		if(returnObj instanceof UserVO)
		{
			UserVO user=(UserVO)returnObj;
			if(user.getRole().equals("관리자"))
				System.out.println(user.getName()+" 로그인");
		}
		if(returnObj==null)
		{
			System.out.println("[사후처리] 널값이다. 반환안한듯");
		}
		else
			System.out.println("[사후처리] "+method+"() 메소드 리턴값: "+returnObj.toString());
	}
}
