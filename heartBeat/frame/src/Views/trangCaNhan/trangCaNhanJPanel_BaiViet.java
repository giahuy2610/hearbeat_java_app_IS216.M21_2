/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.trangCaNhan;

import ConnectDB.OracleConnUtils;
import static Process.postStatus.getStatusNameFromId;
import Process.sort;
import Views.panel.baiVietJPanel;
import Views.main.mainFrame;
import static Views.main.setValue.postColor1;
import static Views.main.setValue.postColor2;
import Views.panel.trangChuJPanel;
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
public class trangCaNhanJPanel_BaiViet extends trangChuJPanel {

    private ArrayList<String> postId = new ArrayList<String>();
    private ArrayList<String> postTitle = new ArrayList<String>();
    private ArrayList<String> postCategory = new ArrayList<String>();
    private ArrayList<String> postContent = new ArrayList<String>();
    private ArrayList<String> postPurpose = new ArrayList<String>();
    private ArrayList<String> postCreatedOn = new ArrayList<String>();
    private ArrayList<String> postStatus = new ArrayList<String>();
    private ArrayList<byte[]> postImage = new ArrayList<byte[]>();
    private int firstFill = 0;
    private int firstLoad = 0;

    protected String initQuery1() {
        if (firstFill == 0) {
            query = "select * from  tb_post where ownerid = " + mainFrame.currentUser.getUserId();
        } else {
            query = "select * from  tb_post where ownerid = " + mainFrame.currentUser.getUserId() + " and ( upper(title) like upper('%" + searchField.getText() + "%') or upper(content) like upper('%" + searchField.getText() + "%'))";
        }

        if (postStatusFilter != null) {
            if (postStatusFilter.getSelectedIndex() > 0 && postStatusFilter.getSelectedIndex() < 4) {
                query += " and statusid = " + postStatusFilter.getSelectedIndex();
            } else if (postStatusFilter.getSelectedIndex() == 4) {
                query += " and isdeleted = 1";
            } else if (postStatusFilter.getSelectedIndex() == 5) {
                //lấy ra bài viết bản thân đã đặt hẹn
                query = "select * from  tb_post where partnerid = " + mainFrame.currentUser.getUserId();
            }

            if (postSortFilter.getSelectedIndex() == 0) {
                query += " order by createdon desc";
            } else {
                query += " order by createdon";
            }
        }
        return query;
    }

    public trangCaNhanJPanel_BaiViet() {
        initComponents();
        firstFill = 0;
        sort.prepareSortFilter(postSortFilter);
        postSortFilter.setSelectedIndex(0);
        this.preparePost();
        firstLoad = 1;
    }

    private void preparePost() {
        try {
            conn = OracleConnUtils.getOracleConnection();
            query = initQuery1();
            System.out.println("trang cá nhân đang chạy query " + query);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            container.removeAll();

            postId.removeAll(postId);
            postTitle.removeAll(postTitle);
            postCategory.removeAll(postCategory);
            postContent.removeAll(postContent);
            postCreatedOn.removeAll(postCreatedOn);
            postImage.removeAll(postImage);
            postPurpose.removeAll(postPurpose);
            postStatus.removeAll(postStatus);
            while (rs.next()) {
                postId.add(rs.getString("postid"));
                postTitle.add(rs.getString("title"));
                postCategory.add(rs.getString("categoryid"));
                postContent.add(rs.getString("content"));
                postCreatedOn.add(rs.getString("createdon"));
                postPurpose.add(rs.getString("purposeid"));
                postImage.add(rs.getBytes("imagepath"));
                postStatus.add(rs.getString("statusid"));
            }
            conn.close();
            int count = postId.size();
            for (int i = 0; i < count; i++) {
                baiVietJPanel x = new baiVietJPanel(postId.get(i), postTitle.get(i), postCategory.get(i), postContent.get(i), postPurpose.get(i), postCreatedOn.get(i), getStatusNameFromId(postStatus.get(i)), postImage.get(i));
                if (i % 2 == 0) {
                    x.changeBackgroundColor(postColor1);
                } else {
                    x.changeBackgroundColor(postColor2);
                }
                container.add(x);
            }
            if (count < 2 && count > 0) {
                for (; count < 2; count++) {
                    baiVietJPanel x = new baiVietJPanel();
                    container.add(x);
                }
            }
            jScrollPanePost.setViewportView(container);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(trangChuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelProfile = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        postStatusFilter = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        postSortFilter = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jScrollPanePost = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(1000, 360));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(989, 370));

        jPanelProfile.setBackground(new java.awt.Color(199, 234, 227));
        jPanelProfile.setPreferredSize(new java.awt.Dimension(995, 380));

        jPanel17.setBackground(new java.awt.Color(126, 186, 181));

        searchField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText(" Tìm kiếm bài viết");
        searchField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchFieldMousePressed(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 204, 204));
        btnSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 51, 153));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/search_1.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        postStatusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả của tôi", "Bài của tôi đang chờ", "Bài của tôi có hẹn", "Bài của tôi thành công", "Bài của tôi đã xóa", "Tôi có hẹn với" }));
        postStatusFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postStatusFilterActionPerformed(evt);
            }
        });

        jLabel9.setText("Phân loại");

        postSortFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postSortFilterActionPerformed(evt);
            }
        });

        jLabel26.setText("Xếp theo");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(jLabel9)
                .addGap(48, 48, 48)
                .addComponent(postStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(postSortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(postSortFilter, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(searchField)
                            .addComponent(postStatusFilter)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jScrollPanePost.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePost.setMaximumSize(new java.awt.Dimension(985, 32767));

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPanePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfileLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanePost, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void postStatusFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postStatusFilterActionPerformed
        if (firstLoad != 0)
            this.preparePost();
    }//GEN-LAST:event_postStatusFilterActionPerformed

    private void postSortFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postSortFilterActionPerformed
        if (firstLoad != 0)
            this.preparePost();
    }//GEN-LAST:event_postSortFilterActionPerformed

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed
        if (firstFill == 0) {
            searchField.setText("");
            firstFill = 1;
        }
    }//GEN-LAST:event_searchFieldMousePressed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.preparePost();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            this.preparePost();
        }
    }//GEN-LAST:event_searchFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JScrollPane jScrollPanePost;
    private javax.swing.JComboBox<String> postSortFilter;
    private javax.swing.JComboBox<String> postStatusFilter;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
