/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author giahu
 */
public class postPurpose {

    protected static ArrayList<String> purposeId = new ArrayList<String>();
    protected static ArrayList<String> purposeName = new ArrayList<String>();

    public static String getPurposeNameFromId(String purposeId) {
        return purposeName.get(Integer.parseInt(purposeId));
    }

    public postPurpose() {
    }

    public static ArrayList<String> getPurposeId() {
        return purposeId;
    }

    public static void setPurposeId(ArrayList<String> purposeId) {
        postPurpose.purposeId = purposeId;
    }

    public static ArrayList<String> getPurposeName() {
        return purposeName;
    }

    public static void setPurposeName(ArrayList<String> purposeName) {
        postPurpose.purposeName = purposeName;
    }

    private static void loadData() {
        try {
            Connection conn = OracleConnUtils.getOracleConnection();
            String query = "select * from tb_purpose order by purposeid";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            purposeId.removeAll(purposeId);
            purposeName.removeAll(purposeName);

            purposeId.add("0");
            purposeName.add("Tất cả");

            while (rs.next()) {
                purposeId.add(rs.getString("purposeid"));
                purposeName.add(rs.getString("purposename"));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(postPurpose.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void preparePurposeFilter(JComboBox purposeFilter) {
        purposeFilter.removeAllItems();
        loadData();

        for (String item : purposeName) {
            purposeFilter.addItem(item);
        }

    }

}
