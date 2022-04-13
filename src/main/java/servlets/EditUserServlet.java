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
import models.Address;
import models.City;
import models.User;
import services.AccountService;
import services.EventService;

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
                    //get the user account
                    AccountService accountService=AccountService.getInstance();
                    HttpSession session=request.getSession();
                    User user=accountService.getByEmail((String) session.getAttribute("email"));
                    //load the user details onto the edit page
                    request.setAttribute("lastName", user.getName().substring(user.getName().lastIndexOf(" ")+1));
                    request.setAttribute("firstName", user.getName().substring(0, user.getName().lastIndexOf(" ")));
                    request.setAttribute("email", user.getEmail());
                    String phone = Long.toString(user.getCellNumber());
                    String areaCode = phone.substring(0, 3);
                    String phoneNumber = phone.substring(3);
                    request.setAttribute("areaCode", areaCode);
                    request.setAttribute("phone", phoneNumber);
                    request.setAttribute("address", user.getAddressId().getAddressDetail());
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
            //check what the user wishes to do
            String action = request.getParameter("action");
            if(action.equals("Profile")){
                response.sendRedirect("Profile");
            }
            if(action.equals("Change")){
            User user=accountService.getByEmail((String) session.getAttribute("email"));
            //check if each value is not null, isnt an empty string, and is  updated before changing user object.
            //user should be able to update some values without having to fill in all of them. 
        try{
            String name=request.getParameter("first_name")+" "+request.getParameter("last_name");
            if(name != null){
                user.setName(name);
            }
            String emailN=request.getParameter("email");
            if(emailN != null && emailN.length() > 0 && !emailN.equals(user.getEmail())){
                user.setEmail(emailN);
            }
            String password=request.getParameter("password");
            if(password != null && password.length() > 0 && !password.equals(user.getPassword())){
                user.setPassword(password);
            }
            long phone=Long.parseLong(request.getParameter("area_code")+request.getParameter("phone"));
            if(phone != user.getCellNumber()){
                user.setCellNumber(phone);
            }
            String addressN=request.getParameter("address");
            if(addressN != null && addressN.length() > 0 && !addressN.equals(user.getAddressId().getAddressDetail())){
                user.getAddressId().setAddressDetail(addressN);
            }
            String locationId = request.getParameter("location");
            if(locationId!= null && locationId.length() > 0){
                EventService eventService=new EventService();
                City city= eventService.getCity(Integer.parseInt(locationId));
                user.getAddressId().setCityId(city);
            }
            //update the user on the database using the new object
            accountService.update(user);
            //return to the profile page showing updated info
            session.setAttribute("email", user.getEmail());
            response.sendRedirect("Profile");
        }catch(Exception e){
            //load error message, then reload page
            request.setAttribute("errorMessage","There was an issue during the update, please try again.");
            getServletContext().getRequestDispatcher("/WEB-INF/EditUserPage.jsp").forward(request, response);
        }
            }
    }

    

}
