/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.main;

import Views.logIn_sigIn.dangNhap;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author giahu
 */
public class main {

 public static void main(String args[]) {
                JFrame frame = new JFrame("SpringLayout");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JScrollPane scroll = new JScrollPane();
                Container contentPane = frame.getContentPane();

               JButton next = new JButton("Next");
               JPanel buttonPanel = new JPanel();
               buttonPanel.add(next);
                SpringLayout layout = new SpringLayout();
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(layout);
                contentPane.setLayout(new BorderLayout());


                int j = 25;
                for(int i =0;i<18;i++){
                    JLabel label = new JLabel("Enter Name " + i );
                    JTextField text = new JTextField(15);

                mainPanel.add(label);
                mainPanel.add(text);
                layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST,
                                contentPane);
                layout.putConstraint(SpringLayout.NORTH, label, j, SpringLayout.NORTH,
                                contentPane);
                layout.putConstraint(SpringLayout.NORTH, text, j, SpringLayout.NORTH,
                                contentPane);
                layout.putConstraint(SpringLayout.WEST, text, 20, SpringLayout.EAST,
                                label);
                j+=30;
                }
                mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), 1500));
                scroll.setPreferredSize(new Dimension(500,500));
                scroll.setViewportView(mainPanel);
                contentPane.add(scroll);
                contentPane.add(buttonPanel,BorderLayout.SOUTH);
                //mainWindow.add(contentPane);
                frame.setSize(500, 600);
                frame.setVisible(true);
        }

}
