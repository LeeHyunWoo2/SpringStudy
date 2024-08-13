package net.lhwcloud.mapper;

import java.util.List;

import net.lhwcloud.domain.BoardVO;

public interface BoardMapper {
	// mybatis 매퍼는 그냥 인터페이스로 만들어야 제대로 작동하도록 만들어짐
	// 이쪽 인터페이스는 DB와 상호작용하는 역할을 함. 서비스는 비즈니스 로직담당
	// 그래서 두 파일 열어보면 이게 뭐하는짓이지?? 싶게 생겼는데 사실 각자 역할을 나누느라 똑같아보이는 파일 두개가 생긴것
	
	
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int update(BoardVO boardVO);
	
	public int delete(long bno);
	
}
