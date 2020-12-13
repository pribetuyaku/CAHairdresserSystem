package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Customer Booking Page
 *
 * @author Betuyaku
 */
public class ViewBookingCustomer extends JFrame implements ActionListener {

    
    public void ViewBookingCustomer() {
        //Create and set up the window
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 520);
        this.setTitle("CUSTOMER BOOKING PAGE");

        //MenuBar
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu menu1 = new JMenu("Appointments");
        JMenuItem app1 = new JMenuItem("New Appointment");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String exit = ae.getActionCommand();
                if (ae.getActionCommand().equals("Exit")) {
                    int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure do you want leave?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (dialogButton == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else if (dialogButton == JOptionPane.NO_OPTION) {
                        remove(dialogButton);
                    }
                }
            }
        });

        menu.add(menu1);
        menu1.add(app1);
        menu1.add(exit);
 
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
