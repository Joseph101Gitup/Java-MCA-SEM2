/*
     Transaction and Batch processing.
     JDBC program demonstrating atomic transactions and batch updates.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.sql.*;

public class JDBCTransactionBatch {
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
            con.setAutoCommit(false);

            try {
                // Batch Processing
                System.out.println("Executing Batch Processing...");
                Statement stmt = con.createStatement();
                stmt.addBatch("INSERT INTO students VALUES (101, 'Alice', 'MCA')");
                stmt.addBatch("INSERT INTO students VALUES (102, 'Bob', 'MCA')");
                stmt.addBatch("UPDATE Emp SET esal = esal + 500 WHERE dno = 10");
                
                int[] results = stmt.executeBatch();
                System.out.println("Batch executed successfully. Updates: " + results.length);

                // Transaction (Commit)
                con.commit();
                System.out.println("Transaction Committed successfully.");

            } catch (SQLException e) {
                System.out.println("An error occurred during transaction: " + e.getMessage());
                con.rollback();
                System.out.println("Transaction Rolled back.");
            }

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
