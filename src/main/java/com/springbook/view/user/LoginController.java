package com.springbook.view.user;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController
{
	public String handleRequest(UserVO vo, UserDAO userDAO)
	{
		System.out.println("LoginController -> �α���ó��");
		
		if(userDAO.getUser(vo)!=null)
		{
			return "getBoardList.do";
		}
		else
		{
			return "login.jsp";
		}
	}
}
