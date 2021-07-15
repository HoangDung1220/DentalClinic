package DTO;

import java.util.List;

public class Paging {
	private int totalItem;
	private int totalPage;
	private int limit;
	private int page;
	private List<Staff> listStaff;

	public Paging() {
		super();
	}

	public Paging(int totalItem, int totalPage, int limit, int page) {
		super();
		this.totalItem = totalItem;
		this.totalPage = totalPage;
		this.limit = limit;
		this.page = page;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	

}
