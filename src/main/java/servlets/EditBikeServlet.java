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
import models.Bike;
import models.User;
import services.AccountService;
import services.BikeService;

/**
 *
 * @author 845593
 */
public class EditBikeServlet extends HttpServlet {

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
        if(request.getParameterMap().containsKey("action") &&request.getParameter("action").equals("delete") ){
        int id=Integer.parseInt(request.getParameter("id"));
        Bike bike=bikeService.getBike(id);
        bikeService.deleteBike(bike);
        request.setAttribute("Message","the bike id:"+id+" has been deleted");
        }
        
        
        request.setAttribute("bikes", bikeService.getAll());

        getServletContext().getRequestDispatcher("/WEB-INF/editBikeInventoryPage.jsp").forward(request, response);
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
        AccountService accountService = AccountService.getInstance();
        String action = request.getParameter("action");
        String id, make, model, price, bikeIndex;
        if (action.equals("add")) {
            make = request.getParameter("bikeMake_add");
            bikeIndex = request.getParameter("bikeIndex_add");
            model = request.getParameter("bikeModel_add");
            price = request.getParameter("bikePrice_add");
            double priceD = Double.parseDouble(price);
            Bike bike = new Bike();
            bike.setMaker(make);
            bike.setModel(model);
            bike.setToSell(true);
            bike.setDonate(false);
            bike.setPrice(priceD);
            bike.setBikeIndex(bikeIndex);
            User user = accountService.getAdmin();
            bike.setUserId(user);
            bikeService.addBike(bike);
            request.setAttribute("Message","the bike has been added");

        } else if (action.equals("edit")) {
            id = request.getParameter("bikeId_edit");
            make = request.getParameter("bikeMake_edit");
            bikeIndex = request.getParameter("bikeIndex_edit");
            model = request.getParameter("bikeModel_edit");
            price = request.getParameter("bikePrice_edit");
            double priceD = Double.parseDouble(price);
            Bike bike = bikeService.getBike(Integer.parseInt(id));
            bike.setMaker(make);
            bike.setModel(model);
            bike.setPrice(priceD);
            bike.setBikeIndex(bikeIndex);
            bikeService.updateBike(bike);
           request.setAttribute("Message","the bike has been edited");

        }
        request.setAttribute("bikes", bikeService.getAll());
        getServletContext().getRequestDispatcher("/WEB-INF/editBikeInventoryPage.jsp").forward(request, response);

    }

}
