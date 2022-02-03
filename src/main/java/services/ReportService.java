/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import dataaccess.TradeDB;
import dataaccess.UserDB;
import models.Event;
import models.Report;

/**
 *
 * @author 845593
 */
public class ReportService{

private UserDB userDB=UserDB.getInstance();
private BikeDB bikeDB=BikeDB.getInstance();
private TradeDB tradeDB=TradeDB.getInstance();
    

  public final Report bikeReport()
    {
		return null;
        
    }    
    
    
    public final Report tradeReport()
    {
		return null;
        
    }    
    
    
    public final Report userReport()
    {
		return null;
        
    }    
}
