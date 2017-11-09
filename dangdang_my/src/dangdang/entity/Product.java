package dangdang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String productName;
	private String description;
	private Long addTime;
	private Double fixedPrice;
	private Double dangPrice;
	private String keywords;
	private Integer hasDeleted;
	private String productPic;
	private Set comments = new HashSet(0);
	private Set books = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Category category, String productName, Double fixedPrice,
			Double dangPrice, Integer hasDeleted) {
		this.category = category;
		this.productName = productName;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.hasDeleted = hasDeleted;
	}

	/** full constructor */
	public Product(Category category, String productName, String description,
			Long addTime, Double fixedPrice, Double dangPrice, String keywords,
			Integer hasDeleted, String productPic, Set comments, Set books) {
		this.category = category;
		this.productName = productName;
		this.description = description;
		this.addTime = addTime;
		this.fixedPrice = fixedPrice;
		this.dangPrice = dangPrice;
		this.keywords = keywords;
		this.hasDeleted = hasDeleted;
		this.productPic = productPic;
		this.comments = comments;
		this.books = books;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	public Double getFixedPrice() {
		return this.fixedPrice;
	}

	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public Double getDangPrice() {
		return this.dangPrice;
	}

	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getHasDeleted() {
		return this.hasDeleted;
	}

	public void setHasDeleted(Integer hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public String getProductPic() {
		return this.productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}