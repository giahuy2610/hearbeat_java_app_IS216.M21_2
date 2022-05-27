/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.main;

/**
 *
 * @author giahu
 */
public class danhMucJPanel extends javax.swing.JPanel {

    /**
     * Creates new form danhMucJPanel
     */
    public danhMucJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_trao_tang = new javax.swing.JButton();
        btn_xin_nhan = new javax.swing.JButton();
        btn_gay_quy = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnThucPham = new javax.swing.JButton();
        btnYTe = new javax.swing.JButton();
        btnDoGiaDung = new javax.swing.JButton();
        btnGiaoDuc = new javax.swing.JButton();
        btnBuaAn = new javax.swing.JButton();
        btnKhac = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhu cầu");
        jLabel2.setPreferredSize(new java.awt.Dimension(48, 15));

        btn_trao_tang.setBackground(new java.awt.Color(255, 153, 255));
        btn_trao_tang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_trao_tang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/donate.png"))); // NOI18N
        btn_trao_tang.setText("Trao tặng");
        btn_trao_tang.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btn_trao_tang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trao_tangActionPerformed(evt);
            }
        });

        btn_xin_nhan.setBackground(new java.awt.Color(255, 153, 153));
        btn_xin_nhan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_xin_nhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/give.png"))); // NOI18N
        btn_xin_nhan.setText("Xin nhận");
        btn_xin_nhan.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btn_xin_nhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xin_nhanActionPerformed(evt);
            }
        });

        btn_gay_quy.setBackground(new java.awt.Color(255, 255, 102));
        btn_gay_quy.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_gay_quy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/fundraiser.png"))); // NOI18N
        btn_gay_quy.setText("Đóng góp quỹ");
        btn_gay_quy.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btn_gay_quy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gay_quyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btn_trao_tang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_xin_nhan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_gay_quy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_trao_tang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xin_nhan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gay_quy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Danh mục");
        jLabel3.setPreferredSize(new java.awt.Dimension(48, 15));

        btnThucPham.setBackground(new java.awt.Color(153, 255, 255));
        btnThucPham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThucPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/food.png"))); // NOI18N
        btnThucPham.setText("Thực phẩm");
        btnThucPham.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnThucPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThucPhamActionPerformed(evt);
            }
        });

        btnYTe.setBackground(new java.awt.Color(204, 255, 204));
        btnYTe.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnYTe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/drugs.png"))); // NOI18N
        btnYTe.setText("Y tế");
        btnYTe.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnYTe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYTeActionPerformed(evt);
            }
        });

        btnDoGiaDung.setBackground(new java.awt.Color(204, 204, 255));
        btnDoGiaDung.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnDoGiaDung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/item.png"))); // NOI18N
        btnDoGiaDung.setText("Đồ gia dụng");
        btnDoGiaDung.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDoGiaDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoGiaDungActionPerformed(evt);
            }
        });

        btnGiaoDuc.setBackground(new java.awt.Color(153, 255, 255));
        btnGiaoDuc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGiaoDuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/studying.png"))); // NOI18N
        btnGiaoDuc.setText("Giáo dục");
        btnGiaoDuc.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnGiaoDuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoDucActionPerformed(evt);
            }
        });

        btnBuaAn.setBackground(new java.awt.Color(204, 255, 204));
        btnBuaAn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBuaAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/lunch.png"))); // NOI18N
        btnBuaAn.setText("Bữa ăn");
        btnBuaAn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnBuaAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuaAnActionPerformed(evt);
            }
        });

        btnKhac.setBackground(new java.awt.Color(204, 204, 255));
        btnKhac.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnKhac.setText("Khác");
        btnKhac.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThucPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuaAn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYTe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoGiaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThucPham, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoGiaDung, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYTe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuaAn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 0, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH MỤC");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_trao_tangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trao_tangActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,1));
    }//GEN-LAST:event_btn_trao_tangActionPerformed

    private void btn_xin_nhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xin_nhanActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,2));
    }//GEN-LAST:event_btn_xin_nhanActionPerformed

    private void btn_gay_quyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gay_quyActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,3));
    }//GEN-LAST:event_btn_gay_quyActionPerformed

    private void btnThucPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThucPhamActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,1));
    }//GEN-LAST:event_btnThucPhamActionPerformed

    private void btnYTeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYTeActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,3));
    }//GEN-LAST:event_btnYTeActionPerformed

    private void btnDoGiaDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoGiaDungActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,2));
    }//GEN-LAST:event_btnDoGiaDungActionPerformed

    private void btnGiaoDucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoDucActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,4));
    }//GEN-LAST:event_btnGiaoDucActionPerformed

    private void btnBuaAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuaAnActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,5));
    }//GEN-LAST:event_btnBuaAnActionPerformed

    private void btnKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhacActionPerformed
        chuyenManHinhController.setView(new trangChuJPanel(0,6));
    }//GEN-LAST:event_btnKhacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuaAn;
    private javax.swing.JButton btnDoGiaDung;
    private javax.swing.JButton btnGiaoDuc;
    private javax.swing.JButton btnKhac;
    private javax.swing.JButton btnThucPham;
    private javax.swing.JButton btnYTe;
    private javax.swing.JButton btn_gay_quy;
    private javax.swing.JButton btn_trao_tang;
    private javax.swing.JButton btn_xin_nhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
