/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.main;

import ConnectDB.OracleConnUtils;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author giahu
 */
public class trangChuJPanel extends javax.swing.JPanel {

    protected static ArrayList<String> postId = new ArrayList<String>();
    protected static ArrayList<String> postTitle = new ArrayList<String>();
    protected static ArrayList<String> postCategory = new ArrayList<String>();
    protected static ArrayList<String> postContent = new ArrayList<String>();
    protected static ArrayList<String> postPurpose = new ArrayList<String>();
    protected static ArrayList<String> postCreatedOn = new ArrayList<String>();

    protected static ArrayList<String> categoryId = new ArrayList<String>();
    protected static ArrayList<String> categoryName = new ArrayList<String>();

    protected static ArrayList<String> cityId = new ArrayList<String>();
    protected static ArrayList<String> cityName = new ArrayList<String>();

    protected static ArrayList<String> districtId = new ArrayList<String>();
    protected static ArrayList<String> districtName = new ArrayList<String>();

    protected static ArrayList<String> purposeId = new ArrayList<String>();
    protected static ArrayList<String> purposeName = new ArrayList<String>();

    protected static ArrayList<String> sortId = new ArrayList<String>();
    protected static ArrayList<String> sortName = new ArrayList<String>();

    protected Connection conn = null;

    protected static JPanel container = new JPanel(new GridLayout(0, 1)); // 1 column variable;

    protected static String query = "";

