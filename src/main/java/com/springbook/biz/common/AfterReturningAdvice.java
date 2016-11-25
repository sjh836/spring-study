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
			if(user.getRole().equals("������"))
				System.out.println(user.getName()+" �α���");
		}
		if(returnObj==null)
		{
			System.out.println("[����ó��] �ΰ��̴�. ��ȯ���ѵ�");
		}
		else
			System.out.println("[����ó��] "+method+"() �޼ҵ� ���ϰ�: "+returnObj.toString());
	}
}
