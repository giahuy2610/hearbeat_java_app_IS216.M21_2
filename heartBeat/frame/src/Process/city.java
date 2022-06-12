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
public class city {

    public static ArrayList<String> cityId = new ArrayList<String>();
    public static ArrayList<String> cityName = new ArrayList<String>();

    public city() {
    }

    public static ArrayList<String> getCityId() {
        return cityId;
    }

    public static void setCityId(ArrayList<String> cityId) {
        city.cityId = cityId;
    }

    public static ArrayList<String> getCityName() {
        return cityName;
    }

    public static void setCityName(ArrayList<String> cityName) {
        city.cityName = cityName;
    }

    private static void loadData() {
        try {
            Connection conn = OracleConnUtils.getOracleConnection();
            String query = "select * from tb_city order by cityid";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            cityId.removeAll(cityId);
            cityName.removeAll(cityName);

            //combobox cityfilter
            //thêm giá trị cho combobox city
            cityId.add("0");
            cityName.add("Tất cả");

            while (rs.next()) {
                cityId.add(rs.getString("cityid"));
                cityName.add(rs.getString("cityname"));

            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(city.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void prepareCityFilter(JComboBox cityFilter) {
        cityFilter.removeAllItems();
        loadData();
        
        for (String item : cityName) {
            cityFilter.addItem(item);
        }
    }
    
    public static String getCityNameFromCityId(String cityId) {
        return cityName.get(Integer. valueOf(cityId));
    }
}
