/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.main;

import java.awt.Color;

/**
 *
 * @author giahu
 */
public class setValue {

    public static Color headerColor = new Color(199, 234, 227);
    public static Color headerTextColor = new Color(0, 102, 204);
    public static Color postColor1 = new Color(199, 234, 227);
    public static Color postColor2 = new Color(199, 234, 247);

    public static Color getHeaderColor() {
        return headerColor;
    }

    public static void setHeaderColor(Color headerColor) {
        setValue.headerColor = headerColor;
    }

    public static Color getHeaderTextColor() {
        return headerTextColor;
    }

    public static void setHeaderTextColor(Color headerTextColor) {
        setValue.headerTextColor = headerTextColor;
    }

}
