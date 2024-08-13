package net.lhwcloud.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class) // 메서드별 테스트용 JUnit4
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 파일
@Log4j2
public class MemberMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	
	@Test
	public void insertMemberTests() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("qwe");
		memberVO.setPw("12345");
		memberVO.setName("재조건");
		mapper.insertMember(memberVO);
	}
	
	@Test
	public void selectMemberTests() {
		MemberVO memberVO = mapper.readMember("asd3");
		log.info(memberVO);
	}
	
	@Test
	public void updateMemberTests() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("asd3");
		memberVO.setPw("1234");
		memberVO.setName("건조기");
		
		int count = mapper.updateMember(memberVO);
		log.info("수정 : " + count);
	}
	
	@Test
	public void deleteMemberTests() {
		log.info("몇개를 지웠나 : " + mapper.deleteMember("asd6"));
	}

}
