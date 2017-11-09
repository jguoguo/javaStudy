package com.bjpowernode.drp.basedata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.basedata.domain.FiscalYearPeriod;
import com.bjpowernode.drp.sysmgr.domain.User;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.IdGenerator;
import com.bjpowernode.drp.util.PageModel;

public class FiscalYearPeriodManager {
	//单例
	private static FiscalYearPeriodManager instance=new FiscalYearPeriodManager();
	private FiscalYearPeriodManager(){}
	public static FiscalYearPeriodManager getInstance(){
		return instance;
	}
	
	/**
	 * 增加会计核算期
	 * @param fiscalYearPeriod
	 */
	public void addFiscalYearPeriod(FiscalYearPeriod fiscalYearPeriod){
		String sql="insert into t_fiscal_year_period (id ,fiscal_year,fiscal_period,begin_date,end_date,period_sts)" +
				"values (?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			int id=IdGenerator.genertate("t_fiscal_year_period");
			pstmt.setInt(1, id);
			pstmt.setInt(2, fiscalYearPeriod.getFiscalYear());
			pstmt.setInt(3, fiscalYearPeriod.getFiscalPeriod());
			pstmt.setTimestamp(4, new Timestamp(fiscalYearPeriod.getBeginDate().getTime()));
			pstmt.setTimestamp(5, new Timestamp(fiscalYearPeriod.getEndDate().getTime()));
			pstmt.setString(6, fiscalYearPeriod.getPeriodSts());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * 修改会计核算期
	 * @param fiscalYearPeriod
	 */
	public void updateFiscalYearPeriod(FiscalYearPeriod fiscalYearPeriod){
		String sql="update t_fiscal_year_period set begin_date=?,end_date=?,period_sts=? " +
				"where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(fiscalYearPeriod.getBeginDate().getTime()));
			pstmt.setTimestamp(2, new Timestamp(fiscalYearPeriod.getEndDate().getTime()));
			pstmt.setString(3, fiscalYearPeriod.getPeriodSts());
			pstmt.setInt(4, fiscalYearPeriod.getId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
				
	}
	/**
	 * 根据核算年和核算月查询会计核算期间
	 * @param fiscalYear 核算年
	 * @param fiscalperiod 核算月
	 * @return FiscalYearPeriod
	 */
	public FiscalYearPeriod findFiscalYearPeriod(int fiscalYear,int fiscalperiod){
		String sql="selsect * from t_fiscal_year_period where fiscal_year=? and fiscal_period=?";
		return null;
		
	}
	
	public FiscalYearPeriod findFiscalYearPeriodById(int id){
		String sql="select * from t_fiscal_year_period where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		FiscalYearPeriod fiscalYearPeriod=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				fiscalYearPeriod=new FiscalYearPeriod();
				fiscalYearPeriod.setId(rs.getInt("id"));
				fiscalYearPeriod.setFiscalYear(rs.getInt("fiscal_year"));
				fiscalYearPeriod.setFiscalPeriod(rs.getInt("fiscal_period"));
				fiscalYearPeriod.setBeginDate(rs.getTimestamp("begin_date"));
				fiscalYearPeriod.setEndDate(rs.getTimestamp("end_date"));
				fiscalYearPeriod.setPeriodSts(rs.getString("period_sts"));
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return fiscalYearPeriod;
	}
	
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel<FiscalYearPeriod> findAllFiscalYear(int pageNo,int pageSize){
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select id ,fiscal_year,fiscal_period,begin_date,end_date,period_sts ")
		.append("from (")
			.append("select rownum as rn,id,fiscal_year,fiscal_period,begin_date,end_date,period_sts ")
			.append("from(")
				.append("select * from t_fiscal_year_period ")
				.append(") where rownum <=?")
		.append(") where rn>?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<FiscalYearPeriod> pageModel=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			List<FiscalYearPeriod> fisList=new ArrayList<FiscalYearPeriod>();
			while(rs.next()){
				FiscalYearPeriod fiscalYearPeriod=new FiscalYearPeriod();
				fiscalYearPeriod.setId(rs.getInt("id"));
				fiscalYearPeriod.setFiscalYear(rs.getInt("fiscal_year"));
				fiscalYearPeriod.setFiscalPeriod(rs.getInt("fiscal_period"));
				fiscalYearPeriod.setBeginDate(rs.getTimestamp("begin_date"));
				fiscalYearPeriod.setEndDate(rs.getTimestamp("end_date"));
				fiscalYearPeriod.setPeriodSts(rs.getString("period_sts"));
				fisList.add(fiscalYearPeriod);
			}
			pageModel=new PageModel<FiscalYearPeriod>();
			pageModel.setTotalRecords(getTotalRecords(conn));
			pageModel.setList(fisList);
			pageModel.setPageSize(pageSize);
			pageModel.setPageNo(pageNo);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
		}
		return pageModel;
	}
	/**
	 * 取得总记录数
	 * @param conn
	 * @return
	 */
	private int getTotalRecords(Connection conn) throws SQLException{
		String sql="select count(*) from t_fiscal_year_period ";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count;
		try{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			count=rs.getInt(1);
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return count;
	}
	
}
