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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "trade_others")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TradeOthers.findAll", query = "SELECT t FROM TradeOthers t")
    , @NamedQuery(name = "TradeOthers.findByTradeOthersId", query = "SELECT t FROM TradeOthers t WHERE t.tradeOthersId = :tradeOthersId")
, @NamedQuery(name = "TradeOthers.findByAllByDesc", query = "SELECT t FROM TradeOthers t WHERE t.desc_id = :descId")})
public class TradeOthers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trade_others_id")
    private Integer tradeOthersId;
    @JoinColumn(name = "desc_id", referencedColumnName = "desc_id")
    @ManyToOne(optional = false)
    private TradeDesc descId;
    @JoinColumn(name = "userId", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public TradeOthers() {
    }

    public TradeOthers(Integer tradeOthersId) {
        this.tradeOthersId = tradeOthersId;
    }

    public Integer getTradeOthersId() {
        return tradeOthersId;
    }

    public void setTradeOthersId(Integer tradeOthersId) {
        this.tradeOthersId = tradeOthersId;
    }

    public TradeDesc getDescId() {
        return descId;
    }

    public void setDescId(TradeDesc descId) {
        this.descId = descId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradeOthersId != null ? tradeOthersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradeOthers)) {
            return false;
        }
        TradeOthers other = (TradeOthers) object;
        if ((this.tradeOthersId == null && other.tradeOthersId != null) || (this.tradeOthersId != null && !this.tradeOthersId.equals(other.tradeOthersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.TradeOthers[ tradeOthersId=" + tradeOthersId + " ]";
    }
    
}
