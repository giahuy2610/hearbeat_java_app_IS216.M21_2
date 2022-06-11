package Process;

import ConnectDB.OracleConnUtils;
import Views.main.mainFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author giahu
 */
public class post {

    private String postId;
    private String title;
    private String categoryId;
    private String content;
    private String createdOn;
    private String updatedOn;
    private String ownerId;
    private String partnerId;
    private String purposeId;
    private String isDeleted;
    private byte[] imagePath;
    private String statusId;

<<<<<<< HEAD


    public static void themBaiViet(String postTitle, String postContent, String postCategoryId, String postPurposeId, String pathImage) throws SQLException, ClassNotFoundException {
=======
    public static void themBaiViet(String postTitle, String postContent, String postCategoryId, String postPurposeId,File postImage) throws SQLException, ClassNotFoundException, FileNotFoundException {
>>>>>>> 9058c51ac2272ac22812f41e52ebe05b8df9e54d
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call P_INSERT_POST_NEW(?,?,?,?,?,?)}";
        System.out.println(mainFrame.currentUser.getUserId());
        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, mainFrame.currentUser.getUserId());
        caSt.setString(2, postTitle);
        caSt.setString(3, postContent);
        caSt.setString(4, postCategoryId);
        caSt.setString(5, postPurposeId);
        
        FileInputStream is = new FileInputStream(postImage);
        caSt.setBinaryStream(6,  is);
        
        System.out.println("đã nhận ảnh ");
        caSt.execute();
    }

    public post(String postId) {
        try {
            this.postId = postId;
            Connection conn = OracleConnUtils.getOracleConnection();
            String query = "select * from tb_post where postid = " + postId;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                title = rs.getString("title");
                categoryId = rs.getString("categoryid");
                purposeId = rs.getString("purposeId");
                content = rs.getString("content");
                createdOn = rs.getString("createdon");
                updatedOn = rs.getString("updatedOn");
                ownerId = rs.getString("ownerId");
                partnerId = rs.getString("partnerId");
                isDeleted = rs.getString("isdeleted");
                imagePath = rs.getBytes("imagePath");
                statusId = rs.getString("statusid");
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(post.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(byte[] imagePath) {
        this.imagePath = imagePath;
    }

    
    
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(String purposeId) {
        this.purposeId = purposeId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public post() {
    }


    public void deletedPost() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_delete_post(?)}";
        CallableStatement caSt = conn.prepareCall(query);
        System.out.println(this.postId);
        caSt.setString(1, this.postId);
        caSt.execute();
        System.out.println("Deleted post" + postId);
    }
    //khôi phục bài viết bị xóa

    public void recoveryPost() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_recovery_post(?)}";
        CallableStatement caSt = conn.prepareCall(query);
        System.out.println(this.postId);
        caSt.setString(1, this.postId);
        caSt.execute();
        System.out.println("Successful recovery post" + postId);
    }

    //chỉnh sửa bài viết
    public void cancelSchedulingPost() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_cancel_scheduling (?,?)}";
        CallableStatement caSt = conn.prepareCall(query);
        System.out.println(this.postId);
        caSt.setString(1, this.postId);
        caSt.setString(1, mainFrame.currentUser.getUserId());
        caSt.execute();
        System.out.println("Cancel success, post" + postId);
    }

    public void schedulePost() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_scheduling (?,?)}";
        CallableStatement caSt = conn.prepareCall(query);
        System.out.println(this.postId);
        caSt.setString(1, this.postId);
        caSt.setString(2, mainFrame.currentUser.getUserId());
        caSt.execute();
        System.out.println("Scheduling successful, post" + postId);
    }

    public void confirmSchedulePost() throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{call p_confirm_scheduling (?,?)}";
        CallableStatement caSt = conn.prepareCall(query);
        System.out.println(this.postId);
        caSt.setString(1, this.postId);
        caSt.setString(2, mainFrame.currentUser.getUserId());
        caSt.execute();
        System.out.println("Scheduling confirm successful, post" + postId);
        conn.close();
    }

    public int modifyPost(String newTitle, String newContent, String newCategoryId, String newPurposeId, String newImagePath) throws SQLException, ClassNotFoundException {
        Connection conn = OracleConnUtils.getOracleConnection();
        String query = "{update tb_post set title = ?, content = ?, categoryid = ?, purposeid = ?, imagepath = ? where postid = ?}";
        CallableStatement caSt = conn.prepareCall(query);
        caSt.setString(1, newTitle);
        caSt.setString(2, newContent);
        caSt.setString(3, newCategoryId);
        caSt.setString(4, newPurposeId);
        caSt.setString(5, newImagePath);
        caSt.setString(6, this.postId);
        caSt.execute();
        System.out.println("successful modify post" + postId);
        conn.close();
        return 1;
    }
}
