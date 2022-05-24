/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcessDB;



import ConnectDB.OracleConnUtils;
import ConnectDB.TestConnectJDBC;
import com.sun.jdi.connect.spi.Connection;


public class BaiViet {

/**
 * 
 * @param jTextFieldTieuDe
 * @param jcomboBoxMucDich
 * @param jcomboBoxDanhMuc
 * @param jTextFieldNoiDung
 * @param pathFile
 * @return 
 */
    public int themBaiViet(String jTextFieldTieuDe, String jcomboBoxMucDich, String jcomboBoxDanhMuc, String jTextFieldNoiDung, String pathFile) {

        int i = 0;
        // TODO add your handling code here:
        try (   Connection conn = (Connection) OracleConnUtils.getOracleConnection()) {

//            String query = "INSERT INTO "
//                    + "DOIBONG(MAD,TENDOI,QUOCGIA)"
//                    +" VALUES('"
//                    +maDoi+"','"+tenDoi+"','"+quocGia+"')";
            String query = "INSERT INTO BAIVIET VALUES(?,?,?,?,?)";
            PreparedStatement ps;
            ps = conn.PreparedStatement(query);
            ps.setString(1, jTextFieldTieuDe);

            ps.setString(2, jcomboBoxMucDich);
            ps.setString(3, jcomboBoxDanhMuc);
            ps.setString(4, jTextFieldNoiDung);
            ps.setString(5, pathFile);
            i = ps.executeUpdate();
//            Statement stat = con.createStatement();
//            i = stat.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

}
