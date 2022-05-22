/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.main;

import ConnectDB.OracleConnUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class ScrollPaneEg extends JPanel {

    private static final int PREF_W = 1000;
    private static final int PREF_H = PREF_W;

    private static ArrayList<String> postId = new ArrayList<String>();
    private static ArrayList<String> postTitle = new ArrayList<String>();

    private static ArrayList<String> postCategory = new ArrayList<String>();
    private static ArrayList<String> postContent = new ArrayList<String>();

    public ScrollPaneEg() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(null);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel container = new JPanel(new GridLayout(0, 1)); // 1 column variable

        // number of rows\
        Connection conn = null;
        try {
            conn = OracleConnUtils.getOracleConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ScrollPaneEg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScrollPaneEg.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "";
        synchronized (query) {
            query = "select * from  tb_post";
        }
        try ( Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                postId.add(rs.getString("postid"));
                postTitle.add(rs.getString("title"));
                postCategory.add(rs.getString("categoryid"));
                postContent.add(rs.getString("content"));
            }
        } catch (SQLException e) {
            System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
        }

        for (int i = 0; i < 15; i++) {
            baiViet x = new baiViet(postId.get(i),postTitle.get(i),postCategory.get(i),postContent.get(i));
            x.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(x.postID);
                }
            });
            // x.setLocation(0, 45 *i);
            container.add(x);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        ScrollPaneEg mainPanel = new ScrollPaneEg();

        JFrame frame = new JFrame("ScrollPaneEg");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class SingleClientPanel extends JPanel {

    private static final int PREF_H = 60;

    public SingleClientPanel(String text) {
        setBorder(BorderFactory.createTitledBorder("Single Client"));
        setLayout(new GridBagLayout());
        add(new JLabel("Panel: " + text, SwingConstants.CENTER));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(superSz.width, prefH);
    }
}
