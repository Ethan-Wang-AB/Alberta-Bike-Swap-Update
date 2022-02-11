/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "trade_desc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TradeDesc.findAll", query = "SELECT t FROM TradeDesc t")
    , @NamedQuery(name = "TradeDesc.findByDescId", query = "SELECT t FROM TradeDesc t WHERE t.descId = :descId")
    , @NamedQuery(name = "TradeDesc.findByDesc", query = "SELECT t FROM TradeDesc t WHERE t.desc = :desc")
    , @NamedQuery(name = "TradeDesc.findByPrice", query = "SELECT t FROM TradeDesc t WHERE t.price = :price")})
public class TradeDesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desc_id")
    private Integer descId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "desc")
    private String desc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descId")
    private List<TradeOthers> tradeOthersList;

    public TradeDesc() {
    }

    public TradeDesc(Integer descId) {
        this.descId = descId;
    }

    public TradeDesc(Integer descId, String desc, double price) {
        this.descId = descId;
        this.desc = desc;
        this.price = price;
    }

    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public List<TradeOthers> getTradeOthersList() {
        return tradeOthersList;
    }

    public void setTradeOthersList(List<TradeOthers> tradeOthersList) {
        this.tradeOthersList = tradeOthersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descId != null ? descId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeDesc)) {
            return false;
        }
        TradeDesc other = (TradeDesc) object;
        if ((this.descId == null && other.descId != null) || (this.descId != null && !this.descId.equals(other.descId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.TradeDesc[ descId=" + descId + " ]";
    }
    
}
