package View;

import DAO.HairdresserDAO;
import JavaBean.Hairdresser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login signUp Screen
 *
 * @author Betuyaku
 */
public class ViewRegHairdresser extends JFrame implements ActionListener {

    private JTextField txtFName;
    private JTextField txtMail;
    private JTextField txtPass;
    private JTextField txtPhone;
    private JTextField txtLocal;

    public void signUpHair() {

        //Create and set up the window
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(320, 340);
        this.setTitle("REGISTER HAIRDRESSER");
        BorderLayout bdTitle = new BorderLayout();
        this.setLayout(bdTitle);

        //creating mainPanel
        JPanel mainPanel = new JPanel(); //adding mainPanel to the Frame
        this.add(mainPanel, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.WHITE);

        //creating centerPanel
        JPanel centerPanel = new JPanel();
        FlowLayout centerFlow = new FlowLayout();
        centerPanel.setLayout(centerFlow);
        centerPanel.setBackground(Color.WHITE);
        centerFlow.setAlignment(FlowLayout.CENTER);
        this.add(centerPanel, BorderLayout.CENTER);

        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 20)); //setting a big font size to the lblNameSystem
        lblNameSys.setForeground(Color.BLUE); //colorizing the name

        FlowLayout flowGap = new FlowLayout();
        mainPanel.setLayout(flowGap);
        flowGap.setVgap(18);//put a gap(border space)
        flowGap.setAlignment(FlowLayout.CENTER);

        //Creating Labels and TextFields 
        JLabel lblFName = new JLabel("Full Name: ");
        txtFName = new JTextField(18);
        mainPanel.setLayout(flowGap);
        JLabel lblMail = new JLabel("E-mail:");
        txtMail = new JTextField(18);
        JLabel lblPhone = new JLabel("Phone number: ");
        txtPhone = new JTextField(18);
        JLabel lblLocal = new JLabel("Location: ");
        txtLocal = new JTextField(18);
        JLabel lblPass = new JLabel("Password:");
        txtPass = new JPasswordField(18);

        //Setting Image
//        ImageIcon logo = new ImageIcon(getClass().getResource("hairdresser.png"));
//        JLabel lblImage = new JLabel(logo);
        //Button Register
        JButton regButton = new JButton("Register"); //creating Button Login
        regButton.setPreferredSize(new Dimension(90, 25));
        regButton.setActionCommand("reg");
        regButton.addActionListener(this);

        //adding items to the frame
        mainPanel.add(lblNameSys);
        centerPanel.add(lblFName);
        centerPanel.add(txtFName);
        centerPanel.add(lblMail);
        centerPanel.add(txtMail);
        centerPanel.add(lblPhone);
        centerPanel.add(txtPhone);
        centerPanel.add(lblLocal);
        centerPanel.add(txtLocal);
        centerPanel.add(lblPass);
        centerPanel.add(txtPass);
        centerPanel.add(regButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        //Register Button
        Hairdresser objHUser = new Hairdresser();
        objHUser.setHFname(txtFName.getText());
        objHUser.setHEmail(txtMail.getText());
        objHUser.setHPhone(txtPhone.getText());
        objHUser.setLocation(txtLocal.getText());
        objHUser.setHpass(txtPass.getText());
        
        HairdresserDAO hdao = new HairdresserDAO();
        hdao.registerHairdresser(objHUser);
        
        JOptionPane.showMessageDialog(null, "Hairdresser registered successfully!");
        
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "REGISTERING ERROR!");
        }
       
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

    public JTextField getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(JTextField txtPass) {
        this.txtPass = txtPass;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public JTextField getTxtLocal() {
        return txtLocal;
    }

    public void setTxtLocal(JTextField txtLocal) {
        this.txtLocal = txtLocal;
    }

  
    
    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
}
