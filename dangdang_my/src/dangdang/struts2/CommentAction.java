package dangdang.struts2;




import java.util.List;

import dangdang.dao.Pagination;
import dangdang.entity.Book;
import dangdang.entity.Comment;
import dangdang.entity.CommentReply;
import dangdang.entity.Product;
import dangdang.entity.User;

public class CommentAction extends BaseAction {
	private Comment comment = new Comment();
	private int cid;
	private List<Comment> commentlist;
	private int n;
	private User user;
	private CommentReply commentreply;
	private int comment_id;
	private Pagination p = new Pagination();
	private Book book;
	/**
	 * 添加回复
	 * @return
	 */
	public String commentreply(){
		try{
			user = (User)sessionMap.get(Constant.DANGDANG_LOGIN_USER);
			user = userService.findById(user.getId());
		commentreply.setUser(user);
		long replyTime = System.currentTimeMillis();
		commentreply.setReplyTime(replyTime);
		comment = commentService.findComment(comment_id);
		commentreply.setComment(comment);
		commentreply.setTurn(1);
		commentService.savecommentreply(commentreply);
		commentread();
		book = shoppingService.findbook(cid);
		return SUCCESS;
		}catch(Exception e){
			System.out.println("reply--faild");
			return "faild";
		}
		
	}

	/**
	 * 分页显示评论
	 * @return
	 */
	public String commentread(){
		try{
		user = (User)sessionMap.get(Constant.DANGDANG_LOGIN_USER);
		p.setLastPage(commentService.findLastPageByCategory(cid, p));
		
		commentlist = commentService.findComment(cid, p);
		System.out.println(commentlist.size());
		n = commentlist.size();
		
		return SUCCESS;
		}catch(Exception e){
			System.out.println("reply--faild");
			return "faild";
		}
	}
	/**
	 * 将评论写入数据库中
	 * @return
	 */
	public String commentwrite(){
		System.out.println("进入commentwrite");
		long time = System.currentTimeMillis();
		comment.setCommentTime(time);
		try{
		User u = (User)sessionMap.get("dangdang_login_user");
		comment.setUser(u);
		Product p = commentService.findproduct(cid);
		comment.setProduct(p);
		commentService.savecomment(comment);
		commentread();
		book = shoppingService.findbook(cid);
		return SUCCESS;
		}catch(Exception e){
			return "faild";
			}
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CommentReply getCommentreply() {
		return commentreply;
	}
	public void setCommentreply(CommentReply commentreply) {
		this.commentreply = commentreply;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int commentId) {
		comment_id = commentId;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public Pagination getP() {
		return p;
	}

	public void setP(Pagination p) {
		this.p = p;
	}
	
}
