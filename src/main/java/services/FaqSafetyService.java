/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.FaqDB;
import dataaccess.SafetyDB;
import java.util.ArrayList;
import java.util.List;
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
          return faqDB.add(fa);
        
    }    
    
    
    public final boolean add(Safety sa)
    {
		return safetyDB.add(sa);
        
    }    
    
    
    public final boolean update(Faq fa)
    {
		return faqDB.update(fa);
        
    }    
    
    
    public final boolean update(Safety sa)
    {
		return safetyDB.update(sa);
        
    }    
    
    
    public final boolean delete(Faq fa)
    {
		return faqDB.delete(fa);
        
    }    
    
    
    public final boolean delete(Safety sa)
    {
		return safetyDB.delete(sa);
        
    }    
    
    
    public final List<Faq> getAllFaq()
    {
		return faqDB.getAll();
        
    }    
    
    
    public final List<Safety> getAllSaf()
    {
		return safetyDB.getAll();
        
    }   
}
