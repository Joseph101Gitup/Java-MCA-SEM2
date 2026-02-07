import java.io.*;
import java.sql.*;

class db
{
	public static void main(String args[])
	{
		try
		{
			Connection con;
			Statement st;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("Jdbc:Odbc:dsds","","");
			st = con.createStatement();
			st.executeUpdate("insert into emp values(2,'DDD')");
			ResultSet rs = st.executeQuery("select * from emp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}