/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 845593
 */
public class Event {
    private int eventId;        
    private String description;     
    private String mediaPath;       
    private ArrayList<Event_Date> event_date;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public ArrayList<Event_Date> getEvent_date() {
        return event_date;
    }

    public void setEvent_date(ArrayList<Event_Date> event_date) {
        this.event_date = event_date;
    }
    
    
    
    
}
