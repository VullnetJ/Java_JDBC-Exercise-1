package student_database_programs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SimpleStudentInsertProgram {
    private Connection connect() {

        String url = "jdbc:sqlite:databases/StudentDatabase.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(int id, String firstname, String lastname, String streetaddress, int postcode, String postoffice) {
    	String sql = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect();
                PreparedStatement ptmt = conn.prepareStatement(sql)) {
            ptmt.setInt(1, id);
            ptmt.setString(2, firstname);
            ptmt.setString(3, lastname);
            ptmt.setString(4, streetaddress);
            ptmt.setInt(5, postcode);
            ptmt.setString(6, postoffice);
               
            ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Failed to insert into Student database");
        }
    }	
		   public static void main(String[] args) {

			   SimpleStudentInsertProgram AppStudent = new SimpleStudentInsertProgram();		  
			   AppStudent.insert(50, "Frank", "Atkins", "Ratapihantie 13", 00520, "HELSINKI");
		       
		    }

		
		
	}
	

