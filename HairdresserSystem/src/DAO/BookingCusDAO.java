package DAO;

/**
 *
 * @author Betuyaku
 */
import JavaBean.BookingCus;
import JavaBean.BookingHair;
import java.sql.Connection;
import Model.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Betuyaku
 */
public class BookingCusDAO {

    private Connection connect;

    //Constructor
    public BookingCusDAO() {
        this.connect = ConnectionDB.connect();
    }

    //Register registerBooking
    public void registerBooking(BookingCus obj) {

        Connection conn = ConnectionDB.connect();
        PreparedStatement stmt = null;
        try {

            //SQL insert into
            stmt = conn.prepareStatement("INSERT INTO BookingCust (fname, Date, Time) VALUES(?,?,?)");

            //Execute cmdsql and play
            stmt.setString(1, obj.getfname());
            stmt.setString(2, obj.getDate());
            stmt.setString(3, obj.getTime());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Appointment booked successfully!", "INFORM MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: FAIL TO BOOK YOUR SLOT, TRY AGAIN!", "ERROR MESSAGE!", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionDB.closeConnection(connect, stmt);
        }

    }

    //list all new bookings
    public List<BookingCus> BookingC() {

        try {
            //create a new vector to save the data on DB
            List<BookingCus> bookCus = new ArrayList<BookingCus>();
            //SQL code
            String cmdsql = "SELECT * FROM BookingCust;";
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();

            //While there is some register, save it in the list
            while (rs.next()) {
                BookingCus BookingCuslist = new BookingCus();

                BookingCuslist.setIdBookingCust(rs.getInt("idBookingCust"));
                BookingCuslist.setidCus(rs.getInt("idCus"));
                BookingCuslist.setfname(rs.getString("fname"));
                BookingCuslist.setDate(rs.getString("Date"));
                BookingCuslist.setTime(rs.getString("Time"));

                bookCus.add(BookingCuslist);
            }
            return bookCus;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ERROR: FAIL TO BOOK YOUR SLOT, TRY AGAIN!", "ERROR MESSAGE!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
