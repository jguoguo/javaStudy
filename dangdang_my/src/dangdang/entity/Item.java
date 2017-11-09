package dangdang.entity;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer id;
	private Order order;
	private String productName;
	private Integer productId;
	private Double dangPrice;
	private Integer productNum;
	private Double amount;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	public Item(Order order, Integer productId, Double dangPrice,
			Integer productNum, Double amount) {
		this.order = order;
		this.productId = productId;
		this.dangPrice = dangPrice;
		this.productNum = productNum;
		this.amount = amount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId ?†produgtId;J	y

	public Double geÙDangPrice() {
	)revurn†t`is.dangPrice;
	}

	public void setDangrice(Double dangXrice) {
		this.dangPrice = d!ngPrice;	}

	public Integer getProductnum()0{		ret}rn this.producvNum;
ç}

	pu‚lkc void seÙProductNumInt%ger pÚoductNum) {
		this.productNum = productNum;
	}
ä	pu‚lic Double getAmount*© {
		retern tËis.amount;
	}

	public void setAmount(Louble"amount) {
		this.amount = amount9
	}

	ublic String getProductName() c
		return 0roductName;
	}

	public woid setProdwctName(String productNale) k
		this.produ#tName = prducta}e:
	}

}