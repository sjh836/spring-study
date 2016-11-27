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
		System.out.println("BoardController ��ü ����");
	}
	//�� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException
	{
		System.out.println("BoardControlle -> �� ��� ó��");
		
		MultipartFile uploadFile=vo.getUploadFile();
		if(!uploadFile.isEmpty())
		{
			String fileName=uploadFile.getOriginalFilename(); //�����̸� ����
			uploadFile.transferTo(new File("D:/web upload/"+fileName)); //������ �ö󰡴°�
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board")BoardVO vo)
	{
		System.out.println("BoardController -> �� ���� ó��");
		
		System.out.println("�۹�ȣ: "+vo.getSeq());
		System.out.println("������: "+vo.getTitle());
		System.out.println("�ۼ���: "+vo.getWriter());
		System.out.println("����: "+vo.getContent());
		System.out.println("�����: "+vo.getRegDate());
		System.out.println("��ȸ��: "+vo.getCnt());
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo)
	{
		System.out.println("BoardController -> �� ���� ó��");
		
		boardService.deleteBoard(vo);

		return "getBoardList.do";
	}
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model)
	{
		System.out.println("BoardController -> �� �� ��ȸ ó��");
		
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchCondition() //�̺κ� �� ���ؾȰ���
	{
		Map<String, String> conditionMap=new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	//�� ��� ��ȸ
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model)
	{
		System.out.println("BoardListController -> �� ��� �˻�ó��");
		
		//�˻����ǰ� Ű���尡 ���޾ȵɶ��� ����Ʈ���� �־���� �Ѵ�. �̿ܿ��� command��ü�� ���༭ ������
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); //Model���� ����

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
