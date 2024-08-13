package net.lhwcloud.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// mybatis는 쿼리문 처리를 xml + interface로 만든다.
	// 인터페이스에서는 호출할 메서드만 기술함
	// xml에는 같은 이름으로 쿼리를 만든다.

	// C 추상 메서드

	// R 추상 메서드
	public String getTimeXml(); // resources/net/lhwcloud/mapper/TimeMapper.xml 의 쿼리를 실행한다.

	// U 추상 메서드

	// D 추상 메서드

	// xml을 꼭 사용하진 않아도 된다.
	// 하지만 쿼리문이 복잡하거나 길어지는 경우엔 xml을 사용하는게 선호됨
	@Select("select sysdate from dual")
	public String getTime();

}