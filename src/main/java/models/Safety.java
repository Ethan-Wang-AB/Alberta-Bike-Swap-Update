/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "safety")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Safety.findAll", query = "SELECT s FROM Safety s")
    , @NamedQuery(name = "Safety.findBySafetyId", query = "SELECT s FROM Safety s WHERE s.safetyId = :safetyId")
    , @NamedQuery(name = "Safety.findBySafetyTitle", query = "SELECT s FROM Safety s WHERE s.safetyTitle = :safetyTitle")
    , @NamedQuery(name = "Safety.findBySafetyDesc", query = "SELECT s FROM Safety s WHERE s.safetyDesc = :safetyDesc")
    , @NamedQuery(name = "Safety.findByLink", query = "SELECT s FROM Safety s WHERE s.link = :link")
    , @NamedQuery(name = "Safety.findByVisible", query = "SELECT s FROM Safety s WHERE s.visible = :visible")
    , @NamedQuery(name = "Safety.findByType", query = "SELECT s FROM Safety s WHERE s.type = :type")
    , @NamedQuery(name = "Safety.findByPosition", query = "SELECT s FROM Safety s WHERE s.position = :position")})
public class Safety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "safety_id")
    private Integer safetyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "safety_title")
    private String safetyTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "safety_desc")
    private String safetyDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible")
    private boolean visible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private boolean type;
    @Column(name = "position")
    private Integer position;

    public Safety() {
    }

    public Safety(Integer safetyId) {
        this.safetyId = safetyId;
    }

    public Safety(Integer safetyId, String safetyTitle, String safetyDesc, String link, boolean visible, boolean type) {
        this.safetyId = safetyId;
        this.safetyTitle = safetyTitle;
        this.safetyDesc = safetyDesc;
        this.link = link;
        this.visible = visible;
        this.type = type;
    }

    public Integer getSafetyId() {
        return safetyId;
    }

    public void setSafetyId(Integer safetyId) {
        this.safetyId = safetyId;
    }

    public String getSafetyTitle() {
        return safetyTitle;
    }

    public void setSafetyTitle(String safetyTitle) {
        this.safetyTitle = safetyTitle;
    }

    public String getSafetyDesc() {
        return safetyDesc;
    }

    public void setSafetyDesc(String safetyDesc) {
        this.safetyDesc = safetyDesc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (safetyId != null ? safetyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Safety)) {
            return false;
        }
        Safety other = (Safety) object;
        if ((this.safetyId == null && other.safetyId != null) || (this.safetyId != null && !this.safetyId.equals(other.safetyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Safety[ safetyId=" + safetyId + " ]";
    }
    
}
