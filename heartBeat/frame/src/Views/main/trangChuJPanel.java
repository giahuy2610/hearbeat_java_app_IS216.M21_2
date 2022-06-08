/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.main;

import ConnectDB.OracleConnUtils;
import Process.city;
import Process.district;
import Process.postCategory;
import Process.postPurpose;
import Process.sort;
import static Views.main.setValue.postColor1;
import static Views.main.setValue.postColor2;
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

    private static ArrayList<String> postId = new ArrayList<String>();
    private static ArrayList<String> postTitle = new ArrayList<String>();
    private static ArrayList<String> postCategory = new ArrayList<String>();
    private static ArrayList<String> postContent = new ArrayList<String>();
    private static ArrayList<String> postPurpose = new ArrayList<String>();
    private static ArrayList<String> postCreatedOn = new ArrayList<String>();

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
            query += " order by createdon";
        } else {
            query += " order by createdon desc";
        }

        System.out.println(query);
 
        return query;
    }

    private void preparePost() {
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
            postPurpose.removeAll(postPurpose);
            postCreatedOn.removeAll(postCreatedOn);
            int count = 0;
            while (rs.next()) {
                postId.add(rs.getString("postid"));
                postTitle.add(rs.getString("title"));
                postCategory.add(rs.getString("categoryid"));
                postContent.add(rs.getString("content"));
                postCreatedOn.add(rs.getString("createdon"));
                postPurpose.add(rs.getString("purposeid"));
                //System.out.println("1 bài viết " + rs.getString("title") + " " + rs.getString("content"));
                count++;
            }
            conn.close();

            for (int i = 0; i < count; i++) {
                baiVietJPanel x = new baiVietJPanel(postId.get(i), postTitle.get(i), postCategory.get(i), postContent.get(i), postPurpose.get(i), postCreatedOn.get(i));
                if (i % 2 == 0) {
                    x.changeBackgroundColor(postColor1);
                } else {
                    x.changeBackgroundColor(postColor2);
                }
                container.add(x);
                //System.out.println("2bài viết " + postTitle.get(i) + " - " + postContent.get(i));
            }
            jScrollPane1.setViewportView(container);
     System.out.println("count " + Integer.toString(count));
        System.out.println(Integer.toString(postId.size()) + Integer.toString(postTitle.size()) + Integer.toString(postContent.size()) + Integer.toString(postCategory.size()) + Integer.toString(postPurpose.size()));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    public trangChuJPanel() {
        initComponents();
        firstFill = 0;
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

        header = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        field_tim_kiem = new javax.swing.JTextField();
        btn_tim_kiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
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

        header.setkEndColor(new java.awt.Color(199, 234, 227));
        header.setkStartColor(new java.awt.Color(199, 234, 227));

        jLabel1.setBackground(new java.awt.Color(255, 230, 236));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("TRANG CHỦ");

        field_tim_kiem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        field_tim_kiem.setText("Tìm kiếm");
        field_tim_kiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                field_tim_kiemMousePressed(evt);
            }
        });
        field_tim_kiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_tim_kiemActionPerformed(evt);
            }
        });

        btn_tim_kiem.setBackground(new java.awt.Color(126, 186, 181));
        btn_tim_kiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\giahu\\Downloads\\search.png")); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(field_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tim_kiem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_tim_kiem)
                    .addComponent(btn_tim_kiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(199, 234, 227));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 546));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jScrollPane1.setBackground(new java.awt.Color(199, 234, 227));

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

        jPanel3.setBackground(new java.awt.Color(199, 234, 227));

        jPanel4.setBackground(new java.awt.Color(126, 186, 181));
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

        jLabel26.setText("Thời gian");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(districtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purposeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
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
                    .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sortFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_sortFilterActionPerformed

    private void categoryFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFilterActionPerformed
        //System.out.println("city " + cityFilter.getSelectedIndex() + " district " + districtFilter.getSelectedIndex() + " category " + categoryFilter.getSelectedIndex());
        this.preparePost();
    }//GEN-LAST:event_categoryFilterActionPerformed

    private void purposeFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purposeFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_purposeFilterActionPerformed

    private void field_tim_kiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_tim_kiemActionPerformed

    }//GEN-LAST:event_field_tim_kiemActionPerformed

    private void field_tim_kiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_tim_kiemMousePressed
        if (firstFill == 0) {
            firstFill = 1;
            field_tim_kiem.setText("");
        }
    }//GEN-LAST:event_field_tim_kiemMousePressed

    private void districtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtFilterActionPerformed
        this.preparePost();
    }//GEN-LAST:event_districtFilterActionPerformed

    private void cityFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFilterActionPerformed

        this.preparePost();
        district.prepareDistrictFilter(cityFilter, districtFilter);
    }//GEN-LAST:event_cityFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_tim_kiem;
    private javax.swing.JComboBox<String> categoryFilter;
    private javax.swing.JComboBox<String> cityFilter;
    private javax.swing.JComboBox<String> districtFilter;
    private javax.swing.JTextField field_tim_kiem;
    private keeptoo.KGradientPanel header;
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
    private javax.swing.JComboBox<String> purposeFilter;
    private javax.swing.JComboBox<String> sortFilter;
    // End of variables declaration//GEN-END:variables
}
