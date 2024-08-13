package net.lhwcloud.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.BoardVO;
import net.lhwcloud.domain.Paging;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드별 테스트용 JUnit4
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 파일
@Log4j2

public class BoardMapperTests { // 테스트용 클래스

	@Setter(onMethod_ = @Autowired) // 생성자 자동 주입
	private BoardMapper mapper;

	@Test // 메서드별로 테스트
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void insert() {
		BoardVO boardVO = new BoardVO(); // 빈 객체 생성
		boardVO.setTitle("ㅐㅁ퍼로 만든 제목");
		boardVO.setContent("매퍼로 만든 내용");
		boardVO.setWriter("매퍼 사용자"); // 객체에 내용 삽입 완료

		mapper.insert(boardVO); // 객체간다잇
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("번호생성먼저제목");
		boardVO.setContent("번호생성먼저내용");
		boardVO.setWriter("번호생성먼저매퍼사용자");
		mapper.insertSelectKey(boardVO);
	}

	@Test
	public void testRead() {
		BoardVO boardVO = mapper.read(5L);
		log.info(boardVO);
	}

	@Test
	public void testUpdate() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(5L); // 찾을 번호
		boardVO.setTitle("수정한 제목");
		boardVO.setContent("수정한 내용");
		boardVO.setWriter("김수정");

		int count = mapper.update(boardVO);
		log.info("수정된 갯수 : " + count);
	}

	@Test
	public void testDelete() {
		log.info("삭제한 갯수 : " + mapper.delete(3));
	}

	@Test
	public void testPaging() {
		Paging pge = new Paging();
		pge.setPageNum(3);
		pge.setAmount(10);
		List<BoardVO> list = mapper.getlListWithPaging(pge);
		list.forEach(board -> log.info(board));
	}

	@Test
	public void testSerch() {
		Paging pge = new Paging();
		pge.setKeyword("테");
		pge.setType("TC");
		List<BoardVO> list = mapper.getlListWithPaging(pge);
		list.forEach(board -> log.info(board));
	}

}