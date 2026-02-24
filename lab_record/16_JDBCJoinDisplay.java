/*
     Displaying Emp and Dept info.
     JDBC program demonstrating joined table output.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.sql.*;

public class JDBCJoinDisplay {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String pass = "oracle";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle Driver not found!");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String query = "SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
                           "FROM Emp e JOIN Department d ON e.dno = d.dno";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Displaying headers
            System.out.printf("%-5s %-10s %-10s %-10s %-10s\n", "eno", "ename", "esal", "dname", "dloc");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-10s %-10.2f %-10s %-10s\n", 
                    rs.getInt("eno"), 
                    rs.getString("ename"), 
                    rs.getDouble("esal"), 
                    rs.getString("dname"), 
                    rs.getString("dloc"));
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
