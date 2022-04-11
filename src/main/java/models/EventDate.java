/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 845593
 */
@Entity
@Table(name = "event_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventDate.findAll", query = "SELECT e FROM EventDate e")
    ,@NamedQuery(name = "EventDate.findAllByEvent", query = "SELECT e FROM EventDate e WHERE e.eventId=:eventId")     
    , @NamedQuery(name = "EventDate.findByEventDateId", query = "SELECT e FROM EventDate e WHERE e.eventDateId = :eventDateId")
    , @NamedQuery(name = "EventDate.findByStartDate", query = "SELECT e FROM EventDate e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "EventDate.findByEndDate", query = "SELECT e FROM EventDate e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "EventDate.findByScheduleDay1", query = "SELECT e FROM EventDate e WHERE e.scheduleDay1 = :scheduleDay1")
    , @NamedQuery(name = "EventDate.findByScheduleDay2", query = "SELECT e FROM EventDate e WHERE e.scheduleDay2 = :scheduleDay2")
    , @NamedQuery(name = "EventDate.findByHeld", query = "SELECT e FROM EventDate e WHERE e.held = :held")})
public class EventDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_date_id")
    private Integer eventDateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 2000)
    @Column(name = "schedule_day1")
    private String scheduleDay1;
    @Size(max = 2000)
    @Column(name = "schedule_day2")
    private String scheduleDay2;
    @Column(name = "held")
    private Boolean held;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventDateId")
    private List<EventDateUser> eventDateUserList;
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private Event eventId;

    public EventDate() {
    }

    public EventDate(Integer eventDateId) {
        this.eventDateId = eventDateId;
    }

    public EventDate(Integer eventDateId, Date startDate, Date endDate) {
        this.eventDateId = eventDateId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getEventDateId() {
        return eventDateId;
    }

    public void setEventDateId(Integer eventDateId) {
        this.eventDateId = eventDateId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getScheduleDay1() {
        return scheduleDay1;
    }

    public void setScheduleDay1(String scheduleDay1) {
        this.scheduleDay1 = scheduleDay1;
    }

    public String getScheduleDay2() {
        return scheduleDay2;
    }

    public void setScheduleDay2(String scheduleDay2) {
        this.scheduleDay2 = scheduleDay2;
    }

    public Boolean getHeld() {
        return held;
    }

    public void setHeld(Boolean held) {
        this.held = held;
    }

    @XmlTransient
    public List<EventDateUser> getEventDateUserList() {
        return eventDateUserList;
    }

    public void setEventDateUserList(List<EventDateUser> eventDateUserList) {
        this.eventDateUserList = eventDateUserList;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventDateId != null ? eventDateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventDate)) {
            return false;
        }
        EventDate other = (EventDate) object;
        if ((this.eventDateId == null && other.eventDateId != null) || (this.eventDateId != null && !this.eventDateId.equals(other.eventDateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EventDate[ eventDateId=" + eventDateId + " ]";
    }
    
}
