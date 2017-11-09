import java.sql.*;
//����Prepare dStatement
public class QueryTest01{
	public static void main(String[] args) throws Exception{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
					//��һ�����������ݿ���������ͬ�����ݿ����������ǲ�һ����
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//�ڶ������õ����ݿ�����
				String dbUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
				String userName="system";
				String password="Asdf-12345";
				conn=DriverManager.getConnection(dbUrl,userName,password);
				//ȡ���������
				int empno=Integer.parseInt(args[0]);
				String ename=args[1];
				String job=args[2];
				int mgr=Integer.parseInt(args[3]);
				String hiredate=args[4];
				float sal=Float.parseFloat(args[5]);
				float comm=Float.parseFloat(args[6]);
				int deptno=Integer.parseInt(args[7]);
				//���������õ�statement��ִ��sql
				String sql="insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)";
				sql+="value("+empno+",'"+ename+"','"+job+"',"+mgr+",";
				sql+="to_date('"+hiredate+"','yyyy-mm-dd'),"+sal+","+comm+","+deptno+")";
				System.out.println("sql:"+sql);
				stmt=conn.createStatement();
				stmt.executeUpdate(sql);
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