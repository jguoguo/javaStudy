package dangdang.dao.impl;


import java.util.List;

import org.springframework.dao.support.DataAccessUtils;

import dangdang.entity.Category;
import dangdang.entity.User;

public class CategoryDaoImpl 
          extends BaseDaoImpl<Category>
          implements dangdang.dao.CategoryDao {

	@Override
	public List<Category> findByParent(int parentId) {
		
		List list = hibernateTemplate.find(
				"from Category c where c.parent.id=?",
				new Object[] {parentId});
		System.out.println("按parent查询得："+list.size());
		return list;
	}

	
}
