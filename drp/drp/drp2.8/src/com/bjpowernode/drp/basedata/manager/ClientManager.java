package com.bjpowernode.drp.basedata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.drp.basedata.domain.Client;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.datadict.domain.ClientLevel;

public class ClientManager {
	private static ClientManager instance=new ClientManager();
	private ClientManager(){}
	public static ClientManager getInstance(){
		return instance;
	}
	/**
	 * 返回HTML字符串
	 * @return
	 */
	public String getClientTreeHTMLString(){
		return new ClientTreeReader().getClientTreeHTMLString();
	}
	/**
	 * 根据id查询分销商或区域
	 * @param id
	 * @return 如果存在返回client，否则返回null
	 */
	public Client findClientOrRegionById(int id){
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select a.id,a.pid,a.client_level_id,a.name,a.client_id")
			.append(",b.name as client_level_name,a.bank_acc_no")
			.append(",a.contact_tel,a.address,a.zip_code,a.is_leaf,a.is_client ")
			.append("from t_client a left join t_data_dict b on a.client_level_id=b.id where a.id=?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Client client=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				client=new Client();
				client.setId(rs.getInt("id"));
				client.setPid(rs.getInt("pid"));
				client.setName(rs.getString("name"));
				client.setClientId(rs.getString("client_id"));
				client.setBankAcctNo(rs.getString("bank_acc_no"));
				client.setContactTel(rs.getString("contact_tel"));
				client.setAddress(rs.getString("address"));
				client.setZipCode(rs.getString("zip_code"));
				client.setIsClient(rs.getString("is_leaf"));
				client.setIsClient(rs.getString("is_client"));
				ClientLevel clientlevel=new ClientLevel();
				clientlevel.setId(rs.getString("client_level_id"));
				clientlevel.setName(rs.getString("client_level_name"));
				client.setClientlevel(clientlevel);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return client;
	}
}
