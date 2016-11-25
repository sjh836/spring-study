package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController
{
	public String handleRequest(BoardVO vo, BoardDAO boardDAO)
	{
		System.out.println("InsertBoardControlle -> 글 등록 처리");
		
		/*
		//1. 사용자 입력 정보 추출
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//2. DB 연동 처리
		BoardVO vo=new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		//3. 화면 네비게이션
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		*/
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

}
