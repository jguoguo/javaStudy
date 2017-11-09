package com.bjpowernode.drp.flowcard.manager.impl;

import java.sql.Connection;
import java.util.Date;

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

	@Override
	public PageModel findFlowCardList(int pageNo, int pageSize,
			String clientId, Date beginDate, Date endDate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
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
