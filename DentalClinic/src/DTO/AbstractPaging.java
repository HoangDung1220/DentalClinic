package DTO;

import java.util.ArrayList;
import java.util.List;

public class AbstractPaging<T> {

	private List<T> list = new ArrayList<T>();
	private int totalItem;
	private int totalPage;
	private int limit;
	private int page;
	
	
	
	public AbstractPaging() {
		super();
	}



	public AbstractPaging(List<T> list, int totalItem, int totalPage, int limit, int page) {
		super();
		this.list = list;
		this.totalItem = totalItem;
		this.totalPage = totalPage;
		this.limit = limit;
		this.page = page;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
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
