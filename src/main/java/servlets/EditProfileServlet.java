/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.EventDate;
import models.EventDateUser;
import models.Role;
import models.User;
import services.AccountService;
import services.EventService;

/**
 *
 * @author 845593
 */
public class EditProfileServlet extends HttpServlet {

  
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
                        AccountService accountService=AccountService.getInstance();
                        EventService eventService=new EventService();

              if(request.getParameterMap().containsKey("userEmail")){
               String shift=request.getParameter("finalshift");
                String userEmail=request.getParameter("userEmail");
                User u=accountService.getByEmail(userEmail);
                Role role=accountService.getRole(Integer.parseInt(shift));
                u.setRoleId(role);
                accountService.update(u);
                EventDateUser eventDateUser=new EventDateUser();
                String eventid=request.getParameter("eventId");
                int id=0;
                try{
                 id=Integer.parseInt(eventid);
                }catch(Exception idp){
                  request.setAttribute("eventIds", eventService.getAllEventDates());
                request.setAttribute("users",accountService.getAllUserExceptAdmin());
                request.setAttribute("roles",accountService.getRolesExceptAdmin());
                
                    getServletContext().getRequestDispatcher("/WEB-INF/EditProfilePage.jsp").forward(request, response);
                     return;
                 }
                EventDate eventDateId=eventService.getEventDate(id);
                eventDateUser.setEventDateId(eventDateId);
                eventDateUser.setUserId(u);
                if(!u.getEventDateUserList().contains(eventDateId))
                    eventService.addEventDateUser(eventDateUser);
               
              }
               List<User> users=accountService.getAllUserExceptAdmin();
                request.setAttribute("eventIds", eventService.getAllEventDates());
                request.setAttribute("users",users);
                request.setAttribute("roles",accountService.getRolesExceptAdmin());
                
                    getServletContext().getRequestDispatcher("/WEB-INF/EditProfilePage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