    /**
     * Creates new form trangChuJPanel
     */
    protected void prepareCategoryFilter() {
        try {
            query = "select * from tb_category order by categoryid";
            conn = OracleConnUtils.getOracleConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            categoryId.add("0");
            categoryName.add("Tất cả");
            categoryFilter.addItem("Tất cả");

            while (rs.next()) {
                categoryId.add(rs.getString("categoryid"));
                categoryName.add(rs.getString("categoryname"));
                categoryFilter.addItem(rs.getString("categoryname"));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void prepareCityFilter() {
        try {
            conn = OracleConnUtils.getOracleConnection();
            query = "select * from tb_category order by categoryid";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            cityId.removeAll(cityId);
            cityName.removeAll(cityName);

            //combobox cityfilter
            //thêm giá trị cho combobox city
            cityId.add("0");
            cityName.add("Tất cả");
            cityFilter.addItem("Tất cả");

            query = "select * from tb_city";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                cityId.add(rs.getString("cityid"));
                cityName.add(rs.getString("cityname"));
                cityFilter.addItem(rs.getString("cityname"));
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareDistrictFilter() {
        districtId.removeAll(districtId);
        districtName.removeAll(districtName);
        districtFilter.removeAllItems();

        districtFilter.addItem("Tất cả");
        districtId.add("0");
        districtName.add("Tất cả");

        if (cityFilter.getSelectedIndex() == 0) {

        } else {
            try {
                conn = OracleConnUtils.getOracleConnection();
            } catch (SQLException ex) {
                Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            String cityid_temp = cityId.get(cityFilter.getSelectedIndex());
            synchronized (query) {
                query = "select * from tb_district where cityid = " + cityid_temp;
            }
            try ( Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    districtId.add(rs.getString("districtid"));
                    districtName.add(rs.getString("districtname"));
                    districtFilter.addItem(rs.getString("districtname"));
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
            }

        }
    }

    protected void preparePurposeFilter() {
        try {
            conn = OracleConnUtils.getOracleConnection();
            query = "select * from tb_purpose order by purposeid";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            purposeId.removeAll(purposeId);
            purposeName.removeAll(purposeName);
            purposeFilter.removeAllItems();

            purposeId.add("0");
            purposeName.add("Tất cả");
            purposeFilter.addItem("Tất cả");

            while (rs.next()) {
                purposeId.add(rs.getString("purposeid"));
                purposeName.add(rs.getString("purposename"));
                purposeFilter.addItem(rs.getString("purposename"));
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void prepareSortFilter(JComboBox cbb) {
        sortId.removeAll(sortId);
        sortName.removeAll(sortName);
        cbb.removeAllItems();

        sortId.add("0");
        sortName.add("Gần đây");
        cbb.addItem("Gần đây");

        sortId.add("1");
        sortName.add("Lâu nhất");
        cbb.addItem("Lâu nhất");
    }

    protected String initQuery() {
        query = "select * from  tb_post where isdeleted = 0 and statusid = 1";

        if (categoryFilter.getSelectedIndex() > 0) {
            query += " and categoryid = " + categoryId.get(categoryFilter.getSelectedIndex());
        }

        if (purposeFilter.getSelectedIndex() > 0) {
            query += " and purposeid = " + purposeId.get(purposeFilter.getSelectedIndex());
        }

        if (cityFilter.getSelectedIndex() > 0) {
            query += " and ownerid in (select userid from tb_address where cityid = " + cityId.get(cityFilter.getSelectedIndex());

            if (districtFilter.getSelectedIndex() > 0) {
                query += " and districtid = " + districtId.get(districtFilter.getSelectedIndex());
            }

            query += ")";
        }

        if (sortFilter.getSelectedIndex() > 0) {
            query += " order by createdon desc";
        } else {
            query += " order by createdon";
        }

        System.out.println(query);
        return query;
    }

    protected void preparePost() {
        try {
            conn = OracleConnUtils.getOracleConnection();
            query = initQuery();
            System.out.println(query);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            container.removeAll();

            postId.removeAll(postId);
            postTitle.removeAll(postId);
            postCategory.removeAll(postCategory);
            postContent.removeAll(postContent);
            while (rs.next()) {
                postId.add(rs.getString("postid"));
                postTitle.add(rs.getString("title"));
                postCategory.add(rs.getString("categoryid"));
                postContent.add(rs.getString("content"));
                postCreatedOn.add(rs.getString("createdon"));
                postPurpose.add(rs.getString("purposeid"));
            }
            conn.close();

            for (int i = 0; i < postId.size(); i++) {
                baiViet x = new baiViet(postId.get(i), postTitle.get(i), postCategory.get(i), postContent.get(i),  postPurpose.get(i), postCreatedOn.get(i));
                //baiViet x = new baiViet(postId.get(i), postTitle.get(i), categoryName.get(Integer.parseInt(postCategory.get(i))), postContent.get(i),  purposeName.get(Integer.parseInt(postPurpose.get(i))), postCreatedOn.get(i));
                container.add(x);
            }
            jScrollPane1.setViewportView(container);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public trangChuJPanel() {
        initComponents();

        this.prepareCityFilter();
        this.prepareDistrictFilter();
        this.preparePurposeFilter();
        this.prepareCategoryFilter();
        this.prepareSortFilter(sortFilter);
        this.preparePost();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        purposeFilter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        categoryFilter = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cityFilter = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        districtFilter = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        sortFilter = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 0, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANG CHỦ");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 546));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(988, 1044));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField6.setText("Tìm kiem bai viet, danh muc bai viet");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/876054.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(807, 50));

        purposeFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trao tặng", "Xin nhận" }));
        purposeFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purposeFilterActionPerformed(evt);
            }
        });

        jLabel8.setText("Mục đích");

        categoryFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryFilterActionPerformed(evt);
            }
        });

        jLabel9.setText("Danh mục");

        cityFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFilterActionPerformed(evt);
            }
        });

        jLabel24.setText("Tình/Thành phố");

        districtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtFilterActionPerformed(evt);
            }
        });

        jLabel25.setText("Quận/Huyện");

        sortFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortFilterActionPerformed(evt);
            }
        });

        jLabel26.setText("Xếp theo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(districtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purposeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(districtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(cityFilter)
                    .addComponent(jLabel24)
                    .addComponent(jLabel8)
                    .addComponent(purposeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(categoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void purposeFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purposeFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_purposeFilterActionPerformed

    private void categoryFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFilterActionPerformed
        //System.out.println("city " + cityFilter.getSelectedIndex() + " district " + districtFilter.getSelectedIndex() + " category " + categoryFilter.getSelectedIndex());
        this.preparePost();
    }//GEN-LAST:event_categoryFilterActionPerformed

    private void cityFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFilterActionPerformed
        this.prepareDistrictFilter();
    }//GEN-LAST:event_cityFilterActionPerformed

    private void districtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_districtFilterActionPerformed

    private void sortFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortFilterActionPerformed
       this.preparePost();
    }//GEN-LAST:event_sortFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoryFilter;
    private javax.swing.JComboBox<String> cityFilter;
    private javax.swing.JComboBox<String> districtFilter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JComboBox<String> purposeFilter;
    private javax.swing.JComboBox<String> sortFilter;
    // End of variables declaration//GEN-END:variables
}
