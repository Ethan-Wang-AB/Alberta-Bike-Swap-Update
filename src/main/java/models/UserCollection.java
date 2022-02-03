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
public class UserCollection {
    private ArrayList<User> users;
    
    public void add(User user){
    users.add(user);
    }
 public void edit(User user){
  
    }
 
  public void remove(User user){
    users.remove(user);
    }


}
