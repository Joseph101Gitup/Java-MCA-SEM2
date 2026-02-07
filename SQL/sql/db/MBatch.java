import java.sql.*;  
class MBatch
{  
	public static void main(String args[])throws Exception
	{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mca","mca");  
		con.setAutoCommit(false);  
  
		Statement stmt=con.createStatement();  
		stmt.addBatch("insert into usertb values(11,'vimal',4000)");  
		stmt.addBatch("insert into usertb values(12,'akhil',5000)");  
  		stmt.executeBatch();
		con.commit();  
		con.close();  
	}
}  