package View;

import DAO.BookingDAO;
import JavaBean.Booking;
import JavaBean.Customer;
import controller.ControllerCustomerHome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 * Customer HomePage
 *
 * @author Betuyaku
 */
public class ViewCustomerHome extends JFrame implements ActionListener {

    public JButton cancel;
    public JButton review;
    public JButton send;
    public JTextArea txtArea;
    public JTable tblNew;
    public JTable tblDone;
    public JLabel lblReview;

    //method list
    public void List(){
        try {
            //execute Select
            BookingDAO dao = new BookingDAO();
            List<Booking> bookinglist = dao.listNewBooking();
            
            //save into the table tblNew
            DefaultTableModel tmodelnew = (DefaultTableModel)tblNew.getModel();
            tmodelnew.setNumRows(0);
            
            for(Booking bng : bookinglist){
                tmodelnew.addRow(new Object[]{
                bng.getIdBooking(), bng.getIdHairdre(), bng.getHFname(),
                bng.getDate(), bng.getTime(), bng.getLocation()
                });
            }

        } catch (Exception e) {
        }
    
    }
    

    
    
    public void ViewCustomerHome() {

        //Create and set up the window
        this.setVisible(true);

        this.setResizable(false);
        this.setSize(425, 540);
        this.setTitle("CUSTOMER HOMEPAGE");

        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setBounds(120, 10, 200, 30);
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 20));
        lblNameSys.setForeground(Color.BLUE);//setting a big font size to the lblNameSystem

        //creating lblNew
        JLabel lblNew = new JLabel("New bookings: ");
        lblNew.setBounds(15, 55, 100, 30);

        //creating tblNew
        String data[][] = {};
        String columnNew[] = {"Hairdresser", "Day", "Time", "Location"};
        JTable tblNew = new JTable(data, columnNew);
        JScrollPane jsPaneNew = new JScrollPane(tblNew);
        jsPaneNew.setBounds(15, 95, 380, 70);

        //Button Cancel
        JButton cancel = new JButton("Cancel"); //creating Button Login
        cancel.setPreferredSize(new Dimension(85, 25));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLUE);
        cancel.addActionListener(this);
        cancel.setBounds(310, 175, 85, 25);

        //creating lblDone
        JLabel lblDone = new JLabel("Bookings done: ");
        lblDone.setBounds(15, 220, 100, 30);

        //creating tblDone
        String dataDone[][] = {{"H1", "today", "1pm", "Santry"},
        {"H1", "today", "1pm", "Santry"}};
        String columnDone[] = {"Hairdresser", "Day", "Time", "Location"};
        JTable tblDone = new JTable(dataDone, columnDone);
        JScrollPane jsPaneDone = new JScrollPane(tblDone);
        jsPaneDone.setBounds(15, 260, 380, 70);

        //Button review
        JButton review = new JButton("Review"); //creating Button Login
        review.setPreferredSize(new Dimension(85, 25));
        review.setForeground(Color.WHITE);
        review.setBackground(Color.BLUE);
        review.addActionListener(this);
        review.setBounds(310, 340, 85, 25);
        
        //creating lblReview
        JLabel lblReview = new JLabel("Review your hairdresser: ");
        lblReview.setBounds(15, 220, 100, 30);
        lblReview.setVisible(false);

        //Adding components
        this.setLayout(null);
        this.add(lblNameSys);
        this.add(lblNew);
        this.add(jsPaneNew);
        this.add(cancel);
        this.add(lblDone);
        this.add(jsPaneDone);
        this.add(review);
        this.add(lblReview);

        this.add(send);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();

    }

    private void formWindowOpened(java.awt.event.WindowEvent event){
        //list data from DB
        
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

    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
}
