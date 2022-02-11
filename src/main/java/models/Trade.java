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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "trade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trade.findAll", query = "SELECT t FROM Trade t")
    , @NamedQuery(name = "Trade.findByTradeId", query = "SELECT t FROM Trade t WHERE t.tradeId = :tradeId")
    , @NamedQuery(name = "Trade.findByTransDate", query = "SELECT t FROM Trade t WHERE t.transDate = :transDate")})
public class Trade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trade_id")
    private Integer tradeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trans_date")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    @JoinColumn(name = "bike_id", referencedColumnName = "bike_id")
    @ManyToOne(optional = false)
    private Bike bikeId;
    @JoinColumn(name = "buyer_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User buyerId;
    @JoinColumn(name = "seller_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User sellerId;

    public Trade() {
    }

    public Trade(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Trade(Integer tradeId, Date transDate) {
        this.tradeId = tradeId;
        this.transDate = transDate;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Bike getBikeId() {
        return bikeId;
    }

    public void setBikeId(Bike bikeId) {
        this.bikeId = bikeId;
    }

    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradeId != null ? tradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trade)) {
            return false;
        }
        Trade other = (Trade) object;
        if ((this.tradeId == null && other.tradeId != null) || (this.tradeId != null && !this.tradeId.equals(other.tradeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Trade[ tradeId=" + tradeId + " ]";
    }
    
}
