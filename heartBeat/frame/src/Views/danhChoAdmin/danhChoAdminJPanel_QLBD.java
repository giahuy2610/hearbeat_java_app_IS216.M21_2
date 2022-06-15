/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.danhChoAdmin;

import ConnectDB.TestConnectJDBC;
import Process.post;
import static Process.postCategory.prepareCategoryFilter;
import static Process.postPurpose.preparePurposeFilter;
import static Process.postStatus.getStatusNameFromId;
import Views.main.chuyenManHinhController;
import Views.main.imageHelper;
import Views.main.themBaiVietJPanel;
import Views.trangCaNhan.trangCaNhanJPanel_ThongTin;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class danhChoAdminJPanel_QLBD extends javax.swing.JPanel {

    //private static String selectedUserId;
    private post post01;
    private int firstFill = 0;
    private String selectedBtn;
    private ArrayList<String> districtIdUser = new ArrayList<String>();
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    /**
     * Creates new form danhChoAdminJPanel
     */
    private boolean isNumeric(String str) {
        if (str == null) return false;
        return pattern.matcher(str).matches();
    }
    /**
     * Creates new form danhChoAdminJPanel
     */
    private void enableAllBtn() {
        if (selectedBtn.equals("")) {
            btnAddPost.setEnabled(true);
            btnDeletePost.setEnabled(true);

            fieldContent.setEditable(false);
            fieldTitle.setEditable(false);
            cbPurpose.setEnabled(false);
            cbCategory.setEnabled(false);
        } else if (selectedBtn.equals("btnAddPost") || selectedBtn.equals("btnModifyPost")) {
            btnAddPost.setEnabled(false);
            btnDeletePost.setEnabled(false);

            fieldContent.setEditable(true);
            fieldTitle.setEditable(true);
            cbPurpose.setEnabled(true);
            cbCategory.setEnabled(true);
            if (selectedBtn.equals("btnAddPost")) {
                clearField();
                fieldTitle.grabFocus();
                tableUser.setFocusable(false);
            } else {

            }

        } //người dùng ấn nút Lưu

    }

    private void loadData() {
        Connection conn = null;
        try {
            conn = TestConnectJDBC.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_QLBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(danhChoAdminJPanel_QLBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "";
        synchronized (query) {
            query = "select * from tb_post order by postid";
            if (firstFill == 1) {
                if (isNumeric(fieldSearch.getText())) {
                    query = "select * from tb_post where postid = " + fieldSearch.getText() + " or upper(title) like upper('%"+ fieldSearch.getText() +"%') or upper(content) like upper('%"+ fieldSearch.getText() +"%') order by postid";
                }
                else {
                    query = "select * from tb_post where upper(title) like upper('%"+ fieldSearch.getText() +"%') or upper(content) like upper('%"+ fieldSearch.getText() +"%') order by postid";
                }
            }
        }
        System.out.println("Đang thực hiện load data cho quản lí  bài đăng: "+query);
        
        DefaultTableModel tblModel = (DefaultTableModel) tableUser.getModel();
        tblModel.setRowCount(0);
        try ( Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String row_temp[] = {rs.getString("postid"), rs.getString("title"), rs.getString("isdeleted").equals("0") ? "Khả dụng" : "Đã xóa"};
                

                tblModel.addRow(row_temp);
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
        }

        preparePurposeFilter(cbPurpose);
        prepareCategoryFilter(cbCategory);

    }

    private void clearField() {
        labelUserId.setText("Mã: ");
        labelCreatedOn.setText("Ngày tạo: ");
        labelIsDeleted.setText("Tình trạng: ");
        labelStatus.setText("Trạng thái bài viết: ");
        fieldContent.setText("");
        fieldTitle.setText("");
    }

    public danhChoAdminJPanel_QLBD() {
        initComponents();
        selectedBtn = "";
        this.enableAllBtn();
        this.loadData();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        fieldTitle = new javax.swing.JTextField();
        fieldContent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPurpose = new javax.swing.JLabel();
        labelUserId = new javax.swing.JLabel();
        labelCategory = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        labelCreatedOn = new javax.swing.JLabel();
        labelIsDeleted = new javax.swing.JLabel();
        cbPurpose = new javax.swing.JComboBox<>();
        labelStatus = new javax.swing.JLabel();
        labelOwner = new javax.swing.JLabel();
        labelPartner = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        btnAddPost = new javax.swing.JButton();
        fieldSearch = new javax.swing.JTextField();
        btnDeletePost = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel2.setBackground(new java.awt.Color(199, 234, 227));

        fieldTitle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTitleActionPerformed(evt);
            }
        });

        fieldContent.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldContent.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContentActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nội dung");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Tiêu đề");

        labelPurpose.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPurpose.setText("Mục đích");

        labelUserId.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUserId.setText("Mã");

        labelCategory.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCategory.setText("Danh mục");

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/size.png"))); // NOI18N
        labelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelCreatedOn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCreatedOn.setText("Ngày tạo");

        labelIsDeleted.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelIsDeleted.setText("Tình trạng");

        cbPurpose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cbPurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPurposeActionPerformed(evt);
            }
        });

        labelStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelStatus.setText("Trạng thái bài viết");

        labelOwner.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelOwner.setText("ID Chủ bài viết:");

        labelPartner.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPartner.setText("ID Người hẹn:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPartner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(fieldContent, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCreatedOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelIsDeleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPurpose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(569, 569, 569))
                            .addComponent(cbPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelUserId)
                        .addGap(10, 10, 10)
                        .addComponent(labelCreatedOn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(10, 10, 10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldContent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(fieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPurpose)
                            .addComponent(labelCategory))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelIsDeleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(labelPartner)
                    .addComponent(labelOwner))
                .addGap(25, 25, 25))
        );

        jPanel1.setBackground(new java.awt.Color(199, 234, 227));

        tableUser.setAutoCreateRowSorter(true);
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tiêu đề", "Tình trạng"
            }
        ));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableUserMousePressed(evt);
            }
        });
        tableUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableUserKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableUser);
        if (tableUser.getColumnModel().getColumnCount() > 0) {
            tableUser.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(199, 234, 227));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 153));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/search_1.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAddPost.setBackground(new java.awt.Color(255, 255, 255));
        btnAddPost.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddPost.setForeground(new java.awt.Color(0, 51, 153));
        btnAddPost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/studying.png"))); // NOI18N
        btnAddPost.setText("Thêm");
        btnAddPost.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnAddPost.setMaximumSize(new java.awt.Dimension(163, 40));
        btnAddPost.setMinimumSize(new java.awt.Dimension(163, 40));
        btnAddPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPostActionPerformed(evt);
            }
        });

        fieldSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        fieldSearch.setText("Tìm kiếm bài viết");
        fieldSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        fieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fieldSearchMousePressed(evt);
            }
        });
        fieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSearchActionPerformed(evt);
            }
        });
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSearchKeyPressed(evt);
            }
        });

        btnDeletePost.setBackground(new java.awt.Color(255, 255, 255));
        btnDeletePost.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeletePost.setForeground(new java.awt.Color(0, 51, 153));
        btnDeletePost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/paper.png"))); // NOI18N
        btnDeletePost.setText("Xóa");
        btnDeletePost.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDeletePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(12, 12, 12))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldSearch)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddPost, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDeletePost, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTitleActionPerformed

    private void fieldContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContentActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableUserMouseClicked

    private void tableUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMousePressed
        selectedBtn = "";
        enableAllBtn();

        DefaultTableModel tblModel = (DefaultTableModel) tableUser.getModel();

        String selectedUser = tblModel.getValueAt(tableUser.getSelectedRow(), 0).toString();//số 0 là số thứ tự cột
        post01 = new post(selectedUser);
        labelUserId.setText("Mã: " + post01.getPostId());
        labelCreatedOn.setText("Ngày tạo: " + post01.getCreatedOn());
        labelIsDeleted.setText("Tình trạng: " + (post01.getIsDeleted().equals("0") ? "Khả dụng" : "Đã xóa"));
        labelStatus.setText("Trạng thái bài viết: " + getStatusNameFromId(post01.getStatusId()));
        labelOwner.setText("ID Chủ bài viết: " + post01.getOwnerId());
        if (post01.getPartnerId() != null) {
            labelPartner.setText("ID Người hẹn: " + post01.getPartnerId());
        } else {
            labelPartner.setText("ID Người hẹn: ");
        }
        //load ảnh
        byte[] imagedata = post01.getImagePath();
        if (imagedata != null) {
            ImageIcon format = new ImageIcon(imagedata);
            Image resize = imageHelper.reSize(format.getImage(), 130, 130);
            labelImage.setIcon(new ImageIcon(resize));
        } else {
            labelImage.setIcon(new ImageIcon(getClass().getResource("/Resource/images/size.png")));
        }

        fieldContent.setText(post01.getContent());

        fieldTitle.setText(post01.getTitle());
        cbCategory.setSelectedIndex(Integer.valueOf(post01.getCategoryId()));
        cbPurpose.setSelectedIndex(Integer.valueOf(post01.getPurposeId()));
        System.out.println("Category " + post01.getCategoryId());
        //nếu người dùng đã bị xóa tài khoản thì có thể khôi phục lại
        if (post01.getIsDeleted().equals("1")) {
            btnDeletePost.setText("Khôi phục");
        } else {
            btnDeletePost.setText("Xóa");
        }

    }//GEN-LAST:event_tableUserMousePressed

    private void btnAddPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPostActionPerformed
        chuyenManHinhController.setView(new themBaiVietJPanel());

    }//GEN-LAST:event_btnAddPostActionPerformed

    private void fieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSearchActionPerformed

    }//GEN-LAST:event_fieldSearchActionPerformed

    private void fieldSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldSearchMousePressed
        if (firstFill == 0) {
            fieldSearch.setText("");
            firstFill = 1;
        }
    }//GEN-LAST:event_fieldSearchMousePressed

    private void cbPurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPurposeActionPerformed

    }//GEN-LAST:event_cbPurposeActionPerformed

    private void tableUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableUserKeyReleased
        selectedBtn = "";
        enableAllBtn();

        DefaultTableModel tblModel = (DefaultTableModel) tableUser.getModel();

        String selectedUser = tblModel.getValueAt(tableUser.getSelectedRow(), 0).toString();//số 0 là số thứ tự cột
        post01 = new post(selectedUser);
        labelUserId.setText("Mã: " + post01.getPostId());
        labelCreatedOn.setText("Ngày tạo: " + post01.getCreatedOn());
        labelIsDeleted.setText("Tình trạng: " + (post01.getIsDeleted().equals("0") ? "Khả dụng" : "Đã xóa"));
        labelStatus.setText("Trạng thái bài viết: " + getStatusNameFromId(post01.getStatusId()));
        labelOwner.setText("ID Chủ bài viết: " + post01.getOwnerId());
        if (post01.getPartnerId() != null) {
            labelPartner.setText("ID Người hẹn: " + post01.getPartnerId());
        } else {
            labelPartner.setText("ID Người hẹn: Chưa có");
        }
        //load ảnh
        byte[] imagedata = post01.getImagePath();
        if (imagedata != null) {
            ImageIcon format = new ImageIcon(imagedata);
            Image resize = imageHelper.reSize(format.getImage(), 130, 130);
            labelImage.setIcon(new ImageIcon(resize));
        } else {
            labelImage.setIcon(new ImageIcon(getClass().getResource("/Resource/images/size.png")));
        }

        fieldContent.setText(post01.getContent());

        fieldTitle.setText(post01.getTitle());
        cbCategory.setSelectedIndex(Integer.valueOf(post01.getCategoryId()));
        cbPurpose.setSelectedIndex(Integer.valueOf(post01.getPurposeId()));
        System.out.println("Category " + post01.getCategoryId());
        //nếu người dùng đã bị xóa tài khoản thì có thể khôi phục lại
        if (post01.getIsDeleted().equals("1")) {
            btnDeletePost.setText("Khôi phục");
        } else {
            btnDeletePost.setText("Xóa");
        }

    }//GEN-LAST:event_tableUserKeyReleased

    private void btnDeletePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePostActionPerformed
        if (post01.getIsDeleted().equals("0")) {
            selectedBtn = "btnDeletePost";
            String[] options = {"Đồng ý", "Hủy"};
            int output = JOptionPane.showOptionDialog(this,
                    "Bài viết sẽ bị xóa", "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (output == JOptionPane.YES_OPTION) {
                try {
                    post01.deletedPost();
                    JOptionPane.showMessageDialog(this, "Xóa bài viết thành công!");
                    this.loadData();
                } catch (SQLException ex) {
                    Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (output == JOptionPane.NO_OPTION) {
                System.out.println("No selected.");
            }
        } else {
            selectedBtn = "btnDeletePost";
            String[] options = {"Đồng ý", "Hủy"};
            int output = JOptionPane.showOptionDialog(this,
                    "Bạn đang khôi phục lại bài viết bị xóa", "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (output == JOptionPane.YES_OPTION) {
                try {
                    post01.recoveryPost();
                } catch (SQLException ex) {
                    Logger.getLogger(danhChoAdminJPanel_QLBD.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(danhChoAdminJPanel_QLBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Khôi phục bài viết thành công!");
                this.loadData();

            } else if (output == JOptionPane.NO_OPTION) {
                System.out.println("No selected.");
            }
        }
    }//GEN-LAST:event_btnDeletePostActionPerformed

    private void fieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyPressed
        if (evt.getKeyCode()==10) {
            this.loadData();
        }
    }//GEN-LAST:event_fieldSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPost;
    private javax.swing.JButton btnDeletePost;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbPurpose;
    private javax.swing.JTextField fieldContent;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JTextField fieldTitle;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelCreatedOn;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelIsDeleted;
    private javax.swing.JLabel labelOwner;
    private javax.swing.JLabel labelPartner;
    private javax.swing.JLabel labelPurpose;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelUserId;
    private javax.swing.JTable tableUser;
    // End of variables declaration//GEN-END:variables
}
