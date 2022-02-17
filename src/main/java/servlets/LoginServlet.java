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
public class LoginServlet extends HttpServlet {



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
        
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("logout") || request.getParameterMap().containsValue("logout")){
          session.invalidate();
                              getServletContext().getRequestDispatcher("/WEB-INF/Welcome.jsp").forward(request, response);

          }
        
               
                    getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response);
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
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        
        AccountService accountService=AccountService.getInstance();
        
        User user=accountService.login(email,password);
        System.out.print("servlet  :"+email+" "+password);
        
        if(user==null){
            request.setAttribute("errorMessage", "Your email and password are not matched with our system");
             getServletContext().getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(request, response);
        }
        else{
         session.setAttribute("email",email);
        response.sendRedirect("Profile");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
