import java.sql.*;
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
					//第一步：加载数据库驱动，不同的数据库驱动程序是不一样的
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//第二步：得到数据库连接
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//第三步：创建statement,执行sql
				stmt=conn.creatStatement();
				//第四步:	取得结果集
				rs=stmt.executeQuery("select * from emp");
				while(rs.next()){
					int empno=rs.getInt("empno");
					String emname=rs.getString("empname");
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
				if(stat!=null){
					stat.close();
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