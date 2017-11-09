import java.sql.*;
//采用Prepare dStatement
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
					//第一步：加载数据库驱动，不同的数据库驱动程序是不一样的
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//第二步：得到数据库连接
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//第三步：得到PreparedStatement，执行sql
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