/*
     Callable and Prepared statements.
     JDBC program for advanced SQL statement handling.
     @JIYO P V      roll no: 33    
     02 january 2026
*/
import java.sql.*;

public class JDBCStatements {
    public static void main(String[] args) {
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
            // Prepared Statement
            //create table emp(eno int,ename varchar(20),esal float,dno int);
            //insert into emp values(1,'jiyo',1000,1);
            //insert into emp values(2,'jibin',2000,2);
            //insert into emp values(3,'jibin',3000,3);
            String createquery="create table emp(eno int,ename varchar(20),esal float,dno int)";
            String insertquery="insert into emp values(1,'jiyo',1000,1)";
            String insertquery2="insert into emp values(2,'jibin',2000,2)";
            String insertquery3="insert into emp values(3,'jibin',3000,3)";
            Statement stmt = con.createStatement();
            stmt.execute(createquery);
            stmt.execute(insertquery);
            stmt.execute(insertquery2);
            stmt.execute(insertquery3);
            System.out.println("Executing Prepared Statement...");
            String pQuery = "UPDATE Emp SET esal = ? WHERE eno = ?";
            PreparedStatement pstmt = con.prepareStatement(pQuery);
            pstmt.setDouble(1, 15000.00);
            pstmt.setInt(2, 1);
            int rows = pstmt.executeUpdate();
            System.out.println("Rows updated by Prepared Statement: " + rows);

            // Callable Statement
            //create procedure getEmpName(in eno int,out ename varchar(20))
            //begin
            //select ename into ename from emp where eno=eno;
            //end;
            String createprocedure="create procedure getEmpName(in eno int,out ename varchar(20))\n"+
            "begin\n"+
            "select ename into ename from emp where eno=eno;\n"+
            "end;";
            stmt.execute(createprocedure);

            String cQuery = "{call getEmpName(?, ?)}";
            CallableStatement cstmt = con.prepareCall(cQuery);
            cstmt.setInt(1, 1);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.execute();
            String empName = cstmt.getString(2);
            System.out.println("Employee Name retrieved via procedure: " + empName);

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
