package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController
{
	@Resource(name="boardService")
	private BoardService boardService;
	
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo)
	{
		System.out.println("BoardControlle -> 글 등록 처리");
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo)
	{
		System.out.println("BoardController -> 글 수정 처리");
		
		System.out.println("글번호: "+vo.getSeq());
		System.out.println("글제목: "+vo.getTitle());
		System.out.println("작성자: "+vo.getWriter());
		System.out.println("내용: "+vo.getContent());
		System.out.println("등록일: "+vo.getRegDate());
		System.out.println("조회수: "+vo.getCnt());
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo)
	{
		System.out.println("BoardController -> 글 수정 처리");
		
		boardService.deleteBoard(vo);

		return "getBoardList.do";
	}
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)
	{
		System.out.println("BoardController -> 글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchCondition() //이부분 잘 이해안간다
	{
		Map<String, String> conditionMap=new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	//글 목록 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model)
	{
		System.out.println("BoardListController -> 글 목록 검색처리");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //Model정보 저장

		return "getBoardList.jsp";
	}
}
