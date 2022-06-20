/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.trangCaNhan;

import static Process.image.scaleImage;
import Views.logIn_sigIn.quenMatKhau;
import Views.panel.bangXepHangNhanAi;
import Views.main.chuyenManHinhController;
import Views.main.danhMucBean;
import Views.main.imageHelper;
import Views.main.mainFrame;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class trangCaNhanJPanel extends javax.swing.JPanel {

    public void updateJLabel() {
        mainFrame.currentUser.loadUser(mainFrame.currentUser.getUserId());
        
        labelTen.setText(mainFrame.currentUser.getLastName());
        System.out.println(mainFrame.currentUser.getRoleId());
        if ((mainFrame.currentUser.getRoleId()).equals("1") == true) {
            labelVaiTro.setText("Người dùng");
        } else {
            labelVaiTro.setText("Quản trị viên");
        }
        labelDiem.setText(mainFrame.currentUser.getScore());
        Font font = labelDiem.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        labelDiem.setFont(font.deriveFont(attributes));

        //load ảnh
        byte[] imagedata = mainFrame.currentUser.getAvatar();
        if (imagedata != null) {
            ImageIcon format = new ImageIcon(imagedata);
            Image resize = imageHelper.reSize(format.getImage(), 130, 130);
            labelImage.setIcon(new ImageIcon(resize));
        } else {
            labelImage.setIcon(new ImageIcon(getClass().getResource("/Resource/images/size.png")));
        }
    }

    /**
     * Creates new form trangCaNhanJPanel
     */
    public trangCaNhanJPanel() {
        initComponents();
        updateJLabel();
        chuyenManHinhProfile profile = new chuyenManHinhProfile(jPanelProfile);
        profile.setView(jbtnBaiViet);

        List<danhMucBean> listItem = new ArrayList<>();
        listItem.add(new danhMucBean("BaiViet", jbtnBaiViet));
        listItem.add(new danhMucBean("ThongTin", jbtnThongTin));

        profile.setEvent(listItem);

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
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelProfile = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbtnBaiViet = new javax.swing.JButton();
        jbtnThongTin = new javax.swing.JButton();
        labelDiem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelTen = new javax.swing.JLabel();
        labelVaiTro = new javax.swing.JLabel();

        setBackground(new java.awt.Color(199, 234, 227));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(199, 234, 227));

        kGradientPanel2.setkEndColor(new java.awt.Color(126, 186, 181));
        kGradientPanel2.setkStartColor(new java.awt.Color(126, 186, 181));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANG CÁ NHÂN");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanelProfile.setBackground(new java.awt.Color(199, 234, 227));
        jPanelProfile.setOpaque(false);

        javax.swing.GroupLayout jPanelProfileLayout = new javax.swing.GroupLayout(jPanelProfile);
        jPanelProfile.setLayout(jPanelProfileLayout);
        jPanelProfileLayout.setHorizontalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanelProfileLayout.setVerticalGroup(
            jPanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(199, 234, 227));

        labelImage.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/size.png"))); // NOI18N
        labelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        labelImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelImageMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Điểm YT:");

        jbtnBaiViet.setBackground(new java.awt.Color(204, 204, 255));
        jbtnBaiViet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnBaiViet.setForeground(new java.awt.Color(0, 51, 153));
        jbtnBaiViet.setText("Bài viết");
        jbtnBaiViet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jbtnThongTin.setBackground(new java.awt.Color(255, 204, 204));
        jbtnThongTin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnThongTin.setForeground(new java.awt.Color(0, 51, 153));
        jbtnThongTin.setText("Giới thiệu");
        jbtnThongTin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        labelDiem.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelDiem.setForeground(new java.awt.Color(255, 51, 153));
        labelDiem.setText("100 điểm");
        labelDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelDiemMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Xin chào");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Vai trò:");

        jLabel7.setBackground(new java.awt.Color(255, 51, 102));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/reset-password.png"))); // NOI18N
        jLabel7.setText("Đổi mật khẩu");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/studying.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelTen.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTen.setText("jLabel3");

        labelVaiTro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelVaiTro.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDiem)
                            .addComponent(labelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelVaiTro)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jbtnBaiViet, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(201, 214, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelTen))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelDiem)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelVaiTro)))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnBaiViet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        //bật thông báo
        JOptionPane.showMessageDialog(this, "Mã khôi phục mật khẩu đã được gửi về email!");
        new quenMatKhau(mainFrame.currentUser.getEmail()).setVisible(true);
    }//GEN-LAST:event_jLabel7MousePressed

    private void labelImageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImageMousePressed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        if (f != null) {
            scaleImage(f.toString(), labelImage);
            try {
                mainFrame.currentUser.setAvatar(f);
            } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
                Logger.getLogger(trangCaNhanJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_labelImageMousePressed

    private void labelDiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDiemMousePressed
        try {
            chuyenManHinhController.setView(new bangXepHangNhanAi());
        } catch (SQLException ex) {
            Logger.getLogger(trangCaNhanJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(trangCaNhanJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelDiemMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelProfile;
    private javax.swing.JButton jbtnBaiViet;
    private javax.swing.JButton jbtnThongTin;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel labelDiem;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelTen;
    private javax.swing.JLabel labelVaiTro;
    // End of variables declaration//GEN-END:variables
}
