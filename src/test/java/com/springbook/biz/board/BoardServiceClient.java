package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient
{
	public static void main(String[] args)
	{
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService=(BoardService)container.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		vo.setTitle("스프링제목3");
		vo.setWriter("엥겔스");
		vo.setContent("테스트중입니다..");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList)
		{
			System.out.println("---> "+board.toString());
		}
		
		container.close();
	}
}
