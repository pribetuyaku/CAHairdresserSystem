/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hairdresserSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;

/**
 * New Customer Register Window
 * @author Betuyaku
 */
public class RegCustomer extends JFrame {
    
    private JTextField txtfName;
    private JTextField txtMail;
    private JTextField txtpNumber;
    private JTextField txtPassword;
    Controller controller;
    
    public RegCustomer (Controller controller){
        this.controller = controller;
        //Encapsulating the buildind windows process
        screenRegCustomer();
        checking();
    }

    RegCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Setting screen RegCustomer screen
    private void screenRegCustomer(){
        //creating a new window RegCustomer
        this.setVisible(true);
        this.setSize(250,300);
        this.setTitle("REGISTER NEW CUSTOMER");
        BorderLayout bdRegCust = new BorderLayout();
        this.setLayout(bdRegCust);
        
        // creating Panel
        JPanel mainRegCusPanel = new JPanel(); //adding mainPanel to the Frame
        this.add(mainRegCusPanel,BorderLayout.PAGE_START);
        
        //creating centerRegCusPanel
        JPanel centerRegCusPanel = new JPanel();
        FlowLayout centerRegCusFlow = new FlowLayout();
        centerRegCusPanel.setLayout(centerRegCusFlow);
        centerRegCusFlow.setAlignment(FlowLayout.CENTER);
        this.add(centerRegCusPanel, BorderLayout.CENTER);
        
        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setFont(new Font("Roboto", Font.PLAIN, 20)); //setting a big font size to the lblNameSystem
        //setLayout(new BorderLayout());
                        
        JLabel lblfName = new JLabel("Full Name:");
        txtfName = new JTextField(18); //creating textfield fName
        FlowLayout flowGapRegCus = new FlowLayout();
        mainRegCusPanel.setLayout(flowGapRegCus);
        //put a gap(border space)
        flowGapRegCus.setVgap(13);
        flowGapRegCus.setAlignment(FlowLayout.LEFT);
        
    }
    
    public static void main(String[] args) {
        new Controller();
    }
    
    private void checking(){
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
}
