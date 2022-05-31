/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.main;

import ConnectDB.OracleConnUtils;
import Views.global.city;
import Views.global.district;
import Views.global.postCategory;
import Views.global.postPurpose;
import Views.global.sort;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    protected Connection conn = null;

    protected static JPanel container = new JPanel(new GridLayout(0, 1)); // 1 column variable;

    protected static String query = "";
    private static int firstFill = 0;

    protected String initQuery() {
        if (firstFill == 0) {
            query = "select * from  tb_post where isdeleted = 0 and statusid = 1";
        } else {
            query = "select * from  tb_post where ( upper(title) like upper('%" + field_tim_kiem.getText() + "%') or upper(content) like upper('%" + field_tim_kiem.getText() + "%') ) and isdeleted = 0 and statusid = 1";
        }

        if (categoryFilter.getSelectedIndex() > 0) {
            postCategory a = new postCategory();
            ArrayList<String> categoryId = a.getCategoryId();
            query += " and categoryid = " + categoryId.get(categoryFilter.getSelectedIndex());
        }

        if (purposeFilter.getSelectedIndex() > 0) {
            postPurpose a = new postPurpose();
            ArrayList<String> purposeId = a.getPurposeId();

            query += " and purposeid = " + purposeId.get(purposeFilter.getSelectedIndex());
        }

        if (cityFilter.getSelectedIndex() > 0) {
            city a = new city();
            ArrayList<String> cityId = a.getCityId();
            query += " and ownerid in (select userid from tb_address where cityid = " + cityId.get(cityFilter.getSelectedIndex());

            if (districtFilter.getSelectedIndex() > 0) {
                district b = new district();
                ArrayList<String> districtId = b.getDistrictId();
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
                baiVietJPanel x = new baiVietJPanel(postId.get(i), postTitle.get(i), postCategory.get(i), postContent.get(i), postPurpose.get(i), postCreatedOn.get(i));
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
        field_tim_kiem.setText("Bạn muốn tìm kiếm....");
        city d = new city();
        d.prepareCityFilter(cityFilter);

        district.prepareDistrictFilter(cityFilter, districtFilter);

        postPurpose b = new postPurpose();
        b.preparePurposeFilter(purposeFilter);

        postCategory a = new postCategory();
        a.prepareCategoryFilter(categoryFilter);

        sort.prepareSortFilter(sortFilter);

        this.preparePost();
    }

    public trangChuJPanel(int defaultSeletectedPurpose, int defaultSeletectedCategory) {
        initComponents();

        city d = new city();
        d.prepareCityFilter(cityFilter);

        district.prepareDistrictFilter(cityFilter, districtFilter);

        postPurpose b = new postPurpose();
        b.preparePurposeFilter(purposeFilter);

        postCategory a = new postCategory();
        a.prepareCategoryFilter(categoryFilter);

        purposeFilter.setSelectedIndex(defaultSeletectedPurpose);
        categoryFilter.setSelectedIndex(defaultSeletectedCategory);

        sort.prepareSortFilter(sortFilter);

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
        jPanel3 = new javax.swing.JPanel();
<<<<<<< HEAD
        field_tim_kiem = new javax.swing.JTextField();
        btn_tim_kiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        purposeFilter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        categoryFilter = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cityFilter = new javax.swing.JComboBox<>();
=======
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
>>>>>>> 0261df956147336a8f2c94966217ebe311e3dcb0
        jLabel24 = new javax.swing.JLabel();
        cityFilter = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        districtFilter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        purposeFilter = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        categoryFilter = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        sortFilter = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

<<<<<<< HEAD
        field_tim_kiem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        field_tim_kiem.setText("Tìm kiếm");
        field_tim_kiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                field_tim_kiemMousePressed(evt);
            }
        });
        field_tim_kiem.addActionListener(new java.awt.event.ActionListener() {
=======
        jTextField6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField6.setText("Tìm kiem bai viet, danh muc bai viet");
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> 0261df956147336a8f2c94966217ebe311e3dcb0
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_tim_kiemActionPerformed(evt);
            }
        });

        btn_tim_kiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/876054.png"))); // NOI18N
        btn_tim_kiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tim_kiemActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 153));
        jLabel24.setText("Tình/Thành phố");

        cityFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        cityFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFilterActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 153));
        jLabel25.setText("Quận/Huyện");

        districtFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        districtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtFilterActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 153));
        jLabel8.setText("Mục đích");

        purposeFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        purposeFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trao tặng", "Xin nhận" }));
        purposeFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purposeFilterActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("Danh mục");

        categoryFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        categoryFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryFilterActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 153));
        jLabel26.setText("Xếp theo");

        sortFilter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        sortFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(districtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(purposeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

<<<<<<< HEAD
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(field_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(field_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
=======
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
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
>>>>>>> 0261df956147336a8f2c94966217ebe311e3dcb0
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void field_tim_kiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tim_kiemActionPerformed

    }//GEN-LAST:event_field_tim_kiemActionPerformed

    private void purposeFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purposeFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_purposeFilterActionPerformed

    private void categoryFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFilterActionPerformed
        //System.out.println("city " + cityFilter.getSelectedIndex() + " district " + districtFilter.getSelectedIndex() + " category " + categoryFilter.getSelectedIndex());
        this.preparePost();
    }//GEN-LAST:event_categoryFilterActionPerformed

    private void cityFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFilterActionPerformed
        //district.prepareDistrictFilter(cityFilter, districtFilter);
        this.preparePost();
        district.prepareDistrictFilter(cityFilter, districtFilter);
    }//GEN-LAST:event_cityFilterActionPerformed

    private void districtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_districtFilterActionPerformed

    private void sortFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_sortFilterActionPerformed

    private void btn_tim_kiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tim_kiemActionPerformed
        this.preparePost();
    }//GEN-LAST:event_btn_tim_kiemActionPerformed

    private void field_tim_kiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_tim_kiemMousePressed
        if (firstFill == 0) {
            firstFill = 1;
            field_tim_kiem.setText("");
        }
    }//GEN-LAST:event_field_tim_kiemMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tim_kiem;
    private javax.swing.JComboBox<String> categoryFilter;
    private javax.swing.JComboBox<String> cityFilter;
    private javax.swing.JComboBox<String> districtFilter;
    private javax.swing.JTextField field_tim_kiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JComboBox<String> purposeFilter;
    private javax.swing.JComboBox<String> sortFilter;
    // End of variables declaration//GEN-END:variables
}
