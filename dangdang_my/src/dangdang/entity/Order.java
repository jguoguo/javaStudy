package dangdang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;//2
	private Integer status = 0;
	private Long orderTime;//2
	private String orderDesc = "";
	private Double totalPrice;//2
	private Double sendFee;//2
	private Integer sendId;//1
	private Double orderPrice;//1
	private Long sendTime;//2
	private Boolean isDelete = false;
	private Integer receiveId;//
	private String receiveName;//1
	private String fullAddress;//1
	private String postalCode;//1
	private String mobile;//1
	private String phone;//1
	private Set items = new HashSet(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Integer userId, Integer status, Long orderTime,
			Double totalPrice, Double sendFee, Double orderPrice,
			Integer receiveId) {
		this.userId = userId;
		this.status = status;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.sendFee = sendFee;
		this.orderPrice = orderPrice;
		this.receiveId = receiveId;
	}

	/** full constructor */
	public Order(Integer userId, Integer status, Long orderTime,
			String orderDesc, Double totalPrice, Double sendFee,
			Integer sendId, Double orderPrice, Long sendTime, Boolean isDelete,
			Integer receiveId, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone, Set items) {
		this.userId = userId;
		this.status = status;
		this.orderTime = orderTime;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
		this.sendFee = sendFee;
		this.sendId = sendId;
		this.orderPrice = orderPrice;
		this.sendTime = sendTime;
		this.isDelete = isDelete;
		this.receiveId = receiveId;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.items = items;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderDesc() {
		return this.orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getSendFee() {
		return this.sendFee;
	}

	public void setSendFee(Double sendFee) {
		this.sendFee = sendFee;
	}

	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Long getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public String getReceiveName() {
		return this.receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}