package View;

import DAO.HairdresserDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Hairdresser HomePage
 *
 * @author Betuyaku
 */
public class ViewHairdresserHome extends JFrame implements ActionListener {

    private Connection connect;
    public JButton btnmybookings;
    public JButton btnmyreview;
    public JButton btnmyagenda;
    public JButton btncancel;
    public JLabel lblBooking;
    public JTable tblBook;
    public JTextArea txtArea;
    public JLabel lblReview;
    HairdresserDAO HairdresserDAO;

    public void ViewHairdresserHome() {
        try {
            HairdresserDAO = new HairdresserDAO();
        } catch (Exception e) {
        }

        //Create and set up the window
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(750, 530);
        this.setTitle("HAIRDRESSER HOMEPAGE");

        //MenuBar
        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu menu1 = new JMenu("Appointments");
        JMenuItem app1 = new JMenuItem("New Appointment");
        app1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == app1) { // if app1 menu item is selected
                    ViewBookingCustomer bookViewCust = new ViewBookingCustomer();
                    bookViewCust.ViewBookingCustomer();
                }
            }
        });

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

        //Creating label nameSystem
        JLabel lblNameSys = new JLabel("Hairdresser System");
        lblNameSys.setBounds(270, 10, 250, 50);
        lblNameSys.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNameSys.setForeground(Color.BLUE);//setting a big font size to the lblNameSystem

        //creating txtSearch
        JTextField txtSearch = new JTextField(45);
        txtSearch.setBounds(110, 135, 220, 25);
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
                    header.add("fname");
                    header.add("Date");
                    header.add("Time");
                    if (!txtSearch.getText().equals("")) {
                        DefaultTableModel nv = new DefaultTableModel(HairdresserDAO.Search(txtSearch.getText()), header);
                        tblBook.setModel(nv);
                    } else {
                        DefaultTableModel nv = new DefaultTableModel(new Vector(), header);
                        tblBook.setModel(nv);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: No records!");
                }
            }
        });

        //creating tblBooking
        String data[][] = tblNewCallDB();
        String columnNew[] = {"Customer", "Day", "Time", "Cancel"};
        JTable tblBooking = new JTable(data, columnNew);
        JScrollPane jsPaneBook = new JScrollPane(tblBooking);
        jsPaneBook.setBounds(40, 180, 300, 100);

        //Button mybookings
        JButton btnmybookings = new JButton("MY BOOKINGS");
        btnmybookings.setForeground(Color.WHITE);
        btnmybookings.setBackground(Color.BLUE);
        btnmybookings.setBounds(40, 70, 140, 25);
        btnmybookings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tblBook.setVisible(true);
            }
        });

        //Button myreview
        JButton btnmyreview = new JButton("MY REVIEWS");
        btnmyreview.setForeground(Color.WHITE);
        btnmyreview.setBackground(Color.BLUE);
        btnmyreview.addActionListener(this);
        btnmyreview.setBounds(40, 100, 140, 25);

        //Button myagenda
        JButton btnmyagenda = new JButton("SET MY AGENDA");
        btnmyagenda.setForeground(Color.WHITE);
        btnmyagenda.setBackground(Color.BLUE);
        btnmyagenda.addActionListener(this);
        btnmyagenda.setBounds(190, 70, 140, 25);

        //Button btncancel
        JButton btncancel = new JButton("CANCEL");
        btncancel.setForeground(Color.WHITE);
        btncancel.setBackground(Color.BLUE);
        btncancel.addActionListener(this);
        btncancel.setBounds(190, 100, 140, 25);

        //creating lblnbooking
        JLabel lblBooking = new JLabel("Search:");
        lblBooking.setBounds(40, 135, 100, 30);

        //creating lblReview
        JLabel lblReview = new JLabel("See your reviews: ");
        lblReview.setBounds(40, 290, 140, 30);
        lblReview.setVisible(true);

        //textArea Review
        JTextArea txtArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtArea);
        txtArea.setEditable(true);
        txtArea.setBounds(40, 320, 300, 120);
        txtArea.setVisible(true);

        //creating lblAgenda
        JLabel lblAgenda = new JLabel("Set your agenda: ");
        lblAgenda.setBounds(400, 25, 150, 100);
        lblAgenda.setVisible(true);

        //Button Send
//        JButton submit = new JButton("Submit"); //creating Button review
//        submit.setPreferredSize(new Dimension(85, 25));
//        submit.setForeground(Color.WHITE);
//        submit.setBackground(Color.BLUE);
//        submit.addActionListener(this);
//        submit.setBounds(680, 250, 85, 25);
        //Adding components
        this.setLayout(null);
        this.add(lblNameSys);
        this.add(txtSearch);
        this.add(jsPaneBook);
        this.add(lblBooking);
        this.add(lblReview);
        this.add(lblAgenda);
        this.add(btnmybookings);
        this.add(btnmyreview);
        this.add(btnmyagenda);
        this.add(btncancel);

        this.add(txtArea);

        try {
            HairdresserDAO = new HairdresserDAO();
        } catch (Exception e) {
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill the program

        checking();
    }

    public String[][] tblNewCallDB() {
        String[][] data = new String[100][5];

        try {
            String dbServer = "jdbc:mysql://apontejaj.com:3306/Priscilla_2019217?useSSL=false";
            String user = "Priscilla_2019217";
            String password = "2019217";
            String query = "SELECT * FROM BookingCust;";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);
            // Get a statement from the connection
            Statement stmt = conn.createStatement();
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            int row = 0;

            while (rs.next()) {

                data[row][0] = rs.getString("idBookingCust");
                data[row][1] = rs.getString("idCus");
                data[row][2] = rs.getString("fname");
                data[row][3] = rs.getString("Date");
                data[row][4] = rs.getString("Time");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public JTable getTblBook() {
        return tblBook;
    }

    public void setTblBook(JTable tblBook) {
        this.tblBook = tblBook;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(JTextArea txtArea) {
        this.txtArea = txtArea;
    }

    private void checking() {
        // Always have these two methods at the end
        // to ensure the rendering process occurs correctly
        this.validate();
        this.repaint();
    }
}
