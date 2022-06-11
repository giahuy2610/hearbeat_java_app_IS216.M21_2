/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.danhChoAdmin;

import ConnectDB.OracleConnUtils;
import ConnectDB.TestConnectJDBC;
import Process.city;
import Process.district;
import Process.user;
import Views.main.imageHelper;
import Views.trangCaNhan.trangCaNhanJPanel_ThongTin;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class danhChoAdminJPanel_Report extends javax.swing.JPanel {

    //private static String selectedUserId;
    private static user user01;
    private static int firstFill = 0;
    private static String selectedBtn;
    private ArrayList<String> districtIdUser = new ArrayList<String>();

    /**
     * Creates new form danhChoAdminJPanel
     */
    private void enableAllBtn() {
        if (selectedBtn.equals("")) {
            btnModifyUser.setEnabled(true);
            btnAddUser.setEnabled(true);
            btnDeleteUser.setEnabled(true);
            btnSave.setEnabled(false);

            fieldLastName.setEditable(false);
            fieldFirstName.setEditable(false);
            fieldDateOfBirth.setEnabled(false);
            fieldAddress.setEditable(false);
            cbCity.setEnabled(false);
            cbDistrict.setEnabled(false);
            cbGender.setEnabled(false);
        } else if (selectedBtn.equals("btnAddUser") || selectedBtn.equals("btnModifyUser")) {
            btnModifyUser.setEnabled(false);
            btnAddUser.setEnabled(false);
            btnDeleteUser.setEnabled(false);
            btnSave.setEnabled(true);

            fieldLastName.setEditable(true);
            fieldFirstName.setEditable(true);
            fieldDateOfBirth.setEnabled(true);
            fieldAddress.setEditable(true);
            cbCity.setEnabled(true);
            cbDistrict.setEnabled(true);
            cbGender.setEnabled(true);
            if (selectedBtn.equals("btnAddUser")) {
                clearField();
                fieldFirstName.grabFocus();
                tableUser.setFocusable(false);
                fieldPhone.setEditable(true);
                fieldEmail.setEditable(true);

            } else {

            }

        } //người dùng ấn nút Lưu

    }

    private void loadData() {
        System.out.println("Đang thực hiện load data cho quản lí người dùng");
        Connection conn = null;
        try {
            conn = TestConnectJDBC.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
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

        tableUser.repaint();
        city.prepareCityFilter(cbCity);
        district.prepareDistrictFilter(cbCity, cbDistrict);

    }

    private void clearField() {
        labelUserId.setText("Mã: ");
        labelRole.setText("Vai trò: ");
        labelScore.setText("Điểm: ");
        labelCreatedOn.setText("Ngày tạo: ");
        labelStatus.setText("Tình trạng: ");

        fieldLastName.setText("");
        fieldFirstName.setText("");
        fieldDateOfBirth.setDate(null);
        cbGender.setSelectedIndex(0);
        fieldPhone.setText("");
        fieldEmail.setText("");
        fieldAddress.setText("");
    }

    public danhChoAdminJPanel_Report() {
        initComponents();
        selectedBtn = "";
        this.enableAllBtn();
        this.loadData();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel2.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(766, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
