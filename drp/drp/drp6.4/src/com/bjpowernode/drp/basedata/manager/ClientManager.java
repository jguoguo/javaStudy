package com.bjpowernode.drp.basedata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.drp.basedata.domain.AimClient;
import com.bjpowernode.drp.basedata.domain.Client;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.IdGenerator;
import com.bjpowernode.drp.util.PageModel;
import com.bjpowernode.drp.util.datadict.domain.ClientLevel;

public class ClientManager {
	private static ClientManager instance=new ClientManager();
	private ClientManager(){}
	public static ClientManager getInstance(){
		return instance;
	}
	/**
	 * ����HTML�ַ���
	 * @return
	 */
	public String getClientTreeHTMLString(){
		return new ClientTreeReader().getClientTreeHTMLString();
	}
	/**
	 * ����id��ѯ�����̻�����
	 * @param id
	 * @return ������ڷ���client�����򷵻�null
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
				client.setIsLeaf(rs.getString("is_leaf"));
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
	/**
	 * �޸�����������
	 * @param client
	 */
	public void modifyClientOrRegion(Client client){
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("update t_client set client_level_id=?,")
			.append("name=?,bank_acc_no=?,contact_tel=?,address=?,")
			.append("zip_code=? where id=?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setString(1, client.getClientlevel().getId());
			pstmt.setString(2, client.getName());
			pstmt.setString(3, client.getBankAcctNo());
			pstmt.setString(4, client.getContactTel());
			pstmt.setString(5, client.getAddress());
			pstmt.setString(6, client.getZipCode());
			pstmt.setInt(7, client.getId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * ���ӷ����̻�����
	 * @param clientOrRegion
	 */
	public void addClientOrRegion(Client clientOrRegion){
		String sql="insert into t_client (id,pid,client_level_id,name,client_id," +
				"bank_acc_no,contact_tel,address,zip_code,is_leaf,is_client) " +
				"values (?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			int id=IdGenerator.genertate("t_client");
			DbUtil.beginTransaction(conn);//�ֶ����������ύ
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, clientOrRegion.getPid());
			pstmt.setString(3, clientOrRegion.getClientlevel().getId());
			pstmt.setString(4, clientOrRegion.getName());
			pstmt.setString(5, clientOrRegion.getClientId());
			pstmt.setString(6, clientOrRegion.getBankAcctNo());
			pstmt.setString(7, clientOrRegion.getContactTel());
			pstmt.setString(8, clientOrRegion.getAddress());
			pstmt.setString(9, clientOrRegion.getZipCode());
			pstmt.setString(10, clientOrRegion.getIsLeaf());
			pstmt.setString(11, clientOrRegion.getIsClient());
			pstmt.executeUpdate();
			//ȡ�õ�ǰ�ڵ�ĸ��ڵ�
			Client parentClient=findClientOrRegionById(clientOrRegion.getPid());
			//���ΪҶ�ӣ����޸�Ϊ��Ҷ��
			if("Y".equals(parentClient.getIsLeaf())){
				//��is_leaf�޸�Ϊ��Ҷ��
				modifyLeaf(conn,clientOrRegion.getPid(),"N");
			}
			DbUtil.commitTransaction(conn);//�ύ����
		}catch(SQLException e){
			e.printStackTrace();
			DbUtil.rollbackTransaction(conn);//�ع�����
		}finally{
			DbUtil.close(pstmt);
			DbUtil.resetConnection(conn);//�ָ�״̬
			DbUtil.close(conn);
		}
	}
	/**
	 * �޸�is_leaf
	 * @param conn
	 * @param id
	 * @param leaf ȡֵ��Y��N
	 * @throws SQLException
	 */
	private void modifyLeaf(Connection conn,int id,String leaf) throws SQLException{
		String sql="update t_client set is_leaf=? where id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, leaf);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ���ݷ����̴����ѯ
	 * @param clientId
	 * @return ���ڷ���true�����򷵻�false
	 */
	public boolean findClientByClientId(String clientId){
		String sql="select count(*) from t_client where client_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, clientId);
			rs=pstmt.executeQuery();
			rs.next();
			int count=rs.getInt("count(*)");
			if(count!=0){
				flag=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return flag;
	}
	/**
	 * ɾ�������̻�����
	 * @param id
	 */
	public void delClientOrRegion(int id){
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			//�ֶ���������
			DbUtil.beginTransaction(conn);
			//���游�ڵ����
			Client client=findClientOrRegionById(id);
			
			//�ݹ�ɾ���ڵ�
			recursionDelNode(conn,id);
			
			//�޸ĸ��ڵ��is_leaf
			modifyParent(conn,client.getPid());
			//�ύ����
			DbUtil.commitTransaction(conn);
		}catch(SQLException e){
			e.printStackTrace();
			DbUtil.rollbackTransaction(conn);
		}finally{
			DbUtil.resetConnection(conn);//����״̬
			DbUtil.close(conn);
		}
	}
	/**
	 * �ݹ�ɾ��
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	private void recursionDelNode(Connection conn,int id) throws SQLException{
		String sql="select * from t_client where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if("N".equals(rs.getString("is_leaf"))){//��ǰ����Ҷ�ӽڵ�
					recursionDelNode(conn,rs.getInt("id"));//�Ե�ǰ�ڵ�id��Ϊpid���в���
				}
				//���������ɾ��
				delClientOrRegionById(conn,rs.getInt("id"));
			}
			delClientOrRegionById(conn,id);//ɾ������
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ɾ������Ľڵ�
	 * @param id
	 * @throws SQLException 
	 */
	private void delClientOrRegionById(Connection conn,int id) throws SQLException{
		String sql="delete from t_client where id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * �޸ĸ��ڵ��is_leaf
	 * @param conn
	 * @param id
	 */
	private void modifyParent(Connection conn,int id){
		String sql="select * from t_client where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()==false){
				modifyLeaf(conn,id,"Y");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ��ѯ���еķ�����
	 * ����t_client��
	 * @param pageNo
	 * @param pageSize
	 * @param queryStr
	 * @return
	 */
	public PageModel<Client> findAllClient(int pageNo,int pageSize,String queryStr){
		StringBuffer sbSql=new StringBuffer();
//		sbSql.append("select id,pid,client_level_id,name,client_id,bank_acc_no,contact_tel,address,zip_code,is_leaf,is_client ")
//			.append("from (")
//				.append("select rownum as rn,id,pid,client_level_id,name,client_id,bank_acc_no,contact_tel,address,zip_code,is_leaf,is_client ")
//				.append("from(")
//					.append("select * from t_client where id like '%"+queryStr+"%' or name like '%"+queryStr+"%'")
//					.append(") where rownum <=?")
//			.append(") where rn>?");
		
		sbSql.append("select * from ")
			.append("( ")
				.append("select t.*,rownum rn from ")
				.append("( ")
					.append("select a.id,a.pid,a.name,a.client_id,b.id as client_level_id,b.name as client_level_name, ")
					.append("a.bank_acc_no,a.contact_tel,a.address,a.zip_code,a.is_leaf,a.is_client ")
					.append("from t_client a,t_data_dict b where a.client_level_id=b.id and a.is_client='Y' ")
					.append("and (a.client_id like ? or a.name like ?) order by a.id ")
					.append(") t where rownum<=? ")
			.append(") ")
			.append("where rn>?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<Client> pageModel=null;
		int count=0;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setString(1, queryStr+"%");
			pstmt.setString(2, queryStr+"%");
			pstmt.setInt(3, pageNo*pageSize);
			pstmt.setInt(4, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			List<Client> list=new ArrayList<Client>();
			while(rs.next()){
				count++;
				Client client=new Client();
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
				list.add(client);
			}
			pageModel=new PageModel<Client>();
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setTotalRecords(count);	
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return pageModel;
	}
	/**
	 * ��ѯ���е��跽�ͻ�
	 * ����v_aim_client��ͼ
	 * @param pageNo
	 * @param pageSize ÿҳ����
	 * @param queryStr ��ѯ����
	 * @return
	 */
	public static PageModel<AimClient> findAllAimClient(int pageNo,int pageSize,String queryStr){
		//String sql="select * from v_aim_client where id like '%?%' or name like '%?%'";
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select id,name,client_temi_id,client_temi_level_id,client_temi_level_name ")
			.append("from (")
				.append("select rownum as rn,id,name,client_temi_id,client_temi_level_id,client_temi_level_name ")
				.append("from(")
					.append("select * from v_aim_client where id like '%"+queryStr+"%' or name like '%"+queryStr+"%'")
					.append(") where rownum <=?")
			.append(") where rn>?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PageModel<AimClient> pageModel=null;
		int count=0;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			List<AimClient> list=new ArrayList<AimClient>();
			while(rs.next()){
				count++;
				AimClient ac=new AimClient();
				ac.setId(rs.getInt("id"));
				ac.setName(rs.getString("name"));
				ac.setClienttemiId(rs.getString("client_temi_id"));
				ac.setClienttemiLevelId(rs.getString("client_temi_level_id"));
				ac.setClienttemiLevelName(rs.getString("client_temi_level_name"));
				list.add(ac);
			}
			pageModel=new PageModel<AimClient>();
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setPageSize(pageSize);
			pageModel.setTotalRecords(count);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return pageModel;
	}
	
	/**
	 * ȡ������
	 * @return
	 */
	public Map<Integer,String> getRegionList(){
		Map<Integer,String> map=getProvByRegion(10000);
		return map;
	}
	
	/**
	 * ȡ��ʡ
	 * @param id
	 * @return
	 */
	public Map<Integer,String> getProvByRegion(int id){
		String sql="select id,name from t_client where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=null;
		Map<Integer,String> map=new HashMap<Integer,String>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				map.put(rs.getInt("id"), rs.getString("name"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return map;
	}
	
}