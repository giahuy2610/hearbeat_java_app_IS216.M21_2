/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.global;

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
public class postCategory {

    private static ArrayList<String> categoryId = new ArrayList<String>();
    private static ArrayList<String> categoryName = new ArrayList<String>();

    public postCategory() {
    }

    public static ArrayList<String> getCategoryId() {
        return categoryId;
    }

    public static void setCategoryId(ArrayList<String> categoryId) {
        postCategory.categoryId = categoryId;
    }

    public static ArrayList<String> getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(ArrayList<String> categoryName) {
        postCategory.categoryName = categoryName;
    }

    private static void loadData() {
        categoryId.removeAll(categoryId);
        categoryName.removeAll(categoryName);
        try {
            String query = "select * from tb_category order by categoryid";
            Connection conn = OracleConnUtils.getOracleConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            categoryId.add("0");
            categoryName.add("Tất cả");

            while (rs.next()) {
                categoryId.add(rs.getString("categoryid"));
                categoryName.add(rs.getString("categoryname"));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(postCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void prepareCategoryFilter(JComboBox categoryFilter) {
        categoryFilter.removeAllItems();
        loadData();

        for (String item : categoryName) {
            categoryFilter.addItem(item);
        }

    }
}
