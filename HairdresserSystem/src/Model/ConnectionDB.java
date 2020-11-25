package Model;

import JavaBean.Customer;
import JavaBean.Hairdresser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Betuyaku
 */
public class ConnectionDB {

    public Connection connect() {

        try {

            return DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Priscilla_2019217?useSSL=false", "Priscilla_2019217", "2019217");
           
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }

    }

}