/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Safety;

/**
 *
 * @author 845593
 */
public class SafetyDB extends CommonDB<Safety> {

    private final static SafetyDB safetyDB = new SafetyDB();

    private SafetyDB() {
        super();
    }

    @Override
    public boolean add(Safety a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Safety a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Safety a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Safety> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static SafetyDB getInstance() {
        return safetyDB;
    }

}
