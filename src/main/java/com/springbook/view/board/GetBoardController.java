package com.springbook.view.board;

import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController
{
	public ModelAndView handleRequest(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
	{
		System.out.println("GetBoardController -> 글 상세 조회 처리");
		
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
