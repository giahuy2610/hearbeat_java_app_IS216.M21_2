/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author giahu
 */
public class danhMucBean {

    private String kind;
    private JButton jbtn;
    
    public danhMucBean() {
    }

    public danhMucBean(String kind, JButton jbtn) {
        this.kind = kind;
        this.jbtn = jbtn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JButton getJbtn() {
        return jbtn;
    }

    public void setJbtn(JButton jbtn) {
        this.jbtn = jbtn;
    }



    
    
}
