package hairdresserSystem;

//importing packages area
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**Login Window
 * @author Betuyaku
 */
public class ViewLogin extends JFrame {
    
    private JTextField txtEmail;
    private JTextField txtPass;
    Controller controller;
   
   
    public ViewLogin () {
        
        this.controller = controller;
          
        //Encapsulating the buildind windows process
        screenItems();
        checking();
    }
    
    //Setting screenItems
    private void screenItems(){
                
        //Create and set up the window
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(230,320);
        this.setTitle("LOGIN");
        BorderLayout bdTitle = new BorderLayout();
        this.setLayout(bdTitle);
              
        //creating mainPanel
        JPanel mainPanel = new JPanel(); //adding mainPanel to the Frame
        this.add(mainPanel, BorderLayout.PAGE_START);
        
        //creating centerPanel
        JPanel centerPanel = new JPanel();
        FlowLayout centerFlow = new FlowLayout();
        centerPanel.setLayout(centerFlow);
        centerFlow.setAlignment(FlowLayout.CENTER);
        this.add(centerPanel, BorderLayout.CENTER);
                
        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setFont(new Font("Roboto", Font.PLAIN, 20)); //setting a big font size to the lblNameSystem
        //setLayout(new BorderLayout());
        //add(lblNameSys, BorderLayout.CENTER); //centralizing
                
        JLabel lblNewUser = new JLabel("NEW USER? SELECT HERE:");
        FlowLayout flowGap = new FlowLayout();
        mainPanel.setLayout(flowGap);
        //put a gap(border space)
        flowGap.setVgap(13);
        flowGap.setAlignment(FlowLayout.CENTER);
               
        //Creating ComboBox type user
        JComboBox<String> comboUser = new JComboBox<>();
        comboUser.addItem("Customer");// add items to the combo box
        comboUser.addItem("Hairdresser");
       
        //Button SignUp
        JButton signUp = new JButton("SIGN UP");
        signUp.setPreferredSize(new Dimension(80,25));
        signUp.addActionListener(controller);
        signUp.setActionCommand("SIGN UP");
    
        //Login
        JLabel lblLogin = new JLabel("LOGIN AREA");
        JLabel lblEmail = new JLabel("E-mail:"); 
        txtEmail = new JTextField(18); //creating textfield email
        JLabel lblPass = new JLabel("Password:"); 
        txtPass = new JTextField(18); //creating textfield password
        
        //Button Erase and Login
        JButton eraseButton = new JButton("ERASE"); //creating Button Login
        eraseButton.setPreferredSize(new Dimension(80,25));
        eraseButton.addActionListener(controller);
        JButton logIn = new JButton("LOGIN"); //creating Button Login
        logIn.setPreferredSize(new Dimension(80,25));
        logIn.addActionListener(controller);
        
        //adding items to the frame
        mainPanel.add(lblNameSys);
        centerPanel.add(lblNewUser);
        centerPanel.add(comboUser);
        centerPanel.add(signUp);
        
        //Separator
        centerPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        
        centerPanel.add(lblLogin);
        centerPanel.add(lblEmail);
        centerPanel.add(txtEmail);
        centerPanel.add(lblPass);
        centerPanel.add(txtPass);
        centerPanel.add(eraseButton);
        centerPanel.add(logIn);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program
    }
    
    //eraseButton
    public void eraseButton(){
        txtEmail.setText("");
        txtPass.setText("");
    }
    
    //Getters user and password
    public String getEmail(){
        return txtEmail.getText();
    }
    public String getPassword(){
        return txtPass.getText();
    }
        
    private void checking(){
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
    
}
