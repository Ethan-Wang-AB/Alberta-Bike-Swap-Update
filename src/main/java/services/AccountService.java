/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.DietDB;
import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import models.Address;
import models.Bike;
import models.City;
import models.Diet;
import models.EventDate;
import models.Role;
import models.State;
import models.User;

/**
 *
 * @author 845593
 */
public class AccountService {

    private static AccountService accountService = new AccountService();
    private DietDB dietDB=new DietDB();
    private UserDB userDB = UserDB.getInstance();
    private BikeService bikeService = BikeService.getInstance();

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

        System.out.println("accountservice " + email + " " + password);
        try {
            User user = userDB.getUserByEmail(email);
            // System.out.println(user.getEmail());
            //System.out.println(user.getSalt());

            if (user == null) {
                return null;
            }
            if ((user.getSalt() == null || user.getSalt().equals("")) && password.equals(user.getPassword())) {

                user.setSalt(PasswordUtil.getSalt());
                String newPassword = PasswordUtil.hashAndSaltPassword(password, user.getSalt());
                System.out.println(newPassword);

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

    public void insertNew(String email, String firstname, String lastname, String password, Long phone, Role firstRole, Role secondRole, String address, String city, short shirtSize, int dietId) throws NoSuchAlgorithmException {
        Address add = new Address();
        add.setAddressDetail(address);
        City thecity = new City();
        if (city.equalsIgnoreCase("1")) {
            thecity.setCityId(1);
            State state = new State();
            state.setStateId(1);
            state.setStateName("AB");
            thecity.setStateid(state);
            thecity.setCityName("Calgary");
        } else if (city.equalsIgnoreCase("2")) {
            thecity.setCityId(2);
            thecity.setCityName("Lethbridge");
        } else if (city.equalsIgnoreCase("3")) {
            thecity.setCityId(3);
            thecity.setCityName("Edmonton");
        }else {
            add = null;
        }

        if (add != null) {
            add.setCityId(thecity);
        }
        String salt = PasswordUtil.getSalt();
        String newPassword = PasswordUtil.hashAndSaltPassword(password, salt);
        User user = new User();
        user.setEmail(email);
        user.setName(firstname + " " + lastname);
        user.setPassword(password);
        user.setSalt(salt);
        user.setCellNumber(phone);
        user.setAddressId(add);
        user.setRoleId(firstRole);
        user.setRoleIdFirst(firstRole);
        user.setRoleIdSecond(secondRole);
        user.setShirtSize(shirtSize);
        Diet diet = new Diet(dietId);
        user.setDietId(diet);
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

    void assignTicket(User user, EventDate event_date) {
        int ticket = Integer.parseInt(String.valueOf(event_date.getEventDateId()) + String.valueOf(user.getUserId()));
        user.setTicket(ticket);
        bikeService.assignEventId(user, event_date);

        userDB.update(user);
    }

    public User getByTicket(int parseInt) {
           return userDB.getUserByTicket(parseInt);
    }
    
    public List<User> getAllUser(){
    return userDB.getAll();
    }
    
    public List<Role> getRoles(){
    return RoleDB.getInstance().getAll();
    }

    public List<User> getAllUserExceptAdmin() {
        Role role=this.getRole(1);
         return userDB.getAllExceptAdmin(role);
    }

    public Diet getDiet(int parseInt) {
       return dietDB.getDiet(parseInt);

    }

    public List<Diet> getAllDiet(){
    return dietDB.getAll();
    }

    public List<Role> getRolesExceptAdmin() {
      List<Role> roles=getRoles();
      for(int i=0;i<roles.size();i++){
      if(roles.get(i).getRoleId()==1){
      roles.remove(roles.get(i));
      break;
      }
      }
      return roles;
      
    }

    public User getAdmin() {
         return userDB.getByUserId(1);
    }
  
}
