package net.lhwcloud.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.lhwcloud.domain.MemberVO;
import net.lhwcloud.mapper.MemberMapper;

@Service // 스프링에 서비스를 담당한다라는 코드 (비즈니스 로직 영역을 담당)
@Log4j2 // 로그 출력용
@AllArgsConstructor // 모든 매개값을 이용해서 자동으로 생성자 만듦
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;

	@Override
	public void registerMember(MemberVO member) {
		log.info("registerMember");
		mapper.insertMember(member);
	}

	@Override
	public MemberVO getMember(String id) {
		log.info("getMember");
		return mapper.readMember(id);
	}

	@Override
	public boolean modifyMember(MemberVO member) {
		log.info("modifyMember");
		return mapper.updateMember(member) == 1;
	}

	@Override
	public boolean removeMember(String id) {
		log.info("removeMember");
		mapper.deleteMember(id);
		return mapper.deleteMember(id) == 1;
	}

}
