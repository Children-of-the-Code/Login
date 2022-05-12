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
        User newUser = new User(username, password);
        if(users.contains(newUser)){
            return 0;
        }else{
            newUser.setUserID(users.size());
            users.add(newUser);
            return newUser.getUserID();
        }
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

}
