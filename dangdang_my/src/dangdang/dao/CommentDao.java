package dangdang.dao;

import java.util.List;

import dangdang.entity.Comment;
/**
 * 对某个商品进行评论的数据库操作的接口。功能如下：
 * <ul>
 * <li>查找某一件商品的所有评论并进行分页</li>
 * <li>得到某一件商品的所有评论并进行分页后的最后一页</li>
 * </ul>
 * @author soft01
 *
 */
public interface CommentDao extends BaseDao<Comment>{
   /**
    * 查找某一件商品的所有评论并进行分页。功能如下：
    * <ul>
    * <li>按照图书的标识查找到所有的评论</li>
    * <li>按照Pagination进行分页</li>
    * </ul>
    * @param p
    * @param cid
    * @return
    */
    List<Comment> findComment(Pagination p,int cid);
    /**
     * 得到某一件商品的所有评论并进行分页后的最后一页
     * <ul>
     * <li>按照图书的标识查找到所有的评论</li>
     *  <li>按照Pagination进行分页</li>
     * </ul>
     * @param cid
     * @param p
     * @return
     */
    int findLastPageByComment(int cid, Pagination p);
}
