/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.FaqDB;
import dataaccess.SafetyDB;
import java.util.ArrayList;
import models.Faq;
import models.Safety;

/**
 *
 * @author 845593
 */
public class FaqSafetyService {
    private FaqDB faqDB=FaqDB.getInstance();        
    private SafetyDB safetyDB=SafetyDB.getInstance();      

    
    
    
    public final boolean add(Faq fa)
    {
		return false;
        
    }    
    
    
    public final boolean add(Safety sa)
    {
		return false;
        
    }    
    
    
    public final boolean update(Faq fa)
    {
		return false;
        
    }    
    
    
    public final boolean update(Safety sa)
    {
		return false;
        
    }    
    
    
    public final boolean delete(Faq fa)
    {
		return false;
        
    }    
    
    
    public final boolean delete(Safety sa)
    {
		return false;
        
    }    
    
    
    public final ArrayList<Faq> getAllFaq()
    {
		return null;
        
    }    
    
    
    public final ArrayList<Safety> getAllSaf()
    {
		return null;
        
    }   
}
