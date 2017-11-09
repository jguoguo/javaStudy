package dangdang.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CommentReply entity. @author MyEclipse Persistence Tools
 */

public class CommentReply implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Comment comment;
	private Long replyTime;
	private String replyContent;
	private Integer turn;
	private String publishnyr;
	private static SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
	// Constructors

	/** default constructor */
	public CommentReply() {
	}

	/** minimal constructor */
	public CommentReply(User user, Comment comment, String replyContent) {
		this.user = user;
		this.comment = comment;
		this.replyContent = replyContent;
	}

	/** full constructor */
	public CommentReply(User user, Comment comment, Long replyTime,
			String replyContent, Integer turn) {
		this.user = user;
		this.comment = comment;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
		this.turn = turn;
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

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Long getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Long replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getTurn() {
		return this.turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public String getPublishnyr() {
		Date date = new Date(this.getReplyTime());
		String s = f.format(date);
		return s;
	}
	public void setPublishnyr(String publishnyr) {
		this.publishnyr = publishnyr;
	}
}