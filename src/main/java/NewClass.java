
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author mmazzucco
 * @author raziel
 * @author juan
 */
public class NewClass {
    public static void main(String []args) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (username varchar(20), password varchar(20))");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected");
            
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
