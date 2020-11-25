package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

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

    public void ViewCustomerHome() {

        //Create and set up the window
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(420, 540);
        this.setTitle("CUSTOMER HOMEPAGE");

        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setBounds(120, 10, 200, 30);
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 20)); //setting a big font size to the lblNameSystem
        lblNameSys.setForeground(Color.BLUE); //colorizing the name

        //creating lblNew
        JLabel lblNew = new JLabel("New bookings: ");
        lblNew.setBounds(15, 55, 100, 30);

        //creating tblNew
        String data[][]={ {"H1","today","1pm","Santry"}, 
                          {"H1","today","1pm","Santry"}};
        String columnNew[]={"Hairdresser","Day","Time", "Location"};   
        JTable tblNew = new JTable(data, columnNew);
        JScrollPane jsPaneNew = new JScrollPane(tblNew);
        jsPaneNew.setBounds(15, 95, 380, 70);
        
       //creating lblDone
        JLabel lblDone = new JLabel("Bookings done: ");
        lblDone.setBounds(15, 180, 100, 30);
        
         //creating tblDone
        String dataDone[][]={ {"H1","today","1pm","Santry"}, 
                          {"H1","today","1pm","Santry"}};
        String columnDone[]={"Hairdresser","Day","Time", "Location"};   
        JTable tblDone = new JTable(dataDone, columnDone);
        JScrollPane jsPaneDone = new JScrollPane(tblDone);
        jsPaneDone.setBounds(15, 210, 380, 70);

        //Adding components
        this.setLayout(null);
        this.add(lblNameSys);
        this.add(lblNew);
        this.add(jsPaneNew);
        this.add(lblDone);
        this.add(jsPaneDone);

        this.add(cancel);
        this.add(review);
        this.add(send);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
}
