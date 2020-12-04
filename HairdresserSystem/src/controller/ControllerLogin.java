package controller;

import DAO.CustomerDAO;
import DAO.HairdresserDAO;
import Model.ConnectionDB;
import View.ViewLogin;
import View.ViewRegCustomer;
import View.ViewCustomerHome;
import View.ViewRegHairdresser;
import Model.ConnectionDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Betuyaku
 */
public class ControllerLogin implements ActionListener {

    ViewLogin view;
    ConnectionDB model;

    public ControllerLogin() {
        this.view = new ViewLogin(this);
        this.model = new ConnectionDB();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String um,pw;
        um = view.getEmail();
        pw = view.getPassword();

        try {

            CustomerDAO cdao = new CustomerDAO();  

            if (cdao.exeLogin(um, pw)) {
                //open the next screen CustomerArea or HairdresserArea
                ViewCustomerHome cust = new ViewCustomerHome();
                JOptionPane.showMessageDialog(null, "Welcome!");
                cust.ViewCustomerHome(); //calling method ViewCustomerHome
                getView().setVisible(false); //close the ViewLogin
                
            } else{
                //ViewHairdresserHome hair = new ViewHairdresserHome();
                JOptionPane.showMessageDialog(null, "Welcome!");
                 getView().setVisible(false); //close the ViewLogin
            } 
        } catch (Exception e) {

        }
    }
    
    
    
    public ConnectionDB getModel() {
        return model;
    }

    public void setModel(ConnectionDB model) {
        this.model = model;
    }

    
    public ViewLogin getView() {
        return view;
    }

    public void setView(ViewLogin view) {
        this.view = view;
    }

}
