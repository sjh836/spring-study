package com.springbook.view.board;

import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController
{
	public ModelAndView handleRequest(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
	{
		System.out.println("GetBoardListController -> 글 목록 검색처리");
		
		mav.addObject("boardList", boardDAO.getBoardList(vo)); //Model정보 저장
		mav.setViewName("getBoardList.jsp"); //View 정보 저장
		
		return mav;
	}
}
