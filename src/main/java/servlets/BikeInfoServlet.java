/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
        List<Bike> bikes=bikeService.getAll();
        int limit;
        // Price filter
        double minPrice=0;
        double maxPrice=99999;
        try{
                if(request.getParameter("minPrice") != null && request.getParameter("minPrice").length() > 0){
                minPrice=Double.parseDouble(request.getParameter("minPrice"));
                }
                if(request.getParameter("maxPrice") != null  && request.getParameter("maxPrice").length() > 0){
                maxPrice=Double.parseDouble(request.getParameter("maxPrice"));
                }
        } catch(Exception e){
                
        }
        //Index filter
        String index= "";
        if(request.getParameter("filterIndex")!= null  && request.getParameter("filterIndex").length() > 0){
            index = request.getParameter("filterIndex");
        }
        
        //Make filter
        String make = "";
        if(request.getParameter("filterMake")!= null  && request.getParameter("filterMake").length() > 0){
            make = request.getParameter("filterMake");
        }
        
        //Model filter
        String model = "";
        if(request.getParameter("filterModel")!= null  && request.getParameter("filterModel").length() > 0){
            index = request.getParameter("filterModel");
        }
        
       //Create a filtered array
            ArrayList<Bike> filtered = new ArrayList<>();
            for(int i = 0 ; i < bikes.size(); i++){
                Bike temp = bikes.get(i);
                if(temp.getPrice()>=minPrice && temp.getPrice()<=maxPrice && temp.getBikeIndex().contains(index)
                        && temp.getMaker().contains(make) && temp.getModel().contains(model)){
                            filtered.add(bikes.get(i));
                }
            }
        
            //set up the limit of bikes to show based on the filtered array
        if(filtered.size() <= 6){
            limit = filtered.size();
             request.setAttribute("nextDisplay", "none");
        }
        else{
            limit = 6;
        }
        
        //build array that is actually displayed using all the above info
            ArrayList<Bike> filter=new ArrayList<>();
            for(int i = 0 ; i < limit; i++){
                Bike temp = filtered.get(i);
                filter.add(temp);
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
        List<Bike> bikes=bikeService.getAll();  
        //get filter information
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
        
        //Index filter
        String index= "";
        if(request.getParameter("filterIndex")!= null  && request.getParameter("filterIndex").length() > 0){
            index = request.getParameter("filterIndex");
        }
        
        //Make filter
        String make = "";
        if(request.getParameter("filterMake")!= null  && request.getParameter("filterMake").length() > 0){
            make = request.getParameter("filterMake");
        }
        
        //Model filter
        String model = "";
        if(request.getParameter("filterModel")!= null  && request.getParameter("filterModel").length() > 0){
            index = request.getParameter("filterModel");
        }
        
        //Create a filtered array
            ArrayList<Bike> filtered = new ArrayList<>();
            for(int i = 0 ; i < bikes.size(); i++){
                Bike temp = bikes.get(i);
                if(temp.getPrice()>=minPrice && temp.getPrice()<=maxPrice && temp.getBikeIndex().contains(index)
                        && temp.getMaker().contains(make) && temp.getModel().contains(model)){
                            filtered.add(bikes.get(i));
                }
            }
            
            if(filtered.size() <= 6){
                request.setAttribute("nextDisplay", "none");
            }
            //use filtered in the actions. 
        //someone bought a bike
        if(action != null && action.contains("Buy")){
            String bikeId = action.substring(3);
            bikeService.deleteBike(bikeService.getBike(Integer.parseInt(bikeId)));
            request.setAttribute("message","Purchase complete!");
            //load page with bikes after purchase
            
            int limit;
            if(filtered.size() < 6){
                limit = filtered.size();
                request.setAttribute("prevDisplay", "none");
            }
            else{
                limit = 6;
            }
             if(filtered.size() == 6){
             request.setAttribute("nextDisplay", "none");
        }
             //need to create a filtered array
            ArrayList<Bike> result = new ArrayList<>();
            for(int i = 0 ; i < limit; i++){
            Bike temp = bikes.get(i);
            if(temp.getPrice()>=minPrice && temp.getPrice()<=maxPrice && temp.getBikeIndex().contains(index)
                    && temp.getMaker().contains(make) && temp.getModel().contains(model)){
                result.add(bikes.get(i));
            }
        }
            
        if(result.size() <= 6){
            request.setAttribute("nextDisplay", "none");
        }
        request.setAttribute("bikes", result);
        request.setAttribute("page", "0");
        request.setAttribute("prevDisplay", "none");
        getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
        }
        //otherwise, we are moving to another page.
        int limit;
        //see if we're moving to the next/previous page
        if(action.contains("Next")){
            ArrayList<Bike> bikeList = new ArrayList<>();
            int page = Integer.parseInt(action.substring(4)) + 6;
            if(page + 6 < filtered.size()){
                limit = page + 6;
            }
            else{
                limit = filtered.size();
                request.setAttribute("listMessage","You have reached the end of our selection!");
                request.setAttribute("nextDisplay", "none");
            }
            for(int i = page; i < limit ; i++){
                Bike temp = filtered.get(i);
                bikeList.add(temp);
                }
            request.setAttribute("bikes", bikeList);
            request.setAttribute("page", page);
            getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
        }
        
        if(action.contains("Prev")){
            ArrayList<Bike> bikeList=new ArrayList<>();
            int page = Integer.parseInt(action.substring(4));
            limit = page - 1;
            if(page -  6<= 0){
                page = 0;
                //request.setAttribute("listMessage","You have reached the end of our selection!");
                request.setAttribute("prevDisplay", "none");
            }
            else{
                page = page - 6;
            }
            for(int i = page; i <= limit; i++){
                Bike temp = filtered.get(i);
                bikeList.add(temp);
            } 
            request.setAttribute("bikes", bikeList);
            request.setAttribute("page", page);
            getServletContext().getRequestDispatcher("/WEB-INF/BikeInfoPage.jsp").forward(request, response);
        }
        
        

    }

   
}
