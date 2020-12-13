package DAO;

import JavaBean.Customer;
import java.sql.Connection;
import Model.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Betuyaku
 */
public class CustomerDAO {

    private Connection connect;

    //Constructor
    public CustomerDAO() throws Exception{
        this.connect = ConnectionDB.connect();
    }

    //Vector 
    public Vector Search(String searching) throws Exception{
        Vector tbl = new Vector();
        String url = "SELECT * FROM Hairdresser WHERE HFname like '" + searching + "%'";
        PreparedStatement stmt = getConnect().prepareStatement(url);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Vector nl = new Vector();
            nl.add(rs.getString("HFname"));
            nl.add(rs.getString("Date"));
            nl.add(rs.getString("Time"));
            nl.add(rs.getString("Location"));
            tbl.add(nl);
        }
        return tbl;
    }
    
    
    //list all new bookings
    public List<Customer> listCustomer() {

        try {
            //create a new vector to save the data on DB
            List<Customer> list = new ArrayList<Customer>();
            //SQL code
            String cmdsql = "SELECT * FROM Customer;";
            PreparedStatement stmt = connect.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();

            //While there is some register, save it in the list
            while (rs.next()) {
                Customer Customerlist = new Customer();
                
                Customerlist.setIdCus(rs.getInt("idCus"));
                Customerlist.setFname(rs.getString("fname"));
                Customerlist.setEmail(rs.getString("email"));
                Customerlist.setPhone(rs.getString("phone"));

                
                list.add(Customerlist);
            }
            return list;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
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
            String cmdsql = "SELECT * FROM Customer WHERE email=? AND password=?;";

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

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

}
