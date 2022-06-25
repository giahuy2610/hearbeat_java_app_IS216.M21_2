/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.danhChoAdmin;

import ConnectDB.OracleConnUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author giahu
 */
public class danhChoAdminJPanel_Report extends javax.swing.JPanel {

    private Connection conn = (Connection) OracleConnUtils.getOracleConnection();

    private void createPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {

            Statement st1 = conn.createStatement();

            ResultSet rs = st1.executeQuery("select count(*) from tb_post where statusid = 3");
            rs.next();

            int count_success = rs.getInt("count(*)");
            dataset.setValue("Thành công", count_success);

            rs = st1.executeQuery("select count(*) from tb_post where statusid = 1");
            rs.next();

            int count_waiting = rs.getInt("count(*)");
            dataset.setValue("Đang chờ", count_waiting);

            rs = st1.executeQuery("select count(*) from tb_post where statusid = 2");
            rs.next();

            int count_scheduling = rs.getInt("count(*)");
            dataset.setValue("Đã có lịch hẹn", count_scheduling);

        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFreeChart chart = ChartFactory.createPieChart("Biểu đồ hiệu quả hoạt động", dataset, true, true, true);
        //PiePlot p = (PiePlot) chart.getPlot();

        ChartPanel myChart = new ChartPanel(chart);
        panelPieChart.setLayout(new java.awt.BorderLayout());
        panelPieChart.add(myChart, BorderLayout.CENTER);
        panelPieChart.validate();

    }

