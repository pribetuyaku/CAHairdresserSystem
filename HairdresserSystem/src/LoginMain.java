
import View.ViewCustomerHome;
import controller.ControllerLogin;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 * @author Betuyaku
 */
public class LoginMain {

    public static void main(String[] args) {

        new ControllerLogin();

        //teste
//        try {
//            JOptionPane.showMessageDialog(null, "Testando a conection");
//            Connection conn = new Model.ConnectionDB().connect();
//            JOptionPane.showMessageDialog(null, "Connected!");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro"+e);
//        }
    }

}
