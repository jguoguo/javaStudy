package com.bjpowernode.drp.flowcard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bjpowernode.drp.basedata.domain.Client;
import com.bjpowernode.drp.flowcard.dao.FlowCardDao;
import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.domain.FlowCardDetail;
import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.ConnectionManager;
import com.bjpowernode.drp.util.DaoException;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * 对流向单维护Dao层接口实现
 * @author Administrator
 *
 */
public class FlowCardDaoImpl implements FlowCardDao {

	//必须增加同步，否则两个用户同时
	@Override
	public synchronized String generateVouNo() throws DaoException {
		String sql="select max(flow_card_no) from t_flow_card_master where substr(flow_card_no,1,8)=?";
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
		sbSql.append("insert into t_flow_card_master (flow_card_no,opt_type,fiscal_year_period_id,")
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
		sbSql.append("insert into t_flow_card_detail (flow_card_no,aim_client_id,item_no,")
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
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select flow_card_no,client_id,client_name,user_name,opt_date ")
		.append("from ") 
		.append("( ")
		  .append("select rownum as rn,flow_card_no,client_id,client_name,user_name,opt_date ")
		  .append("from( ")
		  .append("select a.flow_card_no,a.client_id,b.name as client_name,c.user_name as user_name,a.opt_date ")
		   .append("from t_flow_card_master a join t_client b on a.client_id=b.id join t_user c on a.recorder_id=c.user_id where ");
		if(clientId!=null && !"".equals(clientId)){
			sbSql.append(" b.client_id=? and");
		}
		sbSql.append(" a.opt_date between ? and ? ");
		sbSql.append("order by a.flow_card_no ")
		   .append(") where rownum<=? ")
		 .append(") where rn>?");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<FlowCard> flowCardList=new ArrayList();
		try{
			Connection conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			if(clientId!=null && !"".equals(clientId)){
				pstmt.setString(1, clientId);
				pstmt.setTimestamp(2, new Timestamp(beginDate.getTime()));
				pstmt.setTimestamp(3, new Timestamp(endDate.getTime()));
				pstmt.setInt(4, pageNo*pageSize);
				pstmt.setInt(5, (pageNo-1)*pageSize);
			}else{
				pstmt.setTimestamp(1, new Timestamp(beginDate.getTime()));
				pstmt.setTimestamp(2, new Timestamp(endDate.getTime()));
				pstmt.setInt(3, pageNo*pageSize);
				pstmt.setInt(4, (pageNo-1)*pageSize);
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				FlowCard flowCard=new FlowCard();
				flowCard.setFlowCardNo(rs.getString("flow_card_no"));
				
				Client client=new Client();
				client.setClientId(rs.getString("client_id"));
				client.setName(rs.getString("client_name"));
				flowCard.setClient(client);
				
				User recorder=new User();
				recorder.setUserName(rs.getString("user_name"));
				flowCard.setRecoder(recorder);
				
				flowCard.setOptDate(rs.getTimestamp("opt_date"));
				flowCardList.add(flowCard);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("FlowCardImpl-->addFlowCardDetail,exception"+e);
			throw new DaoException(e);
		}finally{
			ConnectionManager.close(rs);
			ConnectionManager.close(pstmt);
		}
		return flowCardList;
	}

	@Override
	public int getRecordCount(String clientId, Date beginDate, Date endDate)
			throws DaoException {
		String sql="select count(*) from t_flow_card_master a join t_client b on a.client_id=b.id join t_user c on a.recorder_id=c.user_id where ";
		if(clientId !=null && !"".equals(clientId)){
			sql+=" b.client_id=? and ";
		}
		sql+=" a.opt_date between ? and ? ";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try{
			Connection conn=ConnectionManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			if(clientId!=null && !"".equals(clientId)){
				pstmt.setString(1, clientId);
				pstmt.setTimestamp(2, new Timestamp(beginDate.getTime()));
				pstmt.setTimestamp(3, new Timestamp(endDate.getTime()));
			}else{
				pstmt.setTimestamp(1, new Timestamp(beginDate.getTime()));
				pstmt.setTimestamp(2, new Timestamp(endDate.getTime()));
			}
			rs=pstmt.executeQuery();
			rs.next();
			count=rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("FlowCardImpl-->getRecordCount,exception"+e);
			throw new DaoException(e);
		}finally{
			ConnectionManager.close(rs);
			ConnectionManager.close(pstmt);
		}
		return count;
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
