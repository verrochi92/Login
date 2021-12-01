package Business;
 
import java.util.*;
import Data.ConnectToDB;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Yassine
 */
public class Login {
    
    private int iUserId;
    
    private String sFirstName      ,
                   sLastName       ,
                   sEmail          ,
                   sPassword       ,
                   sPasswordConfirm;
    
    private GregorianCalendar dateOfBirth     ;

    public void setUserId(int iUserId) { this.iUserId = iUserId; }
    public void setFirstName      (String sFirstName      ) { this.sFirstName       = sFirstName      ; }
    public void setLastName       (String sLastName       ) { this.sLastName        = sLastName       ; }
    public void setEmail          (String sEmail          ) { this.sEmail           = sEmail          ; }
    public void setPassword       (String sPassword       ) { this.sPassword        = sPassword       ; }
    public void setPasswordConfirm(String sPasswordConfirm) { this.sPasswordConfirm = sPasswordConfirm; }
    public void setDateOfBirth(GregorianCalendar dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public int getUserId() { return iUserId; }
    public String getFirstName()       { return sFirstName      ; }
    public String getLastName()        { return sLastName       ; }
    public String getEmail()           { return sEmail          ; }
    public String getPassword()        { return sPassword       ; }
    public String getPasswordConfirm() { return sPasswordConfirm; }
    public GregorianCalendar getDateOfBirth() { return dateOfBirth; }
    
    public Login(String sEmail, String sPassword) {
        this.sEmail = sEmail;
        this.sPassword = sPassword;
    }
    
    public Login( String sFirstName,
                          String sLastName,
                          String sEmail,
                          String sPassword,
                          String sPasswordConfirm,
                          GregorianCalendar dob) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.sPasswordConfirm = sPasswordConfirm;
        this.dateOfBirth = dob;
    }
    
    public Login( String sFirstName,
                          String sLastName,
                          String sEmail,
                          String sPassword,
                          GregorianCalendar  dateOfBirth) {
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.dateOfBirth = dateOfBirth;
    }
    
    public Login( int    iUserId   ,
                  String sEmail    ,
                  String sPassword ) {
        this.iUserId = iUserId;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
    }
    
    public Login( int iUserId,
                  String sFirstName,
                  String sLastName,
                  String sEmail,
                  String sPassword,
                  GregorianCalendar dateOfBirth) {
        this.iUserId = iUserId;
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        this.sEmail = sEmail;
        this.sPassword = sPassword;
        this.dateOfBirth = dateOfBirth;
    }
    
    public int getID(ConnectToDB connect) {
        ResultSet resultSet;
        int id = 0;
        
        try {
            resultSet = connect.getStm().executeQuery("SELECT * FROM userinfo "
                + "WHERE email = \'" + sEmail + "\';");
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return id;
    }
}
