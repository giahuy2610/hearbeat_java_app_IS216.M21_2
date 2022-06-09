/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.danhChoAdmin;

import ConnectDB.TestConnectJDBC;
import Process.city;
import Process.district;
import Process.user;
import Views.main.testGetDBToTable;
import Views.trangCaNhan.trangCaNhanJPanel_ThongTin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class danhChoAdminJPanel_QLND extends javax.swing.JPanel {

    //private static String selectedUserId;
    private static user user01;
    private static int firstFill;
    private static boolean editable;
    private static String selectedBtn;
    private ArrayList<String> districtIdUser = new ArrayList<String>();

    /**
     * Creates new form danhChoAdminJPanel
     */
    private void loadData() {
        Connection conn = null;
        try {
            conn = TestConnectJDBC.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(testGetDBToTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testGetDBToTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "";
        synchronized (query) {
            query = "select * from tb_user order by userid";
        }
        try ( Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String row_temp[] = {rs.getString("userid"), rs.getString("lastname"), rs.getString("phone"), rs.getString("score"), rs.getString("roleid").equals("1") ? "Người dùng" : "Quản trị viên", rs.getString("isdeleted").equals("0") ? "Khả dụng" : "Đã xóa"};
                DefaultTableModel tblModel = (DefaultTableModel) tableUser.getModel();

                tblModel.addRow(row_temp);
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
        }

        city.prepareCityFilter(cbCity);
        district.prepareDistrictFilter(cbCity, cbDistrict);

        fieldLastName.setEditable(editable);
        fieldFirstName.setEditable(editable);
        fieldDateOfBirth.setEnabled(editable);
        fieldPhone.setEditable(editable);
        fieldEmail.setEditable(editable);
        fieldAddress.setEditable(editable);
        cbCity.setEnabled(editable);
        cbDistrict.setEnabled(editable);
        cbGender.setEnabled(editable);
    }

    private void clearField() {
        labelUserId.setText("Mã: ");
        labelRole.setText("Vai trò: ");
        labelScore.setText("Điểm: ");
        labelCreatedOn.setText("Ngày tạo: ");
        labelStatus.setText("Tình trạng: ");

        fieldLastName.setText("");
        fieldFirstName.setText("");
        fieldDateOfBirth.setEnabled(editable);
        fieldPhone.setText("");
        fieldEmail.setText("");
        fieldAddress.setText("");
    }

    public danhChoAdminJPanel_QLND() {
        initComponents();
        this.loadData();
        editable = false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        fieldFirstName = new javax.swing.JTextField();
        fieldLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldPhone = new javax.swing.JTextField();
        labelUserId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbDistrict = new javax.swing.JComboBox<>();
        fieldAddress = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelRole = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        labelCreatedOn = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        cbCity = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        fieldDateOfBirth = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        field_tim_kiem = new javax.swing.JTextField();
        btnModifyUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        fieldFirstName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFirstNameActionPerformed(evt);
            }
        });

        fieldLastName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldLastNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Tên");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Họ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Số điện thoại");

        fieldPhone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldPhone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPhoneActionPerformed(evt);
            }
        });

        labelUserId.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUserId.setText("Mã");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Email");

        fieldEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldEmailActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/avatarTest.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Quận");

        cbDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cbDistrict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDistrictActionPerformed(evt);
            }
        });

        fieldAddress.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fieldAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAddressActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Giới tính");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Ngày sinh");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        labelRole.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelRole.setText("Vai trò");

        labelScore.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelScore.setText("Điểm");

        labelCreatedOn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCreatedOn.setText("Ngày tạo");

        labelStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelStatus.setText("Tình trạng");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        cbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("Thành phố");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Địa chỉ");

        fieldDateOfBirth.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                fieldDateOfBirthAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        fieldDateOfBirth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fieldDateOfBirthPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCreatedOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelUserId)
                        .addGap(11, 11, 11)
                        .addComponent(labelRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCreatedOn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelStatus))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel20)
                                .addGap(11, 11, 11)
                                .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tableUser.setAutoCreateRowSorter(true);
        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Điện thoại", "Điểm", "Vai trò", "Tình trạng"
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
        jScrollPane2.setViewportView(tableUser);
        if (tableUser.getColumnModel().getColumnCount() > 0) {
            tableUser.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 51, 153));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/paper.png"))); // NOI18N
        btnSave.setText("Lưu thay đổi");
        btnSave.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

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

        btnAddUser.setBackground(new java.awt.Color(255, 255, 255));
        btnAddUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(0, 51, 153));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/studying.png"))); // NOI18N
        btnAddUser.setText("Thêm");
        btnAddUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnAddUser.setMaximumSize(new java.awt.Dimension(163, 40));
        btnAddUser.setMinimumSize(new java.awt.Dimension(163, 40));
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        field_tim_kiem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        field_tim_kiem.setForeground(new java.awt.Color(204, 204, 204));
        field_tim_kiem.setText("Tìm kiếm người dùng");
        field_tim_kiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        btnModifyUser.setBackground(new java.awt.Color(255, 255, 255));
        btnModifyUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnModifyUser.setForeground(new java.awt.Color(0, 51, 153));
        btnModifyUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/studying.png"))); // NOI18N
        btnModifyUser.setText("Sửa");
        btnModifyUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnModifyUser.setMaximumSize(new java.awt.Dimension(163, 40));
        btnModifyUser.setMinimumSize(new java.awt.Dimension(163, 40));
        btnModifyUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(0, 51, 153));
        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/paper.png"))); // NOI18N
        btnDeleteUser.setText("Xóa");
        btnDeleteUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(field_tim_kiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModifyUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_tim_kiem)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void fieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFirstNameActionPerformed

    private void fieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldLastNameActionPerformed

    private void fieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPhoneActionPerformed

    private void fieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldEmailActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (user01.getIsDeleted().equals("0")) {
            selectedBtn = "btnDeleteUser";
            String[] options = {"Đồng ý", "Hủy"};
            int output = JOptionPane.showOptionDialog(this,
                    "Bạn đang Xóa người dùng", "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (output == JOptionPane.YES_OPTION) {
                try {
                    user01.deletedUser();
                    JOptionPane.showMessageDialog(this, "Xóa người dùng thành công!");
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
            selectedBtn = "btnDeleteUser";
            String[] options = {"Đồng ý", "Hủy"};
            int output = JOptionPane.showOptionDialog(this,
                    "Bạn đang khôi phục lại tài khoản", "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (output == JOptionPane.YES_OPTION) {
                try {
                    user01.recoveryUser();
                    JOptionPane.showMessageDialog(this, "Khôi phục thành công!");
                    this.loadData();
                } catch (SQLException ex) {
                    Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (output == JOptionPane.NO_OPTION) {
                System.out.println("No selected.");
            }
        }

    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (firstFill == 0) {
            firstFill = 1;
            field_tim_kiem.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fieldAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAddressActionPerformed

    private void cbDistrictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDistrictActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDistrictActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableUserMouseClicked

    private void tableUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMousePressed
        DefaultTableModel tblModel = (DefaultTableModel) tableUser.getModel();

        String selectedUser = tblModel.getValueAt(tableUser.getSelectedRow(), 0).toString();//số 0 là số thứ tự cột
        user01 = new user(selectedUser);
        labelUserId.setText("Mã: " + user01.getUserId());
        labelRole.setText("Vai trò: " + (user01.getRoleId().equals("1") ? "Người dùng" : "Quản trị viên"));
        labelScore.setText("Điểm: " + user01.getScore());
        labelCreatedOn.setText("Ngày tạo: " + user01.getCreatedOn());
        labelStatus.setText("Tình trạng: " + (user01.getIsDeleted().equals("0") ? "Khả dụng" : "Đã xóa"));

        fieldLastName.setText(user01.getLastName());

        fieldFirstName.setText(user01.getFirstName());
        fieldDateOfBirth.setDateFormatString("dd/MM/yyyy");
        fieldDateOfBirth.setDate(user01.getDateOfBirth());
        fieldPhone.setText(user01.getPhone());
        fieldEmail.setText(user01.getEmail());

        cbGender.setSelectedIndex(Integer.parseInt(user01.getGender()) - 1);

        if (fieldAddress != null) {
            fieldAddress.setText(user01.getAddress());
        }
        if (user01.getCity() != null) {
            cbCity.setSelectedIndex(Integer.parseInt(user01.getCity()));
        } else {
            cbCity.setSelectedIndex(0);
        }
        if (user01.getDistrict() != null) {
            districtIdUser = district.prepareDistrictFilter(cbCity, cbDistrict);
            cbDistrict.setSelectedIndex(districtIdUser.indexOf(user01.getDistrict()));
        } else {
            cbDistrict.setSelectedIndex(0);
        }

        //nếu người dùng đã bị xóa tài khoản thì có thể khôi phục lại
        if (user01.getIsDeleted().equals("1")) {
            btnDeleteUser.setText("Khôi phục");
        } else {
            btnDeleteUser.setText("Xóa");
        }

    }//GEN-LAST:event_tableUserMousePressed

    private void fieldDateOfBirthAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_fieldDateOfBirthAncestorAdded

    }//GEN-LAST:event_fieldDateOfBirthAncestorAdded

    private void fieldDateOfBirthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fieldDateOfBirthPropertyChange

    }//GEN-LAST:event_fieldDateOfBirthPropertyChange

    private void btnModifyUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyUserActionPerformed
        editable = true;
        selectedBtn = "btnModifyUser";
        this.loadData();
        System.out.println(selectedBtn);
        btnSave.setEnabled(editable);
    }//GEN-LAST:event_btnModifyUserActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        switch (selectedBtn) {
            case "btnModifyUser": {
                String[] options = {"Đồng ý", "Hủy"};
                int output = JOptionPane.showOptionDialog(this,
                        "Bạn đang thay đổi thông tin người dùng", "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (output == JOptionPane.YES_OPTION) {
                    try {
                        //user01.modifiedUser(fieldFirstName.getText(), fieldLastName.getText(), Integer.toString(cbGender.selectedIndex() + 1), fieldDateOfBirth.getDate(), Integer.toString(cbCity.getSelectedIndex()), Integer.toString(cbDistrict.getSelectedIndex()), fieldAddress.getText());
                        //JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (output == JOptionPane.NO_OPTION) {
                    System.out.println("No selected.");
                }

                break;
            }
            case "btnDeleteUser": {

                break;
            }
            case "btnAddUser": {
                String[] options = {"Đồng ý", "Hủy"};
                int output = JOptionPane.showOptionDialog(this,
                        "Bạn đang thêm mới thông tin người dùng", "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (output == JOptionPane.YES_OPTION) {
                    try {

                        JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                    } catch (SQLException ex) {
                        Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(trangCaNhanJPanel_ThongTin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (output == JOptionPane.NO_OPTION) {
                    System.out.println("No selected.");
                }

                break;
            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        editable = true;
        this.loadData();
        this.clearField();
        selectedBtn = "btnAddUser";
        btnSave.setEnabled(editable);
    }//GEN-LAST:event_btnAddUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnModifyUser;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCity;
    private javax.swing.JComboBox<String> cbDistrict;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JTextField fieldAddress;
    private com.toedter.calendar.JDateChooser fieldDateOfBirth;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldFirstName;
    private javax.swing.JTextField fieldLastName;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JTextField field_tim_kiem;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCreatedOn;
    private javax.swing.JLabel labelRole;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelUserId;
    private javax.swing.JTable tableUser;
    // End of variables declaration//GEN-END:variables
}
