package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 * 班级管理
 * */
public class ClassesManager {
	/**
	 * 单例模式
	 * */
	private static ClassesManager instance=new ClassesManager();
	private ClassesManager(){}
	public static ClassesManager getInstance(){
		return instance;
	}
	/**
	 * 输出班级信息
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
				System.out.println(s+rs.getInt("classes_Id")+"【"+rs.getString("classes_name")+"】");
				if(rs.getInt("leaf")==0){
					outClassesList(conn,rs.getInt("classes_id"),level+1);
				}
			}
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			//不要关闭Connection
			//资源最好遵循在哪打开，在哪关闭的原则
		}
	}
	/**
	 * 添加班级
	 * */
	public void addClassess(int pid,String classes){
		String sql="insert into t_classes(pid,classes_name) values (?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			//设置为false表示不会自动提交事物，必须手动提交
			DbUtil.setAutoCommit(conn, false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, classes);
			pstmt.executeUpdate();
			//取得当前节点的父节点
			Classes parentClasses=findClassesById(pid);
			//如果为叶子
			if(parentClasses.getLeaf()==1){
				modifyLeaf(conn,parentClasses.getClassesId(),0);
			}
			DbUtil.commit(conn);//提交事物
		}catch(Exception e){
			e.printStackTrace();
			//回滚事物
			DbUtil.rollback(conn);
		}finally{
			DbUtil.close(pstmt);
			//恢复连接的最初状态为自动提交
			DbUtil.setAutoCommit(conn, true);
			DbUtil.close(conn);

		}
	}
	/**
	 * 修改leaf字段
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
	 * 根据id查询班级
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
	 * 修改班级
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
	 * 删除班级
	 * */
	public void delClasses(int classesId){
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			//手动控制事物
			DbUtil.setAutoCommit(conn, false);
			//根据classesId取得班级对象（主要为修改其leaf状态为叶子）
			Classes classes=findClassesById(classesId);
			
			//递归删除班级
			delClasses(conn,classesId);//根据classesId寻找子节点
			//返回子节点个数
			int count =getChildren(conn,classes.getPid());//查询该节点的父节点是否还有子节点
			if(count ==0){
				//修改为叶子节点
				modifyLeaf(conn,classes.getPid(),1);//如果没有，则将该节点的父节点设置为叶子节点
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
	 *递归删除班级
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
				if(rs.getInt("leaf")==0){//当前不是叶子节点
					delClasses(conn,rs.getInt("classes_id"));
				}
				//完成真正的删除
				delClassesById(conn,rs.getInt("classes_id"));
			}
			//删除自身
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
	 * 删除具体的班级
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
	 * 取得当前节点的子节点个数
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
