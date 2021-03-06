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
public class ProfileServlet extends HttpServlet {

    

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
            HttpSession session=request.getSession();
            User user=accountService.getByEmail((String) session.getAttribute("email"));
            session.setAttribute("roleId",user.getRoleId().getRoleId());
            request.setAttribute("bikes", user.getBikeList());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("phone", user.getCellNumber());
            request.setAttribute("Address", user.getAddressId());
            request.setAttribute("photo", user.getPhotoPath());
            request.setAttribute("ticket", user.getTicket());
            request.setAttribute("name", user.getName());
            request.setAttribute("city", user.getAddressId().getCityId().getCityName());
            String tshirt = "N";
            switch(user.getShirtSize()){
                case(1):{
                    tshirt = "S";
                    break;
                }
                case(2):{
                    tshirt = "M";
                    break;
                }
                case(3):{
                    tshirt = "L";
                    break;
                }
                case(4):{
                    tshirt = "XL";
                    break;
                }
                case(5):{
                    tshirt = "XXL";
                    break;
                }
            }
            request.setAttribute("tshirtSize", tshirt);
            request.setAttribute("diet", user.getDietId().getDietDes());
            if(user.getRoleIdFirst()!=null){
            request.setAttribute("firstposition", user.getRoleIdFirst().getRoleName());}
            else request.setAttribute("firstposition",null);
            if(user.getRoleIdSecond()!=null){
            request.setAttribute("secondposition", user.getRoleIdSecond().getRoleName());}
            else request.setAttribute("secondposition", null);
            if(user.getRoleId()!=null)
            request.setAttribute("vShift", user.getAddressId().getCityId().getCityName()+" "+user.getRoleId().getShift());
            else request.setAttribute("vShift",null);
        
        
        
            getServletContext().getRequestDispatcher("/WEB-INF/ProfilePage.jsp").forward(request, response);
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
                String formParam = request.getParameter("editType");
        if(formParam != null){
            if(formParam.equals("Info")){
                //load the standard form jsp
                response.sendRedirect("EditVolunteerEventInfo");
            }
            if(formParam.equals("Profile")){
                //load the standard form jsp
                response.sendRedirect("EditUser");
            }
        }
    }


}
