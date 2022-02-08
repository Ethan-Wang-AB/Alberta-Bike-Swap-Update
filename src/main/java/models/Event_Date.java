/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 845593
 */
public class Event_Date {
    private Event event;
    private int eventDateId;        
    private ArrayList<Event_Date_User> users;      
    private Address address;        
    private Date start;     
    private Date end;  
    private String schedule;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getEventDateId() {
        return eventDateId;
    }

    public void setEventDateId(int eventDateId) {
        this.eventDateId = eventDateId;
    }

    public ArrayList<Event_Date_User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Event_Date_User> users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    
}
