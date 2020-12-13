package View;

import DAO.CustomerDAO;
import java.sql.DriverManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

/**
 * Customer HomePage
 *
 * @author Betuyaku
 */
public class ViewCustomerHome extends JFrame implements ActionListener {

    public JButton cancel;
    public JButton review;
    public JButton submit;
    public JTextArea txtArea;
    public JTextField txtSearch;
    public JTable tblNew;
    public JTable tblDone;
    public JLabel lblReview;
    CustomerDAO CustomerDAO;

    public void ViewCustomerHome() {
        try {
            CustomerDAO = new CustomerDAO();
        } catch (Exception e) {
        }

        //Create and set up the window
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 520);
        this.setTitle("CUSTOMER HOMEPAGE");

        //MenuBar
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu menu1 = new JMenu("Appointments");
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
        menu1.add(exit);

        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setBounds(270, 20, 250, 50);
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNameSys.setForeground(Color.BLUE);//setting a big font size to the lblNameSystem

        //creating lblNew
        JLabel lblNew = new JLabel("Search your new booking: ");
        lblNew.setBounds(15, 75, 150, 50);

        //creating txtSearch
        JTextField txtSearch = new JTextField(45);
        txtSearch.setBounds(170, 88, 225, 25);
        txtSearch.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                try {
                    Vector header = new Vector();
                    header.add("HFname");
                    header.add("Date");
                    header.add("Time");
                    header.add("Location");
                    if (!txtSearch.getText().equals("")) {
                        DefaultTableModel nv = new DefaultTableModel(CustomerDAO.Search(txtSearch.getText()), header);
                        tblNew.setModel(nv);
                    } else {
                        DefaultTableModel nv = new DefaultTableModel(new Vector(), header);
                        tblNew.setModel(nv);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: No records!");
                }
            }
        });

        //creating tblNew
        String data[][] = tblNewCallDB();
        String columnNew[] = {"Hairdresser", "Day", "Time", "Location"};
        JTable tblNew = new JTable(data, columnNew);
        JScrollPane jsPaneNew = new JScrollPane(tblNew);
        jsPaneNew.setBounds(15, 130, 380, 100);

        //creating lblDone
        JLabel lblDone = new JLabel("Bookings done: ");
        lblDone.setBounds(15, 235, 100, 45);

        //creating tblDone
        String dataDone[][] = {};
        String columnDone[] = {"Hairdresser", "Day", "Time", "Location"};
        JTable tblDone = new JTable(dataDone, columnDone);
        JScrollPane jsPaneDone = new JScrollPane(tblDone);
        jsPaneDone.setBounds(15, 273, 380, 100);

        //Button review
        JButton review = new JButton("Review"); //creating Button review
        review.setPreferredSize(new Dimension(85, 25));
        review.setForeground(Color.WHITE);
        review.setBackground(Color.BLUE);
        review.addActionListener(this);
        review.setBounds(310, 400, 85, 25);

        //creating lblReview
        JLabel lblReview = new JLabel("Review your hairdresser: ");
        lblReview.setBounds(450, 45, 150, 100);
        lblReview.setVisible(true);

        //textArea Review
        JTextArea txtArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtArea);
        txtArea.setEditable(true);
        txtArea.setBounds(450, 110, 320, 120);
        txtArea.setVisible(true);

        //Button Submit
        JButton submit = new JButton("Submit"); //creating Button review
        submit.setPreferredSize(new Dimension(85, 25));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.addActionListener(this);
        submit.setBounds(680, 250, 85, 25);

        //Adding components
        this.setLayout(null);
        this.add(lblNameSys);
        this.add(lblNew);
        this.add(txtSearch);
        this.add(jsPaneNew);
        this.add(lblDone);
        this.add(jsPaneDone);
        this.add(review);
        this.add(lblReview);
        this.add(txtArea);
        this.add(submit);

        //CustumerDAO search table
        try {
            CustomerDAO = new CustomerDAO();
        } catch (Exception e) {
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();

    }

    public String[][] tblNewCallDB() {
        String[][] data = new String[100][4];

        try {
            String dbServer = "jdbc:mysql://apontejaj.com:3306/Priscilla_2019217?useSSL=false";
            String user = "Priscilla_2019217";
            String password = "2019217";
            String query = "SELECT * FROM BookingHaird;";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            int row = 0;

            while (rs.next()) {

                data[row][0] = rs.getString("HFname");
                data[row][1] = rs.getString("Date");
                data[row][2] = rs.getString("Time");
                data[row][3] = rs.getString("Location");
                row++;
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
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
