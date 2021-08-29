package student_database_programs;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SimpleStudentListProgram  {
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


public void selectAll(){
    String sql = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student";
    
    try (Connection conn = this.connect();
         Statement stmt  = conn.createStatement();
         ResultSet rs    = stmt.executeQuery(sql)){
        
        System.out.println("=== Print students ===");
        while (rs.next()) {
            System.out.println(rs.getInt("id") +  ": " + 
                               rs.getString("firstname") + " "  +
                               rs.getString("lastname") + ", "  +
                               rs.getString("streetaddress") + ", "  +
                               rs.getInt("postcode") + " "  +                    
                               rs.getString("postoffice"));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static void main(String[] args) {
	SimpleStudentListProgram studentList = new SimpleStudentListProgram();
    studentList.selectAll();
}

}