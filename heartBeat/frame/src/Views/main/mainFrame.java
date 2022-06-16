/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.main;

import Process.user;
import Views.logIn_sigIn.dangNhap;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author giahu
 */
public class mainFrame extends javax.swing.JFrame {

    private static chuyenManHinhController controller;
    public static user currentUser = new user();

    /**
     * Creates new form mainFrame
     */
    public mainFrame(String currentUserId) {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("HeartBeat");

        currentUser.loadUser(currentUserId);
        System.out.println(currentUser.getUserId());

        controller = new chuyenManHinhController(jpnView);

        List<danhMucBean> listItem = new ArrayList<>();
        listItem.add(new danhMucBean("TrangChu", jbtnTrangChu));
        listItem.add(new danhMucBean("ThemBaiViet", jbtnThemBaiViet));
        listItem.add(new danhMucBean("ThongBao", jbtnThongBao));
        listItem.add(new danhMucBean("DanhMuc", jbtnDanhMuc));
        listItem.add(new danhMucBean("TrangCaNhan", jbtnTrangCaNhan));
        //nếu người dùng này không phải admin thì không hiện ra trang admin
        if (currentUser.getRoleId().equals("2")) {
            listItem.add(new danhMucBean("DanhChoAdmin", jbtnDanhChoAdmin));
        } else {
            jbtnDanhChoAdmin.setVisible(false);
        }
        controller.setEvent(listItem);
        chuyenManHinhController.setView(new trangChuJPanel());
    }

    public chuyenManHinhController getController() {
        return controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new keeptoo.KGradientPanel();
        jButton6 = new javax.swing.JButton();
        jbtnDanhChoAdmin = new javax.swing.JButton();
        jbtnTrangChu = new javax.swing.JButton();
        jbtnThemBaiViet = new javax.swing.JButton();
        jbtnThongBao = new javax.swing.JButton();
        jbtnDanhMuc = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jbtnTrangCaNhan = new javax.swing.JButton();
        jpnView = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jpnRoot.setPreferredSize(new java.awt.Dimension(1200, 600));

        jpnMenu.setkEndColor(new java.awt.Color(104, 167, 173));
        jpnMenu.setkStartColor(new java.awt.Color(104, 167, 173));
        jpnMenu.setPreferredSize(new java.awt.Dimension(200, 600));

        jButton6.setBackground(new java.awt.Color(102, 255, 51));
        jButton6.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/heartbeat4.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jbtnDanhChoAdmin.setBackground(new java.awt.Color(199, 234, 227));
        jbtnDanhChoAdmin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnDanhChoAdmin.setForeground(new java.awt.Color(51, 51, 51));
        jbtnDanhChoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/admin.png"))); // NOI18N
        jbtnDanhChoAdmin.setText("Quản trị viên");
        jbtnDanhChoAdmin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnDanhChoAdmin.setContentAreaFilled(false);
        jbtnDanhChoAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnDanhChoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDanhChoAdminActionPerformed(evt);
            }
        });

        jbtnTrangChu.setBackground(new java.awt.Color(199, 234, 227));
        jbtnTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnTrangChu.setForeground(new java.awt.Color(51, 51, 51));
        jbtnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/home (2).png"))); // NOI18N
        jbtnTrangChu.setText(" Trang chủ");
        jbtnTrangChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnTrangChu.setContentAreaFilled(false);
        jbtnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTrangChuActionPerformed(evt);
            }
        });

        jbtnThemBaiViet.setBackground(new java.awt.Color(199, 234, 227));
        jbtnThemBaiViet.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnThemBaiViet.setForeground(new java.awt.Color(51, 51, 51));
        jbtnThemBaiViet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/love-letter.png"))); // NOI18N
        jbtnThemBaiViet.setText("Đăng bài");
        jbtnThemBaiViet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnThemBaiViet.setContentAreaFilled(false);
        jbtnThemBaiViet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnThemBaiViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemBaiVietActionPerformed(evt);
            }
        });

        jbtnThongBao.setBackground(new java.awt.Color(199, 234, 227));
        jbtnThongBao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnThongBao.setForeground(new java.awt.Color(51, 51, 51));
        jbtnThongBao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/love-letter (1).png"))); // NOI18N
        jbtnThongBao.setText("Thông báo");
        jbtnThongBao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnThongBao.setContentAreaFilled(false);
        jbtnThongBao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnThongBao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThongBaoActionPerformed(evt);
            }
        });

        jbtnDanhMuc.setBackground(new java.awt.Color(199, 234, 227));
        jbtnDanhMuc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnDanhMuc.setForeground(new java.awt.Color(51, 51, 51));
        jbtnDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/wish-list.png"))); // NOI18N
        jbtnDanhMuc.setText("Danh mục");
        jbtnDanhMuc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnDanhMuc.setContentAreaFilled(false);
        jbtnDanhMuc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDanhMucActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(199, 234, 227));
        jButton12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 51));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/enter.png"))); // NOI18N
        jButton12.setText(" Đăng xuất");
        jButton12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jButton12.setContentAreaFilled(false);
        jButton12.setHideActionText(true);
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jbtnTrangCaNhan.setBackground(new java.awt.Color(199, 234, 227));
        jbtnTrangCaNhan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtnTrangCaNhan.setForeground(new java.awt.Color(51, 51, 51));
        jbtnTrangCaNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/boy.png"))); // NOI18N
        jbtnTrangCaNhan.setText("Cá nhân");
        jbtnTrangCaNhan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jbtnTrangCaNhan.setContentAreaFilled(false);
        jbtnTrangCaNhan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnTrangCaNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTrangCaNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnTrangCaNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnDanhMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnDanhChoAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jbtnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnThemBaiViet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnThemBaiViet, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jbtnThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnTrangCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jbtnDanhChoAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnView.setPreferredSize(new java.awt.Dimension(1000, 600));
        jpnView.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpnRoot, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDanhChoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDanhChoAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnDanhChoAdminActionPerformed

    private void jbtnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTrangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnTrangChuActionPerformed

    private void jbtnThemBaiVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemBaiVietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnThemBaiVietActionPerformed

    private void jbtnThongBaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThongBaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnThongBaoActionPerformed

    private void jbtnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnDanhMucActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jbtnTrangCaNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTrangCaNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnTrangCaNhanActionPerformed

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed
        String[] options = {"Đồng ý", "Hủy"};
        int output = JOptionPane.showOptionDialog(this,
                "Bạn thực sự muốn đăng xuất?", "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (output == JOptionPane.YES_OPTION) {
            this.dispose();
            new dangNhap().setVisible(true);
        } else if (output == JOptionPane.NO_OPTION) {
            System.out.println("No selected.");
        }
    }//GEN-LAST:event_jButton12MousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame("29").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jbtnDanhChoAdmin;
    private javax.swing.JButton jbtnDanhMuc;
    private javax.swing.JButton jbtnThemBaiViet;
    private javax.swing.JButton jbtnThongBao;
    private javax.swing.JButton jbtnTrangCaNhan;
    private javax.swing.JButton jbtnTrangChu;
    private keeptoo.KGradientPanel jpnMenu;
    private javax.swing.JPanel jpnRoot;
    private keeptoo.KGradientPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
