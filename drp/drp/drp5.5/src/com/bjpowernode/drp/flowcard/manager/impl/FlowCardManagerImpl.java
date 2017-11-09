package com.bjpowernode.drp.flowcard.manager.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.flowcard.dao.FlowCardDao;
import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.manager.FlowCardManager;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.ConnectionManager;
import com.bjpowernode.drp.util.DaoException;
import com.bjpowernode.drp.util.PageModel;

public class FlowCardManagerImpl implements FlowCardManager {

	private FlowCardDao flowCardDao;
	public FlowCardManagerImpl(){
		
		this.flowCardDao=(FlowCardDao)BeanFactory.getInstance().getDaoObject(FlowCardDao.class);
	}
	@Override
	public void addFlowCard(FlowCard flowCard) throws ApplicationException {
		Connection conn=null;
		try{
			//ȡ��Connection
			conn=ConnectionManager.getConnection();
			//��ʼ����
			ConnectionManager.beginTransaction(conn);
			//�������򵥵���
			String flowCardVouNo=flowCardDao.generateVouNo();
			//�����������Ϣ
			flowCardDao.addFlowCardMaster(flowCardVouNo, flowCard);
			//���������ϸ
			flowCardDao.addFlowCardDetail(flowCardVouNo, flowCard.getFlowCardDetail());
			//�ύ����
			ConnectionManager.commitTransaction(conn);
		}catch(DaoException e){
			//�ع�����
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("�������ʧ��");
		}finally{
			//�ر�connection������ThreadLoacl�����
			ConnectionManager.closeConnection();
		}
	}

	@Override
	public void delFlowCard(String[] flowCardVouNos)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyFlowCard(FlowCard flowCard) throws ApplicationException {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageModel findFlowCardList(int pageNo, int pageSize,
			String clientId, Date beginDate, Date endDate)
			throws ApplicationException {
		Connection conn=null;
		PageModel pageModel=null;
		try{
			//ȡ��Connection
			conn=ConnectionManager.getConnection();
			//ȡ�÷�ҳ����
			List<FlowCard> flowCardList=flowCardDao.findFlowCardList(pageNo, pageSize, clientId, beginDate, endDate);
			//ȡ�ü�¼��
			int count=flowCardDao.getRecordCount(clientId, beginDate, endDate);
			
			pageModel=new PageModel<FlowCard>();
			pageModel.setList(flowCardList);
			pageModel.setTotalRecords(count);
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
		}catch(DaoException e){
			//�ع�����
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("��ҳ��ѯ����ʧ��");
		}finally{
			//�ر�connection������ThreadLoacl�����
			ConnectionManager.closeConnection();
		}
		return pageModel;
	}

	@Override
	public void auditFlowCard(String[] flowCardVouNos)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public FlowCard findFlowCardDetail(String flowCardVouNo)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
