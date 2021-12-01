package Data;

import java.sql.*;
import java.util.*;
import Business.Login;
/**
 *
 * @author Yassine
 */
public class RegistrationIO {
    
    //Create a Result set 
    private ResultSet res;
    
    public RegistrationIO()
    {
        
    }
    
    public void setUsertInfo(ConnectToDB connect, Login login)
    {
       String query="INSERT INTO UserInfo (firstName, lastName, email, password, active) VALUES "
               + "('"+login.getFirstName()+"', '"+login.getLastName()+"', '"+login.getEmail()+"','"+login.getPassword()+"', FALSE);";
       
       //Execute the query
       try {
           
           connect.getStm().executeUpdate(query);
           
       }catch (SQLException ex)
       {
           System.out.println(ex.getMessage());
       }
        
       
    }
    
    
    
}
