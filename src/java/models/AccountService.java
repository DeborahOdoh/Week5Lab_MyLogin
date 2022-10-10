package models;

/**
 *
 * @author odohd
 */
public class AccountService {
    final String user1 = "abe";
    final String user2 = "barb";
    final String uPassword = "password";
    String username, password;
    
    public AccountService(){
        
    }
    
     public AccountService(String username, String password){
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
    
    public AccountService login(String username, String password){
        if((username.equals(user1) || username.equals(user2)) & password.equals(uPassword)){
           AccountService user = new AccountService(username, null);
           return user;
        }
        else{
            return null;
        }
    }
    
}
