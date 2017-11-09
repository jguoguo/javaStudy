package com.xlj.forum.struts.form;

import com.xlj.forum.bean.Category;

public class CategoryForm extends ForumForm {
	private Category category=new Category();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
