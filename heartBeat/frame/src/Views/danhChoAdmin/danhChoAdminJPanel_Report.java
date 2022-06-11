/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.danhChoAdmin;

import ConnectDB.OracleConnUtils;
import java.awt.BorderLayout;
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

        setBackground(new java.awt.Color(199, 234, 227));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        panelPieChart.setPreferredSize(new java.awt.Dimension(320, 200));

        javax.swing.GroupLayout panelPieChartLayout = new javax.swing.GroupLayout(panelPieChart);
        panelPieChart.setLayout(panelPieChartLayout);
        panelPieChartLayout.setHorizontalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        panelPieChartLayout.setVerticalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

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

        panelLineChart.setPreferredSize(new java.awt.Dimension(470, 340));

        javax.swing.GroupLayout panelLineChartLayout = new javax.swing.GroupLayout(panelLineChart);
        panelLineChart.setLayout(panelLineChartLayout);
        panelLineChartLayout.setHorizontalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        panelLineChartLayout.setVerticalGroup(
            panelLineChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(680, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLineChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
