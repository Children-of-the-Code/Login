package Model;

public class User {
    String username;
    String password;
    int userID;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
//    TODO: fix equals method
    /*
    @Override
    public boolean equals(User u){
        if(u.getPassword() == password && u.getUsername() == username){
            return true;
        }
        return false;
    }*/
}
