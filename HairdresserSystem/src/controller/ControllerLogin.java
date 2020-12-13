package controller;

import DAO.CustomerDAO;
import DAO.HairdresserDAO;
import Model.ConnectionDB;
import View.ViewLogin;
import View.ViewRegCustomer;
import View.ViewCustomerHome;
import View.ViewRegHairdresser;
import View.ViewHairdresserHome;
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

        String umhair, pwhair;
        String umcus, pwcus;

        umcus = view.getEmail();
        pwcus = view.getPassword();

        umhair = view.getEmail();
        pwhair = view.getPassword();

        try {
            CustomerDAO cdao = new CustomerDAO();
            HairdresserDAO hdao = new HairdresserDAO();

            if (cdao.exeLogin(umcus, pwcus)) {
                //open the next screen CustomerArea or HairdresserArea
                ViewCustomerHome cust = new ViewCustomerHome();
                JOptionPane.showMessageDialog(null, "Welcome!");
                cust.ViewCustomerHome(); //calling method ViewCustomerHome
                getView().setVisible(false); //close the ViewLogin

            } else if (hdao.exeLogin(umhair, pwhair)) {
                ViewHairdresserHome hair = new ViewHairdresserHome();
                JOptionPane.showMessageDialog(null, "Welcome Hairdresser!");
                hair.ViewHairdresserHome();
                getView().setVisible(false); //close the ViewLogin
            } else {
                //if it is empty
                JOptionPane.showMessageDialog(null, "Invalid user or password", "Error!!!", JOptionPane.ERROR_MESSAGE);
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
