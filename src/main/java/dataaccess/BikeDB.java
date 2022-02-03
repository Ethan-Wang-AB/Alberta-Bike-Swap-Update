/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Bike;

/**
 *
 * @author 845593
 */
public class BikeDB extends CommonDB<Bike> {

    private final static BikeDB bikeDB = new BikeDB();
    private BikeDB(){
    super();
    }
    public ArrayList<Bike> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        return null;

    }

    public final ArrayList<Bike> getAll(String cat) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        return null;

    }

    public final Bike getBike(int id) {
        return null;

    }

    @Override
    public boolean add(Bike a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bike a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Bike a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static BikeDB getInstance() {
        return bikeDB;

    }

}
