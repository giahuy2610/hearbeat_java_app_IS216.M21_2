import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 
 */
public class test {
    public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String sid = "orcl";
        String userName = "C##VINASUPPORT";
        String password = "PASS1";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;
    }
}