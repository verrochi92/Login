// RegistrationValidator class

// Contains code that validates registration credentials
// Sends error messages to JSP beans

// By Nick Verrochi
// Last Modified: 7/6/16

package Data;

import Business.Login;
import Beans.IndexBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistrationValidator {
    private final Login login; // credentials to validate
    private final IndexBean bean; // bean to send error message to
    private final ConnectToDB connect; // connection to database
    
    public RegistrationValidator(Login login, IndexBean bean, ConnectToDB connect) {
        this.login = login;
        this.bean = bean;
        this.connect = connect;
    } 
    
    public boolean validate() {
        // check if any fields empty
        if (!validateFieldsEmpty()) {
            return false;
        }
        // check if valid email (contains '@' and '.')
        if (!validateEmail()) {
            return false;
        }
        // check if already in use
        try {
            if (emailInUse()) {
                return false;
            }
        }
        catch(SQLException e) {
            return false;
        }
        // check if passwords match
        if (!login.getPassword().equals(login.getPasswordConfirm())) {
            bean.setRegMessage("Password does not match!");
            return false;
        }
        // check if 18+
        if (!checkDOB()) {
            bean.setRegMessage("Sorry, but you must be at least 18!");
            return false;
        }
        
        return true;
    } 
    
    // checks if dob provided over 18
    public boolean checkDOB() {
        boolean valid;
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar dob = login.getDateOfBirth();
        
        dob.set(Calendar.YEAR, dob.get(Calendar.YEAR) + 18);
        valid = today.compareTo(dob) >= 0;
        dob.set(Calendar.YEAR, dob.get(Calendar.YEAR) - 18);
        
        return valid;
    }
    
    public boolean emailInUse() throws SQLException {
        final String query = "SELECT * FROM userinfo WHERE email = \'" 
                + login.getEmail() + "\';";
        ResultSet resultSet = connect.getStm().executeQuery(query);
        if (resultSet.next()) {
            if (resultSet.getBoolean("active")) {
                bean.setRegMessage("Email already in use!");
                return true;
            }
            else {
                connect.getStm().execute("DELETE FROM userinfo WHERE email = \'"
                    + login.getEmail() + "\';"); // to prevent duplicates
            }
        }
        return false;
    }
    
    public boolean validateEmail() {
        String error = "Please enter a valid email address!";
        
        if (!login.getEmail().contains("@")) {
            bean.setRegMessage(error);
            return false;
        }
        else if (!login.getEmail().substring(login.getEmail().indexOf("@")).contains(".")) {
            bean.setRegMessage(error);
            return false;
        }
        
        return true;
    }
    
    public boolean validateFieldsEmpty() {
        if (login.getFirstName().equals("")) {
            bean.setRegMessage("You must enter a first name!");
            return false;
        }
        
        if (login.getLastName().equals("")) {
            bean.setRegMessage("You must enter a last name!");
            return false;
        }
        
        if (login.getEmail().equals("")) {
            bean.setRegMessage("You must enter an email!");
            return false;
        }
        
        if (login.getPassword().equals("")) {
            bean.setRegMessage("You must enter a password!");
            return false;
        }
        
        if (login.getPasswordConfirm().equals("")) {
            bean.setRegMessage("You must confirm your password!");
            return false;
        }
        
        return true;
    }
}
