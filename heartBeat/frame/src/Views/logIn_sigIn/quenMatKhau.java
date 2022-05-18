/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.logIn_sigIn;

import java.awt.Color;
import Views.javaMail.JavaMailUtil;
import Views.javaMail.RandomStringGenerator;
import static Views.javaMail.RandomStringGenerator.randomAlphaNumeric;
import static Views.javaMail.JavaMailUtil.sendMail;
import connect.OracleConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class quenMatKhau extends javax.swing.JFrame {

    private String auth_code;
    private String email;

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        return OracleConnUtils.getOracleConnection();
    }

    /**
     * Creates new form quenMatKhau
     */
    public quenMatKhau(String email) {

        initComponents();
        this.setLocationRelativeTo(null);
        jLabel11.setVisible(false);
        jLabel11.setText("Vui lòng điền mã khôi phục");
        jLabel11.setForeground(Color.red);

        jLabel12.setVisible(false);
        jLabel12.setText("Vui lòng điền mật khẩu");
        jLabel12.setForeground(Color.red);
        this.email = email;
        auth_code = randomAlphaNumeric(8);

        sendMail(email, auth_code);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panel_nhap_ma = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        jLabel2.setText("Mã khôi phục:");

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        panel_nhap_ma.setkEndColor(new java.awt.Color(153, 153, 255));
        panel_nhap_ma.setkStartColor(new java.awt.Color(238, 156, 167));
        panel_nhap_ma.setPreferredSize(new java.awt.Dimension(450, 600));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã khôi phục:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Đặt lại mật khẩu");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Xác nhận");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel11");

        javax.swing.GroupLayout panel_nhap_maLayout = new javax.swing.GroupLayout(panel_nhap_ma);
        panel_nhap_ma.setLayout(panel_nhap_maLayout);
        panel_nhap_maLayout.setHorizontalGroup(
            panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nhap_maLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(panel_nhap_maLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_nhap_maLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_nhap_maLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_nhap_maLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panel_nhap_maLayout.setVerticalGroup(
            panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_nhap_maLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel11)
                .addGap(60, 60, 60)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
            .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_nhap_maLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_nhap_maLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel1))
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(panel_nhap_maLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_nhap_maLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel3))
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 132, Short.MAX_VALUE)))
        );

        jLayeredPane1.add(panel_nhap_ma, "card2");
        panel_nhap_ma.getAccessibleContext().setAccessibleName("Khôi phục mật khẩu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (jTextField1.getText().equals("") || jTextField3.getText().equals("")) {
            if (jTextField1.getText().equals("")) {
                jLabel11.setVisible(true);
            } else {
                jLabel11.setVisible(false);
            }
            if (jTextField3.getText().equals("")) {
                jLabel12.setVisible(true);
            } else {
                jLabel12.setVisible(false);
                System.out.println("false");
            }
        } else {

            if (!jTextField1.getText().equals(this.auth_code)) {
                JOptionPane.showMessageDialog(null, "Mã khôi phục không đúng! Hệ thống đã gửi lại mã mới, vui lòng nhập lại!", "", JOptionPane.INFORMATION_MESSAGE);
                jTextField1.setText("");
                jTextField3.setText("");
            } else {
                Connection conn = null;
                try {
                    conn = quenMatKhau.getConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(dangKy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dangKy.class.getName()).log(Level.SEVERE, null, ex);
                }
                String query = "";
                synchronized (query) {
                    query = "update tb_user set password = '" + jTextField3.getText() + "' where email = '" + this.email + "'";
                    System.out.println(query);
                }
                try ( Statement stmt = conn.createStatement()) {
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu thành công!", "", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        new dangNhap().setVisible(true);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quenMatKhau("test").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private keeptoo.KGradientPanel panel_nhap_ma;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    // End of variables declaration//GEN-END:variables
}
