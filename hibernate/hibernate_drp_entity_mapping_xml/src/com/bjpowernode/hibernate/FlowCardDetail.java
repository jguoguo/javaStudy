package com.bjpowernode.hibernate;

import java.util.List;

/**
 * ������ϸ��Ϣ
 * @author Administrator
 *
 */
public class FlowCardDetail {

	 //��ʶ
	 private int flowCardDetailId;
	 
	 //��������
	 private double optQty;
	 
	 //����������
	 private double adjustQty;
	 
	 //����ԭ��
	 private String adjustReason;
	 
	 //�������
	 //Y������
	 //N��δ����	 
	 private  String adjustFlag;
	 
	 //�跽�ͻ�
	 private AimClient AimClient;
	 
	 //������Ϣ
	 private Item item;
	 
	 //��������Ϣ
	 private FlowCard flowCard;

	public int getFlowCardDetailId() {
		return flowCardDetailId;
	}

	public void setFlowCardDetailId(int flowCardDetailId) {
		this.flowCardDetailId = flowCardDetailId;
	}

	public double getOptQty() {
		return optQty;
	}

	public void setOptQty(double optQty) {
		this.optQty = optQty;
	}

	public double getAdjustQty() {
		return adjustQty;
	}

	public void setAdjustQty(double adjustQty) {
		this.adjustQty = adjustQty;
	}

	public String getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}

	public String getAdjustFlag() {
		return adjustFlag;
	}

	public void setAdjustFlag(String adjustFlag) {
		this.adjustFlag = adjustFlag;
	}

	public AimClient getAimClient() {
		return AimClient;
	}

	public void setAimClient(AimClient aimClient) {
		AimClient = aimClient;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public FlowCard getFlowCard() {
		return flowCard;
	}

	public void setFlowCard(FlowCard flowCard) {
		this.flowCard = flowCard;
	}
}
