/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import models.Trade;

/**
 *
 * @author 845593
 */
public class TradeDB extends CommonDB<Trade>{
   private final static TradeDB tradeDB=new TradeDB();
   
   private TradeDB(){
   super();
   }
    @Override
    public boolean add(Trade a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Trade a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Trade a) {
                        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Trade> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      
   
   
    public final ArrayList<Trade> getAll(String cat)
    {
		return null;
        
    }    
    
    
    public final Trade getItem(int id)
    {
		return null;
        
    }    
    
    
      public static TradeDB getInstance()
    {
		return tradeDB;
        
    } 
}
