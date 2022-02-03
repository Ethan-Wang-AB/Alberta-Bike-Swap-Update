/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.EventDB;
import dataaccess.EventDateDB;
import models.Event;
import models.Event_Date;

/**
 *
 * @author 845593
 */
public class EventService {

    private EventDB eventDB = EventDB.getInstance();
    private EventDateDB eventDateDB = EventDateDB.getInstance();

    public final Event getEvent(int id) {
        return null;

    }

    public final Event_Date getEventDate(int id) {
        return null;

    }

    public final boolean editEvent(Event e) {
        return false;

    }

    public final boolean editEventDate(Event_Date e) {
        return false;
    }

    public final boolean delEvent(Event e) {
        return false;

    }

    public final boolean delEventDate(Event_Date e) {
        return false;
    }

    public final void scheduleNotify(Event_Date event) {

    }
}
