/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Announcement;
import models.City;
import models.Event;
import models.EventDate;
import services.AnnouncementService;
import services.EventService;
import services.SystemService;

/**
 *
 * @author 845593
 */
public class LocationServlet extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EventService eventService = new EventService(); // The class used to get city stuff from the database
        int cityId;

        /* Gets the cityId from session scope. If there is no cityId, if the user entered directly at the locations
        page without passing through the landing page, sets the cityId to Calgary ID */
        if (session.getAttribute("cityId") != null) {
            cityId = (int) session.getAttribute("cityId");
        } else {
            cityId = 1;
        }

        /* Gets the action from the get request (the one at the address bar). If there is no action, simply loads the
        page, which will load the Javascript and loads the actions */
        String action = request.getParameter("action");
        if (action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/locations.jsp").forward(request, response);
            return;
        }

        Event city = eventService.getEvent(cityId);
        try {
            switch(action) {
                /* If the action is getCity, it will use the methods at the end of this servlet to generate the JSON
                with the city information based on its ID */
                case "getCity":
                    response.getWriter().write(eventService.getEvent(cityId).getEventDesc());
                    break;
                case "getCityName":
                    response.getWriter().write(city.getEventDesc());
                    break;
                case "getCities": // Same as above, but gets the list of all cities
                    List<Event> cities = eventService.getAllEvents();
                    String citiesJson = eventService.getEventsJson(cities);
                    response.getWriter().write(citiesJson);
                            //.write(citiesJson);
                    break;
                case "getEvent": // List of events based on the cityId
                    EventDate eventdate = eventService.getSoonestEvent(city);
                    String eventJson = eventService.getDetailedEventJson(eventdate);
                    response.getWriter().write(eventJson);
                    break;
                case "updateCity": // This one updates the session cityId with the one from the dropdown
                    if (request.getParameter("cityId") != null) {
                        int updatedCityId = Integer.parseInt(request.getParameter("cityId"));
                        session.setAttribute("cityId", updatedCityId);
                    }
                    break;
                case "getAnnouncement": // Get soonest announcement
                    AnnouncementService announcementService = new AnnouncementService();
                    Announcement announcement = announcementService.getSoonestAnnouncement();
                    System.out.println(announcementService.getAnnouncementJson(announcement));
                    response.getWriter().write(announcementService.getAnnouncementJson(announcement));
                    break;
//                case "getPosterBackground": //Get current poster
//                    SystemService systemService = new SystemService();
//                    AbsSystem absSystem = systemService.getSystem(1);
//                    String background = absSystem.getCurrentPoster();
//                    response.getWriter().write(background);
//                    break;
            }
        } catch (Exception e) {
            Logger.getLogger(LocationServlet.class.getName()).log(Level.SEVERE, null, e);
            response.sendError(404);
        } finally {
            response.setStatus(200);
        }
    }

    /**
     * empty method for doPost
     * @param request an httpServletRequest to this servlet
     * @param response an httpServletResponse to the browser
     * @throws ServletException any exceptions the servlet may throw
     * @throws IOException any IO Exceptions the servlet may throw
     */
    // Since we are only using get requests, nothing here
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/locations.jsp").forward(request, response);
    }

}
