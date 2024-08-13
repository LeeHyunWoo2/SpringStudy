package net.lhwcloud.mapper;

import java.util.List;

import net.lhwcloud.domain.BoardVO;
import net.lhwcloud.domain.Paging;

public interface BoardMapper {
	// mybatis 매퍼는 그냥 인터페이스로 만들어야 제대로 작동하도록 만들어짐
	// 이쪽 인터페이스는 DB와 상호작용하는 역할을 함. 서비스는 비즈니스 로직담당

	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);

	public BoardVO read(long bno);

	public int update(BoardVO boardVO);

	public int delete(long bno);

	public List<BoardVO> getlListWithPaging(Paging pge);

	public int getTotalCount(Paging pge);

}
