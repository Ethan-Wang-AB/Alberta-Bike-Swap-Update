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

/**
 *
 * @author 845593
 */
public class BikeCheckServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
         String ticketnum = request.getParameter("ticketnum");
        String phonenum = request.getParameter("phonenum");
        
        
               
        if(ticketnum == null || phonenum == null ){
            request.setAttribute("message", "Both fields required");
            request.getRequestDispatcher("BikeCheckPage.jsp").forward(request, response);
        }
        
        else if(ticketnum.equals("") || phonenum.equals("") ){
            request.setAttribute("message", "Both fields required");
            request.getRequestDispatcher("BikeCheckPage.jsp").forward(request, response);
        }
        
        else if (ticketnum != null && !ticketnum.equals("") && phonenum!= null && !phonenum.equals("")  ){
            
            //Addtional check for the both password and ticket from database is require 
            //Start checking data here
            //Method
            
            
            
            //If correct, forward to the EditBikePage for checking Bike status, ticket number also get forward
            request.setAttribute("ticketnum", ticketnum);
            request.getRequestDispatcher("EditBikePage.jsp").forward(request, response);
            }
        
        
        
        
        
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
