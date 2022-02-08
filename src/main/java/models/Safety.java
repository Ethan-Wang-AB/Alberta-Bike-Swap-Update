/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 845593
 */
public class Safety {
    private int safetyId;       
    private String safetyTitle;     
    private String safetyDetail;        
    private boolean visible;        
    private String link;        
    private String tye;     
    private int position;   

    public int getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(int safetyId) {
        this.safetyId = safetyId;
    }

    public String getSafetyTitle() {
        return safetyTitle;
    }

    public void setSafetyTitle(String safetyTitle) {
        this.safetyTitle = safetyTitle;
    }

    public String getSafetyDetail() {
        return safetyDetail;
    }

    public void setSafetyDetail(String safetyDetail) {
        this.safetyDetail = safetyDetail;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTye() {
        return tye;
    }

    public void setTye(String tye) {
        this.tye = tye;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
}
