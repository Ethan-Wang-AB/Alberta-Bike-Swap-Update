/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "affiliation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affiliation.findAll", query = "SELECT a FROM Affiliation a")
    , @NamedQuery(name = "Affiliation.findByAffiliationId", query = "SELECT a FROM Affiliation a WHERE a.affiliationId = :affiliationId")
    , @NamedQuery(name = "Affiliation.findByAffiliationDes", query = "SELECT a FROM Affiliation a WHERE a.affiliationDes = :affiliationDes")})
public class Affiliation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "affiliation_id")
    private Integer affiliationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "affiliation_des")
    private String affiliationDes;
    @OneToMany(mappedBy = "affiliationId")
    private List<User> userList;

    public Affiliation() {
    }

    public Affiliation(Integer affiliationId) {
        this.affiliationId = affiliationId;
    }

    public Affiliation(Integer affiliationId, String affiliationDes) {
        this.affiliationId = affiliationId;
        this.affiliationDes = affiliationDes;
    }

    public Integer getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(Integer affiliationId) {
        this.affiliationId = affiliationId;
    }

    public String getAffiliationDes() {
        return affiliationDes;
    }

    public void setAffiliationDes(String affiliationDes) {
        this.affiliationDes = affiliationDes;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (affiliationId != null ? affiliationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affiliation)) {
            return false;
        }
        Affiliation other = (Affiliation) object;
        if ((this.affiliationId == null && other.affiliationId != null) || (this.affiliationId != null && !this.affiliationId.equals(other.affiliationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Affiliation[ affiliationId=" + affiliationId + " ]";
    }
    
}
