package dangdang.struts2;


import java.util.List;
import java.util.Set;

import dangdang.dao.BookOrder;
import dangdang.dao.Pagination;
import dangdang.entity.Book;
import dangdang.entity.Cart;
import dangdang.entity.Category;

public class ShoppingAction extends BaseAction {
	private List<Category> categoryList;// 2级分类列表<当代小说>
	private List<Category> categoryListP;// 图书下的分类<小说>
	private String pname;// 父级名称 <小说>
	private int pid;// <小说>
	private int cid;// <当代小说>
	private Pagination p = new Pagination();
	private BookOrder order = new BookOrder("dangPrice","dangPrice|false");
	private List<Book> bookList;// 3级列表，属于<当代小说>中的书籍
	private Cart cart = new Cart();//购物车
	private List<Book> cartbook;
	private int num = 0;//改变物品的数量
	private List<Book> deletebook;
	
	private double amount;
	private Book book;
	
	
	/**
	 * 商品的详细信息
	 * @return
	 */
	public String bookDetail(){
		
		book = shoppingService.findbook(cid);
		return SUCCESS;
	}
	
	
	/**
	 * 点击“恢复”
	 * @return
	 */
	
	public String clickRestore(){
		cart=(Cart)sessionMap.get("cart");
		
		
		cart.getBooks().put(cid, cart.getRemoved().get(cid));
		Set<Integer> bs =cart.getBooks().keySet();
		cartbook = shoppingService.findByIds(bs);
		
		cart.getRemoved().remove(cid);
		
		
		Set<Integer> ids =cart.getRemoved().keySet();
		deletebook = shoppingService.findByIds(ids);
		
		sessionMap.put("cart", cart);
		
		return SUCCESS;
	}
	
	
	/**
	 *  改变购物车(变更或删除)
	 * @return
	 */
	public String ChangeCart(){
		cart=(Cart)sessionMap.get("cart");
		
		
		if(num==0){
			
			
			cart.getRemoved().put(cid, cart.getBooks().get(cid));
			
			cart.getBooks().remove(cid);
			
				Set<Integer> bs =cart.getBooks().keySet();
				cartbook = shoppingService.findByIds(bs);
			
			Set<Integer> ids =cart.getRemoved().keySet();
			deletebook = shoppingService.findByIds(ids);
			
			
		}else{
		System.out.println("进入ChangeCart");
		System.out.println(cid+":"+num);
		cart.getBooks().put(cid, num);
		Set<Integer> ids =cart.getBooks().keySet();
		cartbook = shoppingService.findByIds(ids);
		System.out.println("改变后购物车里的物品："+cart.getBooks());
		System.out.println("改变了了了");
		
		}
		
		sessionMap.put("cart", cart);
		
		return SUCCESS;
	}
	
	/**
	 * 购物车列表
	 * @return
	 */
	public String CartList(){
		System.out.println("CartList  inter");
		cart=(Cart)sessionMap.get("cart");
		
		
		System.out.println("获得购物车");
		Set<Integer> ids =cart.getBooks().keySet();
		System.out.println("得到购物车里book的id");
		cartbook = shoppingService.findByIds(ids);
		System.out.println("获得cartbook========"+cartbook);
		//cart.books[id]
		
		
		return SUCCESS;
	}
	/**
	 * 加入购物车
	 * @return
	 */
   public String AddCart(){
	   System.out.println("cart inter");
	   if(sessionMap.get("cart")==null){
		   System.out.println("cart create");
		   sessionMap.put("cart", cart);
	   }
	   System.out.println("add cart");
	   
	   cart=(Cart)sessionMap.get("cart");
	   if(cart.getBooks().containsKey(cid)){
		   cart.getBooks().put(cid, cart.getBooks().get(cid)+1);
		   System.out.println(cid+"已存在");
	   }else{
		   cart.getBooks().put(cid, 1);
		   System.out.println(cid+"不存在");
	   }
	   sessionMap.put("cart", cart);
	   System.out.println("***"+cart.getBooks());
	   return SUCCESS;
   }
	/**
	 * 分页排序
	 * @return
	 */
	public String PageList() {
		
           p.setLastPage(shoppingService.findLastPageByCategory(cid, p));
			bookList = shoppingService.findBookCategory(cid, p, order);
		return SUCCESS;
	}

	/**
	 * 图书所有分类
	 * @return
	 */
	public String categoryParent() {
		categoryListP = shoppingService.findByP(1);
		if (categoryListP != null) {

			return SUCCESS;
		} else {
			return "faild";
		}
	}

	/**
	 * 2级分类
	 * @return
	 */
	public String categorySub() {

		categoryList = shoppingService.findByP(pid);

		Category cp = shoppingService.findById(pid);
		pname = cp.getCnName();
		return SUCCESS;
	}

	
	
	
	public List<Book> getCartbook() {
		return cartbook;
	}
	public void setCartbook(List<Book> cartbook) {
		this.cartbook = cartbook;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public BookOrder getOrder() {
		return order;
	}

	public void setOrder(BookOrder order) {
		this.order = order;
	}

	public List<Book> getBookList() {

		return bookList;

	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Pagination getP() {
		return p;
	}

	public void setP(Pagination p) {
		this.p = p;
	}

	public List<Category> getCategoryListP() {
		return categoryListP;
	}

	public void setCategoryListP(List<Category> categoryListP) {
		this.categoryListP = categoryListP;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}



	public List<Book> getDeletebook() {
		return deletebook;
	}

	public void setDeletebook(List<Book> deletebook) {
		this.deletebook = deletebook;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	

	

	

	
	
}
