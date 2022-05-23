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
    private int userid;
    private String FIRSTNAME;
    private int role;
    private String code_auth;//code lưu mã khôi phục mật khẩu
    
    
    public user() {
        
    }
    
    public user(int userid) {
        this.userid = userid;
        
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
}
