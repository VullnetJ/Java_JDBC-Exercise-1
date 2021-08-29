package student_database_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleStudentDeleteProgram {
  
	public static void main(String[] args) {
		String studentDatabaseLocation = "jdbc:sqlite:databases/StudentDatabase.sqlite";
		String sql = "DELETE FROM Student WHERE id = 20";
		System.out.println("=== Delete student ===");
		System.out.println("Enter student id: 20");
		try (Connection conn = DriverManager.getConnection(studentDatabaseLocation); 
		        Statement stmt = conn.createStatement();) {		      
		      stmt.executeUpdate(sql);
		      System.out.println("Student deleted!");
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
	}

}
