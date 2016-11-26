package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL��ɾ��
	private final String BOARD_INSERT="insert into board(title, writer, content, regdate, filepath) values(?,?,?,now(),?);";
	private final String BOARD_UPDATE="update board set title=?, content=? where seq=?;";
	private final String BOARD_DELETE="delete from board where seq=?;";
	private final String BOARD_GET="select * from board where seq=?;";
	private final String BOARD_LIST_T="select * from board where title like CONCAT('%',?,'%') order by seq desc;";
	private final String BOARD_LIST_C="select * from board where content like CONCAT('%',?,'%') order by seq desc;";
	
	//CRUD���
	//�۵��
	public void insertBoard(BoardVO vo)
	{
		System.out.println("---> Spring JDBC�� insertBoard() ��� ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent(), "D:/web upload/"+vo.getUploadFile().getOriginalFilename());
	}
	
	//�ۼ���
	public void updateBoard(BoardVO vo)
	{
		System.out.println("---> Spring JDBC�� updateBoard() ��� ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	//�ۻ���
	public void deleteBoard(BoardVO vo)
	{
		System.out.println("---> Spring JDBC�� deleteBoard() ��� ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	//�� ����ȸ
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("---> Spring JDBC�� getBoard() ��� ó��");
		Object[] args={vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	//�� �����ȸ
	public List<BoardVO> getBoardList(BoardVO vo)
	{
		System.out.println("---> Spring JDBC�� getBoardList() ��� ó��");
		Object[] args={vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		else if(vo.getSearchCondition().equals("CONTENT")) return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		return null;
	}
}
