package com.springbook.view.user;

import javax.servlet.http.HttpSession;

public class LogoutController
{
	public String handleRequest(HttpSession session) throws Exception {
		System.out.println("LogoutController -> 로그아웃처리");
		
		//1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();

		//2. 세션 종료 후, 메인 화면으로 이동한다.
		return "login.jsp";
	}

}
