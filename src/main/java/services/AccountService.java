/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 845593
 */
public class AccountService {

    private UserDB userDB = UserDB.getInstance();

    public final User login(String username, String password) {
        User user = userDB.getUser(username);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    /*
     * logout function will be implemented in servlet side, no need to call method here to talk with database
     * @param user 
     */
//    public final void logout(User user)
//    {
//       
//    }    
    /**
     * use uuid to reset password. when user reset password, system will generate a uuid and send by email, client will use uuid uri to open the reset password page, if uuid matches, reset password, if not, resetting fails.
     *
     * @param password
     * @param uuid
     * @return
     */
    public final boolean resetpassword(String password, String uuid) {

        try {
            User user = userDB.getByUUID(uuid);
            //System.out.println(user.getEmail());
            user.setPassword(password);
            user.setResetPasswordUuid(null);
            //System.out.println("set new password "+ user.getPassword()+user.getResetPasswordUuid());
            userDB.update(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public User getByEmail(String email) {

        return userDB.getUserByEmail(email);

    }

    public User getByUsername(String username) {

        return userDB.getUser(username);

    }

    
    /**
     * used for resetting password credential validation
     * @param uuid
     * @return the user with matched uuid or null if no match found
     */
    public User getByUUID(String uuid) {

        return userDB.getByUUID(uuid);

    }

    public final void update(User user) {
        userDB.update(user);
    }

//    public final void deactive(User user)
//    {
//        
//    }    
}
