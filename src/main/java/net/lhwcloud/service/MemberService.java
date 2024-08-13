package net.lhwcloud.service;

import net.lhwcloud.domain.MemberVO;

public interface MemberService {
	
	public void registerMember(MemberVO member);
	public MemberVO getMember(String id);
	public boolean modifyMember(MemberVO member);
	public boolean removeMember(String id);

}
