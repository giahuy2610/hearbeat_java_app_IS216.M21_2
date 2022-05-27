/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.global;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author giahu
 */
public class sort {
    private static ArrayList<String> sortId = new ArrayList<String>();
    private static ArrayList<String> sortName = new ArrayList<String>();

    public static void prepareSortFilter(JComboBox cbb) {
        sortId.removeAll(sortId);
        sortName.removeAll(sortName);
        cbb.removeAllItems();

        sortId.add("0");
        sortName.add("Gần đây");
        cbb.addItem("Gần đây");

        sortId.add("1");
        sortName.add("Lâu nhất");
        cbb.addItem("Lâu nhất");
    }
}
