/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author giahu
 */
public class user {

    private static String code_auth;//code lưu mã khôi phục mật khẩu

    //các thuộc tính của 1 user
    private String userId;
    private String firstName;
    private String gender;
    private String phone;
    private String email;
    private String createdOn;
    private String password;
    private String roleId;
    private String isDeleted;
    private byte[] avatar;
    private String score;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String district;

    public user() {
    }

    public user(String userId) {
        this.loadUser(userId);
        this.loadUser(userId);
    }

//hàm để lấy mọi data của user đó
    public void loadUser(String currentUserId) {
        Connection conn = null;

        try {
            conn = OracleConnUtils.getOracleConnection();
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }

        String query = "";

        synchronized (query) {
            query = "select * from tb_user left join tb_address on tb_user.userid = tb_address.userid where tb_user.userid = " + currentUserId;
            System.out.println(query);
        }
        try ( Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                userId = currentUserId;
                lastName = rs.getString("lastName");
                firstName = rs.getString("firstname");
                gender = rs.getString("gender");
                phone = rs.getString("phone");
                email = rs.getString("email");
                createdOn = rs.getString("createdon");
                password = rs.getString("password");
                roleId = rs.getString("roleid");
                isDeleted = rs.getString("isdeleted");
                avatar = rs.getBytes("avatar");
                score = rs.getString("score");
                dateOfBirth = rs.getDate("dateofbirth");
                System.out.println("city của người dùng là " + rs.getString("cityid"));
                address = rs.getString("address");
                city = rs.getString("cityid");
                district = rs.getString("districtid");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
        }
    }
//hàm tạo mới

    public static void addNewUser(String firstNameIn, String lastNameIn, String genderIn, String phoneIn, Date dateOfBirthIn, String emailIn) throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO TB_USER (FIRSTNAME,LASTNAME,GENDER,PHONE,DATEOFBIRTH,EMAIL,AVATAR,PASSWORD,ROLEID) VALUES (?,?,?,?,?,?,?,?,?)");
        stmt.setString(1, firstNameIn);
        stmt.setString(2, lastNameIn);
        stmt.setString(3, genderIn);
        stmt.setString(4, phoneIn);
        stmt.setDate(5, (java.sql.Date) dateOfBirthIn);
        stmt.setString(6, emailIn);
        stmt.setString(7, "");
        stmt.setString(8, "12345");
        stmt.setString(9, "1");
        System.out.println("Số dòng bị thay đổi " + stmt.executeUpdate());
        /*
        conn.prepareStatement("select top(userid) from tb_user").execute();
        String newUser = ;
        stmt = conn.prepareStatement("UPDATE TB_ADDRESS SET CITYID = ?, DISTRICTID = ?, ADDRESS = ? WHERE USERID = ?");
        stmt.setString(1, cityIdIn);
        stmt.setString(2, districtIdIn);
        stmt.setString(3, addressIn);
        stmt.setString(4, cityIdIn);*/

    }
//hàm xóa

    public void deletedUser() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_delete_account(?)}";
        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, this.userId);
        caSt.execute();
        conn.close();
    }

//khôi phục lại tài khoản
    public void recoveryUser() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_recovery_account(?)}";
        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, this.userId);
        caSt.execute();
        conn.close();
    }
//hàm thay đổi     

    public void modifiedUser(String newFirstName, String newLastName, String newGender, Date newDateOfBirth, String newCityid, String newDistrictid, String newAddress) throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        System.out.println("date " + newDateOfBirth);
        String query = "{call p_update_account(?,?,?,?,?,?,?,?)}";

        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, this.userId);
        caSt.setString(2, newFirstName);
        caSt.setString(3, newLastName);
        caSt.setString(4, newGender);
        caSt.setDate(5, (java.sql.Date) newDateOfBirth);
        caSt.setString(6, newCityid);

        caSt.setString(7, newDistrictid);
        caSt.setString(8, newAddress);
        System.out.println("Số dòng bị thay đổi " + caSt.executeUpdate());
        conn.close();
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUserId() {
        return userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }
    
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(File avatar) throws SQLException, ClassNotFoundException, FileNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "update tb_user set avatar = ? where userid = ?";
        PreparedStatement stmt=conn.prepareStatement(query);  
        stmt.setString(2, userId);
        stmt.setBinaryStream(1, new FileInputStream(avatar));
        stmt.execute();
        conn.close();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCode_auth() {
        return code_auth;
    }

    public void setCode_auth(String code_auth) {
        this.code_auth = code_auth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
