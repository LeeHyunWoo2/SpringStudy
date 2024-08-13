package net.lhwcloud.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	// db에 있는 tbl_board 의 객체를 구성한것
	
	private long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

}
