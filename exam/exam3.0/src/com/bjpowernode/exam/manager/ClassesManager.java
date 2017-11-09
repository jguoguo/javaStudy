package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 * �༶����
 * */
public class ClassesManager {
	/**
	 * ����ģʽ
	 * */
	private static ClassesManager instance=new ClassesManager();
	private ClassesManager(){}
	public static ClassesManager getInstance(){
		return instance;
	}
	/**
	 * ����༶��Ϣ
	 * */
	public void outClassesList(){
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			outClassesList(conn,0,0);		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}

	}
	private void outClassesList(Connection conn,int classesId,int level) throws SQLException{
		String sql="select * from t_classes where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String s =" ";
			for(int i=0;i<level;i++){
				s+=" ";
			}
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(s+rs.getInt("classes_Id")+"��"+rs.getString("classes_name")+"��");
				if(rs.getInt("leaf")==0){
					outClassesList(conn,rs.getInt("classes_id"),level+1);
				}
			}
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			//��Ҫ�ر�Connection
			//��Դ�����ѭ���Ĵ򿪣����Ĺرյ�ԭ��
		}
	}
	/**
	 * ��Ӱ༶
	 * */
	public void addClassess(int pid,String classes){
		String sql="insert into t_classes(pid,classes_name) values (?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			//����Ϊfalse��ʾ�����Զ��ύ��������ֶ��ύ
			DbUtil.setAutoCommit(conn, false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, classes);
			pstmt.executeUpdate();
			//ȡ�õ�ǰ�ڵ�ĸ��ڵ�
			Classes parentClasses=findClassesById(pid);
			//���ΪҶ��
			if(parentClasses.getLeaf()==1){
				modifyLeaf(conn,parentClasses.getClassesId(),0);
			}
			DbUtil.commit(conn);//�ύ����
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			DbUtil.rollback(conn);
		}finally{
			DbUtil.close(pstmt);
			//�ָ����ӵ����״̬Ϊ�Զ��ύ
			DbUtil.setAutoCommit(conn, true);
			DbUtil.close(conn);

		}
	}
	/**
	 * �޸�leaf�ֶ�
	 * */
	private void modifyLeaf(Connection conn,int classesId,int leaf) throws Exception{
		String sql="update t_classes set leaf =? where classes_id=?";
		PreparedStatement pstmt=null;
		try{
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, leaf);
			 pstmt.setInt(2, classesId);
			 pstmt.executeUpdate();
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ����id��ѯ�༶
	 * */
	public Classes findClassesById(int classesId){
		String sql="select * from t_classes where classes_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Classes classes=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				classes=new Classes();
				classes.setClassesId(classesId);
				classes.setClassedName(rs.getString("classes_name"));
				classes.setPid(rs.getInt("pid"));
				classes.setLeaf(rs.getInt("leaf"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return classes;
	}
	
	
	/**
	 * �޸İ༶
	 * */
	public void modifyClasses(int classesId,String classesName){
		String sql="update t_classes set classes_name=? where classes_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesName);
			pstmt.setInt(2, classesId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * ɾ���༶
	 * */
	public void delClasses(int classesId){
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			//�ֶ���������
			DbUtil.setAutoCommit(conn, false);
			//����classesIdȡ�ð༶������ҪΪ�޸���leaf״̬ΪҶ�ӣ�
			Classes classes=findClassesById(classesId);
			
			//�ݹ�ɾ���༶
			delClasses(conn,classesId);//����classesIdѰ���ӽڵ�
			//�����ӽڵ����
			int count =getChildren(conn,classes.getPid());//��ѯ�ýڵ�ĸ��ڵ��Ƿ����ӽڵ�
			if(count ==0){
				//�޸�ΪҶ�ӽڵ�
				modifyLeaf(conn,classes.getPid(),1);//���û�У��򽫸ýڵ�ĸ��ڵ�����ΪҶ�ӽڵ�
			}
			DbUtil.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DbUtil.rollback(conn);
		}finally{
			DbUtil.close(conn);
		}
	}
	/**
	 *�ݹ�ɾ���༶
	 * @author:
	 * @version :
	 * @param conn
	 * @param classesId
	 * @throws Exception 
	 */
	private void delClasses(Connection conn,int classesId) throws Exception{
		String sql="select * from t_classes where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("leaf")==0){//��ǰ����Ҷ�ӽڵ�
					delClasses(conn,rs.getInt("classes_id"));
				}
				//���������ɾ��
				delClassesById(conn,rs.getInt("classes_id"));
			}
			//ɾ������
			delClassesById(conn,classesId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ɾ������İ༶
	 * @author:
	 * @version :
	 * @param conn
	 * @param classesId
	 * @throws Exception 
	 */
	private void delClassesById(Connection conn,int classesId) throws Exception{
		String sql="delete from t_classes where classes_id=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ȡ�õ�ǰ�ڵ���ӽڵ����
	 * @author:
	 * @version :
	 * @param args
	 */
	private int getChildren(Connection conn,int classesId) throws SQLException{
		String sql="select count(*) from t_classes where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			rs.next();
			count=rs.getInt(1);
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return count;
	}
	public static void main(String[] args){
		ClassesManager.getInstance().multiply();
	}
	public void multiply(){
		int i,j,k;
		int tmp;
		int a[]={1,2,3,4};
		int b[]={1,2,3,4};
		int c[]=new int[7];
		int result[]=new int[7];
		for(i=0;i<a.length;i++){
			k=i;
			for(j=0;j<b.length;j++){
				result[k++]+=a[i]*b[j];
			}
		}
		for(k=c.length-1;k>=0;k--){
			if(k>0){
				if(result[k]>9){
					result[k-1]+=result[k]/10;
					result[k]=result[k]%10;
				}
			}else{
				tmp=result[k]/10;
				result[k]=result[k]%10;
			}
		}
		for(i=0;i<result.length;i++){
			System.out.print(result[i]+",");
		}
	}
}
