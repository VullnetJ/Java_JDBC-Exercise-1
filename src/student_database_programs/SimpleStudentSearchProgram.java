package student_database_programs;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

// Accessing straight without relying into other parts (external codes) of code could be a better way since this will always work no matter what happen to the rest of other code. 
//Important is to connect to the database and use queries for accessing what ever we need.
public class SimpleStudentSearchProgram {
	private Connection connect() { 		
		Connection connection = null;
	    String studentDatabaseLocation = "jdbc:sqlite:databases/StudentDatabase.sqlite";

	    try {
	        connection = DriverManager.getConnection(studentDatabaseLocation);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return connection;
	}

	public void getStudentById(){
	      
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;	
//		int givenId = 20;
		
		System.out.println("=== Find student by id ===");
		String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student where id = 20";	
		//if we delete id 20 will not print anything if we run this. 
	    try (Connection connecting = this.connect();	    	
	         Statement statement  = connecting.createStatement();
	         ResultSet results  = statement.executeQuery(sqlText)){
	           
	        System.out.println("Enter student id: 20"); 
	        
	//        boolean rowFound = false;
	        while (results.next()) {
	            System.out.println(results.getInt("id") +  ", " + 
	            		results.getString("firstname") + " "  +
	            		results.getString("lastname") + ", "  +
	            		results.getString("streetaddress") + ", "  +
	            		results.getInt("postcode") + " "  +                    
	            		results.getString("postoffice"));
//	            if (rowFound == false) {
//					//System.out.println("Unknown student id (" + givenId + ")");
//				}  // this we dont need for now. In case we want to develop a project where we need to click a button to delete then it would make sense to have it. 
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

	public static void main(String[] args) {
		
		SimpleStudentSearchProgram studentList = new SimpleStudentSearchProgram();
	    studentList.getStudentById();
	}

	}