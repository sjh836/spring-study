package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	public BoardController()
	{
		System.out.println("BoardController 객체 생성");
	}
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException
	{
		System.out.println("BoardControlle -> 글 등록 처리");
		
		MultipartFile uploadFile=vo.getUploadFile();
		if(!uploadFile.isEmpty())
		{
			String fileName=uploadFile.getOriginalFilename(); //파일이름 추출
			uploadFile.transferTo(new File("D:/web upload/"+fileName)); //파일이 올라가는곳
		}
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
		
		//검색조건과 키워드가 전달안될때는 디폴트값을 넣어줘야 한다. 이외에는 command객체가 해줘서 괜찮다
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //Model정보 저장

		return "getBoardList.jsp";
	}
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo)
	{
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList=boardService.getBoardList(vo);
		return boardList;
	}
}
