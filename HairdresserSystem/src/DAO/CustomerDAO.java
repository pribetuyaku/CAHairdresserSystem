package DAO;

import JavaBean.Customer;
import java.sql.Connection;
import Model.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Betuyaku
 */
public class CustomerDAO {

    private Connection connect;

    //Constructor
    public CustomerDAO() {
        this.connect = new ConnectionDB().connect();
    }

    //Register Customer
    public void registerCustomer(Customer obj) {
        try {

            //SQL insert into
            String cmdsql = "INSERT INTO Customer (fname, email, password, phone) VALUES(?,?,?,?)";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, obj.getFname());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getPhone());
            stmt.setString(4, obj.getPassword());

            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    //execute Login
    public boolean exeLogin(String email, String password){
        try {
            
            //SQL select code 
            String cmdsql = "SELECT * FROM Customer WHERE email=? AND password=?";

            //Execute cmdsql and play
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
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
