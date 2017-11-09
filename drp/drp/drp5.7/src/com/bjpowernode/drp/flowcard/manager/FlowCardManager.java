package com.bjpowernode.drp.flowcard.manager;

import java.util.Date;

import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.PageModel;

/**
 * 流向单维护业务层接口
 * @author Administrator
 *
 */
public interface FlowCardManager {
	/**
	 * 添加流向单
	 * @param flowCard
	 * @throws ApplicationException
	 */
	public void addFlowCard(FlowCard flowCard) throws ApplicationException;
	
	/**
	 * 删除流向单
	 * @param flowCardVouNos
	 * @throws ApplicationException
	 */
	public void delFlowCard(String[] flowCardVouNos) throws ApplicationException;
	
	/**
	 * 修改流向单
	 * @param flowCard
	 * @throws ApplicationException
	 */
	public void modifyFlowCard(FlowCard flowCard) throws ApplicationException;
	
	/**
	 * 查询流向单
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
	 * 送审流向单
	 * @param flowCardVouNos
	 * @throws ApplicationException
	 */
	public void auditFlowCard(String[] flowCardVouNos) throws ApplicationException;
	
	/**
	 * 查询流向单明细信息
	 * @param flowCardVouNo
	 * @return
	 * @throws ApplicationException
	 */
	public FlowCard findFlowCardDetail(String flowCardVouNo) throws ApplicationException;
	
}
