package Service;

import Model.User;

import java.util.ArrayList;

public class UserService {
    ArrayList<User> users;
    public UserService(){
        users = new ArrayList<User>();
    }
    /*
    Returns 0 if register unsuccessful, userID otherwise
     */
    public int register(String username, String password){
        /*
        new User(username, password, User.Role.MANAGER);
         */
        User newUser = new User(username, password);
//        .contains didn't work because it probably uses .equals under the hood, which i couldn't get to work..
//        TODO: fix .contains

//        if(users.contains(newUser)){
//            return 0;
//        }
        for(User u : users){
            if(u.getUsername().equals(username)){
                return 0;
            }
        }
            newUser.setUserID(users.size() +1);
            users.add(newUser);
            return newUser.getUserID();

    }
    /*
    If I get a successful login, return the user's info (as object)
    otherwise, return null
     */
    public User login(String username, String password){
        for(User u : users){
            if(u.getUsername().equals(username)){
                if(u.getPassword().equals(password)){
                    return u;
                }
            }
        }
        return null;
    }
//    Overrode the parent's toString method (parent being Object)
    public String toString(){
        return "this is the user service!";
    }

}
