
package DAO;

/**
 *
 * @author Betuyaku
 */
import JavaBean.Booking;
import java.sql.Connection;
import Model.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Betuyaku
 */
public class BookingDAO {

    private Connection connect;

    //Constructor
    public BookingDAO() {
        this.connect = new ConnectionDB().connect();
    }

    //Register Customer
    public void registerBooking(Booking obj) {
        try {

            //SQL insert into
            String cmdsql = "INSERT INTO Booking (HFname, Date, Time, Location) VALUES(?,?,?,?)";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, obj.getHFname());
            stmt.setString(2, obj.getDate());
            stmt.setString(3, obj.getTime());
            stmt.setString(4, obj.getLocation());

            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }     
    
    //list all new bookings
    public List<Booking> listNewBooking(){
        try {
            //create a new vector to save the data on DB
            List<Booking> list = new ArrayList<Booking>();
            //SQL code
            String cmdsql = "SELECT * FROM Booking";
            
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            //Save the result inside the object rs(ResultSet)
            ResultSet rs = stmt.executeQuery();
            //While there is some register, save it in the list
            while(rs.next()){
                Booking bng = new Booking();
                bng.setIdBooking(rs.getInt("idBooking"));
                bng.setIdHairdre(rs.getInt("idHairdre"));
                bng.setHFname(rs.getString("HFname"));
                bng.setDate(rs.getString("Date"));
                bng.setTime(rs.getString("Time"));
                bng.setLocation(rs.getString("Location"));
                
                list.add(bng);
            }
            return list;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
