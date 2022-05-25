/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.profile;

/**
 *
 * @author giahu
 */
public class user {
    private static String userid;
    private String FIRSTNAME;
    private int role;
    private String code_auth;//code lưu mã khôi phục mật khẩu
    
    
    public user() {
        
    }
    
    public user(String userid) {
        this.userid = userid;
        
    }

    public static String getUserId() {
        return userid;
    }

    public static void setUserid(String userid) {
        user.userid = userid;
    }
    
    
}