    private CategoryDataset createDataset() throws SQLException, ClassNotFoundException {
        final String countPost = "Bài viết";
        final String countCompletePost = "Bài viết thành công";
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        String query = "select count(postid) as countPost from tb_post where EXTRACT(YEAR FROM TO_DATE(CREATEDON, 'DD-MM-YY')) = ? AND extract(MONTH FROM to_date(createdon, 'DD-MM-YY')) = ?";

        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 1; i <= 12; i++) {
            stmt.setInt(1, 2022);//năm
            stmt.setInt(2, i);//tháng
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("countpost of month " + rs.getInt("countPost"));
                dataset.addValue(rs.getInt("countPost"), countPost, "T" + i);
            }
        }

        query += " AND STATUSID = 3";
        stmt = conn.prepareStatement(query);
        for (int i = 1; i <= 12; i++) {
            stmt.setInt(1, 2022);//năm
            stmt.setInt(2, i);//tháng
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("countpost of month " + rs.getInt("countPost"));
                dataset.addValue(rs.getInt("countPost"), countCompletePost, "T" + i);
            }
        }

        return dataset;
    }

    private void createBarChart() throws SQLException, ClassNotFoundException {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống kê hiệu quả năm 2022",
                "Tháng",
                "Số bài viết",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, true);

        ChartPanel chartPanel = new ChartPanel(barChart);
        panelBarChart.setLayout(new java.awt.BorderLayout());
        panelBarChart.add(chartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    private DefaultCategoryDataset createDataset1() throws SQLException, ClassNotFoundException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "select count(userid) as countUser from tb_user where EXTRACT(YEAR FROM TO_DATE(CREATEDON, 'DD-MM-YY')) = ? AND extract(MONTH FROM to_date(createdon, 'DD-MM-YY')) = ?";

        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 1; i <= 12; i++) {
            stmt.setInt(1, 2022);//năm
            stmt.setInt(2, i);//tháng
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dataset.addValue(rs.getInt("countUser"), "người", "T" + i);
            }
        }
        return dataset;
    }

    private void createLineChart() throws SQLException, ClassNotFoundException {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Biểu đồ tăng trưởng lượng người dùng năm 2022",
                "Tháng", "Số người dùng mới",
                createDataset1(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel lineChartPanel = new ChartPanel(lineChart);
        lineChart.getPlot().setBackgroundPaint(Color.WHITE);
        panelLineChart.setLayout(new java.awt.BorderLayout());
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }

    /**
     * Creates new form danhChoAdminJPanel_Report
     */
    public danhChoAdminJPanel_Report() throws SQLException, ClassNotFoundException {
//        conn.setAutoCommit(false);
//        System.out.println("TX is now " + conn.getTransactionIsolation());
//        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//        System.out.println("TX is now " + conn.getTransactionIsolation());
//        Statement stmt2 = conn.createStatement();
//        stmt2.executeQuery("LOCK TABLE tb_user IN SHARE MODE NOWAIT");

        initComponents();

        this.createPieChart();
        this.createBarChart();
        this.createLineChart();
        System.out.println();

        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(USERID) AS COUNTU FROM TB_USER");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                labelCountTotalUser.setText(rs.getString("countu"));
            }

            stmt = conn.prepareStatement("SELECT COUNT(POSTID) AS COUNTP FROM TB_POST");
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("haha");
                labelCountTotalPost.setText(rs.getString("countp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
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

        panelPieChart = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelCountTotalPost = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelCountTotalUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fromDate = new com.toedter.calendar.JDateChooser();
        toDate = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(199, 234, 227));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        panelPieChart.setBackground(new java.awt.Color(204, 204, 255));
        panelPieChart.setPreferredSize(new java.awt.Dimension(320, 200));

        javax.swing.GroupLayout panelPieChartLayout = new javax.swing.GroupLayout(panelPieChart);
        panelPieChart.setLayout(panelPieChartLayout);
        panelPieChartLayout.setHorizontalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        panelPieChartLayout.setVerticalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBarChart.setBackground(new java.awt.Color(153, 153, 255));
        panelBarChart.setPreferredSize(new java.awt.Dimension(470, 340));

        javax.swing.GroupLayout panelBarChartLayout = new javax.swing.GroupLayout(panelBarChart);
        panelBarChart.setLayout(panelBarChartLayout);
        panelBarChartLayout.setHorizontalGroup(
            panelBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        panelBarChartLayout.setVerticalGroup(
            panelBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelLineChart.setBackground(new java.awt.Color(204, 204, 255));
        panelLineChart.setPreferredSize(new java.awt.Dimension(470, 340));

        javax.swing.GroupLayout panelLineChartLayout = new javax.swing.GroupLayout(panelLineChart);
        panelLineChart.setLayout(panelLineChartLayout);
        panelLineChartLayout.setHorizontalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        panelLineChartLayout.setVerticalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SỐ BÀI VIẾT");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/to-do-list.png"))); // NOI18N
        jLabel4.setOpaque(true);

        labelCountTotalPost.setBackground(new java.awt.Color(153, 153, 255));
        labelCountTotalPost.setFont(new java.awt.Font("Arial", 1, 78)); // NOI18N
        labelCountTotalPost.setForeground(new java.awt.Color(255, 204, 255));
        labelCountTotalPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCountTotalPost.setText("254");
        labelCountTotalPost.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCountTotalPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelCountTotalPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCountTotalUser.setBackground(new java.awt.Color(153, 153, 255));
        labelCountTotalUser.setFont(new java.awt.Font("Arial", 1, 78)); // NOI18N
        labelCountTotalUser.setForeground(new java.awt.Color(255, 204, 255));
        labelCountTotalUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCountTotalUser.setText("112");
        labelCountTotalUser.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/images/teamwork (1).png"))); // NOI18N
        jLabel2.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(153, 153, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SỐ NGƯỜI DÙNG");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCountTotalUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelCountTotalUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ĐẾN NGÀY");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TỪ NGÀY");

        jButton1.setText("THỐNG KÊ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fromDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                fromDateAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        fromDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromDatePropertyChange(evt);
            }
        });

        toDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                toDateAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        toDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(608, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fromDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_fromDateAncestorAdded

    }//GEN-LAST:event_fromDateAncestorAdded

    private void fromDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromDatePropertyChange

    }//GEN-LAST:event_fromDatePropertyChange

    private void toDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_toDateAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_toDateAncestorAdded

    private void toDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDatePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDatePropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            System.out.println("TX is now " + conn.getTransactionIsolation());
        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(USERID) AS COUNTU FROM TB_USER WHERE CREATEDON >= ? AND CREATEDON <= ?");
            stmt.setDate(1, new java.sql.Date(fromDate.getDate().getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getDate().getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                labelCountTotalUser.setText(rs.getString("countu"));
            }

            stmt = conn.prepareStatement("SELECT COUNT(POSTID) AS COUNTP FROM TB_POST WHERE CREATEDON >= ? AND CREATEDON <= ?");
            stmt.setDate(1, new java.sql.Date(fromDate.getDate().getTime()));
            stmt.setDate(2, new java.sql.Date(toDate.getDate().getTime()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("haha");
                labelCountTotalPost.setText(rs.getString("countp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(danhChoAdminJPanel_Report.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelCountTotalPost;
    private javax.swing.JLabel labelCountTotalUser;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelPieChart;
    private com.toedter.calendar.JDateChooser toDate;
    // End of variables declaration//GEN-END:variables
}
