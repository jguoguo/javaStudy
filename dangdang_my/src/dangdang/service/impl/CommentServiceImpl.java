package dangdang.service.impl;

import java.util.List;

import dangdang.dao.Pagination;
import dangdang.entity.Comment;
import dangdang.entity.CommentReply;
import dangdang.entity.Product;
import dangdang.service.CommentService;
import dangdang.service.BaseSerivce;


public class CommentServiceImpl 
         extends BaseSerivce 
          implements CommentService {

	@Override
	public void savecomment(Comment c) {
		// TODO Auto-generated method stub
		commentDao.save(c);
	}

	@Override
	public Product findproduct(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(Product.class, id);
	}

	



	@Override
	public Comment findComment(int id) {
		// TODO Auto-generated method stub
		return commentDao.findById(Comment.class, id);
	}

	
	@Override
	public void savecommentreply(CommentReply cr) {
		// TODO Auto-generated method stub
		System.out.println("!!!!!!!!!!!!!!");
		commentreplyDao.save(cr);
	}

	@Override
	public List<CommentReply> findCommentreply() {
		// TODO Auto-generated method stub
		return commentreplyDao.findAll(CommentReply.class);
	}

	@Override
	public int findLastPageByCategory(int cid, Pagination p) {
		// TODO Auto-generated method stub
		return commentDao.findLastPageByComment(cid, p);
	}

	@Override
	public List<Comment> findComment(int cid, Pagination p) {
		// TODO Auto-generated method stub
		return commentDao.findComment(p, cid);
	}

}
