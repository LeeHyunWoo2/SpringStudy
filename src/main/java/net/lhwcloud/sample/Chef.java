package net.lhwcloud.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component // 스프링이 객체 관리하게 한다.
@Data // DTO관리를 lombok이 하게 함
// @AllArgsConstructor // 모든 필드값을 활용하는 생성자 만듦

public class Chef {
	
	private String name;
	private int age;
	private Date regDate;

}
