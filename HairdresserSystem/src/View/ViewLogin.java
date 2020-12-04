package View;

//importing packages area
import controller.ControllerLogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * Login Window
 *
 * @author Betuyaku
 */
public class ViewLogin extends JFrame {

    private JTextField txtEmail;
    private JTextField txtPass;
    public JButton logIn;
    ControllerLogin ControllerLogin;

    public ViewLogin(ControllerLogin ControllerLogin) {
        
        this.ControllerLogin = ControllerLogin;
        
        //Create and set up the window
        this.setVisible(true);
        this.setLocationRelativeTo(null); //set location
        this.setResizable(false);
        this.setSize(240, 320);
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
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 20)); //setting a big font size to the lblNameSystem
        lblNameSys.setForeground(Color.BLUE); //colorizing the name

        JLabel lblNewUser = new JLabel("NEW USER? SELECT HERE:");
        FlowLayout flowGap = new FlowLayout();
        mainPanel.setLayout(flowGap);
        flowGap.setVgap(13);//put a gap(border space)
        flowGap.setAlignment(FlowLayout.CENTER);

        //Creating ComboBox type user
        JComboBox<String> comboUser = new JComboBox<>();
        comboUser.addItem(" ");// add items to the combo box
        comboUser.addItem("Customer");
        comboUser.addItem("Hairdresser");
        comboUser.setPreferredSize(new Dimension(200, 20));
        comboUser.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {

                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    //taking the selected field
                    String typeUser = ie.getItem().toString();
                    if (typeUser.equals("Customer")) { //open RegCustomer screen
                        ViewRegCustomer cus = new ViewRegCustomer();
                        cus.ViewRegCustomer();
                        
                    } else if(typeUser.equals("Hairdresser")) {
                        ViewRegHairdresser cus = new ViewRegHairdresser();
                        cus.setVisible(true); 
                    }
                }
            }
        });

        FlowLayout flowGap2 = new FlowLayout();
        mainPanel.setLayout(flowGap2);
        flowGap2.setVgap(20);//put a gap(border space)
        flowGap2.setAlignment(FlowLayout.CENTER);
        //Login
        JLabel lblLogin = new JLabel("LOGIN AREA");
        JLabel lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField(18); //creating textfield email
        JLabel lblPass = new JLabel("Password:");
        txtPass = new JPasswordField(18);//creating textfield password

        JButton logIn = new JButton("LOGIN");//creating Button Login
        logIn.setForeground(Color.WHITE);
        logIn.setBackground(Color.BLUE);
        logIn.setPreferredSize(new Dimension(80, 25));
        logIn.setActionCommand("login");
        logIn.addActionListener(ControllerLogin);

        //adding items to the frame
        mainPanel.add(lblNameSys);
        centerPanel.add(lblNewUser);
        centerPanel.add(comboUser);

        //Separator
//        JSeparator sep = new JSeparator();
//        sep.setOrientation(SwingConstants.HORIZONTAL);
//        centerPanel.add(sep);
        centerPanel.add(lblLogin);
        centerPanel.add(lblEmail);
        centerPanel.add(txtEmail);
        centerPanel.add(lblPass);
        centerPanel.add(txtPass);
        centerPanel.add(logIn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();
    }

    //Getters user and password
    public String getEmail() {
        return txtEmail.getText();
    }

    public String getPassword() {
        return txtPass.getText();
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(JTextField txtPass) {
        this.txtPass = txtPass;
    }

    public JButton getLogIn() {
        return logIn;
    }

    public void setLogIn(JButton logIn) {
        this.logIn = logIn;
    }

    public ControllerLogin getControllerLogin() {
        return ControllerLogin;
    }

    public void setControllerLogin(ControllerLogin ControllerLogin) {
        this.ControllerLogin = ControllerLogin;
    }

    
    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }

}
