package com.bjpowernode.drp.flowcard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
		String sql="select max(flow_card_no) from flow_card_master where substr(flow_card_no,1,8)=?";
		String currentDate=new SimpleDateFormat("yyyyMMdd").format(new Date());
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String vouNo=currentDate+"0001";
		try{
			Connection conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, currentDate);
			rs=pstmt.executeQuery();
			rs.next();
			if(rs.getLong(1)!=0){
				vouNo=String.valueOf(rs.getLong(1)+1);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("FlowCardImpl-->generateVouNo,exception"+e);
			throw new DaoException(e);
		}finally{
			ConnectionManager.close(rs);
			ConnectionManager.close(pstmt);
		}
		return vouNo;
	}

	@Override
	public void addFlowCardMaster(String flowCardVouNo, FlowCard flowCard)
			throws DaoException {
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("insert into flow_card_master (flow_card_no,opt_type,fiscal_year_period_id,")
				.append("client_id,recorder_id,opt_date,vou_sts) ")
				.append("values (?,?,?,?,?,?,?)");
		PreparedStatement pstmt=null;
		try{
			Connection conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setString(1, flowCardVouNo);
			pstmt.setString(2, flowCard.getOptType());
			pstmt.setInt(3, flowCard.getFiscalYearPeriod().getId());
			pstmt.setInt(4, flowCard.getClient().getId());
			pstmt.setString(5, flowCard.getRecoder().getUserId());
			pstmt.setTimestamp(6, new Timestamp(flowCard.getOptDate().getTime()));
			pstmt.setString(7, flowCard.getVouSts());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("FlowCardImpl-->addFlowCardMaster,exception"+e);
			throw new DaoException(e);
		}finally{
			ConnectionManager.close(pstmt);
		}

	}

	@Override
	public void addFlowCardDetail(String flowCardVouNo,
			List<FlowCardDetail> flowCardDetail) throws DaoException {
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("insert into flow_card_detail (flow_card_no,aim_client_id,item_no,")
				.append("opt_qty,adjust_flag) ")
				.append("values (?,?,?,?,?)");
		PreparedStatement pstmt=null;
		try{
			Connection conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			for(Iterator<FlowCardDetail> iter=flowCardDetail.iterator();iter.hasNext();){
				FlowCardDetail flowCardDetail1=iter.next();
				pstmt.setString(1, flowCardVouNo);
				pstmt.setInt(2, flowCardDetail1.getAimClient().getId());
				pstmt.setString(3, flowCardDetail1.getItem().getItemNo());
				pstmt.setBigDecimal(4, flowCardDetail1.getOptQty());
				pstmt.setString(5, flowCardDetail1.getAdjustFlag());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("FlowCardImpl-->addFlowCardDetail,exception"+e);
			throw new DaoException(e);
		}finally{
			ConnectionManager.close(pstmt);
		}
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
