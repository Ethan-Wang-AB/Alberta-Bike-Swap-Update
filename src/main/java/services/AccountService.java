/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.security.NoSuchAlgorithmException;
import models.Address;
import models.City;
import models.Role;
import models.State;
import models.User;

/**
 *
 * @author 845593
 */
public class AccountService {

    private static AccountService accountService = new AccountService();

    private UserDB userDB = UserDB.getInstance();

    private AccountService() {

    }

    public void insert(String email, String firstname, String lastname, String password, Long phone, Role role, String address, String city) throws Exception {
        Address add = new Address();
        add.setAddressDetail(address);

        City thecity = new City();
        thecity.setCityName(city);
        if (city.equalsIgnoreCase("calgary")) {
            thecity.setCityId(1);
            State state = new State();
            state.setStateId(1);
            state.setStateName("AB");
            thecity.setStateid(state);
        } else if (city.equalsIgnoreCase("edmonton")) {
            thecity.setCityId(3);
        } else if (city.equalsIgnoreCase("lethbridge")) {
            thecity.setCityId(2);
        } else {
            add = null;
        }

        if (add != null) {
            add.setCityId(thecity);
        }
        String salt = PasswordUtil.getSalt();
        String newPassword = PasswordUtil.hashAndSaltPassword(password, salt);
        User user = new User();
        user.setEmail(email);
        user.setName(lastname + ", " + firstname);
        user.setPassword(password);
        user.setSalt(salt);
        user.setCellNumber(phone);
        user.setAddressId(add);
        user.setRoleId(role);
        userDB.add(user);
    }

    public final User login(String email, String password) {

        //System.out.println(email+" "+password);
        try {
            User user = userDB.getUserByEmail(email);
            // System.out.println(user.getEmail());
            //System.out.println(user.getSalt());
            if (user.getSalt() == null && password.equals(user.getPassword())) {

                user.setSalt(PasswordUtil.getSalt());
                String newPassword = PasswordUtil.hashAndSaltPassword(password, user.getSalt());
                user.setPassword(newPassword);
                update(user);
                return user;
            } else {
                String code = PasswordUtil.hashAndSaltPassword(password, user.getSalt());
                System.out.println(user.getPassword());
                System.out.println(code);
                if (user.getPassword().equals(code)) {
                    return user;
                }

            }
        } catch (Exception e) {
        }

        return null;
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
     *
     * @param uuid
     * @return the user with matched uuid or null if no match found
     */
    public User getByUUID(String uuid) {

        return userDB.getByUUID(uuid);

    }

    public final void update(User user) {
        userDB.update(user);
    }

    public static AccountService getInstance() {
        return accountService;
    }
//    public final void deactive(User user)
//    {
//        
//    }   

    public Role getRole(int number) {
        return RoleDB.getInstance().getRole(number);
    }

    public void insert(String email, String fistname, String lastname, String password, Long phone, Role role, Role role0, String address, String city, short shirtSize) throws NoSuchAlgorithmException {
        Address add = new Address();
        add.setAddressDetail(address);

        City thecity = new City();
        thecity.setCityName(city);
        if (city.equalsIgnoreCase("calgary")) {
            thecity.setCityId(1);
            State state = new State();
            state.setStateId(1);
            state.setStateName("AB");
            thecity.setStateid(state);
        } else if (city.equalsIgnoreCase("edmonton")) {
            thecity.setCityId(3);
        } else if (city.equalsIgnoreCase("lethbridge")) {
            thecity.setCityId(2);
        } else {
            add = null;
        }

        if (add != null) {
            add.setCityId(thecity);
        }
        String salt = PasswordUtil.getSalt();
        String newPassword = PasswordUtil.hashAndSaltPassword(password, salt);
        User user = new User();
        user.setEmail(email);
        user.setName(lastname + ", " + fistname);
        user.setPassword(password);
        user.setSalt(salt);
        user.setCellNumber(phone);
        user.setAddressId(add);
        user.setRoleIdFirst(role);
        user.setRoleIdSecond(role0);
        user.setShirtSize(shirtSize);
        userDB.add(user);
    }
    
      public boolean changePassword(String uuid, String password) {
  
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
}
