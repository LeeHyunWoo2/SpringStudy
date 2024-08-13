package net.lhwcloud.service;

import java.util.List;

import net.lhwcloud.domain.BoardVO;
import net.lhwcloud.domain.Paging;

public interface BoardService {
	// 이 또한 매퍼, 비즈니스 로직을 담당.
	// 사실 BoardMapper 파일의 메서드 하나로 비즈니스로직, DB로직 둘다 가능하지만
	// 이러면 나중에 유지보수에서 문제가 발생하기 쉽고 작업효율이 매우 안좋아지기 때문에 역할 1개만 하게 지정하는것

	public void register(BoardVO board);

	public BoardVO get(long bno);

	public boolean modify(BoardVO board);

	public boolean remove(long bno);

	// public List<BoardVO>getList();
	public List<BoardVO> getList(Paging pge);

	public int getTotal(Paging pge);
}
