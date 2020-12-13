
package DAO;

/**
 *
 * @author Betuyaku
 */
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
public class BookingHairDAO {

    private Connection connect;

    //Constructor
    public BookingHairDAO() {
        this.connect = ConnectionDB.connect();
    }

     //Register registerBooking
    public void registerBooking(BookingHair obj) {

        Connection conn = ConnectionDB.connect();
        PreparedStatement stmt = null;
        try {

            //SQL insert into
            stmt = conn.prepareStatement("INSERT INTO BookingHaird (HFname, Date, Time, Location) VALUES(?,?,?,?);");

            //Execute cmdsql and play
            stmt.setString(1, obj.getHFname());
            stmt.setString(2, obj.getDate());
            stmt.setString(3, obj.getTime());
            stmt.setString(4, obj.getLocation());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Appointment booked successfully!", "INFORM MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: FAIL TO BOOK YOUR SLOT, TRY AGAIN!", "ERROR MESSAGE!", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionDB.closeConnection(connect, stmt);
        }

    }
    
    //list all new bookings
    public List<BookingHair> BookingH() {

        try {
            //create a new vector to save the data on DB
            List<BookingHair> list = new ArrayList<BookingHair>();
            //SQL code
            String cmdsql = "SELECT * FROM BookingHaird;";
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();

            //While there is some register, save it in the list
            while (rs.next()) {
                BookingHair BookingHlist = new BookingHair();
                
                BookingHlist.setIdHairdre(rs.getInt("idBooking"));
                BookingHlist.setHFname(rs.getString("HFname"));
                BookingHlist.setDate(rs.getString("Date"));
                BookingHlist.setTime(rs.getString("Time"));
                BookingHlist.setLocation(rs.getString("Location"));

                
                list.add(BookingHlist);
            }
            return list;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
}
