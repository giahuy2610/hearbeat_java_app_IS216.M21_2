/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.global;

import ConnectDB.OracleConnUtils;
import Views.main.trangChuJPanel;
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
    private static String currentUserId;// biến lưu userId của người dùng đang sử dụng app
    private static String currentRoleId; // biến lưu roleId của người dùng đang sử dụng app
    
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
    private String code_auth;//code lưu mã khôi phục mật khẩu
    private String lastName;

    public user() {

    }

    public user(String userId, String firstName, String gender, String phone, String email, String createdOn, String password, String roleId, String isDeleted, String avatar, String score, String code_auth, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.createdOn = createdOn;
        this.password = password;
        this.roleId = roleId;
        this.isDeleted = isDeleted;
        this.avatar = avatar;
        this.score = score;
        this.code_auth = code_auth;
        this.lastName = lastName;
    }

    public static String getCurrentUserId() {
        return currentUserId;
    }

    public static void setCurrentUserId(String currentUserId) {
        user.currentUserId = currentUserId;
    }

    public static String getCurrentRoleId() {
        return currentRoleId;
    }

    public static void setCurrentRoleId(String currentRoleId) {
        user.currentRoleId = currentRoleId;
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
