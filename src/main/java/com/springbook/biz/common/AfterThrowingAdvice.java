package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice
{
	public void exceptionLog(JoinPoint jp, Exception exceptObj)
	{
		String method=jp.getSignature().getName();
		
		if(exceptObj==null)
			System.out.println("�ΰ��̴�. ������ü �ȸ����.");
		else
			System.out.println("[����ó��] "+method+"() �޼ҵ� ���� �� �߻��� ���ܸ޼���: "+exceptObj.getMessage());
	}
}
