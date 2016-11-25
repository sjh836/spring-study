package com.springbook.view.board;

import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController
{
	public ModelAndView handleRequest(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
	{
		System.out.println("GetBoardController -> �� �� ��ȸ ó��");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
