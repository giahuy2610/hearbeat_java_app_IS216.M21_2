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

    private void createPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            Connection conn = (Connection) OracleConnUtils.getOracleConnection();

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
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
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
        Connection conn = (Connection) OracleConnUtils.getOracleConnection();

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
        conn.close();
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
        Connection conn = (Connection) OracleConnUtils.getOracleConnection();

        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 1; i <= 12; i++) {
            stmt.setInt(1, 2022);//năm
            stmt.setInt(2, i);//tháng
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dataset.addValue(rs.getInt("countUser"), "người", "T"+i);
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
        initComponents();
        
        this.createPieChart();
        this.createBarChart();
        this.createLineChart();
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
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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
            .addGap(0, 338, Short.MAX_VALUE)
        );

        panelLineChart.setBackground(new java.awt.Color(204, 204, 255));
        panelLineChart.setPreferredSize(new java.awt.Dimension(470, 340));

        javax.swing.GroupLayout panelLineChartLayout = new javax.swing.GroupLayout(panelLineChart);
        panelLineChart.setLayout(panelLineChartLayout);
        panelLineChartLayout.setHorizontalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLineChartLayout.setVerticalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        jLabel6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 78)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("254");
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 78)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("112");
        jLabel1.setOpaque(true);

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
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
