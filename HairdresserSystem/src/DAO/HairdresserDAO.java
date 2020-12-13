package DAO;

import Model.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import JavaBean.Hairdresser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Betuyaku
 */
public class HairdresserDAO {

    private Connection connect;

    //Constructor
    public HairdresserDAO() {
        this.connect = ConnectionDB.connect();
    }

    //Vector 
    public Vector Search(String searching) throws Exception {
        Vector tbl = new Vector();
        String url = "SELECT * FROM Hairdresser WHERE fname like '" + searching + "%'";
        PreparedStatement stmt = getConnect().prepareStatement(url);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Vector nl = new Vector();
            nl.add(rs.getString("HFname"));
            nl.add(rs.getString("HEmail"));
            nl.add(rs.getString("HPhone"));
            nl.add(rs.getString("Location"));
            tbl.add(nl);
        }
        return tbl;
    }

    //Register Hairdresser
    public void registerHairdresser(Hairdresser objHair) {
        try {

            //SQL insert into
            String cmdsql = "INSERT INTO Hairdresser (HFname, HEmail, HPhone, Location, Hpass) VALUES(?,?,?,?,?)";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, objHair.getHFname());
            stmt.setString(2, objHair.getHEmail());
            stmt.setString(3, objHair.getHPhone());
            stmt.setString(4, objHair.getLocation());
            stmt.setString(5, objHair.getHpass());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //list all new bookings
    public List<Hairdresser> listHairDresser() {

        try {
            //create a new vector to save the data on DB
            List<Hairdresser> list = new ArrayList<Hairdresser>();
            //SQL code
            String cmdsql = "SELECT * FROM Hairdresser;";
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();

            //While there is some register, save it in the list
            while (rs.next()) {
                Hairdresser hairlist = new Hairdresser();

                hairlist.setIdHairdre(rs.getInt("idHairdre"));
                hairlist.setHFname(rs.getString("HFname"));
                hairlist.setHEmail(rs.getString("HEmail"));
                hairlist.setHPhone(rs.getString("HPhone"));
                hairlist.setLocation(rs.getString("Location"));

                list.add(hairlist);
            }
            return list;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    //execute Login
    public boolean exeLogin(String HEmail, String Hpass) {
        try {

            //SQL select code 
            String cmdsql = "SELECT * FROM Hairdresser WHERE HEmail=? AND Hpass=?";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, HEmail);
            stmt.setString(2, Hpass);

            ResultSet rs = stmt.executeQuery();

            //check if there is any register of this user and pasword on DB
            if (rs.first()) {
                //Login done
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

}
