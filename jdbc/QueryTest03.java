import java.sql.*;
//����Prepare dStatement
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
					//��һ�����������ݿ���������ͬ�����ݿ����������ǲ�һ����
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//�ڶ������õ����ݿ�����
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//���������õ�PreparedStatement��ִ��sql
				String sql="select * from emp where job='"+args[0]+"'";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeStatement(sql);
				rs.pstmt.executeQuery();
				while(rs.next()){
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					System.out.println(empno+","+ename);
				}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			if(conn!=null){
				conn.close();
			}
			}catch(SQLException e){
			}
		}
		System.out.println(conn);
	}
}