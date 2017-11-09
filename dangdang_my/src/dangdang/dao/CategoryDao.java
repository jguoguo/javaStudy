package dangdang.dao;

import java.util.List;

import dangdang.entity.Category;
/**
 * 对图书分类数据库操作的接口。功能如下：
 * <ul>
 * <li>通过父分类的id查找子分类</li>
 * </ul>
 * @author soft01
 *
 */
public interface CategoryDao extends BaseDao<Category>{
	/**
	 * 通过父分类的标识（parent_id）查找所有对应的子分类
	 * @param parent_id
	 * @return
	 */
     List<Category> findByParent(int parent_id);
     
}
