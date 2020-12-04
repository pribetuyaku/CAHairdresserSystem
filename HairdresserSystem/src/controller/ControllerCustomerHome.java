
package controller;

import JavaBean.Customer;
import DAO.CustomerDAO;
import View.ViewCustomerHome;
import Model.ConnectionDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Betuyaku
 */
public class ControllerCustomerHome implements ActionListener {
    
    ViewCustomerHome viewCHome;
    ConnectionDB modelCHome;
    
    public ControllerCustomerHome(){
        this.viewCHome = new ViewCustomerHome();
        this.modelCHome = new ConnectionDB();
    }

    public ViewCustomerHome getViewCHome() {
        return viewCHome;
    }

    public void setViewCHome(ViewCustomerHome viewCHome) {
        this.viewCHome = viewCHome;
    }

    public ConnectionDB getModelCHome() {
        return modelCHome;
    }

    public void setModelCHome(ConnectionDB modelCHome) {
        this.modelCHome = modelCHome;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
//        try {
//            //Button cancel
//            Cancel objUser = new Customer();
//            objUser.setFname(txtFName.getText());
//            objUser.setEmail(txtMail.getText());
//            objUser.setPhone(txtPhone.getText());
//            objUser.setPassword(txtPass.getText());
//
//            CustomerDAO cdao = new CustomerDAO();
//            cdao.registerCustomer(objUser);
//
//            JOptionPane.showMessageDialog(null, "User registered successfully!");
//
//        } catch (Exception error) {
//            JOptionPane.showMessageDialog(null, "REGISTERING ERROR!");
//        }
//       if (ae.getActionCommand().equals("Review")) {
//                //set review are visible
//                lblReview.setVisible(true); //close the ViewLogin
//                  
//            } else {
//                ViewHairdresserHome hair = new ViewHairdresserHome();
//                JOptionPane.showMessageDialog(null, "Welcome!");
//                getView().setVisible(false); //close the ViewLogin
//
//            }
    }
    
}
