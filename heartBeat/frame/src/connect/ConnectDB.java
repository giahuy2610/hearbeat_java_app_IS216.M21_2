import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author tuanpham
 */
public class ConnectDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return test.getOracleConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection...");
        Connection conn = ConnectDB.getConnection();
        System.out.println("Get connection " + conn); 
        System.out.println("Done!");
    }
}