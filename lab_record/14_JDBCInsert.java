/*
     Program to insert values into a table.
     JDBC program for executing insert queries.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.sql.*;
import java.util.Scanner;

public class JDBCInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Dept: ");
        String dept = scanner.nextLine();

        // Database connection details (Oracle)
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "jiyo";
        String pass = "1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle Driver not found!");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            String query = "INSERT INTO students (id, name, dept) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record(s) inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
