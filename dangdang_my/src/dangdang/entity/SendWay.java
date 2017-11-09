package dangdang.entity;

/**
 * SendWay entity. @author MyEclipse Persistence Tools
 */

public class SendWay implements java.io.Serializable {

	// Fields

	private Integer id;
	private Boolean isClose;
	private String sendWay;
	private String sendDesc;
	private Double sendFee;

	// Constructors

	/** default constructor */
	public SendWay() {
	}

	/** minimal constructor */
	public SendWay(String sendWay, Double sendFee) {
		this.sendWay = sendWay;
		this.sendFee = sendFee;
	}

	/** full constructor */
	public SendWay(Boolean isClose, String sendWay, String sendDesc,
			Double sendFee) {
		this.isClose = isClose;
		this.sendWay = sendWay;
		this.sendDesc = sendDesc;
		this.sendFee = sendFee;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsClose() {
		return this.isClose;
	}

	public void setIsClose(Boolean isClose) {
		this.isClose = isClose;
	}

	public String getSendWay() {
		return this.sendWay;
	}

	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}

	public String getSendDesc() {
		return this.sendDesc;
	}

	public void setSendDesc(String sendDesc) {
		this.sendDesc = sendDesc;
	}

	public Double getSendFee() {
		return this.sendFee;
	}

	public void setSendFee(Double sendFee) {
		this.sendFee = sendFee;
	}

}