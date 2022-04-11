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
import models.Diet;
import models.Role;
import models.User;
import services.AccountService;

/**
 *
 * @author 851649
 */
public class EditVolunteerEventInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService accountService=AccountService.getInstance();
        request.setAttribute("roles", accountService.getRolesExceptAdmin());
        request.setAttribute("diets", accountService.getAllDiet());
        
        getServletContext().getRequestDispatcher("/WEB-INF/editVolunteerEventInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService accountService = AccountService.getInstance();
        HttpSession session = request.getSession();
        User user = accountService.getByEmail((String) session.getAttribute("email"));
        
        
        try {
        String tshirt = request.getParameter("tshirtsize");
        String diet = request.getParameter("diet");
        String role_first = request.getParameter("firstposition");
        String role_second = request.getParameter("secondposition");
        Role roleIdFirst=accountService.getRole(Integer.parseInt(role_first));
        Role roleIdSecond=accountService.getRole(Integer.parseInt(role_second));
        Diet dietId=accountService.getDiet(Integer.parseInt(diet));
        user.setShirtSize(Short.parseShort(tshirt));
        user.setDietId(dietId);
        user.setRoleIdFirst(roleIdFirst);
        user.setRoleIdSecond(roleIdSecond);
        accountService.update(user);
            //return to the profile page showing updated info
            response.sendRedirect("Profile");
        } catch (Exception e) {
            //load error message, then reload page
            request.setAttribute("errorMessage", "There was an issue during the update, please try again.");
            getServletContext().getRequestDispatcher("/WEB-INF/editVolunteerEventInfo.jsp").forward(request, response);
        }

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
