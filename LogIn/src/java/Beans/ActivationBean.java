// Activation Bean

// Handles account activation

// By Nick Verrochi
// Last Modified: 6/15/16
package Beans;

import Data.ConnectToDB;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nicholas
 */
public class ActivationBean {
    public void activate(HttpServletRequest request) {
        try {
            final String query = "UPDATE userinfo SET active = TRUE WHERE id = " 
                    + request.getParameter("id") + ";";
            ConnectToDB connect = new ConnectToDB();
            connect.getStm().execute(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
