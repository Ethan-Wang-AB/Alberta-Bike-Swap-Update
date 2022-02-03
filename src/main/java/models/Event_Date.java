/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 845593
 */
public class Event_Date {
    private int eventDateId;        
    private ArrayList<User> users;      
    private Address address;        
    private Date start;     
    private Date end;  
    private ArrayList<String>schedule;
}
