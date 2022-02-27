/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import java.util.List;
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

    static BikeService getInstance() {
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

    void assignEventId(User user, EventDate event_date) {
        List<Bike> bikes = user.getBikeList();

        for (int i = 1; i <= user.getBikeList().size(); i++) {
            bikes.get(i - 1).setBikeEventTickets(event_date.getAddressId().getCityId().getCityName() + user.getTicket() + "-" + i);
            bikeDB.update(bikes.get(i - 1));

        }
    }
}
