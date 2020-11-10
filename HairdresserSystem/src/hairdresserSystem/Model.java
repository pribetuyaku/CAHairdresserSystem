
package view;

/**
 *
 * @author Betuyaku
 */
public class Model {
    
    public boolean userLogin(User user){
        if(user.getUserMail().equals("admin") && user.getUserPass().equals("admin")){
            return true;
        }
        return false;
    }
    
}
