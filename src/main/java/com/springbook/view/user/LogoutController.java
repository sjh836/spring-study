package com.springbook.view.user;

import javax.servlet.http.HttpSession;

public class LogoutController
{
	public String handleRequest(HttpSession session) throws Exception {
		System.out.println("LogoutController -> �α׾ƿ�ó��");
		
		//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();

		//2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		return "login.jsp";
	}

}
