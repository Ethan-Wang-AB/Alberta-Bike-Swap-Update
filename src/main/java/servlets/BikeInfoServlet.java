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
        } catch(Exception e){
                
        }
        
        List<Bike> bikes=bikeService.getAll();
        ArrayList<Bike> filter=new ArrayList<>();
        for(int i = 0 ; i < 6; i++){
            if(bikes.get(i).getPrice()>=minPrice && bikes.get(i).getPrice()<=maxPrice)
                filter.add(bikes.get(i));
        }
        request.setAttribute("bikes", filter);
        request.setAttribute("page", "0");
        request.setAttribute("prevDisplay", "none");
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
        BikeService bikeService = BikeService.getInstance();
        String action = request.getParameter("action");
        double minPrice=0;
        double maxPrice=9999;
        try{
                if(request.getParameter("minPrice") != null && request.getParameter("minPrice").length() > 0){
                minPrice=Double.parseDouble(request.getParameter("minPrice"));
                }
                if(request.getParameter("maxPrice") != null && request.getParameter("minPrice").length() > 0){
                maxPrice=Double.parseDouble(request.getParameter("maxPrice"));
                }
        } catch(Exception e){
                
        }
        List<Bike> bikes=bikeService.getAll();
        int limit;
        //see if we're moving to the next/previous page
        if(action.contains("Next")){
            ArrayList<Bike> bikeList = new ArrayList<>();
            int page = Integer.parseInt(action.substring(4)) + 6;
            if(page + 6 < bikes.size()){
                limit = page + 6;
            }
            else{
                limit = bikes.size();
                request.setAttribute("listMessage","You have reached the end of our selection!");
                request.setAttribute("nextDisplay", "none");
            }
            for(int i = page; i < limit ; i++){
                if(bikes.get(i).getPrice()>=minPrice && bikes.get(i).getPrice()<=maxPrice){
                        bikeList.add(bikes.get(i));
                }
                    page++;
                }
            request.setAttribute("bikes", bikeList);
            request.setAttribute("page", page);
            getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
        }
        
        if(action.contains("Prev")){
            ArrayList<Bike> bikeList=new ArrayList<>();
            int page = Integer.parseInt(action.substring(4));
            limit = page - 1;
            if(page - 7 <= 0){
                page = 0;
                request.setAttribute("listMessage","You have reached the end of our selection!");
                request.setAttribute("prevDisplay", "none");
            }
            else{
                page = page - 7;
            }
            for(int i = page; i < limit; i++){
                if(bikes.get(i).getPrice()>=minPrice && bikes.get(i).getPrice()<=maxPrice){
                        bikeList.add(bikes.get(i));
                }
                } 
            request.setAttribute("bikes", bikeList);
            request.setAttribute("page", page);
            getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
        }
        
        

    }

   
}
