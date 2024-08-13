package net.lhwcloud.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;  // 제목
	
	@DateTimeFormat(pattern = "yyyy/MM/dd") // @initBinder 안씀
	private Date dueDate;     // 적용시간
	private boolean check; // 성공여부

}
