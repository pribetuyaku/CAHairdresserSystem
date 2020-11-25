
package DAO;

import Model.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import JavaBean.Hairdresser;
import java.sql.ResultSet;

/**
 *
 * @author Betuyaku
 */
public class HairdresserDAO {
    
    private Connection connect;
    
    //Constructor
    public HairdresserDAO(){
        this.connect = new ConnectionDB().connect();
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
    
    //execute Login
    public boolean exeLogin(String HEmail, String Hpass){
        try {
            
            //SQL select code 
            String cmdsql = "SELECT * FROM Hairdresser WHERE HEmail=? AND Hpass=?";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, HEmail);
            stmt.setString(2, Hpass);
            
            ResultSet rs = stmt.executeQuery();
            
            //check if there is any register of this user and pasword on DB
            if(rs.first()){
                //Login done
                return true;
            }            
        } catch (Exception e) {
        
        }
        return false;
    }

}
