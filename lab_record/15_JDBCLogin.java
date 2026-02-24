/*
     Login table record check.
     JDBC program to verify username and password against a database table.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.sql.*;
import java.util.Scanner;

public class JDBCLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String uname = scanner.nextLine();
        System.out.print("Enter Password: ");
        String upass = scanner.nextLine();

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
            String query = "SELECT * FROM login WHERE Uname = ? AND Upass = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, uname);
            pstmt.setString(2, upass);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful! Record found.");
            } else {
                System.out.println("Login Failed! Record not present.");
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
