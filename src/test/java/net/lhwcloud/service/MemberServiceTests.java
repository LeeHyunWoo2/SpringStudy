package net.lhwcloud.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MemberServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberService service;
	
	@Test
	public void checkTest() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void registerMemberTest() {
		MemberVO member = new MemberVO();
		member.setId("zxcv");
		member.setPw("321");
		member.setName("으엉");
		service.registerMember(member);
		log.info("가입한놈 이름 : " + member.getName());
	}
	
	@Test
	public void getMemberTest() {
		log.info(service.getMember("zxcv"));
	}
	@Test
	public void modifyMemberTest() {
		MemberVO member = new MemberVO();
		member = service.getMember("zxcv");
		if(member == null) {
			log.info("그런건 없음");
			return;
		}
		member.setPw("123");
		member.setName("느엉");
		log.info("수정된 아이디" + service.modifyMember(member));
	}
	@Test
	public void removeMemberTest() {
		log.info("지워진놈 : " + service.removeMember("zxcv"));
	}
}
