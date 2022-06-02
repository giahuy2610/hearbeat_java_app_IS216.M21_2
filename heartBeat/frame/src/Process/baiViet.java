/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnUtils;
import Views.main.mainFrame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giahu
 */
public class baiViet {

    public static void themBaiViet(String postTitle, String postContent, String postCategoryId, String postPurposeId, String image) throws SQLException, ClassNotFoundException {

    
        Connection conn = OracleConnUtils.getOracleConnection();
     
        String query = "{call P_INSERT_POST(?,?,?,?,?,?)}";
    
        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, mainFrame.currentUser.getUserId());
        caSt.setString(2, postTitle);
        caSt.setString(3, postContent);
        caSt.setString(4, postCategoryId);
        caSt.setString(5, postPurposeId);
        caSt.setString(6, image);
        caSt.execute();       
    }
   
}
