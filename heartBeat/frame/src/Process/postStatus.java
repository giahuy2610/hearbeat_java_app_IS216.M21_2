/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giahu
 */
public class postStatus {

    private static ArrayList<String> statusId = new ArrayList<String>();
    private static ArrayList<String> statusName = new ArrayList<String>();

    public postStatus() {

    }

    public static String getStatusNameFromId(String statusId) {
        loadData();
        return statusName.get(Integer.parseInt(statusId));
    }

    private static void loadData() {
        try {
            Connection conn = OracleConnUtils.getOracleConnection();
            String query = "select * from tb_poststatus order by statusid";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            statusId.removeAll(statusId);
            statusName.removeAll(statusName);

            statusId.add("0");
            statusName.add("Tất cả");

            while (rs.next()) {
                statusId.add(rs.getString("statusid"));
                statusName.add(rs.getString("statusname"));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(postStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
