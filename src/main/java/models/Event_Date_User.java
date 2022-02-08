/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 845593
 */
public class Event_Date_User {
    private int id;
    private Event_Date event_date;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event_Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Event_Date event_date) {
        this.event_date = event_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
