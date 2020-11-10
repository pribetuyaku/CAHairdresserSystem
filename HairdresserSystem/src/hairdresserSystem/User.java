
package view;

/**
 *
 * @author Betuyaku
 */
public class User {
    private String userMail;
    private String userPass;
    
    public User(String userMail, String userPass){
        this.userMail = userMail;
        this.userPass = userPass;
    }
    
    public String getUserMail() {
        return userMail;
    }

    public String getUserPass() {
        return userPass;
    }
    
}