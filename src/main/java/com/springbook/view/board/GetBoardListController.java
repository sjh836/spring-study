package com.springbook.view.board;

import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController
{
	public ModelAndView handleRequest(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
	{
		System.out.println("GetBoardListController -> �� ��� �˻�ó��");
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //Model���� ����
		mav.setViewName("getBoardList.jsp"); //View ���� ����
		
		return mav;
	}
}
