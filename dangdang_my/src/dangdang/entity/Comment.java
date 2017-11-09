package dangdang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;                      
	private User user;
	private Product product;
	private String commentTitle;
	private String commentContent;
	private Long commentTime;
	private Set commentReplies = new HashSet(0);
	private String publishnyr;
	private static SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(User user, Product product, String commentTitle,
			String commentContent, Long commentTime) {
		this.user = user;
		this.product = product;
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}

	/** full constructor */
	public Comment(User user, Product product, String commentTitle,
			String commentContent, Long commentTime, Set commentReplies) {
		this.user = user;
		this.product = product;
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentReplies = commentReplies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCommentTitle() {
		return this.commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Long getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Long commentTime) {
		this.commentTime = commentTime;
	}

	public Set getCommentReplies() {
		return this.commentReplies;
	}

	public void setCommentReplies(Set commentReplies) {
		this.commentReplies = commentReplies;
	}
	public String getPublishnyr() {
		Date date = new Date(this.getCommentTime());
		String s = f.format(date);
		return s;
	}
	public void setPublishnyr(String publishnyr) {
		this.publishnyr = publishnyr;
	}
}