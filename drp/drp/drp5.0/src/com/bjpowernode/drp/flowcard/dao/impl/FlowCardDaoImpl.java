package com.bjpowernode.drp.flowcard.dao.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.flowcard.dao.FlowCardDao;
import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.domain.FlowCardDetail;
import com.bjpowernode.drp.util.ConnectionManager;
import com.bjpowernode.drp.util.DaoException;

/**
 * 对流向单维护Dao层接口实现
 * @author Administrator
 *
 */
public class FlowCardDaoImpl implements FlowCardDao {

	@Override
	public String generateVouNo() throws DaoException {
		Date date=new Date();
		int k=1;
		String number =String.format("%tY%<tm%<td%03d", date,k);
		return null;
	}

	@Override
	public void addFlowCardMaster(String flowCardVouNo, FlowCard flowCard)
			throws DaoException {
		

	}

	@Override
	public void addFlowCardDetail(String flowCardVouNo,
			List<FlowCardDetail> flowCardDetail) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delFlowCardMaster(String[] flowCardVouNos) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delFlowCardDetail(String flowCardVouNos) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyFlowCardMaster(String flowCardVouNo, FlowCard flowCard)
			throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyFlowCardDetail(String flowCardVouNo,
			List<FlowCardDetail> flowCardDetail) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FlowCard> findFlowCardList(int pageNo, int pageSize,
			String clientId, Date beginDate, Date endDate) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecordCount(String clientId, Date beginDate, Date endDate)
			throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void auditFlowCard(String[] flowCardVouNos) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public FlowCard findFlowCardMaster(String vouNo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlowCardDetail> findFlowCardDetailList(String vouNo)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
