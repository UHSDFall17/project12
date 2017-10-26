package trello;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionManager {
    private static String urlstring = "jdbc:mysql://50.62.176.51/Trello";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "trello";   
    private static String password = "Team12";
    private static Connection con;
 

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = (Connection) DriverManager.getConnection(urlstring, username, password);
            } catch (Exception ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
