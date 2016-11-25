package com.springbook.view.board;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class DeleteBoardController
{
	public String handleRequest(BoardVO vo, BoardDAO boardDAO)
	{
		boardDAO.deleteBoard(vo);

		return "getBoardList.do";
	}

}
