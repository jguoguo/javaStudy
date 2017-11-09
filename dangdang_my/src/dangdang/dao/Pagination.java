package dangdang.dao;
/**
 * 分页实体
 * @author soft01
 *
 */
public class Pagination {
	private int page = 1;
	private int pageSize = 4;
	private int prePage = 1;
	private int nextPage = 2;
	private int lastPage = Integer.MAX_VALUE;
	
	private int startRow = 1;
	private int endRow = startRow + pageSize;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page<1) page=1;
		this.page = page;
		prePage = page==1?1:page-1;
		nextPage = page>=lastPage?lastPage:page+1;
		startRow = (page-1) * pageSize + 1;
		endRow = startRow + pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize<3) pageSize=3;
		this.pageSize = pageSize;
		this.setPage(this.page);
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		if(lastPage<1) lastPage=1;
		this.lastPage = lastPage;
		this.setPage(this.page);
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	//	@Override
	//	public String toString() {
	//		int start = ((page-1) / 10) * 10 + 1;
	//		
	//	}
}	
