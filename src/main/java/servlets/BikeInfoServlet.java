/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Bike;
import services.BikeService;

/**
 *
 * @author 845593
 */
public class BikeInfoServlet extends HttpServlet {

    
    

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
        BikeService bikeService = BikeService.getInstance();
       
        double minPrice=0;
        double maxPrice=99999;
        try{
                if(request.getParameter("minPrice") != null){
                minPrice=Double.parseDouble(request.getParameter("minPrice"));
                }
                if(request.getParameter("maxPrice") != null){
                maxPrice=Double.parseDouble(request.getParameter("maxPrice"));
                }
        }catch(Exception e){
                
        }
        
         List<Bike> bikes=bikeService.getAll();
         ArrayList<Bike> filter=new ArrayList<>();
         for(Bike b:bikes){
         if(b.getPrice()>=minPrice && b.getPrice()<=maxPrice)
        filter.add(b);         }
         request.setAttribute("bikes", filter);
        
        getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
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
