/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.main;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author giahu
 */
public class chuyenManHinhAdmin {

    private JPanel root;
    private String kindSelected = "";

    private static List<danhMucBean> listItem = null;

    public chuyenManHinhAdmin(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JButton jlbItem) {
        kindSelected = "QLND";
        jlbItem.setOpaque(true);

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new danhChoAdminJPanel_QLND());
        root.validate();
        root.repaint();

    }

    public void setEvent(List<danhMucBean> listItem) {
        this.listItem = listItem;
        for (danhMucBean item : listItem) {
            item.getJbtn().addMouseListener(new btnEvent(item.getKind(), item.getJbtn()));

        }
    }

    class btnEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JButton jbtn;

        public btnEvent(String kind, JButton jbtn) {
            this.kind = kind;
            this.jbtn = jbtn;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            switch (kind) {
                case "QLND":
                    node = new danhChoAdminJPanel_QLND();
                    break;
                case "QLBD":
                    node = new danhChoAdminJPanel_QLBD();
                    break;
                case "QLSK":
                    node = new danhChoAdminJPanel_QLSK();
                    break;
                default:
                    break;
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    private void setChangeBackground(String kind) {
        for (danhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJbtn().setOpaque(true);
            }
            else {
                item.getJbtn().setOpaque(false);              
            }
        }

    }

}
