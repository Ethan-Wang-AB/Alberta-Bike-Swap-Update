/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "announcement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Announcement.findAll", query = "SELECT a FROM Announcement a")
    , @NamedQuery(name = "Announcement.findByAnnouncementId", query = "SELECT a FROM Announcement a WHERE a.announcementId = :announcementId")
    , @NamedQuery(name = "Announcement.findByTitle", query = "SELECT a FROM Announcement a WHERE a.title = :title")
    , @NamedQuery(name = "Announcement.findByBody", query = "SELECT a FROM Announcement a WHERE a.body = :body")
    , @NamedQuery(name = "Announcement.findByPicture", query = "SELECT a FROM Announcement a WHERE a.picture = :picture")
    , @NamedQuery(name = "Announcement.findByLink", query = "SELECT a FROM Announcement a WHERE a.link = :link")
    , @NamedQuery(name = "Announcement.findByDate", query = "SELECT a FROM Announcement a WHERE a.date = :date")})
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "announcement_id")
    private Integer announcementId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "body")
    private String body;
    @Size(max = 300)
    @Column(name = "picture")
    private String picture;
    @Size(max = 300)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Announcement() {
    }

    public Announcement(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public Announcement(Integer announcementId, String title, String body, Date date) {
        this.announcementId = announcementId;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (announcementId != null ? announcementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcement)) {
            return false;
        }
        Announcement other = (Announcement) object;
        if ((this.announcementId == null && other.announcementId != null) || (this.announcementId != null && !this.announcementId.equals(other.announcementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Announcement[ announcementId=" + announcementId + " ]";
    }
    
}
