/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {

 // Kết nối vào ORACLE.
 public static Connection getOracleConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "localhost";
     String sid = "orcl";
     String userName = "heartbeat";
     String password = "Oradoc_db1";

     return getOracleConnection(hostName, sid, userName, password);
 }

 public static Connection getOracleConnection(String hostName, String sid,
         String userName, String password) throws ClassNotFoundException,
         SQLException {

     // Khai báo class Driver cho DB Oracle
     // Việc này cần thiết với Java 5
     // Java6 tự động tìm kiếm Driver thích hợp.
     // Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
     Class.forName("oracle.jdbc.driver.OracleDriver");

     // Cấu trúc URL Connection dành cho Oracle
     // Ví dụ: jdbc:oracle:thin:@localhost:1521:db11g
     String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
