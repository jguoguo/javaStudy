package dangdang.entity;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String receiveName;
	private String fullAddress;
	private String postalCode;
	private String mobile;
	private String phone;
	private Integer isDefault;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(User user, String receiveName, String fullAddress,
			String postalCode, String mobile) {
		this.user = user;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
	}

	/** full constructor */
	public Address(User user, String receiveName, String fullAddress,
			String postalCode, String mobile, String phone, Integer isDefault) {
		this.user = user;
		this.receiveName = receiveName;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.mobile = mobile;
		this.phone = phone;
		this.isDefault = isDefault;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

}