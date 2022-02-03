/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Role;

/**
 *
 * @author 845593
 */
public class RoleDB extends CommonDB<Role> {

    private final static RoleDB roleDB = new RoleDB();

    private RoleDB() {
        super();
    }

    @Override
    public boolean add(Role a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Role a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Role a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Role> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final Role getByName(String name) {
        return null;

    }

    public final RoleDB getRole(int id) {
        return null;

    }

    public static RoleDB getInstance() {
        return roleDB;
    }

}
