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
@Table(name = "event_date_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventDateUser.findAll", query = "SELECT e FROM EventDateUser e")
    , @NamedQuery(name = "EventDateUser.findByEventDateUserId", query = "SELECT e FROM EventDateUser e WHERE e.eventDateUserId = :eventDateUserId")})
public class EventDateUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_date_user_id")
    private Integer eventDateUserId;
    @JoinColumn(name = "event_date_id", referencedColumnName = "event_date_id")
    @ManyToOne(optional = false)
    private EventDate eventDateId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public EventDateUser() {
    }

    public EventDateUser(Integer eventDateUserId) {
        this.eventDateUserId = eventDateUserId;
    }

    public Integer getEventDateUserId() {
        return eventDateUserId;
    }

    public void setEventDateUserId(Integer eventDateUserId) {
        this.eventDateUserId = eventDateUserId;
    }

    public EventDate getEventDateId() {
        return eventDateId;
    }

    public void setEventDateId(EventDate eventDateId) {
        this.eventDateId = eventDateId;
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
        hash += (eventDateUserId != null ? eventDateUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventDateUser)) {
            return false;
        }
        EventDateUser other = (EventDateUser) object;
        if ((this.eventDateUserId == null && other.eventDateUserId != null) || (this.eventDateUserId != null && !this.eventDateUserId.equals(other.eventDateUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EventDateUser[ eventDateUserId=" + eventDateUserId + " ]";
    }
    
}
