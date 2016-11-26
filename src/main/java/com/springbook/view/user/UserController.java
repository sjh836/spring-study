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
		System.out.println("UserController 객체 생성");
	}
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO, HttpSession session)
	{
		System.out.println("UserController -> 로그인처리");
		
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
		System.out.println("UserController -> 로그아웃처리");
		
		//1. 브라우저와 연결된 세션 객체를 강제 종료한다.
		session.invalidate();

		//2. 세션 종료 후, 메인 화면으로 이동한다.
		return "login.jsp";
	}
}
