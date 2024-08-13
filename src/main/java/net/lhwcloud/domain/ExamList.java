package net.lhwcloud.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ExamList {
	
	private List<ExamDTO> list;
	
	
	
	public ExamList() {
		list = new ArrayList<>();
	}
	

}
