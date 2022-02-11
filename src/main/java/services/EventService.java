/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EventDB;
import dataaccess.EventDateDB;
import models.Event;
import models.EventDate;

/**
 *
 * @author 845593
 */
public class EventService {

    private EventDB eventDB = EventDB.getInstance();
    private EventDateDB eventDateDB = EventDateDB.getInstance();

    public final Event getEvent(int id) {
        Event event=eventDB.getEvent(id);
        return event;
    }

    public final EventDate getEventDate(int id) {
        EventDate eventDate=eventDateDB.getEvent_Date(id);
        return eventDate;
    }

    public final boolean editEvent(Event e) {
        return eventDB.update(e);

    }

    public final boolean editEventDate(EventDate e) {
        return eventDateDB.update(e);
    }

    public final boolean delEvent(Event e) {
        return eventDB.delete(e);

    }

    public final boolean delEventDate(EventDate e) {
      return eventDateDB.delete(e);
    }

    /**
     * Need to fixed someday. very complex
     * @param event 
     */
    public final void scheduleNotify(EventDate event) {

    }
}
