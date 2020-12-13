package View;

import DAO.CustomerDAO;
import JavaBean.Customer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Register Customer
 *
 * @author Betuyaku
 */
public class ViewRegCustomer extends JFrame implements ActionListener {

    private JTextField txtFName;
    private JTextField txtMail;
    private JTextField txtPhone;
    private JTextField txtPass;
    public JButton register;

    public void ViewRegCustomer() {

        //Create and set up the window
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(320, 310);
        this.setTitle("REGISTER NEW CUSTOMER");
        
        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setBounds(90, 10, 200, 30);
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 20)); //setting a big font size to the lblNameSystem
        lblNameSys.setForeground(Color.BLUE); //colorizing the name

        //Creating lblFName
        JLabel lblFName = new JLabel("Full Name: ");
        lblFName.setBounds(15, 55, 100, 30);
        txtFName = new JTextField(20);
        txtFName.setBounds(80, 60, 210, 25);

        //Creating lblMail
        JLabel lblMail = new JLabel("E-mail:");
        lblMail.setBounds(15, 90, 100, 30);
        txtMail = new JTextField(20);
        txtMail.setBounds(80, 90, 210, 25);

        //Creating lblPhone
        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(15, 125, 100, 30);
        txtPhone = new JTextField(20);
        txtPhone.setBounds(80, 125, 210, 25);

        //Creating lblPass
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(15, 155, 100, 30);
        txtPass = new JTextField(20);
        txtPass.setBounds(80, 157, 210, 25);

        //Button Register
        JButton regButton = new JButton("Register"); //creating Button Register
        regButton.setPreferredSize(new Dimension(90, 25));
        regButton.setForeground(Color.WHITE);
        regButton.setBackground(Color.BLUE);
        regButton.addActionListener(this);
        regButton.setBounds(113, 230, 90, 25);

        //Adding components
        this.setLayout(null);
        this.add(lblNameSys);
        this.add(lblFName);
        this.add(txtFName);
        this.add(lblMail);
        this.add(txtMail);
        this.add(lblPhone);
        this.add(txtPhone);
        this.add(lblPass);
        this.add(txtPass);
        this.add(regButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();
    }

    public JTextField getTxtFName() {
        return txtFName;
    }

    public void setTxtFName(JTextField txtFName) {
        this.txtFName = txtFName;
    }

    public JTextField getTxtMail() {
        return txtMail;
    }

    public void setTxtMail(JTextField txtMail) {
        this.txtMail = txtMail;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public JTextField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(JTextField txtPass) {
        this.txtPass = txtPass;
    }

    public JButton getRegister() {
        return register;
    }

    public void setRegister(JButton register) {
        this.register = register;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //Button Register
            Customer objUser = new Customer();
            objUser.setFname(txtFName.getText());
            objUser.setEmail(txtMail.getText());
            objUser.setPhone(txtPhone.getText());
            objUser.setPassword(txtPass.getText());

            CustomerDAO cdao = new CustomerDAO();
            
            //check if there is any empty field
            if (txtFName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Fill all the form!",  "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else if (txtMail.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Fill all the form!",  "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else if (txtPhone.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Fill all the form!",  "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else if (txtPass.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR: Fill all the form!",  "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else {
                cdao.registerCustomer(objUser);
                JOptionPane.showMessageDialog(null, "Customer registered successfully!","INFORM MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception error) {
           
        }
    }

    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }

   
}
