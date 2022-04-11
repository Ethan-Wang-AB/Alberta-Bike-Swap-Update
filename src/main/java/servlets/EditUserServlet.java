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
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author 845593
 */
public class EditUserServlet extends HttpServlet {

  
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
                    getServletContext().getRequestDispatcher("/WEB-INF/EditUserPage.jsp").forward(request, response);
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
            AccountService accountService=AccountService.getInstance();
            HttpSession session=request.getSession();
            User user=accountService.getByEmail((String) session.getAttribute("email"));
        try{
            //return to the profile page showing updated info
            response.sendRedirect("Profile");
        }catch(Exception e){
            //load error message, then reload page
            request.setAttribute("errorMessage","There was an issue during the update, please try again.");
            getServletContext().getRequestDispatcher("/WEB-INF/EditUserPage.jsp").forward(request, response);
        }
       
    }

    

}
