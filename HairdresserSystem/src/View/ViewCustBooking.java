
package View;

import JavaBean.Booking;
import Model.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Betuyaku
 */
public class ViewCustBooking {
        private Connection connect;

    //Constructor
    public ViewCustBooking() {
        this.connect = new ConnectionDB().connect();
    }

    //Register Customer
    public void ViewCustBooking(Booking obj) {
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
}
