package Views.global;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author giahu
 */
public class post {

    public String postId;
    private String title;
    private String categoryId;
    private String content;
    private String createdOn;
    private String updatedOn;
    private String ownerId;
    private String partnerId;
    private String purposeId;
    private String isDeleted;
    private String imagePath;
    private String statusId;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public post() {
    }

    public post(String postId, String title, String categoryId, String content, String createdOn, String updatedOn, String ownerId, String partnerId, String purposeId, String isDeleted, String imagePath, String statusId) {
        this.postId = postId;
        this.title = title;
        this.categoryId = categoryId;
        this.content = content;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.ownerId = ownerId;
        this.partnerId = partnerId;
        this.purposeId = purposeId;
        this.isDeleted = isDeleted;
        this.imagePath = imagePath;
        this.statusId = statusId;
    }
}