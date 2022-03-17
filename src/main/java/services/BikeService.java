/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;
import models.Bike;
import models.EventDate;
import models.User;

/**
 *
 * @author 845593
 */
public class BikeService {

    private static BikeService bikeService = new BikeService();

    private BikeService() {
    }

   public static BikeService getInstance() {
        return bikeService;
    }
    BikeDB bikeDB = BikeDB.getInstance();

    public final Bike getBike(int id) {
        Bike bike = bikeDB.getBike(id);
        return bike;

    }

    public final void updateBike(Bike bike) {
        bikeDB.update(bike);

    }

    public final void deleteBike(Bike bike) {
        bikeDB.delete(bike);
    }

    public void assignEventId(User user, EventDate event_date) {
        List<Bike> bikes = user.getBikeList();

        for (int i = 1; i <= user.getBikeList().size(); i++) {
            bikes.get(i - 1).setBikeEventTickets(event_date.getAddressId().getCityId().getCityName() + user.getTicket() + "-" + i);
            bikeDB.update(bikes.get(i - 1));

        }
    }
    
    public void updatePhoto(Bike bike, Part filePart) throws IOException{
         if (filePart != null) {
             
                InputStream fileContent = filePart.getInputStream();
                byte[] image = new byte[fileContent.available()];
               fileContent.read(image);

              //FileOutputStream writer = new FileOutputStream(file);
               //writer.write(image);
               bike.setPhoto(image);
                  
    }
         updateBike(bike);
    }
    
    public List<Bike> getAll(){
    return bikeDB.getAll();
    }
}
