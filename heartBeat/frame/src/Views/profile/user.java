/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.profile;

import ConnectDB.OracleConnUtils;
import Views.main.trangChuJPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
/**
 *
 * @author giahu
 */
public class user {

    private static String userId;
    private static String firstName;
    private static String role;
    private static String score;
    private String code_auth;//code lưu mã khôi phục mật khẩu
    private static String lastName;

    public user() {

    }

    public user(String userid) {
        this.userId = userid;
        try {
            String query = "select * from tb_user where userid = " + userid;
            Connection conn = OracleConnUtils.getOracleConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                firstName = rs.getString("firstname");
                score = rs.getString("score");
                lastName = rs.getString("lastname");
             
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserid(String userid) {
        user.userId = userid;
    }

    public static String getFirstName() {
        return user.firstName;
    }
    
    public static String getScore() {
        return user.score;
    }

    public static String getLastName() {
        return user.lastName;
    }
 }
