package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class UpdateBoardController
{
	public String handleRequest(BoardVO vo, BoardDAO boardDAO)
	{
		System.out.println("UpdateBoardController -> 글 수정 처리");
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
}
