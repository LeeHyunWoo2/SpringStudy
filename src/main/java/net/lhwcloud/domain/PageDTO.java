package net.lhwcloud.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;
	private Paging pge;

	public PageDTO(Paging pge, int total) {
		this.total = total;
		this.pge = pge;

		this.endPage = (int) (Math.ceil(pge.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;

		int realEnd = (int) (Math.ceil(total * 1.0) / pge.getAmount());

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

}
