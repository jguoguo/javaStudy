package dangdang.service;

import java.util.List;

import dangdang.dao.Pagination;
import dangdang.entity.Comment;
import dangdang.entity.CommentReply;
import dangdang.entity.Product;


public interface CommentService {
	public void savecomment(Comment c);
	public Product findproduct(int id);
	public Comment findComment(int id);
	public void savecommentreply(CommentReply cr);
	public List<CommentReply> findCommentreply();
	public int findLastPageByCategory(int cid, Pagination p);
	public List<Comment> findComment(int cid, Pagination p);
}
