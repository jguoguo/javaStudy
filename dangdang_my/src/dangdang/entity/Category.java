package dangdang.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category parent;
	private Integer turn;
	private String enName;
	private String cnName;
	private String categoryValue;
	private Set<Product> products = new HashSet(0);
	private List<Category> subCategorys = new ArrayList(0);
	
	
	
	public Category() {
	}
	public Category(Integer id, Category parent, Integer turn, String enName,
			String cnName, String categoryValue, Set<Product> products,
			List<Category> subCategorys) {
		this.id = id;
		this.parent = parent;
		this.turn = turn;
		this.enName = enName;
		this.cnName = cnName;
		this.categoryValue = categoryValue;
		this.products = products;
		this.subCategorys = subCategorys;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public Integer getTurn() {
		return turn;
	}
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public List<Category> getSubCategorys() {
		return subCategorys;
	}
	public void setSubCategorys(List<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}
	
	
}