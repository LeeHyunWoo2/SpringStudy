package net.lhwcloud.mapper;

import net.lhwcloud.domain.MemberVO;

public interface MemberMapper {

	public void insertMember(MemberVO member);

	public MemberVO readMember(String id);

	public int updateMember(MemberVO member);

	public int deleteMember(String id);

}
