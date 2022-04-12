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
@Table(name = "diet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diet.findAll", query = "SELECT d FROM Diet d")
    , @NamedQuery(name = "Diet.findByDietId", query = "SELECT d FROM Diet d WHERE d.dietId = :dietId")
    , @NamedQuery(name = "Diet.findByDietDes", query = "SELECT d FROM Diet d WHERE d.dietDes = :dietDes")})
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diet_id")
    private Integer dietId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "diet_des")
    private String dietDes;
    @OneToMany(mappedBy = "dietId")
    private List<User> userList;

    public Diet() {
    }

    public Diet(Integer dietId) {
        this.dietId = dietId;
        //assign an appropriate description
        switch(dietId){
            case(0):{
                dietDes="None";
                break;
             }
            case(1):{
                dietDes="Vegetarian";
                break;
             }
            case(2):{
                dietDes="Gluten-Free";
                break;
             }
             case(3):{
                dietDes="No-Dairy";
                break;
             }
             case(4):{
                dietDes="Nut-Sensitive";
                break;
             }
            case(5):{
                dietDes="Other";
                break;
             }             
        }
    }

    public Diet(Integer dietId, String dietDes) {
        this.dietId = dietId;
        this.dietDes = dietDes;
    }

    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    public String getDietDes() {
        return dietDes;
    }

    public void setDietDes(String dietDes) {
        this.dietDes = dietDes;
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
        hash += (dietId != null ? dietId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diet)) {
            return false;
        }
        Diet other = (Diet) object;
        if ((this.dietId == null && other.dietId != null) || (this.dietId != null && !this.dietId.equals(other.dietId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Diet[ dietId=" + dietId + " ]";
    }
    
}
