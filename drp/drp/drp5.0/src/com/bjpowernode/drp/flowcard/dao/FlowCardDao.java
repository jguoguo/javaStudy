package com.bjpowernode.drp.flowcard.dao;

import java.util.Date;
import java.util.List;

import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.domain.FlowCardDetail;
import com.bjpowernode.drp.util.DaoException;

/**
 * 流向单维护数据访问结构
 * @author Administrator
 *
 */
public interface FlowCardDao {
	/**
	 * 生成流向单号
	 */
	public String generateVouNo() throws DaoException;
	
	/**
	 * 添加流向单主信息
	 * @param flowCardNo
	 * @param flowCard
	 * @throws DaoException
	 */
	public void addFlowCardMaster(String flowCardVouNo,FlowCard flowCard) throws DaoException;
	
	/**
	 * 添加流向单明细信息
	 * @param flowCardNo
	 * @param flowCardDetail
	 * @throws DaoException
	 */
	public void addFlowCardDetail(String flowCardVouNo,List<FlowCardDetail> flowCardDetail) throws DaoException;
	
	/**
	 * 删除流向单主信息
	 * @param flowCardVouNos
	 * @throws DaoException
	 */
	public void delFlowCardMaster(String[] flowCardVouNos) throws DaoException;
	
	/**
	 * 删除流向单明细信息
	 * @param flowCardVouNos
	 * @throws DaoException
	 */
	public void delFlowCardDetail(String flowCardVouNos) throws DaoException;
	
	/**
	 * 修改流向单主信息
	 * @param flowCardVouNo
	 * @param flowCard
	 * @throws DaoException
	 */
	public void modifyFlowCardMaster(String flowCardVouNo,FlowCard flowCard) throws DaoException;
	
	/**
	 * 修改流向单明细信息
	 * @param flowCardVouNo
	 * @param flowCardDetail
	 * @throws DaoException
	 */
	public void modifyFlowCardDetail(String flowCardVouNo,List<FlowCardDetail> flowCardDetail) throws DaoException;
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param clientId
	 * @param beginDate
	 * @param endDate
	 * @throws DaoException
	 */
	public List<FlowCard> findFlowCardList(int pageNo,int pageSize,String clientId,Date beginDate,Date endDate) throws DaoException;

	/**
	 * 根据条件取得记录数
	 * @param clientId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DaoException
	 */
	public int getRecordCount(String clientId,Date beginDate,Date endDate) throws DaoException;
	
	/**
	 * 送审流向单
	 * @throws DaoException
	 */
	public void auditFlowCard(String[] flowCardVouNos) throws DaoException;
	
	/**
	 * 返回流向单主信息
	 * @param vouNo
	 * @return
	 * @throws DaoException
	 */
	public FlowCard findFlowCardMaster(String vouNo) throws DaoException;
	
	/**
	 * 返回流向单信息
	 * @param vouNo
	 * @return
	 * @throws DaoException
	 */
	public List<FlowCardDetail> findFlowCardDetailList(String vouNo) throws DaoException;
}
