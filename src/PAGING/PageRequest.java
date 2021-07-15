package PAGING;


public class PageRequest implements Pageble{
	private int page;
	private int maxPageItem;
	
	public PageRequest(int page,int maxPageItem) {
		this.page=page;
		this.maxPageItem=maxPageItem;
	}
	

	public int getPage() {
		return this.page;
	}

	public int getOffset() {
	//	if ((Integer) this.page!=null) {
		return (this.page-1)*this.maxPageItem;
	//	}
	//	return null;
	}

	public int getLimit() {
		return this.maxPageItem;
	}


	



}
