/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.global;

import ConnectDB.OracleConnUtils;
import Views.main.mainFrame;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

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
    private String avatar;
    private String score;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String city;
    private String district;
    
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
                avatar = rs.getString("avatar");
                score = rs.getString("score");
                dateOfBirth = rs.getString("dateofbirth");
                address = rs.getString("addresss");
                city = rs.getString("city");
                district = rs.getString("district");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("lỗi khi truy vấn sql" + e.getMessage().toString());
        }
    }

//hàm thay đổi     
    public void modifiedUser(String newFirstName, String newLastName, String newGender, String newDateOfBirth) throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_update_account(?,?,?,?,?)}";

        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, this.userId);
        caSt.setString(2, newFirstName);
        caSt.setString(3, newLastName);
        caSt.setString(4, newGender);
        caSt.setString(5, newDateOfBirth);
        caSt.execute();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
