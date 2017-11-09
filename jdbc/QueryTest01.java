import java.sql.*;
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try{
					//��һ�����������ݿ���������ͬ�����ݿ����������ǲ�һ����
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//�ڶ������õ����ݿ�����
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//������������statement,ִ��sql
				stmt=conn.creatStatement();
				//���Ĳ�:	ȡ�ý����
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