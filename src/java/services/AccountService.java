/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.User;


/**
 *
 * @author Jonat
 */
public class AccountService {
    public User login(String username, String password){
    String usernames[] = {"abe", "barb"};
    
    String thePassword = "password";
    
    if ((username.equals(usernames[0]) || username.equals(usernames[1])) && username != null && password.equals(thePassword) && password != null ){
      User existingUser = new User(username, null);
      return existingUser;
    } else{
        return null;
    }
}
}
