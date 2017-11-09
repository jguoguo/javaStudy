package com.bjpowernode.drp.flowcard.dao;

import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.domain.FlowCardDetail;
import com.bjpowernode.drp.util.DaoException;

/**
 * ����ά�����ݷ��ʽṹ
 * @author Administrator
 *
 */
public interface FlowCardDao {
	/**
	 * �������򵥺�
	 */
	public String generateVouNo() throws DaoException;
	
	/**
	 * �����������Ϣ
	 * @param flowCardNo
	 * @param flowCard
	 * @throws DaoException
	 */
	public void addFlowCardMaster(String flowCardVouNo,FlowCard flowCard) throws DaoException;
	
	/**
	 * ���������ϸ��Ϣ
	 * @param flowCardNo
	 * @param flowCardDetail
	 * @throws DaoException
	 */
	public void addFlowCardDetail(String flowCardVouNo,List<FlowCardDetail> flowCardDetail) throws DaoException;
	
	/**
	 * ɾ����������Ϣ
	 * @param flowCardVouNos
	 * @throws DaoException
	 */
	public void delFlowCardMaster(String[] flowCardVouNos) throws DaoException;
	
	/**
	 * ɾ��������ϸ��Ϣ
	 * @param flowCardVouNos
	 * @throws DaoException
	 */
	public void delFlowCardDetail(String flowCardVouNos) throws DaoException;
	
	/**
	 * �޸���������Ϣ
	 * @param flowCardVouNo
	 * @param flowCard
	 * @throws DaoException
	 */
	public void modifyFlowCardMaster(String flowCardVouNo,FlowCard flowCard) throws DaoException;
	
	/**
	 * �޸�������ϸ��Ϣ
	 * @param flowCardVouNo
	 * @param flowCardDetail
	 * @throws DaoException
	 */
	public void modifyFlowCardDetail(String flowCardVouNo,List<FlowCardDetail> flowCardDetail) throws DaoException;
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @param clientId
	 * @param beginDate
	 * @param endDate
	 * @throws DaoException
	 */
	public List<FlowCard> findFlowCardList(int pageNo,int pageSize,String clientId,Date beginDate,Date endDate) throws DaoException;

	/**
	 * ��������ȡ�ü�¼��
	 * @param clientId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DaoException
	 */
	public int getRecordCount(String clientId,Date beginDate,Date endDate) throws DaoException;
	
	/**
	 * ��������
	 * @throws DaoException
	 */
	public void auditFlowCard(String[] flowCardVouNos) throws DaoException;
	
	/**
	 * ������������Ϣ
	 * @param vouNo
	 * @return
	 * @throws DaoException
	 */
	public FlowCard findFlowCardMaster(String vouNo) throws DaoException;
	
	/**
	 * ����������Ϣ
	 * @param vouNo
	 * @return
	 * @throws DaoException
	 */
	public List<FlowCardDetail> findFlowCardDetailList(String vouNo) throws DaoException;
}
