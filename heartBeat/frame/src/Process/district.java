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
public class district {

    public static ArrayList<String> districtId = new ArrayList<String>();
    public static ArrayList<String> districtName = new ArrayList<String>();

    public district() {
    }

    public static ArrayList<String> getDistrictId() {
        return districtId;
    }

    public static void setDistrictId(ArrayList<String> districtId) {
        district.districtId = districtId;
    }

    public static ArrayList<String> getDistrictName() {
        return districtName;
    }

    public static void setDistrictName(ArrayList<String> districtName) {
        district.districtName = districtName;
    }

    private static void loadData(JComboBox cityFilter) {
        districtId.removeAll(districtId);
        districtName.removeAll(districtName);

        districtId.add("0");
        districtName.add("Tất cả");

        if (cityFilter.getSelectedIndex() == 0) {

        } else {
            Connection conn = null;
        
            try {
                 conn = OracleConnUtils.getOracleConnection();
            } catch (SQLException ex) {
                Logger.getLogger(district.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(district.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<String> cityId = city.getCityId();
            String cityid_temp = cityId.get(cityFilter.getSelectedIndex());
            String query = "";
            
            synchronized (query) {
                query = "select * from tb_district where cityid = " + cityid_temp;
                System.out.println(query);
            }
            try ( Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    districtId.add(rs.getString("districtid"));
                    districtName.add(rs.getString("districtname"));
                    
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
            }
        }
        
    }

    public static ArrayList<String> prepareDistrictFilter(JComboBox cityFilter, JComboBox districtFilter) {
    
        districtFilter.removeAllItems();
        loadData(cityFilter);
        
        for (String item : districtName) {
            districtFilter.addItem(item);
        }
        System.out.println("size of districtid array is " + districtId.size());
        return districtId;
    }

}
