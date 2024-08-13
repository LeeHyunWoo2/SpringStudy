package net.lhwcloud.domain;

import lombok.Data;

@Data // toString 게터 세터 이퀄스 생성자 등등 자동생성
public class ExamDTO {

	private String name;
	private int age;
}
