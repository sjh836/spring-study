package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class UserController
{
	public UserController()
	{
		System.out.println("UserController ��ü ����");
	}
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session)
	{
		System.out.println("UserController -> �α���ó��");
		
		UserVO user=userDAO.getUser(vo);
		if(userDAO.getUser(vo)!=null)
		{
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else
		{
			return "login.jsp";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		System.out.println("UserController -> �α׾ƿ�ó��");
		
		//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();

		//2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		return "login.jsp";
	}
}
