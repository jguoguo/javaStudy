import java.sql.*;
//采用Prepare dStatement
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
					//第一步：加载数据库驱动，不同的数据库驱动程序是不一样的
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//第二步：得到数据库连接
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//取得输入参数
				int empno=Integer.parseInt(args[0]);
				String ename=args[1];
				String job=args[2];
				int mgr=Integer.parseInt(args[3]);
				String hiredate=args[4];
				float sal=Float.parseFloat(args[5]);
				float comm=Float.parseFloat(args[6]);
				int deptno=Integer.parseInt(args[7]);
				//第三步：得到statement，执行sql
				String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)";
				stmt=conn.preparedStatement();
				stmt.setInt(1,empno);
				stmt.setString(2,ename);
				stmt.setString(3,job);
				stmt.setInt(4,mgr);
				java.util.Date d=new SimpleDateFormat("yyyy-mm-dd").parse(hiredate);
				stmt.setDate(5,new java.sql,Date(d.getTime());
				stmt.setFloat(6,sal);
				stmt.setFloat(7,comm);
				stmt.setInt(8,deptno);
				
				pstmt.executeUpdate();
				stmt.executeUpdate(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
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