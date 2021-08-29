package data_access;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
    public static void connect() {
        Connection connection = null;
        try {
      
            String studentDatabaseLocation = "jdbc:sqlite:databases/StudentDatabase.sqlite";          
            connection = DriverManager.getConnection(studentDatabaseLocation);            
            System.out.println("Connection to SQLite has been established.");
  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
  
    public static void main(String[] args) {
        connect();
    }
}