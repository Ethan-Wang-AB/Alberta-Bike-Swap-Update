/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Address;
import models.City;
import models.Event;
import models.EventDate;
import services.EventService;

/**
 *
 * @author 845593
 */
public class EventServlet extends HttpServlet {

   

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        EventService eventService=new EventService(); 
         if(request.getParameterMap().containsKey("delete")){
        String id=request.getParameter("id");
        EventDate e=eventService.getEventDate(Integer.parseInt(id));
        eventService.delEventDate(e);
        }
        request.setAttribute("eventdata", eventService.getAllEventDates());
        
        getServletContext().getRequestDispatcher("/WEB-INF/EditEventPage.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("action");
                EventService eventService=new EventService();

        if(action!=null &&action.equals("add")){
        String location=request.getParameter("location");
        Calendar calS=Calendar.getInstance();
        String date=request.getParameter("trip-start");
        
        String[]day=date.split("-");
        calS.set(Integer.parseInt(day[0]), Integer.parseInt(day[1])-1, Integer.parseInt(day[2]));
        
        
        
        String schedule1=request.getParameter("day1time");
        String schedule2=request.getParameter("day2time");
        String address=request.getParameter("address");
        Address addressId=new Address();
        addressId.setAddressDetail(address);
        City cityId=eventService.getCity(Integer.parseInt(location));
        addressId.setCityId(cityId);
        //calS.setTime(dateN);
        Date start=calS.getTime();
      
        calS.add(Calendar.DATE,1);
        Date end=calS.getTime();
        EventDate event=new EventDate();
        event.setEndDate(end);
        event.setStartDate(start);
        Event eventId=eventService.getEvent(Integer.parseInt(location));
        event.setEventId(eventId);
        event.setAddressId(addressId);
        event.setHeld(false);
        event.setScheduleDay1(schedule1);
        event.setScheduleDay2(schedule2);
        //addressId.getEventDateList().add(event);
        eventService.addEvent(event);
        request.setAttribute("eventdata", eventService.getAllEventDates());
        
        getServletContext().getRequestDispatcher("/WEB-INF/EditEventPage.jsp").forward(request, response);
        }
        else if(action!=null && action.equals("edit")){
         String id=request.getParameter("eventid");
         
         EventDate e=eventService.getEventDate(Integer.parseInt(id));
         
        if(e==null){
          request.setAttribute("eventdata", eventService.getAllEventDates());
        request.setAttribute("message","the event id is invalid");
        getServletContext().getRequestDispatcher("/WEB-INF/EditEventPage.jsp").forward(request, response);
        return;
        }
         
         
         String location=request.getParameter("location_edit");
         String date=request.getParameter("trip-start_edit");
                 System.out.println("date get from frontend: "+date);

       String[]day=date.split("-");
  //     Date dateN=new Date(date); 
       Calendar calS=Calendar.getInstance();
       //calS.setTime(dateN);
calS.set(Integer.parseInt(day[0]), Integer.parseInt(day[1])-1, Integer.parseInt(day[2]));
        Date start=calS.getTime();
         
         String schedule1=request.getParameter("day1time_edit");
        String schedule2=request.getParameter("day2time_edit");
        String address=request.getParameter("address_edit");
        Address addressId=new Address();
        addressId.setAddressDetail(address);
        City cityId=eventService.getCity(Integer.parseInt(location));
        addressId.setCityId(cityId);
        
        calS.add(Calendar.DATE,1);
        Date end=calS.getTime();
        e.setEndDate(end);
        e.setStartDate(start);
        Event eventId=eventService.getEvent(Integer.parseInt(location));
        e.setEventId(eventId);
        e.setAddressId(addressId);
        e.setScheduleDay1(schedule1);
        e.setScheduleDay2(schedule2);
       // addressId.getEventDateList().add(event);
        eventService.editEventDate(e);
        request.setAttribute("eventdata", eventService.getAllEventDates());
        
        getServletContext().getRequestDispatcher("/WEB-INF/EditEventPage.jsp").forward(request, response);
 
        
       
        }
        

    }

}
