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

    /**
     * Inserts a new user/volunteer
     * @param email user's email
     * @param firstname user's name
     * @param lastname user's last name
     * @param password user's password
     * @param phone user's phone number
     * @param role user's role
     * @param address user's address
     * @param city location
     * @throws Exception if errors occur getting the city from the database.
     */
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

    /**
     * Logs user in 
     * @param email user's identifying email
     * @param password password matching email
     * @return User if login fails, returns null
     */
    public final User login(String email, String password) {

       // System.out.println("accountservice " + email + " " + password);
        try {
            User user = userDB.getUserByEmail(email);
            // System.out.println(user.getEmail());
            //System.out.println(user.getSalt());
            String saltedPassword = saltPassword(user, password);
            if(user.getPassword().equals(saltedPassword))
                return user;
            }
        catch (Exception e) {
                return null;
            }
            return null;
        }
    
    /**
     * Generates a salted password
     * @param user the user we are trying to identify
     * @param checkPassword password provided as an id that needs to be salted
     * @return String password that has been salted
     */
        private String saltPassword(User user, String checkPassword){
            String password = user.getPassword();
            try{
                if (user.getSalt() == null || user.getSalt().equals("")) {
                    user.setSalt(PasswordUtil.getSalt());
                    String newPassword = PasswordUtil.hashAndSaltPassword(password, user.getSalt());
                    user.setPassword(newPassword);
                    update(user);
                    return newPassword;
                } 
                else {
                    String code = PasswordUtil.hashAndSaltPassword(checkPassword, user.getSalt());
                    if (user.getPassword().equals(code)) {
                        return code;
                    }
                }
                }
            catch(Exception e){
                e.printStackTrace();
            }
        return null;
    }

    /*
     * logout function will be implemented in servlet side, no need to call method here to talk with database
     * use uuid to reset password. when user reset password, system will generate a uuid and send by email, client will use uuid uri to open the reset password page, if uuid matches, reset password, if not, resetting fails.
     *
     * @param password password to be reset
     * @param uuid identifying id
     * @return boolean whether password reset was successful
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
     * @param uuid identifying id 
     * @return User the user with matched uuid or null if no match found
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

    public Role getRole(int number) {
        return RoleDB.getInstance().getRole(number);
    }

    /**
     * Inserts a new user - used during registration
     * @param email user's email
     * @param firstname user's name
     * @param lastname user's last name
     * @param password user's password
     * @param phone user's phone number 
     * @param firstRole user's first choice for desired role
     * @param secondRole user's second choice for desired role
     * @param address user's address
     * @param city user's location
     * @param shirtSize user's shirt size
     * @param dietId user's dietary restriction
     * @throws NoSuchAlgorithmException  occurs if user enters a location value not in the database
     */
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

    /**
     * Change user password
     * @param uuid identifying token
     * @param password new password
     * @return boolean true if successful, false if not
     */
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
