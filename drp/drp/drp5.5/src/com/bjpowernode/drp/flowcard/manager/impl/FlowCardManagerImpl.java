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
			//取得Connection
			conn=ConnectionManager.getConnection();
			//开始事务
			ConnectionManager.beginTransaction(conn);
			//生成流向单单号
			String flowCardVouNo=flowCardDao.generateVouNo();
			//添加流向单主信息
			flowCardDao.addFlowCardMaster(flowCardVouNo, flowCard);
			//添加流向单明细
			flowCardDao.addFlowCardDetail(flowCardVouNo, flowCard.getFlowCardDetail());
			//提交事务
			ConnectionManager.commitTransaction(conn);
		}catch(DaoException e){
			//回滚事务
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("添加流向单失败");
		}finally{
			//关闭connection，并从ThreadLoacl中清除
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
	 * 分页查询
	 */
	@Override
	public PageModel findFlowCardList(int pageNo, int pageSize,
			String clientId, Date beginDate, Date endDate)
			throws ApplicationException {
		Connection conn=null;
		PageModel pageModel=null;
		try{
			//取得Connection
			conn=ConnectionManager.getConnection();
			//取得分页数据
			List<FlowCard> flowCardList=flowCardDao.findFlowCardList(pageNo, pageSize, clientId, beginDate, endDate);
			//取得记录数
			int count=flowCardDao.getRecordCount(clientId, beginDate, endDate);
			
			pageModel=new PageModel<FlowCard>();
			pageModel.setList(flowCardList);
			pageModel.setTotalRecords(count);
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
		}catch(DaoException e){
			//回滚事务
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("分页查询流向单失败");
		}finally{
			//关闭connection，并从ThreadLoacl中清除
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
