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
import models.Role;
import services.AccountService;

/**
 *
 * @author 845593
 */
public class RegistrationServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/WEB-INF/RegistrationPage.jsp").forward(request, response);
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
        HttpSession session=request.getSession();
        //try to bring in values from the jsp, fail if any are empty.
        try {
            String fistname = request.getParameter("first_name");
            String lastname = request.getParameter("last_name");
            String email = request.getParameter("email");
            String city = request.getParameter("location");
            Long phone = Long.parseLong(request.getParameter("phone"));
            String password = request.getParameter("password");
            String address = request.getParameter("address");
//            System.out.println(request.getParameter("roleId"));
//            int roleId = Integer.parseInt(request.getParameter("roleId"));
            
//            if(roleId==2){
//                accountService.insert(email, fistname, lastname, password, phone, accountService.getRole(roleId), address, city);
//                session.setAttribute("email",email);
//                response.sendRedirect("Profile");
//            }
//            if(roleId==3){
                int dietId = Integer.parseInt(request.getParameter("diet"));
                short shirtSize=Short.parseShort(request.getParameter("tshirtsize"));
                int firstPosition=Integer.parseInt(request.getParameter("firstposition"))+2;
                int secondPosition=Integer.parseInt(request.getParameter("secondposition"))+2;
                //build a user using the information above
                AccountService accountService = AccountService.getInstance();
                accountService.insertNew(email, fistname, lastname, password, phone, 
                accountService.getRole(firstPosition),accountService.getRole(secondPosition), address, city, shirtSize, dietId);
                session.setAttribute("email",email);
                response.sendRedirect("Profile");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Please check your input, there is something wrong with your phone number format.");
            getServletContext().getRequestDispatcher("/WEB-INF/RegistrationPage.jsp").forward(request, response);
        
        }

    }

}
