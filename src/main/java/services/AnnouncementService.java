/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.AnnouncementDB;
import java.util.Calendar;
import java.util.List;
import models.Announcement;

/**
 *
 * @author 845593
 */
public class AnnouncementService {
    
    private AnnouncementDB announcementDB=AnnouncementDB.getInstance();

  public Announcement getSoonestAnnouncement() {
        List<Announcement> announcements = announcementDB.getAll();

        if (!announcements.isEmpty()) {
            return announcements.get(announcements.size() - 1);
        }

        return null;
    }

    public String getAnnouncementsJson(List<Announcement> announcements) {
        if (!announcements.isEmpty()) {
            String json = "[ ";
            for(int i = 0; i < announcements.size(); i++) {
                if (i > 0) {
                    json += ", \n";
                }
                json += getAnnouncementJson(announcements.get(i));
            }

            json += " ]";
            return json;
        }

        //If there are no announcements available, generate a "no announcements" json
        return getAnnouncementJson(null);
    }
    
    public String getAnnouncementJson(Announcement announcement) {
        String json = "{\n";

        // If there are announcements available
        if (announcement != null) {
            String body = announcement.getBody();
       

            String newLine = System.getProperty("line.separator");
            body = body.replace(newLine, "<br>");
            Calendar cal=Calendar.getInstance();
            cal.setTime(announcement.getDate());
            json += "\"announcementId\" : " + announcement.getAnnouncementId() + ", \n";
            json += "\"title\" : \"" + announcement.getTitle() + "\", \n";
            json += "\"body\" : \"" + body + "\", \n";
            json += "\"date\" : \"" + cal.toString()+  "\", \n";
            json += "\"picture\" : \"" + announcement.getPicture() + "\", \n";
            json += "\"link\" : \"" + announcement.getLink() + "\"\n";
            json += "}";
            return json;
        }

        // If there are no announcements available
        json += "\"announcementId\" : " + 0 + ", \n";
        json += "\"title\" : \"No Announcements\", \n";
        json += "\"body\" : \"\", \n";
        json += "\"date\" : \"\", \n";
        json += "\"picture\" : \"\", \n";
        json += "\"link\" : \"\"\n";
        json += "}";
        return json;
    }
    
}
