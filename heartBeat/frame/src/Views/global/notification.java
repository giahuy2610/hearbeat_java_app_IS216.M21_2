/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.global;

import java.util.ArrayList;

/**
 *
 * @author giahu
 */
public class notification {
    private String notiId;
    private String content;
    private String createdOn;
    private String isSeen;

    public String getNotiId() {
        return notiId;
    }

    public void setNotiId(String notiId) {
        this.notiId = notiId;
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

    public String getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(String isSeen) {
        this.isSeen = isSeen;
    }

    public notification() {
    }

    public notification(String notiId, String content, String createdOn, String isSeen) {
        this.notiId = notiId;
        this.content = content;
        this.createdOn = createdOn;
        this.isSeen = isSeen;
    }
    
    public notification(String notiId) {
        
    }

}
