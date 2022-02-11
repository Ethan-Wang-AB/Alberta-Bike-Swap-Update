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
        return null;

    }

    public final EventDate getEventDate(int id) {
        return null;

    }

    public final boolean editEvent(Event e) {
        return false;

    }

    public final boolean editEventDate(EventDate e) {
        return false;
    }

    public final boolean delEvent(Event e) {
        return false;

    }

    public final boolean delEventDate(EventDate e) {
        return false;
    }

    public final void scheduleNotify(EventDate event) {

    }
}
