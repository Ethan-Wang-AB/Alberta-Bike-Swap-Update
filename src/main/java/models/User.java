/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 845593
 */
public class User {
    private int userId;     
    private String userName;        
    private String email;       
    private Address address;        
    private String password;        
    private String salt;        
    private boolean active;     
    private Role role;     
    private ArrayList<Bike> bikes;      
    private long ticket;
    
}
