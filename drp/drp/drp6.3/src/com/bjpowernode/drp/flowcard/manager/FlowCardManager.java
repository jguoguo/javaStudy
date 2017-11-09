package com.bjpowernode.drp.flowcard.manager;

import java.util.Date;

import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.PageModel;

/**
 * ����ά��ҵ���ӿ�
 * @author Administrator
 *
 */
public interface FlowCardManager {
	/**
	 * �������
	 * @param flowCard
	 * @throws ApplicationException
	 */
	public void addFlowCard(FlowCard flowCard) throws ApplicationException;
	
	/**
	 * ɾ������
	 * @param flowCardVouNos
	 * @throws ApplicationException
	 */
	public void delFlowCard(String[] flowCardVouNos) throws ApplicationException;
	
	/**
	 * �޸�����
	 * @param flowCard
	 * @throws ApplicationException
	 */
	public void modifyFlowCard(FlowCard flowCard) throws ApplicationException;
	
	/**
	 * ��ѯ����
	 * @param pageNo
	 * @param pageSize
	 * @param clientId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws ApplicationException
	 */
	public PageModel findFlowCardList(int pageNo,int pageSize,String clientId,Date beginDate,Date endDate) throws ApplicationException;
	
	/**
	 * ��������
	 * @param flowCardVouNos
	 * @throws ApplicationException
	 */
	public void auditFlowCard(String[] flowCardVouNos) throws ApplicationException;
	
	/**
	 * ��ѯ������ϸ��Ϣ
	 * @param flowCardVouNo
	 * @return
	 * @throws ApplicationException
	 */
	public FlowCard findFlowCardDetail(String flowCardVouNo) throws ApplicationException;
	
}
