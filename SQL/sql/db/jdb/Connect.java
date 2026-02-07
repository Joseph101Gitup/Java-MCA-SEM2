import java.sql.*;
 
public class Connect 
{
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","","");
            System.out.println("connected.."+con);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Test2");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + "  " + rs.getString(2));
		}
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
 
}