/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;

/**
 *
 * @author 845593
 */
public class BikeCheckServlet extends HttpServlet {

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

        String ticketnum = request.getParameter("ticketnum");
        String phonenum = request.getParameter("phonenum");

        if (ticketnum == null || phonenum == null) {
            request.setAttribute("message", "Both fields required");
            getServletContext().getRequestDispatcher("/WEB-INF/BikeCheckPage.jsp").forward(request, response);
        } else if (ticketnum.equals("") || phonenum.equals("")) {
            request.setAttribute("message", "Both fields required");
            request.getServletContext().getRequestDispatcher("/WEB-INF/BikeCheckPage.jsp").forward(request, response);
        } else if (ticketnum != null && !ticketnum.equals("") && phonenum != null && !phonenum.equals("")) {

            //Addtional check for the both password and ticket from database is require 
            //Start checking data here
            //Method
            //If correct, forward to the EditBikePage for checking Bike status, ticket number also get forward
            request.setAttribute("ticketnum", ticketnum);
            getServletContext().getRequestDispatcher("/WEB-INF/editBikePage.jsp").forward(request, response);
        }

        // getServletContext().getRequestDispatcher("/WEB-INF/BikeCheckPage.jsp").forward(request, response);
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
        String ticket = request.getParameter("ticketnum");
        String phone = request.getParameter("phonenum");
        Long phoneNum;
        AccountService accountService = AccountService.getInstance();
        User user = new User();
        String message = "ticket number is not exists";
        try {
            user = accountService.getByTicket(Integer.parseInt(ticket));
            message = "ticket number exists;";
            phoneNum = Long.parseLong(phone);
        } catch (Exception e) {
            if (user != null) {
                message = message + "phone number is not in correct format";

            }
            user = null;
        }

        if (user == null) {
            request.setAttribute("message",message);
            getServletContext().getRequestDispatcher("/WEB-INF/BikeCheckPage.jsp").forward(request, response);
        }else{
            request.setAttribute("bikes", user.getBikeList());
            getServletContext().getRequestDispatcher("/WEB-INF/editBikePage.jsp").forward(request, response);

        
        }
    }

}
