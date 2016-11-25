package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController
{
	public String handleRequest(BoardVO vo, BoardDAO boardDAO)
	{
		System.out.println("InsertBoardControlle -> �� ��� ó��");
		
		/*
		//1. ����� �Է� ���� ����
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		//2. DB ���� ó��
		BoardVO vo=new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		//3. ȭ�� �׺���̼�
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		*/
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

}
