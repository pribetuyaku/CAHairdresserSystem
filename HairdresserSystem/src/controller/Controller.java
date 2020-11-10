package controller;

import view.Model;
import hairdresserSystem.RegCustomer;
import view.User;
import hairdresserSystem.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Betuyaku
 */

public class Controller implements ActionListener {
    
    ViewLogin view;
    Model model;
    RegCustomer regcustomer;
    
    
    public Controller() {
        this.view = new ViewLogin();
        this.model = new Model();
        
    }
    
    /*btnLogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            this.setVisible(false);
            new FrmMain().setVisible(true); // Main Form to show after the Login Form..
        }
    });*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //take the text from Email and password
        String userMail = view.getEmail();
        String userPass = view.getPassword();
        User user = new User(userMail,userPass);
        
        //eraseButton
        //view.controller(eraseButton());
  
    }
    
}

    
    
    
    
    
    
    

