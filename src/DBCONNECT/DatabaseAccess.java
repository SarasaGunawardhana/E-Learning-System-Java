
package DBCONNECT;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DatabaseAccess {
    
    public Connection getConnection(){
        try {
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/st_2","root","");
            return (Connection) con;
        } catch (SQLException sQLException) {
            return null;

        }
    }

}
