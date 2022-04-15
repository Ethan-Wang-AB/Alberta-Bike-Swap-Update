/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.CityDB;
import dataaccess.EventDB;
import dataaccess.EventDateDB;
import dataaccess.EventDateUserDB;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.json.Json;
import models.City;
import models.Event;
import models.EventDate;
import javax.json.Json;
import javax.json.JsonReader;
import models.EventDateUser;

/**
 *
 * @author 845593
 */
public class EventService {

    private EventDB eventDB = EventDB.getInstance();
    private EventDateDB eventDateDB = EventDateDB.getInstance();
    private CityDB cityDB=new CityDB();
    private EventDateUserDB eventDateUserDB=EventDateUserDB.getInstance();

    public final Event getEvent(int id) {
        Event event = eventDB.getEvent(id);
        return event;
    }

    public final EventDate getEventDate(int id) {
        EventDate eventDate = eventDateDB.getEvent_Date(id);
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

    public EventDate getSoonestEvent(Event e) {

        List<EventDate> cityEvents = eventDateDB.getAllByEvent(e);
        Calendar cal = Calendar.getInstance(Locale.CANADA);

        EventDate earliestEvent = null;
        for (EventDate ed : cityEvents) {
            if (ed.getStartDate().compareTo(cal.getTime()) >= 0) {
                if (earliestEvent == null) {
                    earliestEvent = ed;
                } else if (earliestEvent.getStartDate().compareTo(ed.getStartDate()) > 0) {
                    earliestEvent = ed;
                }
            }
        }

        return earliestEvent;
    }

    public String getEventsDateJson(List<EventDate> events) {
        if (!events.isEmpty()) {
            String json = "[ ";
            for (int i = 0; i < events.size(); i++) {
                if (i > 0) {
                    json += ", \n";
                }
                json += getEventDateJson(events.get(i));
            }

            json += " ]";
            return json;
        }

        return getEventDateJson(null);
    }

    public String getEventDateJson(EventDate event) {
        String json = "{\n";

        if (event != null) {

            json += "\"eventDateId\" : " + event.getEventDateId() + ", \n";
            json += "\"address\" : \"" + event.getAddressId() + "\", \n";
            json += "\"date\" : \"" + event.getStartDate() + "\", \n";
            json += "\"schedule\" : \"" +"day1: "+ event.getScheduleDay1() + " day2: "+event.getScheduleDay2()+"\", \n";
            json += "}";
            return json;
        }

        json += "\"eventId\" : " + 0 + ", \n";
        json += "\"address\" : \"No Events\", \n";
        json += "\"date\" : \"\", \n";
        json += "\"schedule\" : \"\", \n";
        json += "}";
        return json;
    }

    public String getEventsJson(List<Event> events) {
        String json = "[ ";
        for (int i = 0; i < events.size(); i++) {
            if (i > 0) {
                json += ", \n";
            }
            json += getEventJson(events.get(i));
        }

        json += " ]";
        return json;
    }

    /**
     * Formats a list of city attributes into JSON format
     *
     * @param city The city to get the attributes from
     * @return String a JSON formatted list of city attributes
     */
    private String getEventJson(Event event) {
        return Json.createObjectBuilder().add("cityId", event.getEventId())
                .add("cityName", event.getEventDesc()).add("background", event.getMediaPath()).build().toString();
//        JSONObject obj= new JSONObject();
//        obj.put("cityId",event.getEventId());
//        
//        
//        String json = "{\n";
//        json += "\"cityId\" : " + event.getEventId() + ", \n";
//        json += "\"cityName\" : \"" + event.getEventDesc() + "\", \n";
//        json += "\"background\" : \"" + event.getMediaPath() + "\"\n";
//        json += "}";
//        return json;
    }

    public List<EventDate> getAllEventDates() {
        return eventDateDB.getAll();
    }
    public List<Event> getAllEvents(){
    return eventDB.getAll();
    }

    public String getDetailedEventJson(EventDate event) {
        String json = "{\n";

        // If there are events available
        if (event != null) {
            json += "\"eventId\" : " + event.getEventDateId() + ", \n";
            json += "\"address\" : \"" + event.getAddressId().getAddressDetail() + "\", \n";
            json += "\"date\" : \"" + (event.getStartDate().getYear()+1900)+", "+(event.getStartDate().getMonth()+1)+", "+event.getStartDate().getDate() +" - "+(event.getEndDate().getYear()+1900)+", "+(event.getEndDate().getMonth()+1)+", "+event.getEndDate().getDate()+ "\", \n";
            json += "\"consign\" : \"" + (event.getStartDate().getYear()+1900)+", "+(event.getStartDate().getMonth()+1)+", "+event.getStartDate().getDate()+" Time: " +event.getScheduleDay1()+ "\", \n";
            json += "\"buy\" : \"" +(event.getEndDate().getYear()+1900)+", "+(event.getEndDate().getMonth()+1)+", "+event.getEndDate().getDate() +" Time: "+event.getScheduleDay2()+ "\", \n";

            json += "\"donate\" : \"Both Days\"\n";
            json += "}";
            return json;
        }

        // If there are no events available
        json += "\"eventId\" : " + 0 + ", \n";
        json += "\"address\" : \"TBA\", \n";
        json += "\"date\" : \"TBA\", \n";
        json += "\"consign\" : \"TBA\", \n";
        json += "\"buy\" : \"TBA\", \n";
        json += "\"donate\" : \"TBA\"\n";
        json += "}";
        return json;
    }

    public City getCity(int id){
        return cityDB.getCity(id);
    }
    public final void scheduleNotify(EventDate event) {

    }
    public final void addEvent(EventDate e){
    
    eventDateDB.add(e);
    }

    public void addEventDateUser(EventDateUser eventDateUser) {
        eventDateUserDB.add(eventDateUser);
    }
  
}
